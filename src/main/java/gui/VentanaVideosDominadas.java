package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es una ventana que contiene un video explicativo de como hacer las dominadas y presenta la opción de
 * volver a la ventana de dominadas o mostrar otro video.
 * @author Juan Villagrán.
 */

public class VentanaVideosDominadas extends Ventana implements ActionListener{

    private JButton siguienteBtn;
    private JButton volverBtn;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton, JLabel y gif's. De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaVideosDominadas() {
        this.generarEtiqueta("Dominadas", 120, 10, 300,40, "Forte", 30);
        inicializarcomponentes();
    }

    /**
     * Este método llama a los métodos que generan los JButton y JLabel y gif's.
     */

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        generarGIF();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        siguienteBtn = this.generarBoton("Siguiente", 250, 520, 100, 30);
        volverBtn = this.generarBoton("Volver", 50, 520, 100, 30);

        siguienteBtn.addActionListener(this);
        volverBtn.addActionListener(this);
    }

    /**
     * Este método genera un JLabel con un gif dentro y lo agrega a la ventana.
     */

    private void generarGIF() {
        this.generarLabelConGif("gif\\Dominadas1.gif", -50, 40, 700, 280);
    }

    /**
     * Este método genera el JTextArea que contiene el texto explicativo de como hacer una dominada.
     */

    private void generarEtiquetas() {
        String texto = """
                Colócate debajo de la barra de dominadas. Agárrala por encima     
                colocando las manos un poco más abiertas que el ancho de los 
                hombros. Mantén las piernas extendidas.
                Coloca los omóplatos hacia abajo y hacia atrás al tiempo que activas
                la espalda, el torso y los glúteos. Empújate hacia arriba hasta 
                llevar la barbilla por encima de la barra. Mientras lo haces, 
                piensa en el movimiento como si llevaras la barra hacia el pecho. 
                Mantén los codos cerca del torso y no arquees la espalda inferior 
                mas de lo natural.
                Baja el cuerpo lentamente para volver a comenzar. Eso sería una
                repetición, vuelve a ajustar la postura de los hombros en cada 
                repetición, llevándolos hacia abajo.""";

        this.generarAreaDeTexto(texto,5, 325,390, 190, "Times roman", 11);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == siguienteBtn) {
            this.dispose();
            new VentanaVideosDominadas2();
        } else if(e.getSource() == volverBtn) {
            this.dispose();
            new VentanaDominadas();
        }
    }
}