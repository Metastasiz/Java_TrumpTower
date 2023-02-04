package Trump;

public class Intro extends BasicFrame{
    public static void main(String[] arg){
        new Intro();
    }
    Intro(){super(STA_H,STA_W);stepRefresh();}

    void stepRefresh() {
        try{
            String [][] tmp;

            INIT();
            tmp = new PxObj("THE APPLICATION WILL START SOON").getObj();
            append(tmp,h/2,w/2- tmp[0].length/2);
            render();
            Thread.sleep(3000);

            INIT();
            tmp = new PxObj("PLEASE MAKE SURE THE TOP OF THE WINDOW SCREEN").getObj();
            append(tmp,h/2-2,w/2- tmp[0].length/2);
            tmp = new PxObj("MATCHES THE TOP OF THE TERMINAL SCREEN").getObj();
            append(tmp,h/2,w/2- tmp[0].length/2);
            tmp = new PxObj("FOR YOUR BEST EXPERIENCE").getObj();
            append(tmp,h/2+2,w/2- tmp[0].length/2);
            render();
            Thread.sleep(5000);

            INIT();
            tmp = new PxObj("INTRODUCING").getObj();
            append(tmp,h/2-1,w/2- tmp[0].length/2);
            tmp = new PxObj("TRUMP TOWER MANAGEMENT").getObj();
            append(tmp,h/2+1,w/2- tmp[0].length/2);
            render();
            Thread.sleep(3000);

            INIT();
            tmp = new PxObj("PRESENTED TO YOU BY").getObj();
            append(tmp,h/2-4,w/2- tmp[0].length/2);
            tmp = new PxObj("THANONDRAK ARUNSANGSIRINAK, S22130 12C").getObj();
            append(tmp,h/2-2,w/2- tmp[0].length/2);
            tmp = new PxObj("INSTRUCTED BY SLAWOMIR DANCZAK").getObj();
            append(tmp,h/2+2,w/2- tmp[0].length/2);
            tmp = new PxObj("LECTURED BY TOMASZ WERNER").getObj();
            append(tmp,h/2+4,w/2- tmp[0].length/2);
            tmp = new PxObj("AT POLISH-JAPANESE ACADEMY OF INFORMATION TECHNOLOGY").getObj();
            append(tmp,h/2+7,w/2- tmp[0].length/2);
            render();
            Thread.sleep(7000);
        }
        catch (Exception e){}

    }
}
