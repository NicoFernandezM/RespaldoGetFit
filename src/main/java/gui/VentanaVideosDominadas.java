package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaVideosDominadas extends Ventana implements ActionListener{

    private JButton siguienteBtn;
    private JButton volverBtn;

    public VentanaVideosDominadas() {
        this.generarEtiqueta("Dominadas", 120, 10, 300,40, "Forte", 30);
        inicializarcomponentes();
    }

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        generarGIF();
    }

    private void generarBotones() {
        siguienteBtn = this.generarBoton("Siguiente", 250, 520, 100, 30);
        volverBtn = this.generarBoton("Volver", 50, 520, 100, 30);

        siguienteBtn.addActionListener(this);
        volverBtn.addActionListener(this);
    }
    private void generarGIF() {
        this.generarLabelConGif("gif\\Dominadas1.gif", -50, 40, 700, 280);
    }

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