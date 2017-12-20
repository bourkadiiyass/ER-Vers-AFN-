
import java.util.Stack;

public class Regex {
    private String regex = "";
    private Stack operatorStack;
    private Stack operandStack;
    private int[][] priority = {
                                    { 1, 1, 1, -1, 1, 1 }, // *&|()#
                                    { -1, 1, 1, -1, 1, 1 },
                                    { -1, -1, 1, -1, 1, 1 },
                                    { -1, -1, -1, -1, 0, 2 },
                                    { 1, 1, 1, 1, 1, 1 },
                                    { -1, -1, -1, -1, -1, -1 } 
        
                                };
 
    public Regex() {
        regex = "";
        operatorStack = new Stack();
        operandStack = new Stack();
    }
 
    public Regex(String _regex) {
        regex = "";
        operatorStack = new Stack();
        operandStack = new Stack();
        prepareString(_regex);
    }
 
    public Graph transformNFA() {
        if (regex.length() == 0)
            return null;
        else {
            int i = 0;
            operatorStack.push('#');
            char[] _regex = (regex + "#").toCharArray();
            while (_regex[i] != '#'
                    || (Character) (operatorStack.peek()) != '#') {
                if (!isOperator(_regex[i])) {
                    operandStack.push((Character)_regex[i]);
                    i++;
                } else {
                    int value=priorityOperator((Character)(operatorStack.peek()), _regex[i]);
                    switch (value) {
                    case 1:
                        Character character=(Character)operatorStack.pop();
                        switch (character) {
                        case '*':
                            Object obj=operandStack.pop();
                            Graph graph1=new Graph();
                            graph1.Star(obj);
                            operandStack.push(graph1);
                            break;
                        case '&':
                            Object obj2=operandStack.pop();
                            Object obj1=operandStack.pop();
                            Graph graph2=new Graph();
                            graph2.Concat(obj1, obj2);
                            operandStack.push(graph2);
                            break;
                        case '|':
                            Object obj4=operandStack.pop();
                            Object obj3=operandStack.pop();
                            Graph graph3=new Graph();
                            graph3.Union(obj3, obj4);
                            operandStack.push(graph3);
                            break;
                        default:
                            break;
                        }
                        break;
                    case 0:
                        operatorStack.pop();
                        i++;
                        break;
                    case -1:
                        operatorStack.push(_regex[i]);
                        i++;
                        break;
                    default:
                        break;
                    }
                }
            }
            return (Graph) operandStack.pop();
        }
    }
     
    public void reset(){
        Sommet.reset();
        operandStack.clear();
        operatorStack.clear();
    }
 
    public String getRegex() {
        return regex;
    }
 
    public void setRegex(String _regex) {
        prepareString(_regex);
    }
 
    private boolean isOperator(Character character) {
        String operatorString = "*&|()#";
        if (operatorString.contains(character.toString())) {
            return true;
        } else {
            return false;
        }
    }
 
    private int priorityOperator(Character character1, Character character2) {
        String priorityString = "*&|()#";
        return this.priority[priorityString.indexOf(character1.toString())][priorityString
                .indexOf(character2.toString())];
    }
 
    private void prepareString(String _regex) {
        char[] regexs = _regex.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < regexs.length; i++) {
            if (i == 0)
                regex += regexs[i];
            else {
                if (regexs[i] == '|' || regexs[i] == '*' || regexs[i] == ')') {
                    regex += regexs[i];
                } else {
                    if (regexs[i - 1] == '(' || regexs[i - 1] == '|')
                        regex += regexs[i];
                    else
                        regex += ("&" + regexs[i]);
                }
            }
        }
    }
 
}
