/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.processor.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.slf4j.Logger;

public class ProcessingContext {

	private Logger logger;

	private Types types;

	private Elements elements;

	private Map<String, String> files;

	private List<String> contents;

	private Problems problems;

	private Processors processors;

	private Filer filer;

	private String projectPath;

	private RenderRegister renderer;

	private JannocessorEngine engine;

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

	public Processors getProcessors() {
		return processors;
	}

	public void setProcessors(Processors processors) {
		this.processors = processors;
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

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getProjectPath() {
		return projectPath;
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

	public void generateCode(AbstractJavaStructure model, boolean debug) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", model);

		render(attributes, debug);
	}

	public void render(Map<String, Object> attributes, boolean debug) {
		if (debug) {
			renderer.register(attributes);
		}

		try {
			String content = engine.renderMacro("main", attributes,
					new String[] {});
			getContents().add(content);
		} catch (JannocessorException e) {
			throw new RuntimeException("Exception occured while rendering", e);
		}
	}

	public void generateFile(String fileName, String content) {
		getFiles().put(fileName, content);
	}

}
