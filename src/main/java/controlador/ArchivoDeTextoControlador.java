package controlador;

import error.UsuarioNoEncontradoException;
import modelo.Usuario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Esta clase permite controlar todas las acciones sobre el archivo de texto que guarda los datos de los usuarios.
 * @author Nicolás Fernández
 */

public class ArchivoDeTextoControlador {
    private static ArchivoDeTextoControlador instancia;

    private static String DATOS_USUARIOS;
    public static final String SEPARADOR = ";";

    private Usuario usuarioEnSesion;

    /**
     * Este constructor permite crear un archivo con la dirección indicada en caso de que no exista.
     */

    private ArchivoDeTextoControlador(String ruta) {
        try {
            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método permite obtener una unica instancia de la clase.
     *
     * @return una instancia de la clase, en caso de que ya exista una retorna esa instancia, en caso contrario
     * hace una instancia y la retorna.
     */

    public static ArchivoDeTextoControlador getInstancia() {
        if (instancia == null) {
            DATOS_USUARIOS = "DatosUsuarios.txt";
            instancia = new ArchivoDeTextoControlador(DATOS_USUARIOS);
        }

        return instancia;
    }

    public static ArchivoDeTextoControlador getInstancia(String ruta) {
        if (instancia == null) {
            DATOS_USUARIOS = ruta;
            instancia = new ArchivoDeTextoControlador(ruta);
        }

        return instancia;
    }

    /**
     * Este método junta los datos del usuario en una línea y los separa por un separador específicado.
     * Adicionalmente, establece ese usuario registrado como el usuario en sesión.
     *
     * @param nombreUsuario es el nombre de usuario.
     * @param contrasena    es la contrasena del usuario.
     * @param nombre        es el nombre de la persona que se registra.
     * @param edad          es la edad de la persona que se registra.
     * @throws IOException lanza esta excepción si ocurre un error en el proceso de escritura.
     */

    public void registrarUsuario(String nombreUsuario, String contrasena, String nombre, int edad) throws IOException {
        String lineaUsuario = String.join(SEPARADOR, nombreUsuario, contrasena, nombre, String.valueOf(edad));
        Files.writeString(Paths.get(DATOS_USUARIOS), lineaUsuario + "\n", StandardOpenOption.APPEND);

        this.usuarioEnSesion = Usuario.crearUsuario(lineaUsuario);
    }

    /**
     *Este método permite saber si un usuario existe leyendo el archivo de texto y buscando un usuario por su nombre.
     * @param nombreUsuario es el nombre del usuario.
     * @return Un objeto de Usuario en el caso de que exista un usuario registrado con el nombre indicado, en caso
     * contrario retorna null.
     */

    public Usuario buscarUsuario(String nombreUsuario) throws IOException {

        List<String> content = Files.readAllLines(Paths.get(DATOS_USUARIOS));

        for (String entradaUsuario: content) {
            String nombreUsuarioEnLista = entradaUsuario.split(SEPARADOR)[0];
            if(nombreUsuarioEnLista.equals(nombreUsuario)) {
                return Usuario.crearUsuario(entradaUsuario);
            }
        }
        throw new UsuarioNoEncontradoException(nombreUsuario);
    }

    public Usuario buscarUsuarioSiExiste(String nombreUsuario) {
        try {
            return buscarUsuario(nombreUsuario);
        }catch (IOException | UsuarioNoEncontradoException e) {
            return null;
        }
    }

    /**
     * Este método permite editar el máximo de repeticiones de cada ejercicio de un usuario.
     * @param maxFlexiones es el máximo de repeticiones de flexiones de brazos que puede hacer un usuario.
     * @param maxDominadas es el máximo de repeticiones de dominadas que puede hacer un usuario.
     */

    public void editarUsuario(int maxFlexiones, int maxDominadas) {
        this.usuarioEnSesion.setMaxRepsFlexiones(maxFlexiones);
        this.usuarioEnSesion.setMaxRepsDominadas(maxDominadas);
        String lineaUsuario = this.usuarioEnSesion.generarEntradaUsuario();

        try {
            List<String> content = Files.readAllLines(Paths.get(DATOS_USUARIOS));
            int indice = IntStream.range(0, content.size())
                    .filter(i -> content.get(i).contains(this.usuarioEnSesion.getNombreUsuario()))
                    .findFirst()
                    .orElse(-1);

            content.set(indice, lineaUsuario);

            Files.write(Paths.get(DATOS_USUARIOS), content , StandardOpenOption.WRITE);

        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Este método verifica que cierto usuario y contrasena coincida con los datos guardados en el archivo de texto.
     * @param nombreUsuario es el nombre del usuario.
     * @param contrasena es la contrasena del usuario.
     * @return true si el usuario y la contrasena dada coinciden con un usuario y contrasena guardados en el
     * archivo de texto y false en caso contrario.
     */

    public boolean validarUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = this.buscarUsuarioSiExiste(nombreUsuario);

        if(usuario != null && usuario.getContrasena().equals(contrasena)) {
            this.usuarioEnSesion = usuario;
            return true;
        }

        return false;
    }

    /**
     * Este método permite obtener el usuario en sesión.
     * @return un objeto de tipo Usuario.
     */

    public Usuario getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void borrarLista() {
        File file = new File(DATOS_USUARIOS);
        file.delete();
        instancia = null;
    }

}
