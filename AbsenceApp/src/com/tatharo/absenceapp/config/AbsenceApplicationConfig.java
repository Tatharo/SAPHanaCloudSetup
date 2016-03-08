package com.tatharo.absenceapp.config;

import java.util.*;

import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import com.tatharo.absenceapp.service.rest.PersonService;
  

public class AbsenceApplicationConfig extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(PersonService.class);
        return classes;
    }
 
    @Override
    public Set<Object> getSingletons() {
        MOXyJsonProvider moxyJsonProvider = new MOXyJsonProvider();
        moxyJsonProvider.setWrapperAsArrayName(false);
        moxyJsonProvider.setAttributePrefix("@");
        moxyJsonProvider.setFormattedOutput(true);
        moxyJsonProvider.setIncludeRoot(false);
        moxyJsonProvider.setMarshalEmptyCollections(false);
        moxyJsonProvider.setValueWrapper("$");
        moxyJsonProvider.setNamespaceSeparator(':');
 
        HashSet<Object> singletons = new HashSet<Object>();
        singletons.add(moxyJsonProvider);
        return singletons;
    }
    
}