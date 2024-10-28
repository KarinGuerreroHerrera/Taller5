package uniandes.dpoo.hamburguesas.mundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductoMenuTest {

    private ProductoMenu productoCorral;
    private ProductoMenu productoPapas;
    private ProductoMenu productoAgua;

    @BeforeEach
    void setUp() {
        productoCorral = new ProductoMenu("corral", 14000);
        productoPapas = new ProductoMenu("papas medianas", 5500);
        productoAgua = new ProductoMenu("agua cristal sin gas", 5000);
    }

    @Test
    void testConstructor() {
        assertEquals("corral", productoCorral.getNombre());
        assertEquals(14000, productoCorral.getPrecio());

        assertEquals("papas medianas", productoPapas.getNombre());
        assertEquals(5500, productoPapas.getPrecio());

        assertEquals("agua cristal sin gas", productoAgua.getNombre());
        assertEquals(5000, productoAgua.getPrecio());
    }

    @Test
    void testGetNombre() {
        assertEquals("corral", productoCorral.getNombre());
        assertEquals("papas medianas", productoPapas.getNombre());
        assertEquals("agua cristal sin gas", productoAgua.getNombre());
    }

    @Test
    void testGetPrecio() {
        assertEquals(14000, productoCorral.getPrecio());
        assertEquals(5500, productoPapas.getPrecio());
        assertEquals(5000, productoAgua.getPrecio());
    }

    @Test
    void testGenerarTextoFactura() {
        String expectedTextCorral = "corral\n 14000\n";
        assertEquals(expectedTextCorral, productoCorral.generarTextoFactura());

        String expectedTextPapas = "papas medianas\n 5500\n";
        assertEquals(expectedTextPapas, productoPapas.generarTextoFactura());

        String expectedTextAgua = "agua cristal sin gas\n 5000\n";
        assertEquals(expectedTextAgua, productoAgua.generarTextoFactura());
    }
}