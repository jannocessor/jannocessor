package org.jannocessor.collection.filter.impl;

import org.apache.commons.collections.Predicate;
import org.jannocessor.collection.filter.api.Condition;

@SuppressWarnings("rawtypes")
public class ConditionPredicateAdapter implements Predicate {

	private final Condition condition;

	public ConditionPredicateAdapter(Condition condition) {
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	public boolean evaluate(Object object) {
		return condition.satisfies(object);
	}

}
