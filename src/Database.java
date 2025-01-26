import java.util.HashMap;
/**
 * Tommy Chang
 * CEN 3024 - Software Development 1
 * January 26, 2025
 * Database.java
 * This class will handle storing the Patron Database, as well as any logic regarding the database
 */
public class Database {
    private HashMap<String, Patron> PatronsDB;
    public Database() {
        this.PatronsDB = new HashMap<>();
    }

    /**
     * method: getPatronsDB
     * parameters: none
     * return: HashMap<String,Patron>
     * purpose: returns the patronDB instance
     */
    public HashMap<String, Patron> getPatronsDB() {
        return PatronsDB;
    }

    /**
     * method: getPatronsDB
     * parameters: none
     * return: none
     * purpose: sets the patronDB instance
     */
    public void setPatronsDB(HashMap<String, Patron> patronsDB) {
        PatronsDB = patronsDB;
    }
}
