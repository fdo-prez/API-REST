/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videoclub_API.Videoclub.Controladores;


import com.Videoclub_API.Videoclub.Modelos.Pelicula;
import com.Videoclub_API.Videoclub.Servicios.ServicioPelicula;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author totit
 */

//Esta anotacion indica que esta clase es un controlador
@RestController
//Esta anotacion indica la ruta a la que responden las peticiones
//No debe de coincidir con nada, ni con el nombre de la BBDD, ni con la tabla
//pero una buena practica es que sea la entidad con la que estamos trabajando en plural
//es decir, si la entidad es autores, que se indique /peliculas
@RequestMapping("/peliculas")
public class ControladorPelicula {
    /* Para completar el controlador, necesitamos crear una instancia del
    repositorio e inyectarla en la clase para poder usar sus metodos
    */
    ServicioPelicula sp;

    public ControladorPelicula(ServicioPelicula sp) {
        this.sp = sp;
    }

  
//Con este metodo haremos una solicitud para guardar un registro 
//La etiqueta @RequestBody servira para traducir el objeto JSON a java
@PostMapping
public ResponseEntity<Pelicula> saveFilm(@RequestBody Pelicula pelicula){

return new ResponseEntity(sp.saveFilm(pelicula),HttpStatus.CREATED );

//Usamos un ResponseEntity para mayor personalizacion. En este caso, el mensaje 
//que nos devuelve es 201, que es de registro creado
}
   
//Con este metodo haremos una solicitud de datos al servidor
@GetMapping
public ResponseEntity<List>findAllFilm(){
return ResponseEntity.ok(sp.findAll());

}
//Con este metodo tambien haremos una solicitud de datos al servidor
//En concreto por id
@GetMapping("/{id}")
public ResponseEntity<Pelicula>findById(@PathVariable long id){
return ResponseEntity.ok(sp.findById(id));
}

//Con este metodo haremos una solicitud para eliminar un registro del servidor
@DeleteMapping("/{id}")
public void deleteFilm(@PathVariable long id){
   sp.deleteFilm(id);
}

//Con este metodo podremos modificar registros de la bbdd o servidor
//El mensaje que nos devolvera personalizado nos enviara un codigo continue

@PutMapping
public ResponseEntity<Pelicula> updateFilm(@RequestBody Pelicula pelicula){

return ResponseEntity.ok(sp.updateFilm(pelicula));
}


}
