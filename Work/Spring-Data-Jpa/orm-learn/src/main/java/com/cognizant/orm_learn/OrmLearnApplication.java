package com.cognizant.orm_learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;

import java.math.BigDecimal;
import java.text.Bidi;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner{
	
	@Autowired
	private CountryService countryService;

	@Autowired
	private StockRepository stockRepository;
	
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
		findStockwithpriceGreaterThan(1250*1d);
	}
	private void testAddCountry(){
		Country country = new Country();
		country.setCode("YY");
		country.setName("New Country");
		countryService.addCountry(country);
	}
	private void testUpdateCountry() throws Exception{
		countryService.updateCountryName("IN", "Hindustan");
	}
	private void testDeleteCountry() throws Exception{
		countryService.deleteCountry("IN");
	}
	private void testSearchCountry() throws Exception{
		List<Country> countries = countryService.findCountryByText("ou");
		for(Country country : countries){
			System.out.println(country.getCode() + " : " + country.getName());
		}
	}
	private void testSearchCountrySorted() throws Exception{
		List<Country> countries = countryService.findCountryByTextSorted("ou");
		for(Country country : countries){
			System.out.println(country.getCode() + " : " + country.getName());
		}
	}
	private void stockOfCompanyByDate(){
		List<Stock> records = stockRepository.findByDateBetweenAndCodeContaining(LocalDate.parse("2019-09-01"),LocalDate.parse("2019-09-30"),"FB");
		if(records.isEmpty()) System.out.println("No records found");
		else{
			for(Stock stock : records){
				System.out.println(stock.getCode() + ", " + stock.getDate() + ", " + stock.getOpen() + ", "+stock.getClose() + ", "+stock.getVolume());
			}
		}
	}

	private void findStockwithpriceGreaterThan(double price){
		List<Stock> stocks = stockRepository.findStockByPriceGreaterThan(new BigDecimal(price));
		if(stocks.isEmpty()) System.out.println("No records found");
		else{
			for(Stock stock : stocks){
				System.out.println(stock.getCode() + ", " + stock.getDate() + ", " + stock.getOpen() + ", "+stock.getClose() + ", "+stock.getVolume());
			}
		}
	}
}
