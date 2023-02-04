package Trump;

public class InfoTap extends BasicFrame{
    static String output = "";
    static int counter = 0;
    InfoTap(){
        super(STA_H-new MyTime().h+1-new HelpTap().h+1,STA_W/4);
    }
    @Override
    public void refresh(){
        if (output=="" || output==null || Information.phase==0){output="";return;}
        INIT();
        append(new PxObj(output).getObj(),1,1);
        output="";
    }
}
