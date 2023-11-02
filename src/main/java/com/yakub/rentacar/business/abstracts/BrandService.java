package com.yakub.rentacar.business.abstracts;

import com.yakub.rentacar.business.requests.CreateBrandRequest;
import com.yakub.rentacar.business.requests.UpdateBrandRequest;
import com.yakub.rentacar.business.responses.GetAllBrandsResponse;
import com.yakub.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
