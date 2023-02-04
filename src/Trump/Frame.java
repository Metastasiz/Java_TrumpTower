package Trump;

import java.util.Scanner;

public class Frame extends BasicFrame{
    Scanner scan = new Scanner(System.in);
    MyLog log = new MyLog();
    Notification noti = new Notification();
    InfoTap info = new InfoTap();
    Frame() {
        super(STA_H,STA_W);

        while (true){
            System.out.println();
            this.render();
            if (!new MyConsole().enter) System.out.print("User >> [Press Enter] ");
            else if (new MyConsole().enter) {System.out.print("User >> ");
                while (new MyConsole().enter) {
                    if (new MyConsole().stop){
                        if (new MyConsole().login > 0){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.login == 1){refresh();}
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.login == 2){refresh();}
                        } else if (MyConsole.fluid > 0){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.fluid == 1){refresh();}
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.fluid == 2){refresh();}
                        } else if (MyConsole.move){
                            while (MyConsole.move){
                                MyConsole.input = "";
                                refresh();
                                render();
                                System.out.print("User >> ");
                                while(MyConsole.input.equalsIgnoreCase("")){
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else if (MyConsole.addpp){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.addpp){refresh();}
                        } else if (MyConsole.addpr){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.addpr){refresh();}
                        } else if (MyConsole.dispp){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.dispp){refresh();}
                        } else if (MyConsole.dispr){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.dispr){refresh();}
                        } else if (MyConsole.rntr){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.rntr){refresh();}
                        } else if (MyConsole.rntp){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.rntp){refresh();}
                        } else if (MyConsole.cncr){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.cncr){refresh();}
                        } else if (MyConsole.cncp){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.cncp){refresh();}
                        } else if (MyConsole.addf){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.addf){refresh();}
                        } else if (MyConsole.rmvf){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.rmvf){refresh();}
                        } else if (MyConsole.addt){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.addt){refresh();}
                        } else if (MyConsole.rmvt){
                            render();
                            System.out.print("User >> ");
                            while (MyConsole.rmvt){refresh();}
                        }
                        /*
                        dispp = false, dispr = false, addpp = false, addpr = false, rntr = false, rntp = false,
            cncr = false, cncp = false, addf = false, rmvf = false, addt = false, rmvt;
                         */
                    } else try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clr();
        }
    }
    @Override
    public void refresh(){
        INIT();
        log.refresh();
        info.refresh();
        noti.refresh();

        this.append(log, h-log.h, 0);
        this.append(new MyDesktop(),0,0);
        this.append(info, new MyTime().h-1, w-info.w);
        this.append(new MyTime(), 0, w-new MyTime().w);
        this.append(noti, h-noti.h, log.w-1);
        this.append(new HelpTap(), h-new HelpTap().h, w-info.w);
        if (new MyConsole().login > 0) {
            this.append(new MyLogin(), (h-new MyLogin().h)/2, (w-new MyLogin().w)/2);
        }
        autoBorder();


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
}
