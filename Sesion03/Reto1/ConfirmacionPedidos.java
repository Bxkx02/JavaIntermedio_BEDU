import java.util.*;
import java.util.stream.*;

public class ConfirmacionPedidos {

    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Juan", "domicilio", "555-1234"),
                new Pedido("María", "local", null),
                new Pedido("Carlos", "domicilio", null),
                new Pedido("Luisa", "domicilio", "555-5678")
        );

        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent) 
                .map(Optional::get) 
                .map(tel -> "📞 Confirmación enviada al número: " + tel) 
                .toList(); 

        System.out.println("📞 Confirmaciones de pedidos a domicilio:");
        mensajes.forEach(System.out::println);
    }
}