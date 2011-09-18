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

package org.jannocessor.bootstrap.processor;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.domain.type.JavaInterface;
import org.jannocessor.model.CodeProcessor;
import org.jannocessor.model.ProcessingContext;

public class DomainProxyGenerator implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
		JavaInterface model = (JavaInterface) params.get("model");
		context.getLogger().debug("Processing annotated domain model: {}",
				model);
		DomainProxyGeneratorHelper helper = new DomainProxyGeneratorHelper();

		context.getLogger().debug("Generating model proxies...");
		generateModelProxies(context, model, helper);

		context.getLogger().debug("Generating model base beans...");
		generateBaseModel(context, model, helper);

		// context.getLogger().debug("Generating model beans...");
		// generateModelBeans(context, model, helper);
	}

	private void generateModelProxies(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		String packageName = "org.jannocessor.proxy";
		String className = model.getName().appendPart("Proxy").getText();

		attributes.put("model", model);
		attributes.put("packageName", packageName);
		attributes.put("className", className);
		attributes.put("helper", helper);

		context.generateFile(packageName, className + ".java", "model_proxy",
				attributes);
	}

	private void generateBaseModel(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes2 = new HashMap<String, Object>();
		String packageName2 = "org.jannocessor.data";
		String className2 = model.getName().appendPart("Data").getText();

		attributes2.put("model", model);
		attributes2.put("packageName", packageName2);
		attributes2.put("className", className2);
		attributes2.put("helper", helper);

		context.generateFile(packageName2, className2 + ".java", "model_data",
				attributes2);
	}

	@SuppressWarnings("unused")
	private void generateModelBeans(ProcessingContext context,
			JavaInterface model, DomainProxyGeneratorHelper helper) {
		Map<String, Object> attributes3 = new HashMap<String, Object>();
		String packageName3 = "org.jannocessor.model.bean";
		String className3 = model.getName().appendPart("Bean").getText();

		attributes3.put("model", model);
		attributes3.put("packageName", packageName3);
		attributes3.put("className", className3);
		attributes3.put("helper", helper);

		context.generateFile(packageName3, className3 + ".java", "model_bean",
				attributes3);
	}

}
