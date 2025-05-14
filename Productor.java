import java.util.*;
import java.io.*;

public class Productor extends Thread{
    
    LinkedList<String>memoriaCompartida = new LinkedList<>();

    public Productor ( LinkedList<String>memoriaCompartida){
        
        this.memoriaCompartida = memoriaCompartida;
    }

    @Override
    public void run (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("okey, introduce el nombre del fichero pues");
        String nombreFichero = entrada.nextLine();

       
        File archivo = new File(nombreFichero);

        if (archivo.exists() && archivo.isFile()) {
            
            try (Scanner lector = new Scanner(archivo)) {
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    String []palabraPorPalabra = linea.split(" ");
                   

                    for (String palabras : palabraPorPalabra){
                        memoriaCompartida.add(palabras);
                    }
                  
                }
                
            } catch (FileNotFoundException e) {
                System.out.println("me da que no hemos podido leer el fcihero");
            }
        } else {
            System.out.println("ezzz ");
            System.out.println("estas aca: " + new File(".").getAbsolutePath());

        }
        entrada.close();
    }
    }


