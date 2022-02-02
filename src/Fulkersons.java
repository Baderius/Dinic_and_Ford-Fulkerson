import java.util.LinkedList;

public class Fulkersons {
	/**
	 * 
	 * @param graph is a graph object which contains a 2D array that represents the edges between the nodes
	 * @param source the id of the source node
	 * @param sink the id of the sink node
	 * @return the max flow
	 */
	public static int getMaxFlow(Graph graph, int source, int sink){
               int residualG[][] = new int[graph.getNofVertices()][graph.getNofVertices()];
 
        for (int u = 0; u < graph.getNofVertices(); u++)
            for (int v = 0; v < graph.getNofVertices(); v++)
            	residualG[u][v] = graph.getVertices()[u][v];
 
        int parent[] = new int[graph.getNofVertices()];
 
        int maxFlow = 0; 
 
        while (breadthFS(residualG, parent, source, sink)) {
            int currFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                currFlow = Math.min(currFlow, residualG[u][v]);
            }
 
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualG[u][v] -= currFlow;
                residualG[v][u] += currFlow;
            }
 
            maxFlow += currFlow;
        }
        return maxFlow;
    }

	/**
	 * 
	 * @param residualG residual graph in the fulkerson's algorithm
	 * @param parents the array of the paretns of each node
	 * @param source 
	 * @param sink
	 * @return true if the sink node is reached otherwise false
	 */
    private static boolean breadthFS(int residualG[][], int[] parents, int source, int sink){
    	boolean isVisited[] = new boolean[residualG.length];
    	
    	for (int i = 0; i < residualG.length; ++i)
    		isVisited[i] = false;
    	
    	LinkedList<Integer> myQueue = new LinkedList<Integer>();
    	parents[source] = -1;
    	isVisited[source] = true;
    	myQueue.add(source);
    	
    	while (!myQueue.isEmpty()) {
    		int u = myQueue.poll();
    		
    		for (int i = 0; i < residualG.length; i++) {
    			if (isVisited[i] == false && residualG[u][i] > 0) {
    				
    				if (i == sink) {
    					parents[i] = u;
    					return true;
    				}
    				myQueue.add(i);
    				parents[i] = u;
    				isVisited[i] = true;
    			}
    		}
    	}
    	return false;
    }
}
