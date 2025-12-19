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
		// getStocksByPriceGreaterThan("GOOGL", new BigDecimal(1250));
		getlowestXPricedStock(3);
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
	private void findStocksBymonthAndYearAndCompany(){
		List<Stock> records = stockRepository.findByDateBetweenAndCode(LocalDate.of(2019, 8, 31), LocalDate.of(2019, 9, 30), "FB");
		for(Stock record : records){
			System.out.println(record.getId() + ", " 
			+record.getCode() + ", "
			+record.getDate() + ", " 
			+record.getOpen() + ", "
			+record.getClose() + ", "
			+record.getVolume() + ". ");
		}
	}
	public void getStocksByPriceGreaterThan(String code, BigDecimal price){
		List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan(code, price);
		for(Stock record : stocks){
			System.out.println(record.getId() + ", " 
			+record.getCode() + ", "
			+record.getDate() + ", " 
			+record.getOpen() + ", "
			+record.getClose() + ", "
			+record.getVolume() + ". ");
		}
	}
	public void getTopXVolumedStock(int x){
		List<Stock> stocks = stockRepository.findAllByOrderByVolumeDesc();

		for(int i = 0; i < x; i++){
			Stock record = stocks.get(i);
			System.out.println(record.getId() + ", " 
			+record.getCode() + ", "
			+record.getDate() + ", " 
			+record.getOpen() + ", "
			+record.getClose() + ", "
			+record.getVolume() + ". ");
		}
	}
	public void getlowestXPricedStock(int x){
		List<Stock> stocks = stockRepository.findAllByOrderByCloseAsc();

		for(int i = 0; i < x; i++){
			Stock record = stocks.get(i);
			System.out.println(record.getId() + ", " 
			+record.getCode() + ", "
			+record.getDate() + ", " 
			+record.getOpen() + ", "
			+record.getClose() + ", "
			+record.getVolume() + ". ");
		}
	}
}
