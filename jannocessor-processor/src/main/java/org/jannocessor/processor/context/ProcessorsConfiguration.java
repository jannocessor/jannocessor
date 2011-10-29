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

package org.jannocessor.processor.context;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jannocessor.JannocessorException;
import org.jannocessor.annotation.Annotated;
import org.jannocessor.annotation.Types;
import org.jannocessor.model.JavaElement;
import org.jannocessor.util.Check;
import org.jannocessor.util.Jannocessor;

public class ProcessorsConfiguration {

	private final Class<?> processorsConfig;

	private List<ProcessingConfiguration> configuration = new ArrayList<ProcessingConfiguration>();

	public ProcessorsConfiguration(Class<?> processorsConfig)
			throws JannocessorException {
		this.processorsConfig = processorsConfig;
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() throws JannocessorException {
		try {
			Object settings = processorsConfig.newInstance();
			Method[] methods = processorsConfig.getMethods();
			for (Method method : methods) {
				Annotated annotated = method.getAnnotation(Annotated.class);
				if (annotated != null) {
					Object result;
					try {
						result = method.invoke(settings);
					} catch (IllegalArgumentException e) {
						throw Jannocessor.error("Couldn't invoke method: "
								+ method, e);
					} catch (InvocationTargetException e) {
						throw Jannocessor.error("Couldn't invoke method: "
								+ method, e);
					}

					Check.state(result instanceof CodeProcessor,
							"The method '%s' must implement CodeProcessor!",
							method.getName());

					CodeProcessor<? extends JavaElement> processor = (CodeProcessor<? extends JavaElement>) result;
					Class<? extends Annotation>[] annotations = annotated
							.value();

					Types types = method.getAnnotation(Types.class);

					configuration.add(new ProcessingConfiguration(annotations,
							types.value(), processor));
				}
			}
		} catch (InstantiationException e) {
			throw Jannocessor.error("Couldn't instantiate class: "
					+ processorsConfig, e);
		} catch (IllegalAccessException e) {
			throw Jannocessor.error("Couldn't instantiate class: "
					+ processorsConfig);
		}
	}

	public Set<String> getSupportedAnnotations() throws JannocessorException {
		Set<String> supportedAnnotations = new HashSet<String>();

		for (ProcessingConfiguration entry : configuration) {
			for (Class<? extends Annotation> annotation : entry
					.getAnnotations()) {
				supportedAnnotations.add(annotation.getCanonicalName());
			}
		}

		return supportedAnnotations;
	}

	public List<ProcessingConfiguration> getConfiguration() {
		return configuration;
	}

}
