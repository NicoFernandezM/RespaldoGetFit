package gui;

import controlador.ArchivoDeTextoControlador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es la ventana que nos muestra los datos del usuario (nombre, edad, y máximas repeticiones en
 * flexiones y dominadas) y además nos da la opción de cerrar la sesión.
 * @author Nicolás Fernández
 */

public class VentanaPerfil extends Ventana implements ActionListener {
    private JButton regresar;
    private JButton cerrarSesion;

    private final String fuente = "Sabon Next LT";
    private final int tamañoFuente = 15;

    private Usuario usuarioEnSesion = ArchivoDeTextoControlador.getInstancia().getUsuarioEnSesion();

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton y JLabel.
     */

    public VentanaPerfil() {
        inicializarComponentes();
    }

    /**
     * Este método llama a los métodos que generan los JButton y JLabel.
     */

    private void inicializarComponentes() {
        generarBotones();
        generarEtiquetas();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        regresar = this.generarBoton("<--", 20, 15, 50, 30);
        regresar.addActionListener(this);

        cerrarSesion = this.generarBoton("Cerrar sesión", 20, 500, 150, 30);
        cerrarSesion.addActionListener(this);
    }

    /**
     * Este método genera los JLabel de la ventana.
     */

    private void generarEtiquetas() {
        this.generarEtiqueta("Nombre: " + usuarioEnSesion.getNombre(), 20, 300, 380, 20,
                this.fuente, this.tamañoFuente);

        this.generarEtiqueta("Edad: " + usuarioEnSesion.getEdad(), 20, 340, 380, 20,
                this.fuente, this.tamañoFuente);

        this.generarEtiqueta("Máx. flexiones: " + usuarioEnSesion.getMaxRepsFlexiones(),
                20, 380, 150, 20, this.fuente, this.tamañoFuente);

        this.generarEtiqueta("Máx. dominadas: " + usuarioEnSesion.getMaxRepsDominadas(),
                20, 420, 150, 20, this.fuente, this.tamañoFuente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == regresar) {
            new VentanaPrincipal();
            this.dispose();
        } else {
            new VentanaLogin();
            this.dispose();
        }
    }
}
