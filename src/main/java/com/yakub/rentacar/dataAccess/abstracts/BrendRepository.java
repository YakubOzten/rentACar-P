package com.yakub.rentacar.dataAccess.abstracts;

import com.yakub.rentacar.entites.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BrendRepository extends JpaRepository<Brand,Integer> {



}
