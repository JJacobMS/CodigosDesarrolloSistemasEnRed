package AppSocketsJavaUDPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;

public class ThreadScanner implements Runnable {
    private boolean running = true;
    int puerto;
    InetAddress grupo;
    MulticastSocket socket;
    boolean envioAdios = false;
    String nombreUsuario;
    Scanner scanNombre;

    public ThreadScanner(int puerto, InetAddress grupo, MulticastSocket socket){
        this.puerto = puerto;
        this.grupo = grupo;
        this.socket = socket;
    }

    public boolean getActual(){
        return envioAdios;
    }

    public void setNombreUsuario(){
        scanNombre = new Scanner(System.in);
        System.out.println("Ingresa tu nombre de usuario");
        this.nombreUsuario = scanNombre.nextLine();
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        setNombreUsuario();
        while (running) { 
            System.out.println("Envie un mensaje al grupo: ");
            String texto = scan.nextLine();
            String mensaje = nombreUsuario+": "+texto;
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket mensajeSalida = new DatagramPacket(mensajeBytes, mensajeBytes.length, grupo, puerto);
            try {
                if(texto.equalsIgnoreCase("Adios")){
                    System.out.println("Es el mismo usuario");
                    envioAdios = true;
                }
                socket.send(mensajeSalida);
            } catch(SocketException e) {
                System.out.println("Socket "+e.getMessage());
            } catch(IOException e) {
                System.out.println("IO  "+e.getMessage());
            }
        }
        scan.close();
        scanNombre.close();
    }
}
