package org.jannocessor.processor.api;

import java.util.List;
import java.util.Map;

import org.jannocessor.JannocessorException;

public interface RenderRegister {

	void register(Map<String, Object> attributes, CodeMerger merger);

	List<RenderData> getRenderings();

	void refresh() throws JannocessorException;

}