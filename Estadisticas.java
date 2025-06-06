import java.util.concurrent.BlockingQueue;

public class Estadisticas extends Thread {

    private int palabrasProductor = 0;
    private int palabrasConsumidor = 0;
    BlockingQueue<String> memoriaCompartida1;

    private volatile boolean iniciar = false;

    public Estadisticas(BlockingQueue<String> memoriaCompartida1) {
        this.memoriaCompartida1 = memoriaCompartida1;
    }

    @Override
    public void run() {

        while (true) {

            while (iniciar == false) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println("error");
                }
            }

            while (true) {
                try {
                    System.out.println("------------------------------------------------------");
                    System.out.println("palabras en memoria " + memoriaCompartida1.size());
                    System.out.println("lineas leidas " + palabrasProductor);
                    System.out.println("Palabras escritas por el consumidor " + palabrasConsumidor);
                    System.out.println("-------------------------------------------------------");
                    Thread.sleep(10000);
                } catch (Exception e) {
                    System.out.println("error al producir las estadísticas");
                }
            }

        }
    }

    public void iniciar() {
        this.iniciar = true;
    }

    public synchronized void aumentarPalabrasProductor() {
        palabrasProductor++;
    }

    public synchronized void aumentarPalabrasConsumidor() {
        palabrasConsumidor++;
    }
}