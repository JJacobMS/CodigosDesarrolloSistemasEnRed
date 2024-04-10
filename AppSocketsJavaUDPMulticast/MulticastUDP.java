package AppSocketsJavaUDPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class MulticastUDP {
    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        try{
            int puerto = 9000;
            InetAddress grupo = InetAddress.getByName("224.0.0.0");
            MulticastSocket socket = new MulticastSocket(puerto);
            socket.joinGroup(grupo);

            ThreadScanner scannerConsola = new ThreadScanner(puerto,grupo,socket);
            Thread scannerHilo = new Thread(scannerConsola);
            scannerHilo.start();

            byte[] buffer = new byte[1024];
            String linea;
            while (true) {
                DatagramPacket mensajeEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(mensajeEntrada);
                linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
                System.out.println(linea);
                String[] usuario = linea.split(": ");
                String nombreUsuarioRecibido = usuario[0];
                String mensaje = usuario[1];
                if(mensaje.equalsIgnoreCase("Adios") && scannerConsola.getActual()){
                    socket.leaveGroup(grupo);
                    System.out.println("Desconectando");
                    break;
                } if (mensaje.equalsIgnoreCase("Adios") && !scannerConsola.getActual()) {
                    System.out.println("Se ha desconectado "+nombreUsuarioRecibido);
                }
            }
            scannerHilo.stop();
            socket.close();
        }catch(SocketException e){
            System.out.println("Socket "+e.getMessage());
        }catch(IOException e){
            System.out.println("IO  "+e.getMessage());
        }
    }
}
