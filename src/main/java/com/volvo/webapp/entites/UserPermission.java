package com.volvo.webapp.entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_permissions database table.
 * 
 */
@Entity
@Table(name="user_permissions")
@NamedQuery(name="UserPermission.findAll", query="SELECT u FROM UserPermission u")
public class UserPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	private Permission permission;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserPermission() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}