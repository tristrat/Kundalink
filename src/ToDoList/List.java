package ToDoList;public class List {
    String title;
    String contant;
    int id;
    boolean completed;
    public List() {
        new List("missing","missing",-1);
    }

    public List(String title, String contant) {
        new List(title,contant,-1);
    }

    public List(String title, String contant, int id) {
        this.title = title;
        this.contant = contant;
        this.id = id;
        completed=false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean finished(){
        if (completed){
            return false;
        }
        completed=true;
        return true;
    }
    public boolean unfinished(){
        if (completed){
            completed=false;
            return true;
        }
        return false;
    }
}
