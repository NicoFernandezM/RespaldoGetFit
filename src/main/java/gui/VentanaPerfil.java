package gui;

import controlador.ArchivoDeTextoControlador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPerfil extends Ventana implements ActionListener {
    private JButton regresar;
    private JButton cerrarSesion;
    private JLabel nombre;
    private JLabel edad;
    private JLabel maxFlexiones;
    private JLabel maxDominadas;
    protected final String fuente = "Sabon Next LT";
    protected final int tamañoFuente = 15;
    //Está bien esto definido como atributo?
    private Usuario usuarioEnSesion = ArchivoDeTextoControlador.getInstancia().getUsuarioEnSesion();

    public VentanaPerfil() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        generarBotones();
        generarEtiquetas();
    }

    private void generarBotones() {
        regresar = this.generarBoton("<--", 20, 15, 50, 30);
        regresar.addActionListener(this);

        cerrarSesion = this.generarBoton("Cerrar sesión", 20, 500, 150, 30);
        cerrarSesion.addActionListener(this);
    }

    private void generarEtiquetas() {
        nombre = this.generarEtiqueta("Nombre: " + usuarioEnSesion.getNombre(), 20, 300, 380, 20,
                this.fuente, this.tamañoFuente);
        edad = this.generarEtiqueta("Edad: " + usuarioEnSesion.getEdad(), 20, 340, 380, 20,
                this.fuente, this.tamañoFuente);
        maxFlexiones = this.generarEtiqueta("Máx. flexiones: " + usuarioEnSesion.getMaxRepsFlexiones(),
                20, 380, 150, 20, this.fuente, this.tamañoFuente);
        maxDominadas = this.generarEtiqueta("Máx. dominadas: " + usuarioEnSesion.getMaxRepsDominadas(),
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
