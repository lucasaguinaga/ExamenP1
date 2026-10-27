package ec.edu.taller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterfazImpresiones {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Centro de Impresión Universitario");
            interfaz pantalla = new interfaz();
            ventana.setContentPane(pantalla.getPrincipal()); // el panel del .form
            ventana.setSize(650, 550);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}