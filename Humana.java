import java.util.ArrayList;
/**
 * Write a description of class Humano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Humana extends Poblacion
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Humano
     */
    public Humana(Raza raza, int años)
    {
        // initialise instance variables
        super(raza, años);
    }
    
    public String getBichoName()
    {
        String bichoName = "M" + super.getBichoName();
        return bichoName;
    }   
    
     public String getRaza()
    {
        return raza.getRaza();
    }
    
    /**
     * mueve humana
     */
    public void mover()
    {
        super.mover();     
    }
}
