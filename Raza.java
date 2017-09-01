
/**
 * Enumeration class Raza - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Raza
{
    DINOSAURIO("dinosaurio"), HUMANO("humano"), HUMANA("humana");
 
   private String raza;
    
   Raza(String raza)
    {
        this.raza = raza;
    }
    
    public String getRaza()

    {
        return raza;
   }    
}
