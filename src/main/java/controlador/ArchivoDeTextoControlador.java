package controlador;

import modelo.Usuario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.IntStream;

public class ArchivoDeTextoControlador {
    private static ArchivoDeTextoControlador instancia = null;

    private static final String DATOS_USUARIOS = "DatosUsuarios.txt" ;
    public static final String SEPARADOR =  ";";

    private Usuario usuarioEnSesion;

    private ArchivoDeTextoControlador() {
        try {
            File file = new File(DATOS_USUARIOS);

            if(!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArchivoDeTextoControlador getInstancia() {
        if(instancia == null) {
            instancia = new ArchivoDeTextoControlador();
        }

        return instancia;
    }

    public void registrarUsuario(String nombreUsuario, String contraseña, String nombre, int edad) throws IOException {
        String lineaUsuario = String.join(SEPARADOR, nombreUsuario, contraseña, nombre, String.valueOf(edad));
        Files.writeString(Paths.get(DATOS_USUARIOS), lineaUsuario + "\n", StandardOpenOption.APPEND);

        this.usuarioEnSesion = Usuario.crearUsuario(lineaUsuario);
    }

    public Usuario usuarioExiste(String nombreUsuario) {
        try {
            List<String> content = Files.readAllLines(Paths.get(DATOS_USUARIOS));

            for (String entradaUsuario: content) {
                String a = entradaUsuario.split(SEPARADOR)[0];
                if(a.equals(nombreUsuario)) {
                    return Usuario.crearUsuario(entradaUsuario);
                }
            }
            return null;
        }catch (IOException ioException) {
            return null;
        }

    }

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

    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = this.usuarioExiste(nombreUsuario);

        if(usuario != null && usuario.getContraseña().equals(contraseña)) {
            this.usuarioEnSesion = usuario;
            return true;
        }

        return false;
    }

    public Usuario getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

}
