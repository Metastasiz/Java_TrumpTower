package Trump;

public class HelpTap extends BasicFrame {
    static String
            cmd1 = "Use \"W\" and \"S\" to scroll up and down",
            cmd2 = "The following are the commands",
            cmd3 = "w s /move /exit /stop",
            cmd4 = "/swap /login /save /fluid",
            cmd5 = "The following commands are basic commands",
            cmd6 = "/displayperson /displayproperty",
            cmd7 = "/addperson /addproperty",
            cmd8 = "/rentroom /rentpark",
            cmd9 = "The following commands you must /displayperson",
            cmd10= "/cancelroom /cancelpark",
            cmd11= "/addfriend /removefriend",
            cmd12= "/additem /removeitem"
    ;
    static String cmdAll = "";

    HelpTap(){super(8+4+2,STA_W/4);INIT_CMD();append(new PxObj(cmdAll).getObj(),1,1);}
    void INIT_CMD(){
        cmdAll = "";
        cmdAll += cmd1+
                "\n"+cmd2+
                "\n"+new PxObj().spaceString(cmd3,6)+
                "\n"+new PxObj().spaceString(cmd4,6)+
                "\n"+cmd5+
                "\n"+new PxObj().spaceString(cmd6,16)+
                "\n"+new PxObj().spaceString(cmd7,16)+
                "\n"+new PxObj().spaceString(cmd8,16)+
                "\n"+cmd9+
                "\n"+new PxObj().spaceString(cmd10,13)+
                "\n"+new PxObj().spaceString(cmd11,13)+
                "\n"+new PxObj().spaceString(cmd12,13)
        ;
    }
}
