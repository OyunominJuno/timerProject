import java.util.Scanner;

/**
 * Main class handles user data gathering
 *
 * @author  Oyunomin Munkhkhurel
 * @version 3/12/2018
 */
public class Main {
    /**
     * Asks three question from the user, calls the validation and creates Simulation object
     * 
     * @param   String[]    arguments
     */
    public static void main(String[] args) {
        System.out.print('\u000C');
        Scanner scan = new Scanner(System.in);
        
        int INITIAL_MIN = 1;
        int INITIAL_MAX = 20;
        double INTERVAL_MIN = 1;
        double INTERVAL_MAX = 5;
        int INCREMENT_MIN = 1;
        int INCREMENT_MAX = 20;
        
        System.out.print("\n========================================");
        System.out.print("\nSophocles Software Call Center Sim\n");
        System.out.print("========================================\n");
            
        System.out.println("How many customer do you want to be in the initial queue ?");
        System.out.print("Enter a integer between " + INITIAL_MIN + " and " + INITIAL_MAX + " : ");
        int initialQ = getInRangeInt(scan, INITIAL_MIN, INITIAL_MAX);
        
        System.out.println("How long you want one call to continue ?");
        System.out.print("Enter a double between " + INTERVAL_MIN + " and " + INTERVAL_MAX + " : ");
        double callInterval = getInRangeDouble(scan, INTERVAL_MIN, INTERVAL_MAX);
        
        System.out.println("How many calls do you want to complete ?");
        System.out.print("Enter a integer between " + INCREMENT_MIN + " and " + INCREMENT_MAX + " : ");
        int increment = getInRangeInt(scan, INCREMENT_MIN, INCREMENT_MAX);
        
        Simulation sim = new Simulation(initialQ, callInterval, increment);
    }
    
    /**
     * Checks if it is an integer and in the specific range and if no keep asking
     * and when it gets valid integer returns that integer
     * 
     * @param   Scanner   scanner object that gathers user input
     * @param   int       minimun value
     * @param   int       maximun value
     * @return            valid integer in the range
     */
    private static int getInRangeInt(Scanner scan, int min, int max) {
        int value = -9999;
        while (value < min || value > max) {
            System.out.println("Must be a integer between " + min + " and " + max + " : ");
            while (!scan.hasNextInt()) {
                System.out.println("Must be a integer between " + min + " and " + max + " : ");
                scan.next();
            }
            value = scan.nextInt();
        }
        return value;
    }
    
    /**
     * Checks if it is an double and in the specific range and if no keep asking
     * and when it gets valid double returns that integer
     * 
     * @param   Scanner   scanner object that gathers user input
     * @param   int       minimun value
     * @param   int       maximun value
     * @return            valid integer in the range
     */
    private static double getInRangeDouble (Scanner scan, double min, double max) {
        double value = -9999;
        while (value < min || value > max) {
            System.out.println("Must be a double between " + min + " and " + max + " : ");
            while (!scan.hasNextDouble()) {
                System.out.println("Must be a double between " + min + " and " + max + " : ");
                scan.next();
            }
            value = scan.nextDouble();
        }
        return value;
    }
}
