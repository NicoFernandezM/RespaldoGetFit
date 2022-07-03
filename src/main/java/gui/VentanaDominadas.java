package gui;

import controlador.ArchivoDeTextoControlador;
import utils.GetFitMath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es la ventana que contiene la opción de ingresar el máximo de dominadas para eventualmente mostrar
 * la rutina. También contiene la opción de ver videos explicativos.
 * @author Nicolás Fernández
 */

public class VentanaDominadas extends Ventana implements ActionListener {
    private final String fuente = "Sabon Next LT";
    private final int tamanoFuente = 14;

    private JComboBox numeroDeDominadas;

    private JButton mostrarVideoBtn;
    private JButton aceptarBtn;
    private JButton regresarBtn;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton y JComboBox. De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaDominadas () {
        this.generarEtiqueta("Dominadas", 110, 70, 300,40, "Forte", 30);
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
     * Este método genera el JComboBox de la ventana.
     */

    private void generarComboBox() {
        numeroDeDominadas = this.generarComboBox(4, 40, 125, 220, 150, 30);
    }

    /**
     * Este metodo genera el Area de texto de la Ventana destinada a mostrar la rutina.
     */

    private void mostrarRutina(){
        this.generarAreaDeTexto("Recuerde descansar 2 minutos por serie.\n" + ciclo(),
                50,400,300,120,fuente,tamanoFuente);
    }

    /**
     * Este método obtiene la rutina generada por la clase GetFitMath de acuerdo al máximo.
     * @return un String con el número de series y repeticiones.
     */

    private String ciclo() {
        int [] repsPorSerie = GetFitMath.generarRutinaDominadas(obtenerMaximoIngresado());
        String a = "";

        for (int i = 0; i < 4; i++) {

            a += "\n Serie " + (i+1) + ": " +repsPorSerie[i] + " reps." ;
        }

        return a;
    }

    /**
     * Este método actualiza las máximas repeticiones de un usuario en dominadas.
     */

    private void actualizarMaximasReps() {
        int maxRepsFlexiones = ArchivoDeTextoControlador.getInstancia().getUsuarioEnSesion().getMaxRepsFlexiones();
        int maxRepsDominadas = obtenerMaximoIngresado();

        ArchivoDeTextoControlador.getInstancia().editarUsuario(maxRepsFlexiones, maxRepsDominadas);
    }

    /**
     * Este método obtiene el máximo ingresado por el usuario en el JComboBox.
     * @return un int que representa el máximo ingresado por el usuario.
     */

    private int obtenerMaximoIngresado() {
        return Integer.parseInt(numeroDeDominadas.getSelectedItem().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aceptarBtn) {
            actualizarMaximasReps();
            mostrarRutina();
        } else if(e.getSource() == regresarBtn) {
            this.dispose();
            new VentanaPrincipal();
        } else if(e.getSource() == mostrarVideoBtn) {
            this.dispose();
            new VentanaVideosDominadas();
        }
    }


}
