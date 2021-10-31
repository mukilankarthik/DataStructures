import java.util.*;

public class DepthFirstSearch {


    private final Map<String, List<String>> adj;

    // Constructor
    DepthFirstSearch(int v)
    {
        adj = new HashMap<>(v);
    }

    // Function to add an edge into the graph
    void addEdge(String v, String w)
    {
        List<String> edges;
        if (adj.isEmpty()) {
            edges = new ArrayList<>();
        } else {
            edges = adj.get(v);
            if (null == edges) {
                edges = new ArrayList<>();
            }
        }
        edges.add(w);
        adj.put(v, edges);
    }

    void DFS(String startNode) {
        System.out.println(startNode);
        List<String> stack = new LinkedList<>(adj.get(startNode));

        while (!stack.isEmpty()) {
            String node = stack.get(stack.size() - 1);
            System.out.println(node);
            if (null != adj.get(node)) {
                stack.remove(stack.size() - 1);
                for (String edges : adj.get(node)) {
                    if (!edges.isEmpty()) {
                        stack.add(edges);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(4);

        depthFirstSearch.addEdge("a", "c");
        depthFirstSearch.addEdge("a", "b");
        depthFirstSearch.addEdge("b", "d");
        depthFirstSearch.addEdge("c", "e");
        depthFirstSearch.addEdge("d", "f");
        depthFirstSearch.addEdge("e", "");
        depthFirstSearch.addEdge("f", "");

        System.out.println("Nodes with its edges : "+ depthFirstSearch.adj);

        depthFirstSearch.DFS("a");
    }
}
