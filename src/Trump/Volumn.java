package Trump;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Volumn {
    //in m^2
    double size;
    Volumn(double a){size = a;}
    Volumn(double x, double y, double z){size = x*y*z;}
    Volumn(int mn, int mx){size = (int)((Math.random()*(mx-mn+1))+mn)*(int)((Math.random()*(mx-mn+1))+mn)*(int)((Math.random()*(mx-mn+1))+mn);}
    Volumn(int mn, int mx, int height){size = (int)((Math.random()*(mx-mn+1))+mn)*(int)((Math.random()*(mx-mn+1))+mn)*height;}
}
class Item implements Comparable<Item>{
    int ID;
    String name;
    Volumn vol;
    int price;
    String type;
    Item(String n){name = n;}
    double getVol(){return vol.size;}
    int getPrice(){return price;}
    String getName(){return name;}
    String getInfo(){return "Item: " + getName() + ", costs $" + getPrice() + ", and occupy " + getVol() + " m3";}

    @Override
    public int compareTo(Item o) {
        return (int) (vol.size-o.vol.size);
    }
}
class Comp3 implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.ID-o2.ID;
    }
}
class Obj extends Item{
    static int counter = 0;
    static int mnv = 1, mxv = 3;
    static int mnp = 3, mxp = 2000;
    Obj(String n, int price, double vol, int ID){
        super(n);
        this.ID = ID; counter++;
        this.price = price;
        this.vol = new Volumn(vol);
        type = "obj";
    }
    Obj(String n) {
        super(n);
        ID = counter++;
        vol = new Volumn(mnv,mxv);
        price = (int)(Math.random()*(mxp-mnp+1))+mnp;
        type = "obj";
    }
    String getInfo(){return "Item: " + getName() + ", costs $" + getPrice() + ", and occupy " + getVol() + " m3";}
}
class Car extends Item{
    static int counter = 0;
    static int mnv = 3, mxv = 10, carh = 2;
    static int mnp = 5000, mxp = 100000;
    //Capacity in mi per refuel
    static int mncap = 120, mxcap = 480;
    int capacity;
    //static Map<String, Car> STA_CAR = new HashMap<>();
    Car(String n, int cap, int price, double vol, int ID){
        super(n);
        this.ID = ID; counter++;
        capacity = cap;
        this.price = price;
        this.vol = new Volumn(vol);
        type = "car";
    }
    Car(String n) {
        super(n);
        ID = counter++;
        vol = new Volumn(mnv,mxv,carh);
        capacity = (int)(Math.random()*(mxcap-mncap+1))+mncap;
        price = (int)(Math.random()*(mxp-mnp+1))+mnp;
        type = "car";
    }
    double getCap(){return capacity;}
    @Override
    String getInfo(){return "Car: " + getName() + " with capacity of "+ getCap() +", costs $" + getPrice() + ", and occupy " + getVol() + " m3";}

}