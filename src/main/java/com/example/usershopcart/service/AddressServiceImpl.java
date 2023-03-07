package com.example.usershopcart.service;

import com.example.usershopcart.model.Address;
import com.example.usershopcart.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepo addressRepo;
    @Override
    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }
}
