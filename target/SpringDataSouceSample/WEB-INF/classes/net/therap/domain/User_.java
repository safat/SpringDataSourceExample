package net.therap.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> id;
	public static volatile SingularAttribute<User, Boolean> isAdmin;

}

