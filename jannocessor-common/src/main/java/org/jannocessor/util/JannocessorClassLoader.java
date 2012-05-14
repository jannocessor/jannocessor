package org.jannocessor.util;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

public class JannocessorClassLoader extends ClassLoader {

	private final List<String> names;
	private final ClassLoader parent;
	private final Logger logger;

	public JannocessorClassLoader(ClassLoader parent, List<String> names, Logger logger) {
		super(parent);
		this.parent = parent;
		this.names = names;
		this.logger = logger;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		URL res = parent.getResource(getClassRelativePath(name));
		if (res != null) {
			try {
				String classPath = res.toURI().getPath();
				logger.info("Hot swap: " + classPath);
				byte[] classData = FileUtils.readFileToByteArray(new File(classPath));
				return defineClass(name, classData, 0, classData.length);
			} catch (Exception e) {
				throw new ClassNotFoundException("Couldn't find class: " + name);
			}
		} else {
			return super.findClass(name);
		}

	}

	public Class<?> loadClass(String classname) throws ClassNotFoundException {
		if (names.contains(classname)) {
			try {
				return findClass(classname);
			} catch (ClassNotFoundException e) {
				Class<?> fallbackClass = super.loadClass(classname);
				logger.warn("Couldn't reload class: {}. Fallback: {}", classname, fallbackClass);
				return fallbackClass;
			}
		} else {
			return super.loadClass(classname);
		}
	}

	private String getClassRelativePath(String classname) {
		return classname.replace('.', File.separatorChar) + ".class";
	}

}
