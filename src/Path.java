import java.io.*; 
public class Path{
    private String dataPath;
    private String data;
    private String path;
    private String header;
    private boolean loaded;
    // True if has external file, false if data in obj
    private boolean external;
    //Constructor, if data is empty dataPath is set, always loads
    public Path(String path, String data, String dataPath, String header){
        this.path = path;
        if(data == ""){
            this.external = true;
            this.dataPath = dataPath;
            load();
            this.loaded = true; 
        }else{
            this.data = data;
            this.loaded = true;
            this.external = false;

        }
        this.header = header;
    }
    //Constructor, if data is empty dataPath is set, loads if loaded true
    public Path(String path, String data, String dataPath, String header, boolean loaded){
        this.path = path;
        if(data == ""){
            this.external = true;
            this.dataPath = dataPath;
            if(loaded){
                load();
            }
            this.loaded = loaded; 
        }else{
            this.external = false;
            this.data = data;
            this.loaded = true;
        }
        this.header = header;
    }
    //Loads data from dataPath
    public void load(){
        if(this.dataPath == ""){

        }else{
           FileReader fr;
            try{
                fr = 
                new FileReader(this.dataPath);
                int i; 
                this.data = "";
                try{
                    while ((i=fr.read()) != -1) {
                        this.data += ((char) i);
                    } 
                }
                catch(Throwable tr){
                    tr.printStackTrace();
                } 
            }
            catch(Throwable tr){
                tr.printStackTrace();
            }
            
    }
}
    //Switches data path and loads
    
    public void load(String dataPath){
        this.external = true;
        this.dataPath = dataPath;
        FileReader fr;
        try{
            fr = 
            new FileReader(this.dataPath); 
            int i; 
            this.data = "";
            try{
                while ((i=fr.read()) != -1) {
                    this.data += ((char) i);
                } 
            }
            catch(Throwable tr){
                tr.printStackTrace();
            }
        }
        catch(Throwable tr){
            tr.printStackTrace();
        }
        
    }
    public String getDataPath(){
        return this.dataPath;
    }
    public String getData(){
        return this.data;
    }
    public String getPath(){
        return this.path;
    }
    public String getHeader(){
        return this.header;
    }
    public boolean isExternal(){
        return this.external;
    }
    public boolean isLoaded(){
        return this.loaded;
    }
}