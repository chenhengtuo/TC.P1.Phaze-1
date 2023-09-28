/**
 *  Command class , use for running the argument form the command line by any order.
 *  have a switch flag allow user to print all the membership in the database or just print
 *  the recent membership informatin
 */
public class Command {
    private int i;
    private String arg;
    private String lastNmae;
    private String firstName;
    private String phoneNumber;
    private String outputFile;
    private String inputFile;
    private String check;  //use for check the commandline argument
    private String switchFlag;// use this switch flag to 1. print all the memberships or 2.recent membership
    boolean live;

    public Command() {
        i = 0;
        arg = "";
        lastNmae = "";
        firstName = "";
        phoneNumber = "";
        outputFile = "";
        inputFile = "";
        check = "ture";  //use for check the commandline argument
        switchFlag = "";// use this switch flag to 1. print all the memberships or 2.recent membership
        live = false;
    }

    public void CommandlineRun(String[] args){
        while(i < args.length && args[i].startsWith("-")){
            arg = args[i++];
            if(arg.startsWith("-firstname=")){
                firstName = arg.substring(arg.indexOf('=') +1);
                //System.out.println(firstName);
            }
            else if(arg.startsWith("-lastname=")){
                lastNmae = arg.substring(arg.indexOf('=') +1);
               // System.out.println(lastNmae);
            }
            else if(arg.startsWith("-phone=")){
                phoneNumber = arg.substring(arg.indexOf('=') +1);
               // System.out.println(phoneNumber);
            }
            else if(arg.startsWith("-NewYork=")){
                check = arg.substring(arg.indexOf('=') +1);
                if(check.equals("false")){
                    live = false;
                }
                else{
                    live = true;
                }
                //System.out.println(live);
            }
            else if(arg.startsWith("-outputFile")){
                outputFile = arg.substring(arg.indexOf('=') +1);
            }
            else if(arg.startsWith("-inputFile")){
                inputFile = arg.substring(arg.indexOf('=') +1);
            }
            else if(arg.startsWith("-switch=")){
                switchFlag = arg.substring(arg.indexOf('=')+1);
            }
            else{
                System.out.println(arg + " is not valid commandline argument, please using the following format:" +"\n"+
                        "java Membership -firstname=validnamae -lastname=validnamae -phone=validnumber -NewYork=true/false -outputFile=NameOfOutputFile -inputFile=InitialDataFile -switch=y/n" );
                System.exit(0);
            }
        }
    }

    /**
     * @param
     * @return fristName from command line
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param
     * @return lastname form command line
     */
    public String getLastName() {
        return this.lastNmae;
    }

    /**
     *
     * @param
     * @return  the phone number form command line
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     *
     * @param
     * @return true if the person live in NewYork,
     */
    public Boolean getLive() {
        return this.live;
    }

    /**
     *
     * @param
     * @return the input file name
     */
    public String getInputFile() {
        return this.inputFile;
    }

    /**
     *
     * @param
     * @return name of the outfile
     */
    public String getOutputFile() {
        return this.outputFile;
    }

    /**
     * @param
     * @return the name of the switch flag
     */
    public String getSwitchFlag() {
        return this.switchFlag;
    }
}
