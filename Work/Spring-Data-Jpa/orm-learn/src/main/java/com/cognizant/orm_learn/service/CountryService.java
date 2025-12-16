package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    
    @Transactional
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
        Optional<Country> result = countryRepository.findById(countryCode);
        if(!result.isPresent()){
            throw new CountryNotFoundException(
                "Country not found with code " + countryCode
            );
        }
        Country country = result.get();
        return country;
    }
    @Transactional
    public void addCountry(Country country){
        countryRepository.save(country);
    }
    @Transactional
    public void updateCountryName(String countryCode, String name) throws CountryNotFoundException{
        Optional<Country> country = countryRepository.findById(countryCode);
        if(!country.isPresent()) throw new CountryNotFoundException("Country with the code "+ countryCode +"does not exist.");
        Country c = country.get();
        c.setCo_name(name);
        countryRepository.save(c);
    }
    @Transactional
    public void deleteCountry(String countrycode) throws CountryNotFoundException{
        Optional<Country> country = countryRepository.findById(countrycode);
        if(!country.isPresent()) throw new CountryNotFoundException("Country with the code "+ countrycode +"does not exist.");
        Country c = country.get();
        countryRepository.delete(c);
    }
}
