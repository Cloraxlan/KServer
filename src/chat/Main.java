package chat;
import kserver.*;
public class Main{

    public static void main(String[] args){
        Server server = new Server(8000, new Path[]{new Path("/", "", "C:/Users/Konrad/Documents/Java/KServer/src/chat/index.html", Path.HTML), SendMessage.messages}, new Post[]{new Post("/send", "{}", "", Path.HTML, new SendMessage())} );
        server.start();
    }
}