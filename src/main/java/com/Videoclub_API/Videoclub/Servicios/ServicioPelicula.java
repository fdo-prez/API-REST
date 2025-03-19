/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videoclub_API.Videoclub.Servicios;

import com.Videoclub_API.Videoclub.Modelos.Pelicula;
import com.Videoclub_API.Videoclub.Repositorios.RepositorioPelicula;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author totit
 */

//Con la anotacion @Service indicamos que esta clase sera un servicio
//Las clases servicios tienen la lógica del programa
@Service
public class ServicioPelicula {
    /*Para implementar la logica bien debemos de tener un objeto
    de la clase repositorio, ya que esta al extender de jpa
    implementa los metodos que necesitamos*/
    RepositorioPelicula rp;

    //De esta manera inyectamos el repositorio en la clase
    public ServicioPelicula(RepositorioPelicula rp) {
        this.rp = rp;
    }
    
    //Este metodo nos devolvera una lista con todas las peliculas
    public List<Pelicula> findAll(){
    return rp.findAll();
    }
  
    //Este metodo nos devolvera una Pelicula por su id
    public Pelicula findById(long id){
    return rp.findById(id).get();
    //Usamos el get para que nos devuelva un objeto sin error
    }
    
    //Este metodo guardara una pelicula en la base de datos
    public Pelicula saveFilm(Pelicula pelicula){
       return rp.save(pelicula);
    }
    
    //Este metodo eliminara una pelicula en la base de datos
    public void deleteFilm(long id){
    rp.deleteById(id);
    }
    
    //Este metodo modificara una pelicula existente en la BBDD de la base de datos
    
    public Pelicula updateFilm(Pelicula pelicula){
        Optional<Pelicula> peliculaBBDD= rp.findById(pelicula.getId());
        Pelicula peliculaModificada=peliculaBBDD.get();
        peliculaModificada.setNameDirector(pelicula.getNameDirector());
        peliculaModificada.setTitle(pelicula.getTitle());
        peliculaModificada.setYear(pelicula.getYear());
        return rp.save(peliculaModificada);

    }

}
  