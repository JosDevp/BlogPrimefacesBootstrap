/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion;

import com.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Syndein
 */
@ManagedBean
public class Usuarios {
    
    private String usuario;
    private String contra;
  Conexion con;
  public Usuarios(){
      con=new Conexion();
  }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String acceso() throws Exception
    {
          try{
     
        
         CallableStatement cs = con.conectar().prepareCall("CALL usuarioByPas(?, ?)");
         cs.setString(1, this.usuario);
         cs.setString(2, this.contra);
            
         ResultSet rs = cs.executeQuery();
         
        if (rs.next()){
            this.usuario = rs.getString("usuario");
            this.contra = rs.getString("contrasena");
             FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Bienvenido",  "Usuario: " +this.usuario) );
        return "administracion";
        }else {
               FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Error",  "Usuario no existe ") );
        this.usuario=null;
        this.contra=null;
            
        }
        }catch(Exception e1){
            System.out.println(e1.toString());
            throw e1;
        }
        return null;
    }
}
