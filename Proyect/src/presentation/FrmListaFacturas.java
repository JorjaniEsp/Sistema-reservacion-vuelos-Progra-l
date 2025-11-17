package presentation;

import domain.Reservacion;
import logic.SistemaReservacion;

import javax.swing.*;
import java.util.List;

public class FrmListaFacturas extends JFrame {
    
    private final SistemaReservacion sistema;
    private JTextArea txtLista;

    public FrmListaFacturas(SistemaReservacion sistema) {
        this.sistema = sistema;
        initComponents();
        cargarFacturas();
    }

    private void initComponents() {
        setTitle("Lista de Facturas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel lblTitulo = new JLabel("Facturas emitidas en la sesión");
        lblTitulo.setBounds(20, 10, 300, 25);
        panel.add(lblTitulo);

        txtLista = new JTextArea();
        txtLista.setEditable(false);
        txtLista.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(txtLista);
        scroll.setBounds(20, 40, 550, 300);
        panel.add(scroll);
    }

    private void cargarFacturas() {
        List<Reservacion> reservaciones = sistema.listarReservaciones();
        if (reservaciones.isEmpty()) {
            txtLista.setText("No se han generado facturas en esta sesión.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Reservacion r : reservaciones) {
            if (r.getMiFactura() != null) {
                sb.append(r.getMiFactura().mostrar()).append("\n");
            }
        }

        if (sb.length() == 0) {
            txtLista.setText("No hay facturas asociadas a las reservaciones.");
        } else {
            txtLista.setText(sb.toString());
        }
    }
    
}
