import java.util.*;
import java.io.*; 

public class Consumidor extends Thread{
    

    LinkedList<String> memoriaCompartida = new LinkedList<>();

    public Consumidor (LinkedList<String> memoriaCompartida){
        this.memoriaCompartida = memoriaCompartida; 
    }

    @Override
    public void run (){
        try (FileWriter writer = new FileWriter("ArchivoConMayusc.txt")){
           for (String palabra : memoriaCompartida){
            writer.write(palabra.toUpperCase()+" ");
        } 
        } catch (Exception e) {
            System.out.println("No hemos podido pasar lo que hay en la memoria compartida a mayúsculas mi loco");
        }
        
    }
    
}