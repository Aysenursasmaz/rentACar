package com.tobeto.pair9.services.rules;

import com.tobeto.pair9.core.utilities.exceptions.ModelBusinessException;
import com.tobeto.pair9.core.utilities.results.Messages;
import com.tobeto.pair9.entities.concretes.Model;
import com.tobeto.pair9.repositories.ModelRepository;
import com.tobeto.pair9.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private final ModelRepository modelRepository;
    private final UserService userService;

    public void isExistModelByName(String name){
        if(modelRepository.existsByName(name)){
            throw new ModelBusinessException(Messages.modelAlreadySaved);
        }
    }
    public void isExistModelById(Integer id){
        if(!modelRepository.existsById(id)){
            throw new ModelBusinessException(Messages.modelIsNotFound);
        }
    }

    public void isExistBrandById(Integer id){
        if(!modelRepository.existsBrandById(id)){
            throw new ModelBusinessException(Messages.brandIsNotFound);
        }
    }

    public Model getModelByName(String name){
        Optional<Model> model = modelRepository.getModelByName(name);
        if(model.isPresent()){
            return model.get();
        }
        throw new ModelBusinessException(Messages.modelIsNotFound);
    }
}
