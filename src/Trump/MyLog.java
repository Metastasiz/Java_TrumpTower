package Trump;

import java.util.Arrays;

public class MyLog extends BasicFrame{
    public static void main(String[] arg){

    }
    MyLog(){
        super((STA_H/10)<3?3:(STA_H/10),(STA_W/5)<10?10:(STA_W/5));
    }
    public void refresh(){
        if (MyConsole.logInput==null||MyConsole.logInput.equalsIgnoreCase("/null") || MyConsole.logInput.equalsIgnoreCase("")) return;
        else {
            moveUp();
            clear();
            append(new PxObj("User: " + MyConsole.logInput).getObj(), h - 2, 1);
            MyConsole.logInput = "";
        }
    }
    void moveUp(){
        if (h <= 3) return;
        int min = 1;
        for (int i = min; i < h-1; i++){
            if (i==h-1){clear();break;}
            copy(out[i],out[i+1]);
        }
    }
    void copy(String[] move, String[] src){
        for (int i = 1; i < w-1;i++) move[i] = src[i];
    }
    void clear(){
        for (int i = 1; i < w-1;i++) out[h-2][i] = " ";
    }
    public void addLog(){
        if (MyConsole.input.equalsIgnoreCase("/help")){

        }
        else if (MyConsole.input.equalsIgnoreCase("/exit")){

        }
        else if (MyConsole.input.equalsIgnoreCase("/select")){

        }
        /* add log method

            if no-out command no log
            else log

        */
    }
}

