package gui;

import controlador.ArchivoDeTextoControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Esta clase es la ventana que contiene la opción de ingresar el máximo de dominadas para eventualmente mostrar
 * la rutina. También contiene la opción de ver videos explicativos.
 * @author Nicolás Fernández
 */

public class VentanaDominadas extends Ventana implements ItemListener, ActionListener {
    private JComboBox numeroDeDominadas;

    private JButton mostrarVideoBtn;
    private JButton aceptarBtn;
    private JButton regresarBtn;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton y JComboBox. De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaDominadas () {
        inicializarComponentes();
        this.generarEtiqueta("Ingrese su máximo de repeticiones.",
                35, 100, 430,80, "Impact", 20);
    }

    /**
     * Este método llama a los métodos que generan los JButton y JComboBox.
     */

    private void inicializarComponentes() {
        generarBotones();
        generarComboBox();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        mostrarVideoBtn = this.generarBoton("Ver video explicativo.", 100, 15, 270, 30);
        mostrarVideoBtn.addActionListener(this);

        aceptarBtn = this.generarBoton("Aceptar", 125, 300, 150, 80);
        aceptarBtn.addActionListener(this);

        regresarBtn = this.generarBoton("<--", 20, 15, 50, 30);
        regresarBtn.addActionListener(this);
    }

    /**
     * Este método genera el JComboBox de la ventana y le agrega el ItemListener
     */

    private void generarComboBox() {
        numeroDeDominadas = this.generarComboBox(4, 30, 125, 220, 150, 30);
        numeroDeDominadas.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //int maxDominadas = ArchivoDeTextoControlador.getInstancia().getUsuarioEnSesion().getMaxRepsDominadas();
        ArchivoDeTextoControlador.getInstancia().editarUsuario(20, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aceptarBtn) {
            //Mostrar tabla gonzalo
        } else if(e.getSource() == regresarBtn) {
            this.dispose();
            new VentanaPrincipal();
        } else if(e.getSource() == mostrarVideoBtn) {
            this.dispose();
            //new VentanaVideosDominadas();
        }
    }


}
