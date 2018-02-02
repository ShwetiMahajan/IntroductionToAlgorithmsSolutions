package cormenbooksolutions.Ch23;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetimahajan on 1/26/18.
 */
public class DFS {
    static int t = 0;
    static class GraphNode {
        int val;
        int dist = Integer.MAX_VALUE;
        GraphNode parent = null;
        int color = 0;
        int start = 0;
        int end = 0;
        GraphNode(int x ) { val = x;}
        ArrayList<GraphNode> adjacencyList;
    }

    public static void main(String args[]) {}

    public static void DFSTraversal(List<GraphNode> V) {
        for(GraphNode u : V) {
            if(u.color == 0) {
                DFSVisit(u);
            }
        }
    }

    public static void DFSVisit(GraphNode u) {
        u.color = 1;
        u.start = t+1;
        for(GraphNode v : u.adjacencyList) {
            if(v.color == 0) {
                v.parent = u;
                v.dist = u.dist +1;
                DFSVisit(v);
            }
        }
        u.color = 2;
        u.end = t+1;
    }
}
