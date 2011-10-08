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

package org.jannocessor.service.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.processor.model.Rule;
import org.jannocessor.service.api.FileService;
import org.jannocessor.service.api.PatternService;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RulesGeneratorImpl implements RulesGenerator, Settings {

	private Logger logger = LoggerFactory.getLogger("RULES");

	private final TemplateRenderer renderer;

	private final FileService fileService;

	private final PatternService patternService;

	@Inject
	public RulesGeneratorImpl(TemplateRenderer renderer,
			FileService fileService, PatternService patternService) {
		this.renderer = renderer;
		this.fileService = fileService;
		this.patternService = patternService;
	}

	@Override
	public String generateRules(String[] ruleNames) throws JannocessorException {
		Map<String, Object> attributes = new HashMap<String, Object>();

		List<Rule> rules = new ArrayList<Rule>();

		for (String ruleName : ruleNames) {
			rules.add(loadRule(ruleName));
		}

		attributes.put("rules", rules);

		String rulesText = renderer.renderFromFile(RULES_TEMPLATE_NAME,
				attributes);

		logger.debug("Generated rules:\n{}", rulesText);
		return rulesText;
	}

	private Rule loadRule(String name) {
		String filename = "patterns/" + name + ".match";

		String pattern = fileService.readClasspathFile(filename);
		logger.debug("Loading pattern:\n{}", pattern);

		List<String> args = patternService.extractPatternVariables(pattern);
		Rule rule = new Rule(name, pattern, args);

		return rule;
	}

}
