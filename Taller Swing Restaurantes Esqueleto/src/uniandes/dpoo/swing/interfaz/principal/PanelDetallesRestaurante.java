package uniandes.dpoo.swing.interfaz.principal;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante()
    {
        // Organiza los elementos en la ventana
        setLayout(new GridLayout(3, 2));

        // Nombre
        add(new JLabel("Nombre:"));
        labNombre = new JLabel();
        add(labNombre);

        // Calificación
        add(new JLabel("Calificación:"));
        labCalificacion = new JLabel();
        add(labCalificacion);

        // Visitado
        add(new JLabel("Visitado:"));
        chkVisitado = new JCheckBox();
        chkVisitado.setEnabled(false);
        add(chkVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     */
    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado)
    {
        labNombre.setText(nombre);
        labCalificacion.setIcon(new ImageIcon("./imagenes/stars" + calificacion + ".png"));
        chkVisitado.setSelected(visitado);
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     */
    public void actualizarRestaurante(Restaurante r)
    {
        this.actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }
}