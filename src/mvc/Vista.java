
package mvc;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  Vista de nuestro programa
 *  Utilizamos la libreria swing
 *  
 * @author fon
 */
public class Vista extends JFrame implements ModeloObserver{

    private Controlador c;
    private JLabel texto;
    
    /*Los siguientes atributos no son necesarios que existan como tal, pero los he creado para que se vean bien mis componentes de la vista*/
    private JButton botonSuma, botonResta;  //No es necesario tenerlos como atributos ya que no lo vamos a modificar
    private FlowLayout capa;                //No es necesario tenerlos como atributos ya que no vamos a estar modificandolo
    private JPanel panel;                   // No es necesario tenerlos como atributos ya que no vamos a estar modificandolo
    
    /**
     * Crea la vista, se le asigna un controlador
     * @param c : controlador asociado a la vista.
     */
    public Vista(Controlador c){
        //Asignamos controlador a la vista
        this.c = c;
        
        //Creamos el boton suma
        botonSuma = new JButton();
        //Añadimos su texto correspondiente
        botonSuma.setText("sumar");
        //Añadimos un listener para los eventos de raton.
        botonSuma.addMouseListener(new MouseAdapter() {
            /*Es más comodo usar MouseAdapter, ya que solo necesitamos un metodo de la interfaz MouseListener*/
            //Cuando clickemos sobre el boton, queremos que realice...
            @Override
            public void mouseClicked(MouseEvent e) {
                //... al clickar, llamamos al controlador y le indicamos que acción realizar. El controlador se encargará de notificar a la lógica según la acción.
                c.sumar();
            }
        });
        //Lo mismo que con el boton de sumar, pero con la resta...
        botonResta = new JButton();
        botonResta.setText("restar");
        botonResta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.restar();
            }
        });
        
        //Creamos el JLabel. Nuestro texto indicará el valor del número. Y se actualizará a medida que la lógica se modifique y cambie de estado.
        texto = new JLabel();
        //Lo inicializamos a 0
        texto.setText(Integer.toString(0));
        
        //Creamos un flowLayout sobre el que estarán los componentes anteriores
        capa = new FlowLayout();
        //Creamos el JPanel sobre el que estara el flowlayout y los componentes de la vista.
        panel = new JPanel();
        
        //Añadimos titulo a nuestra ventana
        this.setTitle("Ejemplo MVC");
        //Indicamos a la ventana que se pueda cerrar. (La acción de cerrar)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Le damos un tamaño por defecto a la ventana.
        this.setSize(300,300);
        //Indicamos su tamaño mínimo, y máximo, ya que no vamos a "bloquearla" y permitiremos que sea redimensionable.
        this.setMinimumSize(new Dimension(100,100));
        this.setMaximumSize(new Dimension(2000,2000));
        
        //Añadimos layout al panel
        panel.setLayout(capa);
        //Añadimos componentes visuales al panel
        panel.add(texto);
        panel.add(botonSuma);
        panel.add(botonResta);
        //Añadimos el panel a nuestra ventana.
        this.add(panel);
        //Hacemos visible nuestra ventana.
        this.setVisible(true);
        
    }
    
    /**
     * Metodo de la interfaz del observador. Este método será llamado por el Observable para que cada observador sepa qué ha pasado respecto al valor cambiado.
     * @param valor : valor que recibimos nuevo del modelo.
     */
    @Override
    public void valorCambiado(int valor) {
        //Nos llega el valor cambiado del modelo, que es el estado que nos interesa para cambiar la vista.
        //Actuamos en consecuencia de ese valor que nos ha llegado del modelo, actualizando el texto(JLabel) de nuestra vista.
        texto.setText(Integer.toString(valor));
    }
    
    

}
