package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVideosDominadas2 extends Ventana implements ActionListener{

    private JButton volverBtn;

    public VentanaVideosDominadas2() {
        inicializarcomponentes();
    }

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        this.generarLabelConGif("gif\\Dominadas2.gif", 0, 5, 400, 350);
    }

    private void generarBotones() {
        volverBtn = this.generarBoton("Volver", 150, 522, 100, 30);
        volverBtn.addActionListener(this);
    }

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