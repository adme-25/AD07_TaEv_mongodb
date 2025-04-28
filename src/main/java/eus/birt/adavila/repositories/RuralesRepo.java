package eus.birt.adavila.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.adavila.domain.Rurales;

public interface RuralesRepo extends MongoRepository<Rurales, String>{
	 
}
