package com.tobeto.pair9.services.abstracts;


import com.tobeto.pair9.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair9.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair9.services.dtos.color.responses.GetListColorResponse;
import com.tobeto.pair9.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair9.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair9.services.dtos.model.responses.GetListModelResponse;

import java.util.List;

public interface ModelService {
    List<GetListModelResponse> getAll();
    void add(AddModelRequest request);
    void update(UpdateModelRequest request);
    void delete(int id);
    boolean existsId(int id);

    boolean existsId(int id);

}
