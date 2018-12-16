/**
 * Tech class that handles and displays the data of the tech person
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2018/3/11
 */
public class Tech {
    private long id;
    private String firstName, lastName, userName;
    private Simulation.WeekDay offDay;
    
    /**
     * Ful constructor for tech person class
     * 
     * @param   long         id
     * @param   String      first name
     * @param   String      last name
     * @param   String      user name
     * @param   Day         off day
     */
    public Tech(long id, String firstName, String lastName, String userName, Simulation.WeekDay offDay) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setOffDay(offDay);
    }
    
    /**
     * Retrieves the tech person's id
     * 
     * @return  id
     */
    public long getId(){
        return id;
    }
    
    /**
     * Retrieves the tech person's first name
     * 
     * @return  first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Retrieves the tech person's last name
     * 
     * @return  last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Retrieves the tech person's user name
     * 
     * @return  user name
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Retrieves the tech person's off day
     * 
     * @return  off day
     */
    public Simulation.WeekDay getOffDay() {
        return offDay;
    }
    
    /**
     * Sets the tech person's id
     * 
     * @param  long  id
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Sets the tech person's first name
     * 
     * @param  String   first name
     */
    public void setFirstName(String firstName) {
        check(firstName);
        this.firstName = firstName;
    }
    
    /**
     * Sets the tech person's last name
     * 
     * @param  String  last name
     */
    public void setLastName(String lastName) {
        check(lastName);
        this.lastName = lastName;
    }
    
    /**
     * Stes the tech person's user name
     * 
     * @param   String   user name
     */
    public void setUserName(String userName) {
        check(userName);
        this.userName = userName;
    }
    
    /**
     * Sets the tech person's off day
     * 
     * @param  Day   off day
     */
    public void setOffDay (Simulation.WeekDay offDay) {
        this.offDay = offDay;
    }
    
    /**
     * Helper method that checks String if it is a null
     * 
     * @throws IllegalArgumentException if String is null
     * @param  String   data that is to check
     */
    private void check(String data) {
        if (data == null) {
            throw new IllegalArgumentException("cannot be null");
        }
    }
    
    /**
     * Collects verbal state of this object
     * 
     * @return  verbal state of this object
     */
    public String toString() {
        String info = "";
        info += id + ", " + firstName + ", " + lastName + ", " + userName  + ", off day: " + offDay +"\n";
        return info;
    }
}
