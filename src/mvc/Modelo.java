package mvc;

import java.util.ArrayList;


/**
 * Modelo de mi programa, aquí estará toda la lógica y el funcionamiento interno de este.
 * Lo hacemos Observable sobre los observadores del modelo, para que sean notificados con lo que les interese.
 * @author fon
 */
public class Modelo implements Observable<ModeloObserver>{

    //Aquí añadiremos la liste de nuestros observadores
    private ArrayList<ModeloObserver> observadores;
    //Valor de la suma/resta
    private int valor;
    
    
    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la lista de los observadores.
     */
    public Modelo() {
        //Inicializamos atributos...
        valor = 0;
        observadores = new ArrayList<ModeloObserver>();
        
    }
    
    /**
     * Funcion sumar. Incrementa el valor.
     */
    public void sumar(){
        
        valor++;
        //Al modificarse el valor, notificamos a los observadores ya que les interesa ese cambio de estado.
        notificarObservadores(valor);
    }
    /**
     * Funcion restar. Decrementa el valor.
     */
    public void restar(){
        valor--;
        //Al modificarse el valor, notificamos a los observadores ya que les interesa ese cambio de estado.
        notificarObservadores(valor);
    }
    
    /**
     * addObservador: Añade observadores a nuestro modelo
     * @param t : observador de tipo ModeloObserver
     */
    @Override
    public void addObservador(ModeloObserver t) {
        //Añadimos el observador a nuestro arraylist
        observadores.add(t);
        //Notificamos el valor a nuestros observadores ya que tenemos un nuevo observador que necesita saber el valor.
        notificarObservadores(valor);
    }

    /**
     * removeObservador: Borra observadores a nuestro modelo
     * @param t : observador que queramos borrar.
     */
    //**En realidad no vamos a emplear en nuestro ejemplo este metodo, pero es importante tenerlo en cuenta.
    @Override
    public void removeObservador(ModeloObserver t) {
        observadores.remove(t);
    }
    
    /**
     * Método que notifica a nuestros observadores los cambios que nos interese que sepan.
     * @param t : estado del valor del numero.
     */
    private void notificarObservadores(int t) {
        //Nos recorremos el arraylist de los observadores
        for(ModeloObserver o : observadores){
            //Le a cada observador que el valor se ha cambiado al nuevo valor "t".
            //Recuerdo que para este caso, estamos notificando a cada vista que tengamos, el nuevo valor que tiene el numero, para que estas modifiquen su JLabel como output de la logica.
            o.valorCambiado(t);
        }
    }
    
    
}
