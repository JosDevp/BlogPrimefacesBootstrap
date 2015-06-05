/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion;

import com.conexion.Conexion;
import com.modelos.ModelPost;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author joseguru
 */
@ManagedBean
public class Post {
private String titulo;
    private String fecha;
    private String descripcion1;
    private String link;
    private Blob imagen;
    private String descripcion2;
    private UploadedFile file;
    
       Conexion con;
         public Post(){
       con=new Conexion();
     
      //  this.posters = new ArrayList<ModelPost>();
    }
         private String id="id";
       ModelPost e;
          
          public List<ModelPost> getAllImage() throws Exception {
         List<ModelPost> posters  = new ArrayList<ModelPost>();
    
        try {
         CallableStatement cs = con.conectar().prepareCall("CALL getPost()");
        ResultSet rs = cs.executeQuery();
            while (rs.next()) {
             e = new ModelPost();
            e.setId(rs.getInt(id));
            e.setTitulo(rs.getString("titulo"));
            e.setFecha(rs.getString("fecha"));
            e.setLink(rs.getString("link"));
            e.setDescripcion1(rs.getString("descripcion1"));
            e.setDescripcion2(rs.getString("desripcion2"));
            posters.add(e);
               
               
            }
           
        } catch (SQLException e) {
            System.out.println("Exception in getAllImage::" + e.getMessage());
        }
        return posters;
    }
          
        public String toProgramacion(){
            return "programacion";
        }
         
        /*Pendiente de configurar*/
        public void agregar() throws Exception{
               try{
              String sql="INSERT INTO post(id,titulo,fecha,link,descripcion1,imagen,desripcion2)VALUES(?, ?, ?, ?, ?, ?, ?)";
              
              
              PreparedStatement stm=con.conectar().prepareStatement(sql);
              stm.setString(1, this.id);
              stm.setString(2, this.titulo);
              stm.setString(3, this.fecha);
              stm.setString(4, this.link);
              stm.setString(6, this.descripcion1);
              stm.setBinaryStream(6, file.getInputstream());
              stm.setString(7, this.descripcion2);
              stm.executeUpdate();
              stm.close();
         
           FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Guardado Correctamente") );
      
        }catch(Exception e1){
            System.out.println(e1.toString());
              FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("No se guardo") );
        throw e1;
        }
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

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
        
        public String salir(){
            return "index";
        }
        
}
