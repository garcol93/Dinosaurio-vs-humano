import java.util.ArrayList;
import javafx.scene.text.Text;

public abstract class Poblacion
{
    // instance variables - replace the example below with your own
    public Raza raza;
    public int años;
    public double shipXSpeed;
    public double shipYSpeed; 
    /**
     * constructor de Poblacion(DIOS)
     */
    public Poblacion (Raza raza, int años)
    {
      //raza a la que pertenece
      this.raza = raza;
      //años vida de poblacion
      this.años = años;
     //movimiento poblacion
        shipXSpeed = 8;
        shipYSpeed = 8;
    }
    
    /**
     * aumenta un año despues de un turno
     */ 
    public void aumentaAños()
    {
        años = años + 1;
    }    
    
    /**
     * Obtener el bando al que pertenece el barco
     */
    public String getRaza()
    {
        return raza.getRaza();
    }
    
    public void mover()
    {
        //Desplazamos la poblacion
        setTranslateX(getTranslateX() + shipXSpeed);
        setTranslateY(getTranslateY() + shipYSpeed);    

        // Controlamos la poblacion para que no se escape derch , izq
        if (getBoundsInParent().getMinX() <= 0 || getBoundsInParent().getMaxX() >= 50) 
        {
            shipXSpeed = -shipXSpeed;                              
        }

        // Controlamos la poblacion para que no se escape arriba, abajo
        if (getBoundsInParent().getMinY() <= 0 || getBoundsInParent().getMaxY() >= 50) 
        {
            shipYSpeed = -shipYSpeed;
        }        
    }
}
