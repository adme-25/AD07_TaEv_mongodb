package eus.birt.adavila.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import eus.birt.adavila.domain.Rurales;

public interface RuralesRepo extends MongoRepository<Rurales, String>{
	
	//Metodo para buscar por municipality, si contiene el nombre pasado
	List<Rurales> findByPropertiesMunicipalityContaining(String municipality);
	
	//Metodo para buscar por documentname, si hay coincidencia e ignorando mayusculas del nombre pasado
	@Query("{ 'properties.documentname' : { $regex: ?0, $options: 'i' } }")
	List<Rurales> findByPropertiesDocumentname(String documentname);
}
