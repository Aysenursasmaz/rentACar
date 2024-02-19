package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.DataResult;
import com.tobeto.pair9.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair9.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair9.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair9.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {

    DataResult<GetByIdBrandResponse> getById(Integer id);

    DataResult<List<GetListBrandResponse>> getAll();

    BaseResponse add(AddBrandRequest request);

    BaseResponse update(UpdateBrandRequest request);

    BaseResponse delete(Integer id);

    boolean isExistBrandById(Integer id);

    DataResult getBrandByName(String name);
}
