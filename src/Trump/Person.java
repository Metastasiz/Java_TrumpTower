package Trump;

import java.util.*;

@SuppressWarnings("unchecked")
public class Person implements Comparable<Person>{
    static Map<String, Integer> STA_ID = new HashMap<>();
    List<Space> LIVES = new ArrayList<Space>();
    List<Space> HOMES = new ArrayList<Space>();
    Map<Space, List<Person>> FRIENDS = new HashMap<>();
    Map<Space, List<Item>> ITEMS = new HashMap<>();
    Map<Space, Letter> LETTERS = new HashMap<>();
    boolean max(){return HOMES.size()>=5;}
    Space getPark(){
        INIT_SORT();
        for (Space e : HOMES) if (e.type.equalsIgnoreCase("Park"))return e;
        return null;
    }
    void INIT_SORT(){
        Comparator<Space> comp2 = new Comp2();
        Collections.sort(HOMES, comp2);
    }
    void addItem(Space a, Item b){
        //badly fixed
        if (b == null)return;
        INIT_SORT();
        if (!a.type.equalsIgnoreCase("Park"))return;
        double maxv = a.prop.getVPark();
        if (maxv < b.getVol())return;
        double curv = 0;
        if (!ITEMS.containsKey(a) && maxv >= b.getVol()) {ITEMS.put(a,new ArrayList(Arrays.asList(b)));return;}
        for (Item e : ITEMS.get(a)){curv += e.getVol();}
        if (b.getVol() < maxv-curv){ITEMS.get(a).add(b);car++;}
        else {InfoTap.output = "Maximum capacity has been reached\nPlease consider removing items";}
        Collections.sort(ITEMS.get(a));
    }
    void rmvItem(Space a, int b){
        INIT_SORT();
        ITEMS.get(a).remove(b);
    }

    void addS(Space a){
        Comparator<Space> comp2 = new Comp2();
        if (HOMES.contains(a)||HOMES.size()>=5)return;
        if (a.type.equalsIgnoreCase("Room"))room++;
        else park++;
        HOMES.add(a);
        Collections.sort(HOMES, comp2);
    }
    void rmvS(Space a){
        Comparator<Space> comp2 = new Comp2();
        if (!HOMES.contains(a))return;
        if (a.type.equalsIgnoreCase("Room"))room--;
        else park--;
        HOMES.remove(a);
        Collections.sort(HOMES, comp2);
    }
    String getItem(){
        String out = "";
        INIT_SORT();
        int counter = 1;
        for (Space e : HOMES){
            out += "\n" + counter++ + ". ";
            out += e.getFullName();
            int counter2 = 1;
            if (ITEMS.containsKey(e)) {
                out += " and contains " + ITEMS.get(e).size() + " items";
                for (Item n : ITEMS.get(e)) {
                    out += "\n-> " + counter2++ + ". " + n.getInfo();
                }
            }
        }
        return out;
    }
    //spot, item name
    static final int maxLives = 3;
    String name;
    String ID = "";
    int friend = 0;
    final int prime = 16127, end = 104;
    int year, month, day;
    int mnY = 1990, mxY = 2005;
    int car = 0;
    final int minMoney = 2000, maxMoney = 100000, minInc = 1200, maxInc = 40000;
    int money  = (int)(Math.random()*(1+maxMoney-minMoney))+minMoney;
    int income = (int)(Math.random()*(1+maxInc-minInc)    )+minInc;
    int room = 0, park = 0;
    Person(){}
    Person(String name){this.name = name;INIT();}
    Person(String name, int year, int month, int day, int money, int income){
        this.name = name;
        this.year   = year;
        this.month  = month;
        this.day    = day;
        this.money = money;
        this.income = income;
        ID += year;
        ID += month;
        ID += day;
        register();
    }
    //for load only
    Person(String name, String ID, int money, int income){
        //need property builder
        this.name = name;
        this.year = Integer.valueOf(ID.substring(0,4));
        this.month = Integer.valueOf(ID.substring(4,6));
        this.day = Integer.valueOf(ID.substring(6,8));
        this.ID = ID;
        this.money = money;
        this.income = income;
        INIT_load();
    }
    void INIT(){
        dob();
        register();
    }
    void dob(){
        if (!ID.equalsIgnoreCase("")){return;}
        String tmp = ""; ID = ""; day = 1;
        boolean feb = false;
        year = (int)(Math.random()*(mxY-mnY+1))+mnY;
        if (year%4==0) feb = true;
        month = (int)(Math.random()*12)+1;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {day = (int)(Math.random()*31)+1; break;}

            case 4:
            case 6:
            case 9:
            case 11: {day = (int)(Math.random()*30)+1; break;}

            case 2: {if (feb) {day = (int)(Math.random()*29)+1; break;} else day = (int)(Math.random()*28)+1; break;}
        }
        ID += year;
        tmp += month;
        if (tmp.length()==1) ID += "0" + month;
        else ID += month;
        tmp = "";
        tmp += day;
        if (tmp.length()==1) ID += "0" + day;
        else ID += day;
    }
    void INIT_load(){
        String tmp = Integer.toString(year);
        tmp += Integer.toString(month);
        tmp += Integer.toString(day);
        if(!STA_ID.containsKey(tmp)){
            STA_ID.put(tmp,prime);
        } else {
            STA_ID.computeIfPresent(tmp, (k,v) -> v+end);
        }
    }
    void register(){
        String tmp = ID;
        if(!STA_ID.containsKey(tmp)){
            STA_ID.put(tmp,prime);
            //1677208
            ID += "000" + prime;
        } else {
            STA_ID.put(tmp, STA_ID.get(tmp)+end);

            String tmp2 = Integer.toString(STA_ID.get(tmp));
            int temp = 8-tmp2.length();
            for (int i = 0; i < temp; i++){
                ID += "0";
            }
            ID += tmp2;
        }
    }
    String getInfo(){
        Comparator<Space> comp2 = new Comp2();
        List<Space> tmp = new ArrayList<Space>();
        for (Space e : LIVES)tmp.add(e);
        Collections.sort(tmp,comp2);
        String lives = "\nAnd also registered in " + LIVES.size() + " other properties";
        int counter = 1;
        for (Space e : tmp){
            lives += "\n" + counter++ + ". " + e.getFullName();
        }
        if (LIVES.size() == 0) lives = "";
        return name + " ID: " + ID + " has $" + money + " with net income of $" + income + " per month, and owns " + HOMES.size() + " properties" + getItem() + getFriends() + lives;}
    int monthlyEx(){
        int total = 0;
        for (Space e : HOMES){
            if (e.type.equalsIgnoreCase("Room")) {
                money += e.prop.getRoomPrice();
            } else if (e.type.equalsIgnoreCase("Park")) {
                money += e.prop.getParkPrice();
            }
        }
        return total;
    }
    void monthly(){
        for (Space e : HOMES){
            if (e.type.equalsIgnoreCase("Room")) {
                if (money - e.prop.getRoomPrice() < 0){
                    if (LETTERS.containsKey(e)){e.prop.rmvRTenant(this,e.ID);LETTERS.remove(e);}
                    else if (!LETTERS.containsKey(e)){LETTERS.put(e,new Letter(this,e));}
                }
                else {
                    money -= e.prop.getRoomPrice();
                    if (LETTERS.containsKey(e)){LETTERS.remove(e);}
                }
            } else if (e.type.equalsIgnoreCase("Park")) {
                if (money - e.prop.getParkPrice() < 0){
                    if (LETTERS.containsKey(e)){e.prop.rmvRTenant(this,e.ID);LETTERS.remove(e);}
                    else if (!LETTERS.containsKey(e)){LETTERS.put(e,new Letter(this,e));}
                }
                else {
                    money -= e.prop.getParkPrice();
                    if (LETTERS.containsKey(e)){LETTERS.remove(e);}
                }
            }
        }
        money += income;
        Notification.log = "AT " + MyTime.time + ": Another month has passed, what have you done with your life?";

    }
    boolean checkIfRoom(Property a){
        for (Space e: HOMES){
            if (e.prop.getID() == a.getID() && e.type.equalsIgnoreCase("Room")) return true;
        }
        return false;
    }

    boolean checkIfPark(Property a){
        for (Space e: HOMES){
            if (e.prop.getID() == a.getID() && e.type.equalsIgnoreCase("Park")) return true;
        }
        return false;
    }
    void addFriendPlace(Space a){
        if (a==null)return;
        if (a.ownerID==null)return;
        if (!Information.personInfo.get(a.ownerID).FRIENDS.containsKey(a)){
            Information.personInfo.get(a.ownerID).FRIENDS.put(a,new ArrayList(Arrays.asList(this)));
        }
        else {Information.personInfo.get(a.ownerID).FRIENDS.get(a).add(this);}
        LIVES.add(a);
    }
    void rmvFriendPlace(Space a){
        Information.personInfo.get(a.ownerID).FRIENDS.get(a).remove(this);
        if (Information.personInfo.get(a.ownerID).FRIENDS.get(a).size()==0){Information.personInfo.get(a.ownerID).FRIENDS.remove(a);}
        LIVES.remove(a);
    }
    Space getAvRoom(){
        Space out = null;
        for (Space e : HOMES){
            out = e; break;
        }
        return out;
    }
    Space getFrRoom(){
        Space out = null;
        for (Space e : HOMES){
            if (e.type.equalsIgnoreCase("park"))continue;
            if(!FRIENDS.containsKey(e)){out = e;break;}
            if (FRIENDS.get(e).size() < 3) {out = e;break;}
        }
        return out;
    }

    @Override
    public int compareTo(Person o) {
        int k = name.compareToIgnoreCase(o.name);
        return k;
    }
    String getFriends(){
        String out = "";
        if (FRIENDS.size()!=0){out += "\nAnd also has other people registered in these properties";}
        else return "";
        int counter = 1;
        for (Map.Entry<Space, List<Person>> e : FRIENDS.entrySet()){
            out += "\n" + counter++ + ". " + e.getKey().getFullName() + " has " + e.getValue().size()+ " other people registered in it";
            int counter2 = 1;
            for (Person n : e.getValue()){
                out += "\n-> " + counter2++ + ". " + n.name + " ID: " + n.ID;
            }
        }
        return out;
    }
}