
package presentation;

import java.awt.*;
import javax.swing.*;

public class FrmInicio extends JFrame{
     private JButton btnEntrar;
    private JButton btnSalir;

    public FrmInicio() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Reservación de Vuelos");
        setSize(520, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(235, 243, 250)); 
        setContentPane(panel);

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(25, 118, 210)); 
        header.setBounds(0, 0, 520, 70);
        panel.add(header);

        JLabel lblTitulo = new JLabel("Simulador de Reservación de Vuelos");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 20, 500, 30);
        header.add(lblTitulo);

        JLabel lblSub = new JLabel("Agencia de vuelos");
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSub.setHorizontalAlignment(SwingConstants.CENTER);
        lblSub.setBounds(40, 90, 440, 25);
        panel.add(lblSub);

        JLabel lblTexto = new JLabel(
                "<html><div style='text-align:center;'>"
                + "Bienvenid@ al sistema de simulación de reservación de vuelos.<br>"
                + "Desde aquí podrás buscar vuelos, generar tiquetes y facturas."
                + "</div></html>"
        );
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lblTexto.setBounds(40, 120, 440, 50);
        panel.add(lblTexto);

        JLabel lblAvion = new JLabel("✈");
        lblAvion.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 42));
        lblAvion.setHorizontalAlignment(SwingConstants.CENTER);
        lblAvion.setBounds(230, 165, 60, 50);
        panel.add(lblAvion);

        btnEntrar = new JButton("Iniciar simulación");
        btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEntrar.setBounds(120, 230, 160, 35);
        panel.add(btnEntrar);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setBounds(300, 230, 100, 35);
        panel.add(btnSalir);

        btnEntrar.addActionListener(e -> {
            new FmrMenuPrincipal().setVisible(true);
            dispose();
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { }

        SwingUtilities.invokeLater(() -> new FrmInicio().setVisible(true));
    }
    
}
