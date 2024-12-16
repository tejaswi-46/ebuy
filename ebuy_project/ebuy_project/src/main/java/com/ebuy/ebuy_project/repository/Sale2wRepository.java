package com.ebuy.ebuy_project.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebuy.ebuy_project.model.Sale2w;

@Repository
@Qualifier("sale2wRepo")
public interface Sale2wRepository extends JpaRepository<Sale2w, Integer>{

}
