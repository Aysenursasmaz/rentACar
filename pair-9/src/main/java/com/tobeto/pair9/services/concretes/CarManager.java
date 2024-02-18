package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.core.utilities.results.*;
import com.tobeto.pair9.entities.concretes.Car;
import com.tobeto.pair9.repositories.CarRepository;
import com.tobeto.pair9.services.abstracts.CarService;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetCarPlateResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.pair9.services.rules.CarBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;

    @Override
    public DataResult<List<GetListCarResponse>> getAll() {
        List<Car> cars = carRepository.findAll();
        var result = cars.stream()
                .map(car->this.modelMapperService.forResponse()
                        .map(car, GetListCarResponse.class)).collect(Collectors.toList());
        return new DataResult(result);
    }

    @Override
    public DataResult<GetByIdCarResponse> getById(Integer id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        var result = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
        return new DataResult(result);
    }

    @Override
    public BaseResponse add(AddCarRequest request) {
        carBusinessRules.isExistCarByPlate(request.getPlate());
        carBusinessRules.isExistModelById(request.getModelId());
        carBusinessRules.isExistColorById(request.getColorId());
        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        car.setId(null);
        car.setDepositPrice(carBusinessRules.calculateDepositPrice(request.getDailyPrice()));
        this.carRepository.save(car);
        return new BaseResponse(true, Messages.carAdded);
    }

    @Override
    public BaseResponse update(UpdateCarRequest request) {
        carBusinessRules.isExistModelById(request.getModelId());
        carBusinessRules.isExistColorById(request.getColorId());
        double depositPrice =  carBusinessRules.calculateDepositPrice(request.getDailyPrice());
        Car car = this.modelMapperService.forRequest()
                .map(request,Car.class);
        car.setDepositPrice(depositPrice);
        this.carRepository.save(car);
        return new BaseResponse(true,Messages.carUpdated);
    }

    public boolean isExistById(Integer id) {
        return carRepository.existsById(id);
    }

    @Override
    public BaseResponse delete(Integer id) {
        this.carRepository.deleteById(id);
        return new BaseResponse(true,Messages.carDeleted);
    }

    public DataResult getCarByPlate(String plate){
        Car car = carBusinessRules.getCarByPlate(plate);
        var result =  this.modelMapperService.forResponse().map(car, GetCarPlateResponse.class);
        return new DataResult<>(result);
    }

    @Override
    public List<String> getAllCities() {
        List<Car> cars = carRepository.findAll();
        Set<String> city = cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toSet());

        List<String> citiesList = new ArrayList<>(city);

        return citiesList;
    }

    @Override
    public BaseResponse deleteByPlate(String plate) {
        Car car =  carBusinessRules.getCarByPlate(plate);
        carRepository.delete(car);
        return new DataResult<>(true,Messages.carDeleted);
    }
}
