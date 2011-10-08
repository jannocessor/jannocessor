/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.collection.filter.impl;

import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;

public class CriteriaImpl<E> implements Criteria<E> {

	private final Condition<E> condition;

	public CriteriaImpl(Condition<E> condition) {
		this.condition = condition;
	}

	public boolean satisfies(E object) {
		return condition.satisfies(object);
	}

	public static <T> Criteria<T> create(Condition<T> condition) {
		return new CriteriaImpl<T>(condition);
	}

	public Criteria<E> not() {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return !condition.satisfies(object);
			}
		});
	}

	public Criteria<E> and(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object)
						&& criteria.satisfies(object);
			}
		});
	}

	public Criteria<E> or(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object)
						|| criteria.satisfies(object);
			}
		});
	}

	public Criteria<E> xor(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object) ^ criteria.satisfies(object);
			}
		});
	}
}
