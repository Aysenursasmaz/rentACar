package com.tobeto.pair9.services.dtos.car.responses;

import com.tobeto.pair9.services.dtos.color.responses.GetListColorResponse;
import com.tobeto.pair9.services.dtos.model.responses.GetListModelResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCarPlateResponse {

    private Integer id;

    private Integer  kilometer;

    private String plate;

    private int modelYear;

    private double dailyPrice;

    private double depositPrice;

    private short minFindeksRate;

    private String transmissionType;

    private String fuelType;

    private boolean airbag;

    private int drivingLicenseAge;

    private int minCustomerAge;

    private int seatCapacity;

    private String imagePath;

    private String location;

    private GetListModelResponse model;

    private GetListColorResponse color;

}
