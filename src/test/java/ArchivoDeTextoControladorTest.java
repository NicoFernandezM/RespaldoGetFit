import controlador.ArchivoDeTextoControlador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoDeTextoControladorTest {
    @Test
    void inicioSesionTest() {
        assertFalse(ArchivoDeTextoControlador.getInstancia().validarUsuario("", ""));
    }
    @Test
    void existeUsuarioTest(){
        assertNull(ArchivoDeTextoControlador.getInstancia().usuarioExiste(""));
    }
    @Test
    void validarUsuarioTest(){
        assertFalse(ArchivoDeTextoControlador.getInstancia().validarUsuario("", ""));
    }
}