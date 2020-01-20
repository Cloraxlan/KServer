public class Post extends Path{
    private String responce;
    private PostAction action;
    public Post(String path, String data, String dataPath, String header, PostAction action){
        super(path, data, "{}", "application/json");
        this.responce = "";
        this.action = action;

    }
    public void setResponce(String responce){
        this.responce = responce;
    }
    public void doAction(){
        this.action.action(this.responce);
    }


    

}
interface PostAction{
    void action(String responce);
}