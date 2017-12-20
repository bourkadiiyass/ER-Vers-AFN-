public class Sommet {
    private int id;
    private static int ID=0;
     
    public Sommet(){
        this.id=ID++;
    }
 
    public int getId() {
        return id;
    }
     
    public static void reset(){
        ID=0;
    }
 
    @Override
    public String toString() {
        return id+"";
    }
     
}