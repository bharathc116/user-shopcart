package com.example.usershopcart.repo;

import com.example.usershopcart.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
