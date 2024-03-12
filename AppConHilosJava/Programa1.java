
public class Programa1 implements Runnable{
    public static void main(String[] args) {
        Thread hilo = new Thread(new Programa1(),"Hilo1");
        hilo.start();
        System.out.println("Este codigo esta fuera del hilo");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" subproceso corriendo...");
    }
}
/* 
public class Programa1 extends Thread{
    public static void main(String[] args) {
        Programa1 hilo = new Programa1();
        hilo.start();
        System.out.println("Este codigo esta fuera del hilo");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" subproceso corriendo...");
    }
}
*/
