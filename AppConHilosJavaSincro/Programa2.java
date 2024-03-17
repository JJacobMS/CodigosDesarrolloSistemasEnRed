public class Programa2 {
    private static int hora;

    private static class JuntaThread implements Runnable{
        public JuntaThread(){
            hora = 9;
        }

        @Override
        public void run() {
            realizarJunta();
        }
        public static synchronized void realizarJunta(){
            System.out.println(Thread.currentThread().getName()+" junta iniciada a las "+ hora);
            hora++;
            System.out.println(Thread.currentThread().getName()+" junta terminada a las "+ hora);    
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread hilo1 = new Thread(new JuntaThread(),"Junta-"+(i+1));
            hilo1.start();
        }
    }
}
