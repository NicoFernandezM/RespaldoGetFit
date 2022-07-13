package gui;

import controlador.ArchivoDeTextoControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

/**
 * Esta clase es la ventana que muestra los componentes necesarios para registrar un nuevo usuario.
 * @author Nicolás Fernández
 */

public class VentanaRegistroUsuario extends Ventana implements ActionListener {
    private JButton registrarBtn;
    private JButton regresarBtn;

    private final String fuente = "Sabon Next LT";
    private final int tamanoFuente = 10;

    private JTextField nombre;
    private JTextField apellido;
    private JTextField usuario;
    private JPasswordField contrasena;
    private JTextField edad;

    /**
     * El constructor de esta clase llama al método que inicializa los componentes que se muestran en esta ventana,
     * tales como JButton, JLabel y JTextField.
     */

    public VentanaRegistroUsuario() {
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

        registrarBtn = this.generarBoton("Registrar", 150, 400, 100, 50);
        registrarBtn.addActionListener(this);
    }

    /**
     * Este método genera los JTextField de la ventana .
     */

    private void generarCamposDeTexto() {
        this.nombre = this.generarCampoDeTexto(100, 150, 200, 20);
        this.apellido = this.generarCampoDeTexto(100, 200, 200, 20);
        this.usuario = this.generarCampoDeTexto(100, 250, 200, 20);
        this.contrasena = this.generarCampoDeTextoContrasena(100, 300, 200, 20);
        this.edad = this.generarCampoDeTexto(100, 350, 200, 20);
    }

    /**
     * Este método genera los JLabel de la ventana.
     */

    private void generarEtiquetas() {
        this.generarEtiqueta("Registrar", 130, 50, 150,80, "Forte", 35);

        this.generarEtiqueta("Nombre: ", 20, 150, 70, 20,
                this.fuente, this.tamanoFuente);

        this.generarEtiqueta("Apellido: ", 20, 200, 70, 20,
                this.fuente, this.tamanoFuente);

        this.generarEtiqueta("Usuario: ", 20, 250, 70, 20,
                this.fuente, this.tamanoFuente);

        this.generarEtiqueta("Contrasena: ", 20, 300, 70, 20,
                this.fuente, this.tamanoFuente);

        this.generarEtiqueta("Edad: ", 20, 350, 70, 20,
                this.fuente, this.tamanoFuente);
    }

    /**
     * Este método verifica que las entradas sean validas.
     * @return true si el nombre y la edad son válidos y si ninguna entrada está vacía.
     * En caso contrario retorna false.
     */
    private boolean entradasValidas() {
        return (nombreValido() && !entradasVacias() && edadValida());
    }

    /**
     * Este método verifica que el nombre contenga solo letras.
     * @return true si el nombre contiene solo letras y false en caso contrario.
     */

    private boolean nombreValido() {
        String nombre = unirNombreYApellido().replaceAll(" ","");
        return (nombre.matches("[a-zA-Z]+"));
    }

    /**
     * Este método une el nombre y apellido en un solo String.
     * @return un String con el nombre y apellido separados por un espacio.
     */
    private String unirNombreYApellido() {
        return this.nombre.getText().replaceAll(" ","") + " " +
                this.apellido.getText().replaceAll(" ","");
    }

    /**
     * Este método valida si hay algun JTextfield vacío.
     * @return true si por lo menos un JTextField está vacío y false si es que ninguno está vacío.
     */

    private boolean entradasVacias() {
        return (this.nombre.getText().isEmpty() || this.apellido.getText().isEmpty() ||
                this.usuario.getText().isEmpty() || obtenerContrasena().isEmpty() ||
                this.edad.getText().isEmpty());
    }

    /**
     * Este método obtiene texto del JTextField correspondiente al usuario
     * @return el texto del JTextField del usuario sin espacios.
     */

    private String obtenerUsuario() {
        return this.usuario.getText().replaceAll(" ","");
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
     * Este método verifica que la edad sea válida.
     * @return true si el JTextField correspondiente a la edad tiene un número entre 5 y 100 y false en caso contrario.
     */

    private boolean edadValida() {
        try {
            int edad = Integer.parseInt(this.edad.getText());
            return edad < 100 && edad > 5;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Este método establece el texto de todos los JTextField a un espacio en blanco.
     */

    private void limpiarTextField() {
        nombre.setText("");
        apellido.setText("");
        usuario.setText("");
        contrasena.setText("");
        edad.setText("");
    }

    /**
     * Este método verifica que el nombre ingresado en el JTextField de usuario existe.
     * @return true si el usuario existe y false en caso contrario.
     */

    private boolean usuarioExiste() {
        ArchivoDeTextoControlador c = ArchivoDeTextoControlador.getInstancia();
        return c.buscarUsuarioSiExiste(this.usuario.getText()) != null;
    }

    /**
     * Este método intenta registrar un usuario en caso de que no exista previamente y que las entradas sean
     * válidas para posteriormente mostrar la ventana principal. Si las entradas no son validas o el usuario ya existe,
     * se muestra un mensaje de advertencia. Puede ocurrir un error al tratar de hacer lo anterior, y en ese caso
     * muestra un mensaje informando que algo falló.
     */

    private void registrarUsuario() {
        ArchivoDeTextoControlador controlador = ArchivoDeTextoControlador.getInstancia();

        try {
            if(!usuarioExiste() && entradasValidas()) {
                controlador.registrarUsuario(obtenerUsuario(), obtenerContrasena(),
                        unirNombreYApellido(), Integer.parseInt(this.edad.getText()));

                new VentanaPrincipal();
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(this, "Entradas inválidas",
                        "Ingreso inválido", JOptionPane.WARNING_MESSAGE);
                limpiarTextField();
            }
        } catch (IOException ex) {
            ex.printStackTrace();

            JOptionPane.showMessageDialog(this, "Algo falló",
                    "Error", JOptionPane.ERROR_MESSAGE);
            limpiarTextField();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registrarBtn) {
            registrarUsuario();

        } else if (e.getSource() == regresarBtn) {
            this.dispose();
            new VentanaLogin();
        }
    }
}
