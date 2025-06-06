import java.util.*;
import java.util.concurrent.BlockingQueue;

import java.io.*;

public class Productor extends Thread {
    Estadisticas estadisticas;
    BlockingQueue<String> memoriaCompartida1;

    public Productor(BlockingQueue<String> memoriaCompartida1, Estadisticas estadisticas) {
        this.memoriaCompartida1 = memoriaCompartida1;
        this.estadisticas = estadisticas;
    }

    @Override
    public void run() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo");
        String nombreFichero = entrada.nextLine();
        estadisticas.iniciar();

        File archivo = new File(nombreFichero);

        if (archivo.exists() && archivo.isFile()) {

            try (Scanner lector = new Scanner(archivo)) {
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    estadisticas.aumentarPalabrasProductor();

                    String[] palabraPorPalabra = linea.split(" ");

                    for (String palabras : palabraPorPalabra) {
                        try {
                            memoriaCompartida1.put(palabras + " ");
                         
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }
                    //
                    try {
                        Thread.sleep(6000);
                    } catch (Exception e) {
                        System.out.println("no puedo leer bien las lineas cada segundo" + e.getMessage());
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("error al intentar leer el archivo");
            }
        } else {
            System.out.println("tu ubicación actual es: " + new File(".").getAbsolutePath());

        }
        entrada.close();
    }
}
