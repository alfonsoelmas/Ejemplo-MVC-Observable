/**
 * Ejemplo patrones de diseño MVC y Observer
 * Realizado por Alfonso Soria Muñoz
 * Para el canal de experimentando y aprendiendo.
 */
package mvc;

/**
 * Clase Main, desde aqui cargaremos el modelo, la vista y el controlador, y añadiremos observadores sobre el modelo.
 * @author fon
 */
public class mvc {
    /**
     * Main del programa
     * @param args : Array de argumentos de entrada. No los utilizamos. 
     */
    public static void main(String args[]){
        
        //Cargamos modelo
        Modelo m = new Modelo();
        
        //Cargamos controlador y le asignamos qué modelo controlar
        Controlador c = new Controlador(m);
        
        //Cargamos 2 vistas y asignamos cual queremos que sea su controlador **No tenemos en cuenta threads sobre el controlador, pero no lo llamaremos a la par.
        Vista v = new Vista(c);
        Vista v2 = new Vista(c);
        
        //añadimos observadores al modelo. En este caso, dos vistas.
        m.addObservador(v);
        m.addObservador(v2);
        
    }
}
