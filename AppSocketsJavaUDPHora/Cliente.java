package AppSocketsJavaUDPHora;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        String mensaje = new String("Dame la hora local");
        String servidor = new String("localhost");
        int puerto = 8080;
        int espera = 5000;
        DatagramSocket socketUDP = new DatagramSocket();
        //ip localhost
        InetAddress hostservidor = InetAddress.getByName(servidor);
        DatagramPacket peticion = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, hostservidor, puerto);
        //Esperamos un tiempo maximo en milisegundos
        socketUDP.setSoTimeout(espera);
        System.out.println("Esperamos datos de un maximo "+espera+" milisegundos");
        //Se envia la peticion
        socketUDP.send(peticion);
        //Esperamos respuesta
        try{
            byte[] buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            //Recibimos respuesta
            socketUDP.receive(respuesta);
            //Convertimos la fecha en string
            String strText = new String(respuesta.getData(),0,respuesta.getLength());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime horaServidor = LocalDateTime.parse(strText,formatter);
            System.out.println("Hora del servidor es "+horaServidor.format(formatter));

            LocalDateTime now = LocalDateTime.now();
            String strFechaActual = now.format(formatter);
            System.out.println("La hora del cliente es: "+strFechaActual);

            Duration duration = Duration.between(horaServidor, now);
            long segundos = duration.getSeconds();            
            System.out.println("La diferencia en segundos es de "+segundos);
        }catch(SocketTimeoutException s){
            System.out.println("Tiempo expirado para recibir la respuesta");
        }
        socketUDP.close();
    }
}
