/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package multicastudpchatgrafico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

/**
 *
 * @author monti
 */
public class FXMLChatController implements Initializable {
    @FXML
    private Button ButtonEnviarMensaje;
    @FXML
    private Label label;
    @FXML
    private VBox VBoxMensajes;
    @FXML
    private TextField TextFieldMensaje;
    private Thread scannerHilo;
    private ThreadScanner scannerConsola;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{                
            int puerto = 9000;
            InetAddress grupo = InetAddress.getByName("224.0.0.0");
            MulticastSocket socket = new MulticastSocket(puerto);
            socket.joinGroup(grupo);
            scannerConsola = new ThreadScanner(puerto,grupo,socket, VBoxMensajes);
            scannerHilo = new Thread(scannerConsola);
            scannerHilo.start();
            String nombre = showInputDialog("","Nombre usuario","Ingresa tu nombre de usuario");
            if(nombre.isEmpty() || nombre==null){
                nombre = "Sin nombre usuario";
            }
            scannerConsola.setNombreUsuario(nombre);
        }catch(SocketException e){
            System.out.println("Socket "+e.getMessage());
        }catch(IOException e){
            System.out.println("IO  "+e.getMessage());
        }
    }    

    @FXML
    private void enviarMensaje(ActionEvent event) {
        String mensaje = TextFieldMensaje.getText();
        if(!mensaje.isEmpty()){
            scannerConsola.enviarMensaje(mensaje);
            TextFieldMensaje.setText("");
        }
    }
    
    public static String showInputDialog(String title, String headerText, String message) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().removeIf(buttonType -> buttonType.getButtonData().isCancelButton());

        Optional<String> result = dialog.showAndWait();
        return result.get();
    }
    
} 
