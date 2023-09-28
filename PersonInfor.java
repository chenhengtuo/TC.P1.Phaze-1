import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * PersonInfor class: used to store the data for each membership
 */
public class PersonInfor {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean live;

    /**
     * constructor
     */
    public PersonInfor(){
        firstName = null;
        lastName = null;
        phoneNumber = null;
        live = false;
    }

    public PersonInfor(String lname, String fname, String number, boolean result){
        firstName = fname;
        lastName = lname;
        phoneNumber = number;
        live = result;
    }

    /**
     *
     * @return lastname
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     *
     * @return first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     *
     * @return phone number
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     *
     * @return return the status the person live in NewYork or not
     */
    public boolean getLive(){
        return this.live;
    }

    /**
     *
     * @param name
     * set the person firstname
     */
    public void setFirstName(String name){
        firstName = name;
    }

    /**
     *
     * @param name
     * set the person lastname
     */
    public void setLastName(String name){
        lastName = name;
    }

    /**
     *
     * @param number
     * set the unique phone number
     */
    public void setPhoneNumber(String number){
        phoneNumber = number;
    }
    public void setLive(boolean result){
            live = result;
    }

    /**
     *
     * @return the membership all the information
     */

    public String toString(){
        String str = "";
        str = firstName + " | " + lastName + " | "+ phoneNumber +" | " + live;
        return str;
    }

}
