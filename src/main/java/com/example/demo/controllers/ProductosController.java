package com.example.demo.controllers;

import com.example.demo.dao.ProductosRepository;
import com.example.demo.models.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/products")
public class ProductosController {
    @Autowired
    private ProductosRepository productosRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Productos> getAll(){

        return productosRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Productos Insert(@RequestBody Productos productos){
        System.out.println(productos);
        productosRepository.save(productos);
        return productos;
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> Delete(@PathVariable Integer id){
        System.out.println("numeros  = "+id);
        if(productosRepository.existsById(id)){
            Productos productos  = productosRepository.findById(id).get();
            productosRepository.delete(productos);
            return new ResponseEntity<>("Se elimino el producto", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("el producto no existe", HttpStatus.BAD_REQUEST);
    }
}
