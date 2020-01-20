package multimedia;
import kserver.*;
public class Main{

    public static void main(String[] args){
        Server server = new Server(8000, new Path[]{ new Path("/video", "", "C:/Users/Konrad/Documents/Java/KServer/src/multimedia/toad.mp4", Path.MP4), new Path("/image", "", "C:/Users/Konrad/Documents/Java/KServer/src/multimedia/download.png", Path.PNG)}, new Post[]{} );
        server.start();
    }
}