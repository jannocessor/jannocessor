package org.jannocessor.processor.model;

import java.util.Map;

public interface Configuration {

	String[] getMandatoryValues(String key) throws JannocessorException;

	String getMandatoryValue(String key) throws JannocessorException;

	String[] getOptionalValues(String key, String defaultValue);

	String getOptionalValue(String key, String defaultValue);

	Map<String, String> getAllProperties() throws JannocessorException;

}