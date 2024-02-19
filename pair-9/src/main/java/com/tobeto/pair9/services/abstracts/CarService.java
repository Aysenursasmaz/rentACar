package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.DataResult;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;

import java.util.List;
import java.util.Set;

public interface CarService{

    DataResult<List<GetListCarResponse>> getAll();

    DataResult<GetByIdCarResponse> getById(Integer id);

    BaseResponse add(AddCarRequest request);

    BaseResponse update(UpdateCarRequest request);

    BaseResponse delete(Integer id);

    boolean isExistById(Integer id);

    DataResult getCarByPlate(String plate);

    List<String> getAllCities();

    BaseResponse deleteByPlate(String plate);

}
