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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.adavila.domain.Rurales;
import eus.birt.adavila.repositories.RuralesRepo;

@RestController
@RequestMapping("/api")
public class RuralesController {
	
	@Autowired
	RuralesRepo ruralesRepo;
	
	//Metodo para listar todos los alojamientos rurales
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
	
	//Metodo para listar todos los municipios 
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
	
	//Metodo para buscar alojamientos por municipio
	@GetMapping("/municipios/{municipality}")
	public ResponseEntity<List<Rurales>> ruralesMunicipio(@PathVariable("municipality") String municipality) {
	    try {
	        List<Rurales> ruralesProvincia = ruralesRepo.findByPropertiesMunicipalityContaining(municipality);
	        return new ResponseEntity<>(ruralesProvincia, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	//Metodo para mostrar ciertos datos de un alojamiento seleccionado por el nombre
	@GetMapping("/datos/{documentname}")
	public String datosAlojamiento(@PathVariable() String documentname) {
		try {
			List<Rurales> rurales = ruralesRepo.findByPropertiesDocumentname(documentname);
			
			 if (rurales.isEmpty()) {
		            return "No existe ningún alojamiento con ese nombre en la base de datos.";
		        }

		        // Usamos StringBuilder para construir la respuesta en caso de que haya coincidencias en el nombre
		        StringBuilder data = new StringBuilder();
		        for (Rurales rural : rurales) {
		            data.append("Nombre: ").append(rural.getProperties().getDocumentname()).append("\n")
		                .append("Localidad: ").append(rural.getProperties().getLocality()).append("\n")
		                .append("Municipio: ").append(rural.getProperties().getMunicipality()).append("\n")
		                .append("Dirección: ").append(rural.getProperties().getAddress()).append("\n")
		                .append("Teléfono: ").append(rural.getProperties().getPhone()).append("\n")
		                .append("Web: ").append(rural.getProperties().getWeb()).append("\n")
		                .append("--------------------------------------\n"); // Separador entre alojamientos
		        }

		        return data.toString();
	    }
		catch (Exception e)
		{
	        e.printStackTrace();
	        return "Ha ocurrido un error al recuperar los datos";
		}
	}
}
