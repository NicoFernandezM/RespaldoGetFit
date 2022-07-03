package modelo;

import controlador.ArchivoDeTextoControlador;

/**
 * Esta clase es la que representa un usuario en la aplicación.
 * @author Nicolás Fernández
 */
public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String nombre;
    private int edad;
    private int maxRepsFlexiones;
    private int maxRepsDominadas;

    private Usuario() {

    }

    public static Usuario crearUsuario(String linea) {
        Usuario u = new Usuario();
        String [] lineaUsuario = linea.split(ArchivoDeTextoControlador.SEPARADOR);

        u.nombreUsuario = lineaUsuario[0];
        u.contraseña = lineaUsuario[1];
        u.nombre = lineaUsuario[2];
        u.edad = Integer.parseInt(lineaUsuario[3]);
        u.maxRepsFlexiones = lineaUsuario.length == 4 ? 0 : Integer.parseInt(lineaUsuario[4]);
        u.maxRepsDominadas = lineaUsuario.length == 4 ? 0 : Integer.parseInt(lineaUsuario[5]);

        return u;
    }

    public String generarEntradaUsuario() {
        return String.join(ArchivoDeTextoControlador.SEPARADOR, nombreUsuario,
                contraseña, nombre, String.valueOf(edad), String.valueOf(maxRepsFlexiones),
                String.valueOf(maxRepsDominadas));
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getMaxRepsFlexiones() {
        return this.maxRepsFlexiones;
    }

    public int getMaxRepsDominadas() {
        return this.maxRepsDominadas;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setMaxRepsFlexiones(int maxRepsFlexiones) {
        this.maxRepsFlexiones = maxRepsFlexiones;
    }

    public void setMaxRepsDominadas(int maxRepsDominadas) {
        this.maxRepsDominadas = maxRepsDominadas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
