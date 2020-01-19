import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class Server{
    private int port;
    private Path[] paths;
    private HttpServer server;
    public Server(int port, Path[] paths){
        this.port = port;
        this.paths = paths;
        try{
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        }catch (Throwable tr)
        {
            tr.printStackTrace();
        }
        for(Path path: paths){
            server.createContext(path.getPath(), httpExchange ->
            {
                byte response[]= path.getData().getBytes("UTF-8");
                httpExchange.getResponseHeaders().add("Content-Type", path.getHeader());
                httpExchange.sendResponseHeaders(200, response.length);

                OutputStream out=httpExchange.getResponseBody();
                out.write(response);
                out.close();
            });

                
            }
    }
    public void start(){
        this.server.start();
    }
}


