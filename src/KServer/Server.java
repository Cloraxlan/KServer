package KServer;
import com.sun.net.httpserver.HttpServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class Server{
    private int port;
    private Path[] paths;
    private Post[] posts;
    private HttpServer server;
    public Server(int port, Path[] paths, Post[] posts){
        this.port = port;
        this.paths = paths;
        this.posts = posts;
        try{
            this.server = HttpServer.create(new InetSocketAddress(this.port), 0);
        }catch (Throwable tr)
        {
            tr.printStackTrace();
        }
        for(Path path: this.paths){
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
        for(Post post : this.posts){
            server.createContext(post.getPath(), httpExchange ->{
                StringBuilder sb = new StringBuilder();
                InputStream in = httpExchange.getRequestBody();
                int i;
                while ((i = in.read()) != -1) {
                    sb.append((char) i);
                }
                post.setResponce(sb.toString());
                post.doAction();
            });
        }
    }
    public void start(){
        this.server.start();
    }
}


