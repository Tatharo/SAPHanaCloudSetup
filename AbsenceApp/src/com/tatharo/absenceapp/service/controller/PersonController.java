package com.tatharo.absenceapp.service.controller;

import com.tatharo.absenceapp.persistence.model.Person;
import com.tatharo.absenceapp.persistence.repository.PersonRepository;
import com.tatharo.absenceapp.service.dto.PersonDTO;

public class PersonController {
	private PersonRepository personRepository = new PersonRepository();

	public void savePerson(PersonDTO personDTO) {
		Person person = new Person(personDTO.getName(), personDTO.getEmail());
		personRepository.savePerson(person);
	}
}
