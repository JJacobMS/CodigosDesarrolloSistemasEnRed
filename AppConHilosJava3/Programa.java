package AppConHilosJava3;

public class Programa {
    public static void main(String[] args) {
        Hilo hilo = new Hilo("Hola");
        Hilo hilo2 = new Hilo("Mundo");

        Thread p1 = new Thread(hilo);
        Thread p2 = new Thread(hilo2);
        p1.start();
        p2.start();
    }
}
