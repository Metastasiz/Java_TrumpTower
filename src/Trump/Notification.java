package Trump;

public class Notification extends BasicFrame {
    static String log ="AT " + new MyTime().time + ": INITIATING...";
    Notification() {
        super((STA_H/10)<3?3:(STA_H/10), STA_W-((STA_W/5)<10?10:(STA_W/5))-(STA_W/4)+2);
        notiINIT();
        refresh();
    }
    void notiINIT(){
        clear();
        append(new PxObj(log).getObj(), h - 2, 1);
        log = "";
    }
    public void refresh(){
        if (log==null||log.equalsIgnoreCase("/null") || log.equalsIgnoreCase("")) return;
        else {
            moveUp();
            clear();
            append(new PxObj(log).getObj(), h - 2, 1);
            log = "";
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
    void clear(){
        for (int i = 1; i < w-1;i++) out[h-2][i] = " ";
    }
    void copy(String[] move, String[] src){
        for (int i = 1; i < w-1;i++) move[i] = src[i];
    }
}
