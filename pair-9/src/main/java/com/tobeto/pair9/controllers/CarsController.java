package com.tobeto.pair9.controllers;

import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.DataResult;
import com.tobeto.pair9.services.abstracts.CarService;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarsController {

    private final CarService carService;


    @GetMapping("/getAll")
    public DataResult<List<GetListCarResponse>> getAll(){
        return carService.getAll();
    }


    @GetMapping("/getById/{id}")
    public DataResult<GetByIdCarResponse> getById(@PathVariable Integer id){
        return carService.getById(id);
    }

    @GetMapping("/getLocation")
    public List<String> getAllLocation(){
        return carService.getAllCities();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BaseResponse add(@RequestBody @Valid AddCarRequest request){
        return carService.add(request);
    }


    @PutMapping("/update")
    public BaseResponse update(@RequestBody @Valid UpdateCarRequest request){
        return this.carService.update(request);
    }


    @DeleteMapping("{id}")
    public BaseResponse delete(@PathVariable Integer id){
        return carService.delete(id);
    }

    @DeleteMapping("/deleteByPlate")
    public BaseResponse deleteByPlate(@RequestParam String plate) {
        return carService.deleteByPlate(plate);
    }

    @GetMapping("/getByPlate")
    public DataResult getCarByPlate(@RequestParam ("plate") String plate){
        return carService.getCarByPlate(plate);
    }
}
