
public class Main
{

 public static void main(String args[])
    {
        Server server = new Server(8000, new Path[]{new Path("/","", "./test.txt", "text/html; charset=UTF-8")});
        server.start();

  
 

    }
}