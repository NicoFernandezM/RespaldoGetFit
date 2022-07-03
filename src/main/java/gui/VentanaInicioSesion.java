package gui;

import controlador.ArchivoDeTextoControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Esta clase es la ventana que muestra los componenetes necesarios para iniciar sesión.
 * @author Nicolás Fernández
 */

public class VentanaInicioSesion extends Ventana implements ActionListener {
    private JButton iniciarSesionBtn;
    private JButton regresarBtn;

    protected final String fuente = "Sabon Next LT";
    protected final int tamanoFuente = 10;

    private JTextField usuario;
    private JPasswordField contrasena;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton, JLabel y JTextField.
     */

    public VentanaInicioSesion() {
        inicializarComponentes();
    }

    /**
     * Este método llama a los métodos que generan los JButton, JLabel y JTextField.
     */

    private void inicializarComponentes() {
        generarBotones();
        generarEtiquetas();
        generarCamposDeTexto();
    }

    /**
     * Este método genera los JButton de la ventana y les agrega el ActionListener.
     */

    private void generarBotones() {
        regresarBtn = this.generarBoton("<--", 20, 15, 50, 30);
        regresarBtn.addActionListener(this);

        iniciarSesionBtn = this.generarBoton("Iniciar sesión", 140, 400, 120, 50);
        iniciarSesionBtn.addActionListener(this);
    }

    /**
     * Este método genera los JTextField de la ventana .
     */

    private void generarCamposDeTexto() {
        this.usuario = this.generarCampoDeTexto(100, 250, 200, 20);
        this.contrasena = this.generarCampoDeTextoContrasena(100, 300, 200, 20);
    }

    /**
     * Este método genera los JLabel de la ventana.
     */

    private void generarEtiquetas() {
        this.generarEtiqueta("Inicio de sesión", 90, 100, 300,80,
                "Forte", 30);

        this.generarEtiqueta("Usuario: ", 20, 250, 70, 20,
                this.fuente, this.tamanoFuente);

        this.generarEtiqueta("Contrasena: ", 20, 300, 70, 20,
                this.fuente, this.tamanoFuente);
    }

    /**
     * Este método obtiene la contrasena del JPasswordField.
     * @return un String con la contrasena sin espacios ni puntuación.
     */
    private String obtenerContrasena() {
        String contrasena = Arrays.toString(this.contrasena.getPassword());

        return String.join(",", contrasena).
                replaceAll("\\p{Punct}", "").replaceAll(" ", "");
    }

    /**
     * Este método verifica que el usuario ingresado corresponda con la contrasena ingresada.
     * @return true si la contrasena ingresada coincide con la contrasena asociada a ese usuario
     * y false en el caso contrario.
     */

    private boolean usuarioValido() {
        return ArchivoDeTextoControlador.getInstancia().validarUsuario(this.usuario.getText(), obtenerContrasena());
    }

    /**
     * Este método abre la ventana principal en caso de que los datos del usuario sean correctos y se muestra
     * un mensaje de advertencia en el caso contrario.
     */

    private void iniciarSesion() {
        if(usuarioValido()) {
            new VentanaPrincipal();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contrasena incorrecta",
                    "Ingreso inválido", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iniciarSesionBtn) {
            iniciarSesion();
        } else if(e.getSource() == regresarBtn) {
            new VentanaLogin();
            this.dispose();
        }
    }
}
