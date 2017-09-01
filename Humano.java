import java.util.ArrayList;
/**
 * Write a description of class Humano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Humano extends Poblacion
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Humano
     */
    public Humano(Raza raza, int años)
    {
        // initialise instance variables
        super(raza, años);
    }
    /**
     * devuelve letra raza
     */
    public String getBichoName()
    {
        String bichoName = "H" + super.getBichoName();
        return bichoName;
    }
    
     public String getRaza()
    {
        return raza.getRaza();
    }
    
    /**
     * mueve humano
     */
    public void mover()
    {
        super.mover();     
    }
}
