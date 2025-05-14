import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

    LinkedList<String>memoriaCompartida = new LinkedList<>();

    Productor  productor = new Productor(memoriaCompartida);
    Consumidor consumidor = new Consumidor(memoriaCompartida);

    productor.start();
    
    try {
        productor.join();
    } catch (Exception e) {
        System.out.println("OSTRAS QUE CARENCIAS");
    }
    consumidor.start();


    }



}