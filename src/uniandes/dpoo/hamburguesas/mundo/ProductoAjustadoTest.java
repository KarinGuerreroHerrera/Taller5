package uniandes.dpoo.hamburguesas.mundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductoAjustadoTest {

    private ProductoMenu productoBase;
    private ProductoAjustado productoAjustado;
    private Ingrediente lechuga;
    private Ingrediente tocinetaExpress;

    @BeforeEach
    void setUp() {
        productoBase = new ProductoMenu("corral", 14000);
        
        lechuga = new Ingrediente("lechuga", 1000);
        tocinetaExpress = new Ingrediente("tocineta express", 2500);

        productoAjustado = new ProductoAjustado(productoBase);
    }

    @Test
    void testConstructor() {
        assertEquals(productoBase.getNombre(), productoAjustado.getNombre());
        
        assertTrue(productoAjustado.getAgregados().isEmpty());
        assertTrue(productoAjustado.getEliminados().isEmpty());
    }

    @Test
    void testGetNombre() {
        assertEquals("corral", productoAjustado.getNombre());
    }

    @Test
    void testGetPrecio() {
    	productoAjustado.getAgregados().add(lechuga);
        productoAjustado.getAgregados().add(tocinetaExpress);

        int expectedPrice = productoBase.getPrecio() + lechuga.getCostoAdicional() + tocinetaExpress.getCostoAdicional();
        assertEquals(expectedPrice, productoAjustado.getPrecio());
    }
    
    @Test
    void testGenerarTextoFactura() {
    	productoAjustado.getAgregados().add(lechuga);
        productoAjustado.getEliminados().add(tocinetaExpress);
        
        String expectedText = "corral\n+lechuga 1000\n-tocineta express\n  " + productoAjustado.getPrecio() + "\n";
        assertEquals(expectedText.strip(), productoAjustado.generarTextoFactura().strip());
    }
}
