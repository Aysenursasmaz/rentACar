package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.entities.Car;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarService{
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);

    List<GetListCarResponse> getAll();
}
