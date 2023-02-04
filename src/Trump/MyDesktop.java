package Trump;

import java.util.*;

public class MyDesktop extends BasicFrame{
    public static void main(String[] arg){
        new Information().INIT();
        MyDesktop a = new MyDesktop();
    }
    //1 - selecting people, 2 - selecting people, 3 - showing people, 4 - showing property
    static int panel = 1, maxPanel = 4, scrollPerson = 0, scrollProp = 0, scrollObj = 0, scrollCar = 0;
    static String input = "", ppID = "", prID = "";
    String[][] infoPeople;
    MyDesktop(){super(STA_H-new MyLog().h+1,STA_W*3/4+STA_W%4);refresh();}
    @Override
    public void refresh(){
        if (Information.phase == 0){
            append(new PxObj(Information.output).getObj(), h/2,w/2);
        }else if (panel==1){
            infoPerson();
        }else if (panel==2){
            infoProperty();
        }else if (panel==3){
            infoObj();
        }else if (panel==4){
            infoCar();
        }else if (panel==5){
            findPerson();
        }else if (panel==6){
            findProperty();
        }
    }
    static void swap(){
        if (panel >= maxPanel) panel = 1;
        else panel ++;
    }
    void findPerson(){
        //temp
        ppID = input; append(new PxObj(Information.personInfo.get(input).getInfo()).getObj(), 1,1);
    }
    void findProperty(){
        prID = input; append(new PxObj(Information.propertyInfo.get(input).getInfo()).getObj(), 1,1);
    }
    void infoPerson(){
        int counter = 0;
        int tmp = scrollPerson<0?0:scrollPerson;
        // assume scroll down = +
        List<Person> out = new ArrayList<Person>();

        for (Map.Entry<String, Person> e : Information.personInfo.entrySet())
        {out.add(e.getValue());}
        Collections.sort(out);
        for (Person e : out){
            if(counter>this.h)break;
            int start;
            int length = new PxObj(e.getInfo()).getObj().length+1;
            if (tmp > length) {tmp -= length;continue;}
            else if (tmp == length) {tmp = 0;continue;}
            start = tmp;
            tmp = 0;

            append(new PxObj(e.getInfo()).trim(start).getObj(), 1+counter,1);
            counter += new PxObj(e.getInfo()).trim(start).getObj().length+1;
        }
    }
    void infoProperty(){
        int counter = 0;
        int tmp = scrollProp<0?0:scrollProp;
        for (Map.Entry<String, Property> e : Information.propertyInfo.entrySet())
        {
            if(counter>this.h)break;
            int start;
            int length = new PxObj(e.getValue().getInfo()).getObj().length+1;
            if (tmp > length) {tmp -= length;continue;}
            else if (tmp == length) {tmp = 0;continue;}
            start = tmp;
            tmp = 0;

            append(new PxObj(e.getValue().getInfo()).trim(start).getObj(), 1+counter,1);
            counter += new PxObj(e.getValue().getInfo()).trim(start).getObj().length+1;
        }
    }
    void infoObj(){
        Comparator<Item> comp3 = new Comp3();
        int counter = 0;
        int tmp = scrollObj<0?0:scrollObj;
        // assume scroll down = +
        List<Obj> out = new ArrayList<Obj>();

        for (Map.Entry<Integer, Obj> e : Information.objInfo.entrySet())
        {out.add(e.getValue());}
        Collections.sort(out,comp3);
        int size = String.valueOf(Information.objInfo.size()).length();
        for (Item e : out){
            if(counter>this.h)break;
            int start;
            int length = new PxObj(e.getInfo()).getObj().length+1;
            if (tmp > length) {tmp -= length;continue;}
            else if (tmp == length) {tmp = 0;continue;}
            start = tmp;
            tmp = 0;

            int tmpL = 1+size-String.valueOf(e.ID).length();
            String ID = spaceB("ID",tmpL);

            append(new PxObj(ID +e.ID +": "+e.getInfo()).trim(start).getObj(), 1+counter,1);
            counter += new PxObj(e.getInfo()).trim(start).getObj().length+1;
        }
    }
    void infoCar(){
        Comparator<Item> comp3 = new Comp3();
        int counter = 0;
        int tmp = scrollCar<0?0:scrollCar;
        // assume scroll down = +
        List<Car> out = new ArrayList<Car>();

        for (Map.Entry<Integer, Car> e : Information.carInfo.entrySet())
        {out.add(e.getValue());}
        Collections.sort(out,comp3);
        int size = String.valueOf(Information.carInfo.size()).length();
        for (Item e : out){
            if(counter>this.h)break;
            int start;
            int length = new PxObj(e.getInfo()).getObj().length+1;
            if (tmp > length) {tmp -= length;continue;}
            else if (tmp == length) {tmp = 0;continue;}
            start = tmp;
            tmp = 0;

            int tmpL = 1+size-String.valueOf(e.ID).length();
            String ID = spaceB("ID",tmpL);

            append(new PxObj(ID +e.ID +": "+ e.getInfo()).trim(start).getObj(), 1+counter,1);
            counter += new PxObj(e.getInfo()).trim(start).getObj().length+1;
        }
    }
}

//based 12