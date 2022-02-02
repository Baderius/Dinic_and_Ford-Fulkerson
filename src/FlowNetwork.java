import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
	private int nofVertices;
	private List<Edge>[] edges;
	
	@SuppressWarnings("unchecked")
	public FlowNetwork(int nofVertices) {
		edges = new List[nofVertices];
		for(int i=0; i<nofVertices; i++) {
			edges[i] = new ArrayList<>();
		}
		this.nofVertices = nofVertices;
	}
	
	
	
	public void formNetwork(ArrayList<Vertex> leftBP, ArrayList<Vertex> rightBP) {
			for(Vertex v : leftBP) {
				
				this.addEdge(0, v.getId(), v.getCapacity());
			}
			for(Vertex v : rightBP) {
				
				this.addEdge(v.getId(), this.getNofVertices() - 1, v.getCapacity());
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
	public void addEdge(int from, int to, int capacity) {
		edges[from].add(new Edge(to, edges[to].size(), capacity));
		edges[to].add(new Edge(from, edges[from].size()-1, capacity));
		
		
	}
		
	
	public int getNofVertices() {
		return this.nofVertices;
	}
	public List<Edge>[] getEdges(){
		return this.edges;
	}
	

}
