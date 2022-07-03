package gui;

import javax.swing.*;
import java.awt.*;

/**
 *Esta clase abstracta sirve de padre para todas las ventanas en el programa.
 * @author Nicolás Fernández
 */

public abstract class Ventana extends JFrame {
    /**
     * El constructor establece las características por default que deben tener todas las ventanas.
     * Por ejemplo que se termine el proceso al presionar la "x", que no se pueda redimensionar, que se cree
     * en el centro de la pantalla y que sea visible. Se define también el tamaño, titulo y el layout.
     */
    public Ventana() {
        this.setLayout(null);
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("GetFit");
    }

    /**
     * Este método genera un JTextField y lo agrega a la ventana que lo esté llamando.
     * @param x Es la posición en "x" en que se creará el JTextField de la ventana.
     * @param y Es la posición en "y" en que se creará el JTextField de la ventana.
     * @param ancho Es el ancho que tendrá el JTextField.
     * @param alto Es el alto que tendrá el JTextField.
     * @return El JTextField (ya agregado a la ventana) con las posiciones y dimensiones indicadas.
     */

    protected JTextField generarCampoDeTexto(int x, int y, int ancho, int alto) {
        JTextField campoDeTexto = new JTextField();
        this.add(campoDeTexto);
        campoDeTexto.setBounds(x, y, ancho, alto);
        campoDeTexto.setVisible(true);
        return campoDeTexto;
    }

    /**
     * Este método genera un JPasswordField y lo agrega a la ventana que lo esté llamando.
     * @param x Es la posición en "x" en que se creará el JPasswordField dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JPasswordField dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JPasswordField.
     * @param alto Es el alto que tendrá el JPasswordField.
     * @return El JPasswordField para contraseña (ya agregado a la ventana) con las posiciones y dimensiones indicadas.
     */

    protected JPasswordField generarCampoDeTextoContraseña(int x, int y, int ancho, int alto) {
        JPasswordField campoDeTexto = new JPasswordField();
        this.add(campoDeTexto);
        campoDeTexto.setBounds(x, y, ancho, alto);
        campoDeTexto.setVisible(true);
        return campoDeTexto;
    }

    /**
     * Este método genera un JButton y lo agrega a la ventana que lo esté llamando.
     * @param texto Es el texto que tendrá el JButton.
     * @param x Es la posición en "x" en que se creará el JButton dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JButton dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JButton.
     * @param alto Es el alto que tendrá el JButton.
     * @return El JButton (ya agregado a la ventana) con el texto, las posiciones y dimensiones indicadas.
     */

    protected JButton generarBoton(String texto, int x, int y, int ancho, int alto) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        this.add(boton);

        return boton;
    }

    /**
     * Este método genera un JButton y lo agrega a la ventana que lo esté llamando.
     * @param x Es la posición en "x" en que se creará el JButton dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JButton dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JButton.
     * @param alto Es el alto que tendrá el JButton.
     * @return El JButton (ya agregado a la ventana) con las posiciones y dimensiones indicadas.
     */

    protected JButton generarBoton(int x, int y, int ancho, int alto) {
        JButton boton = new JButton();
        boton.setBounds(x, y, ancho, alto);
        this.add(boton);

        return boton;
    }

    /**
     * Este método genera un JLabel y lo agrega a la ventana que lo esté llamando.
     * @param texto Es el texto que tendrá el JLabel.
     * @param x Es la posición en "x" en que se creará el JLabel dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JLabel dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JLabel.
     * @param alto Es el alto que tendrá el JLabel.
     * @param fuente Es el nombre de la fuente que tendrá el JLabel.
     * @param tamaño Es el tamaño de la fuente que tendrá el JLabel.
     * @return El JLabel (ya agregado a la ventana) con el texto, fuente, posiciones y dimensiones indicadas.
     */

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int alto, String fuente, int tamaño) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, alto);
        Font font = new Font(fuente, Font.BOLD, tamaño);
        etiqueta.setFont(font);
        this.add(etiqueta);
        return etiqueta;
    }

    /**
     * Este método genera un JTextArea y lo agrega a la ventana que lo esté llamando.
     * @param texto Es el texto que tendrá el JTextArea.
     * @param x Es la posición en "x" en que se creará el JTextArea dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JTextArea dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JTextArea.
     * @param alto Es el alto que tendrá el JTextArea.
     * @param fuente Es el nombre de la fuente que tendrá el JTextArea.
     * @param tamaño Es el tamaño de la fuente que tendrá el JTextArea.
     * @return El JTextArea (ya agregado a la ventana) con el texto, fuente, posiciones y dimensiones indicadas.
     */

    protected JTextArea generarAreaDeTexto (String texto, int x, int y, int ancho, int alto, String fuente, int tamaño) {
        JTextArea areaDeTexto = new JTextArea(texto);

        areaDeTexto.setBounds(x, y, ancho, alto);
        Font font = new Font(fuente, Font.BOLD, tamaño);
        areaDeTexto.setFont(font);
        areaDeTexto.setEditable(false);
        this.add(areaDeTexto);

        return areaDeTexto;
    }

    /**
     * Este método genera un JLabel con un gif dentro y lo agrega a la ventana que lo esté llamando.
     * @param direccion Es la dirección en la que se encuentra el gif que se quiere utilizar.
     * @param x Es la posición en "x" en que se creará el JLabel dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JLabel dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JLabel.
     * @param alto Es el alto que tendrá el JLabel.
     * @return El JLabel (ya agregado a la ventana) con el gif, posiciones y dimensiones indicadas.
     */

    protected JLabel generarLabelConGif(String direccion, int x, int y, int ancho, int alto) {
        ImageIcon imageIcon = new ImageIcon(direccion);
        Icon icon = new ImageIcon(String.valueOf(imageIcon));

        JLabel gif = new JLabel();
        gif.setIcon(icon);
        gif.setLayout(null);
        gif.setBounds(x, y, ancho, alto);

        return gif;
    }

    /**
     * Este método genera un JLabel y lo agrega a la ventana que lo esté llamando.
     * @param texto Es el texto que tendrá el JLabel.
     * @param x Es la posición en "x" en que se creará el JLabel dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JLabel dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JLabel.
     * @param alto Es el alto que tendrá el JLabel.
     * @return El JLabel (ya agregado a la ventana) con el texto, posiciones y dimensiones indicadas.
     */

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int alto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, alto);
        this.add(etiqueta);
        return etiqueta;
    }

    /**
     * Este método genera un JComboBox y lo agrega a la ventana que lo esté llamando.
     * @param minReps Es el menor número que tendrá el JComboBox.
     * @param maxReps Es el mayor número que tendrá el JComboBox.
     * @param x Es la posición en "x" en que se creará el JComboBox dentro de la ventana.
     * @param y Es la posición en "y" en que se creará el JComboBox dentro de la ventana.
     * @param ancho Es el ancho que tendrá el JComboBox.
     * @param alto Es el alto que tendrá el JComboBox.
     * @return El JComboBox (ya agregado a la ventana) relleno con los números desde el mínimo hasta el máximo
     * con las posiciones y dimensiones indicadas.
     */

    protected JComboBox generarComboBox(int minReps, int maxReps, int x, int y, int ancho, int alto) {
        JComboBox <String> comboBox = new JComboBox<String>();
        comboBox.setBounds(x,y,ancho,alto);
        int numeroDeReps = maxReps - minReps + 1;
        String[] numeros = new String[numeroDeReps];

        for (int i = minReps; i <= maxReps; i++) {
            numeros[i - minReps] = String.valueOf(i);
            comboBox.addItem(numeros[i - minReps]);
        }

        this.add(comboBox);

        return comboBox;
    }
}
