package com.rm.ums.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rm.ums.dao.impl.UserRepository;
// for static metamodels
import com.rm.ums.entity.User;
import com.rm.ums.entity.User_;
import com.rm.ums.model.UserCriteria;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link User} entities in the database.
 * The main input is a {@link UserCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link User} or a {@link Page} of {@link User} which fulfills the criteria.
 */
/**
 * @author Manish.Mourya
 *
 */
@Service
@Transactional(readOnly = true)
public class UserQueryService extends QueryService<User> {

    private final Logger log = LoggerFactory.getLogger(UserQueryService.class);

    private final UserRepository userRepository;

    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Return a {@link List} of {@link User} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<User> findByCriteria(UserCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return userRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link User} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<User> findByCriteria(UserCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<User> specification = createSpecification(criteria);
        return userRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UserCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return userRepository.count(specification);
    }

    /**
     * Function to convert ConsumerCriteria to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */    
    private Specification<User> createSpecification(UserCriteria criteria) {
         Specification<User> specification = Specification.where(null);
         if (criteria != null) {
        	if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), User_.id));
			}
        	if (criteria.getFirstName() != null) {
				specification = specification.and(buildStringSpecification(criteria.getFirstName(), User_.firstName));
			}
        	if (criteria.getLastName() != null) {
				specification = specification.and(buildStringSpecification(criteria.getLastName(), User_.lastName));
			}
        	if (criteria.getEmail() != null) {
				specification = specification.and(buildStringSpecification(criteria.getEmail(), User_.email));
			}
        	if (criteria.getEnabled() != null) {
				specification = specification.and(buildSpecification(criteria.getEnabled(), User_.enabled));
			}
        	if (criteria.getLocked() != null) {
				specification = specification.and(buildSpecification(criteria.getLocked(), User_.locked));
			}
        	if (criteria.getType() != null) {
				specification = specification.and(buildStringSpecification(criteria.getType(), User_.type));
			}
        	if (criteria.getFirstTimeLoggedIn() != null) {
				specification = specification.and(buildSpecification(criteria.getFirstTimeLoggedIn(), User_.firstTimeLoggedIn));
			}
        	if (criteria.getLastTimeLoggedIn() != null) {
				specification = specification.and(buildSpecification(criteria.getLastTimeLoggedIn(), User_.lastTimeLoggedIn));
			}
        	if (criteria.getLastTimePasswordChanged() != null) {
				specification = specification.and(buildSpecification(criteria.getLastTimePasswordChanged(), User_.lastTimePasswordChanged));
			}
         }
       return specification;
    }
}
