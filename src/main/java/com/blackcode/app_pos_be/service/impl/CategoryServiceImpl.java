package com.blackcode.app_pos_be.service.impl;

import com.blackcode.app_pos_be.dto.CategoryReq;
import com.blackcode.app_pos_be.dto.CategoryRes;
import com.blackcode.app_pos_be.model.Category;
import com.blackcode.app_pos_be.repository.CategoryRepository;
import com.blackcode.app_pos_be.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryRes> getListCategoryAll() {
        List<Category> category = categoryRepository.findAll();
        List<CategoryRes> categoryRes = new ArrayList<>();
        for (Category categoryTemp : category){
            CategoryRes categoryRow = CategoryRes.builder()
                    .category_id(categoryTemp.getCategory_id())
                    .category_name(categoryTemp.getCategory_name())
                    .build();
            categoryRes.add(categoryRow);
        }
        return categoryRes;
    }

    @Override
    public CategoryRes getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        CategoryRes categoryResponse = null;
        if (category.isPresent()) {
            Category category1 = category.get();
            categoryResponse = CategoryRes.builder()
                    .category_id(category1.getCategory_id())
                    .category_name(category1.getCategory_name())
                    .build();
        }
        return categoryResponse;
    }

    @Override
    @Transactional
    public CategoryRes addCategory(CategoryReq categoryReq) {
        Category category = Category.builder()
                .category_id(categoryReq.getCategory_id())
                .category_name(categoryReq.getCategory_name())
                .build();
        Category category1 = categoryRepository.save(category);

        return CategoryRes.builder()
                .category_id(category1.getCategory_id())
                .category_name(category1.getCategory_name())
                .build();
    }
}
