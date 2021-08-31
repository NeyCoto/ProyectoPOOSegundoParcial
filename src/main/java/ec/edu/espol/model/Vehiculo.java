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
public class Vehiculo {
    protected int id;
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipo_motor;
    protected int year;
    protected double recorrido;
    protected String color;
    protected String tipo_combustible;
    protected int vidrios;
    protected String transmicion;
    protected String traccion;
    protected double precio;
    protected ArrayList<Oferta> ofertas;
    protected Vendedor vendedor; ////
    protected int id_vendedor;  ////

    //constructor de carros, no tiene traccion
    public Vehiculo(int id, String placa, String marca, String modelo, String tipo_motor, int year, double recorrido, String color, String tipo_combustible, int vidrios, String transmicion, double precio, int id_vendedor) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.year = year;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmicion = transmicion;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
        this.id_vendedor = id_vendedor;
        
    }
   
    //constructor de motos, no tiene vidrios, transmicion y traccion
    public Vehiculo(int id, String placa, String marca, String modelo, String tipo_motor, int year, double recorrido, String color, String tipo_combustible, double precio, int id_vendedor) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.year = year;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
        this.id_vendedor = id_vendedor;
    }
    
    //construcctor de camionetas tiene todo
    public Vehiculo(int id, String placa, String marca, String modelo, String tipo_motor, int year, double recorrido, String color, String tipo_combustible, int vidrios, String transmicion, String traccion, double precio, int id_vendedor) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_motor = tipo_motor;
        this.year = year;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmicion = transmicion;
        this.traccion = traccion;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
        this.id_vendedor = id_vendedor;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public int getVidrios() {
        return vidrios;
    }

    public void setVidrios(int vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
    
    
    
    
    //equals -- revisar comparacion vidrios transmicion y traccion
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
        Vehiculo other = (Vehiculo) obj;
        return (this.id != other.id && !Objects.equals(this.placa, other.placa));
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipo_motor=" + tipo_motor + ", year=" + year + ", recorrido=" + recorrido + ", color=" + color + ", tipo_combustible=" + tipo_combustible + ", vidrios=" + vidrios + ", transmicion=" + transmicion + ", traccion=" + traccion + ", precio=" + precio  + '}';
    }
    
    // ASK USER IN CONSOLE FOR A VEHICULO , CREATE NEW TYPE OF VEHICULO, SAVE IT IN A VEHICULO TXT
    public static void nextVehiculo(String nomfile, int id_vendedor, Scanner sc)
    {
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nomfile);
        String placa;
        do{
           System.out.println("Por favor ingrese el numero de placa: ");
           placa= sc.nextLine();
        }while(Util.validacionPlaca(placa, vehiculos)); // VERIFY PLACA 
               
        //validarplaca
        System.out.println("Por favor ingrese la marca: ");
        String marca = sc.nextLine();
        System.out.println("Por favor ingrese el modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Por favor ingrese el tipo de motor: ");
        String tipo_motor = sc.nextLine();
        
        String year_s;
        do{
            System.out.println("Por favor ingrese el año: ");
            year_s = sc.nextLine();
         }while(!Util.isInt(year_s)); // CHECK IF YEAR IS NOT LESS THAN 0
        int year = Integer.parseInt(year_s);
        
        String recorrido_s;
        do{
            System.out.println("Por favor ingrese el recorrido: ");
            recorrido_s = sc.nextLine();
         }while(!Util.isNumeric(recorrido_s)); // CHECK IF RECORRIDO IS NOT LESS THAN 0
        double recorrido = Double.parseDouble(recorrido_s);
        
        
        System.out.println("Por favor ingrese el color: ");
        String color = sc.nextLine();
        System.out.println("Por favor ingrese el tipo de combustible: ");
        String tipo_combustible = sc.nextLine();
        
        String precio_s;
        do{
            System.out.println("Por favor ingrese el precio: ");
            precio_s =  sc.nextLine();
        }while(!Util.isNumeric(precio_s)); // CHECK IF PRECIO IS NOT LESS THAN 0
        double precio = Double.parseDouble(precio_s);
        
        
        int id = Util.nextID(nomfile);
        //int id_vendedor = vendedor.getId();
        String opcion_s;
        
        do{            
            System.out.println("Por favor digite:"
                            + "\n1. Si el vehículo es un carro."
                            + "\n2. Si el vehículo es una moto."
                            + "\n3. Si el vehículo es una camioneta."
                            + "\nUna vez escrita la opción, pulse la tecla Enter");
            opcion_s = sc.nextLine();                                                
        }while(!Util.isInt(opcion_s) || !(Integer.parseInt(opcion_s) <= 3 && Integer.parseInt(opcion_s) > 0)); //      
        int opcion = Integer.parseInt(opcion_s);
        
        int vidrios;
        String transmicion;            
        String traccion;
        Vehiculo vehicle;
        if (opcion != 2){
            String vidrios_s;
            do{
                System.out.println("Por favor ingrese el numero de vidrios: ");
                vidrios_s = sc.nextLine(); 
            }while(!Util.isInt(vidrios_s)); // CHECK IF VIDREOS IS NOT LESS THAN 0
            vidrios = Integer.parseInt(vidrios_s);
            
            System.out.println("Por favor ingrese la transmicion: ");
            transmicion = sc.nextLine(); 
            //carros
            vehicle = new Vehiculo(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, vidrios, transmicion, precio,id_vendedor);
            if(opcion == 3){
                    System.out.println("Por favor ingrese la traccion: ");
                    traccion =  sc.nextLine(); 
                
                //camionetas
                vehicle = new Vehiculo(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, vidrios, transmicion, traccion, precio,id_vendedor);
            }
        }
        else    //motos
            vehicle = new Vehiculo(id, placa, marca, modelo, tipo_motor, year, recorrido, color, tipo_combustible, precio,id_vendedor);
        
        
        vehicle.saveFile(nomfile);  
    }
    
    
    
    /*
    // SAVE ANY VEHICULE IN A TXT
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipo_motor+"|"+this.year+"|"+this.recorrido+"|"+this.color+"|"+this.tipo_combustible+"|"+this.vidrios+"|"+this.transmicion+"|"+this.traccion+"|"+this.precio+"|"+this.id_vendedor);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/
    
    // SAVE ANY VEHICULE IN A BINARY FILE
    public void saveFile(String nomfile){
        try(FileOutputStream fous = new FileOutputStream(nomfile);ObjectOutputStream out = new ObjectOutputStream(fous);){
            Vehiculo v = new Vehiculo(this.id,this.placa,this.marca,this.modelo,this.tipo_motor,this.year,this.recorrido,this.color,this.tipo_combustible,this.vidrios,this.transmicion,this.traccion,this.precio,this.id_vendedor);      
            out.writeObject(v);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    
    
    /*
    // READ VEHICULO TXT AND RETURN ANY TYPE OF VEHICULO 
    public static ArrayList<Vehiculo> readFile(String nomfile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo vehicle = new Vehiculo(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Double.parseDouble(tokens[6]), tokens[7], tokens[8], Integer.parseInt(tokens[9]), tokens[10], tokens[11], Double.parseDouble(tokens[12]),Integer.parseInt(tokens[13]));
                vehiculos.add(vehicle);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }*/
    
    public static ArrayList<Vehiculo> readFile(String nomfile){
        try(FileInputStream fin = new FileInputStream(nomfile);ObjectInputStream oin = new ObjectInputStream(fin);) {
            ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>)oin.readObject();
            return vehiculos;
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    // GET VENDEDOR BY ID FROM A GIVEN LIST OF VENDEDORES, THEN ADD VEHICULO FROM A LIST OF VEHICULOS TO USER'S VEHICULES LIST, FINALLY CHANGE VENDEDOR FOR SEARCHBYID VENDEDOR
    public static void link(ArrayList<Vendedor> vendedores, ArrayList<Vehiculo> vehiculos){
        for(Vehiculo v: vehiculos){
            Vendedor ven = Vendedor.searchByID(vendedores, v.getId_vendedor());
            ven.getVehiculos().add(v);
            v.setVendedor(ven); //?
        }
    }
     
    
    /*
    // SAVE ANY TYPE OF VEHICULO FROM A GIVEN LIST IN VEHICULOS TXT
    public static void saveFile(String nomfile,ArrayList<Vehiculo> vehiculos){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))))
        {
            for (Vehiculo v: vehiculos)
                pw.println(v.id+"|"+v.placa+"|"+v.marca+"|"+v.modelo+"|"+v.tipo_motor+"|"+v.year+"|"+v.recorrido+"|"+v.color+"|"+v.tipo_combustible+"|"+v.vidrios+"|"+v.transmicion+"|"+v.traccion+"|"+v.precio+"|"+v.id_vendedor);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/
    
    
    // SAVE ANY TYPE OF VEHICULO FROM A GIVEN LIST IN VEHICULOS BINARY FILE
    public static void saveFile(String nomfile, ArrayList<Vehiculo> vehiculos){
        try(FileOutputStream fous = new FileOutputStream(nomfile);ObjectOutputStream out = new ObjectOutputStream(fous);){
            for(Vehiculo v: vehiculos)
                out.writeObject(v);
 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    
    
         
    // RETURN VEHICULO IF GIVEN ID MATCHES
    public static Vehiculo searchByID(ArrayList<Vehiculo> vehiculos, int id)
    {
        for(Vehiculo veh : vehiculos)
        {
            if(veh.id == id)
                return veh;
        }
        return null;
    }
    
    
    // RETURN VEHICULO IF GIVEN PLACA MATCHES
    public static Vehiculo searchByPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        for(Vehiculo veh : vehiculos)
        {
            if(veh.placa.equals(placa))
                return veh;
        }
        return null;
    }
    
        
    // RETURN LIST OF VEHICULOS FROM A GIVEN TYPE
    public static ArrayList<Vehiculo> searchByTipo(ArrayList<Vehiculo> vehiculos, String tipo){
        ArrayList<Vehiculo> filtro_vehiculos = new ArrayList<>();
        if(tipo.equals("moto")){
        for(Vehiculo vehiculo : vehiculos)
            {
            if (vehiculo.getVidrios()==0 && vehiculo.getTraccion().equals("null") && vehiculo.getTransmicion().equals("null")) //moto
                    filtro_vehiculos.add(vehiculo);
            }
        }
        
        if(tipo.equals("carro")){
        for(Vehiculo vehiculo : vehiculos)
            {
            if (vehiculo.getVidrios()!=0 && vehiculo.getTraccion().equals("null") && !vehiculo.getTransmicion().equals("null")) //carro
                    filtro_vehiculos.add(vehiculo);
            }
        }
        if(tipo.equals("camioneta")){
        for(Vehiculo vehiculo : vehiculos)
            {
            if (vehiculo.getVidrios()!=0 && !vehiculo.getTraccion().equals("null") && !vehiculo.getTransmicion().equals("null")) //camioneta
                    filtro_vehiculos.add(vehiculo);
            }
        }
        
        else
            filtro_vehiculos = vehiculos;
            
        
        return filtro_vehiculos;
    }
    
    
    
    // RETURN LIST OF VEHICULOS DEPENDING ON GIVEN RANGE, return whole list if range is not given.
    public static ArrayList<Vehiculo> searchByRecorrido(ArrayList<Vehiculo> vehiculos, double max_rec, double min_rec)
    {
        ArrayList<Vehiculo> filtro_vehiculos = new ArrayList<>();
        for(Vehiculo veh : vehiculos)
        {
            if(veh.recorrido<= max_rec && veh.recorrido>= min_rec)
                filtro_vehiculos.add(veh);
        }
        if(max_rec == 0 && min_rec == 0)
            filtro_vehiculos = vehiculos;
        
        return filtro_vehiculos;
    }
    
    
    // RETURN LIST OF VEHICULOS DEPENDING ON PRICE RANGE, return whole list if price is not given.
    public static ArrayList<Vehiculo> searchByPrecio(ArrayList<Vehiculo> vehiculos, double max_prec, double min_prec)
    {
        ArrayList<Vehiculo> filtro_vehiculos = new ArrayList<>();
        for(Vehiculo veh : vehiculos)
        {
            if(veh.precio<= max_prec && veh.precio>= min_prec)
                filtro_vehiculos.add(veh);
        }
        if(max_prec == 0 && min_prec == 0)
            filtro_vehiculos = vehiculos;
        return filtro_vehiculos;
    }
    
    
    // RETURN LIST OF VEHICULOS DEPENDING ON YEAR RANGE, return whole list if year is not given.
    public static ArrayList<Vehiculo> searchByYear(ArrayList<Vehiculo> vehiculos, int max_year, int min_year)
    {
        ArrayList<Vehiculo> filtro_vehiculos = new ArrayList<>();
        for(Vehiculo veh : vehiculos)
        {
            if(veh.year<= max_year && veh.year >= min_year)
                filtro_vehiculos.add(veh);
        }
        if(max_year == 0 && min_year == 0)
            filtro_vehiculos = vehiculos;
        return filtro_vehiculos;
    }
    
    
    // RETURN INTERSECTION FROM 2 GIVEN VEHICULOS' LIST
    public static ArrayList<Vehiculo> interseccionList(ArrayList<Vehiculo> vehiculos1,ArrayList<Vehiculo> vehiculos2){
        ArrayList<Vehiculo> filtro_vehiculos = new ArrayList<>();
        for(Vehiculo veh1 : vehiculos1){
           for(Vehiculo veh2 : vehiculos2){
            if(veh1.equals(veh2))
               filtro_vehiculos.add(veh1);
           
           }
       }
        return filtro_vehiculos;
    }
    
}
