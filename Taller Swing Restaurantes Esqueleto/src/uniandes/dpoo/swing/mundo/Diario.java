package uniandes.dpoo.swing.mundo;

import java.util.ArrayList;
import java.util.List;

public class Diario
{
    /**
     * La lista de restaurantes, que pueden ser visitados o no
     */
    private List<Restaurante> restaurantes;

    public Diario()
    {
        this.restaurantes = new ArrayList<Restaurante>();
    }

    /**
     * Retorna una lista de restaurantes
     */
    public List<Restaurante> getRestaurantes(boolean completos)
    {
        List<Restaurante> seleccion;
        if (completos)
            seleccion = new ArrayList<Restaurante>(this.restaurantes);
        else
        {
            seleccion = new ArrayList<Restaurante>();
            for (Restaurante r : this.restaurantes)
            {
                if (r.isVisitado())
                    seleccion.add(r);
            }
        }
        return seleccion;
    }

    /**
     * Agrega un restaurante al diario, al final de la lista
     */
    public void agregarRestaurante(Restaurante restaurante)
    {
        this.restaurantes.add(restaurante);
    }
}