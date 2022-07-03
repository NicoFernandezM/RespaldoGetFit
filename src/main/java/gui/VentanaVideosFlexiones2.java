package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVideosFlexiones2 extends Ventana implements ActionListener{

    private JButton volverBtn;

    public VentanaVideosFlexiones2() {
        inicializarcomponentes();
    }

    public void inicializarcomponentes() {
        generarBotones();
        generarEtiquetas();
        this.generarLabelConGif("gif\\Flexiones2.gif",-40, -80, 450, 400);
    }

    private void generarBotones() {
        volverBtn = this.generarBoton("Volver", 140, 500, 100, 30);
        volverBtn.addActionListener(this);
    }

    private void generarEtiquetas() {
        String texto = """
                Para empezar a hacer push-ups lo primero es colocar las manos 
                El respirar correctamente mantiene de un ritmo apropiado 
                permite la oxigenación de los músculos más activados.
                En las flexiones, la toma y expulsión del aire es inhalar al 
                bajar, exhalar al subir. Asimismo, la posición de la cabeza es 
                clave; debe estar en línea recta y sin presión, alineada con la 
                columna. Jamás se ha de pegar la barbilla al pecho, ni tampoco
                hay que elevarla.
                El secreto está en sostener el cuerpo recto lo mejor que se
                pueda. De la misma forma, hay que asegurar que la tensión 
                se centre en la zona abdominal.
                Las manos tienen que estar a la altura de los hombros, con las
                 palmas extendidas.\s
                El tronco debe quedar recto en todo momento,  similar a la 
                posición de plancha. Las piernas también deben estar derechas, 
                con una separación mínima entre los pies.\s""";

        this.generarAreaDeTexto(texto,15, 240,355, 260, "times roman", 12);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volverBtn) {
            this.dispose();
            new VentanaVideosFlexiones();
        }
    }
}