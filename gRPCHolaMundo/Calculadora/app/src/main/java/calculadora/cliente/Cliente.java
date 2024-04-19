package calculadora.cliente;

import com.proto.calculadora.CalculadoraServiceGrpc;

import javax.swing.JOptionPane;

import com.proto.calculadora.Calculadora.CalculadoraRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";

        int puerto = 9000;

        ManagedChannel ch = ManagedChannelBuilder.forAddress(host, puerto).usePlaintext().build();
        
        CalculadoraServiceGrpc.CalculadoraServiceBlockingStub stub = CalculadoraServiceGrpc.newBlockingStub(ch);

        while (true) {
            String opt = JOptionPane.showInputDialog(
                "Calcular\n"+"Suma (1)\n"+"Resta  (2)\n"+"Multiplicación (3)\n"+"División (4)\n"+"Cancelar para salir");
            if (opt == null) {
                break;
            }
            int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b"));
            CalculadoraRequest peticion = CalculadoraRequest.newBuilder().setA(a).setB(b).build();
            switch (opt) {
                case "1":
                    JOptionPane.showMessageDialog(null, a + "+" + b + "=" + stub.sum(peticion).getResultado());
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, a + "-" + b + "=" + stub.res(peticion).getResultado());
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, a + "*" + b + "=" + stub.mul(peticion).getResultado());
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, a + "/" + b + "=" + stub.div(peticion).getResultado());
                    break;
                default:
                    break;
            }
        }

        System.out.println("Apagando");
        ch.shutdown();
    }
}
