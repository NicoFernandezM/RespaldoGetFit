package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends Ventana implements ActionListener {
    private JButton iniciarSesionBtn;
    private JButton registrarseBtn;

    public VentanaLogin() {
        this.generarEtiqueta("GetFit", 155, 100, 150,80, "Forte", 30);
        generarBotones();
    }

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
