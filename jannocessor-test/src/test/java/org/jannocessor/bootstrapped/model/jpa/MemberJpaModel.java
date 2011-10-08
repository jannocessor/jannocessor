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

package org.jannocessor.bootstrapped.model.jpa;

import java.util.List;

import org.jannocessor.bootstrapped.annotation.Constraints;
import org.jannocessor.bootstrapped.annotation.jpa.Persist;
import org.jannocessor.bootstrapped.annotation.jpa.PrimaryKey;

// @JpaModel
public class MemberJpaModel {

	@PrimaryKey
	Integer id;

	String name;

	String firstName;

	String lastName;

	String email;

	@Constraints(nullable = false)
	String username;

	@Constraints(nullable = false)
	@Persist(column = "pass")
	String password;

	@Persist(persist = false)
	Boolean isAdmin;

	Boolean isManager;

	@Persist(persist = false)
	List<Integer> roleIds;

}
