package com.blackcode.app_pos_be.controller;

import com.blackcode.app_pos_be.dto.CategoryReq;
import com.blackcode.app_pos_be.dto.CategoryRes;
import com.blackcode.app_pos_be.model.Category;
import com.blackcode.app_pos_be.service.CategoryService;
import com.blackcode.app_pos_be.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseStatus<List<CategoryRes>>> getAllCategory(){
        List<CategoryRes> categoryResponses = categoryService.getListCategoryAll();
        ResponseStatus<List<CategoryRes>> categoryRtn = new ResponseStatus<>();
        if(categoryResponses == null){
            categoryRtn.setStatus(false);
            categoryRtn.setStatusCode(HttpStatus.NOT_FOUND);
            categoryRtn.setData(null);
            categoryRtn.getMessage().add("gagal di tampilkan");
            return ResponseEntity.ok(categoryRtn);

        }
        categoryRtn.setStatus(true);
        categoryRtn.setStatusCode(HttpStatus.OK);
        categoryRtn.setData(categoryResponses);
        categoryRtn.getMessage().add("Berhasil di tampilkan");
        return ResponseEntity.ok(categoryRtn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStatus<CategoryRes>> getCategoryById(@PathVariable("id") Long id){
        CategoryRes categoryResponse = categoryService.getCategoryById(id);
        ResponseStatus<CategoryRes> responseResponseStatus = new ResponseStatus<>();
        if(categoryResponse == null){
            responseResponseStatus.setStatus(false);
            responseResponseStatus.setStatusCode(HttpStatus.NOT_FOUND);
            responseResponseStatus.setData(null);
            responseResponseStatus.getMessage().add("gagal di tampilkan");
            return ResponseEntity.ok(responseResponseStatus);
        }
        responseResponseStatus.setStatus(true);
        responseResponseStatus.setStatusCode(HttpStatus.OK);
        responseResponseStatus.setData(categoryResponse);
        responseResponseStatus.getMessage().add("Berhasil di tampilkan");
        return ResponseEntity.ok(responseResponseStatus);
    }

    @PostMapping
    public ResponseEntity<ResponseStatus<CategoryRes>> addCategory(@RequestBody CategoryReq categoryReq){
        CategoryRes categoryRes = categoryService.addCategory(categoryReq);
        ResponseStatus<CategoryRes> resResponseStatus = new ResponseStatus<>();
        resResponseStatus.setStatus(true);
        resResponseStatus.setStatusCode(HttpStatus.OK);
        resResponseStatus.getMessage().add("Data Berhasil Di tambahkan");
        resResponseStatus.setData(categoryRes);
        return ResponseEntity.ok(resResponseStatus);
    }
}
