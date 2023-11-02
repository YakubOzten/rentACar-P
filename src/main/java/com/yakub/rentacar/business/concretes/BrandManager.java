package com.yakub.rentacar.business.concretes;

import com.yakub.rentacar.business.abstracts.BrandService;
import com.yakub.rentacar.business.requests.CreateBrandRequest;
import com.yakub.rentacar.business.requests.UpdateBrandRequest;
import com.yakub.rentacar.business.responses.GetAllBrandsResponse;
import com.yakub.rentacar.business.responses.GetByIdBrandResponse;
import com.yakub.rentacar.core.utilities.mappers.ModelMapperService;
import com.yakub.rentacar.dataAccess.abstracts.BrendRepository;
import com.yakub.rentacar.entites.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
 class BrandManager implements BrandService {
    private BrendRepository brendRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
    //mapping
        List<Brand>brands=brendRepository.findAll();
     /*
        List<GetAllBrandsResponse>brandsResponse=new ArrayList  <GetAllBrandsResponse>();

        for (Brand brand :brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }*/   // yukardakı döngü yerine bunu map operasyonlarını yazdık.
        List<GetAllBrandsResponse>brandsResponse=
                brands.stream().map(brand -> this.modelMapperService.forResponse().
                        map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse ;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
       Brand brand = this.brendRepository.findById(id).orElseThrow();
       GetByIdBrandResponse response=this.modelMapperService.forResponse()
               .map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brendRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand=this.modelMapperService .forRequest().map(updateBrandRequest,Brand.class);
        this.brendRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brendRepository.deleteById(id);

    }
}
