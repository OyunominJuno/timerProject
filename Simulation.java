import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 * Write a description of class Simulation here.
 *
 * @author   Oyunomin Munkhkhurel
 * @version  3/12/2018
 */
public class Simulation {
    private ArrayList<Customer> custArray;
    private ArrayList<Tech> techArray;
    private Queue<Customer> custQ;
    private Queue<Tech> techQ;
    private HashSet<Customer> custHash; 
    private int simulationCount = 0;
    private int increment, initialQ;
    private Timer simulationTimer;        
    private WeekDay randomDay;
    
    /**
     * Working days, in other words, weekdays
     */
    public enum WeekDay { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }
    
    @SuppressWarnings("unchecked")
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation(int initialQ, double callInterval, int increment) {
        //initializes everything
        custArray = new ArrayList<Customer>();
        techArray = new ArrayList<Tech>();
        custQ = new Queue<Customer>();
        techQ = new Queue<Tech>();
        custHash = new HashSet<Customer>();
        
        //assigs to the instance variables
        this.increment = increment;
        this.initialQ = initialQ;
        
        //calls necessary methods
        readData();
        randomDay = getRandomWeekDay();
        
        //Prints today's date
        System.out.print("**********************");
        System.out.print("\nToday's Date: " + randomDay);
        System.out.print("\n**********************\n");
        
        //fills the queues and the set
        while (custHash.size() != increment) {
            int randomIndexCust = (int)(Math.random() * (custArray.size()));
            custHash.add(custArray.get(randomIndexCust));
        }
        
        for (int index = 0; index < custArray.size(); index++) {
            if (custHash.contains(custArray.get(index))) {
                custQ.add(custArray.get(index));
            }
        }
        
        for (int idx = 0; idx < techArray.size(); idx++) {
            if (techArray.get(idx).getOffDay() != randomDay) {
                techQ.add(techArray.get(idx));
            }
        }
        
        //creates Timer
        simulationTimer = new Timer();
        simulationTimer.schedule(new SimulationTask(), 0,(long)callInterval * 1000);
    }

    /**
     * Reads data from the specified files and creates necessary objects
     * 
     * @throws  FileNotFoundException   if file does not found
     */
    private void readData() {
        try {
            File customerFile = new File("customerData.csv");
            Scanner scan = new Scanner(customerFile);
            scan.nextLine();
            while(scan.hasNext()) {
                String[] perCustData = scan.nextLine().split(",");
                Customer tempCust = new Customer(Long.valueOf(perCustData[0]), perCustData[1], perCustData[2], perCustData[3], perCustData[4]);
                custArray.add(tempCust);
            }
            File techFile = new File("techData.csv");
            Scanner scanner = new Scanner(techFile);
            scanner.nextLine();
            while(scanner.hasNext()) {
                String[] perTechData = scanner.nextLine().split(",");
                Tech tempTech = new Tech(Long.valueOf(perTechData[0]), perTechData[1], perTechData[2], perTechData[3], WeekDay.valueOf(perTechData[4]));
                techArray.add(tempTech);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Retrieves random day from the enum WeekDay
     * 
     * @return   randomly chosen week day
     */
    public static Simulation.WeekDay getRandomWeekDay() {
        Random random = new Random();
        return Simulation.WeekDay.values()[random.nextInt(Simulation.WeekDay.values().length)];
    }
    
    /**
     * Timer task that hepls Timer object
     */
    private class SimulationTask extends TimerTask {
        public void run() {
            System.out.println("\n\n" + custQ.peek() + "\t\t\tis helped by\n" + techQ.peek());
            Tech tempPeek = techQ.peek();
            techQ.remove();
            techQ.add(tempPeek);
            custQ.remove();
            simulationCount++;
            if (simulationCount >= increment) {
                System.out.print(increment + " calls have been successfully made.");
                simulationTimer.cancel();
            }
        }
    }
}
