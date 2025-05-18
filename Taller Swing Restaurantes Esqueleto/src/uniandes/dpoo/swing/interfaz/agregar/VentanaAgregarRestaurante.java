package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante(VentanaPrincipal principal)
    {
        this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        // Agrega el panel donde va a estar el mapa
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);
        JPanel sur = new JPanel(new BorderLayout());
        sur.add(panelDetalles, BorderLayout.CENTER);
        sur.add(panelBotones, BorderLayout.SOUTH);
        add(sur, BorderLayout.SOUTH);

        // Termina de configurar la ventana
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Toma datos del panel de edición y los envía a la ventana principal, luego cierra
     */
    public void agregarRestaurante()
    {
        String nombre  = panelDetalles.getNombre();
        int cal        = panelDetalles.getCalificacion();
        boolean vis    = panelDetalles.getVisitado();
        int[] coord    = panelMapa.getCoordenadas();
        ventanaPrincipal.agregarRestaurante(nombre, cal, coord[0], coord[1], vis);
        dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana()
    {
        dispose();
    }
}