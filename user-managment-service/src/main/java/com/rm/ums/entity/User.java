package com.rm.ums.entity;	

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User extends AbstractAuditingEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9162579960210219326L;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password")
	@Transient
	private String password;
	
	@Column(name = "access_key")
	private String accessKey;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "locked")
	private Boolean locked;
	
	@Column(name = "first_time_logged_in")
	private Instant firstTimeLoggedIn;
	
	@Column(name = "last_time_logged_in")
	private Instant lastTimeLoggedIn;
	
	@Column(name = "last_time_password_changed")
	private Instant lastTimePasswordChanged;
	
	@Column(name = "type")
	private String type;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Instant getFirstTimeLoggedIn() {
		return firstTimeLoggedIn;
	}

	public void setFirstTimeLoggedIn(Instant firstTimeLoggedIn) {
		this.firstTimeLoggedIn = firstTimeLoggedIn;
	}

	public Instant getLastTimeLoggedIn() {
		return lastTimeLoggedIn;
	}

	public void setLastTimeLoggedIn(Instant lastTimeLoggedIn) {
		this.lastTimeLoggedIn = lastTimeLoggedIn;
	}

	public Instant getLastTimePasswordChanged() {
		return lastTimePasswordChanged;
	}

	public void setLastTimePasswordChanged(Instant lastTimePasswordChanged) {
		this.lastTimePasswordChanged = lastTimePasswordChanged;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
