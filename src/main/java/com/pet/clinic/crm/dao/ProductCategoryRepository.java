package com.pet.clinic.crm.dao;

import com.pet.clinic.crm.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Integer> {
}
