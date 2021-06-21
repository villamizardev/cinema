package com.cinema.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	private String description;
	@ManyToMany
	@JoinTable(name = "permissionRole", joinColumns = @JoinColumn(name = "idRole"), inverseJoinColumns = @JoinColumn(name = "idPermission"))
	@JsonIgnore
	private Set<Permission> permissionRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Permission> getPermissionRole() {
		return permissionRole;
	}

	public void setPermissionRole(Set<Permission> permissionRole) {
		this.permissionRole = permissionRole;
	}

}
