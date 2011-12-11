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
import org.jannocessor.context.RenderRegister;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.util.ValidationUtils;
import org.jannocessor.processor.api.ProcessingContext;
import org.slf4j.Logger;

public class DefaultProcessingContext implements ProcessingContext {

	private Logger logger;

	private Types types;

	private Elements elements;

	private Map<String, String> files;

	private List<String> contents;

	private Problems problems;

	private Filer filer;

	private RenderRegister renderer;

	private JannocessorEngine engine;

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

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
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
		// check model correctness
		ValidationUtils.validate(model);

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", model);

		render(attributes, debug);
	}

	@Override
	public void generateInfo(JavaCodeModel model, boolean debug) {
		JavaCodeModel clone = model.copy();
		clone.getCode().setMacroName("info");

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", clone);

		render(attributes, debug);
	}

	private void render(Map<String, Object> attributes, boolean debug) {
		if (debug) {
			renderer.register(attributes);
		}

		try {
			String content = engine.renderMacro("main", attributes, new String[] {});
			getContents().add(content);
		} catch (JannocessorException e) {
			throw new RuntimeException("Exception occured while rendering", e);
		}
	}

	@Override
	public void generateFile(String fileName, String content) {
		getFiles().put(fileName, content);
	}

}
