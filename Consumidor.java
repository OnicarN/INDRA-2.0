
import java.util.concurrent.BlockingQueue;

import java.io.*;

public class Consumidor extends Thread {
    Estadisticas estadisticas;
    BlockingQueue<String> memoriaCompartida1;
   

    public Consumidor(BlockingQueue<String> memoriaCompartida1, Estadisticas estadisticas) {
        this.memoriaCompartida1 = memoriaCompartida1;
        this.estadisticas = estadisticas; 
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter("ArchivoConMayusc.txt")) {

            while (true) {
                String palabra = memoriaCompartida1.take();
                writer.write(palabra.toUpperCase() + "\n");
                writer.flush();
                estadisticas.aumentarPalabrasConsumidor();
                Thread.sleep(1000);
               
            }

        } catch (Exception e) {
            System.out.println("error al escribir el nuevo archivo");
        }

    }

}