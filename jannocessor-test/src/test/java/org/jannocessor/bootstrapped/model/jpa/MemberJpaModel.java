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
