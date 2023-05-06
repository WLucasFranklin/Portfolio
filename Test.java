/*
Class to hold the attributes of malaria causing mosquitoes.
 */

public class Test {
    private String mosquito;
    private int species;
    private String plasmodium;

    public Test( String mosquito, int species, String plasmodium ) {
        this.mosquito = mosquito;
        this.species = species;
        this.plasmodium = plasmodium;
    }

    public String getMosquito(){
        return this.mosquito;
    }
    public int getSpecies(){
        return this.species;
    }
    public String getPlasmodium(){
        return this.plasmodium;
    }
}
