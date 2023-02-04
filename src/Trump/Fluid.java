package Trump;

public class Fluid {
    static final int h = BasicFrame.STA_H, w = BasicFrame.STA_W;
    //static final int h = 30, w = 30;
    static final double g = 10;
    static final double deg = Math.PI/8;
    final double denMul = 1;

    double denMx = 0, denMn = 0, curSum = 0, curCnt = 0;
    double[][] vy, vx, vyn, vxn, den, denn;
    boolean debug = !true;
    double stadenMn = 0, stadenMx = 0, stadenCnt = 0;
    int debugcounter = 0;
    String[][] out = new String[h][w];
    Fluid(){
        denn = new double[h][w];
        den = new double[h][w];
        vy = new double[h][w];
        vx = new double[h][w];
        vyn = new double[h][w];
        vxn = new double[h][w];
        INIT();
        INIT_border();
    }
    void INIT(){
        for (int i = 0; i < out.length; i++)
            for (int j = 0; j < out[0].length; j++)
                out[i][j] = " ";
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++){
                vy[i][j] = 9999;
                vx[i][j] = 9999;
                den[i][j] = 9999;
            }
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++){
                vy[i][j] = 0;
                vx[i][j] = 0;
                den[i][j] = 1000;
            }
    }
    double getV(int y, int x){
        return Math.sqrt(vy[y][x]*vy[y][x]+vx[y][x]*vx[y][x]);
    }
    void addFluid(int y, int x, double vey, double vex){
        vy[y][x] += vey;
        vx[y][x] += vex;
        //System.out.println(vy[y][x] + " " + vx[y][x]);
    }
    void run(){
        run(50, 10);
    }
    void run(double fs, double as){
        addFluid(h/2, w/2, 2,3);
        render();
        double sec = 0;
        while (sec < fs){
            if(!debug) {
                int tmp = (int)(Math.random() * 2) + 1;
                if (tmp == 1 && sec < as) {
                    System.out.println(tmp);
                    int addh = (int) (Math.random() * (h - 10)) + 1;
                    int addw = (int) (Math.random() * (w - 20)) + 1;
                    double vey = ((Math.random() * 6) - 3);
                    double vex = ((Math.random() * 6) - 3);
                    //System.out.println(addh + " " + addw + " " + vey + " " + vex);
                    addFluid(addh, addw, vey, vex);
                }
            }
            runVelo();
            runDen();
            applyNext();
            render();
            try {Thread.sleep(250);sec+=.25;debugcounter++;}
            catch (Exception e){System.out.println(e);}
        }
    }
    static boolean inBwn(double value, double top, double bot){ return value <= top && value >= bot; }
    static double conv(double rad){if (rad < 0) rad += Math.PI*2; return rad;}

    void printTest(){
        if (debug){
            if (!true){
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        System.out.print(String.format("%02f", den[i][j]));
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            for (int i = 1; i < h-1; i++) {
                for (int j = 1; j < w - 1; j++) {
                    System.out.print(String.format("%02f", den[i][j]));
                    System.out.print(" ");
                }
                System.out.println();
            }
        /*
        System.out.println("VY");
        for (int i = 1; i < h-1; i++) {
            for (int j = 1; j < w - 1; j++)
                System.out.print(vy[i][j]+ " ");
            System.out.println();
        }
        System.out.println("VX");
        for (int i = 1; i < h-1; i++) {
            for (int j = 1; j < w - 1; j++)
                System.out.print(vx[i][j] + " ");
            System.out.println();
        }
        */
        }
        System.out.println();
        System.out.println();

    }

    double magDen(int i, int j){
        return den[i][j]*Math.sqrt(vy[i][j]*vy[i][j]+vx[i][j]*vx[i][j]);
    }
    double getSurDen(int y, int x){
        double avg = 0;
        for (int i = -1; i < 1; i++)
            for (int j = -1; j < 1; j++){
                if (i == 0 && j == 0) continue;
                avg += den[y+i][x+j];
            }
        return avg/8;
    }
    void runVelo(){
        //printTest();
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++){
                if (!(vy[i][j] == 0 && vx[i][j]==0)) {
                    if (Math.abs(vy[i][j])+Math.abs(vx[i][j]) < 0.00625){
                        vy[i][j] = 0;
                        vx[i][j] = 0;
                        continue;
                    }
                    else if (den[i][j] < getSurDen(i,j)){
                        vy[i][j]/=2;vx[i][j]/=2;
                        continue;
                    }
                    if (i == 1          ) {vy[i][j]*=-1;vx[i][j]*=-1;}
                    else if (i == h-2   ) {vy[i][j]*=-1;vx[i][j]*=-1;}
                    else if (j == 1     ) {vy[i][j]*=-1;vx[i][j]*=-1;}
                    else if (j == w-2   ) {vy[i][j]*=-1;vx[i][j]*=-1;}
                    double rad = Math.atan2(vy[i][j],vx[i][j]);
                    rad = conv(rad);
                    double mxrad = conv(rad+deg)%(Math.PI*2), mnrad = conv(rad-deg)%(Math.PI*2);
                    int quarmn = -1, quarmx = -1;
                    //inBwn(Math.PI*2, deg, Math.PI*2-deg)
                    for (int k = 0; k < 8; k++) {
                        if (k == 0) {
                            if (inBwn(mxrad, deg, 0)||inBwn(mxrad, 0, conv(0-deg))){quarmx = 0;}
                            if (inBwn(mnrad, deg, 0)||inBwn(mnrad, 0, conv(0-deg))){quarmn = 0;}
                        } else {
                            if (inBwn(mxrad, (deg*k*2)+deg, (deg*k*2)-deg)) {quarmx = k;}
                            if (inBwn(mnrad, (deg*k*2)+deg, (deg*k*2)-deg)) {quarmn = k;}
                        }
                    }
                    if (quarmx == 1 && quarmn == 7) {quarmx = 0; quarmn = 0;}
                    else if (quarmx == 2 && quarmn == 0) {quarmx = 1; quarmn = 1;}
                    else if (quarmx == 3 && quarmn == 1) {quarmx = 2; quarmn = 2;}
                    else if (quarmx == 4 && quarmn == 2) {quarmx = 3; quarmn = 3;}
                    else if (quarmx == 5 && quarmn == 3) {quarmx = 4; quarmn = 4;}
                    else if (quarmx == 6 && quarmn == 4) {quarmx = 5; quarmn = 5;}
                    else if (quarmx == 7 && quarmn == 5) {quarmx = 6; quarmn = 6;}
                    else if (quarmx == 0 && quarmn == 6) {quarmx = 7; quarmn = 7;}
                    double magL = ((deg*(quarmx+1)*2) - (mxrad+deg))/(deg*2);
                    double magU = 1-magL;
                    //System.out.println(quarmx + " " + quarmn);
                    switch (quarmx){
                        case 0: {
                            vyn[i][j+1]+=magU*vy[i][j]/2;
                            vxn[i][j+1]+=magU*vx[i][j]/2;
                            denn[i][j+1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 1: {
                            vyn[i-1][j+1]+=magU*vy[i][j]/2;
                            vxn[i-1][j+1]+=magU*vx[i][j]/2;
                            denn[i-1][j+1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 2: {
                            vyn[i-1][j]+=magU*vy[i][j]/2;
                            vxn[i-1][j]+=magU*vx[i][j]/2;
                            denn[i-1][j]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 3: {
                            vyn[i-1][j-1]+=magU*vy[i][j]/2;
                            vxn[i-1][j-1]+=magU*vx[i][j]/2;
                            denn[i-1][j-1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 4: {
                            vyn[i][j-1]+=magU*vy[i][j]/2;
                            vxn[i][j-1]+=magU*vx[i][j]/2;
                            denn[i][j-1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 5: {
                            vyn[i+1][j-1]+=magU*vy[i][j]/2;
                            vxn[i+1][j-1]+=magU*vx[i][j]/2;
                            denn[i+1][j-1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 6: {
                            vyn[i+1][j]+=magU*vy[i][j]/2;
                            vxn[i+1][j]+=magU*vx[i][j]/2;
                            denn[i+1][j]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                        case 7: {
                            vyn[i+1][j+1]+=magU*vy[i][j]/2;
                            vxn[i+1][j+1]+=magU*vx[i][j]/2;
                            denn[i+1][j+1]+=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magU*den[i][j]/g;
                        }break;
                    }
                    switch (quarmn){
                        case 0: {
                            vyn[i][j+1]+=magL*vy[i][j]/2;
                            vxn[i][j+1]+=magL*vx[i][j]/2;
                            denn[i][j+1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 1: {
                            vyn[i-1][j+1]+=magL*vy[i][j]/2;
                            vxn[i-1][j+1]+=magL*vx[i][j]/2;
                            denn[i-1][j+1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 2: {
                            vyn[i-1][j]+=magL*vy[i][j]/2;
                            vxn[i-1][j]+=magL*vx[i][j]/2;
                            denn[i-1][j]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 3: {
                            vyn[i-1][j-1]+=magL*vy[i][j]/2;
                            vxn[i-1][j-1]+=magL*vx[i][j]/2;
                            denn[i-1][j-1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 4: {
                            vyn[i][j-1]+=magL*vy[i][j]/2;
                            vxn[i][j-1]+=magL*vx[i][j]/2;
                            denn[i][j-1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 5: {
                            vyn[i+1][j-1]+=magL*vy[i][j]/2;
                            vxn[i+1][j-1]+=magL*vx[i][j]/2;
                            denn[i+1][j-1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 6: {
                            vyn[i+1][j]+=magL*vy[i][j]/2;
                            vxn[i+1][j]+=magL*vx[i][j]/2;
                            denn[i+1][j]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                        case 7: {
                            vyn[i+1][j+1]+=magL*vy[i][j]/2;
                            vxn[i+1][j+1]+=magL*vx[i][j]/2;
                            denn[i+1][j+1]+=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                            den[i][j]-=mag(vy[i][j],vx[i][j])*magL*den[i][j]/g;
                        }break;
                    }
                    //unstable
                    vy[i][j]/=2;vx[i][j]/=2;

                    //this too
                    /*
                    if ((Math.abs(vx[i][j])+Math.abs(vy[i][j]) - g/(g+69)) < 0 ){vx[i][j] = 0; vy[i][j] = 0;}
                    else {
                        double sum = Math.abs(vx[i][j])+Math.abs(vy[i][j]);
                        double mag = Math.abs((sum-(g/(g+69)))/sum);
                        vx[i][j] = mag*vx[i][j];
                        vy[i][j] = mag*vy[i][j];
                    }
                     */
                }
            }
        printTest();
    }
    void runDen(){
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++){
                /*
                int counter = 1;
                double avg = 0, u = 0, d = 0, r = 0, l = 0;
                double one = 0, two = 0, thr = 0, fur = 0;
                if(vy[i][j]==0){
                    if (den[i][j] > den[i-1][j]){u = 1;}
                    if (den[i][j] > den[i+1][j]){d = 1;}
                }
                if(vx[i][j]==0){
                    if (den[i][j] > den[i][j+1]){r = 1;}
                    if (den[i][j] > den[i][j-1]){l = 1;}
                }
                if(vx[i][j]==0&&vy[i][j]==0){
                    if (den[i][j] > den[i-1][j-1]){one = 1;}
                    if (den[i][j] > den[i-1][j+1]){two = 1;}
                    if (den[i][j] > den[i+1][j-1]){thr = 1;}
                    if (den[i][j] > den[i+1][j+1]){fur = 1;}
                }
                //avg = (u + d + r + l + one + two + thr + fur + den[i][j])/counter;

                 */
                double tmp;
                if (den[i][j] > den[i-1][j])    {tmp = ((den[i][j] - den[i-1][j])  * g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i-1][j])  * g/(g*8*denMul)):(den[i][j] - den[i-1][j])  /2; den[i-1][j]  +=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i+1][j])    {tmp = ((den[i][j] - den[i+1][j])  * g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i+1][j])  * g/(g*8*denMul)):(den[i][j] - den[i+1][j])  /2; den[i+1][j]  +=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i][j+1])    {tmp = ((den[i][j] - den[i][j+1])  * g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i][j+1])  * g/(g*8*denMul)):(den[i][j] - den[i][j+1])  /2; den[i][j+1]  +=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i][j-1])    {tmp = ((den[i][j] - den[i][j-1])  * g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i][j-1])  * g/(g*8*denMul)):(den[i][j] - den[i][j-1])  /2; den[i][j-1]  +=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i-1][j-1])  {tmp = ((den[i][j] - den[i-1][j-1])* g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i-1][j-1])* g/(g*8*denMul)):(den[i][j] - den[i-1][j-1])/2; den[i-1][j-1]+=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i-1][j+1])  {tmp = ((den[i][j] - den[i-1][j+1])* g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i-1][j+1])* g/(g*8*denMul)):(den[i][j] - den[i-1][j+1])/2; den[i-1][j+1]+=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i+1][j-1])  {tmp = ((den[i][j] - den[i+1][j-1])* g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i+1][j-1])* g/(g*8*denMul)):(den[i][j] - den[i+1][j-1])/2; den[i+1][j-1]+=tmp; denn[i][j]-=tmp;}
                if (den[i][j] > den[i+1][j+1])  {tmp = ((den[i][j] - den[i+1][j+1])* g/(g*8*denMul)) > 1 ? ((den[i][j] - den[i+1][j+1])* g/(g*8*denMul)):(den[i][j] - den[i+1][j+1])/2; den[i+1][j+1]+=tmp; denn[i][j]-=tmp;}
            }
    }
    void applyNext(){
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++) {
                den[i][j]+=denn[i][j];
                denn[i][j]=0;
                vx[i][j]+=vxn[i][j];
                vxn[i][j]=0;
                vy[i][j]+=vyn[i][j];
                vyn[i][j]=0;
            }

    }
    String convertDen(double a){
        String out = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
        //out = "@$#*!=;:~-,. ";
        //
        double step;
        double max = 1300;
        double min = 850;
        step = (max-min)/out.length();
        //double length = denMx - denMn;
        /*
        for (int i = 0; i < out.length(); i++){
            if (i == out.length()-1) {
                if (a > ((out.length()-1/out.length())*length)+denMn) {
                    return String.valueOf(out.charAt(out.length()-1-i));
                }
            }
            else if (a <= ((i+1/out.length())*length)+denMn) {
                return String.valueOf(out.charAt(out.length()-1-i));
            }
        }

         */
        for (int i = 0; i < out.length(); i++){
            if (i == out.length()-1) {if (a>max-(2*step)){return String.valueOf(out.charAt(out.length()-1-i));}}
            else if (a<=max-(out.length()*step)+(i*step)){return String.valueOf(out.charAt(out.length()-1-i));}
        }

        System.out.println("\n\n\n\n\nValue is not in bound - Value: " + a);
        return "T";
    }
    double mag(double y, double x){
        return 1+Math.sqrt(y*y+x*x);
    }
    void render(){
        if (true){
            if (debug){
                printTest();
                for (int i = 1; i < h-1; i++) {
                    for (int j = 1; j < w - 1; j++){
                        if (vy[i][j]==0)System.out.print("Y:0.------");
                        else System.out.print(String.format("Y:%02f",vy[i][j]));
                        if (vx[i][j]==0)System.out.print("X:0.------");
                        else System.out.print(String.format(", X:%02f",vx[i][j]));
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
        denMx = den[1][1]; denMn = den[1][1]; curSum = 0; curCnt = 0;
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++){
                if (den[i][j] < denMn){denMn = den[i][j];}
                if (den[i][j] > denMx){denMx = den[i][j];}
                curSum += den[i][j]; curCnt++;
            }
        for (int i = 1; i < h-1; i++)
            for (int j = 1; j < w-1; j++)
                out[i][j] = convertDen(den[i][j]);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                System.out.print(out[i][j]);
            System.out.println();
        }
        stadenMn += denMn; stadenMx += denMx; stadenCnt++;
        System.out.println("Max: "+ denMx + ", Min: " + denMn +", Current Avg: " + curSum/curCnt + ", Avg Max: "+ stadenMx/stadenCnt + ", Avg Min: " + stadenMn/stadenCnt);
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
}
class SimFluid {
    public static void main(String[] arg){
        System.out.println(Math.atan2(0,-1));
        Fluid fluid = new Fluid();
        fluid.run(300,100);
    }
}
