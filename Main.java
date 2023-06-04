public class Main {
    public static Time addSeconds(Time time, int s){
        Time res = new Time();
        res.second = time.second;
        res.hour = time.hour;
        res.minute = time.minute;
        res.isAM = time.isAM;
        if(s>=60){
            for(int i = s; i >= 60; i-=60){
                res.minute++;
            }
            s%=60;
        }
        res.second+=s;
        //what if we added SOOOO many seconds such that the amount of minutes is 60+?
        if(res.minute>=60){
            for(int i = res.minute; i >= 60; i-=60){
                res.hour++;
            }
            res.minute%=60;
        }
        //now what if we were totally insane and had the seconds so high that the PM/AM needs to change?
        if(res.hour>=12){
            for(int i = res.hour; i >= 12; i-=12){
                res.isAM = !res.isAM;
            }
            res.hour%=12;
        }        
        return res;
    }
    public static Time createTime(int h, int m, int s, boolean x){
        Time res = new Time();
        res.hour = h;
        res.second = s;
        res.minute = m;
        res.isAM = x;
        return res;
    }
    public static String timeToString(Time t){
        String res = "";
        if(t.hour<10){
            res+=("0"+t.hour+":");
        } else {
            res+=(""+t.hour+":");
        }
        if(t.minute<10){
            res+=("0"+t.minute+":");
        } else {
            res+=(""+t.minute+":");
        }
        if(t.second<10){
            res+=("0"+t.second);
        } else {
            res+=(""+t.second);
        }
        if(t.isAM){
            res+=" AM";
        } else {
            res+=" PM";
        }
        return res;
    }
    public static void test1(){
        // period 6 apcs: 
            // starts at 153 pm;
            // end at 244 pm;
        Time start = new Time();
        start.hour = 1; start.minute = 53; start.second=0; start.isAM = false;
        Time end = new Time();
        end.hour = 2; end.minute = 44; end.second=0; end.isAM = false;
        //print them
        System.out.println(timeToString(start));
        System.out.println(timeToString(end));
    }
    public static boolean equals(Time a, Time b){
        boolean result = true;
        result &= (a.hour == b.hour) && (a.minute == b.minute) && (a.second == b.second) && (a.isAM == b.isAM);
        return result;
    }
    public static void main(String[] args) {
        Time y = createTime(1,0, 0, false);
        Time y1 = addSeconds(y, 10);
        System.out.println(secondsBetween(y, y1));
    }
    public static int secondsBetween(Time a, Time b){
        int result = 0;
        while(!equals(a, b)){
            a = addSeconds(a, 1);
            result++;
        }
        return result;
    }
}
