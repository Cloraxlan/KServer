import KServer.*;
public class changeTime implements PostAction{
    public static String time = "9 pm";
    public static Path getTime = new Path("/time", time, "", Path.TXT);
    public void action(String responce){
        time = responce;
        getTime.setData(time);
    }
    
}