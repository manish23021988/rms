package com.rm.ums.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rm.ums.entity.User;


/**
 * Spring Data  repository for the Agency entity.
 */
/**
 * @author Manish.Mourya
 *
 */
@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
	
}
