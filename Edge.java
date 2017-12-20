

public class Edge {
    private Sommet begin;
    private Sommet end;
    private String label;
    private Edge edge;
     
    public Edge() {
        super();
    }
 
    public Edge(Sommet begin, Sommet end) {
        super();
        this.begin = begin;
        this.end = end;
    }
 
    public Edge(Sommet begin, Sommet end, String label) {
        super();
        this.begin = begin;
        this.end = end;
        this.label = label;
    }
 
    public String getLabel() {
        return label;
    }
 
    public void setLabel(String label) {
        this.label = label;
    }
 
    public Edge getEdge() {
        return edge;
    }
 
    public void setEdge(Edge edge) {
        this.edge = edge;
    }
     
    public Sommet getBegin() {
        return begin;
    }
 
    public void setBegin(Sommet begin) {
        this.begin = begin;
    }
 
    public Sommet getEnd() {
        return end;
    }
 
    public void setEnd(Sommet end) {
        this.end = end;
    }
 
    @Override
    public String toString() {
        return "Edge [begin=" + begin + ", end=" + end + ", label=" + label
                + "]";
    }
     
}