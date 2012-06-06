/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.processor.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.JannocessorException;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.util.ValidationUtils;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.ProcessingContext;
import org.jannocessor.processor.api.RenderRegister;
import org.slf4j.Logger;

public class DefaultProcessingContext implements ProcessingContext {

	private Logger logger;

	private Types types;

	private Elements elements;

	private Map<String, GeneratedFile> files;

	private List<GeneratedCode> contents;

	private Problems problems;

	private Filer filer;

	private RenderRegister renderer;

	private JannocessorEngine engine;
	
	private String outputPath;

	@Override
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Elements getElements() {
		return elements;
	}

	public void setElements(Elements elements) {
		this.elements = elements;
	}

	public Problems getProblems() {
		return problems;
	}

	public void setProblems(Problems problems) {
		this.problems = problems;
	}

	public void setFiler(Filer filer) {
		this.filer = filer;
	}

	public Filer getFiler() {
		return filer;
	}

	public Map<String, GeneratedFile> getFiles() {
		return files;
	}

	public void setFiles(Map<String, GeneratedFile> files) {
		this.files = files;
	}

	public List<GeneratedCode> getContents() {
		return contents;
	}

	public void setContents(List<GeneratedCode> contents) {
		this.contents = contents;
	}

	public void setEngine(JannocessorEngine engine) {
		this.engine = engine;
	}

	public JannocessorEngine getEngine() {
		return engine;
	}

	public RenderRegister getRenderer() {
		return renderer;
	}

	public void setRenderer(RenderRegister renderer) {
		this.renderer = renderer;
	}

	@Override
	public void generateCode(AbstractJavaStructure model, boolean debug) {
		generateCode(model, null, debug);
	}

	@Override
	public void generateCode(AbstractJavaStructure model, CodeMerger merger, boolean debug) {
		// check model correctness
		ValidationUtils.validate(model);

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", model);

		render(attributes, merger, debug);
	}

	@Override
	public void generateInfo(JavaCodeModel model, boolean debug) {
		JavaCodeModel clone = model.copy();
		clone.getCode().setMacroName("info");

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", clone);

		render(attributes, null, debug);
	}

	private void render(Map<String, Object> attributes, CodeMerger merger, boolean debug) {
		if (debug) {
			renderer.register(attributes, merger);
		}

		try {
			String content = engine.renderMacro("main", attributes, new String[] {});
			getContents().add(new GeneratedCode(content, merger));
		} catch (JannocessorException e) {
			throw new RuntimeException("Exception occured while rendering", e);
		}
	}

	@Override
	public void generateFile(String filename, String content) {
		generateFile(filename, content, null);
	}

	@Override
	public void generateFile(String filename, String content, CodeMerger merger) {
		getFiles().put(filename, new GeneratedFile(filename, content, merger));
	}

	@Override
	public String getProfile() {
		try {
			return engine.getProfile();
		} catch (JannocessorException e) {
			logger.error("Cannot retrieve the profile!", e);
			return null;
		}
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	
}
