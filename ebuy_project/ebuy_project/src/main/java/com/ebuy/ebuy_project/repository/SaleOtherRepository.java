package com.ebuy.ebuy_project.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebuy.ebuy_project.model.SaleOther;

@Repository
@Qualifier("saleOtherRepo")
public interface SaleOtherRepository extends JpaRepository<SaleOther, Integer>{

}
