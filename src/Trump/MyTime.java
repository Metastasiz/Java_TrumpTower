package Trump;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class MyTime extends BasicFrame {
    static String time;
    //double sTime = System.currentTimeMillis(), eTime;
    //static double lapse = 0;
    static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    MyTime(){
        super(3,10);
        refresh();
    }
    @Override
    public void refresh() {
        time = timeFormat.format(Calendar.getInstance().getTime());
        append(new PxObj(time).getObj(), 1, 1);
        //eTime = System.currentTimeMillis();
        //lapse += eTime-sTime;
    }
}
