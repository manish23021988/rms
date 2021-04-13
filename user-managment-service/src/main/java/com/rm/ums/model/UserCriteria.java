package com.rm.ums.model;

import java.io.Serializable;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.InstantFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.infobeans.myapp.domain.User} entity. This class is used
 * in {@link com.UserResource.myapp.web.rest.UserResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /replication-logs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
/**
 * @author Manish.Mourya
 *
 */
public class UserCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;
    private StringFilter firstName;
    private StringFilter lastName;
    private StringFilter email;
    private BooleanFilter enabled;
    private BooleanFilter locked;
    private StringFilter type;
    private InstantFilter firstTimeLoggedIn;
    private InstantFilter lastTimeLoggedIn;
    private InstantFilter lastTimePasswordChanged;
    
	public LongFilter getId() {
		return id;
	}
	public void setId(LongFilter id) {
		this.id = id;
	}
	public StringFilter getFirstName() {
		return firstName;
	}
	public void setFirstName(StringFilter firstName) {
		this.firstName = firstName;
	}
	public StringFilter getLastName() {
		return lastName;
	}
	public void setLastName(StringFilter lastName) {
		this.lastName = lastName;
	}
	public StringFilter getEmail() {
		return email;
	}
	public void setEmail(StringFilter email) {
		this.email = email;
	}
	public BooleanFilter getEnabled() {
		return enabled;
	}
	public void setEnabled(BooleanFilter enabled) {
		this.enabled = enabled;
	}
	public BooleanFilter getLocked() {
		return locked;
	}
	public void setLocked(BooleanFilter locked) {
		this.locked = locked;
	}
	public StringFilter getType() {
		return type;
	}
	public void setType(StringFilter type) {
		this.type = type;
	}
	public InstantFilter getFirstTimeLoggedIn() {
		return firstTimeLoggedIn;
	}
	public void setFirstTimeLoggedIn(InstantFilter firstTimeLoggedIn) {
		this.firstTimeLoggedIn = firstTimeLoggedIn;
	}
	public InstantFilter getLastTimeLoggedIn() {
		return lastTimeLoggedIn;
	}
	public void setLastTimeLoggedIn(InstantFilter lastTimeLoggedIn) {
		this.lastTimeLoggedIn = lastTimeLoggedIn;
	}
	public InstantFilter getLastTimePasswordChanged() {
		return lastTimePasswordChanged;
	}
	public void setLastTimePasswordChanged(InstantFilter lastTimePasswordChanged) {
		this.lastTimePasswordChanged = lastTimePasswordChanged;
	}
	
	@Override
	public Criteria copy() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
