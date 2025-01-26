import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/**
 * Tommy Chang
 * CEN 3024 - Software Development 1
 * January 26, 2025
 * Main.java
 * This application will ask users if they'd like to manipulate patrons by adding, viewing, or deleting.
 */

public class Main {
    public static Database DB = new Database();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello. Welcome to the library system.");

        // Main Menu
        int option = 0;
        while (true){
            menu();

            /*
                Make sure the user has entered a valid menu option.
                Otherwise, prompt for another input.
             */
            String message = in.nextLine();
            try{
                option = Integer.parseInt(message);
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
                continue;
            }

            // Switch to handle chosen option as well as the decision tree
            switch (option){
                case 1:
                    viewPatrons();
                    break;
                case 2:
                    addPatron();
                    break;
                case 3:
                    enterPatronFromTextFile();
                    break;
                case 4:
                    deletePatron();
                    break;
                case 5:
                    exitApplication();
                    return;
                default:
                    // If it is an invalid number, prompt user for a new input
                    System.out.println("Not a valid input.");
                    System.out.println("Please try again.");
                    continue;
            }


        }


    }

    /**
     * method: menu
     * parameters: none
     * return: void
     * purpose: contains the main menu prompts
     */
    public static void menu(){
        System.out.println("Please select one of the options by typing the corresponding number.");
        System.out.println("1. View all patrons");
        System.out.println("2. Add patron");
        System.out.println("3. Enter Patrons from Text File");
        System.out.println("4. Delete patron");
        System.out.println("5. Exit Application");
    }

    /**
     * method: viewPatrons
     * parameters: none
     * return: void
     * purpose: prints to console all patrons & details
     */
    public static void viewPatrons(){
        Scanner in = new Scanner(System.in);
        HashMap<String, Patron> patronsDB = DB.getPatronsDB();
        for (Patron patron : patronsDB.values()) {
            System.out.println(patron.toString());
        }
        System.out.println("Press enter to continue back to the main menu.");
        in.nextLine();
    }

    /**
     * method: addPatron
     * parameters: none
     * return: void
     * purpose: Add a patron to the system by prompting user for console input
     */
    public static void addPatron(){
        HashMap<String, Patron> patronsDB = DB.getPatronsDB();
        Random randomGenerator = new Random();
        Scanner in = new Scanner(System.in);

        String name = getStringValueFromInput("Please enter the name of the patron: ");
        String address = getStringValueFromInput("Please enter the address of the patron: ");
        double overDueAmount = getDoubleValueFromInput("Please enter the over-due amount of the patron: ");

        int ID = randomGenerator.nextInt(9999999);
        while (patronsDB.containsKey(ID)) {
            ID = randomGenerator.nextInt(9999999);
        }

        String PatronID = String.format("%07d", ID);
        Patron newPatron = new Patron(PatronID, name, address, overDueAmount);

        patronsDB.put(PatronID, newPatron);
        System.out.println(newPatron.toString() + " has been added to the database.");
        System.out.println("Press enter to continue back to the main menu.");
        in.nextLine();
    }

    /**
     * method: deletePatron
     * parameters: none
     * return: void
     * purpose: Delete a patron from the system by prompting user for PatronID
     */
    public static void deletePatron(){
        HashMap<String, Patron> patronsDB = DB.getPatronsDB();
        Scanner in = new Scanner(System.in);
        String id = getStringValueFromInput("Please enter the ID of the patron to delete: ");

        while (!patronsDB.containsKey(id)) {
            System.out.println("Patron does not exist. Please try again.");
            id = getStringValueFromInput("Please enter the ID of the patron to delete: ");
        }
        patronsDB.remove(id);
        System.out.println(id + " has been deleted from the database.");
        System.out.println("Press enter to continue back to the main menu.");
        in.nextLine();
    }

    /**
     * method: enterPatronFromTextFile
     * parameters: none
     * return: void
     * purpose: Processes patrons from user inputted text file name
     *          example text file line:
     *          1245789-Sarah Jones-1136 Gorden Ave. Orlando, FL 32822-40.54
     */
    public static void enterPatronFromTextFile(){
        File file;
        Scanner in = new Scanner(System.in);
        while (true){
            try{
                file = new File(getStringValueFromInput("Please enter the name of the text file: "));
                Scanner fIn = new Scanner(file);

                // if file exists, continue with scanning in patrons
                // if patronID already exist, notify user and continue with the rest of the file.
                while (fIn.hasNextLine()) {
                    String line = fIn.nextLine();
                    String[] patronDetails = line.split("-");
                    Patron temp = new Patron(patronDetails[0], patronDetails[1], patronDetails[2], Double.parseDouble(patronDetails[3]));
                    if (DB.getPatronsDB().containsKey(temp.getPatronID())) {
                        System.out.println(temp.getPatronID() + " already exists. Continuing.");
                        continue;
                    }
                    DB.getPatronsDB().put(temp.getPatronID(), temp);
                    System.out.println("Success. Patron " + temp.getPatronID() + " added.");
                }
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
        System.out.println("Patrons file has been processed.");
        System.out.println("Press enter to continue back to the main menu.");
        in.nextLine();

    }

    /**
     * method: exitApplication
     * parameters: none
     * return: void
     * purpose: End the program with a code 0
     */
    public static void exitApplication(){
        System.exit(0);
    }

    /**
     * method: getIntValueFromInput
     * parameters: string
     * return: int
     * purpose: Prompt user with msg for an int value, if not int, then re-prompt
     */
    public static int getIntValueFromInput(String msg){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println(msg);
            String inputLine = in.nextLine();
            try{
                return Integer.parseInt(inputLine);
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
                continue;
            }
        }
    }

    /**
     * method: getIntValueFromInput
     * parameters: string
     * return: double
     * purpose: Prompt user with msg for a double value, if not double, then re-prompt
     */
    public static double getDoubleValueFromInput(String msg){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println(msg);
            String inputLine = in.nextLine();
            try{
                return Double.parseDouble(inputLine);
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
                continue;
            }
        }
    }

    /**
     * method: getIntValueFromInput
     * parameters: string
     * return: String
     * purpose: Prompt user with msg for a String value, if not String, then re-prompt
     */
    public static String getStringValueFromInput(String msg){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println(msg);
            String inputLine = in.nextLine();
            try{
                return inputLine;
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
                continue;
            }
        }
    }
}

