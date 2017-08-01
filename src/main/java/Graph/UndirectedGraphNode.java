package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2017/6/29.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
