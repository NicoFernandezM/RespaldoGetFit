package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es una ventana que contiene un video explicativo de como hacer las dominadas y presenta la opción de
 * volver a la ventana VentanaVideosDominadas.
 * @author Juan Villagrán.
 */

public class VentanaVideosDominadas2 extends Ventana implements ActionListener{

    private JButton volverBtn;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton, JLabel y gif's.
     */

    public VentanaVideosDominadas2() {
        inicializarcomponentes();
    }

    /**
     * Este método llama a los métodos que generan los JButton y JLabel y gif's.
     */

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        this.generarLabelConGif("gif\\Dominadas2.gif", 0, 5, 400, 350);
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        volverBtn = this.generarBoton("Volver", 150, 522, 100, 30);
        volverBtn.addActionListener(this);
    }

    /**
     * Este método genera el JTextArea que contiene el texto explicativo de como hacer una dominada.
     */

    private void generarEtiquetas() {
        String texto = """
                Coloca los omóplatos hacia abajo y hacia atrás al tiempo que activas
                Si quieres conseguir un buen rendimiento y evitar lesiones es muy 
                importante que calientes muy bien ya que se trata de un ejercicio 
                que implica muchos grupos musculares.
                Debes hacer una retracción escapular al hacer dominadas sacar pecho
                y echar los hombros hacia atrás ya que es muy probable que se 
                produzca una lesión si echamos los hombros hacia adelante. Realiza 
                ejercicios de retracción escapular antes de empezar a hacer dominadas.
                No utilices el impulso del cuerpo para elevarte. Intenta mantener tu 
                cuerpo recto. Hay que prestar gran importancia al descenso y hacerlo
                lento y controlado.""";


        this.generarAreaDeTexto(texto,5, 360,370, 152, "Times roman", 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverBtn) {
            this.dispose();
            new VentanaVideosDominadas();
        }
    }
}