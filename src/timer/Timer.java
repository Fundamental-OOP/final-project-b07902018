package timer;


public class Timer {
    long endTime;
    boolean started = false;


    public String getCountString(){
        if(started){
            if(ended())return "00:00";
            else {
                long s = (endTime - System.currentTimeMillis())/1000;
                return String.format("%02d:%02d", s/60,s%60);
            }
        }else{
            return "99:99";
        }
    }
    public boolean ended(){
        return started&&System.currentTimeMillis()>=endTime;
    }
    public void startTimer(int sec){
        started = true;
        endTime = 1000*sec + System.currentTimeMillis();
    }
}
