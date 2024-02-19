package com.tobeto.pair9.services.rules;

import com.tobeto.pair9.core.utilities.exceptions.BrandBusinessException;
import com.tobeto.pair9.core.utilities.results.Messages;
import com.tobeto.pair9.entities.concretes.Brand;
import com.tobeto.pair9.repositories.BrandRepository;
import com.tobeto.pair9.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;


    public void isExistBrandByName(String name){
        if(brandRepository.existsByName(name)){
           throw new BrandBusinessException(Messages.brandAlreadySaved);
        }
    }

    public void isExistBrandById(Integer id){
        if(!brandRepository.existsById(id)){
            throw new BrandBusinessException(Messages.brandIsNotFound);
        }
    }

    public Brand getBrandByName(String name){
        Optional<Brand> brand = brandRepository.getBrandByName(name);
        if(brand.isPresent()){
            return brand.get();
        }
        throw new BrandBusinessException(Messages.brandIsNotFound);
    }
}
