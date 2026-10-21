/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import modelo.Curso;

/**
 *
 * @author demia
 */
public class VentanaInscripcion extends JFrame {

    private static final Color AZUL = new Color(0, 94, 184);
    private static final Color FONDO = new Color(242, 242, 242);

    private final DefaultListModel<Curso> modeloDisponibles = new DefaultListModel<>();
    private final DefaultListModel<Curso> modeloInscritos = new DefaultListModel<>();
    private final JList<Curso> listaDisponibles = new JList<>(modeloDisponibles);
    private final JList<Curso> listaInscritos = new JList<>(modeloInscritos);
    private final JLabel lblTotal = new JLabel("Monto a pagar: $0.00");
    private final JButton btnInscribir = new JButton("Inscribir curso seleccionado");
    private final JButton btnFinalizar = new JButton("Finalizar inscripcion");

    public VentanaInscripcion() {
        super("Inscribirse en Clases");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(FONDO);

        // Encabezado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(AZUL);
        encabezado.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel titulo = new JLabel("Inscribirse en Clases");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        encabezado.add(titulo, BorderLayout.WEST);

        // Listas
        configurarLista(listaDisponibles);
        configurarLista(listaInscritos);
        listaDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel centro = new JPanel(new GridLayout(1, 2, 15, 0));
        centro.setBackground(FONDO);
        centro.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));

        JPanel izquierda = new JPanel(new BorderLayout(0, 8));
        izquierda.setBackground(FONDO);
        izquierda.setBorder(titulado("Cursos disponibles"));
        izquierda.add(new JScrollPane(listaDisponibles), BorderLayout.CENTER);
        configurarBoton(btnInscribir);
        izquierda.add(btnInscribir, BorderLayout.SOUTH);

        JPanel derecha = new JPanel(new BorderLayout(0, 8));
        derecha.setBackground(FONDO);
        derecha.setBorder(titulado("Cursos inscritos"));
        derecha.add(new JScrollPane(listaInscritos), BorderLayout.CENTER);
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTotal.setForeground(AZUL);
        lblTotal.setPreferredSize(new Dimension(100, 32));
        derecha.add(lblTotal, BorderLayout.SOUTH);

        centro.add(izquierda);
        centro.add(derecha);

        // Pie
        JPanel abajo = new JPanel();
        abajo.setBackground(FONDO);
        abajo.setBorder(BorderFactory.createEmptyBorder(5, 0, 12, 0));
        configurarBoton(btnFinalizar);
        abajo.add(btnFinalizar);

        add(encabezado, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);

        setSize(760, 460);
        setLocationRelativeTo(null);
    }

    private TitledBorder titulado(String texto) {
        TitledBorder b = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(AZUL, 1), texto);
        b.setTitleColor(AZUL);
        b.setTitleFont(new Font("SansSerif", Font.BOLD, 14));
        return b;
    }

    private void configurarLista(JList<Curso> lista) {
        lista.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lista.setFixedCellHeight(26);
        lista.setSelectionBackground(AZUL);
        lista.setSelectionForeground(Color.WHITE);
    }

    private void configurarBoton(JButton boton) {
        boton.setBackground(AZUL);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setPreferredSize(new Dimension(240, 34));
    }

    public void setCursosDisponibles(List<Curso> cursos) {
        modeloDisponibles.clear();
        for (Curso c : cursos) {
            modeloDisponibles.addElement(c);
        }
    }

    public void setCursosInscritos(List<Curso> cursos) {
        modeloInscritos.clear();
        for (Curso c : cursos) {
            modeloInscritos.addElement(c);
        }
    }

    public void setTotal(double total) {
        lblTotal.setText(String.format("Monto a pagar: $%.2f", total));
    }

    public Curso getCursoSeleccionado() {
        return listaDisponibles.getSelectedValue();
    }

    public void mostrarFichaPago(String texto) {
        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JOptionPane.showMessageDialog(this, new JScrollPane(area), "Ficha de pago",
                JOptionPane.PLAIN_MESSAGE);
    }

    public void setAccionInscribir(java.awt.event.ActionListener l) {
        btnInscribir.addActionListener(l);
    }

    public void setAccionFinalizar(java.awt.event.ActionListener l) {
        btnFinalizar.addActionListener(l);
    }
}
