package uniandes.dpoo.hamburguesas.mundo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    private ProductoMenu productoCorral;
    private ProductoMenu productoPapas;
    private ProductoMenu productoGaseosa;
    private ArrayList<ProductoMenu> itemsCombo;
    private Combo comboCorral;

    @BeforeEach
    void setUp() {
        productoCorral = new ProductoMenu("corral", 14000);
        productoPapas = new ProductoMenu("papas medianas", 5500);
        productoGaseosa = new ProductoMenu("gaseosa", 5000);

        itemsCombo = new ArrayList<>();
        itemsCombo.add(productoCorral);
        itemsCombo.add(productoPapas);
        itemsCombo.add(productoGaseosa);

        comboCorral = new Combo("combo corral", 0.9, itemsCombo); 
    }

    @Test
    void testConstructor() {
        assertEquals("combo corral", comboCorral.getNombre());
    }

    @Test
    void testGetNombre() {
        assertEquals("combo corral", comboCorral.getNombre());
    }

    @Test
    void testGetPrecio() {
        int expectedPrice = (int) ((14000 + 5500 + 5000) * 0.9);
        assertEquals(expectedPrice, comboCorral.getPrecio());
    }

    @Test
    void testGenerarTextoFactura() {
        String expectedText = "Combo combo corral\n" +
                              " Descuento: 0.9\n" +
                              "            " + comboCorral.getPrecio() + "\n";
        
        assertEquals(expectedText, comboCorral.generarTextoFactura());
    }
}
