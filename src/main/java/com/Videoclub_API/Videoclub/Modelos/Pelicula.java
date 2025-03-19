/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Videoclub_API.Videoclub.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author totit
 */

//La etiqueta @Entity indicara que esta clase es una entidad a mapear
@Entity
//La etiqueta @Table le dara el nombre a la tabla en la que se mapearan los datos
@Table(name="peliculas")
public class Pelicula {
     //Debe coincidir con los nombres de la base de datos si tenemos la tabla creada previamente, si no hemos creado la tabla se crearan automaticamente con 
    //Los nombres que pongamos en name
    
    //Sobre el id indicamos la etiqueta @Id para indicar que sera el indentificador, y debera de ser de tipo long
    //Además la etiqueta generatvalue indicara que sera un atributo que se creara automaticamente con cada registro nuevo
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    //Los demas campos llevaran la etiqueta @Column para indicarles el nombre del campo de la tabla a la que pertenecen
    @Column(name="titulo")
    private String title;
    @Column(name="Nombre_Director")
    private String nameDirector;
    @Column(name="Anio")
    private int year; 
 
     //Con la etiqueta @CreationTimestamp se indicara automaticamente la hora en la que se crea un registro en nuestra BBDD
    //Como lo gestiona automaticamente hibernate, no hara falta que las dejemos en el constructor
    @CreationTimestamp
    @Column(name="fechaCreacionRegistro")
    private LocalDate createdDate;
   
     //Con la etiqueta @UpdateTimestamp se indicara automaticamente la hora en la que se actualiza un registro en nuestra BBDD
    //Como lo gestiona automaticamente hibernate, no hara falta que las dejemos en el constructor
    @UpdateTimestamp
    @Column(name="fechaModificacionRegistro")
    private LocalDate updateDate;
    
    public Pelicula() {
    }

    public Pelicula(String title, String nameDirector, int year) {
        this.title = title;
        this.nameDirector = nameDirector;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
  
    
    
    
}
