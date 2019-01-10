package br.com.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listavip.model.Guest;
import br.com.listavip.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository repo;
	
	public Iterable<Guest> getAll(){
		
		return repo.findAll();
	}
	
	public void save(Guest guest) {
		
		repo.save(guest);
	}

}
