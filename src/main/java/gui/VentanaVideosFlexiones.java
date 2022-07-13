package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es una ventana que contiene un video explicativo de como hacer las flexiones y presenta la opción de
 * volver a la ventana de flexiones o mostrar otro video.
 * @author Juan Villagrán.
 */

public class VentanaVideosFlexiones extends Ventana implements ActionListener {

    private JButton siguienteBtn;
    private JButton volverBtn;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton, JLabel y gif's. De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaVideosFlexiones() {
        this.generarEtiqueta("Flexiones", 130, 20, 300,40, "Forte", 30);
        inicializarcomponentes();
    }

    /**
     * Este método llama a los métodos que generan los JButton y JLabel y gif's.
     */

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        this.generarLabelConGif("gif\\Flexiones1.gif", 25, -25, 400, 400);
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        siguienteBtn = this.generarBoton("Siguiente", 250, 500, 100, 30);
        volverBtn = this.generarBoton("Volver", 50, 500, 100, 30);

        siguienteBtn.addActionListener(this);
        volverBtn.addActionListener(this);
    }

    /**
     * Este método genera el JTextArea que contiene el texto explicativo de como hacer una dominada.
     */

    private void generarEtiquetas() {
        String texto = """
                Para empezar a hacer push-ups lo primero es colocar las manos 
                en el suelo a una distancia ligeramente más amplia que el 
                ancho de tus hombros. Pon los brazos en línea recta desde tu 
                pecho hasta el suelo. Dependiendo de tu fuerza y experiencia, 
                tus manos deben estar en una posición de que te resulte cómoda 
                (si rectas o un poco dobladas hacia dentro o fuera).
                Tu cabeza debe mirar un poco hacia delante, no hacia abajo.
                En la parte superior de tu flexión, tus brazos deben estar 
                rectos y soportar tu peso.\s
                Para hacer el movimiento de flexión, baja constantemente hasta
                que los codos estén en un ángulo de 90 grados o menos.
                Lo ideal sería bajar hasta que el pecho toque el suelo, pero 
                esto cuesta práctica y debes adaptarte a tu nivel.""";

        this.generarAreaDeTexto(texto,15, 280,355, 210, "times roman", 12);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == siguienteBtn) {
            this.dispose();
            new VentanaVideosFlexiones2();
        } else if(e.getSource() == volverBtn) {
            this.dispose();
            new VentanaFlexiones();
        }
    }
}