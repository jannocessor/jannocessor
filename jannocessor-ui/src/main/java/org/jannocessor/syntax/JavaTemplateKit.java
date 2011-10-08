package org.jannocessor.syntax;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import jsyntaxpane.DefaultSyntaxKit;
import jsyntaxpane.Lexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaTemplateKit extends DefaultSyntaxKit {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger("UI");

	public JavaTemplateKit() {
		super(new JavaTemplateLexer());
		setConfiguration();
	}

	private void setConfiguration() {
		try {
			Properties config = new Properties();
			InputStream stream = getClass().getClassLoader()
					.getResourceAsStream("syntax.properties");
			config.load(new InputStreamReader(stream));
			stream.close();
			setConfig(config);
		} catch (Exception e) {
			logger.warn("Cannot initialize syntax editor", e);
		}
	}

	public JavaTemplateKit(Lexer lexer) {
		super(lexer);
	}

}
