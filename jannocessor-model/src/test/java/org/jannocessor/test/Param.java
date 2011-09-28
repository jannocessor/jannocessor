package org.jannocessor.test;

import java.util.List;

import net.sf.twip.AutoTwip;

import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Fields;

public class Param {

	@AutoTwip
	public static FieldModifiers[] fieldModifiers() {
		return new FieldModifiers[] { Fields.PRIVATE, Fields.PRIVATE_FINAL,
				Fields.FINAL_TRANSIENT };
	}

	@AutoTwip
	public static JavaType[] javaTypes() {
		return new JavaType[] { Code.type(List.class, String.class) };
	}

	@AutoTwip
	public static Class<?>[] classes() {
		return new Class<?>[] { String.class, int.class, void.class };
	}

}