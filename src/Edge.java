
public class Edge {
	/**
	 * id of the edgein geldigi node
	 */
	public int to;
	/**
	 * id of the edgein gitti node
	 */
	public int from;
	/**
	 * current flow on the edge
	 */
	public int flow;
	/**
	 * capacity of the edge
	 */
	public int capacity;

	public Edge(int from, int to, int capacity) {
		this.capacity = capacity;
		this.from = from;
		this.to = to;
		
	}
	
	

	
	

}
