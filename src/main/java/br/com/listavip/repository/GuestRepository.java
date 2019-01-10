package br.com.listavip.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.listavip.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long>{

}
