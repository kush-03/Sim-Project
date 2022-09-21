package com.infy.sim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.CustomerIdentity;
@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,String> {
	@Query("select cust from CustomerIdentity cust where cust.emailAddress= ?1")
	public Optional<CustomerIdentity> getCustomerByEmail(String email);
	
	@Query("select cust from CustomerIdentity cust where cust.firstName= ?1 and cust.lastName=?2")
	public Optional<CustomerIdentity> getCustomerByFirstNameAndLastName(String firstName,String lastName);
}
