package com.tatharo.absenceapp.persistence.config;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityManagerProvider {
	public static final Logger LOGGER = LoggerFactory.getLogger(EntityManagerProvider.class);
	private static DataSource ds;
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf==null)
			EntityManagerProvider.initEntityManagerFactory();
		return emf;
	}
	private static void initEntityManagerFactory() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

			Map<String, DataSource> properties = new HashMap<String, DataSource>();
			properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
			emf = Persistence.createEntityManagerFactory("AbsenceApp", properties);
		} catch (NamingException e) {
			LOGGER.error("NamingException during contextlookup EntityManagerFactory", e);
		}
	}
}