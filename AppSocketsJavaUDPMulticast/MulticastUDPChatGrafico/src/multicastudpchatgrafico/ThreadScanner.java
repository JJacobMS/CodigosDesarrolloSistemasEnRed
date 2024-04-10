/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multicastudpchatgrafico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author monti
 */
public class ThreadScanner implements Runnable {
    private boolean running = true;
    int puerto;
    InetAddress grupo;
    MulticastSocket socket;
    boolean envioAdios = false;
    String nombreUsuario;
    byte[] buffer = new byte[1024];
    String linea;
    private VBox VBoxMensajes;
    String finalLinea;
    
    public ThreadScanner(int puerto, InetAddress grupo, MulticastSocket socket, VBox VBoxMensajes){
        this.puerto = puerto;
        this.grupo = grupo;
        this.socket = socket;
        this.VBoxMensajes = VBoxMensajes;
    }

    public boolean getActual(){
        return envioAdios;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public void enviarMensaje(String mensajeString){
        String texto = mensajeString;
        String mensaje = nombreUsuario+": "+texto;
        byte[] mensajeBytes = mensaje.getBytes();
        DatagramPacket mensajeSalida = new DatagramPacket(mensajeBytes, mensajeBytes.length, grupo, puerto);
        try {
            if(texto.equalsIgnoreCase("Adios")){
                envioAdios = true;
            }
            socket.send(mensajeSalida);
        } catch(SocketException e) {
            System.out.println("Socket "+e.getMessage());
        } catch(IOException e) {
            System.out.println("IO  "+e.getMessage());
        }
    }
    

    @Override
    public void run() {
        try{
            while (true) {
                DatagramPacket mensajeEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(mensajeEntrada);
                linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());   
                String[] usuario = linea.split(": ");
                String nombreUsuarioRecibido = usuario[0];
                String mensaje = usuario[1];
                finalLinea = linea; 
                Platform.runLater(() -> { 
                    Label label = new Label(nombreUsuarioRecibido+": "+mensaje);
                    VBoxMensajes.getChildren().add(label);
                });
                if(mensaje.equalsIgnoreCase("Adios") && this.getActual()){
                    socket.leaveGroup(grupo);
                    finalLinea = "Desconectando";
                    Platform.runLater(() -> { 
                        Label label = new Label(finalLinea);
                        VBoxMensajes.getChildren().add(label);
                    }); 
                    break;
                } if (mensaje.equalsIgnoreCase("Adios") && !this.getActual()) {
                    finalLinea = "Se ha desconectado "+nombreUsuarioRecibido;
                    Platform.runLater(() -> { 
                        Label label = new Label(finalLinea);
                        VBoxMensajes.getChildren().add(label);
                    }); 
                }
            }
            socket.close();
        }catch(SocketException e){
            System.out.println("Socket "+e.getMessage());
        }catch(IOException e){
            System.out.println("IO  "+e.getMessage());
        }
    }
}

