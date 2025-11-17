package presentation;

import domain.*;
import logic.*;

import javax.swing.*;
import java.util.List;

public class FmrMenuPrincipal extends JFrame {

    private final SistemaReservacion sistema;
    private final Gestor gestor;

    private JComboBox<String> cbOrigen;
    private JComboBox<String> cbDestino;

    private JRadioButton rbEjecutiva;
    private JRadioButton rbEconomica;
    private ButtonGroup grupoClase;

    private JTextField txtNombre;
    private JTextField txtIdentificacion;

    private JComboBox<String> cbMetodoPago;

    private JButton btnVerificar;
    private JButton btnGenerar;
    private JButton btnSalir;
    private JButton btnVerTiquetes;
    private JButton btnVerFacturas;

    private JTextArea txtAreaTiquete;
    private JTextArea txtAreaFactura;
    
    private JButton btnLimpiar;   
    private JButton btnCotizar;

    public FmrMenuPrincipal() {
        this.sistema = new SistemaReservacion();
        this.gestor = new Gestor();
        initComponents();
    }

    private void initComponents() {
        setTitle("Simulador de Reservación de Vuelos");
        setSize(720, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel lblOrigen = new JLabel("Origen:");
        lblOrigen.setBounds(20, 20, 60, 25);
        panel.add(lblOrigen);

        cbOrigen = new JComboBox<>(new String[]{"SJO", "MEX"});
        cbOrigen.setBounds(90, 20, 150, 25);
        panel.add(cbOrigen);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(260, 20, 60, 25);
        panel.add(lblDestino);

        cbDestino = new JComboBox<>(new String[]{"MEX", "MIA", "SJO", "PAN"});
        cbDestino.setBounds(330, 20, 150, 25);
        panel.add(cbDestino);

        btnVerificar = new JButton("Verificar Disponibilidad");
        btnVerificar.setBounds(500, 20, 180, 25);
        panel.add(btnVerificar);

        JLabel lblClase = new JLabel("Clase:");
        lblClase.setBounds(20, 60, 60, 25);
        panel.add(lblClase);

        rbEjecutiva = new JRadioButton("Ejecutiva");
        rbEjecutiva.setBounds(80, 60, 100, 25);
        rbEconomica = new JRadioButton("Económica");
        rbEconomica.setBounds(190, 60, 100, 25);
        rbEconomica.setSelected(true);

        grupoClase = new ButtonGroup();
        grupoClase.add(rbEjecutiva);
        grupoClase.add(rbEconomica);

        panel.add(rbEjecutiva);
        panel.add(rbEconomica);

        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setBounds(20, 100, 120, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 100, 330, 25);
        panel.add(txtNombre);

        btnGenerar = new JButton("Generar Tiquete y Factura");
        btnGenerar.setBounds(500, 90, 180, 30);
        panel.add(btnGenerar);
        
        btnCotizar = new JButton("Cotizar"); 
        btnCotizar.setBounds(500, 130, 180, 25);
        panel.add(btnCotizar);

        JLabel lblIdentificacion = new JLabel("Identificación:");
        lblIdentificacion.setBounds(20, 170, 100, 25);
        panel.add(lblIdentificacion);

        txtIdentificacion = new JTextField();
        txtIdentificacion.setBounds(150, 170, 150, 25);
        panel.add(txtIdentificacion);

        JLabel lblMetodoPago = new JLabel("Método de pago:");
        lblMetodoPago.setBounds(320, 170, 110, 25);
        panel.add(lblMetodoPago);

        cbMetodoPago = new JComboBox<>(new String[]{"TARJETA", "EFECTIVO", "TRANSFERENCIA"});
        cbMetodoPago.setBounds(430, 170, 150, 25);
        panel.add(cbMetodoPago);
        
        btnLimpiar = new JButton("Limpiar"); 
        btnLimpiar.setBounds(590, 170, 100, 25);
        panel.add(btnLimpiar);

        JLabel lblTiquete = new JLabel("Tiquete");
        lblTiquete.setBounds(20, 210, 100, 25);
        panel.add(lblTiquete);

        JLabel lblFactura = new JLabel("Factura");
        lblFactura.setBounds(360, 210, 100, 25);
        panel.add(lblFactura);

        txtAreaTiquete = new JTextArea();
        txtAreaTiquete.setEditable(false);
        txtAreaTiquete.setLineWrap(false);
        txtAreaTiquete.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        JScrollPane scrollTiquete = new JScrollPane(txtAreaTiquete);
        scrollTiquete.setBounds(20, 235, 320, 230);
        panel.add(scrollTiquete);

        txtAreaFactura = new JTextArea();
        txtAreaFactura.setEditable(false);
        txtAreaFactura.setLineWrap(false);
        txtAreaFactura.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        JScrollPane scrollFactura = new JScrollPane(txtAreaFactura);
        scrollFactura.setBounds(360, 235, 320, 230);
        panel.add(scrollFactura);

        btnVerTiquetes = new JButton("Ver Tiquetes");
        btnVerTiquetes.setBounds(20, 475, 130, 25);
        panel.add(btnVerTiquetes);

        btnVerFacturas = new JButton("Ver Facturas");
        btnVerFacturas.setBounds(160, 475, 130, 25);
        panel.add(btnVerFacturas);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(580, 475, 100, 25);
        panel.add(btnSalir);

  
        btnVerificar.addActionListener(e -> verificarDisponibilidad());
        btnGenerar.addActionListener(e -> generarTiqueteYFactura());
        btnSalir.addActionListener(e -> System.exit(0));

        btnVerTiquetes.addActionListener(e -> new FrmListaTiquetes(sistema).setVisible(true));
        btnVerFacturas.addActionListener(e -> new FrmListaFacturas(sistema).setVisible(true));
        
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnCotizar.addActionListener(e -> cotizarVuelo());
        
    }

    private void verificarDisponibilidad() {
        String origen = (String) cbOrigen.getSelectedItem();
        String destino = (String) cbDestino.getSelectedItem();
        String fecha = obtenerFechaPorRuta(origen, destino);

        if (fecha == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No hay vuelos configurados para esa ruta.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Clase clase = obtenerClaseSeleccionada();
        if (clase == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una clase.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        List<Vuelo> vuelos = sistema.buscarVuelos(origen, destino, fecha);
        if (vuelos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron vuelos para esa ruta y fecha.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Vuelo vuelo = vuelos.get(0);
        int disponibles = vuelo.disponibles(clase);

        if (disponibles > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Hay " + disponibles + " asientos disponibles en " + clase.name().toLowerCase() + ".",
                    "Disponibilidad",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(this,"No hay asientos disponibles en esa clase.","Sin espacio",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void generarTiqueteYFactura() {
        String origen = (String) cbOrigen.getSelectedItem();
        String destino = (String) cbDestino.getSelectedItem();
        String fecha = obtenerFechaPorRuta(origen, destino);

        if (fecha == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No hay vuelos configurados para esa ruta.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Clase clase = obtenerClaseSeleccionada();
        if (clase == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una clase.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String nombre = txtNombre.getText().trim();
        String idTexto = txtIdentificacion.getText().trim();

        if (nombre.isEmpty() || idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Complete el nombre e identificación.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int cedula;
        try {
            cedula = Integer.parseInt(idTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "La identificación debe ser un número entero.",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        List<Vuelo> vuelos = sistema.buscarVuelos(origen, destino, fecha);
        if (vuelos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron vuelos para esa ruta y fecha.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Vuelo vuelo = vuelos.get(0);

        Pasajero pasajero = new Pasajero(
                cedula,
                nombre,
                "N/D",
                "N/D",
                "N/D"
        );

        String numAsiento = "A" + (sistema.listarReservaciones().size() + 1);

        String metodoSeleccionado = (String) cbMetodoPago.getSelectedItem();
        MetodoPago metodoPago = MetodoPago.valueOf(metodoSeleccionado);

        Reservacion r = sistema.reservar(vuelo, pasajero, clase, numAsiento, metodoPago);

        if (r == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo completar la reservación (sin espacio o error).",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (r.getMiTiquete() != null) {
            txtAreaTiquete.setText(r.getMiTiquete().mostrar());
        } else {
            txtAreaTiquete.setText("No se generó tiquete.");
        }

        if (r.getMiFactura() != null) {
            txtAreaFactura.setText(r.getMiFactura().mostrar());
        } else {
            txtAreaFactura.setText("No se generó factura.");
        }

        boolean guardado = gestor.guardarDocumentosReservacion(r);
        if (guardado) {
            JOptionPane.showMessageDialog(
                    this,
                    "Tiquete y factura guardados en archivos de texto (carpeta data).",
                    "Documentos guardados",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudieron guardar los documentos en archivo.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
     private void cotizarVuelo() {
        String origen = (String) cbOrigen.getSelectedItem();
        String destino = (String) cbDestino.getSelectedItem();
        String fecha = obtenerFechaPorRuta(origen, destino);

        if (fecha == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No hay vuelos configurados para esa ruta.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Clase clase = obtenerClaseSeleccionada();
        if (clase == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una clase.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        List<Vuelo> vuelos = sistema.buscarVuelos(origen, destino, fecha);
        if (vuelos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron vuelos para esa ruta y fecha.",
                    "Sin vuelos",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        Vuelo vuelo = vuelos.get(0);
        double costo = sistema.cotizar(vuelo, clase);

        JOptionPane.showMessageDialog(
                this,
                String.format("La cotización para %s → %s en clase %s es: $%.2f",
                        origen, destino, clase.name().toLowerCase(), costo),
                "Cotización",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    private void limpiarCampos() {
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        rbEconomica.setSelected(true);
        txtNombre.setText("");
        txtIdentificacion.setText("");
        cbMetodoPago.setSelectedIndex(0);
        txtAreaTiquete.setText("");
        txtAreaFactura.setText("");
    }


    private Clase obtenerClaseSeleccionada() {
        if (rbEjecutiva.isSelected()) return Clase.EJECUTIVA;
        if (rbEconomica.isSelected()) return Clase.ECONOMICA;
        return null;
    }

    private String obtenerFechaPorRuta(String origen, String destino) {
        if ("SJO".equalsIgnoreCase(origen) && "MEX".equalsIgnoreCase(destino)) return "2025-11-15";
        if ("SJO".equalsIgnoreCase(origen) && "MIA".equalsIgnoreCase(destino)) return "2025-11-20";
        if ("SJO".equalsIgnoreCase(origen) && "PAN".equalsIgnoreCase(destino)) return "2025-12-01";

        if ("MEX".equalsIgnoreCase(origen) && "SJO".equalsIgnoreCase(destino)) return "2025-11-25";
        if ("MEX".equalsIgnoreCase(origen) && "MIA".equalsIgnoreCase(destino)) return "2025-12-05";
        if ("MEX".equalsIgnoreCase(origen) && "PAN".equalsIgnoreCase(destino)) return "2025-12-10";

        return null;
    }
}


