package org.jannocessor.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class JannocessorClassLoader extends ClassLoader {

	private final List<String> names;
	private final List<String> paths;
	private final String path;

	public JannocessorClassLoader(ClassLoader parent, List<String> names,
			List<String> paths) {
		super(parent);
		Check.argument(names.size() == paths.size(),
				"The names and paths must have same size!");
		this.names = names;
		this.paths = paths;
		this.path = null;
	}

	public JannocessorClassLoader(ClassLoader parent, List<String> names,
			String path) {
		super(parent);
		this.names = names;
		this.path = path;
		this.paths = null;
	}

	public Class<?> loadClass(String classname) throws ClassNotFoundException {
		String path = getPath(classname);
		if (path == null) {
			return super.loadClass(classname);
		}

		String relativePath = getClassRelativePath(classname);
		String fullPath = path + "/" + relativePath;

		try {
			byte[] classData = FileUtils
					.readFileToByteArray(new File(fullPath));
			return defineClass(classname, classData, 0, classData.length);
		} catch (IOException e) {
			throw new ClassNotFoundException("Couldn't read class: " + fullPath);
		}
	}

	private String getClassRelativePath(String classname) {
		return classname.replace('.', '/') + ".class";
	}

	private String getPath(String classname) throws ClassNotFoundException {
		if ((paths != null) && (path == null)) {
			int index = names.indexOf(classname);
			return (index >= 0) ? paths.get(index) : null;
		} else if ((paths == null) && (path != null)) {
			return names.contains(classname) ? path : null;
		} else {
			throw new IllegalStateException("Either path or paths must be set!");
		}
	}

}
