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

package org.jannocessor.model.util;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.api.event.CollectionOperationListener;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.ParentedElement;
import org.jannocessor.model.type.JavaType;

public class ModelUtils {

	public static <T> PowerList<T> parentedList(PowerList<T> results,
			final JavaElement parent) {
		results.addCollectionOperationListener(new CollectionOperationListener<T>() {
			@Override
			public void itemAdded(CollectionOperationEvent<T> event) {
				if (event.getElement() instanceof ParentedElement) {
					System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					ParentedElement element = (ParentedElement) event
							.getElement();
					element.setParent(parent);
					System.out.println(element + "-" + parent);
				} else {
					System.out.println("XXXXX: "
							+ event.getElement().getClass());
				}
			}

			@Override
			public void itemRemoved(CollectionOperationEvent<T> event) {
				if (event.getElement() instanceof ParentedElement) {
					System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
					ParentedElement element = (ParentedElement) event
							.getElement();
					element.setParent(null);
					System.out.println(element + "-" + parent);
				}
			}
		});
		return results;
	}

	public static <T> PowerList<T> parentedList(PowerList<T> list, JavaType type) {
		return list;
	}

}
