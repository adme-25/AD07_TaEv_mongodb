package eus.birt.adavila.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.adavila.domain.Rurales;
import eus.birt.adavila.repositories.RuralesRepo;

@RestController
@RequestMapping("/api")
public class RuralesController {
	
	@Autowired
	RuralesRepo ruralesRepo;
	
	@GetMapping("/rurales")
	public ResponseEntity<List<Rurales>> index(){
		try {
			List<Rurales> rurales = ruralesRepo.findAll();
			return new ResponseEntity<List<Rurales>>(rurales, HttpStatus.OK);
		}
		catch (Exception e){
			 e.printStackTrace();
		     return new ResponseEntity<List<Rurales>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/municipios")
	public ResponseEntity<List<String>> getAllMunicipalities() {
	    try {
	        List<Rurales> rurales = ruralesRepo.findAll();
	        Set<String> uniqueTerritories = new HashSet<>();
	        for (Rurales rural : rurales) {
	            uniqueTerritories.add(rural.getProperties().getMunicipality());
	        }
	        List<String> sortedMunicipalities = new ArrayList<>(uniqueTerritories);
	        Collections.sort(sortedMunicipalities);
	        return new ResponseEntity<List<String>>(sortedMunicipalities, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/municipios/{municipality}")
	public ResponseEntity<List<Rurales>> ruralesPorMunicipio(@PathVariable("municipality") String municipality) {
	    try {
	        List<Rurales> rurales = ruralesRepo.findAll();
	        List<Rurales> ruralesProvincia = new ArrayList<Rurales>();
	        	        
	        for (Rurales rural : rurales) {
	        	if (rural.getProperties().getMunicipality().equals(municipality) || rural.getProperties().getMunicipality().contains(municipality)) {
	        		ruralesProvincia.add(rural);
	        	}
	        }
	        return new ResponseEntity<List<Rurales>>(ruralesProvincia, HttpStatus.OK);
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Rurales>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping("/imprimir/{documentname}")
	public String datosRural(@PathVariable("documentname") String documentname) {
		List<Rurales> rural = ruralesRepo.findAll();
		Rurales temp = new Rurales();
        for (Rurales rurales : rural) {
        	if (rurales.getProperties().getDocumentname().equals(documentname)) {
        		temp = rurales;
        	}
        }
        String data = "Nombre: " + documentname + "\n" +
        		"Localidad: " + temp.getProperties().locality + "\n" +
        		"Municipio: " + temp.getProperties().municipality + "\n" +
        		"Direccion: " + temp.getProperties().address + "\n" +
        		"Telefono: " + temp.getProperties().phone + "\n" +
        		"Web: " + temp.getProperties().web ;
        		
        return data;
	}
}
