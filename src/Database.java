import java.util.HashMap;

public class Database {
    private HashMap<String, Patron> PatronsDB;
    public Database() {
        this.PatronsDB = new HashMap<>();
    }

    // getter function for PatronsDB
    public HashMap<String, Patron> getPatronsDB() {
        return PatronsDB;
    }

    // setter function for PatronsDB
    public void setPatronsDB(HashMap<String, Patron> patronsDB) {
        PatronsDB = patronsDB;
    }
}
