package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //con QUERY NATIVO
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findCategoria(int idCategoria); // Esta forma es para utilizar un QUERY SQL NATIVO

    //con QUERY METHODS
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); // aplicar el nombre con CAMEL CASE
    //con operador opcional
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
