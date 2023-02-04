package Trump;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyConsole {
    static String stopReg = "^((/move)|(/login)|(/fluid)|(/displayperson)|(/displayproperty)|(/addperson)|(/addproperty)|(/rentroom)|(/rentpark)|(/cancelroom)|(/cancelpark)|(/addfriend)|(/removefriend)|(/additem)|(/removeitem))$";
    static Pattern stopPat = Pattern.compile(stopReg);
    static String checkReg = "^((/save)|(/stop)|(/help)|(/exit)|(/select)|(/move)|(/swap)|(/mode)|(/find)|[wasd])$";
    static Pattern checkPat = Pattern.compile(checkReg);

    public static boolean ss = false, enter = false, stop = false, move = false, select = false,
            dispp = false, dispr = false, addpp = false, addpr = false, rntr = false, rntp = false,
            cncr = false, cncp = false, addf = false, rmvf = false, addt = false, rmvt;
    static int login = 0, fluid = 0;
    static String input = "/null", logInput;
    static double fluidSec = 20;
    Scanner scan = new Scanner(System.in);
    MyConsole(){}
    void runIns(){
        input = scan.nextLine();
        logInput = input;
        if (stop){
            if (login > 0){
                if (login == 1) {new MyLogin().user = input; login++;}
                else if (login == 2) {new MyLogin().pw = input; login++; stop=!stop;enter=!enter;}
            }
            else if (fluid > 0){
                if (fluid == 1) {try{fluidSec = Integer.valueOf(input);}catch(Exception e){fluidSec = 20;} fluid++;}
                else if (fluid == 2) {try{new Fluid().run(fluidSec, Integer.valueOf(input));}catch(Exception e){new Fluid().run();}fluid = 0;stop=!stop;enter=!enter;}
            }
            else if (move){
                if (MyDesktop.panel==1){
                    if (input.equalsIgnoreCase("/exit")){move = false; enter=!enter;stop=!stop;}
                    else if (input.equalsIgnoreCase("w")){MyDesktop.scrollPerson-=(new MyDesktop().h/4);MyDesktop.scrollPerson=MyDesktop.scrollPerson<0?0:MyDesktop.scrollPerson;}
                    else if (input.equalsIgnoreCase("s")){MyDesktop.scrollPerson+=(new MyDesktop().h/4);}
                } else if (MyDesktop.panel==2){
                    if (input.equalsIgnoreCase("/exit")){move = false; enter=!enter;stop=!stop;}
                    else if (input.equalsIgnoreCase("w")){MyDesktop.scrollProp-=(new MyDesktop().h/4);MyDesktop.scrollProp=MyDesktop.scrollProp<0?0:MyDesktop.scrollProp;}
                    else if (input.equalsIgnoreCase("s")){MyDesktop.scrollProp+=(new MyDesktop().h/4);}
                } else if (MyDesktop.panel==3){
                    if (input.equalsIgnoreCase("/exit")){move = false; enter=!enter;stop=!stop;}
                    else if (input.equalsIgnoreCase("w")){MyDesktop.scrollObj-=(new MyDesktop().h/4);MyDesktop.scrollObj=MyDesktop.scrollObj<0?0:MyDesktop.scrollObj;}
                    else if (input.equalsIgnoreCase("s")){MyDesktop.scrollObj+=(new MyDesktop().h/4);}
                } else if (MyDesktop.panel==4){
                    if (input.equalsIgnoreCase("/exit")){move = false; enter=!enter;stop=!stop;}
                    else if (input.equalsIgnoreCase("w")){MyDesktop.scrollCar-=(new MyDesktop().h/4);MyDesktop.scrollCar=MyDesktop.scrollCar<0?0:MyDesktop.scrollCar;}
                    else if (input.equalsIgnoreCase("s")){MyDesktop.scrollCar+=(new MyDesktop().h/4);}
                }
            }
            else if (addpp){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Person t = new Person(tempArr[0], Integer.valueOf(tempArr[1]), Integer.valueOf(tempArr[2]), Integer.valueOf(tempArr[3]), Integer.valueOf(tempArr[4]), Integer.valueOf(tempArr[5]));
                    Information.personInfo.put(t.ID, t);
                    InfoTap.output = "Successfully added a person to the list\nID: " + t.ID;
                }
                addpp = false;
                enter=!enter;
                stop=!stop;
            }
            else if (addpr){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Property t = new Property(tempArr[0], tempArr[1], Integer.valueOf(tempArr[2]), Integer.valueOf(tempArr[3]), Integer.valueOf(tempArr[4]), Integer.valueOf(tempArr[5]), Integer.valueOf(tempArr[6]), Integer.valueOf(tempArr[7]));
                    Information.propertyInfo.put(t.ID, t);
                    InfoTap.output = "Successfully added a property to the list\nID: " + t.ID;
                }
                addpr = false;
                enter=!enter;
                stop=!stop;
            }
            else if (dispp){
                if (!input.equalsIgnoreCase("/exit")) {
                    MyDesktop.panel = 5;
                    MyDesktop.input = input;

                }
                dispp = false;
                enter=!enter;
                stop=!stop;
            }
            else if (dispr){
                if (!input.equalsIgnoreCase("/exit")) {
                    MyDesktop.panel = 6;
                    MyDesktop.input = input;

                }
                dispr = false;
                enter=!enter;
                stop=!stop;
            }
            else if (rntr){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.propertyInfo.get(tempArr[1]).addRTenant(Information.personInfo.get(tempArr[0]), Information.propertyInfo.get(tempArr[1]).getAvRoom());

                }
                rntr = false;
                enter=!enter;
                stop=!stop;
            }
            else if (rntp){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.propertyInfo.get(tempArr[1]).addPTenant(Information.personInfo.get(tempArr[0]), Information.propertyInfo.get(tempArr[1]).getAvRoom());

                }
                rntp = false;
                enter=!enter;
                stop=!stop;
            } else if (cncr){
                if (!input.equalsIgnoreCase("/exit")) {
                    //String[] tempArr = input.split("\\s+");
                    if (!Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).type.equalsIgnoreCase("park"))
                        Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).prop.rmvRTenant(Information.personInfo.get(MyDesktop.ppID),Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).ID);
                }
                cncr = false;
                enter=!enter;
                stop=!stop;
            } else if (cncp){
                if (!input.equalsIgnoreCase("/exit")) {
                    //String[] tempArr = input.split("\\s+");
                    if (!Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).type.equalsIgnoreCase("room"))
                    Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).prop.rmvPTenant(Information.personInfo.get(MyDesktop.ppID),Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(input)-1).ID);
                }
                cncp = false;
                enter=!enter;
                stop=!stop;
            } else if (addf){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.personInfo.get(tempArr[0]).addFriendPlace(Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(tempArr[1])-1));
                }
                addf = false;
                enter=!enter;
                stop=!stop;
            } else if (rmvf){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.personInfo.get(tempArr[0]).rmvFriendPlace(Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(tempArr[1])-1));
                }
                rmvf = false;
                enter=!enter;
                stop=!stop;
            } else if (addt){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.personInfo.get(MyDesktop.ppID).addItem(Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(tempArr[0])-1),Information.objInfo.get(Integer.valueOf(tempArr[1])));
                }
                addt = false;
                enter=!enter;
                stop=!stop;
            } else if (rmvt){
                if (!input.equalsIgnoreCase("/exit")) {
                    String[] tempArr = input.split("\\s+");
                    Information.personInfo.get(MyDesktop.ppID).rmvItem(Information.personInfo.get(MyDesktop.ppID).HOMES.get(Integer.valueOf(tempArr[0])-1),Integer.valueOf(tempArr[1])-1);
                }
                rmvt = false;
                enter=!enter;
                stop=!stop;
            }
        }
        else if (input.equals("") & !enter){
            enter = !enter;
            input = "/null";
        }
        else if (enter){
            String tmp = input.toLowerCase(Locale.ROOT);
            if (tmp.contains("gachi")){new Sound().gachi();enter = !enter;}
            else if (stopCommand(input)){
                stop = true;
                switch (input){
                    case "/fluid"           :fluid++; break;
                    case "/login"           :login++; break;
                    case "/move"            : move  = true; InfoTap.output = "Enter w,s to scroll "; break;
                    case "/displayperson"   : dispp = true; InfoTap.output = "Please insert the ID of the person"; break;
                    case "/displayproperty" : dispr = true; InfoTap.output = "Please insert the ID of the property"; break;
                    case "/addperson"       : addpp = true; InfoTap.output = "Please insert 6 values:\n->1. Name\n->2. Year\n->3. Month\n->4. Day\n->5. Savings\n->6. Income"; break;
                    case "/addproperty"     : addpr = true; InfoTap.output = "Please insert 8 values:\n->1. Name\n->2. Apartment/House\n->3. Room Price\n->4. Room Capacity\n->5. Parking Lot Price\n->6. Parking Lot Capacity\n->7. Room size\n->8. and Parking Lot Size"; break;
                    case "/rentroom"        : rntr  = true; InfoTap.output = "Please insert 2 values:\n->1. Person ID\n->2. Property ID"; break;
                    case "/rentpark"        : rntp  = true; InfoTap.output = "Please insert 2 values:\n->1. Person ID\n->2. Property ID"; break;
                    case "/cancelroom"      : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}cncr  = true; InfoTap.output = "Please insert the Number of the Property(1-5)"; break;
                    case "/cancelpark"      : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}cncp  = true; InfoTap.output = "Please insert the Number of the Property(1-5)"; break;
                    case "/addfriend"       : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}addf  = true; InfoTap.output = "Please insert 2 values:\n->1. Friend ID\n->2. the Number of the Property(1-5)"; break;
                    case "/removefriend"    : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}rmvf  = true; InfoTap.output = "Please insert 2 values:\n->1. Friend ID\n->2. the Number of the Property(1-5)"; break;
                    case "/additem"         : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}addt  = true; InfoTap.output = "Please insert 2 values:\n->1. the Number of the Property(1-5)\n->2. Item ID"; break;
                    case "/removeitem"      : if(MyDesktop.panel!=5){enter=!enter;stop=!stop;break;}rmvt  = true; InfoTap.output = "Please insert 2 values:\n->1. the Number of the Property(1-5)\n->2. the Number of the Item"; break;

                    default: {enter=!enter;break;}
                }
            }else if (checkCommand(input)){
                switch (input){
                    case "/stop":{
                        TimeTracker.timeStop=!TimeTracker.timeStop;enter=!enter;break;}
                    case "/swap":MyDesktop.swap(); {enter=!enter;break;}
                    case "/save":new Information().save(); {enter=!enter;break;}

                    default: {enter=!enter;break;}
                }
            }else if (tmp.contains("/")&&!checkCommand(input)){new Sound().bonk();enter = !enter;}
            else enter = !enter;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void run(){
        while (true){runIns();}
    }
    static boolean stopCommand(String a){
        if (a == null)return false;
        String tmp = a.toLowerCase(Locale.ROOT);
        Matcher m = stopPat.matcher(tmp);
        return m.matches();
    }
    static boolean checkCommand(String a){
        if (a == null)return false;
        String tmp = a.toLowerCase(Locale.ROOT);
        Matcher m = checkPat.matcher(tmp);
        return m.matches();
    }
}
