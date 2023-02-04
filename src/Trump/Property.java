package Trump;

import java.util.*;

class Property implements Comparable<Property>{
    Map<Integer, Room> room = new HashMap<>();
    Map<Integer, Park> park = new HashMap<>();
    static final int mnvroom = 4, mxvroom = 15, roomh = 3;
    static final int mnvpark = 5, mxvpark = 7, parkh = 5;
    static int STA_counter1 = 0, STA_round = 1;
    static final int prime = 16127, end = 104;
    int counter2 = 0, counter3 = 0, counter4 = 0;
    String ID = "";
    //
    Volumn vroom, vpark;
    String name, tName;
    int rp, pp, mxr, mxp, curr, curp;
    Person[] parkTenant, roomTenant;
    //
    //
    Property(){}
    Property(String name, String tName, int rp, int mxr, int pp, int mxp, double vroom, double vpark)
    {
        this.name = name;
        INIT_ID();
        if (tName.equalsIgnoreCase("house"))this.tName = "House";
        if (tName.equalsIgnoreCase("apartment"))this.tName = "Apartment";

        this.rp = rp;
        this.mxr = mxr;

        this.pp = pp;
        this.mxp = mxp;

        this.vroom = new Volumn(vroom);
        this.vpark = new Volumn(vpark);

        roomTenant = new Person[mxr];
        parkTenant = new Person[mxp];

        curr = mxr;
        curp = mxp;
        INIT_LIST();
    }
    Property(String name, String ID, String tName, int rp, int mxr, int pp, int mxp, double vroom, double vpark)
    {
        this.name = name;
        this.ID = ID;
        this.tName = tName;

        this.rp = rp;
        this.mxr = mxr;

        this.pp = pp;
        this.mxp = mxp;

        this.vroom = new Volumn(vroom);
        this.vpark = new Volumn(vpark);

        roomTenant = new Person[mxr];
        parkTenant = new Person[mxp];

        curr = mxr;
        curp = mxp;
        INIT_LIST();
    }
    Property(String name){INIT(); this.name = name;INIT_LIST();}
    void INIT_ID(){
        if (STA_counter1>end*prime) {
            if(STA_round == prime){System.out.println("Unique number has already been initiated");return;}
            STA_counter1=STA_round++;
        }
        counter2=STA_counter1/36;
        counter3=counter2/36;
        counter4=counter3/36;
        ID+=intToChar(counter4);
        ID+=intToChar(counter3);
        ID+=intToChar(counter2);
        ID+=intToChar(STA_counter1);
        STA_counter1+=prime;
    }
    void INIT_LIST(){
        for (int i = 0; i < getMaxRoom(); i++){
            room.put(i, new Room(this, i));
        }
        for (int i = 0; i < getMaxPark(); i++){
            park.put(i, new Park(this, i));
        }
    }
    void INIT(){
        INIT_ID();
        PType type = new Apartment();
        if ((int)(Math.random()*10)+1 > 3) {type = new House();}

        tName = type.getName();
        mxr = type.getMaxRoom(); mxp = type.getMaxPark();
        rp = type.getRoomPrice(); pp = type.getParkPrice();
        roomTenant = new Person[mxr];
        parkTenant = new Person[mxp];
        curr = mxr;
        curp = mxp;

        vroom = new Volumn(mnvroom,mxvroom,roomh);
        if (mxp==0) vpark = new Volumn(0);
        else vpark = new Volumn(mnvpark,mxvpark,parkh);
    }
    char intToChar(int a){
        int tmp = a%36;
        if (tmp < 10) return (char)(tmp+48);
        else return (char)(tmp+55);
    }
    int getNo(){
        int round = STA_counter1%prime;
        int no = (STA_counter1-round)/prime;
        return (no+round*end);
    }
    int getCur(Person[] a){
        int out = 0;
        for (int i = 0; i < a.length; i++){if (a[i]==null)out++;}
        return out;
    }
    void addRTenant(Person a, int no){
        if (a.LETTERS.size() >= 3){InfoTap.output = "This person has more than 3 letters";return;}
        if (no >= 0 && no < mxr && roomTenant[no] == null) {
            if(!a.max()) {
                Room tmp = this.room.get(no);
                tmp.setOwner(a.ID);
                roomTenant[no] = a;
                a.addS(tmp);
                curr = getCur(roomTenant);
                InfoTap.output = "Successfully added a Room";
                return;
            } else {InfoTap.output = "This person has reach\nthe maximum of 5 properties";return;}
        }
        else if (no < 0) {InfoTap.output = "The room of " + this.getType() + " is full";return;}
        else if (no >= mxr){InfoTap.output = "The input value is out of bound";return;}
        InfoTap.output = "Unknown error";
    }
    void addPTenant(Person a, int no){
        if (a.LETTERS.size() >= 3){InfoTap.output = "This person has more than 3 letters";return;}
        if (no >= 0 && no < mxp && parkTenant[no] == null) {
            if(!a.max()) {
                Park tmp = this.park.get(no);
                tmp.setOwner(a.ID);
                parkTenant[no] = a;
                a.addS( tmp);
                curp = getCur(parkTenant);
                InfoTap.output = "Successfully added a Parking Lot";
            } else {
                InfoTap.output = "This person has reach\nthe maximum of 5 properties";
            }
            return;
        }
        else if (no < 0) {InfoTap.output = "The parking lot of " + this.getType() + " is full";return;}
        else if (no >= mxp){InfoTap.output = "The input value is out of bound";return;}
        InfoTap.output = "Unknown error";
    }

    void rmvRTenant(Person a, int no){
        if (no >= 0 && no < mxr) {
            Room tmp = this.room.get(no);
            //remove friends' place
            if (a.FRIENDS.get(room.get(no))!=null) {
                for (Person e : a.FRIENDS.get(room.get(no))){
                    e.LIVES.remove(room.get(no));
                }
            }
            //remove friends
            a.FRIENDS.remove(room.get(no));
            //remove items
            a.ITEMS.remove(a.FRIENDS.get(room.get(no)));
            //
            tmp.rmvOwner();
            roomTenant[no] = null;
            a.rmvS(tmp);
            curr = getCur(roomTenant);
            InfoTap.output = "Successfully removed a Room";
            return;
        }
        else if (no >= mxr || no < 0){InfoTap.output = "The input value is out of bound";return;}
        InfoTap.output = "Unknown error";
    }
    void rmvPTenant(Person a, int no){
        if (no >= 0 && no < mxp) {
            Park tmp = this.park.get(no);
            //remove friends' place
            if (a.FRIENDS.get(park.get(no))!=null){
                for (Person e : a.FRIENDS.get(park.get(no))){
                    e.LIVES.remove(park.get(no));
                }
            }
            //remove friends
            a.FRIENDS.remove(room.get(no));
            //remove items
            a.ITEMS.remove(a.FRIENDS.get(park.get(no)));
            //
            tmp.rmvOwner();
            parkTenant[no] = null;
            a.rmvS(tmp);
            curp = getCur(parkTenant);
            InfoTap.output = "Successfully removed a Parking Lot";
            return;
        }
        else if (no >= mxp || no < 0){InfoTap.output = "The input value is out of bound";return;}
        InfoTap.output = "Unknown error";
    }
    int getAvRoom(){
        for (int i = 0; i < mxr; i++){
            if (roomTenant[i] == null) return i;
        }
        return -1;
    }
    int getAvPark(){
        for (int i = 0; i < mxp; i++){
            if (parkTenant[i] == null) return i;
        }
        return -1;
    }
    String getID(){return ID;}
    String getName(){return name;}
    String getType(){return tName;}
    String getFullName(){
        if (tName.equalsIgnoreCase("Apartment"))return getName() + " " + tName + " ID: " + ID;
        else if (tName.equalsIgnoreCase("House"))return tName + " of " + getName()  + " ID: " + ID;
        return "Unknown type " + getName()  + " ID: " + ID;
    }
    int getRoomPrice(){return rp;}
    int getParkPrice(){return pp;}
    int getMaxRoom(){return mxr;}
    int getMaxPark(){return mxp;}
    int getCurRoom(){return getCur(roomTenant);}
    int getCurPark(){return getCur(parkTenant);}
    double getVRoom(){return vroom.size;}
    double getVPark(){return vpark.size;}
    String getInfo(){
        int counter = 1;
        String out = getFullName() + ", Available Room: " + getCurRoom() + "/" + getMaxRoom() + " at " + getVRoom() + " m2 at $" + getRoomPrice() + ", Available Parking lot: " + getCurPark() + "/" + getMaxPark() + " at " + getVPark() + " m2 at $" + getParkPrice();
        for (int i = 0; i < mxr; i++){
            if (roomTenant[i] != null) {
                out += "\n" + counter++ + ". Room ID: " + i + " is occupied by ";
                out += roomTenant[i].name;
            }
        }
        for (int i = 0; i < mxp; i++){
            if (parkTenant[i] != null) {
                out += "\n" + counter++ + ". Parking lot ID: " + i + " is occupied by ";
                out += parkTenant[i].name;
            }
        }
        return out;
    }

    @Override
    public int compareTo(Property o) {
        int k = name.compareToIgnoreCase(o.name);
        return k;
    }
}

abstract class Space{
    String ownerID;
    String name;
    String type;
    Property prop;
    int ID;
    String getFullName(){String out = "";
        if (type.equalsIgnoreCase("Room")){out += prop.getVRoom();}
        else {out += prop.getVPark();}
        return prop.getFullName() + ", " + name + ID + " with size of " + out + " m3";
    }
    int getID(){return ID;}
    void setOwner(String ID){this.ownerID = ID;}
    void rmvOwner(){this.ownerID=null;}
}
class Room extends Space{
    Room(Property prop, int ID){this.prop = prop; prop.room.put(ID,this); name = "Room ID: "; this.ID = ID; type = "Room";}
}
class Park extends Space{
    Park(Property prop, int ID){this.prop = prop; prop.park.put(ID,this); name = "Parking lot ID: "; this.ID = ID; type = "Park";}
}
class Comp2 implements Comparator<Space> {
    @Override
    public int compare(Space o1, Space o2) {
        if (o1.prop.vroom.size!= o2.prop.vroom.size) return (int)(o1.prop.vroom.size - o2.prop.vroom.size);
        else if (o1.prop.vpark.size!= o2.prop.vpark.size) return (int)(o1.prop.vpark.size - o2.prop.vpark.size);
        else if (!o1.type.equalsIgnoreCase(o2.type)) {return o1.type.equalsIgnoreCase("Room")?-1:1;}
        return 0;
    }
}
class PType{
    private String tName;
    private int mnr, mxr, mnp, mxp, cr, cp;
    private int mnrp, mnpp, mxrp, mxpp, crp, cpp;
    PType(String name, int minRoom, int maxRoom, int minPark, int maxPark, int minRPrice, int maxRPrice, int minPPrice, int maxPPrice)
    {
        tName = name;
        mnr = minRoom; mxr = maxRoom;
        mnp = minPark; mxp = maxPark;
        mnrp = minRPrice; mxrp = maxRPrice;
        mnpp = minPPrice; mxpp = maxPPrice;
        INIT();
    }
    void INIT(){
        cr = (int)(Math.random()*(mxr-mnr+1))+mnr;
        cp = (int)(Math.random()*(mxp-mnp+1))+mnp;
        crp = (int)(Math.random()*(mxrp-mnrp+1))+mnrp;
        cpp = (int)(Math.random()*(mxpp-mnpp+1))+mnpp;
    }
    String getName(){return tName;}
    int getMaxRoom(){return cr;}
    int getMaxPark(){return cp;}
    int getRoomPrice(){return crp;}
    int getParkPrice(){return cpp;}
}
class Apartment extends PType{
    Apartment(){super("Apartment",10,30,30,50, 800, 3000, 200, 600);}
}
class House extends PType{
    House(){super("House",2,5,0,3, 600, 1500, 100, 300);}
}

class testP{
    public static void main(String[] arg){
        Person przemek = new Person("Przemek"), mark = new Person("Mark");
        Property cunt = new Property("pepe");
        Item[] sample1 = {new Obj("asdf"), new Obj("fgd"), new Obj("cxvb"), new Obj("cv")};
        System.out.println(cunt.getFullName());
        System.out.println(cunt.getRoomPrice());
        System.out.println(cunt.getParkPrice());
        System.out.println(cunt.getMaxRoom());
        System.out.println(cunt.getCurRoom());

        cunt.addRTenant(przemek, cunt.getAvRoom());
        cunt.addRTenant(przemek, cunt.getAvRoom());
        cunt.addRTenant(mark, cunt.getAvRoom());
        cunt.addRTenant(przemek, cunt.getAvRoom());
        mark.addItem(mark.HOMES.get(0), sample1[0]);
        mark.addItem(mark.HOMES.get(0), sample1[1]);


        cunt.addPTenant(przemek, cunt.getAvPark());
        cunt.addPTenant(przemek, cunt.getAvPark());
        cunt.addPTenant(przemek, cunt.getAvPark());

        System.out.println(cunt.getMaxRoom());
        System.out.println(cunt.getCurRoom());
        //
        System.out.println(cunt.getInfo());
        System.out.println(przemek.getInfo());
        System.out.println(mark.getInfo());
        System.out.println("    cut");
        //
        Information.propertyInfo.put(cunt.ID, cunt);
        Information.personInfo.put(przemek.ID, przemek);
        Information.personInfo.put(mark.ID, mark);

        mark.addFriendPlace(przemek.getAvRoom());
        //
        if (Information.propertyInfo.containsKey(cunt.ID))
        Information.propertyInfo.get(cunt.ID).rmvRTenant(Information.personInfo.get(przemek.ID),1);

        //
        System.out.println(cunt.getInfo());
        System.out.println(przemek.getInfo());
        System.out.println(mark.getInfo());
        System.out.println("    cut");

        mark.rmvItem(mark.HOMES.get(0),0);
        Information.personInfo.get(mark.ID).rmvFriendPlace(przemek.HOMES.get(0));

        System.out.println(cunt.getInfo());
        System.out.println(przemek.getInfo());
        System.out.println(mark.getInfo());
    }
}
