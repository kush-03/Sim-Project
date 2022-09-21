package com.infy.sim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.sim.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{

}
