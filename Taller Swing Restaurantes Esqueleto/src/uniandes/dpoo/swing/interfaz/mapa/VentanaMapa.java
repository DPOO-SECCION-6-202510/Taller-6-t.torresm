package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    private static final String VISITADOS = "VISITADOS";
    private static final String TODOS      = "TODOS";

    private PanelMapaVisualizar panelMapa;
    private JRadioButton       radioTodos;
    private JRadioButton       radioVisitados;

    private VentanaPrincipal   ventanaPrincipal;

    public VentanaMapa(VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes)
    {
        super("Mapa de Restaurantes");
        this.ventanaPrincipal = ventanaPrincipal;
        setLayout(new BorderLayout());

        // Agrega el panel donde se muestra el mapa
        panelMapa = new PanelMapaVisualizar();
        panelMapa.actualizarMapa(restaurantes);
        add(panelMapa, BorderLayout.CENTER);

        // Agrega el panel con los RadioButtons y los configura
        JPanel panelRadios = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioTodos     = new JRadioButton("Todos");
        radioTodos.setActionCommand(TODOS);
        radioTodos.addActionListener(this);
        radioVisitados = new JRadioButton("Visitados");
        radioVisitados.setActionCommand(VISITADOS);
        radioVisitados.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioTodos);
        grupo.add(radioVisitados);
        radioTodos.setSelected(true);

        panelRadios.add(radioTodos);
        panelRadios.add(radioVisitados);
        add(panelRadios, BorderLayout.SOUTH);

        // Termina de configurar la ventana y la muestra
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (TODOS.equals(comando))
        {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(true));
        }
        else if (VISITADOS.equals(comando))
        {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(false));
        }
    }
}