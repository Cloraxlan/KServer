package chat;
import java.io.FileWriter;
import kserver.*;
public class SendMessage implements PostAction{
    public static Path messages = new Path("/messages", "" , "C:/Users/Konrad/Documents/Java/KServer/src/chat/messages.txt", Path.TXT);
    public void action(String  responce){
        try {
            FileWriter fw = new FileWriter("C:/Users/Konrad/Documents/Java/KServer/src/chat/messages.txt", true);
            fw.append(responce+"<br>");    
            fw.close();
            messages.load();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}