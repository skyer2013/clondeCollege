package com.cloudunicollege.entities.po;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
Copyright (C) 2011 by Radu Viorel Cosnita

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/


/**
 * Class used to implement a RBAC user. Currently we hold only the 
 * unique identifier of the user. This unique identifier will not 
 * be even set by the RBAC system but instead by the system that integrates
 * with this RBAC implementation.
 * 
 * @author Radu Viorel Cosnita
 * @version 1.0
 * @since 02.10.2011
 */

@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="Users.loadAll", query="SELECT obj FROM User obj")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="Users.removeFromAllRoles", query="DELETE FROM AssignedUsers WHERE user_id = ?1", resultClass=User.class)
})
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@ManyToMany(mappedBy="assignedUsers")
	private List<Role> roles = new ArrayList<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
		if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
		if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
			return false;
		if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
			return false;
		return !(getRoles() != null ? !getRoles().equals(user.getRoles()) : user.getRoles() != null);

	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
		result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
		result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
		return result;
	}
}