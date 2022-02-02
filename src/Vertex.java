import java.util.ArrayList;

public class Vertex {
	private int id;
	private String type;
	//Capacity is the nofGifts for the BAGS and literally capacity for VEHICLES!!!!
	private int capacity;
	
	public Vertex(int id) {
		this.id = id;
	}
	
	
	
	public Vertex(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public Vertex(int id, String type, int capacity) {
		this.id = id;
		this.type = type;
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static void idCorrection(int nofBags, ArrayList<Vertex> vertices) {
		for(Vertex v : vertices) {
			v.id += nofBags;
		}
	}

	
	@Override
	public String toString() {
		return "Vertex [id=" + id + ", type=" + type + ", capacity=" + capacity + "]";
	}
	public boolean contA() {
		return type.contains("a");
	}
	public boolean contB() {
		return type.contains("b");
	}
	public boolean contC() {
		return type.contains("c");
	}
	public boolean contD() {
		return type.contains("d");
	}
	public boolean contE() {
		return type.contains("e");
	}
	public boolean contBD() {
		return type.contains("bd");
	}
	public boolean contBE() {
		return type.contains("be");
	}
	public boolean contCD() {
		return type.contains("cd");
	}
	public boolean contCE() {
		return type.contains("ce");
	}
	
	
	
	public boolean isG() {
		return type.contains("G");
	}
	public boolean isR() {
		return type.contains("R");
	}
	public boolean isT() {
		return type.contains("T");
	}
	public boolean isD() {
		return type.contains("D");
	}
	public boolean isGT() {
		return type.contains("GT");
	}
	public boolean isRT() {
		return type.contains("RT");
	}
	public boolean isGD() {
		return type.contains("GD");
	}
	public boolean isRD() {
		return type.contains("RD");
	}

}
