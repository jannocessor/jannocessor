package example.mapper;

import java.util.List;
import java.util.Set;

public class AbstractMapper {

	protected <From, To> List<To> convert(List<From> src, Class<To> destClass) {
		return null; // NOT IMPLEMENTED
	}

	protected <From, To> Set<To> convert(Set<From> src, Class<To> destClass) {
		return null; // NOT IMPLEMENTED
	}

	protected <From, To> To convert(From src, Class<To> destClass) {
		return null; // NOT IMPLEMENTED
	}
}
