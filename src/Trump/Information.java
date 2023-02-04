package Trump;

import java.io.IOException;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Information {
    static String output;
    static int phase = 0;
    static final String
            names = "names.txt", savenames = "savenames.txt",
            properties = "properties.txt", saveproperties = "saveproperties.txt",
            cars = "cars.txt", savecars = "savecars.txt",
            objs = "objs.txt", saveobjs = "saveobjs.txt",
            saveitems = "saveitems.txt"
    ;
    static Map<String, Person> personInfo = new HashMap<>();
    static Map<String, Property> propertyInfo = new HashMap<>();
    static Map<Integer, Car> carInfo = new HashMap<>();
    static Map<Integer, Obj> objInfo = new HashMap<>();
    public static void main(String[] arg){
        Information a = new Information();
        a.INIT();
        //a.oprint();
        //a.cprint();
        //a.nprint();
        a.testprint();
        //a.pprint();
    }
    Information(){}
    void save(){
        pSave();
        nSave();
        cSave();
        oSave();
        iSave();
        InfoTap.output = "SAVE SUCCESSFULLY";
    }
    void testprint(){
        for (Map.Entry<String, Person> e : personInfo.entrySet()) {
            System.out.println(e.getValue().getInfo());
            //for (Space i : e.getValue().HOMES) System.out.println(i.getFullName());
            System.out.println();
        }
    }
    void INIT(){
        output = "INITIATING...";
        output = "GENERATING PROPERTIES...";
        INIT_PROPERTY();
        output = "GENERATING CITIZEN...";
        INIT_NAME();
        output = "GENERATING OBJECTS...";
        INIT_OBJ();
        output = "GENERATING VEHICLES...";
        INIT_CAR();
        if (!(nexist() && pexist())) {
            output = "GENERATING ADDRESSES...";
            INIT_GETPLACE();
            output = "GENERATING RELATIONSHIPS...";
            INIT_FRIEND();
        }
        output = "GENERATING VEHICLES...";
        INIT_VEHICLES();
        output = "GENERATING ITEMS...";
        INIT_POSSESSION();

        save();
        phase = 1;
        try {Thread.sleep(1000);}
        catch (Exception e){}
        InfoTap.output = "GENERATION COMPLETED";
    }
    //
    //
    //
    //
    void INIT_NAME(){
        String temp;
        String loadFrom = names;
        int total = 0;
        if (nexist()){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
            ){
                int checkl = 0;
                while (br1.readLine() != null)checkl++;
                if (checkl>1)loadFrom = savenames;
            }catch (Exception e){}
        }
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
                )
        {
            while (br2.readLine() != null){total++;}
            int counter = 0;
            while ((temp = br1.readLine()) != null) {
                output = "GENERATING CITIZEN..." + (100*counter++)/total + "%";
                String[] tempArr = temp.split("\\s+");
                String name = tempArr[0];
                if (tempArr.length >= 4){
                    String rawID = tempArr[1];
                    int money = Integer.valueOf(tempArr[2]);
                    int income = Integer.valueOf(tempArr[3]);
                    Person t = new Person(name, rawID, money, income);
                    personInfo.put(rawID, t);
                    for (int i = 4; i < tempArr.length; i++){
                        String[] tempArr2 = tempArr[i].split(",");
                        if (tempArr2[0].equalsIgnoreCase("null")) continue;
                        if (tempArr2.length == 3){
                            int rmID = Integer.valueOf(tempArr2[tempArr2.length-1]);
                            if (tempArr2[1].equalsIgnoreCase("Room"))propertyInfo.get(tempArr2[0]).addRTenant(t,rmID);
                            else if (tempArr2[1].equalsIgnoreCase("Park"))propertyInfo.get(tempArr2[0]).addPTenant(t,rmID);
                        } else if (tempArr2.length == 2){
                            int rmID = Integer.valueOf(tempArr2[tempArr2.length-1]);
                            t.addFriendPlace(propertyInfo.get(tempArr2[0]).room.get(rmID));
                        }
                    }
                } else {
                    Person t = new Person(name);
                    personInfo.put(t.ID, t);
                }
            }
        }
        catch (IOException e) {}
    }
    void nprint(){
        for (Map.Entry<String, Person> e : personInfo.entrySet())
        {System.out.println(e.getValue().getInfo()+"\n");}
        System.out.println(personInfo.size());
    }
    String nSave(){
        nexist();
        try {
            FileWriter writer = new FileWriter(savenames);
            for (Map.Entry<String, Person> e : personInfo.entrySet()){
                writer.write(e.getValue().name + " ");
                writer.write(e.getValue().ID + " ");
                writer.write(e.getValue().money + " ");
                writer.write(e.getValue().income + " ");


                for (Space n : e.getValue().HOMES){
                    writer.write(n.prop.getID() + "," + n.type + "," + n.ID + " ");
                }
                int counter = 0;
                for (Space n : e.getValue().LIVES){
                    //null,null
                    writer.write(n.prop.getID() + "," + n.ID + " ");
                    counter++;
                }
                counter = new Person().maxLives - counter;
                for (int i = 0; i < counter; i++){
                    writer.write( "null,null ");
                }
                writer.write( "\n");
            }
            writer.close();
            return "Save Successfully";
        } catch (IOException e) {}
        return "Unknown error";
    }
    boolean nexist(){
        File file = new File(savenames);
        if (file.exists()){return true;}
        return false;
    }
    //
    //
    //
    //
    void INIT_PROPERTY(){
        String temp;
        String loadFrom = properties;
        int total = 0;
        if (pexist()){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
            ){
                int checkl = 0;
                while (br1.readLine() != null)checkl++;
                if (checkl>1)loadFrom = saveproperties;
            }catch (Exception e){}
        }
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
        )
        {
            while (br2.readLine() != null){total++;}
            int counter = 0;
            while ((temp = br1.readLine()) != null) {
                output = "GENERATING PROPERTIES..." + (100*counter++)/total + "%";
                String[] tempArr = temp.split("\\s+");
                String name = tempArr[0];
                if (tempArr.length == 9) {
                    String rawID       = (tempArr[1]);
                    String tName    = (tempArr[2]);
                    int rp          = Integer.valueOf(tempArr[3]);
                    int mxr         = Integer.valueOf(tempArr[4]);

                    int pp          = Integer.valueOf(tempArr[5]);
                    int mxp         = Integer.valueOf(tempArr[6]);

                    double vroom       = Double.valueOf(tempArr[7]);
                    double vpark       = Double.valueOf(tempArr[8]);
                    Property t = new Property(name, rawID, tName, rp, mxr, pp, mxp, vroom, vpark);
                    propertyInfo.put(rawID, t);
                } else {
                    Property t = new Property(name);
                    propertyInfo.put(t.ID, t);
                }

            }
            new Property().STA_counter1 += counter;
        }
        catch (IOException e) {}
    }
    void pprint(){
        for (Map.Entry<String, Property> e : propertyInfo.entrySet()) {
            if (e.getValue().getCurRoom()!=e.getValue().getMaxRoom())
                System.out.println(e.getValue().getInfo());
        }
        System.out.println(propertyInfo.size());
    }
    String pSave(){
        pexist();
        try {
            FileWriter writer = new FileWriter(saveproperties);
            for (Map.Entry<String, Property> e : propertyInfo.entrySet()){
                writer.write(e.getValue().name + " ");
                writer.write(e.getValue().ID + " ");
                writer.write(e.getValue().tName + " ");

                writer.write(e.getValue().rp + " ");
                writer.write(e.getValue().mxr + " ");

                writer.write(e.getValue().pp + " ");
                writer.write(e.getValue().mxp + " ");

                writer.write(e.getValue().getVRoom() + " ");
                writer.write(e.getValue().getVPark() + "\n");

            }
            writer.close();
            return "Save Successfully";
        } catch (IOException e) {}
        return "Unknown error";
    }
    boolean pexist(){
        File file = new File(saveproperties);
        if (file.exists()){return true;}
        return false;
    }
    //
    //
    //
    //
    void INIT_CAR(){
        String temp;
        String loadFrom = cars;
        int total = 0;
        if (cexist()){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
            ){
                int checkl = 0;
                while (br1.readLine() != null)checkl++;
                if (checkl>1)loadFrom = savecars;
            }catch (Exception e){}
        }
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
        )
        {
            while (br2.readLine() != null){total++;}
            int counter = 0;
            while ((temp = br1.readLine()) != null) {
                output = "GENERATING VEHICLES..." + (100*counter++)/total + "%";
                String[] tempArr = temp.split("\\s+");
                String name = tempArr[0];
                if (tempArr.length == 5) {
                    name = tempArr[1];
                    int cap = Integer.valueOf(tempArr[2]);
                    int price = Integer.valueOf(tempArr[3]);
                    double vol = Double.valueOf(tempArr[4]);
                    Car t = new Car(name, cap, price, vol, Integer.valueOf(tempArr[0]));
                    carInfo.put(Integer.valueOf(tempArr[0]), t);
                } else {
                    Car t = new Car(name);
                    carInfo.put(t.ID, t);
                }

            }
        }
        catch (IOException e) {}
    }
    void cprint(){
        for (Map.Entry<Integer, Car> e : carInfo.entrySet())
        {System.out.println(e.getValue().getInfo());}
        System.out.println(carInfo.size());
    }
    String cSave(){
        cexist();
        try {
            FileWriter writer = new FileWriter(savecars);
            for (Map.Entry<Integer, Car> e : carInfo.entrySet()){
                writer.write(e.getKey() + " ");
                writer.write(e.getValue().name + " ");
                writer.write(e.getValue().capacity + " ");
                writer.write(e.getValue().price + " ");
                writer.write(e.getValue().vol.size + "\n");
            }
            writer.close();
            return "Save Successfully";
        } catch (IOException e) {}
        return "Unknown error";
    }
    boolean cexist(){
        File file = new File(savecars);
        if (file.exists()){return true;}
        return false;
    }
    //
    //
    //
    //
    void INIT_OBJ(){
        String temp;
        String loadFrom = objs;
        int total = 0;
        if (oexist()){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
            ){
                int checkl = 0;
                while (br1.readLine() != null)checkl++;
                if (checkl>1)loadFrom = saveobjs;
            }catch (Exception e){}
        }
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
        )
        {
            while (br2.readLine() != null){total++;}
            int counter = 0;
            while ((temp = br1.readLine()) != null) {
                output = "GENERATING OBJECTS..." + (100*counter++)/total + "%";
                String[] tempArr = temp.split("\\s+");
                String name = tempArr[0];
                if (tempArr.length == 4) {
                    name = tempArr[1];
                    int price = Integer.valueOf(tempArr[2]);
                    double vol = Double.valueOf(tempArr[3]);
                    Obj t = new Obj(name, price, vol, Integer.valueOf(tempArr[0]));
                    objInfo.put(Integer.valueOf(tempArr[0]), t);
                } else {
                    Obj t = new Obj(name);
                    objInfo.put(t.ID, t);
                }

            }
        }
        catch (IOException e) {}
    }
    void oprint(){
        for (Map.Entry<Integer, Obj> e : objInfo.entrySet())
        {System.out.println(e.getValue().getInfo());}
        System.out.println(objInfo.size());
    }
    String oSave(){
        oexist();
        try {
            FileWriter writer = new FileWriter(saveobjs);
            for (Map.Entry<Integer, Obj> e : objInfo.entrySet()){
                writer.write(e.getKey() + " ");
                writer.write(e.getValue().name + " ");
                writer.write(e.getValue().price + " ");
                writer.write(e.getValue().vol.size + "\n");
            }
            writer.close();
            return "Save Successfully";
        } catch (IOException e) {}
        return "Unknown error";
    }
    boolean oexist(){
        File file = new File(saveobjs);
        if (file.exists()){return true;}
        return false;
    }
    //
    //
    //
    //
    void INIT_GETPLACE(){
        int total = personInfo.size();
        int counter = 0;
        for (Map.Entry<String, Person> e : personInfo.entrySet())
        {
            if (e.getValue().income*3/10 < e.getValue().monthlyEx()) continue;
            for (Map.Entry<String, Property> i : propertyInfo.entrySet())
            {
                if (e.getValue().income*3/10 < e.getValue().monthlyEx()) break;
                int t = (int)(Math.random()*100)+1;
                if (t < 10) {
                    if (AI_LOGIC_ROOM(e.getValue(), i.getValue())) {
                        i.getValue().addRTenant(e.getValue(), i.getValue().getAvRoom());
                    }
                    if (AI_LOGIC_PARK(e.getValue(), i.getValue())) {
                        i.getValue().addPTenant(e.getValue(), i.getValue().getAvPark());
                    }
                }
            }
            output = "GENERATING ADDRESSES..." + (100*counter++)/total + "%";
        }
    }
    void INIT_FRIEND(){
        int total = personInfo.size();
        int counter = 0;
        for (Map.Entry<String, Person> i : personInfo.entrySet()){
            if (i.getValue().LIVES.size() == 3) continue;
            for (Map.Entry<String, Person> e : personInfo.entrySet()){
                if (i.getValue().LIVES.size() == 3) break;
                if (e.getKey() == i.getKey()) continue;
                if (AI_LOGIC_FRIEND(e.getValue(), i.getValue()) && e.getValue().room > 0 && i.getValue().LIVES.size() < i.getValue().maxLives){
                    int t = (int)(Math.random()*100)+1;
                    if (t < 5) {
                        e.getValue().friend++;
                        i.getValue().friend++;
                        i.getValue().addFriendPlace(e.getValue().getFrRoom());
                    }
                }
            }
            output = "GENERATING RELATIONSHIPS..." + (100*counter++)/total + "%";
        }
    }
    void INIT_POSSESSION(){
        String temp;
        String loadFrom = saveitems;
        int total = 0;
        int checkl = 0;
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
        ){
            while (br1.readLine() != null)checkl++;
        }catch (Exception e){}
        if (checkl>1){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                    BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
            )
            {
                while (br2.readLine() != null){total++;}
                int counter = 0;
                while ((temp = br1.readLine()) != null) {
                    output = "GENERATING POSSESSIONS..." + (100*counter++)/total + "%";
                    String[] tempArr = temp.split("\\s+");
                    //ID, type, propID, spaceID, itemID+
                    if (!tempArr[1].equalsIgnoreCase("obj")) continue;
                    String ID = tempArr[0];
                    personInfo.get(ID).INIT_SORT();
                    for (int i = 4; i < tempArr.length; i++) {
                        personInfo.get(ID).addItem(propertyInfo.get(tempArr[2]).park.get(Integer.valueOf(tempArr[3])), objInfo.get(Integer.valueOf(tempArr[i])));
                    }
                }
            }
            catch (IOException e) {}
        } else {
            for (Map.Entry<String, Person> e : personInfo.entrySet()){
                if ((int)(Math.random()*100)+1 < 80){
                    if (e.getValue().getPark()!=null){
                        e.getValue().addItem(e.getValue().getPark(),objInfo.get((int)(Math.random()*objInfo.size())));
                    }
                }
            }
        }
    }
    void iSave(){
        try {
            FileWriter writer = new FileWriter(saveitems);
            for (Map.Entry<String, Person> e : personInfo.entrySet()){
                if (e.getValue().HOMES.size() < 1) continue;
                //ID, type, propID, spaceID, itemID+
                //ID, type, propID, spaceID, itemID+
                String ID = e.getValue().ID;
                for (Map.Entry<Space, List<Item>> n : e.getValue().ITEMS.entrySet()){
                    String propID = n.getKey().prop.ID;
                    int spaceID = n.getKey().ID;
                    int obj = 0;
                    for (Item i : n.getValue()){
                        if (i.type.equalsIgnoreCase("obj")){
                            if (obj++ == 0){writer.write(ID + " " + "obj" + " " + propID + " " + spaceID + " ");}
                            writer.write(i.ID + " ");
                        }
                    }
                    if (obj > 0)writer.write("\n");
                    int car = 0;
                    for (Item i : n.getValue()){
                        if (i.type.equalsIgnoreCase("car")){
                            if (car++ == 0){writer.write(ID + " " + "car" + " " + propID + " " + spaceID + " ");}
                            writer.write(i.ID + " ");
                        }
                    }
                    if (car > 0)writer.write("\n");
                }
            }
            writer.close();
            return;
        } catch (IOException e) {}
    }
    void INIT_VEHICLES(){
        String temp;
        String loadFrom = saveitems;
        int total = 0;
        int checkl = 0;
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
        ){
            while (br1.readLine() != null)checkl++;
        }catch (Exception e){}
        if (checkl>1){
            try (
                    BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                    BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
            )
            {
                while (br2.readLine() != null){total++;}
                int counter = 0;
                while ((temp = br1.readLine()) != null) {
                    //ID, prop.id,
                    output = "GENERATING VEHICLES..." + (100*counter++)/total + "%";
                    String[] tempArr = temp.split("\\s+");
                    //ID, type, propID, spaceID, itemID+
                    if (!tempArr[1].equalsIgnoreCase("obj")) continue;
                    String ID = tempArr[0];
                    personInfo.get(ID).INIT_SORT();
                    for (int i = 4; i < tempArr.length; i++)
                        personInfo.get(ID).addItem(propertyInfo.get(tempArr[2]).park.get(Integer.valueOf(tempArr[3])),carInfo.get(Integer.valueOf(tempArr[i])));
                }
            }
            catch (IOException e) {}

        } else {
            for (Map.Entry<String, Person> e : personInfo.entrySet()){
                if (e.getValue().getPark()!=null&&e.getValue().car < 2){
                    e.getValue().addItem(e.getValue().getPark(),carInfo.get((int)(Math.random()*carInfo.size())));
                }
            }
        }
    }
    boolean AI_LOGIC_ROOM(Person a, Property b){
        int totalEx = a.monthlyEx();
        if (a.checkIfRoom(b)) return false;
        else if (totalEx + b.getRoomPrice() <= a.income*3/10 && a.room == 0) return true;
        else if (totalEx + b.getRoomPrice() <= a.income*3/10  && a.room < 4 && !a.checkIfRoom(b)) return true;
        else if (totalEx + b.getRoomPrice() <= a.money/12 && a.room == 0) return true;
        return false;
    }
    boolean AI_LOGIC_PARK(Person a, Property b){
        int totalEx = a.monthlyEx();
        if (a.checkIfPark(b)) return false;
        else if (totalEx + b.getParkPrice() <= a.income*5/10 && a.checkIfRoom(b)) return true;
        return false;
    }
    boolean AI_LOGIC_FRIEND(Person a, Person b){
        if (Math.abs(a.year - b.year) < 30 && Math.abs(a.income-b.income) < 500) return true;
        else if (Math.abs(a.year - b.year) < 25 && Math.abs(a.income-b.income) < 1000) return true;
        else if (Math.abs(a.year - b.year) < 20 && Math.abs(a.income-b.income) < 2000) return true;
        else if (Math.abs(a.year - b.year) < 15 && Math.abs(a.income-b.income) < 4000) return true;
        else if (Math.abs(a.year - b.year) < 10 && Math.abs(a.income-b.income) < 8000) return true;
        else if (Math.abs(a.year - b.year) < 5 && Math.abs(a.income-b.income) < 16000) return true;
        else if (Math.abs(a.year - b.year) < 2) return true;
        return false;
    }
}
