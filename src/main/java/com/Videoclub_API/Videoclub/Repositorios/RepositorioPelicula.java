/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Videoclub_API.Videoclub.Repositorios;

import com.Videoclub_API.Videoclub.Modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author totit
 */
//Indicamos al programa que esta clase es un repositorio con @Repository
@Repository
public interface RepositorioPelicula extends JpaRepository<Pelicula,Long> {

     //Con el repositorio, podemos tener una organizacion en capas de nuestro proyecto. 
    //Con el repositorio manejaremos todos los datos
    //Debera de extender de JpaRepository, ya que nos dará múltiples funcionalidades para
    //acceder a la base de datos
    /*Pelicula hace referencia a a la entidad con la que estamos trabajando, es decir, la 
    que hemos mapeado, mientras que Long es el tipo de dato que es su ID*/
    
}
