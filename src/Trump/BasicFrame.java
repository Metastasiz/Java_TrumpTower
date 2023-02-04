package Trump;

import java.util.Arrays;

public class BasicFrame{
    static int SCALE = 12;
    //static int STA_H = 48, STA_W = 208;
    static int STA_H = 94, STA_W = 226;
    static boolean testMode = false;
    int h, w;
    String[][] out;
    BasicFrame(int height, int width){h = height; w = width; out = new String[h][w]; INIT();}
    public void INIT(){
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                out[i][j] = new PxObj().in;
        INIT_border();
    }
    public void INIT_border(){
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                String t = out[i][j];
                if (t.equals("╠") || t.equals("╣") || t.equals("╩") || t.equals("╦"));
                else if (i == 0 && j == 0) out[i][j] = "╔";
                else if (i == 0 && j == out[0].length-1) out[i][j] = "╗";
                else if (i == out.length-1 && j == 0) out[i][j] = "╚";
                else if (i == out.length-1 && j == out[0].length-1) out[i][j] = "╝";
                else if (i == out.length-1 || i == 0) out[i][j] = "═";
                else if (j == out[0].length-1 || j == 0) out[i][j] = "║";
            }
        }
    }
    public boolean checkIfBorder(String a){
        switch (a) {
            case "╔":
            case "╩":
            case "╗":
            case "╚":
            case "╝":
            case "═":
            case "║":
            case "╬":
            case "╣":
            case "╠":
            case "╦":
                return true;
        }
        return false;
    }
    public void autoBorder(){
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                out[i][j] = fixBorder(i, j, out[i][j]);
    }
    public static boolean compareOr(String one, String src){
        for (int i = 0; i < src.length(); i++)
        {if (one.charAt(0)==src.charAt(i))return true;}
        return false;
    }
    public String fixBorder(int i, int j, String a){
        if (checkIfBorder(a)) {
            boolean up = false, down = false, left = false, right = false;
            if (j>0) if     (compareOr(out[i][j-1],"═╠╔╚╦╩╬")) left = true;
            if (j<w-1) if   (compareOr(out[i][j+1],"═╣╗╝╦╩╬")) right = true;
            if (i>0) if     (compareOr(out[i-1][j],"║╣╗╔╦╠╬")) up = true;
            if (i<h-1) if   (compareOr(out[i+1][j],"║╣╚╝╩╠╬")) down = true;
            //System.out.println(a + " " + i + " " + j);
            //System.out.println(up +"" + down +""+ left +""+ right);
            if (up&&!down&&left&&!right) return "╝";
            if (up&&!down&&!left&&right) return "╚";
            if (!up&&down&&left&&!right) return "╗";
            if (!up&&down&&!left&&right) return "╔";
            if (up&&down&&!left&&!right) return "║";
            if (up&&down&&left&&!right) return "╣";
            if (up&&down&&!left&&right) return "╠";
            if (!up&&!down&&left&&right) return "═";
            if (!up&&down&&left&&right) return "╦";
            if (up&&!down&&left&&right) return "╩";
            if (up&&down&&left&&right) return "╬";
        } else return a;
        return a;
    }
    public void append(BasicFrame a, int y, int x){
        int mxy = this.h-y<a.h?this.h-y:a.h, mxx = this.w-x<a.w?this.w-x:a.w;
        for (int i = y; i < y+mxy; i++){
            for (int j = x; j < x+mxx; j++){
                this.out[i][j] = a.out[i-y][j-x];
            }
        }
    }
    public String[][] extend(String[][] a){
        int extend = 0;
        for (String[] e : a){
            extend = (e.length/w);
        }
        String[][] out = new String[a.length+extend][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //out
            }
        }
        return a;
    }
    public void append(String[][] a, int y, int x){

        if (a.length==0)return;
        int mxy = this.h-y-1<a.length?this.h-y-1:a.length, mxx = this.w-x-1<a[0].length?this.w-x-1:a[0].length;
        for (int i = y; i < y+mxy; i++){
            for (int j = x; j < x+mxx; j++){
                this.out[i][j] = a[i-y][j-x];
            }
        }
    }
    void add(String[][] loc, String[][] a, int y, int x){
        int mxy = loc.length-y-1<a.length?loc.length-y-1:a.length, mxx = loc[0].length-x-1<a[0].length?loc[0].length-x-1:a[0].length;
        for (int i = y; i < y+mxy; i++){
            for (int j = x; j < x+mxx; j++){
                loc[i][j] = a[i-y][j-x];
            }
        }
    }
    public void render(){
        clr();
        refresh();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (out[i][j].length() == 1) {
                    System.out.print(out[i][j]);
                    /*
                    if (new MyConsole().input.equals("/mode")) {testMode = !testMode; new MyConsole().input="/null";}
                    if (testMode) {
                        if (!checkIfBorder(out[i][j]))
                            System.out.print(ConsoleColour.WHITE_BACKGROUND + out[i][j] + ConsoleColour.RESET);
                        else System.out.print(out[i][j]);
                    } else {
                        if (checkIfBorder(out[i][j]))
                            System.out.print(ConsoleColour.WHITE_BACKGROUND + out[i][j] + ConsoleColour.RESET);
                        else System.out.print(out[i][j]);
                    }

                     */
                }
                else System.out.print(out[i][j]);
            }
            System.out.println();
        }
    }
    public static void clr()
    {
        try
        {
            System.out.flush();
            Runtime.getRuntime().exec("clear");
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    public static void testPrintArr(String[][] a){
        System.out.println("START TESTING");
        for (String[] b : a){
            System.out.println(Arrays.toString(b));
        }
    }
    public static String spaceF(String a, int b){
        String tmp = "";
        for (int i = 0; i < b; i++)tmp+=" ";
        tmp+=a;
        return tmp;
    }
    public static String spaceB(String a, int b){
        String tmp = "";
        tmp+=a;
        for (int i = 0; i < b; i++)tmp+=" ";
        return tmp;
    }
    public void refresh(){}
}
