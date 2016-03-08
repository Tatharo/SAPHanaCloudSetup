package com.tatharo.absenceapp.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tatharo.absenceapp.service.controller.PersonController;
import com.tatharo.absenceapp.service.dto.PersonDTO;

@Path("/persons")
public class PersonService {
	public static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	
	private PersonController personController = new PersonController();
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonDTO> getAllPersons(){
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		personDTOs.add(new PersonDTO(1,"Henk Pieters", "henk@email.com"));
		personController.savePerson(personDTOs.get(0));
		return personDTOs;
	}
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(PersonDTO personDTO){
		personController.savePerson(personDTO);
	}
	
}
