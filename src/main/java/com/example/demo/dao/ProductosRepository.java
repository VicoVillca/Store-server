package com.example.demo.dao;

import com.example.demo.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos,Integer> {
}
