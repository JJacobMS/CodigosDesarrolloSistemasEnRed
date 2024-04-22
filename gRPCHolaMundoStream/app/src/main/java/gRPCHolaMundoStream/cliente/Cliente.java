package gRPCHolaMundoStream.cliente;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.proto.saludo.SaludoServiceGrpc;
import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;;


public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 8080;
        ManagedChannel ch = ManagedChannelBuilder
        .forAddress(host, puerto)
        .usePlaintext()
        .build();
    
        SaludarUnario(ch);
        SaludarStream(ch);
        System.out.println("Apagando");
        ch.shutdown();
    }
    private static void SaludarUnario(ManagedChannel ch) {
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);
        SaludoRequest peticion = SaludoRequest.newBuilder().setNombre("Jesus Jacob").build();
        SaludoResponse respuesta = stub.saludo(peticion);
        System.out.println("Respuesta RPC: "+respuesta.getResponse());        
    }
    private static void SaludarStream(ManagedChannel ch) {
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);
        SaludoRequest peticion = SaludoRequest.newBuilder().setNombre("Jesus Jacob").build();
        stub.saludoStream(peticion).forEachRemaining(respuesta -> {
           System.out.println("Respuesta RPC: "+respuesta.getResponse()); 
        });
    }
}
