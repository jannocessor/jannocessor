package org.jannocessor.util;

import java.util.Map;

public interface FlexyMap extends Map<Object, Object> {

	FlexyMap sub(Object... keys);

	FlexyMap add(Object key, Object value);

	FlexyMap set(Object key, Object value);

}
