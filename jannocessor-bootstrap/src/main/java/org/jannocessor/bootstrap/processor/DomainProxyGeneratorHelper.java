package org.jannocessor.bootstrap.processor;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.domain.executable.JavaMethod;

public class DomainProxyGeneratorHelper {

    public String fieldName(JavaMethod method) {
	String name = method.getName().getText();
	if (name.startsWith("get")) {
	    return StringUtils.uncapitalize(name.substring(3));
	} else {
	    return "_" + name;
	}
    }

}
