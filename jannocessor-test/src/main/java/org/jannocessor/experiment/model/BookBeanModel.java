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

package org.jannocessor.experiment.model;

import java.awt.List;

import javax.annotation.Generated;
import javax.lang.model.type.TypeKind;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 105, b = "xx", cls = List.class, kind = TypeKind.DECLARED, ann = @Generated("gen"))
@BeanModel
@SuppressWarnings("unused")
public class BookBeanModel {

	@AnotherAnnotation
	private transient String title;

	@AnotherAnnotation(b = "field")
	public static PersonBeanModel author;

}
