package ru.belmih.webstore.model;

import java.util.Set;

public class Role {
	private Long id;
	private String rolename;
    private Set<User> users;

    public Role() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", users=" + users + "]";
	}
	
    
	
}
