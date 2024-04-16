import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) {
        try {
            int puerto = 9000;
            String servidor = "localhost";
            System.out.println("Iniciando servidor en ");
            System.out.println("Hostname: "+servidor);
            System.out.println("Puerto: "+puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", servidor);
            registro.rebind("Calculadora", new CalcRMI());

            //Finalmente con un rebind() iniciamos el servidor con el nombre de Calculadora, que traducido a URL será rmi://localhost:8080/Calculadora.
            System.out.println("Servidor ejecutadose..");

        } catch(RemoteException ex){
            System.err.println(ex);
        }
    }
}
