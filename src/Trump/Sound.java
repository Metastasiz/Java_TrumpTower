package Trump;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;

//gachi is manly

public class Sound {
    public static void main(String[] arg){
        //new Sound().gachi();
        new Sound().bonk();
    }
    String[][] f1, f2, f3;
    String[][] b1, b2;
    void INIT_gachi(){
        f1 = new PxObj(gachiF1).getObj();
        f2 = new PxObj(gachiF2).getObj();
        f3 = new PxObj(gachiF3).getObj();
        INIT_border(f1);
        INIT_border(f2);
        INIT_border(f3);

    }
    void INIT_bonk(){
        b1 = new PxObj(bonkF1).getObj();
        b2 = new PxObj(bonkF2).getObj();
        INIT_border(b1);
        INIT_border(b2);
    }
    void bonk(){
        INIT_bonk();
        File file = new File("bonk.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            render(b1);
            Thread.sleep(1500);
            render(b2);
            Thread.sleep(1500);
        } catch (Exception e){}
    }
    void gachi(){
        INIT_gachi();
        File file = new File("gachiBASS.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            int i = 0, sec = 0;
            while (sec < 24){
                if (i == 0) {render(f1);i++;}
                else if (i == 1) {render(f2);i++;}
                else if (i == 2) {render(f3);i++;}
                else if (i == 3) {render(f2);i=0;}
                try {
                    Thread.sleep(250);
                    sec++;
                } catch(Exception e){}
            }
        } catch (Exception e){}
    }
    public void INIT_border(String[][] out){
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
    public void render(String[][] out){
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++)
                System.out.print(out[i][j]);
            System.out.println();
        }
    }
    String bonkF1 =
                    "MMMMMMMMMMMMMMMWMMMMWWWWWWWWWWWWWWNNXXKK00KKXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMWWWWWWWWWWWWWWWWWWWNNNXK0Okkxdoooodk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "WWWWWWWWWWWWNNNNNNNNNNXXKK0OOkxxddooollllcclld0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "XXXXXXXXKKK00OOkkkkkkkkxddoolllllllllllllllllox0XWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "ddoooooooooooollllllllllllllcccccclllllllllllldkXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ":;,,,,,;::ccccccccccccccccccccccccccclllllllloox0NWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ",,'''',,;::::cccccccccccccccccccccccccclllllloodk0XNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ",'''',,;;:::::cccccccccccccccccccccccccccccllooodxOKNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ",,,;;;::::::::ccccccccccccccccccccccc:::::ccloooddxOKXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ";;::ccc::::::cccccccccccccccccccccccc:::::::cloddddxOKNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ":ccllcc:::::cccccccccccccccccccccccccc:::::::clodddxkOKNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "cclllcc::::ccccccccccccccccclllllllllcc::::::clodddxxkOKXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "ccccccc:::ccccccccccccllllllllllllllllcccc::cclooddxxkkO00KXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "cccc:::::ccccccccccccllllloooooollloollllccccllooddxxxkkkxxxOXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ":::::::::cccccccccclllooooooooollllooollllllllooodddxxxxxollokKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    ":::::::::ccccccccllooodoodooooollllllllllloooooodddxxxxddocclokKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW\n" +
                    "cccccccccccccccclloooooooooollllllllllllllooooodddxxxxddlc:;::lxKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWW\n" +
                    "ccccccccccccccclllooooooolllllllolllllllllllloodddxxxxdlc;,''',lONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWX\n" +
                    "ccccccccclllooooooolllllllcccclllooooollllllllooddddddoc;'....':kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNX0KNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNX0k\n" +
                    "ccccccccloodddolcc:;,,,,,;;;;:ccloooddooooooooooddddddl:,......;xKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl,oXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNX0kdl\n" +
                    "cc::::ccllollc:,''..........',;:clooodddoooooooooodddol:,......;o0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO,.lXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNKOdlc:\n" +
                    "ccc:::::::;,,'................'';:cllloodooooooooooooool:,.....,o0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWO,.:KWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNKOxocc::\n" +
                    "llccccc::;;'.....................',;;:cllollllllllllllolc:;,,',:d0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNNWWWWW0:.;0WWWMMMMMMMMMMMMMMMMMMMMMMMMMMWWNKOxocc::::\n" +
                    "oooooooooolc;'.................'',,,',,;:::::::::ccccccccc:::::cd0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0ocdKNWWKc.;0WWWWWWMMMMMMMMMMMMMMMMMMMMMWWNX0kdlc::::::\n" +
                    "xxxxxkkkkkkxoc;'...........',;:ccc:;,,,,,,,,;;;;;;;:::::::::::cld0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOc..;dKNKc.'dO0KXXXNNWWWWMWWWMMMMMMMMWWWWX0kdlc::::cccc\n" +
                    "xkkkOO000OOOkxol:;,''.''',;:clodollc:;,,,,,,,,,,,,,,,,,;;;;;:::coOXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXx:..;xkc...''',;;:clodxOXNWMMMMMMMMWWNKkdlc:::::ccccc\n" +
                    "kkOOO000000OOkxddollcccccllooddddool:;,,,,,,,,,,,,,,,,,,,;;;;;;;cxKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXx:..'..'oxxdolc:;,,,:dKWWMMMWWWWWNKOdlc::::::cccclo\n" +
                    "kOOOO0000000Okkxdddooooooodddxxxxdooc:;;;;;;,,,,,,,,''''',,,,,,;:okXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMMMMMMMMMMWWKx:.  'kNWWWWNNXXXXXNWWMMMMWWWNKOdlc:::::::ccllloo\n" +
                    "kkkkOOOOOO0OOOkkxxxddddddxxxkkkxxxdolcc::::;;,,,,,,,''''''''',,,;:okKNWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOx0NWMMMMMMMMMMWWXx:..;xKWWWWWMMMMMMWWWWWWWNXOdlc:::::::ccclloooo\n" +
                    "xkkkkkOOOOOOOOOOkkkkkxxkkkkkkkkxxddoollcccc::;;;;;,,,,,,''''''',,,:cdOXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOc.,lOXWWMMMMMMMMWWWKx:..:xXWWMMMMMMMWWWWWWX0koc:::::::cccclloooll\n" +
                    "xxkkkkOOOOOOOOOOOOOOOOOOOOkkkkxxxddooollllllc::::::;;;;;,,'''..'''',:lxOKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0o,.'l0NWMMMMMMMMMWWWXx:.,dXWMMMMMMWWWWWNKkdlc:::::::cclloooollox\n" +
                    "xxxkkkkOOOO0000000000OOOOOOkkkxxxddooooloooolllcccc:::;;,,'''.......',;clx0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWN0o,.,lONWWWMMMMMMMMWWKOk0NWMMMMMWWWWNKOxlc::::cc:cccloooollldOK\n" +
                    "dxxxkkkOOO0000000000000OOOkkkkxxxdooddoooodddoollcc::;;;,,''..........''';dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNWWWMWWWWWWN0o,.'l0NWMMMMMMMMMMWWWWMMMMMMWWWNXOxoc:::ccccccclloollcldOKXW\n" +
                    "xxxxxkkkkOO00000OOOOOOOOOkkkxxxxxddodddoodddddoollc:::;;;,,''............'ckNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXxc:clodxO0KXNNNXOl'.,o0NWMMMMMMMMMMMWMMMWWWWNX0xoc:::::ccccccllllcccokKNWWW\n" +
                    "dxxxxxkkkOOOOOOOkkkkkkkkkkxxdddxddooooooooooooooolllccc:;,''...............;d0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXd,.  .....',:codxxd:..'o0NWWMMMMMMMMWWWWWWNX0kolc:::::cccclllccc:lok0XNWWWW\n" +
                    "dddddxxxkkkOOOOkkkxxxxxddddooooddoolllllllooooooooooolc:;,'..................:kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOo'..;lddol:;,'''''.  .,xXWMMMMMMMMMMMWWX0kdlc:::::cccccclcc::clx0XNWWWMMM\n" +
                    "oodddxxxxkkOOkkkkkxxddooolccclloooolllllllllllllloooll::;'...................,dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNOl'.,o0XNNXXK0kxdlc;,ckXWMMMMMMMWWWWNKOdocc::ccccccllccc::cok0XNWWWWWWMM\n" +
                    "oodddxxxxkkkkkkkkxxdoolllcc::ccloolllllloooolllllllllc::;'....... ...........'oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNOl,.,oONWWMMMWWWWNXNWWMMMMMMWWWWNXOxocc:::cccccccccc::cok0XNWWWWMMMMMM\n" +
                    "ooodddxxxkkkkkkkxxdollllc::;;;;::cccclloooooolllllllcc::;,'..................;dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNOl'.,oKNWMMMMMMMMMMWWWMWWWWWNX0xolc:::ccclccccc:::clx0XNWWWMWMMMMMMM\n" +
                    "loooodddxxxxxxkxxdolccc::;,'''',;:ccccllllooooooolllccc::;,'................'lONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNK0O0KXNWWMMMMMMMMWWWXOc'.,o0NWMMMMMMMWWWWWWWWNX0kdlc::::cccccccc:::clx0XNWWWWWWWMMMMMMM\n" +
                    "cclllooddxxxxxxdddolc::;,''.....',;::cccclloooooolllllcc::;,'...............:kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNOo:,'..',:dOXWWMMMMMMMMWWXOc..:OWMMMWNWWWWWWWWNXKkdoc::::cccccccccccclx0XNWWWWWWWWWMMMMMMM\n" +
                    "::ccclooddxxxxddooolc::;,'........',,;;;::ccclllllllllllc:;,,'............':dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0o,,:oxkxdc,.':xXWMMMMMMMMWWWXOdkXWMMWNXNWWWWWWNKOdolc::::cccccccc:clox0XNWWWWWWWWWWWMMMMWWW\n" +
                    ":::cclloddxxxxddoolllc:;;,''........',,,;;::::cccccccccc::;,''.......'',;cdkKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c.;xXWMMWWNKd;..:kXWWMMMMMMMMMMWWMMMMWWNWWWWWNX0xoccc::cccccccc:::cok0XNWWWWWWWWWWWWWWWWWWWW\n" +
                    "ccccclloddxxxxddoollllcc::;;,,''......'',;;;;:::::::::;;;,,'''''''',;coxOKXNWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNx'.dNWMMMMMMWWKd;.,oKWMMMMMMMMMMMMMMMMWWWWWWNX0kdlc:::cccccccc:::coxOXNWWWWWWWMWWWWWWWWWWWWWW\n" +
                    "llllllloddxxxxxxdoolllllccc::::;;,,''..''',,;;;;;;,,,,,',,;:cccccloxOKXNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNx'.oXWWMMMMMMMMW0c..oXMMMMMMMMMMMMMMMWWWWWWNKkdlc::::ccccccc:::cok0XNWWWWWWWWWMWWWWWWWWWWWWWW\n" +
                    "lllllooodxxxkkkxxddooollllcccccc:::;;;,,,,,,,,;;;;,,;;;:lxO0KKKXXXNNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWW0:.'dXWWMMMMMMMMWO;.;OWMMMMMMMMMMWWWWWWWWNKOxocc:::ccccccc:::clxOXNNWWWWWWWWWWWNNNNNNWWWWWWWW\n" +
                    "loooooddxxkkkkkkkxxddddoollllllcccccc:::::;;;;;;;;;:clokKNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNO:..cONWMWWWWWWW0:.;OWMMMMMMMWWWWWWWWWNX0xoc::::ccccccc::::cdk0KXXNNNNNNNNXK0OkkxxkO0KXNNNWW\n" +
                    "ooooodddxxkkkOkkkkkkxxxxdddooolllllcccccccccccccccccox0XNWMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWKd,.'lkXNWWWWN0l..oXWMMMMWWWWWWWWWWNX0kdlc:::ccccccc:c::::clodddxxxxxxxxxdolc:;;;:codk0KXXN\n" +
                    "ddddddddxkkkkOOOOOOOkkkxxxxxddooollccccccccllllllllox0XWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWMMMMMMMMWWWN0d;..;lxkkxl,.;dKWMMMWWWWWWWWWNNXKkdlccccccccccccc::::;;;;;;;;;;;;;;;;::;;;,,''',;:coxkkO\n" +
                    "dddddddxxxkkkOOOOOkkkkkkkkkxxxdddooollllllllooooooodkXWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMWNKkocclx0NWMMMMMMMWWWNKxl:,,,,,;cxKNWMMMMWWWWWNNNNNKOdlc::ccllccccc:c::;;;;;;;;;;,,,'''',,,,;,,,,''...',,;:cc\n" +
                    "xxxxxxxxxkkkkkkkOkkkkOOkkkkkkkxxxddddoooooooddooooox0NWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0l,',,,..,dKWMMMMMMMMMWWWWNXK0KKXNWWWWWMWWWWWWNNNNKOxlc:::ccllccc::::::;;,,;;;;;;;,,,''',,,,,,,,,,''......''''\n" +
                    "kkkkkkkkkkkkkkkkOOOOOOOOOOOOkkkkxxxxxxddddddxddddddx0NWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOo,'cxKXXOc.'xNWWMMMMMMMMMMMMMMMMMMMMMMWWWWWNNNNXXK0koc:::cccccccccc:::;;,;;;;;;;;;;;,,,,,,,,,,''',,'''.........\n" +
                    "kkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOkkkkkkkxxxxxxxxxxxxxkKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWKo'.;xXWWWWNx'.:xxkOXWWMMMMMMMMMMMMMMMMMWWWNNXXKK0Okxolccccccccccccccc::;;,,;;;;;;;;;;,,,,,,,,,,,,,,,,,,,'........\n" +
                    "OkkkkkkkkkkkOOOOOOOOOOO00OOOOOOOOOkkkkkkkkkkkkkxxxxOKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOc..;xXWWWXk;..;:;'';dKWMMMMMMMMMMMMMMWWNNXXKK0Okxdolcccclllccc::ccccc::;;;;;;;;;;;;;;,,,,,,,,,,,,,,,;;,,'........\n" +
                    "OOOOOOOOOkOOOOOO000000OOOOOOOOOOOOOOOOOOOOOkkkkkkxkOKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKx;.'ck0kl,,lkKXKkc..oKWMMMMMMMMMMMMWWNNXK00Okxdolccccclllcc::ccccccc:::;:::::::::;;;,,,,,,,,,,,,,,,;;,,'........\n" +
                    "kkkkkOOOOOOOOOO00000OOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNKd;..'''cONWWWWWO;.:0WMMMMMMMMMMWWWWNXK0kxdoolllclllcccc:::ccccccc::::::::;,,,,,;;;,,,,,,,,,,,,,,,,,'''........\n" +
                    "kkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkOKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKd,..,xXWWWWWXx,.lKWMMMMMMMMMWWWWNXK0kdollcllllllccc::::cccccc::::;::;;,''..'',,;;;;;;,,,,,,''''''''.........\n" +
                    "kkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkOKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWN0d,.'lONNXkl',oKNWMMMMMMMMMWWWWNKOxolcccclllllcc:::::cccc::::;;;;;;,''''''',;:cllc::;;;;,,,''''............\n" +
                    "xkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkO0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMWWN0d;.,lo:''cONWWMMMMMMMWWMWWWWX0kolcccccccccc:::::::::::;;;,,,,,,,,,;;;;;:ccloddolc::;;;,,,'''''..........\n" +
                    "kkkkkkkOOOOkOOOOOkkOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkxkk0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMWWWWWWWWWNKd;..'ckXWWWWMMMWWWWWWWWWWNKkdlccccccccc::::;;;;;;;;,,,,'''',,,;:cccclllooddddolc::;;;,,,'''''''.......\n" +
                    "kkOOOOOOOOOOOOOOkkkOOOOOOOOOOOOOOOOOOkkkkkkxxxxkkxkk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWWWN0doOXWWWMMMMWWWWWWWWWWWNXOdlccccccc::::::;;;,,,,,,''''''',,,;:cloooooodddxxdollc::;;;,,,,''''''''''''\n" +
                    "kOOOOOOOOOOOOOOOkOOOOOOOOOOOOOOOkkkkkxxxxxxxxxkkkxkk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMWWWWWNWWWMMMMMWWWWWWWWWWWX0kdlccccccc:::;;;,,,,,,'''''''''',,;;:llooodddddxxxxddolcc:::;;,,,,,,,,,,,''''\n" +
                    "kOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxkkkkkkkk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMWWWWMMMMMWWWWWWWWWWNKOdllllcccc::;;,,,''''''''''''''',,;;::cllooddddddxxxxddollcc:::;;;;,,,,,,,,,,,,\n" +
                    "kOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxxkkkkkkxk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWNKOxocclllcc:;;;,,'''''''''''''''',,,;;::ccloooddodddxxxxxdoolllcc::;;;,,,,,,,,,,,,\n" +
                    "kkOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxxxxxxxxxxk0XWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWX0xolccccccc:;,,,''.........'''''',,;;::::clloooooooddxxxxxddoolllcc::;;;,,,,,,,,,,,\n" +
                    "kkkOOOOOOOOOOOOOOOOOOOkkkkOOOOOkkxxxxxxxxxxxdddddddx0XWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWNKOdlccccccc:;,'''.......''''''',,,,;;;::::ccllllllllooddddddddooolllcc::;;;,,,,,,,,,,\n" +
                    "kkkkkkkOOOOOOkkkkkkkkkkkkkkOOOkkkxxxdddddddddddodddx0NWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOdlccllcc::;,''.........''''',,,;;;;::::::ccccccccclllodddddddoooollllcc:::;;;;;;;;;;,\n" +
                    "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxdddddooooooodddddx0NWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNXOdlcccccc::;,'...........'''',,;;;:::::::::::cc:::cccclloodddooooooollllccc:::;;;;;;;;;;\n" +
                    "xxxxxxxxxkkkxxxkkkkkkkkkkkkkkxxxxddooooooooodddddddx0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWMMWWWNX0xoccccccc:;,''..........''',,,;;;::::::::::::::::::::ccclloooooooooollllllccc:::;;;;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxkkkkkkkkkxxxdddoooooodddddddddddox0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWWWX0xoc:ccccc:;;,'.........'''',,,;;;::::::::::::::::;;;;::cccllloooooooooolllllcccc:::;;;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxkkkkkkkkkxxddddooooddddddddddddood0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWWNKkoc::cc:::;,,''.........'',,,;;;;:::::::::::::::;;;;,,;;::ccloooooooooooollllllccc:::;;;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxkkkkkkkxxxddddddddddddxxxdddddooldONWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWWWWNXOdlc::cc::;,,'............',,,;;;::::::::::::::;;;;,,,,,;;::cllooooddoooooolllllcccc::::;;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxkkkkxxxxxxddddddddddxxxxxddddoooloOXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWMMMMMMMMMMMMWWWWWWWWWNX0xlc::::::;,''.............'',,;;;;:::::::::::::;;;,,'''',,;::cloddddddoooooollllccccc::::;;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddddddoolloOXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWMMMMMMMMMWWWWWWWWNX0xolc::::::;,...............'',;;;;;:::::::::::;;;;,,'''''',,;:clloddddddooooooollllccc::::::;;;;;;\n" +
                    "xxxxxdxxxxxxxxxxxxxxxddddddxxxxxxxxxxxxxxxdddddoooodOXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWMMMMMWWWWWWNX0xocc:::::cc:,................',;;:::::::::::::::;;;,''....'',;::clooddddddooooooolllcccc::::::;;;;;;\n" +
                    "xxxxxxxxxxxxxxxxxxxdddddddddxxxxxxxxxxxxxxxxddddooodOXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMMMMMWWWWWWNKkdlc:::::loxdc'.... ..........',;;::::::::::::::::;;,'......',,;:cllodddddddooooooolllccccc:::::;;;;;,\n" +
                    "xxxxxxxxxdddddddddddddddddddxxxxxxxxxxxxxxxxxxdddoookXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNKOdlccc:::cdk00x:..         .....',;;:::::::::::::::;;,'......'',;::cllodddddddooooooolllccccc::::;;;;;;;\n" +
                    "xxdddddddddoooooooddddddddddxxxkkkkkxxxxxxxxxxxddoooxKWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWNXOdlccc:::cokKXNKx;.           ....',;;:::::::::::::;;;,'.......',;::clloodddddddoooooollllcccccc:::;;;;;;;\n" +
                    "ddddddddddoooooolooooooooodddxxkkkkkkxxxxxxxxxxddoloxKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWMMWWWWWNX0xolccc::cdk0XNNNKd;.           ....',;;::::::::::::;;,,'.......',,;:ccllooddddddddoooolllllcccccc::::;;;;;;\n" +
                    "ddddddooooooooollllllcclllodxxxkkkkkkkkxxxxxxxxddooox0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWWNXOxolcc:::cdkKNNWWWN0d,.          .....',;;::::::::::;;;,,'........',;::ccllooddddddddooollllllcccccc:::::;;;;;\n" +
                    "oooooooooooolllllc::::::cloddxkkkkkkkkkkkxxxxxxxddoox0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWN0koccc:::cokKNWWWWWWN0d;.         ......',;;::::::::;;;,,''.......'',;;:cclloooddddddddooollllllccccc::::::;;;;;\n" +
                    "oooolllllllllllcc:;,,,;;:clodxxxkkkkkkkkkkxxkxxxddooxKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNKkdlcc:::cokKXNWWWWWWWNKx:..       ......',,;;;:::::;;,,,''........'',,;;:clloooooddddddoooolllllccccc::::::::;;;;\n" +
                    "lllllllllllllcc:;,'..',;;:cloddxxkkkOkkkkkkxkxxxxdodkKNWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOdlcc:::cok0XNWWWWWWWWWWXOl,.. ..........'',;;;;;;;;;,,'''........'',,,;;:cclooddddddddddooooollllccccc::::::::;;;;\n" +
                    "llllllllllllc:;;,'....',;;:cloddxkkOOOkkkkkxxxxxxdddx0XNNWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNXOdlc:::::lx0XNWWWWWWWWWWWWN0d:'.............',,,,,,,,,,''''......'',,,,;;;::clloooddddddddddoooollllccccc::::::;;;;;;\n" +
                    "ooolllllllcc:;,,''''''',;;::clodxxkkkkkkkxxxxxkxxddodkOO00KXNNWWWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNKOdl::::::ox0XNWWWWWWWWWWWWWWNXOdc,'............'''',,,,''''''....'',,;;;;;::ccclloooddddddddddoooollllccccc::::::;;;;;;\n" +
                    "loollllllcc:;,,''',,,,,,;;;:cloodxkkkkkkkxxxxxxxxdoooddddxxxkOO0KKXXXNNNWWWWWWWWWMMMMMMMMMMMMMMMMMMMWWWNX0xlc:;;;:cd0XWWWWWWWMMWWWWWWWWNNKOxoc;,.............''''''''''''''',,;;;;;::ccclllooddddddddddddooollllcccccc:::::;;;;;;;\n" +
                    "lllllllllc:;,,''',,,,,,,,,;:cclodxkkkkkkxxxxxxxxxddoooooooooooooddxxxkkO00KXXXNNNWWWWWWWWMMMMMMMMMMWWNX0kdlc:;;:ldOXNWWWWWWWWWWWWWWWWWWWNNXK0Oxolcccccc:;;,,'''''''''''''',,;;;;:::ccclllloooddddddddddddooollllcccccc:::::;;;;;;;\n" +
                    "lllllllcc:;;,''''',,,,,,,,,;:clodxkkkkkkxxxxxxxxxxdollllllcccccccllllooddxxkkOO00KKXXXNNWWWWMMWMWWWWX0xocc::;:cdOXNWWWWWWWWWMMWWWWWWWWWWWWWWNNXKK000000Okdoc:;,''''',,,,,,;;;::::cccllloooooddddddddddddoooolllcccccc::::::;;;;;;,\n" +
                    "llllllcc::;,,''...''',,,,,,;;:clodxkkkkxxxxxxxxxxxxdllccccccccccccccllloooddxxxxkkkkOOOO0KXNNWWWWNXKkolc::::cokKNWWWWWWWWWWWMMMMMMMWWWWWWWWWWWWNNWWWWNNNXKOxoc;,,,,,,,,,;;;;:::ccccllooooooodddddddddddoooolllcccccc:::::;;;;,,,,,\n" +
                    "ollllllccc::;;,'.....'''',,;;::cldxxkkxxxxxxxxxxxxxdolllllcccc::::::ccclllooddddddxxxxxxxkkO0XNNX0kdl::;;:cdOKNWWWWWWWWMMMMWWMMMMMMWMMWWWWWWWWWWWWWWWWWWWNX0koc;;;;;;;;;;;;::ccccllllooooooodddddddddoooooollcccccc:::::;;;,,,,,,,\n" +
                    "ooooooolllllccc:;,,'''''',,;::ccloddxxxxxxxxxxxxxxxddkOOOOkxdolcccccccccccclloolllloooddddoodk00Odlc::;;:okKNWWWWWWWWWWWMMMWWWMMMMMWMMMWWWWWWWWWWWWWWWWWWWNXOxl::::;;;;:::::cllllllllooooooddddoooooooooolllccccccc:::;;;;,,,,,,,,\n" +
                    "dddoooooooooooollcc:;;,,,,;;:::ccloddxxxxxdddxxxxxxxk0XNNNNXKK0OOkkkxxxddolllll:;,,;:clool:;;codlc::;:cokKNWWWWWWWWWWWWWMMMWWMMMMMMMMMMWWWWWWWWWWWWWWWWWWWWN0kocc::::::::cccllllllllloooooodddoooooooooolllcccccccc:::;;,,,,,,,,,,\n" +
                    "ddddoooooooooooooollcc:;;;;;;;;::cloddxxxddddxxxxxxxk0XNWWWWWWWWWWNNNNNXXK00Oxdl:;,::codxdlc:cccc:;;:lkKNWWWWWMWWWWWWWMMMMMWMMMMMMMMMMWWMMWWWWMMWWWWWWWWWWWNKkdlccccccccccclllooooooooooooooooooooooooollllcccccc::::;;;,,,,,,,,,,\n" +
                    "ddddddddddddddooooolllc:::;;;;;;::clooddddooddxxxxxxxOXNWWWWWWWWWWWWWWWWWWWWNNXKOOOO00KKKOxolc::;;:lx0NWWWWWMMMMMMMMWWMMMMMWMMMMMMMMMMMMMMMMMMMMWWWWWWWWWWWN0kdlllllllllllllloooooooooooooooooooooooolllllcccc:::::;;;;,,,,,,,,,,,";
    String bonkF2 =
            "MMMMMMMMMMMMMMMWMMMMWWWWWWWWWWWWWWNNXXKK00KKXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "MMMMMMMMMWWWWWWWWWWWWWWWWWWWNNNXK0Okkxdoooodk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "WWWWWWWWWWWWNNNNNNNNNNXXKK0OOkxxddooollllcclld0XWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "XXXXXXXXKKK00OOkkkkkkkkxddoolllllllllllllllllox0XWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "ddoooooooooooollllllllllllllcccccclllllllllllldkXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ":;,,,,,;::ccccccccccccccccccccccccccclllllllloox0NWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ",,'''',,;::::cccccccccccccccccccccccccclllllloodk0XNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ",'''',,;;:::::cccccccccccccccccccccccccccccllooodxOKNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ",,,;;;::::::::ccccccccccccccccccccccc:::::ccloooddxOKXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ";;::ccc::::::cccccccccccccccccccccccc:::::::cloddddxOKNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ":ccllcc:::::cccccccccccccccccccccccccc:::::::clodddxkOKNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "cclllcc::::ccccccccccccccccclllllllllcc::::::clodddxxkOKXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "ccccccc:::ccccccccccccllllllllllllllllcccc::cclooddxxkkO00KXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            "cccc:::::ccccccccccccllllloooooollloollllccccllooddxxxkkkxxxOXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ":::::::::cccccccccclllooooooooollllooollllllllooodddxxxxxollokKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
            ":::::::::ccccccccllooodoodooooollllllllllloooooodddxxxxddocclokKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW\n" +
            "cccccccccccccccclloooooooooollllllllllllllooooodddxxxxddlc:;::lxKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWW\n" +
            "ccccccccccccccclllooooooolllllllolllllllllllloodddxxxxdlc;,''',lONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWX\n" +
            "ccccccccclllooooooolllllllcccclllooooollllllllooddddddoc;'....':kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNX0k\n" +
            "ccccccccloodddolcc:;,,,,,;;;;:ccloooddooooooooooddddddl:,......;xKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMWWNX0kdl\n" +
            "cc::::ccllollc:,''..........',;:clooodddoooooooooodddol:,......;o0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNKOdlc:\n" +
            "ccc:::::::;,,'................'';:cllloodooooooooooooool:,.....,o0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNKOxocc::\n" +
            "llccccc::;;'.....................',;;:cllollllllllllllolc:;,,',:d0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNKOxocc::::\n" +
            "oooooooooolc;'.................'',,,',,;:::::::::ccccccccc:::::cd0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNX0kdlc::::::\n" +
            "xxxxxkkkkkkxoc;'...........',;:ccc:;,,,,,,,,;;;;;;;:::::::::::cld0NWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWX0kdlc::::cccc\n" +
            "xkkkOO000OOOkxol:;,''.''',;:clodollc:;,,,,,,,,,,,,,,,,,;;;;;:::coOXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMWWNKkdlc:::::ccccc\n" +
            "kkOOO000000OOkxddollcccccllooddddool:;,,,,,,,,,,,,,,,,,,,;;;;;;;cxKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOdlc::::::cccclo\n" +
            "kOOOO0000000Okkxdddooooooodddxxxxdooc:;;;;;;,,,,,,,,''''',,,,,,;:okXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNKOdlc:::::::ccllloo\n" +
            "kkkkOOOOOO0OOOkkxxxddddddxxxkkkxxxdolcc::::;;,,,,,,,''''''''',,,;:okKNWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNXOdlc:::::::ccclloooo\n" +
            "xkkkkkOOOOOOOOOOkkkkkxxkkkkkkkkxxddoollcccc::;;;;;,,,,,,''''''',,,:cdOXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWX0koc:::::::cccclloooll\n" +
            "xxkkkkOOOOOOOOOOOOOOOOOOOOkkkkxxxddooollllllc::::::;;;;;,,'''..'''',:lxOKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKkdlc:::::::cclloooollox\n" +
            "xxxkkkkOOOO0000000000OOOOOOkkkxxxddooooloooolllcccc:::;;,,'''.......',;clx0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOxlc::::cc:cccloooollldOK\n" +
            "dxxxkkkOOO0000000000000OOOkkkkxxxdooddoooodddoollcc::;;;,,''..........''';dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNXOxoc:::ccccccclloollcldOKXW\n" +
            "xxxxxkkkkOO00000OOOOOOOOOkkkxxxxxddodddoodddddoollc:::;;;,,''............'ckNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNX0xoc:::::ccccccllllcccokKNWWW\n" +
            "dxxxxxkkkOOOOOOOkkkkkkkkkkxxdddxddooooooooooooooolllccc:;,''...............;d0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMWWWNX0kolc:::::cccclllccc:lok0XNWWWW\n" +
            "dddddxxxkkkOOOOkkkxxxxxddddooooddoolllllllooooooooooolc:;,'..................:kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMWWX0kdlc:::::cccccclcc::clx0XNWWWMMM\n" +
            "oodddxxxxkkOOkkkkkxxddooolccclloooolllllllllllllloooll::;'...................,dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOdocc::ccccccllccc::cok0XNWWWWWWMM\n" +
            "oodddxxxxkkkkkkkkxxdoolllcc::ccloolllllloooolllllllllc::;'....... ...........'oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNXOxocc:::cccccccccc::cok0XNWWWWMMMMMM\n" +
            "ooodddxxxkkkkkkkxxdollllc::;;;;::cccclloooooolllllllcc::;,'..................;dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNX0xolc:::ccclccccc:::clx0XNWWWMWMMMMMMM\n" +
            "loooodddxxxxxxkxxdolccc::;,'''',;:ccccllllooooooolllccc::;,'................'lONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNX0kdlc::::cccccccc:::clx0XNWWWWWWWMMMMMMM\n" +
            "cclllooddxxxxxxdddolc::;,''.....',;::cccclloooooolllllcc::;,'...............:kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNXKkdoc::::cccccccccccclx0XNWWWWWWWWWMMMMMMM\n" +
            "::ccclooddxxxxddooolc::;,'........',,;;;::ccclllllllllllc:;,,'............':dKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKkdolc::::cccccccc:clox0XNWWWWWWWWWWWMMMMWWW\n" +
            ":::cclloddxxxxddoolllc:;;,''........',,,;;::::cccccccccc::;,''.......'',;cdkKNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNX0xoccc::cccccccc:::cok0XNWWWWWWWWWWWWWWWWWWWW\n" +
            "ccccclloddxxxxddoollllcc::;;,,''......'',,;;;:::::::::;;;,,'''''''',;coxOKXNWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNX0kdlc:::cccccccc:::coxOXNWWWWWWWMWWWWWWWWWWWWWW\n" +
            "llllllloddxxxxxxdoolllllccc::::;;,,''..''',;;;;;;;,,,,,',,;:cccccloxOKXNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNKkdlc::::ccccccc:::cok0XNWWWWWWWWWMWWWWWWWWWWWWWW\n" +
            "lllllooodxxxkkkxxddooollllcccccc:::;;;,,,,,,,,;;;;,,;;;:lxO0KKKXXXNNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWNKOxocc:::ccccccc:::clxOXNNWWWWWWWWWWWNNNNNNWWWWWWWW\n" +
            "loooooddxxkkkkkkkxxddddoollllllcccccc:::::;;;;;;;;;:clokKNWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWNX0xoc::::ccccccc::::cdk0KXXNNNNNNNNXK0OkkxxkO0KXNNNWW\n" +
            "ooooodddxxkkkOkkkkkkxxxxdddooolllllcccccccccc:;,;:ccox0XNWMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWWNX0kolc:::ccccccc:c::::clodddxxxxxxxxxdolc:;;;:codk0KXXN\n" +
            "ddddddddxkkkkOOOOOOOkkkxxxxxddooollcccccclclllc,.':lx0NWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWNNNXKkdlccccccccccccc::::;;;;;;;;;;;;;;;;::;;;,,''',;:coxkkO\n" +
            "dddddddxxxkkkOOOOOkkkkkkkkkxxxdddooolllllllloool,..'oKWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNNNNKOdlc::ccllccccc:c::;;;;;;;;;;,,,'''',,,,;,,,,''...',,;:cc\n" +
            "xxxxxxxxxkkkkkkkOkkkkOOkkkkkkkxxxddddoooooooddool;.  ,xXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNNNXKOxlc:::ccllccc::::::;;,,;;;;;;;,,,''',,,,,,,,,,''......''''\n" +
            "kkkkkkkkkkkkkkkkOOOOOOOOOOOOkkkkxxxxxxddddddxxdddo:.   'oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNNNXXK0koc:::cccccccccc:::;;,;;;;;;;;;;;,,,,,,,,,,''',,'''.........\n" +
            "kkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOkkkkkkkxxxxxxxxxxxxxo'    .cONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNXXKK0Okxolccccccccccccccc::;;,,;;;;;;;;;;,,,,,,,,,,,,,,,,,,,'........\n" +
            "OkkkkkkkkkkkOOOOOOOOOOO00OOOOOOOOOkkkkkkkkkkkkkxxxkOk:     .;xXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNNXXKK0Okxdolcccclllccc::ccccc::;;;;;;;;;;;;;;,,,,,,,,,,,,,,,;;,,'........\n" +
            "OOOOOOOOOkOOOOOO000000OOOOOOOOOOOOOOOOOOOOkkkkkkkkkOKKl.      'oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNNXK00Okxdolccccclllcc::ccccccc:::;:::::::::;;;,,,,,,,,,,,,,,,;;,,'........\n" +
            "kkkkkOOOOOOOOOO00000OOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkOKNNd.       .cONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNNXK0kxddolllclllcccc:::ccccccc::::::::;,,,,,;;;,,,,,,,,,,,,,,,,,'''........\n" +
            "kkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkOKNWNx.        .;xXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNXK0kdollcllllllccc::::cccccc::::;::;;,''..'',,;;;;;;,,,,,,''''''''.........\n" +
            "kkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkOKNWWWO'          'oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNKOxolcccclllllcc:::::cccc::::;;;;;;,''''''',;:cllc::;;;;,,,''''............\n" +
            "xkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkO0NWWMW0;           .cONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMWWWWX0kolcccccccccc:::::::::::;;;,,,,,,,,,;;;;;:ccloddolc::;;;,,,'''''..........\n" +
            "kkkkkkkOOOOkOOOOOkkOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkxkk0NWWMMMK:            .;xXMMMMMMMMMMMMMMMMMMMWWWWNNNNXXXXXXXXXNNNNWWWMMMMMMMMMMMMMMMMMMMMMMWWWWWWWNKkdlccccccccc::::;;;;;;;;,,,,'''',,,;:cccclllooddddolc::;;;,,,'''''''.......\n" +
            "kkOOOOOOOOOOOOOOkkkOOOOOOOOOOOOOOOOOOkkkkkkxxxxkkxkk0XWWMMMMXl.             'oKWMWWNXXKOkxdollc:;;,,''............''',;;:cclodxkO0KXNWMMMMMWWWWWWWWWNXOdlccccccc::::::;;;,,,,,,''''''',,,;:cloooooodddxxdollc::;;;,,,,''''''''''''\n" +
            "kOOOOOOOOOOOOOOOkOOOOOOOOOOOOOOOkkkkkxxxxxxxxxkkkxkk0XWWMMMMMNd.              .;c;,....                                          ...';:loxk0KNWWWWWX0kdlccccccc:::;;;,,,,,,'''''''''',,;;:llooodddddxxxxddolcc:::;;,,,,,,,,,,,''''\n" +
            "kOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxkkkkkkkk0XWWMMMMMMWx.                                                                          ..,:loxkxolllllccc::;;,,,''''''''''''''',,;;::cllooddddddxxxxddollcc:::;;;;,,,,,,,,,,,,\n" +
            "kOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxxkkkkkkxk0XWWMMMMMWN0:                                                                                  ...';:c::;;;,,'''''''''''''''',,,;;::ccloooddodddxxxxxdoolllcc::;;;,,,,,,,,,,,,\n" +
            "kkOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkxxxxxxxxxxxxxxxxxxk0XWWWNKxl;..                                                                                         ...'''''.........''''',,,;;::::clloooooooddxxxxxddoolllcc::;;;,,,,,,,,,,,\n" +
            "kkkOOOOOOOOOOOOOOOOOOOkkkkOOOOOkkxxxxxxxxxxxdddddddx0K0dc,.                                                                                                    .......'''''',,,,;;;::::ccllllllllooddddddddooolllcc::;;;,,,,,,,,,,\n" +
            "kkkkkkkOOOOOOkkkkkkkkkkkkkkOOOkkkxxxdddddddddddodolc;'.                                                                                                            ...''',,,;;;;::::::ccccccccclllodddddddoooollllcc:::;;;;;;;;;;,\n" +
            "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxdddddddooooooc;..                                                                                                                   ..,;;;:::::::::::cc:::cccclloodddooooooollllccc:::;;;;;;;;;;\n" +
            "xxxxxxxxxkkkxxxkkkkkkkkkkkkkkxxxxdddooooooool;..             .,;.     .,:'      .;'   .;:::::::;,.        ':llolc;.      .;;.       .;'      .;clllc;.                   .,:::::::::::::::::::ccclloooooooooollllllccc:::;;;;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxkkkkkkkkkxxxdddooooooddoc'.                .kNl     cXWO'    .kNo   lNXxdddddxO0d'   .:kKOdllldOKk:.   oWWO;      cXx.   'd0OdllldO0x,                   .';::::::::::;;;;::cccllloooooooooolllllcccc:::;;;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxkkkkkkkkkxxddddooooddo:.                    cXO'   .OK0Xo.   :X0'   lNk.      .xNd. .dXO;.     .:0Xo.  oNKKKc.    lNx.  :K0:.     .c0O,                    ..;:::::;;;;,,;;::ccloooooooooooollllllccc:::;;;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxkkkkkkkxxxdddddddddo:.                      .kNl   lXo,k0,  .xNl    lNk.      .xNd. cNO'         ;KX:  dNo,xKo.   cNx. ,0X:         .'.                       .,;;;;,,,,,;;::cllooooddoooooolllllcccc::::;;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxkkkkkxxxxxddddddddc.                         :XO. '0O' :Kd. ;K0'    lNKdllllldOKd. .xWd.         .kNl  oNo .oKk'  cNx. cNO.    .cccccc,                         .,,,'''',,;::cloddddddoooooollllccccc::::;;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo,                           .kXc.oXc  .xK;.xXl     lNKoccclloOXx. .xWd.         .ONc  oNo   c0O;.cNx. cNO.    'clloONk.                          .''''',,;:ccloddddddooooooollllccc::::::;;;;;;\n" +
            "xxxxxdxxxxxxxxxxxxxxxddddddxxxxxdc.                             :KOo0k.   ;KkoKO.     lNk.      .ONl  :X0,         lXO' .oNo    ,OKldNx. '0Xc         oNk.                           ...'',;::clooddddddooooooolllcccc::::::;;;;;;\n" +
            "xxxxxxxxxxxxxxxxxxxdddddddddxxxd:.                              .xNNK:    .dXNXc      lNk.      .dNd. .lK0c.    .'dKO,   oNo     .xXNWx.  ;0Ko.    .'oKWk.                             .',,;:cllodddddddooooooolllccccc:::::;;;;;,\n" +
            "xxxxxxxxxddddddddddddddddddddxd;.                                ;OXd.     'kXx.      :0d.       cKx.   'oOOkxxxkOx:.    l0c      .l0Xo.   .lkOkxdxxxocxd.                              .,;:ccllodddddddooooooolllccccc::::;;;;;;;\n" +
            "xxdddddddddoooooooddddddddddxx:.                                  ...       ...        ..         ..      ..,;;,'.       ..         ...       .',,,..  ..                               .,::clloodddddddoooooollllcccccc:::;;;;;;;\n" +
            "ddddddddddoooooolooooooooodddl.                                                                                                                                                          .:ccllooddddddddoooolllllcccccc::::;;;;;;\n" +
            "ddddddooooooooollllllcclllodo,                                                                                                                                                            ,ccllooddddddddooollllllcccccc:::::;;;;;\n" +
            "oooooooooooolllllc::::::clodc.                                                                                                                                                            .clloooddddddddooollllllccccc::::::;;;;;\n" +
            "oooolllllllllllcc:;,,,;;:clo;                                                                                                                                                             .:loooooddddddoooolllllccccc::::::::;;;;\n" +
            "lllllllllllllcc:;,'..',;;:cl,                     .,clllc;.        .,:lllc:'.     .;;;'         ';;.   ';;.        .,;,.       .;,.       ';,.       .,.   ';;;;;;;,.                     .:ooodddddddddooooollllccccc::::::::;;;;\n" +
            "llllllllllllc:;;,'....',;;:c'                   'd0OdllldO0d'    .oO0kollok00o.   lNWWK:       ;KWNo  'OWWx.      .dNW0'      ;0WNo.     .xWNk'     .dXl  .OW0ddddxkOkc.                  .:oooddddddddddoooollllccccc::::::;;;;;;\n" +
            "ooolllllllcc:;,,''''''',;;::'                  :KKc.     .lKk.  ,0Xo.      .dXO,  lNWXXO'     .kXXNo  '0NKKl      cKKN0,     .kKx0Xc     .kWKKO;    .dNl  .OXc     .'xXk.                 .coooddddddddddoooollllccccc::::::;;;;;;\n" +
            "loollllllcc:;,,''',,,,,,;;::;.                'OXc         .'. .kNo.        .dNx. oNNxoKd.    oKdxNo  '0Kok0;    'OOo00,    .dXl.:X0'    .kXl;OKc   .dNl  .OX:       .xNd.                ,loddddddddddddooollllcccccc:::::;;;;;;;\n" +
            "lllllllllc:;,,''',,,,,,,,,;::.                :X0'             ;KK,          :X0' oNWd'dK:   ;0x'oNo  '0K;;Kk.  .dK:,0K,    cXx. .oNx.   .kX: .xKo. .dNl  .OX:        lNk.               .cooddddddddddddooollllcccccc:::::;;;;;;;\n" +
            "lllllllcc:;;,''''',,,,,,,,,;:;.               ;X0,         ..  ;KK;          cNO. lNWd.'OO' .k0,.oNo  '0K, lKo  cKo.'00,   ;KNxc::dNNl   .kX:  .oKx..dNl  .OX:        lNx.               ;ooddddddddddddoooolllcccccc::::::;;;;;;,\n" +
            "llllllcc::;,,''...''',,,,,,;;:,.              .kNl        'xO, .kNd.        .ONl  lNWd. :Kd'oKc  oNo  '0K, .kK;,OO. '00,  .OXkoooooxXK;  .kX:    :0OcxNl  .OX:       'OXc               ,loodddddddddddoooolllcccccc:::::;;;;,,,,,\n" +
            "ollllllccc::;;,'.....'''',,;;::,.              ,OXd'.   .;OXo.  'kXx,.    .;OXo.  lNWd  .dK0Kx.  oNo  '0K,  ,0K0K:  '00, .dXo.      lXO' .kX:     ,OXNNl  .ONl.  ...cOKl.              ,looddddddddddoooooollcccccc:::::;;;,,,,,,,\n" +
            "ooooooolllllccc:;,,'''''',,;::cc;.              .ckOkxxxkOd,     .ck0OkxxxkOd,    cKKo   .kXk'   lKl  .kO,   cKKl.  'kO' :0x.       .dKl..d0;      .dKKc  .xX0kxxxkkko'               ,loodddddoooooooooolllccccccc:::;;;;,,,,,,,,\n" +
            "dddoooooooooooollcc:;;,,,,;;:::cc:.                .,;;,'.          .';;;,..      ....    ...    ...   ..     ..     ..  ...         ...  ..         ...   .........                .;loooddddoooooooooolllcccccccc:::;;,,,,,,,,,,\n" +
            "ddddoooooooooooooollcc:;;;;;;;;::cc;.                                                                                                                                              'clooooooooooooooooollllcccccc::::;;;,,,,,,,,,,\n" +
            "ddddddddddddddooooolllc:::;;;;;;::clc,.                                                                                                                                          .:looooooooooooooooolllllcccc:::::;;;;,,,,,,,,,,,";
    String gachiF1= "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0d;....................................,oOXWMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKx:,',,,,,;;:c::;,'',;::;;;;;;;;;;,,,''...';o0NWMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0d:,,,;;;;;;:ccccc::;;;:::;;;;;;;;;;,,,,,'''''';o0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0d;'';:::::;;;;;;;;;;;;;;;;,,,,,,,''''''.....',,''';o0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0Od:'',;;;;:;;,,,'''.''',,,,,,'''''..............',,,''';o0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXx:''',;;::;;,;,,''..................................',,,,,'':dKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNx;.',;;:::;;,,,''.....................................',,,,,'.'o0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMNKxc,,,;;;;;;;,''................... ....... .............',,,,,,,:ld0NMMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMWNX0xc;;;;;::;,,,''...........................           .....',,,;;;;;;;cd0NWMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMWKo::;,,;;;;;;,,'......................................    .....',,;;:ccc:;,:xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMNKxc::;;,,,,,,,''.............................''''.................',,;:cccc::oOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMWKdc:llc:;,,,,,''.......................',,,;;;:::::::;,,''............',,;;:cccc:cxXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMNd,,:ccc;;,,,'......................',;;:::cccccccccccc::;,,,,''........'',,;:ccc;';ONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMWKo;,;:::;,,,'.................''',,;:cclllllcccccccccccc::;;:;;;;,,,''''''''',,;:::;lkNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMWXxc;,,,,;;,''................'',;:ccclllllllllccccccccc::::::::::::;;;;;,,,,,,'''',,;,,cONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKo,',,;;,,,'................',;:cclllllllllllllcccccccccc:::::::::::;;;;;;;;;;;,,''.....';oONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMW0d:,,;;:;;,,''.............',;:clllllllllllllllccccccc:cccc::::::::::::;;;;;;;;;;;;,'.......:ONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMWXo,,,;::::;,,''..........',,;ccllllllllooooooolllllcccc::ccc:::::::::::::;;;,;;;;:::;;,'.....'ckXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMWKd:;;;;;;:;;,'''.........';:cclllloooloooooooooooooolllccc:::::::::::::::::;;;;;;;;:::::;;'.....cKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMWKd:;::;,,,,,,'''........',:clllloooooooooooooooooooooooollccc:::c::::::::::::;;;;;;;;:::ccc;,...'cONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMKl;:cc:;;,,''''........',;clllloooooooooooooooooooooooooooolcc::ccc::c:::::cccc:;;;;;;;;;;:cc:;''',:kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMW0c,;::;;,,'...........,;:cllllooooooooodoooodoooooooooolccc:::;;;:::::ccccccccc:;,,,'''''',;;;;;,'''ckXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMW0o:,,;;,'...........'',:cllooooooooooodddooooddoooolllc:;;,'''''''',;:::cccc:::;,,''...........'''''..,ckXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMXo,,,,,,''..........',;:cloooloooodddddddxdoooolllcc:;;,''...........',;;:::::;,,,'......................;kNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMXo,,,,,,,,,'''......',;clloooooooodddxxxddollc:;;,,,''...............'',,;::::;;,,''.....................':kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMWNOl;,,,;;,,,,,,''...',;:cloooodddddddxxxdolc:;,,'.......................',,;;:::;;;,,''''................'.'oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNk:,,,,,;;,,,,'''...'',;:cllooodddxxddxddol:;,''.........................',,;;::::::;;;,,,,''''''''''''''',,;lONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNk;,,,,,,,,''.......'',;:cllooodddxxddddolc:,'....'''''''''''.'''.......',;::ccc::::::;;;;;;;,,,,,,,,,,,,,;;;;ckNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNkc,,,,,,'..........'',;:clloooddxxxxdxdolc;,'''',,,,,,;;,;;;;;;,,'....',:lllllccc::::;;;;;;;;;,,,,,,,,;;;;;;;:lxXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMXd:;,,,,''............',;;:cllooddxxxxxxdolc;;,;;;;::;;;;;;;;:::::;,....,:lodoollc:::;;;;;;;;;,,,,,;,,,,,,;;;;:;;;ckNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWKc,,,,,'..............',,;:cclooddxxxxddolc::::cccccc:;;;;;;;;:::;;'...';loddoollc::;;;;;;;;;,'''''''''...'',;;:;,'lKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMKo;,,,,''.............'',;:cclooddxxxddolc:cccclllc::;;,,,,,,,,,,,'...';coddddollcc::;;;;;;;;,'.............'';;:;;ckXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMKo;,,,''..............',,;:ccloddxxxdddolccllllcc:;,'''''''''''''....',cldddddoollc:::;;;;;;;;,''..'''''''''',;;;:;,;xNMMMMMMMWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMKo;,,,'..............'',,;:ccloddxxxxddooooollc:;,'..........',,'''',;coddddddooolllcc:::::;;;;;,,,;;;;;;;;;;;;;;;:;;lkXWMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMKo,''''..............'',;;:clloddxxxxdooooollc:;;;,,,,''''',,;;;;;;:clodxxddddoodddoolcccc:ccc:::;;;;;;;;;;;;;;;;;::;;cONMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWKc.........'''.......',,;:ccloddxxxxxdollccccc::::c:::;;;;;;::::::cloodxxxxxdddddxxddolcccccllcc::;;;;;;;;;;;;;;;;:::;;:xXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMW0:........''''.......',;;:cloodxxxdddollcccccclllllcc:::cc::::::ccllloooddxddddxddddolcc::::::::;;;;;;;;;;;;;;;;;;:::c;,lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWO;........'''......'',;;:cclodxxxddddollllllllllllllccccccccccccccllccclldddddddolc::::::;;;;;;,,,,,;;;;;;;;;;;;;;;::c::ckXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWO;................'',,;::cloddxdddxdoooolllloooooooolllllllllllllllc;;;clddxddoc;,'..',,,,,,;;,'...',;;,,,,,,,,;;;;;:cc:;;dXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWO;..'''...........'',,;;cloddxxddddooooddolloooooooooooooooooooollc;,',;ldxxdl:,.......''',,,,,'...',,,,,,,,,,,,,;;::ccc:;cxXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWO;..'''............',,,;:loddddddddooddddoloooddddoodooooooollllll:,'.',:odol:,........''',,,,,,'''',,,,,,,,,,,,,;;::cclc:;:kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWO;..''.............'',,;:cloddddddddddddolldddxxxxddddoollollllllc;'...',:cc;,'.......'',,,,,,,,,,,,,,,,,,,,,,,,;;:ccclool:;:dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMWKc'''...............',,;:clooddxddddxxdollodxxxdxxxxdooolllllllllc;,....',;;;,'''''''',,,,,,,,,,,;;,,,,;;,,,,,,,;:ccccldxdo:,:kXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMWKd;................'',,;:cloddddddxxxdooodxxxxxxxxxddoolllllllll:;,'...',;::c:::::;;;;;;;;;;;,,;;;;,,,,,;;;;;;,;;::cccodxdl:,;dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNx;.................'',,;:coddddddxxxxddxxxxxxxxxxxxddoolllllllc:;,''.',:cloolllcc::;;;;;;;;;,,;;;;,;;;,,,;;;;;;;;;::ccoxxdl;,oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNx;..................''',;clodxxxdxxxxxxxxxxxxxxxxxxxdoollclllc::;,,,,;:clooollcc:::;::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::cldkkxc;dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNx;..................'''';:loddxxddxxxxxxxxxxxxxxxxxxxdollcccc::;;,,,;:cllolllcc::::;;:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:ldkOklcxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMNx,.....................';:loddxxdddxxxxxxxxxxxxxxxxxxdolcccc::;;,,,;:clllllllccc::;;;::;;;;;;;,;;;;;;;;;;;;;;;;;;;;;;;coxkkdox0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMWO:'....................';:clodddxdddxxxxxxxxxxxxxxxxxdolcc:::;;;,,,;:cloolllllcc:;;;,;;;;;;;;;;;;;;::::;;;;;;;;;;;;;;::coxkkd:ckNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMW0l'...................',:cllooddddddddxxxxxxxxxxxxxxdolcc:::;;,,,,;:llolllcc:;;,,,''''',,,,,,;;;;;;;;;;;;;;;;,;;;;;;;:cloxxo;;xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMXo'...................',;::ccloodddddddddxxxxxxxdddddolcc:::;,,,,,;:llllcc:;;,,'''.....'',,,,,,,,,,,,,,,,,,,,;;;;;;;;;:clool;;xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMXo'..................'',,,;;:cloddddddddddxxxxxxxddddolcc::;;,,,,;;:ccc::;;,'''''''',,;;;;;::::;;;;,'''''',,;;;;;;;;;;:clllc::kNMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMXd;''..................''',,;:codddddddddddxxxxxddddddolc::;,,,,,;;;;;;,,,''',;;;;::clloollloooolllc:;'...',,;;;;;;;;;:ccllc:lOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMWXOl,...,;;;;;;,,''''''..'',,;clodddddddddddxxxdddddddolcc::;;,,,,,,,''..'',;:lodddddxxkkxxxxkkxddddoc,....',,;;;;;;::::ccllco0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMXd;'.';cllc:;;:::::;;,''',,;:cloddddddddddddddddddddollc::;;;,,,,'.....',:lodxkOkkxxxkxxddddoooooddo:'...'',,;;;;::::::cclclx0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMKo;,,,:lc;'.',cllollc:;,,,,,;cloddddddoooddddddddddddolcc::;;;,,,'.....';ldxxxxddllcccc::;,''''',:cc:,....'',,;;;::::::cclc:,cOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMKl;:::cc;'.';:cooooolc:;,,,,:cloddddddooooooodddddddoolcc::;;;;,,''.....,:oxdl;'..........      ..',,'....'',,;;;::::::cccc;';kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMN0xollc;'',coooodddoolc;,,,;:looddddddooooooooooooooooolccc:::;;,,'......,;:;..                   ........',,;;;;;::::::ccc:,':kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMW0dllc,',cdxxddddodddl:,,,;coodddoddooooooooooooooooooollcc::;;,,,''.........                  ..........',,;;;;;::::::ccc:,..lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMWOc:c;'.;ldxxdolccldddl;,,:looddoodddooooooooooooooooooollc::;;;;;;;;,'....          ..  ...............',,,;;;;;::::::cccc;''oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMWKdlc,'';oxxdl:;,;cdxdo:;;cooodoooodoooooooooooooooooooollc::;;;;;:ccc:;,''............................'',,,,;;;;::::::cccc:,,oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMWXxc'.,:odol:,..,cdxxdlccloodddddoooooooooooooooooooooolcc::;;;;:cllolllcccc::::::;;;,,,,'',,,,,,,,,,,',,,;,,;;;;:::::ccc:;''oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNx;..,cooc;'..';ldxxdooooddddddddooooooooooolllllooooollcc:;;;;:clloooooooooooolllcc:;;;;;;;;;;;;;;;,,,,;;;;;;;::::::ccc:,.'oXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNx;'',col:,...,cdxxxddddddddddddddooooooooolllllllollollcc:;;::cclooooooooooooolllccc::;;;;;;;;;;;;;;;;;;;;;;;;;:::::cc:;';dKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWXx:';cll;'..,coxxxdddoooodddddddoooooooollllllllllllolcccc:::::clllloollooooollllcc::;;;;;;;;;;;;;;;;:::;;;;;;;;;;;::::,;oKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMXd:;cll;'',:odxxdooooooooddddddoooooolllllllllllllllllccc::::cccllllolloooollllcc::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;:dKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMWXx:,:cc::coddddooooooooooooodoooooollllllllllllllllllcccc::cccclllllllllllllcccc:;;;;;;;;,,,,;;;;;;;;;;;;;;;;;;;;;;:,:kNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWKd:;:loodddoolloooooooooooooooooollllllllcclllllcllllccccccccccllllllllllllccc:;;,,;;,,,,,,,,;;;;;;:::::;;;;;;;;::;,;kNMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMN0d::lddddddddoolllccllooooooooollllllllccclllccclccccccccccccccccccclllllccc::;;;;;,,,,,,,,;;;;;:::::;;;:;;;;;;::lkXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMW0l,,:oddxxxxolc:;;;:cloooooooollllccccccccccccccccccccccccccccccccccccccccc:::;;;;;;,,,,,;;;;;;;;::;;;;;;;;;;;;;dXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMWXkc;:codddol:;,,'',:cloolooollllcccccccccccccccccccccccccccccccccccccccccccc:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,,oXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMWKo,';::cc:;,''...,:loooooollllccccccccccccccccccccccccccccccccccccccccccc:::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;lkNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMW0l,..,;:::;,''..':llooooollllccccccccccccccccccccccccccccccccccccccccccc::::;;;;;;;;;;;;;;;;;,;;;;;;;;;;;;l0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMWNOl,',;cllc::;;:loooooolllllccccccccccccccccccccccccccccccccccccllcclccc::::;;;;;;;;;;;;;;;;;;;;;;;;;;;,'c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOo;';:loddooddddoolllllllccccccccccccccccccccccccccccccccccccllclllcccc::;;;;;;;;;;;;;;;;;;;;;;;;;;;,,lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOo;,;coddxxxddoollllllcccccccccccccccccccccccccccccccccccccccccccccccc::;;;;;;;;;;;;;;;;;;;;;,,,,';dKNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOl,';codxxddoollllllllllccccccccccccccccccccccccccccccccccccccccccc::::;;;;;;;;;;;;:::;;,,''...'l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkl;;;clooodoollllllllllllccccccccccccccccccccccccccccccccccccc:::::::;;;;;;;;;;;;;;;,''...;:lkKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0o;,,;:cllllllllllllllcccccccccccccccccccccccccccclccccccc::;;;;;;;;;;;;;;,,,,,'....;lox0NWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0kdl;,;;;;::cccccccccccccccccccccccccccccccccccccccc:::;;;;;,,,,''''''..........,lONWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0Oxc,,;,,,;::cccccccccccccccccccccccccccccccc::;;;;;,,,,'''........''''',cxO0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXKKKOl;;,''',,;;;:::;;;::::cccccccccccc:::::;;;,,,,'''.....,;,;lk0KKKKXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXKklcc:,........''''',,,,,;;;;;;;;,,,,,,'''......,:cd0XXXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWXOdoollllll;...........................':ldOXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNKkd:'......................ckXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0OkOOOOOOkkkkxxxxxxxkkOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
    String gachiF2= "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKc...''',,,,''....................................lkKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXOo:,,,,,,,,,,,''...................................lx0WWMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0dc:;,,;;;;;;;,,,'''................................. .',ckXWMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0d;'',,,;;:;;;;;,'''..................................    ..'cOXWMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKd:''',;;,;;;,,''''...................................         .'lOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd:''',,;;,,,,,'''..................................            ....,lkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXo,',,,,,,,,,,''..........................................        .....'lONWMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0dc;,,;,,,,,''............................'',,,,,,,,'''...........   .....;oOXNWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd:,,,,;;,,,,'.......................'''',,;;::::cc:::;;,,,,''.......   .....';clxO0KKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMWKx:'',,,,,,,,'....................',,;;;;::cccccccccccc::;;;;;,,,'''..............',;,;ck0KNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMWXkc;;,;,,,,,'...................'',;;::cccccccccccccccccc:::;;;;;;;;;,,,''................',;oONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMNx;',;:c:;;,'.................',,;::cclllllcccccccccccccc:::::;;;;;;;;;;;;;,,'................'c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMWXxc,,;;:::;;,'..............',;::cclllllccccccccccccccccc::::::::;;::;;;;;;;;;,,,''............':0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMWNk:,;;,;;;;,,''............',;:ccllllllllccccccccccccc:::::::::::::::::;;;;;;;;;;;,,,''.........':kNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMWXd:;;;;;,,,,,'''.........'';:cccllllllllllccccccccc::::::::::::;::::::::;;;;;;;;,,,,;;;,,'........';dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMWXOl;;::::;,'''..........',;:cclllllllllllllclllllllcc:::::::::::::::::::::::;;;;;,;;;;;;;;;'.........cKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWXkoc:;::c:;,''...........',;clllllllllllooolllooooooollcc::::::::::::::::::::::;;;;;;;;;;;;;:;,'.......cKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWO:,:::;;;,''..........'',;:cllllllooooooooooooooooooooollcc::::::::::::::::::::::;;;;;;;;;;;::;;,'.....;o0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWOc;::;;,'............',;:clllooolooooooooooooooooooooooollcc::::::::::::::::::::::;;;;;;;;;;:::::;'......dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMW0c;;,,,,''..........',;:lloooooooooooooooooooooooooooooolllcc:::::::::::::::::cc::::;;;;;;;;:::ccc:;'...'dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMW0l;,,,,,,,,,'......'',;cloooooooooooooooooooooooooooolllcccc::::::::ccccccccccccc:::;;,,,;;,,,,;:cc:;'..'l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMN0dc;,,,,,;;;,,''....'',:clooooooodddddddooooooooolllcc::;;;,,,,,,,,;;:ccccccc:::::::;,''...''....',,,,,,'',c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKl,,;,,,,,,,'''''...'',;:cloooooddddddddddoooollc::::;,'''''.......'',;:::ccc:::::;;,'.................',,'.;OWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKl',,,,,,''.........',;::cloddddddxxdddddollc:;;,,,''................'',;;:::::::;,,''..................'''':kNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKo;,,,'''...........',;:cclooddxxxxxxxddolc:;,''.......................',,,;:::::;;,,''...................'',:xXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKo;,,,,''..........'',;:ccllooddxxxxxddolc;,'...........................',,;;:::::;;;,,''.................''''lKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKd:;;,'............'',;::clloodddxxxxddoc:;,'..........................',;;::::::::::;;,,'''''''''',,,,,,',,,;oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWKxlc;,'............''',,;:cllloddxxxxxdolc;;,'''''','',,,,,,,,,,''.....';:ccccccccc:::;;,,,,,,,,,,;;;;;;;,,,;;;cxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo,,;,''............'''',;:cllloodxxxxdolc::;;;;;;;;;;;;;::::cc::;'....';clooolllccc:;;;,,,,,,,,,;;;;;;;;,,,,;;;,;xNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo''''..............'''',;:cclooddxxxxdolc:::ccccc::;;;;;::::::::;'...';coddooollcc::;;,,,,,,,''''''''''''''',,;;;cdKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo'................'''',,;:cclodddxxxddolcccllllcc:;;,'',,,,,,,,,'....,:lodddoollcc:;;;;;,,,,''..............'',,,,:xXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXl'...............'''',,;:cclloddxxxxdollllllllc:;,''........''''....,;coddddoolccc:;;;;;;;;,,,'''''''''',,,,,,,,;;,;oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo'..............'''',,;;:clloddxxxxxdollclllc:;,'.........'',,''''';clodddddoollccc:;;;;;;;;;;;,,,,,,,;;;;;;;;;;;:;;cxXWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo'.............''',,,;;:cclooddxxxxdoolcccc::;;,,''''''',,;;;;,,;;:lodddddddoollllcc:;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::;;xNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo'.............''',,;;::clloddxxxxdoollcccc:::::::;;;;;;;;::::::clloddddddddoodddoolc::::::;;;;;;;;;;;;;;;;;;;;;;::c::cxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXo'.'...........''',;;;::cloddxxxxddoollccccllllllc:::::::::ccccllllooddddddddddddddolcc:cccc::;;;;;;;;;;;;;;;;;;:::cc:;;xXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXd;'''..........''',;;;:cloddxxxxdddollllllloollllcc::::cccccllllllcclloddddddddddddoolc:cccc:;;;;;;;;;;;;;;;;;:::::::c:;:dXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNd;,'...........''',,;;:cloddxxxddddoolllllllllllllccccccclllllllcc:;:clodddddooooollcc:::;;:;;;;;;;;;;;;;;;;;;:::::::cc:;cxXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMXd;,,'..........'''',,;:codddxxddddddooooooollllllllllllllllllllcc:,',:ldxxdooc:::;;;;;;;;;;;;,,'',,,,;;;;;;;;;::::::::cc:;;dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNd;,,'..........'''',,;;cloodddddddddooooooooooooolooooolllllllcc:,'.';cdxdoc:,'....'',,,,,,,,,'..'',,,,,;;;;;;::::::::ccc:;:d0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNd,,,'...........'''',,;:cloodddddxdddoooooooooooooollllllllllcc:,'...,:lol:,'.........',,,,,,,,''',,,,,,,,,,,;::cc:::cclllc;,:dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMNx:'''............''',,,;cloddddddxdddddoddddxxxxddollllllllllc:;,'...',::;,'..........',,,,,,,,,,,,;;;;;;,,,,;::cccccllodolc;':0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWNkc'.............'''',,;:codxddxxddxxxddxxxxxxxxxddollllllllcc:;,.....',,,,''...'''''',,,,,,,;,,,,;;;;;;;;,;;;;::cccclodddolc;c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMWKc..............'''''',;cldxdxxddxxxxxxxxxxxxxxxxddollllllcc::;,'....,;::::;;;;;;;,;,,,,,,,,,,,;;;;;;,;;;;;,,;;;::cclodddolc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMXd;'.............''''',;:ldxxxxxxxxxxxxxxxxxxxxxxddollllllcc::;,,'.',;cloolllccc:;;;,,,,,,,;;;,,,;;;;;;;;;;;,,,;::cclodddolc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMNk;'........''...'..'';:codxxxxdxxxxxxxxxxxxxxxxxddolllcccc:;;,,,,;:clodoollccc:;;;;,;;;;;;;;;;;;;;;;;;;;;;;;,,;;:cclodddoc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWO:'.......''''''.''',;:cldxxxdddxxxxxxxxxxxxxxxxdooollccc::;,,,,;:clloolllcc::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::cclodolc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWNOc................'',:cloodxxxdddxxxxxxxxxxxxxxddoolcc:::;;;,,,;:cllllllcc:::;;;;;;,;;;;;;;;;;;;;;;;;;;;;;;;;;;;::clooolc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMNk;................',,;:clodxxxddxxxxxxxxxdddddddollcc::;;;,,,;:cllllllccc::;;;;;;;;;;;;:::;;;;;;;;;;;;;;;::;;;;;::clooll:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMNOc...',,,''......'',,;:clodxxdddxxxxxxxddddddddollcc::;;,,,,;:clllllccc:;;;,,,,,,;;;;;;;;;;;;;;;;,;;;;;;:::;;;;::clllll:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMNkc'';ccc:;,''''..'',,;:cldddddddxxxdddddddddddollcc::;,,,,,::cccccc::;;,,,'''''''',,,,,,,,,,,,,,,;;;;;;;;;;;;;::cllllc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMNk:,clcc:::cc:;,,'',,;:cloddddddxxxxddddddddddollcc:;;,,,,;;::::::;;,,'''''.......''''''''''''''',,,;;;;;;;;;;::cllllc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMW0c;;,',;:clollc:,,,,,;:codddddxxxxddddddddddoollcc:;;,,,,;;;;;;;,,,''''''''',,,;;;;;::::;;,'''''''',;;;;;;;;:::ccclcc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMWXkl,''';ccloooolc:,,,,;;cldddddxxxdddddddddddooolcc:;;;;,,,,,,'''.''',;:::cccccllllloodoollcc:;,'...',;:::::::::cccccc:l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMXd:,'',codooooooolc;,,,,;codddddddddddddddddddooollc::;;;;,,,''....',;:coddxxdoodxxdodxxkxxddddlc,....',;:::::::::cccc::l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMW0l,'..;oxxxdolloool:;,,,;:ooooooddddddddddddddooollcc:;;;;,,,'.....':clodxxxxdoodddoooodddollodol;'....',;::::::::cccc:;l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMW0oc;,'':oxxdoc::clooc;,,,;cooooooooodddddddooddooollcc::;;;,,,'.....':loooollcccccc::;;;;,,'.',;:;,'....',,;::::ccccccc:;l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMWXd;:c;''cdxdoc;,,:lddl:;;;:looooooooooooooooooooooollccc::;;;,,''.....,;::;,'..............    ..........',,;:::cccccccc:;l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMWKo,:c;',cddl:,'.':lddoc:::cloooooooooooooooooooooooollcc::;;;;,,'...........                        ....',,;::::cccccccc:;l0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMXxc::,';lol:,...,cdxxdllclloddoooooooooooooooooooooollcc:::;;;;,,,'.....                      .........'',;:::::cccccccc;,c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMWN0l,.';loc;'..,:odxxdoooooodooooooooooooooooooooooollcc::;;;;;;;;;;,'..............  ..  ............',,,;:::::ccccccc:;':0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMNkc;,;clc;'.,:oxxxddoddddooooooooooooooooooooooooollccc::;;;:::cccc:;;,'''''..................'''',,,,,;;;;:::ccccccc:;':0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMNk:,;lol;'':ldxxdddddddddooooooooooollllloooooooollccc:::;;::clllllllccccc::;;,,,,,'''''',,,,,,,,;;;;;;;;::::ccc::cc:;'c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMWOc,;clolcclddddddddddddddooooooooolllllloollolllllcccc:;;:::clllooooooolllllccc::;;;,,,,;;;;;;;;;;;;;;;::::::::::cc::o0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMN0o;;coddxdddoolodddddddoooooooolllllllllllllllllccccc::;:::cllllooooooooooollccc:;;;;;;;;;;;:::;;;;;;;;;;;::::::::;:kWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMW0l:codddddoooooooooodooooooolllllllllllllllllllccccc:::::ccllloooollllllllllccc:;;;;;;;;;;;;;;;;;;;;;;;;;;;::;:::,;xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMWWW0o:coddddddoooollllloooooollllllllllllllllllllccccccc:ccclllllllllllccclllccc:;;,,,,;;;;;;;;;;;;;;;;;;;;;::::::;,,dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMN0o:;:codddddol::;;;:looollllllllcclllllcllllccccccccccllllllllllllcccllcccc:;;,,,,,,;;;;;;:::::;;;;;;;;:::::::;',dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkc,';:cllll:;,''',:coollllllllccclllccclccccccccccccccccccclllllcccllcc::;;,,,,,,,;;;;;:::::;;;:;;;;;::;;::;,',xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKkl:;;,,;::;;,'',;clolllcccccccccccccccccccccccccccccccccccccccccccccc::;;;,,,,,;;;;;;;;::;;;;;;;;;;;:;;::;;cxXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNX0kc'.,:cccc::clollllccccccccccccccccccccccccccccccccccccccccccccc::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;:dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd:'';codddddollllccccccccccccccccccccccccccccccccccccccccccc:::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:;;;xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKx:,,codxxxdolllccccccccccccccccccccccccccccccccccccccccccc::::;;;;;;;;;;;;;;;;;,,;;;;;;;;;;;;;;;;,,dNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKx:,;coddddollccccccccccccccccccccccccccccccccccccllcclccc::::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;,,oXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0xc;:codoollccccccccccccccccccccccccccccccccccccllclllcccc::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;,'lXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxc;;cllllccccccccccccccccccccccccccccccccccccccccccccccc::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;;,;dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKxc;;clllllccccccccccccccccccccccccccccccccccccccccccc::::;;;;;;;;;;;::::;;;;;;;;;;;;;::;,ckNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWKxl::cllllllccccccccccccccccccccccccccccccccccccccccc::;;;;;;;;;;;:::;;;;;;;;;;;;;;:::;;lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWKxl::clllccccccccccccccccccccccccccccccccccccccccccc::;;;;;;;;;;;;;;;;;;;;;;;;;;:::;,,lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKklc::cccccccccccccccccccccccccccccccccccccccccc:::::;;;;;;;;;;;;;;;;;;;;;;;;:::;;,'c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKko:,;;::ccccccccccccccccccccccccccccccccccc:::;;;;;,,,,,,,,,,,,,,,,,,;;;;;:;;;,,'c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxc;,,',;:ccccccccccccccccccccccccccccc:::;;;,,,,,,,,,,,,,,,,,,,,,,,,;;;;;;,,,,;oKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNXKOoc:;,,;;::ccccccccccccccccccc::::::;;;;,,,,,''''''''''''',,,,,,',,,,,,'';oONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNXOdol;,,,;:::::::::::cc::::::;;;;;;,,,,'''''''''''''''''''''''''..,codONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXOxdc,''''''''',,;;:;;;;;;,,,,,,'''''''.....''''''''''......':xKWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kl;'''''',,;;;''''''''''''.....................'''.;oxOKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0000000000d:,'..................   .....'',cx000KNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNXKkl;,;;;;;;;;;;;;;;;;;;;;;lkKKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNXNNNNNNNNNNNNNNNNNNNNNNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
    String gachiF3= "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOl'..................................................                  ...........;dKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkl;'''''...''',''.....''''....................     .......                .......',''':xXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l;,,,,,'''''''',,'......'.......................     .......                  ....',;;;,;lkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo,';;:;;,'',,,''''''..............................   ........                   ...',;:ccc::lOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKx:'',;:c:;,'',,''''''............................................                 ....',;ccll::o0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo'.',,;::::;,''.............       ...............................                  ....',;cllc:;c0WMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl,',,,;;cc:;,''.............        .......................................           ...',;:clcc:oONMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOo:;,;,,,;:::;,''................................................''''''.........   ...  ....',,;;::;,l0WMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0o;,,;;;;;,;;;;,,'''.........................'',,,;;;;;;;;;;;;;;;;;;;;;;;,,,,''.......... ......''''''''cOWMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd;',;;:::;,,,,,''''''...................'''',;;::cccccccccccccccccccc::;;;;;,,,,,,''....................'lONWMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo;,,,;:cc:;,,'''''''''..............''',,;;;::cccccccccccccccccccccccc:::;;;;;;;;;;;;,,'..................':kNMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0d:,;;;;;::;;,'''''................'',,;;;::cccccccccccccccccccccccccccc::::;;;;;;;;;;;;;,,'.................'lONMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo,,,,;,,,''''''..................',,;::cccllcccccccccccccccccccccc:::c::::::::;;;;;;;;;;;;;,,,'...............'c0WMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0o:,,,,,,''......................',;:ccclllllllcccccccccccccc:::::::::::::::::::;;;;;;;;;;;;;;,,,,'.............',cONMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd;,,,,,''''...................'',;:clllllooollllllccccccccc:::::::::::::::::::::;;;;;;;;;;;;;;;;;;,,'...........',,oKWMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l;,,,,,,,,,;,''.............',,;::clllloollllllllllllllllccc::::::::::::::::::::;;;;;;;;;;;;;;;;;;;;;;,'.........',,,c0WMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0:',,'',,,;;;;,,,''.........',;:cclloooooooooolllooooolllllccc::::::::::::::::::;;;;;;;;;;;;;;;;;;;;;;:;,'.........',,;oONMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKc',,'',,,,,,,,,,,,,'.......',:cllloooooooooooooooooooooollllcccc:::::::::::::::;;;;;;;;;;;;;;;;;;;;;;:::;'.........,;,'c0MMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c',,,',,,,,''''''''''.....',;:clooooooooooooooooooooooooolllllcc::cccccc:::::::;;;;;;;;;;;;;;;;;;;;;;;:::;,........',,.:0WMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO:',;,,',,''.......'''....',,:cloooooooooddddddddddooooooooollllccccccccc:::::::;::::;;;;;:;;;;;;;;;;;;;;:;;,........'..:0WMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c',,,,,'''..............'',;:clooddddddddddddddddddoooooooollllcccccc::::::::;;;;::::::::::;;;;;;;;;;;;;;;;;,'.........:0WMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl,,,,,,'''.............''',;:clooddddddxdddddxxddddoooooooolllllccccc:::::::;;;;;;;:::::::::;;;;;;;;;;;;;;::;,'.....'''lKMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0o;,,,,'''...............'',;:clloodddddxxxxddxxxxdddoooooooooollllcccccc::::;;;;;;;;;::::::::;;;;,,,,;;;;;;::;;,.....'',oKWMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl'.''...........''........',;:cclooddddxxxxxxxxxxxxddddooooooooolllllllcc::::;;;;;;;;;;;::::::::;;;;;;;;;;;;::::;,'....,;co0WMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKl.......................''',;::clloooddxxxxxxxxxxxxdddddddooooooooolllllccc::::;;;;;;;;;::::cc::::;;;;;;;;;;;:cllc;,'..';,,oXMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl.......................''',;;:ccloooddxxxxxxxxxxxxxxxdddddddddooooooolllccc::::::::::::::::::::::::;;;;;;;;::clool:,'.',,'oXMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl..''''...............'.'''',;:ccllooddxxxxxxxxxxxxxxdddddddddooooooooolllcccc::::::::::::::c::::::::;;;;;:::::loddoc;,''',dNMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl'.''''.................''',;;:ccllodddxxxxxxxxxxxxxdddddooooooooooooolllcccc:::::::::ccccccc::cc::::;;;;;::::::codxdo:,,';dNMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo'.''''................'''',;;:cclloddxxxxxxxxxxxxxdddooooollllccccccc::;;;;;;;;;;;::ccccccc:::ccc::;;,;;;,,;;;;;:loddlc;;:xNMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo'.''''''.............'''',,;::clloodxxxxxxxxxxxxdddoollcc::;;;,,,,,'''''''''''''',;::cccc::::::::;,,''''''''''''',;clllc:cdKWMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo'..'''''...........'''',,;;;:cclooddxxxxxxxxxxxxddolc:;;,,''.....................',,;:::::::;;;;,,'...............',;::cc::l0WMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo'......'''......''''',,,,;:::clooddxxxxxxxxxxxxxdol:;,''..........................'',;;:::::;;,,'....................';:cc,;kWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo'...............''',,,,;;;:cclloddxxxxxdxxxxxxxxdlc;,''............................'',;;::::;;,''.....................,:cc;:OWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd;................'',,,;;;;::clooddxxdddddxxddddddoc:;,,'''...........................',;;::::;;;,''....................,:cc;:OWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWx'................''',;;;;;::clooddxxxddxxxdddoolllc::;,,,''''''',,,,,,'''............'',;;:::::;;;,,'''.......''.''''''',;:c;:OWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWx'...............'''',;;;;::ccloddxxxxxxxxddddollccc::;;;;;;;;;;;;;;;::;;;;,'.........',,;::::::::;;;,,,''''',,,,,,,,,,,,;:cc:ckXWMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNx'...............'''',,;;;:clloddxxxxxxxdddddolllccccccccccc::;;;;;;:::::;;;,........',;::cccc::::;;;,,,''''',,;;,;,,;;;;:::cc::oKWMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNx,.''.............'''',;;;:clloddxxxxxxxdddddoollllllllllllc::;;;;;,;;;;,,,,'.....'';:cccllccc:::;;;;,,'......'''''',,;;::::cc:';OWMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk;;;'..............''',,;;:cloddxxxxxxxxxxddoolllllllloollc:;,,''''''....''......';clooooollc:::;;;;;,,'..............',,;:::c:,c0WMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWkc::,..............''',,,;:clodxxxxxxxxxxdddolllllllloolc:;,'.........'',,,'....':lddxddoolcc::;;;;;;;,,'''''''.........',;::c:;lKWMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWkccl;.............''''',,;:cloddxxxxxxxxdddoollcccllllc:;''.........',,;;;,'..',:ldxxdddoolcc::;;;;;;;;;;;;;;;,,,,,,,''',;;::c:;l0WMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk:cl:'..............'''',;;:lodxxxxxxxxxdddoollccclccc:;,,''''''',,,,;;;;;,,,,:codxxxxddoollc:::;;;;;;;;;;;;;;;::::::;;;;;::ccc;lKMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOlccc,...............''',,;:clddxxxxxxxxxddoollcccccccc:::::;;;;;;;;;;;;;;;;:cloddxxxxdddollcc:::;;;;;;;;;;;;;:::::::::::::cclc:lKMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKd::;'.............'''',,,;:ldddxxxxxxxxddooollllllllllllcc::::::::::::::cclooddxxxxxdddoollccc::;;;;;;;;;;;;;;::::::::::cccllclxKWMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOoc;'...........''''''',,;:lodxxxxxxxxxdddooooooollllllccccccccccccccclllllooooddxxxdddolllcc:::;;;;;;;;;;;;;:::::::::::ccclll:,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo;,'.........''''''''',;:loddxxxxxxxxxddddoooooooollllcclllclllllllllllllllllloddddddoollcc::::;;;;;;;;;;::::::::::::::cclll:,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo,,'.........'''''''''';clddxxxxxxxxxxxdddooooooooolllllllllllolllloolllllcc::codddddooooolcc::::::;;;;;::::::::::::::ccccllc;oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0o,'................'',;clddxxxxxxxxxxxxddddoooooooooolloooooooollloollllc:;,;coddoddddxddolccccccccc:;;:::::cc::::::::c::clc;oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOc,''''''''........'',;clddxxxxxxxxxxxxxddddoooooooooooooooooooooooolllc:;'',codxddxxddddolccccclllc::::::::ccc:::::::::::cc:oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0o::::::,,'.......',;:cldddddddxxxxxxxxxxdddoooooooooooooooooooooolllc:;'..,cdxxxxdolllllcc:::::::::::::::::ccc:::::::::ccc:dXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxoooollc::;;,''...',;cclodddddddddxxxxxxxxxxdddddddddooooooooooollllc:;,...,ldxxdoc:;,;;::;;;;;;;;;,,,,;;::::cccc:::::::ccccxXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk::clc:;,;::cc:;,'''';:clodddddddddddxxxxxxxxxxdddddddddooooooooolllcc;,'...,codol:,.....',,;;;;,,,,'...',;;::::::::::::::cccdKWMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl;;;'''',;:llll:,''',;cllodddddddddddxxddddddddddddddddddooooooolllc:;,....';:cc;'.......',,,,,,,,,'...',;;;;:::::::::::::cc:lONMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l;,'',:cc:clodol:,,,,;::cloddddddxxdddddddddddddddddxxddddooooooolcc:;,.....',;;'........',,,,,,,,,,''',;;;;;;::::::::::::c:,,dNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dc,..,cdddoloddolc;,,,;;::clodddddxxdddddddddddddddddddddddddoooolcc::,'......,;;;,'''''''',,,,,,,,,,,,,;;;;;;;::::::::::::::,,xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo;,'..;oxxddoooolllc:;,,;;::loddddxxxdddddddddddddddddddddddddooollc:::;,''.'';:cllc::::;;,,,,,,,,,,,,;;;;;;;;;;;::::::::::::;',xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl,,'.':dxxdolc::;:lll:;,,;;:clodddxxxxddddddddddddddddddddddddoollcc::;;;,,,;:clooollccc:;;,,,,,,,,,,;;;;;;;;;:::::::::::::::;',xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl,'..,cdxdlc:;''';ldoc;,,,;;:lodddxxxxxdddddddddddddddddddddddoolcc:::;;;;::cllooollccc::;;;;;;,,,,,;;;;,;;;;;:::::::::::::::;,;xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl'...,lddc;,'...';lddl:;,,;;:clddxxxxdddddddddddddddddddddddddoolcc:::;::cclllllllcccc::;;;;;;;,,,,,;;;;;;;;;;:::::::::::::::;',xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c...';lol;'....',cdxdoc;,,;;:cloddddddddddddddddddddddddddddddoolcc::::cllllllllllccc::::;;;;;;,,,,,;;;;;;;;;;;::::::::::::::;''dNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c...':ll:,....';ldxxdoc;,,;;;:coddddddddddddddddddddddddddddddoollc:::cllooollllllccc:::;;;;;;;,,,,,;;;;;;;;;;;::::::::::::::;..oNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c','';ll;'...';ldxxxdo:;,,,;;:clodddddddddddddddddddddddddxxddoollc:ccllooolllllllccc::;;;;;,,,,,,,,;;;;;;;;;;;::::::::::::::;.'dNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOo:,,;cl:'...,lxkxxxxo:,,,,,;;cloddddddoooooodddddddddddxxxxddoollcccllooooolllllcc::;;,,,,,,,,,,,,,,,,;;;;;;;;::::::::::::::;,,xNMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl;,;:lc;'',:oxxxxxxoc;,,,;;:codddddooooooooooddddddddddxxxddoolllcllooooolllccc:;;;,'''''''''''''''''''',,,,;:::::::::::::::lkXWMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0l,,:cll::coddddddol:;;;;:cloodddddooooooooooddddddddddddxddooolllloooolllcc::;;,''......................'',;;::::::::::::;;dXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkc;;:lodddxdoolllcc:;::cloddddddddooooooooooddddddddddddddddoollloooollcc::;;,,,'''''',,,,',,,;,,,'.......',;::::::::::::;;dXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl,;cldxxxdollcc:::::clddddddddddooooooooooodddddddddddddddoooloooollcc::;;,,,,,;;;;:cllc:cloolcc:,'......',;;::::::::::;;oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOoccloxxxolccc:::::cclodddddddddooooooooooooooodddddddddddooooooollcc:;;;;,,,,;ccccloddooodxxdoooc;.......',;;:::::::c:;,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOxoodddolccccc:::::clodddddddoooooooooooooooooooodddddddoooooollcc:;;;;;,'',:cllloddxddoddddoool;'......',,;:::::::cc;,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNkc:llolllllccc:;;;;cldddddoooooooooooooooooooooooooddddoooolllcc:;;;;;,'..',;;::clllllccccccc:;'.......',,;;::::::c:;,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk:;;clccccccc:;,,,,;coddooooooooooooolllooooooooooooodddoolllccc:;;;;;,.......',,;,,,,,,,,,,,,'.......'',,;;::::::::,'oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKxllc:::cccc:;,,'.';lodoooooooooolllllllloooooooooooooooollccc::;;;;;,,'...''',,,,'''''''',,,,''.....',,;;;::::::::,'lXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOl;,,;:clllcc:;'';codoooooooolllllllllllllooooooooooooollccc:::;:::::;;;;,;;;;;;,,,,,,,,,,,,,,''''',,;;;;::::::::,'lKMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkl,'':loddddooc:clooooooooollllllclllllllllloooooooooollcccc:::::cccccc:::ccc::;;,,,,,,,,,,,,,,,,,,,;;;::::::::;,'lXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXx:',coxxxxxxdoooooooooooollllllccllllllllloooooooolllccccccccccccclllcccccccc:;;;;;,,,,,;;;;;;;;;;;;;::::::::;,,oXMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXd;';ldxxxxxxdddddoooooolllcccccccclllllllllllllllllcccccccccccccclllccccccc:::;;,,,,,,,,;;;;;;;;;;;::::::::::lxKWMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMMWXx;':odxxxxxxddddooooollcccccccccclllllllllllllllcccccccccccccccccccccccc:::;;;,,,,,,,,'',,,,,,;;:::::::::::;l0WMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMMWKd::ldxxxxxxddddoooollccccccccccccllllllllllllccccccccccccccccccccccc::::;;;,,,,'''''...'''',,;:::::::::::;,c0WMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMMMMMMMMMMMMMMMMWN0xllodxxxdddddoolllllcccccccccccccccccllllccccccccccccccccccccccc::::;;;,,,,,'''''......'',,;;:::::::::;,':0WMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXd:codddddddooolllllccccccccccccccccccccccccccccccccccccccccccc::::;;;,,,,,,,,'''''''''',,,;;::::::::;;;lONMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxlccloooooooollllcccccccccccccccccccccccccccccccccccccccccc:::::;;;,,,,,,,,,,,,,,,,,,,,;;;:::::::::;';kWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd;;clooooollllcccccccccccccccccccccccccccccccccccccccccc::::::;;;,,,,,,,,,,,,,,,,;;;;;;;::::::::;,';kWMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMMMMMMMMMMMMMW0l;,:clllllllccccccccccccccccccccccccccccccccccccccccccc::::::;;;;,,,,,,,,,,,,,;;;;;;;;;;;;;;::;;,;l0WMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkl:;::cllllccccccccccccccccccccccccccccccccccccc::::::::::::;;;;;;;;;;,,;;;;;;;;;;;;;;;;;;;::;,;dXWMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kxo:;;:cccccccccccccccccccccccccccccccccccccc::::ccc:::::::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;,,dNMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkc,,;,;;:ccccccccccccccccccccccccccccccccc:::ccccc:::c:::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,;dXMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0ko::::;::::ccccccccccccccccccccccccccccccccccccccccc:::;;;;;;;;;;;;;;;;;;;;;;;;;;;,;;ckXWMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNXX0o;''',;::::cc:ccccccccccccccccccccccccccccccccc:::;;;;;;;;;;;;;;;;;:::;;:::;;,,,lKMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOocc:,',,;;;:::::::::cccccccccccccccccccccccc::::;;;;;;;;;;;;;;;;;;::;;;;;;,,''c0WMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNXxc,'''',,;;;:::ccccccccccccccccccccccc:::::;;;;;;;;;;;;;;;;;;;;;;;;;,,'',ckNMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkxo;''''',;:::::::ccccccccccccccc:::::;;;;;;,,,,,,,,,;;;;;;;,,,,,,'';lkXWMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKOko:;,,,,;;;::::::::c::ccccc:::::;;;;,,,''''''',,,,,,,,,,,'''';lkXWMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNXKkl::,,,;;;;:::::::::::::::;;;,,,''''''...''''','''''''.,lkXWMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNX0d:'.'',;;;;;;;;;;;;;;;;,,'''.............''......':xKWWWMMMMMMMMMMMMMMMMMMMMMM";
}

