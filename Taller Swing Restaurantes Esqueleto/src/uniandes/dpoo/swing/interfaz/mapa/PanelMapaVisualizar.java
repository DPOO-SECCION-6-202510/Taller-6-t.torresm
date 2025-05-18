package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar()
    {
        setLayout(new BorderLayout());
        this.labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        add(labMapa, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (restaurantes != null)
        {
            Graphics2D g2d = (Graphics2D)g;
            for (Restaurante r : restaurantes)
            {
                int x = r.getX(), y = r.getY();
                g2d.setColor(Color.RED);
                g2d.fillOval(x - 3, y - 3, 7, 7);
                g2d.setColor(Color.BLACK);
                g2d.drawString(r.getNombre(), x + 5, y - 5);
            }
        }
    }

    /**
     * Actualiza la lista de restaurantes y repinta el mapa
     */
    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        this.restaurantes = nuevosRestaurantes;
        repaint();
    }
}