

import java.util.ArrayList;
import java.util.List;
 
public class Graph {
    private List<Edge> edges;
    private Sommet start;
    private Sommet end;
 
    public Graph() {
        edges = new ArrayList<Edge>();
    }
 
    public List<Edge> getEdges() {
        return edges;
    }
 
    public Sommet getStart() {
        return start;
    }
 
    public void setStart(Sommet start) {
        this.start = start;
    }
 
    public Sommet getEnd() {
        return end;
    }
 
    public void setEnd(Sommet end) {
        this.end = end;
    }
 
    public void reset() {
        Sommet.reset();
    }
 
    public void Star(Object obj) {
        if (obj.getClass().getName().equals(Graph.class.getName())) {
            addStar((Graph) obj);
            return;
        }
        if (obj.getClass().getName().equals(Character.class.getName())) {
            addStar((Character) obj);
            return;
        } else {
            throw new RuntimeException("You have an error in your Regex syntax");
        }
    }
 
    public void Union(Object obj1, Object obj2) {
        if (obj1.getClass().getName().equals(Character.class.getName())) {
            if (obj2.getClass().getName().equals(Graph.class.getName())) {
                addUnion((Character) obj1, (Graph) obj2);
                return;
            }
            if (obj2.getClass().getName().equals(Character.class.getName())) {
                addUnion((Character) obj1, (Character) obj2);
                return;
            }
        }
        if (obj1.getClass().getName().equals(Graph.class.getName())) {
            if (obj2.getClass().getName().equals(Graph.class.getName())) {
                addUnion((Graph) obj1, (Graph) obj2);
                return;
            }
            if (obj2.getClass().getName().equals(Character.class.getName())) {
                addUnion((Graph) obj1, (Character) obj2);
                return;
            }
        } else {
            throw new RuntimeException("You have an error in your Regex syntax");
        }
    }
 
    public void Concat(Object obj1, Object obj2) {
        if (obj1.getClass().getName().equals(Character.class.getName())) {
            if (obj2.getClass().getName().equals(Graph.class.getName())) {
                addConcat((Character) obj1, (Graph) obj2);
                return;
            }
            if (obj2.getClass().getName().equals(Character.class.getName())) {
                addConcat((Character) obj1, (Character) obj2);
                return;
            }
        }
        if (obj1.getClass().getName().equals(Graph.class.getName())) {
            if (obj2.getClass().getName().equals(Graph.class.getName())) {
                addConcat((Graph) obj1, (Graph) obj2);
                return;
            }
            if (obj2.getClass().getName().equals(Character.class.getName())) {
                addConcat((Graph) obj1, (Character) obj2);
                return;
            }
        } else {
            throw new RuntimeException("You have an error in your Regex syntax");
        }
    }
 
    public void addStar(Graph graph) {
        Sommet begSommet = new Sommet();
        Sommet endSommet = new Sommet();
        Edge edge1 = new Edge(endSommet, begSommet, "epsilon");
        Edge edge2 = new Edge(begSommet, graph.getStart(), "epsilon");
        Edge edge3 = new Edge(graph.getEnd(), endSommet, "epsilon");
        for (int i = 0; i < graph.getEdges().size(); i++) {
            this.edges.add(graph.getEdges().get(i));
        }
        this.edges.add(edge1);
        this.edges.add(edge2);
        this.edges.add(edge3);
        this.start = begSommet;
        this.end = endSommet;
    }
 
    public void addStar(Character character) {
        Sommet SommetCenter = new Sommet();
        Sommet Sommetbeg = new Sommet();
        Sommet Sommetend = new Sommet();
        Edge edgeLink = new Edge(SommetCenter, SommetCenter, character.toString());
        Edge edgeEpsilonBeg = new Edge(Sommetbeg, SommetCenter, "epsilon");
        Edge edgeepsilonEnd = new Edge(SommetCenter, Sommetend, "epsilon");
        this.edges.add(edgeLink);
        this.edges.add(edgeEpsilonBeg);
        this.edges.add(edgeepsilonEnd);
        this.start = Sommetbeg;
        this.end = Sommetend;
    }
 
    public void addUnion(Character character, Graph graph) {
        Sommet begSommet = new Sommet();
        Sommet endSommet = new Sommet();
        Edge edge1 = new Edge(begSommet, graph.getStart(), "epsilon");
        Edge edge2 = new Edge(graph.getEnd(), endSommet, "epsilon");
        Edge edge3 = new Edge(begSommet, endSommet, character.toString());
        for (int i = 0; i < graph.getEdges().size(); i++) {
            this.edges.add(graph.getEdges().get(i));
        }
        this.edges.add(edge1);
        this.edges.add(edge2);
        this.edges.add(edge3);
        this.start = begSommet;
        this.end = endSommet;
    }
 
    public void addUnion(Graph graph, Character character) {
        Sommet begSommet = new Sommet();
        Sommet endSommet = new Sommet();
        Edge edge1 = new Edge(begSommet, graph.getStart(), "epsilon");
        Edge edge2 = new Edge(graph.getEnd(), endSommet, "epsilon");
        Edge edge3 = new Edge(begSommet, endSommet, character.toString());
        for (int i = 0; i < graph.getEdges().size(); i++) {
            this.edges.add(graph.getEdges().get(i));
        }
        this.edges.add(edge1);
        this.edges.add(edge2);
        this.edges.add(edge3);
        this.start = begSommet;
        this.end = endSommet;
    }
 
    public void addUnion(Graph graph1, Graph graph2) {
        Sommet begSommet = new Sommet();
        Sommet endSommet = new Sommet();
        Edge edge1 = new Edge(begSommet, graph1.getStart(), "epsilon");
        Edge edge2 = new Edge(begSommet, graph2.getStart(), "epsilon");
        Edge edge3 = new Edge(graph1.getEnd(), endSommet, "epsilon");
        Edge edge4 = new Edge(graph2.getEnd(), endSommet, "epsilon");
        this.start = begSommet;
        this.end = endSommet;
        for (int i = 0; i < graph1.getEdges().size(); i++) {
            this.edges.add(graph1.getEdges().get(i));
        }
        for (int i = 0; i < graph2.getEdges().size(); i++) {
            this.edges.add(graph2.getEdges().get(i));
        }
        this.edges.add(edge1);
        this.edges.add(edge2);
        this.edges.add(edge3);
        this.edges.add(edge4);
    }
 
    public void addUnion(Character characterOne, Character characterTwo) {
        Sommet Sommetbeg = new Sommet();
        Sommet Sommetend = new Sommet();
        Edge edgeOne = new Edge(Sommetbeg, Sommetend, characterOne.toString());
        Edge edgeTwo = new Edge(Sommetbeg, Sommetend, characterTwo.toString());
        edges.add(edgeOne);
        edges.add(edgeTwo);
        start = Sommetbeg;
        end = Sommetend;
    }
 
    public void addConcat(Character character, Graph graph) {
        Sommet begSommet = new Sommet();
        Edge edge = new Edge(begSommet, graph.getStart(), character.toString());
        for (int i = 0; i < graph.getEdges().size(); i++) {
            this.edges.add(graph.getEdges().get(i));
        }
        this.edges.add(edge);
        this.start = begSommet;
        this.end = graph.getEnd();
    }
 
    public void addConcat(Graph graph, Character character) {
        Sommet endSommet = new Sommet();
        Edge edge = new Edge(graph.getEnd(), endSommet, character.toString());
        for (int i = 0; i < graph.getEdges().size(); i++) {
            this.edges.add(graph.getEdges().get(i));
        }
        this.edges.add(edge);
        this.start = graph.getStart();
        this.end = endSommet;
    }
 
    public void addConcat(Graph graph1, Graph graph2) {
        Edge edge = new Edge(graph1.getEnd(), graph2.getStart(), "epsilon");
        this.start = graph1.getStart();
        this.end = graph2.getEnd();
        for (int i = 0; i < graph1.getEdges().size(); i++) {
            this.edges.add(graph1.getEdges().get(i));
        }
        for (int i = 0; i < graph2.getEdges().size(); i++) {
            this.edges.add(graph2.getEdges().get(i));
        }
        this.edges.add(edge);
    }
 
    public void addConcat(Character characterOne, Character characterTwo) {
        Sommet begSommet = new Sommet();
        Sommet midSommet = new Sommet();
        Sommet endSommet = new Sommet();
        Edge edge1 = new Edge(begSommet, midSommet, characterOne.toString());
        Edge edge2 = new Edge(midSommet, endSommet, characterTwo.toString());
        this.start = begSommet;
        this.end = endSommet;
        this.edges.add(edge1);
        this.edges.add(edge2);
    }
 
    @Override
    public String toString() {
        String printString = "Start=" + this.start + "  End=" + this.end + "\n";
        for (int i = 0; i < edges.size(); i++) {
            printString += edges.get(i) + "\n";
        }
        return printString;
    }
}