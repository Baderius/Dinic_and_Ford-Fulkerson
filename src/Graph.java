import java.util.ArrayList;

public class Graph {
	/**
	 * edges represented in an adjacency matrix
	 */
	private int[][] vertices;
	/**
	 * nof vertices on the graph
	 */
	private int nofVertices;
	
	public Graph(int nofVertices) {
		vertices = new int[nofVertices][nofVertices];
		this.nofVertices = nofVertices;
	}
	public void addEdge(int from, int to, int capacity) {
		vertices[from][to] = capacity;
	}

	public int getNofVertices() {
		return nofVertices;
	}
	
	public int[][] getVertices(){
		return vertices;
	}
	
	/**
	 * forms the graph given two arrays of vertices. Leftbp baglerin oldugu list, digeri de vehiclealrin oldugu list hocam iste anlayin
	 */
	public void formGraph(ArrayList<Vertex> leftBP, ArrayList<Vertex> rightBP) {
		for(int i=0; i<leftBP.size(); i++) {
			this.addEdge(0, leftBP.get(i).getId(), leftBP.get(i).getCapacity());
		}
		for(int i=0; i<rightBP.size(); i++) {
			this.addEdge(rightBP.get(i).getId(), this.getNofVertices() -1 , rightBP.get(i).getCapacity());
		}
		
		for(Vertex v : leftBP) {
			if(v.contA()) {
				if(v.contBD()) {		//abd
					for(Vertex vehicle : rightBP) {
						if(vehicle.isGT()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
							
						}
					}
					
				}else if(v.contBE()) {  //abe
					for(Vertex vehicle : rightBP) {
						if(vehicle.isGD()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contCD()) {  //acd
					for(Vertex vehicle : rightBP) {
						if(vehicle.isRT()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contCE()) {  //ace
					for(Vertex vehicle : rightBP) {
						if(vehicle.isRD()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contB()) {  	//ab
					for(Vertex vehicle : rightBP) {
						if(vehicle.isG()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contC()) {  	//ac
					for(Vertex vehicle : rightBP) {
						if(vehicle.isR()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contD()) {  	//ad
					for(Vertex vehicle : rightBP) {
						if(vehicle.isT()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else if(v.contE()) {  	//ae
					for(Vertex vehicle : rightBP) {
						if(vehicle.isD()) {
							this.addEdge(v.getId(), vehicle.getId(), 1);
						}
					}
				}else {                 //a
					for(Vertex vehicle : rightBP) {
						this.addEdge(v.getId(), vehicle.getId(), 1);
					}
				}
				
			}else if(!v.contA()) {
				if(v.contBD()) {        //bd
					for(Vertex vehicle : rightBP) {
						if(vehicle.isGT()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
					
				}else if(v.contBE()) {  //be
					for(Vertex vehicle : rightBP) {
						if(vehicle.isGD()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}else if(v.contCD()) {  //cd
					for(Vertex vehicle : rightBP) {
						if(vehicle.isRT()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}else if(v.contCE()) {  //ce
					for(Vertex vehicle : rightBP) {
						if(vehicle.isRD()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}else if(v.contB()) {   //b
					for(Vertex vehicle : rightBP) {
						if(vehicle.isG()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}else if(v.contC()) {   //c
					for(Vertex vehicle : rightBP) {
						if(vehicle.isR()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}else if(v.contD()) {   //d
					for(Vertex vehicle : rightBP) {
						if(vehicle.isT()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
							
						}
					}
				}else if(v.contE()) {   //e
					for(Vertex vehicle : rightBP) {
						if(vehicle.isD()) {
							this.addEdge(v.getId(), vehicle.getId(), v.getCapacity());
						}
					}
				}
				
			}
		}
	}

}
