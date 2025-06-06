
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> memoriaCompartida = new LinkedBlockingQueue<>();
        Estadisticas estadisticas = new Estadisticas(memoriaCompartida);

        Productor productor = new Productor(memoriaCompartida, estadisticas);
        Consumidor consumidor = new Consumidor(memoriaCompartida, estadisticas);
       
        productor.start();
        estadisticas.start();
        consumidor.start();

    }

}