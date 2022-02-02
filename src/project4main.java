import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class project4main {

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File(args[0]);
		File out = new File(args[1]);
		
		
		Scanner scanner = new Scanner(in);
		PrintStream printStream = new PrintStream(out);
		
		ArrayList<Vertex> rightBP = new ArrayList<Vertex>();
		ArrayList<Vertex> leftBP = new ArrayList<Vertex>();
		
		int nofGT = scanner.nextInt();
		
		
		for(int i=0; i<nofGT; i++) {
			rightBP.add(new Vertex(i+1, "GT", scanner.nextInt()));
		}
		
		int nofRT = scanner.nextInt();
		
		for(int i=0; i<nofRT; i++) {
			rightBP.add(new Vertex(nofGT + i + 1, "RT", scanner.nextInt()));
		}
		
		int nofGD = scanner.nextInt();
		
		for(int i=0; i<nofGD; i++) {
			rightBP.add(new Vertex(nofGT+nofRT+i+1, "GD", scanner.nextInt()));
		}
		
		int nofRD = scanner.nextInt();
		
		for(int i=0; i<nofRD; i++) {
			rightBP.add(new Vertex(nofGT+nofRT+nofGD+i+1, "RD", scanner.nextInt()));
		}
		
		int nofBags = scanner.nextInt();
		
		//IDCORRECTION
		Vertex.idCorrection(nofBags, rightBP);
		//////////////
		
		int totalGifts = 0;
		
		for(int i=0; i<nofBags; i++) { //FOR BAGS
			String type = scanner.next();
			int cap = scanner.nextInt();
			leftBP.add(new Vertex(i+1, type, cap));
			totalGifts += cap;
		}
		
		
		//UP TO THIS POINT WE CREATED VERTICES AND ADDED THEM INTO OUR ARRAYLISTS, NOW WE CREATE EDGES AND FORM THE FLOW NETWORK
		
		FlowNetwork santaDinic = new FlowNetwork(leftBP.size() + rightBP.size() + 2);//Total nof vertices is equal to that num, source and sink included
		Graph santaFulkerson = new Graph(leftBP.size() + rightBP.size() + 2);
		
		Vertex source = new Vertex(0);
		Vertex sink   = new Vertex(leftBP.size() + rightBP.size() + 1);
		
		
		if(santaFulkerson.getNofVertices() <= 1500) {
			santaFulkerson.formGraph(leftBP, rightBP);
			printStream.println(totalGifts - Fulkersons.getMaxFlow(santaFulkerson, source.getId(), sink.getId()));
			
		}else if(santaDinic.getNofVertices() >1500) {
			santaDinic.formNetwork(leftBP, rightBP);
			printStream.println(totalGifts - Dinics.getMaxFlow(santaDinic.getEdges(), source.getId(), sink.getId()));
		}
		
		scanner.close();
		printStream.close();
		
		}

}
