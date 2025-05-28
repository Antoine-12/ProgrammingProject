

package com.mycompany.loginu;

import java.util.ArrayList;

public class LogU {
    
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<PromoCode> prco = new ArrayList<>();
    public static ArrayList<StockTaking> stockT = new ArrayList<>();
    public static ArrayList<Address> adress = new ArrayList<>();

    public static void main(String[] args) {
        
        User us = new User();
        
        us.setName("osmar");
        us.setPassword("admin");
        us.setRole(1);
        us.setUser("admin");
        
        LogU.users.add(us);
        
        DefaultList.loadBooks();
        DefaultList.cxs();
       // DefaultList.codp();
        
        
        toLogin lg = new toLogin();
        lg.setVisible(true);
        // todos los atributos de una clase deben ser privados 
        // encapsular: la variables privadas y se generan mitalos de set and set 
    }
    
    /*
    
    Archivo
    - Abrir
    - leer
    - escribir
     guardar
     borrarlo
    
    Los archivos tienen dos permisos,
    
    # Lectura: (No se bloquea) // multiples procesos
    
    # Escritura: (si se bloquea) // solo un proceso
    
    Tipos de archivos:
    
    - Texto
        *String
    
    - Binarios
       * cualquier cosa
    
    SE puede acceder a los archivos por dos maneras:
    
    secuencial: 
    
    Acceso directo:
    
    IOexeption
    
    Tipos de rutas 
    - ruta absoluta: C://Usuario
    
    - ruta relativa: // txt
    
    Dos librerias
    - FireWriter:
    
    
    
    Lectura:
    - File:
    - FileReader:
    - BufferedReader: almacena los datos por filas
    
    
    
    
    
    
    
    
    
    
    
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
