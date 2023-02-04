package Trump;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyLogin extends BasicFrame{
    Information info = new Information();
    static Map<String, String> passwordInfo = new HashMap<>();
    final String INIT_user = "Username: ", INIT_pw = "Password: ";
    static String user="", pw="";
    static boolean right = true;
    MyLogin() {
        super(5, 1+10+20+1);
        super.out = new String[h][w];
        INIT();
        INIT_PW();
        refresh();
    }
    void load() {
        String loadFrom = "password.txt";
        try (
                BufferedReader br1 = Files.newBufferedReader(Paths.get(loadFrom));
                BufferedReader br2 = Files.newBufferedReader(Paths.get(loadFrom));
        ) {
            FileWriter writer = new FileWriter(loadFrom);
            for (Map.Entry<String, Person> e : info.personInfo.entrySet()){
                //writer.write(e.getKey())
            }

        }catch (Exception e){}
    }
    void INIT_PW() {
        for (Map.Entry<String, Person> e : info.personInfo.entrySet()) {
            passwordInfo.put(e.getKey(),"password");
        }
    }
    String getUser(){return user;}
    @Override
    public void refresh(){
        append(new PxObj(INIT_user + user).getObj(),1,1);
        append(new PxObj(INIT_pw + pw).getObj(),3,1);
        if (!user.equals("")&&!pw.equals("")&&passwordInfo.get(user).equals(pw)){
            right = true;
        }
    }
}