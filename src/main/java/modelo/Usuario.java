package modelo;

import controlador.ArchivoDeTextoControlador;

/**
 * Esta clase es la que representa un usuario en la aplicación.
 *
 * @author Nicolás Fernández
 */

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private int edad;
    private int maxRepsFlexiones;
    private int maxRepsDominadas;

    private Usuario() {

    }

    /**
     * Este método crea un usuario a partir del contenido de linea.
     *
     * @param linea contiene los datos necesarios para crear un usuario (nombreUsuario, contrasena, nombre, edad,
     *              maxRepsFlexiones y maxRepsDominadas).
     * @return un objeto de tipo Usuario.
     */

    public static Usuario crearUsuario(String linea) {
        Usuario u = new Usuario();
        String[] lineaUsuario = linea.split(ArchivoDeTextoControlador.SEPARADOR);

        u.nombreUsuario = lineaUsuario[0];
        u.contrasena = lineaUsuario[1];
        u.nombre = lineaUsuario[2];
        u.edad = Integer.parseInt(lineaUsuario[3]);
        u.maxRepsFlexiones = lineaUsuario.length == 4 ? 0 : Integer.parseInt(lineaUsuario[4]);
        u.maxRepsDominadas = lineaUsuario.length == 4 ? 0 : Integer.parseInt(lineaUsuario[5]);

        return u;
    }

    /**
     * Este método junta todos los atributos de un usuario en un String.
     *
     * @return un String con los atributos de un usuario separados por un separador específicado.
     */

    public String generarEntradaUsuario() {
        return String.join(ArchivoDeTextoControlador.SEPARADOR, nombreUsuario,
                contrasena, nombre, String.valueOf(edad), String.valueOf(maxRepsFlexiones),
                String.valueOf(maxRepsDominadas));
    }

    /**
     * Este método permite obtener el nombre de la persona registrada.
     *
     * @return un String con el nombre de la persona registrada.
     */

    public String getNombre() {
        return this.nombre;
    }

    /**
     * Este método permite obtener la edad de la persona registrada.
     *
     * @return un int con la edad del usuario.
     */

    public int getEdad() {
        return this.edad;
    }

    /**
     * Este método permite obtener el máximo de repeticiones de flexiones del usuario.
     *
     * @return un int con el máximo de repeticiones de flexiones del usuario.
     */

    public int getMaxRepsFlexiones() {
        return this.maxRepsFlexiones;
    }

    /**
     * Este método permite obtener el máximo de repeticiones de dominadas del usuario.
     *
     * @return un int con el máximo de repeticiones de dominadas del usuario.
     */

    public int getMaxRepsDominadas() {
        return this.maxRepsDominadas;
    }

    /**
     * Este método permite obtener la contrasena del usuario.
     *
     * @return un String con la contrasena del usuario.
     */

    public String getContrasena() {
        return contrasena;
    }

    /**
     * Este método permite obtener el nombre de usuario.
     *
     * @return un String con el nombre de usuario.
     */

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Este método permite establecer el máximo de repeticiones de flexiones de brazos de un usuario.
     *
     * @param maxRepsFlexiones es el máximo de repeticiones de flexiones de brazos de un usuario.
     */

    public void setMaxRepsFlexiones(int maxRepsFlexiones) {
        this.maxRepsFlexiones = maxRepsFlexiones;
    }

    /**
     * Este método permite establecer el máximo de repeticiones de dominadas de un usuario.
     *
     * @param maxRepsDominadas es el máximo de repeticiones de dominadas de un usuario.
     */

    public void setMaxRepsDominadas(int maxRepsDominadas) {
        this.maxRepsDominadas = maxRepsDominadas;
    }
}
