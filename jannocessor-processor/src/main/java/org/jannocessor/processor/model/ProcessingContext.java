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
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.model.structure.JavaClass;
import org.slf4j.Logger;

public class ProcessingContext {

	private Logger logger;

	private Types types;

	private Elements elements;

	private Files files;

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

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
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

	public void generateClass(JavaClass clazz) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("self", clazz);

		String packageName = clazz.getPackageName().getText();
		String fileName = clazz.getName().getText() + ".java";

		generateFile(packageName, fileName, "default/class", attributes);
	}

	public void generateFile(String packageName, String fileName,
			String templateName, Map<String, Object> attributes) {
		renderer.register(templateName, attributes);

		try {
			String template = engine.getTemplatesPath() + "/" + templateName
					+ ".vm";
			String content = engine.renderFromFile(template, attributes);

			getFiles().file(packageName, fileName, content);
		} catch (JannocessorException e) {
			throw new RuntimeException("Cannot generate file: " + fileName, e);
		}
	}

	public void generateFile(String packageName, String fileName, String content) {
		getFiles().file(packageName, fileName, content);
	}

}
