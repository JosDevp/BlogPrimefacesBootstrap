/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelos;

import java.sql.Blob;

/**
 *
 * @author joseguru
 */
public class ModelPost {
    private int id;
    private String titulo;
    private String fecha;
    private String descripcion1;
    private String link;
    private Blob imagen;
    private String descripcion2;

    public ModelPost(int id,String titulo, String fecha,String descripcion1,String link,Blob imagen,String descripcion2){
        this.id=id;
        this.titulo=titulo;
        this.fecha=fecha;
        this.descripcion1=descripcion1;
        this.link=link;
        this.imagen=imagen;
        this.descripcion2=descripcion2;
    }

    public ModelPost(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }
    
    
}
