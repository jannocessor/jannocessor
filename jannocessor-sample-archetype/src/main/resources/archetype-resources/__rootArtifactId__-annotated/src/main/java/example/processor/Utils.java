#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.example.processor;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class Utils {

	/**
	 * This is just a workaround for a bug that will be fixed soon.
	 * 
	 * @param canonicalName
	 *            the canonical name of the type
	 * @return a representation of the specified type
	 */
	@SuppressWarnings("serial")
	public static JavaType type(final String canonicalName) {
		return new JavaTypeData() {
			@Override
			public String getCanonicalName() {
				return canonicalName;
			}

			@Override
			public SourceCode getCode() {
				return New.code(JavaType.class);
			}
		};
	}
}
