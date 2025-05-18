package uniandes.dpoo.swing.interfaz.principal;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ListSelectionListener
{
    /**
     * El widget donde se muestra la lista de restaurantes
     */
    private JList<Restaurante> listaDeRestaurantes;

    /**
     * El modelo de datos que se muestra en la lista de restaurantes
     */
    private DefaultListModel<Restaurante> dataModel;

    /**
     * La ventana principal que contiene a este panel
     */
    private VentanaPrincipal ventanaPrincipal;

    public PanelLista(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal = ventanaPrincipal;
        setBorder(new TitledBorder("Restaurantes"));
        setLayout(new BorderLayout());

        dataModel = new DefaultListModel<>();
        listaDeRestaurantes = new JList<>(dataModel);
        listaDeRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDeRestaurantes.addListSelectionListener(this);

        JScrollPane scroll = new JScrollPane(listaDeRestaurantes);
        add(scroll, BorderLayout.CENTER);
    }

    /**
     * Actualiza la lista de restaurantes que se muestran en la lista.
     */
    public void actualizarRestaurantes(List<Restaurante> restaurantes)
    {
        List<Restaurante> nuevosRestaurantes = new ArrayList<>();
        for (Restaurante r : restaurantes)
        {
            if (!dataModel.contains(r))
                nuevosRestaurantes.add(r);
        }
        dataModel.addAll(nuevosRestaurantes);
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        Restaurante seleccionado = listaDeRestaurantes.getSelectedValue();
        ventanaPrincipal.cambiarRestauranteSeleccionado(seleccionado);
    }

    /**
     * Cambia el restaurante seleccionado en la lista
     */
    public void seleccionarRestaurante(Restaurante restaurante)
    {
        listaDeRestaurantes.setSelectedValue(restaurante, true);
    }
}