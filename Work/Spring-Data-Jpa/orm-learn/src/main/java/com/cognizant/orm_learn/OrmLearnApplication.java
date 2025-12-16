package com.cognizant.orm_learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner{
	
	@Autowired
	private CountryService countryService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		LOGGER.info("Test: Adding new country.");
		// Country country = countryService.findCountryByCode("IN");
		// // List<Country> countries = countryService.getAllCountries();
		// // for(Country country : countries){
		// 	System.out.println("country "+ country.getCo_code() + " - "+ country.getCo_name());
		// // }
		// testAddCountry();
		// testUpdateCountry();
		testDeleteCountry();
	}
	private void testAddCountry(){
		Country country = new Country();
		country.setCo_code("YY");
		country.setCo_name("New Country");
		countryService.addCountry(country);
	}
	private void testUpdateCountry() throws Exception{
		countryService.updateCountryName("IN", "Hindustan");
	}
	private void testDeleteCountry() throws Exception{
		countryService.deleteCountry("IN");
	}
}
