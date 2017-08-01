package Graph;

/**
 * Created by Wang on 2017/6/29.
 *
 * TODO: Implementing thoughts: shadowNodes, visiting path
 */

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class sol_133 {
    Set<Integer> visited = new HashSet<Integer>();
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) return node;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for (UndirectedGraphNode i : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(i));
        }
//        cloneNodes(node);

        return cloneNode;
    }

//    void cloneNodes(UndirectedGraphNode node) {
//        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
//        visited.add(node.label);
//        for (UndirectedGraphNode i : node.neighbors) {
//            if (!visited.contains(i.label))
//                cloneNodes(i);
//            newNode.neighbors.add(i);
//        }
//        node.neighbors.add(newNode);
//    }
    void cloneNodes(UndirectedGraphNode node) {
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for (UndirectedGraphNode i : node.neighbors) {
            if (!map.containsKey(i.label)) {
                cloneNodes(i);
            }
            cloneNode.neighbors.add(map.get(i.label));
        }
    }

    void resetNeighbors(UndirectedGraphNode node) {
        visited.add(node.label);
        List<UndirectedGraphNode> newNeighbor = new ArrayList<UndirectedGraphNode>();
        UndirectedGraphNode cloneNode = node.neighbors.get(node.neighbors.size() - 1);
        for (UndirectedGraphNode i : cloneNode.neighbors) {
            if (!visited.contains(i.label))
                resetNeighbors(i);
            newNeighbor.add(i.neighbors.get(i.neighbors.size() - 1));
        }
        cloneNode.neighbors = newNeighbor;
    }

    void cleanup() {}
}
