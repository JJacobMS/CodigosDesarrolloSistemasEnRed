package gRPCHolaMundoStream.servidor;

import java.util.Scanner;

import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;
import com.proto.saludo.SaludoServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ServidorImpl extends SaludoServiceGrpc.SaludoServiceImplBase {

    @Override
    public void saludo(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver) {
        //Se crea la respuesta con el atributo response como "Hola request.Nombre"
        SaludoResponse respuesta = SaludoResponse.newBuilder().setResponse("Hola "+ request.getNombre()).build();
        //Se envia la response con onNext
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }

    @Override
    public void saludoStream(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver) {
        try (Scanner scanner = new Scanner(ServidorImpl.class.getResourceAsStream("/archivote.csv"))) {
            while (scanner.hasNextLine()) {
                String mensaje = scanner.nextLine();
                SaludoResponse respuesta = SaludoResponse.newBuilder().setResponse(mensaje).build();
                responseObserver.onNext(respuesta);
            }
        }
        responseObserver.onCompleted();
    }
}
