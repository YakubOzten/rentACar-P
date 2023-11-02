package com.yakub.rentacar.webApi.controllers;

import com.yakub.rentacar.business.abstracts.BrandService;
import com.yakub.rentacar.business.requests.CreateBrandRequest;
import com.yakub.rentacar.business.requests.UpdateBrandRequest;
import com.yakub.rentacar.business.responses.GetAllBrandsResponse;
import com.yakub.rentacar.business.responses.GetByIdBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")

public class BrendsController {
    private BrandService brandService;

    public BrendsController(BrandService brandService){
        this.brandService=brandService;
    }

@GetMapping()
    public List<GetAllBrandsResponse>getAll(){
        return  brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable  int id){
        return  brandService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public  void  add(@RequestBody() CreateBrandRequest createBrandRequest){
       this.brandService.add(createBrandRequest);
    }
    @PutMapping()
    public void update(@RequestBody()  UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
