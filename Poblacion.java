import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Random;
public abstract class Poblacion extends Text
{
    // instance variables - replace the example below with your own
   
    public Raza raza;
    public int años;
    public double bichoXSpeed;
    public double bichoYSpeed; 
    /**
     * constructor de Poblacion(DIOS)
     */
    public Poblacion (Raza raza, int años)
    {
      //raza a la que pertenece
      this.raza = raza;
      //años vida de poblacion
      this.años = 0;
      //tamaño
 
     //movimiento poblacion
        bichoXSpeed = 8;
        bichoYSpeed = 8;
    }
    
    public String getBichoName()
    {
        String bichoName = " ";
        return bichoName;
    }
    /**
     * aumenta un año despues de un turno
     */ 
    public void aumentaAños()
    {
        años = años + 1;
    }    
    
    /**
     * Obtener raza
     */
    public String getRaza()
    {
        return raza.getRaza();
    }
    
    public void mover()
    {
        //Desplazamos la poblacion
        setTranslateX(getTranslateX() + bichoXSpeed);
        setTranslateY(getTranslateY() + bichoYSpeed);    

        // Controlamos la poblacion para que no se escape derch , izq
        if (getBoundsInParent().getMinX() <= 0 || getBoundsInParent().getMaxX() >= 50) 
        {
            bichoXSpeed = -bichoXSpeed;                              
        }

        // Controlamos la poblacion para que no se escape arriba, abajo
        if (getBoundsInParent().getMinY() <= 0 || getBoundsInParent().getMaxY() >= 50) 
        {
            bichoYSpeed = -bichoYSpeed;
        }        
    }
}
