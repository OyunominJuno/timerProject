/**
 * Customer class that handles and displays the data of the customer
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2018/3/11
 */
public class Customer {
    private long id;
    private String firstName, lastName, email, phoneNumber;
    
    /**
     * Ful constructor for customer class
     * 
     * @param   long         id
     * @param   String      first name
     * @param   String      last name
     * @param   String      email
     * @param   String      phone number
     */
    public Customer(long id, String firstName, String lastName, String email, String phoneNumber) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }
    
    /**
     * Retrieves the customer's id
     * 
     * @return  id
     */
    public long getId(){
        return id;
    }
    
    /**
     * Retrieves the customer's first name
     * 
     * @return  first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Retrieves the customer's last name
     * 
     * @return  last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Retrieves the customer's email
     * 
     * @return  email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Retrieves the customer's phone number
     * 
     * @return  phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Sets the customer's id
     * 
     * @param  long  id
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Sets the customer's first name
     * 
     * @param  String   first name
     */
    public void setFirstName(String firstName) {
        check(firstName);
        this.firstName = firstName;
    }
    
    /**
     * Sets the customer's last name
     * 
     * @param  String  last name
     */
    public void setLastName(String lastName) {
        check(lastName);
        this.lastName = lastName;
    }
    
    /**
     * Stes the customer's email
     * 
     * @param   String   email
     */
    public void setEmail(String email) {
        check(email);
        this.email = email;
    }
    
    /**
     * Sets the customer's phone number
     * 
     * @param  String   phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        check(phoneNumber);
        this.phoneNumber = phoneNumber;
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
        info += id + ", " + firstName + ", " + lastName + ", " + email + ", " + phoneNumber  + "\n";
        return info;
    }
}
