package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es la ventana principal de la aplicación. Tiene 3 botones que dan la opción de ir a la ventana
 * de dominadas, flexiones o perfil.
 * @author Nicolás Fernández
 */

public class VentanaPrincipal extends Ventana implements ActionListener {
    private JButton flexiones;
    private JButton dominadas;
    private JButton perfil;

    /**
     * El constructor de esta clase llama al método que genera los JButton de esta ventana.
     * De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaPrincipal () {
        this.generarEtiqueta("GetFit", 155, 100, 150,80, "Forte", 30);
        generarBotones();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        flexiones = this.generarBoton("Flexiones", 125, 200, 150, 80);
        dominadas = this.generarBoton("Dominadas",125, 300, 150, 80);
        perfil = this.generarBoton("P", 25, 25, 50, 50);

        flexiones.addActionListener(this);
        dominadas.addActionListener(this);
        perfil.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == flexiones) {
            new VentanaFlexiones();
            this.dispose();
        } else if(e.getSource() == dominadas) {
            new VentanaDominadas();
            this.dispose();
        } else {
            new VentanaPerfil();
            this.dispose();
        }
    }
}

