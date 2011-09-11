package org.jannocessor.collection.filter.impl;

import org.apache.commons.collections.Predicate;
import org.jannocessor.collection.filter.api.Criteria;

@SuppressWarnings("rawtypes")
public class PredicateAdapter implements Predicate {

	private final Criteria<Object> criteria;

	@SuppressWarnings("unchecked")
	public PredicateAdapter(Criteria criteria) {
		this.criteria = criteria;
	}

	public boolean evaluate(Object object) {
		return criteria.satisfies(object);
	}

}
