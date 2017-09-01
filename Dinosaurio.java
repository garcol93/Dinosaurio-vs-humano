import java.util.ArrayList;
import javafx.scene.paint.*;
/**
 * Write a description of class Humano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dinosaurio extends Poblacion
{
   public int hambre;
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class dino
     */
    public Dinosaurio(Raza raza, int años, int hambre)
    {
        // initialise instance variables
        super(raza, años);
        hambre =0;
       
    }
  
    public String getBichoName()
    {
        String bichoName = "D" + super.getBichoName();
        return bichoName;
    }    
  
    
    public int getnivelHambre()
    {
        int nivelHambre = hambre;
        return hambre;
    }
    
    public String getRaza()
    {
        return raza.getRaza();
    }
    /**
     * mueve dino
     */
    public void mover()
    {
        super.mover();     
    }
}
