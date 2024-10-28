package uniandes.dpoo.hamburguesas.mundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;

public class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    public void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    public void testIniciarPedido() throws Exception {
        restaurante.iniciarPedido("Juan", "123 Calle Falsa");
        assertNotNull(restaurante.getPedidoEnCurso(), "El pedido en curso debería existir");

        assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            restaurante.iniciarPedido("Maria", "456 Avenida Real");
        }, "Debería lanzarse YaHayUnPedidoEnCursoException cuando ya hay un pedido en curso");
    }

    @Test
    public void testCerrarYGuardarPedido() throws Exception {
        restaurante.iniciarPedido("Juan", "123 Calle Falsa");
    }
}