package cormenbooksolutions.Ch23;

/**
 * Created by shwetimahajan on 1/25/18.
 */
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    static class GraphNode {
        int val;
        int dist = Integer.MAX_VALUE;
        GraphNode parent = null;
        int color = 0;
        GraphNode(int x ) { val = x;}
        ArrayList<GraphNode> adjacencyList;
    }
    public static void main(String args[]) {
        GraphNode root = new GraphNode(1);
        ArrayList<GraphNode> al = new ArrayList<>();
        GraphNode n = new GraphNode(2);
        al.add(n);
        GraphNode n1 = new GraphNode(3);
        al.add(n1);
        GraphNode n2 = new GraphNode(6);
        al.add(n2);
        root.adjacencyList = al;
        n.adjacencyList = new ArrayList<>();
        n.adjacencyList.add(n1);
        n.adjacencyList.add(new GraphNode(4));
        n1.adjacencyList = new ArrayList<>();
        n1.adjacencyList.add(n);
        n = new GraphNode(5);
        n1.adjacencyList.add(n);
        n.adjacencyList = new ArrayList<>();
        n.adjacencyList.add(n2);
        n1 = new GraphNode(7);
        n.adjacencyList.add(n1);
        n1.adjacencyList = new ArrayList<>();
        n1.adjacencyList.add(n);
        n1.adjacencyList.add(n2);
        visitNodes(root);
    }

    public static void visitNodes(GraphNode root) {
        root.color = 1; //value 1 stands for gray
        root.dist = 0;
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            GraphNode node = queue.removeFirst();

            if(node.adjacencyList != null && node.adjacencyList.size() > 0) {
                for(GraphNode n : node.adjacencyList) {
                    if(n.color == 0) {
                        n.color = 1;
                        n.parent = node;
                        n.dist = node.dist + 1;
                        queue.add(n);
                    }
                }
            }

            node.color = 2; // Value 2 represents black color.
        }
    }

}
