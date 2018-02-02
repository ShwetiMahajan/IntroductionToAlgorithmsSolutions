package cormenbooksolutions.Ch25;

/**
 * Created by shwetimahajan on 1/28/18.
 */
import java.util.*;

import static java.util.Collections.*;

public class DijkstraAlgo {
    public static class GraphNode {
        int val = 0;
        GraphNode parent = null;
        int dist = 0;
        List<adjacentNode> adjacencyList;
        GraphNode(int x) { val = x;}
    }

    public static class adjacentNode {
        GraphNode node;
        int weight;
        adjacentNode(GraphNode n, int w) {
            node = n;
            weight = w;
        }
    }
    public static void main(String args[]) {
        GraphNode s = new GraphNode(1);
        GraphNode u1 = new GraphNode(2);
        GraphNode u2 = new GraphNode(3);
        GraphNode u3 = new GraphNode(4);
        GraphNode u4 = new GraphNode(5);
        List<adjacentNode> l = new ArrayList<>();
        l.add(new adjacentNode(u1,10));
        l.add(new adjacentNode(u2,5));
        s.adjacencyList = l;
        l = new ArrayList<>();
        l.add(new adjacentNode(u2,2));
        l.add(new adjacentNode(u3,1));
        u1.adjacencyList = l;
        l = new ArrayList<>();
        l.add(new adjacentNode(u1,3));
        l.add(new adjacentNode(u3,9));
        l.add(new adjacentNode(u4,2));
        u2.adjacencyList = l;
        l = new ArrayList();
        l.add(new adjacentNode(u4, 4));
        u3.adjacencyList = l;
        l = new ArrayList<>();
        l.add(new adjacentNode(s, 7));
        l.add(new adjacentNode(u3, 6));
        u4.adjacencyList = l;
        List<GraphNode> V = new ArrayList<>();
        V.add(s);
        V.add(u1);
        V.add(u2);
        V.add(u3);
        V.add(u4);
        findSingleSourceShortestPath(V,s);
        for(GraphNode v : V) {
            System.out.println("Node : "+v.val+" , parent : "+v.parent.val+" , dist. from source(1) : "+v.dist);
        }
    }

    public static void initializeDist(List<GraphNode> V, GraphNode s) {
        for(GraphNode v : V) {
            v.dist = Integer.MAX_VALUE;
        }
        s.dist = 0;
    }

    public static void findSingleSourceShortestPath(List<GraphNode> V, GraphNode s) {
        initializeDist(V, s);
        Comparator<GraphNode> nodeCompare = new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode o1, GraphNode o2) {
                if(o1.dist > o2.dist) return 1;
                else if(o1.dist < o2.dist) return -1;
                else return 0;
            }
        };
        LinkedList<GraphNode> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for(GraphNode v : V) {
            q.add(v);
        }
        q.sort(nodeCompare);
        for(GraphNode v : q) {
            System.out.println(v.dist);
        }
        while(!q.isEmpty()) {
            GraphNode u = q.remove();
            q.sort(nodeCompare);
            System.out.println("Removing : "+u.val+" with dist: "+u.dist);
            set.add(u.val);
            for(adjacentNode v : u.adjacencyList) {
                System.out.println("First : " + v.node.val + " with dist :" + v.weight);
                if(!set.contains(v.node.val)) {
                    System.out.println("Node : "+ v.node.val +" is not in set!");
                    relax(u, v.node, v.weight);
                }
            }
        }
    }

    public static void relax(GraphNode u, GraphNode v, int weight) {
        System.out.println("Relaxation : ");
        System.out.println("Initial distance : "+v.dist);
        if(v.dist > u.dist + weight) {
            v.dist = u.dist + weight;
            v.parent = u;
        }
        System.out.println("New distance : "+v.dist);
    }

}
