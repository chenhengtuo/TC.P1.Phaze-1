import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Phase#1 The project is to collect membership
 * information for a person, store that information in a hashtable,
 * read the information stored and output it to an OutputFile
 * Name:Hengtuo Chen
 * Date:9/25/2023
 *
 */

public class Membership {
    public static void main(String[] args){

        String outputFile = "";
        String inputFile = "";
        String switchFlag ="";// use this switch flag to 1. print all the memberships or 2.recent membership
        String  str = "";
        PersonInfor recent = new PersonInfor();//create the person informatuon obejct for store data

        Command command = new Command(); //initial the command object to run the commandline argument
        command.CommandlineRun(args);  //running our command line.
        recent.setFirstName(command.getFirstName()); //store the firstName into Person object
        recent.setLastName(command.getLastName()); //store the lastName into Person object
        recent.setPhoneNumber(command.getPhoneNumber()); //store the unique phone number into Person object
        recent.setLive(command.getLive());  //store the live status into person object
        inputFile = command.getInputFile();
        switchFlag = command.getSwitchFlag(); // get the flag value
        outputFile = command.getOutputFile();

        Hashtable<String,PersonInfor> table = new Hashtable<>(); //initial the hashtable for personInfo object
        try {
           FileReader file = new FileReader(inputFile);
           BufferedReader br = new BufferedReader(file);  //buffread to read the initila txt file
           String line = br.readLine();
           while((line = br.readLine()) != null){
               String[] words = line.split("\\s*\\|\\s*");
               PersonInfor person = new PersonInfor();// initial a personInfo object to store the information
               person.setFirstName(words[0]); //set the first name
               person.setLastName(words[1]);  //set last name
               person.setPhoneNumber(words[2]); //set the phone number
               if(words[3].equals("true")){
                   person.setLive(true);
               }
               else{
                   person.setLive(false);
               }
               table.put(person.getPhoneNumber(),person);
           }

           br.close();
           file.close();
       }catch (IOException e){
           System.out.println("The file you try to read is not find");
       }

        // use to check if the prosen object is already in hashtable oo not
        if(table.containsKey(recent.getPhoneNumber())){
            System.out.println("Sorry, the information(phone number) you entered is already exits in our database.Below is  the membership information");
            //System.out.println(table.get(recent.getPhoneNumber()).toString());
            Enumeration<PersonInfor> valus = table.elements(); //create the object to through the hashtable value
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write("Sorry, the information(phone number) you entered is already exits in our database.Below is  the membership information\n");
                while (valus.hasMoreElements()) {
                    str = valus.nextElement().toString();
                    System.out.println(str);
                    writer.write(str+"\n");
                }
                writer.close();
            }catch (IOException e){
                System.out.println("an error occured when you try to write out");
            }
        }
        else{
            table.put(recent.getPhoneNumber(),recent);
            Enumeration<PersonInfor> valus = table.elements(); //create the object to through the hashtable value
            if(switchFlag.equals("y")){
                System.out.println("You choose to print all the membership information, below is the list:");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                    writer.write("You choose to print all the membership information, below is the list:\n");
                    while (valus.hasMoreElements()) {
                        str = valus.nextElement().toString();
                        System.out.println(str);
                        writer.write(str+"\n");
                    }
                    writer.close();
                }catch (IOException e){
                    System.out.println("an error occured when you try to write out");
                }
            }// the switch key part to print all the membership information in the hashtable
            else if(switchFlag.equals("n")){
                try{
                System.out.println("You choose to print the recent membership information,below is the recent membership information:");
                System.out.println(recent.toString());
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write("You choose to print the recent membership information,below is the recent membership information:\n");
                str = recent.toString();
                writer.write(str+"\n");
                writer.close();
                 }catch (IOException e){
                    System.out.println("an error occured when you try to write out");
                }
            }// the part to print the recent membership information
            else{
                System.out.println("You have not pick any option to print ");
                System.out.println("Please using the following format:" +"\n"+
                        "java Membership -firstname=validnamae -lastname=validnamae -phone=validnumber -NewYork=true/false -outputFile=NameOfOutputFile -inputFile=InitialDataFile -switch=y/n" );
            }
        }

    }
}