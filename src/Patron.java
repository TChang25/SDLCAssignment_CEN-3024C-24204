public class Patron{

    private String PatronID;
    private String Name;
    private String Address;
    private double AmountOwed;

    public Patron(){

    }

    public Patron(String PatronID, String Name, String Address, double AmountOwed){
        this.PatronID = PatronID;
        this.Name = Name;
        this.Address = Address;
        this.AmountOwed = AmountOwed;
    }

    /*
        Getters and setters for patron properties
    */
    public String getPatronID(){
        return PatronID;
    }
    public void setPatronID(String PatronID){
        this.PatronID = PatronID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public double getAmountOwed(){
        return AmountOwed;
    }
    public void setAmountOwed(double AmountOwed){
        this.AmountOwed = AmountOwed;
    }
    public String toString(){
        return this.PatronID + " " + this.Name + " " + this.Address + " " + this.AmountOwed;
    }
}
