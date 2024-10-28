package uniandes.dpoo.hamburguesas.mundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Juan Pérez", "Calle Falsa 123");
        producto1 = new ProductoMenu("corral", 14000);
        producto2 = new ProductoMenu("papas medianas", 5500);
    }

    @Test
    void testAgregarProductoYCalcularPrecioTotal() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        int expectedTotal = (int) ((14000 + 5500) * 1.19);
        assertEquals(expectedTotal, pedido.getPrecioTotalPedido());
    }

    @Test
    void testGenerarTextoFactura() {
        pedido.agregarProducto(producto1);
        assertTrue(pedido.generarTextoFactura().contains("corral"));
    }

    @Test
    void testGuardarFactura() throws FileNotFoundException {
        File archivoFactura = new File("factura_test.txt");
        pedido.guardarFactura(archivoFactura);
        assertTrue(archivoFactura.exists());
        archivoFactura.delete();
    }
}
