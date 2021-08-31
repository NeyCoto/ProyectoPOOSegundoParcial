/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Usuario {
    protected int id;
    protected String nombres, apellidos, correo_elec, organizacion, clave;


    public Usuario(int id, String nombres, String apellidos, String correo_elec, String organizacion, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo_elec = correo_elec;
        this.organizacion = organizacion;
        this.clave = clave;
    }
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_elec() {
        return correo_elec;
    }

    public void setCorreo_elec(String correo_elec) {
        this.correo_elec = correo_elec;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return (this.id != other.id && !Objects.equals(this.correo_elec, other.correo_elec));
    }
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_elec=" + correo_elec + ", organizacion=" + organizacion + ", clave=" + clave + '}';
    }
    
    
    // ASK IN CONSOLE AND CREATE A NEW USER, WHICH IS INCLUDED IN A USER TXT FILE AND SAVE his/her CLAVE IN A HASH CODE CLAVE FILE
    public static void nextUsuario(String nomfile, String nomfile_hash, Scanner sc)
    {
        String correo_elec;
        do{
            System.out.println("Por favor ingrese su correo electrónico: ");
            correo_elec = sc.nextLine();
              
        } while(Util.correoInFile(correo_elec, nomfile) || !Util.validacionCorreo(correo_elec));// repetir mientras que el correo este en el archivo o el correo NO este bien escrito
        System.out.println("Por favor ingrese su clave: "); 
        String clave = sc.nextLine();
        System.out.println("Por favor ingrese sus nombres: "); 
        String nombres = sc.nextLine();       
        System.out.println("Por favor ingrese sus apellidos: ");
        String apellidos = sc.nextLine();  
        System.out.println("Por favor ingrese su organización: "); 
        String organizacion = sc.nextLine();       
               
       
        int id = Util.nextID(nomfile);
        Usuario user = new Usuario(id, nombres, apellidos, correo_elec, organizacion,clave);
        user.saveFile(nomfile);
        
        ArrayList<Usuario> usuarios = Usuario.readFile_usuario(nomfile);
        Util.crearArchivoHash(usuarios, nomfile_hash); // save claves in hash code
        
    }
    
    
    /*
    // SAVE NEW USER IN A TXT FILE
    public void saveFile(String nomfile) throws IOException{
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+this.correo_elec+"|"+this.organizacion+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/
    
    // SAVE NEW USER IN A BINARY FILE
    public void saveFile(String nomfile){
        try(FileOutputStream fous = new FileOutputStream(nomfile);ObjectOutputStream out = new ObjectOutputStream(fous);){
            Usuario u = new Usuario(this.id, this.nombres, this.apellidos, this.correo_elec, this.organizacion, this.clave);
            out.writeObject(u);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    
    
    
    /*
    // READ USER BINARY FILE AND RETURN LIST OF USERS
    public static ArrayList<Usuario> readFile_usuario(String nomfile){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                // linea = "1|20201010|eduardo|cruz"
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Usuario user = new Usuario(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                usuarios.add(user);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return usuarios;       
    }*/
    
    // READ USER BINARY FILE AND RETURN LIST OF USERS
    public static ArrayList<Usuario> readFile_usuario(String nomfile){
        try(FileInputStream fin = new FileInputStream(nomfile);ObjectInputStream oin = new ObjectInputStream(fin);) {
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>)oin.readObject();
            return usuarios;
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    // RETURN USER IF ID MATCHES
    public static Usuario searchByID_usuario(ArrayList<Usuario> usuarios, int id)
    {
        for(Usuario user : usuarios)
        {
            if(user.id == id)
                return user;
        }
        return null;
    }

    
}
