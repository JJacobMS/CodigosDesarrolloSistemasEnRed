package AppConHilosJava2;

public class Hilo implements Runnable{

    private String tipoHilo;

    public Hilo(String tipoHilo){
        this.tipoHilo = tipoHilo;
    }

    @Override
    public void run() {
        if (tipoHilo.equals("1")) {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hilo1: "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else{
            for (int i = 100; i >= 1; i--) {
                System.out.println("Hilo2: "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
