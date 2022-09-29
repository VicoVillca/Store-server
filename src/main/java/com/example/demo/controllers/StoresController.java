package com.example.demo.controllers;

import com.example.demo.dao.StoresRepository;
import com.example.demo.models.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping(value="api/stores")
public class StoresController {
    @Autowired
    private StoresRepository storesRepository;

    @RequestMapping( method = RequestMethod.GET)
    public List<Stores> getAll(){
        return storesRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Stores> Insert(@RequestBody Stores stores){
        System.out.println("Hollaaaa");

        if(stores.getName()!=null){
            storesRepository.save(stores);
            System.out.println(stores);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "foo");
            return new ResponseEntity<>(stores, headers, HttpStatus.OK);
        }else{
            System.out.println(stores);
            //"La teinda no tiene nombre!"
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> Delete(@PathVariable Integer id){


        if(storesRepository.existsById(id)){
            Stores stores = storesRepository.findById(id).get();
            storesRepository.delete(stores);
            if(!storesRepository.existsById(stores.getId())){
                return new ResponseEntity<>("Error al borrar la tienda!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Tienda Borrada!!", HttpStatus.OK);
        }
        return new ResponseEntity<>("La tienda no existe", HttpStatus.BAD_REQUEST);

    }
}
