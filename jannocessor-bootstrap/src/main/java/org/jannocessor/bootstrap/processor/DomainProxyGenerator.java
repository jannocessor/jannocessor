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
