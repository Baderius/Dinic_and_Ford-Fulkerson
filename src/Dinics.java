
import java.util.List;

public class Dinics {
	/**
	 * 
	 * @param graph is the list of arraylist of edge objects
	 * @param source is the source node's id
	 * @param sink is the sink node's id
	 * @return the max flow on a graph
	 */
	public static int getMaxFlow(List<Edge>[] graph, int source, int sink) {
	    int maxFlow = 0;
	    int[] distance = new int[graph.length];
	    
	    while (breadthFS(graph, source, sink, distance)) {
	      int[] ptr = new int[graph.length];
	      
	      while (true) {
	        int df = depthFS(graph, sink, source, ptr, distance, Integer.MAX_VALUE);
	        if (df == 0)
	          break;
	        
	        maxFlow += df;
	      }
	    }
	    
	    
	    return maxFlow;
	  }
	
	/**
	 * 
	 * @param FlowNetwork is the list of arraylist of edge objects
	 * @param sink is the sink node's id
	 * @param source is the source node's id
	 * @param ptr 
	 * @param distance
	 * @param flow
	 * @return
	 */
	public static int depthFS(List<Edge>[] FlowNetwork, int sink, int source, int[] ptr, int[] distance, int flow) {
		if (source == sink)
		      return flow;
		for (; ptr[source] < FlowNetwork[source].size(); ptr[source]++) {
			Edge e = FlowNetwork[source].get(ptr[source]);
		    if (distance[e.from] == distance[source] + 1 && e.flow < e.capacity) {
		    	int df = depthFS(FlowNetwork, sink, e.from, ptr, distance, Math.min(flow, e.capacity - e.flow));
		        if (df > 0) {
		        	
		        	e.flow += df;
		        	FlowNetwork[e.from].get(e.to).flow -= df;
		        	
		        	return df;
		        }
		      }
		    }
		return 0;
		  
	}
	
	public static boolean breadthFS(List<Edge>[] FlowNetwork, int source, int sink, int[] distance) {
		for(int i=0; i<distance.length; i++) {
			distance[i] = -1;
		}
		
		int[] tempArr = new int[FlowNetwork.length];
		int sofArr = 0;
		
		tempArr[sofArr++] = source;
		distance[source] = 0;
		
		for (int i = 0; i < sofArr; i++) {
			int u = tempArr[i];
			
			for (Edge e : FlowNetwork[u]) {
				if (distance[e.from] < 0 && e.flow < e.capacity) {
					
					distance[e.from] = distance[u] + 1;
					tempArr[sofArr++] = e.from;
				}
			}
		}
		
		return !(distance[sink] < 0);
	}
	
	
	


}
