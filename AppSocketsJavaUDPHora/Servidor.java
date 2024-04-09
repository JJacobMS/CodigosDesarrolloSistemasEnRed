package AppSocketsJavaUDPHora;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor {
    public static void main(String[] args) throws SocketException, IOException {
        int puerto =8080;        
        int retardo = 4000;
        //Usamos try para que cierre el socket automaticamente al terminar
        try(DatagramSocket socketUDP = new DatagramSocket(puerto)){
            //peticion no mayor a 1024 bytes
            byte[] buffer = new byte[1024];
            System.out.println("Servidor UDP escuchando en puerto: "+puerto);
            //bucle infinito para escuchar
            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                //Aqui recibe la respuesta
                socketUDP.receive(peticion);
                
                System.out.println("Datagrama recibido del host: "+peticion.getAddress());
                System.out.println("Desde el puerto remoto: "+peticion.getPort());
                System.out.println("Datos recibidor: "+ new String(peticion.getData()));

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String strFecha = now.format(formatter);
                System.out.println("La hora del servidor es: "+strFecha);

                //Retardo en segundos
                try{
                    System.out.println("Simulados un retardo en milisegundos: "+retardo);
                    Thread.sleep(retardo);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                //Se envian datos al cliente
                //Se crea la respuesta UDP con el mensaje, ip y puerto
                DatagramPacket respuesta = new DatagramPacket(strFecha.getBytes(), strFecha.getBytes().length, peticion.getAddress(),peticion.getPort());
                //Se envia la respuesta
                socketUDP.send(respuesta);
                System.out.println("Datos enviados al cliente");
            }
        }
    }
}
