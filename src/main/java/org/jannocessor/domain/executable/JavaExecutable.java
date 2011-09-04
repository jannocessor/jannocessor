/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.domain.executable;

import java.util.List;

import org.jannocessor.bootstrap.annotation.DomainModel;
import org.jannocessor.domain.JavaElement;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Text;
import org.jannocessor.domain.type.JavaTypeParameter;
import org.jannocessor.domain.variable.JavaParameter;

@DomainModel
public interface JavaExecutable extends JavaElement {

	List<JavaTypeParameter> getTypeParameters();

	JavaElementType getReturnType();

	List<JavaParameter> getParameters();

	Boolean getVarArgs();

	List<JavaElementType> getThrownTypes();

	Text getDefault();

}
