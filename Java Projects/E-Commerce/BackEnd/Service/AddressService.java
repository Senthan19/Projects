package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository ar;
	
	@Autowired
	private UserRepository ur;
	
	public Address addAddress(Address a) {
		Users user = ur.findById(a.getUser().getId()).orElse(null);
		Address temp = ar.findByUserId(a.getUser().getId());
		if(temp == null) {
			a.setUser(user);
			return ar.save(a);
		}
		return temp;
	}
	
	public Address upadateAddress(Address a) {
		Address temp = ar.findById(a.getId()).orElse(null);
		if(temp.getAddress() == null) {
			return ar.save(a);
		}
		if(!a.getAddress().equals(temp.getAddress())) {
			temp.setAddress(a.getAddress());
			return ar.save(a);
		}
		return null;
	}
}
