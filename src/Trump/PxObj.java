package Trump;

import java.util.Arrays;
public class PxObj {
    char pixel = ' ';
    String in = " ", colour = ConsoleColour.RESET;
    int mxw = 0, mxh = 0;
    String[] arr;
    String[][] obj;
    PxObj(){INIT();}
    PxObj(String obj){
        in = obj;
        INIT();
        /*
        for (int i = 0; i < obj.length(); i++)
            System.out.println(Arrays.toString(this.obj));

         */
    }
    PxObj(String obj, String colour){
        in = obj;
        this.colour = colour;
        INIT();
    }
    public String spaceString(String a, int max){
        String[] tempArr = a.split("\\s+");
        max++;
        String out = "";
        for (int i = 0; i < tempArr.length; i++){
            out += tempArr[i];
            for (int j = 0; j < max-tempArr[i].length(); j++){out += " ";}
        }
        return out;
    }
    public String[][] getObj(){return obj;}
    public PxObj trim(int from){
        String[][] out = new String[obj.length-from][obj[0].length];
        for (int i = from; i < obj.length; i++){out[i-from] = obj[i];}
        obj = out;
        return this;
    }
    public void setColour(String colour){
        this.colour = colour;
        INIT();
    }
    public void INIT(){
        INIT_size();
        INIT_obj();
    }
    public void INIT_size(){
        arr = in.split("\n");
        int counter;
        mxw = 0;
        mxh = arr.length;
        for (int i = 0; i < arr.length; i++) {
            counter = arr[i].length();
            if (mxw < counter) mxw = counter;
        }
        //System.out.println(Arrays.toString(arr)+ "\nmax = " + mxw);
    }
    public void INIT_obj(){
        obj = new String[mxh][mxw];
        for (int i = 0; i < mxh; i++)
            for (int j = 0; j < mxw; j++) {
                if (arr[i].length()-1 < j) obj[i][j] = colour + ' ';
                else obj[i][j] = colour + arr[i].charAt(j);
            }
    }
    public void printTest(){
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[0].length; j++)
                System.out.print(obj[i][j]);
            System.out.println(ConsoleColour.RESET);
        }
    }
}
