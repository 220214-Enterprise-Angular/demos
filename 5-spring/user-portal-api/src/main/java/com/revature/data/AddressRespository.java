package com.revature.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Address;

@Repository // stereotype annotaion indicating that this is a component responsible for persisting Address objects
public interface AddressRespository extends JpaRepository<Address, Integer>{
	
	Set<Address> findByOwnersUsername(String username);

}
