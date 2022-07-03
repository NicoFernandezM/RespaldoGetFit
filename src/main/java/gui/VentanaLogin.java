package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es la ventana que muestra las opciones de ingresar sesión o registrarse.
 * @author Nicolás Fernández
 */

public class VentanaLogin extends Ventana implements ActionListener {
    private JButton iniciarSesionBtn;
    private JButton registrarseBtn;

    /**
     * El constructor de esta clase llama al método que genera los botones que se muestran en esta ventana.
     * De forma adicional también inicializa un JLabel con el titulo.
     */

    public VentanaLogin() {
        this.generarEtiqueta("GetFit", 155, 100, 150,80, "Forte", 30);
        generarBotones();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        iniciarSesionBtn = this.generarBoton("Iniciar sesión", 100, 200, 200, 80);
        registrarseBtn = this.generarBoton("Registrarse", 100, 300, 200, 80);

        iniciarSesionBtn.addActionListener(this);
        registrarseBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iniciarSesionBtn) {
            new VentanaInicioSesion();
            this.dispose();
        } else if(e.getSource() == registrarseBtn) {
            new VentanaRegistroUsuario();
            this.dispose();
        }
    }
}
