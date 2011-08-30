/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.service.api.JannocessorException;
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

	public void generateClass(JavaClass clazz) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("clazz", clazz);
		String className = clazz.getName().getText();

		try {
			String template = engine.getTemplatesPath() + "/javabean.vm";
			String content = engine.renderFromFile(template, attributes);

			getFiles().file("domain", className, "java", content);
		} catch (JannocessorException e) {
			throw new RuntimeException("Cannot generate class " + className, e);
		}
	}

}
