package com.example.demo.controllers;

import com.example.demo.dao.CategoriesRepository;
import com.example.demo.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/storesCateogires")
public class CategoriesController {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categories> getAll(){

        return categoriesRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void Insert(@RequestBody Categories categories){

        categoriesRepository.save(categories);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> Delete(@PathVariable Integer id){

        if(categoriesRepository.existsById(id)){
            Categories categories  = categoriesRepository.findById(id).get();
            categoriesRepository.delete(categories);
            return new ResponseEntity<>("Se elimino la categoria",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("la cateogiria no existe", HttpStatus.BAD_REQUEST);
    }
}
