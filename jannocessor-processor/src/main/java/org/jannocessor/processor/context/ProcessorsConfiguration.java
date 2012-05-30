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

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jannocessor.JannocessorException;
import org.jannocessor.model.JavaElement;
import org.jannocessor.processor.annotation.Annotated;
import org.jannocessor.processor.annotation.Types;
import org.jannocessor.processor.api.CodeProcessor;
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
							"The result of method '%s' must implement CodeProcessor!",
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
