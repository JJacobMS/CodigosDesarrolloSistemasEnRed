package AppConHilosJava3;

public class Hilo implements Runnable{

    private String nombreHilo;

    public Hilo(String nombreHilo){
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(nombreHilo+" ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}
    
