
/**
 * Tommy Chang
 * CEN 3024 - Software Development 1
 * January 26, 2025
 * Patron.java
 * This class contains the properties of the Patron Object, as well as any patron logic
 */
public class Patron{

    private String PatronID;
    private String Name;
    private String Address;
    private double AmountOwed;

    /**
     * method: Patron
     * parameters: none
     * return: none
     * purpose: default constructor
     */
    public Patron(){

    }

    /**
     * method: Patron
     * parameters: String, String, String, double
     * return: none
     * purpose: overloaded constructor
     */
    public Patron(String PatronID, String Name, String Address, double AmountOwed){
        this.PatronID = PatronID;
        this.Name = Name;
        this.Address = Address;
        this.AmountOwed = AmountOwed;
    }

    /**
     * method: getPatronID
     * parameters: none
     * return: String
     * purpose: getter for PatronID property
     */
    public String getPatronID(){
        return PatronID;
    }

    /**
     * method: setPatronID
     * parameters: none
     * return: none
     * purpose: setter for PatronID property
     */
    public void setPatronID(String PatronID){
        this.PatronID = PatronID;
    }

    /**
     * method: getName
     * parameters: none
     * return: String
     * purpose: getter for name property
     */
    public String getName(){
        return Name;
    }

    /**
     * method: setName
     * parameters: none
     * return: none
     * purpose: setter for name property
     */
    public void setName(String Name){
        this.Name = Name;
    }

    /**
     * method: getAddress
     * parameters: none
     * return: String
     * purpose: getter for Address property
     */
    public String getAddress(){
        return Address;
    }

    /**
     * method: setAddress
     * parameters: none
     * return: none
     * purpose: setter for Address property
     */
    public void setAddress(String Address){
        this.Address = Address;
    }

    /**
     * method: getAmountOwed
     * parameters: none
     * return: double
     * purpose: getter for AmountOwed property
     */
    public double getAmountOwed(){
        return AmountOwed;
    }

    /**
     * method: setAmountOwed
     * parameters: none
     * return: none
     * purpose: setter for AmountOwed property
     */
    public void setAmountOwed(double AmountOwed){
        this.AmountOwed = AmountOwed;
    }

    /**
     * method: toString
     * parameters: none
     * return: String
     * purpose: object stringify method for viewing the patron details in a String
     */
    public String toString(){
        return this.PatronID + " " + this.Name + " " + this.Address + " " + this.AmountOwed;
    }
}
