package com.blackcode.app_pos_be.service;

import com.blackcode.app_pos_be.dto.CategoryReq;
import com.blackcode.app_pos_be.dto.CategoryRes;

import java.util.List;

public interface CategoryService {
    List<CategoryRes> getListCategoryAll();

    CategoryRes getCategoryById(Long id);

    CategoryRes addCategory(CategoryReq categoryReq);
}
