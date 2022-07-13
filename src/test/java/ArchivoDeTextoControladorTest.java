import controlador.ArchivoDeTextoControlador;
import error.UsuarioNoEncontradoException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoDeTextoControladorTest {

    private final String NOMBRE = "nico";
    private final String NOMBRE_USUARIO = "elNico";
    private final String NOMBRE_USUARIO_INEXISTENTE = "Nicolas";
    private final String CONTRASENA = "123";
    private final int EDAD = 20;
    private final String DATOS_USUARIO_PRUEBA = "DatosUsuariosPruebas.txt";


    @BeforeEach
    void inicializar() throws IOException {
        ArchivoDeTextoControlador archivoDeTextoControlador = ArchivoDeTextoControlador.getInstancia(DATOS_USUARIO_PRUEBA);
        archivoDeTextoControlador.registrarUsuario(NOMBRE_USUARIO, CONTRASENA, NOMBRE, EDAD);
    }

    @AfterEach
    void finalizar() {
        ArchivoDeTextoControlador
                .getInstancia(DATOS_USUARIO_PRUEBA)
                .borrarLista();
    }

    /*@Test
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
    }*/

    @Test
    @DisplayName("Caso prueba usuario existente")
    void buscarUsuarioTestPruebaUsuarioExistente() {
        ArchivoDeTextoControlador archivoDeTextoControlador = ArchivoDeTextoControlador.getInstancia(DATOS_USUARIO_PRUEBA);
        var usuario = archivoDeTextoControlador.buscarUsuarioSiExiste(NOMBRE_USUARIO);
        assertEquals(NOMBRE_USUARIO, usuario.getNombreUsuario());
    }

    @Test
    @DisplayName("Caso prueba usuario no existe")
    void buscarUsuarioTestPruebaUsuarioNoExiste() {
        ArchivoDeTextoControlador archivoDeTextoControlador = ArchivoDeTextoControlador.getInstancia(DATOS_USUARIO_PRUEBA);
        assertThrows(UsuarioNoEncontradoException.class,
                () -> archivoDeTextoControlador.buscarUsuario(NOMBRE_USUARIO_INEXISTENTE));
    }

    @Test
    @DisplayName("Caso prueba datos usuarios coinciden")
    void validarUsuarioTest() {
        ArchivoDeTextoControlador archivoDeTextoControlador = ArchivoDeTextoControlador.getInstancia(DATOS_USUARIO_PRUEBA);
        assertTrue(archivoDeTextoControlador.validarUsuario(NOMBRE_USUARIO, CONTRASENA));
    }

    @Test
    @DisplayName("Caso prueba datos usuarios no coinciden")
    void validarUsuarioSinCoincidenciaTest() {
        ArchivoDeTextoControlador archivoDeTextoControlador = ArchivoDeTextoControlador.getInstancia(DATOS_USUARIO_PRUEBA);
        assertFalse(archivoDeTextoControlador.validarUsuario(NOMBRE_USUARIO_INEXISTENTE, CONTRASENA));
    }
}