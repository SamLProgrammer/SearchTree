package tests;

import models.Node;
import models.Tree;

public class ModelsTests {
	
	public static void main(String[] args) {
		proobTree1();
	}
	
	public static void proobTree1() {
//		Tree tree = new Tree();
//		Node node = new Node(50);
//		Node node1 = new Node(25); // ra�z
//		Node node2 = new Node(75);
//		Node node3 = new Node(11);	
//		Node node4 = new Node(1);
//		Node node5 = new Node(13);
//		Node node6 = new Node(60);
//		Node node7 = new Node(55);
//		Node node8 = new Node(80);
//		Node node9 = new Node(51);
//		Node node10 = new Node(57);
//		Node node11 = new Node(56);
//		Node node12 = new Node(58);
//		tree.addNode(node); // ra�z 
//		tree.addNode(node1); // ra�z 
//		tree.addNode(node2); // ra�z 
//		tree.addNode(node3); // ra�z 
//		tree.addNode(node4); // ra�z 
//		tree.addNode(node5); // ra�z 
//		tree.addNode(node6); // ra�z 
//		tree.addNode(node7); // ra�z 
//		tree.addNode(node8); // ra�z 
//		tree.addNode(node9); // ra�z 
//		tree.addNode(node10); // ra�z 
//		tree.addNode(node11); // ra�z 
//		tree.addNode(node12); // ra�z 
//		System.out.println("************");
//	System.out.println(tree.countTreeLevels(tree.getRootNode(), 0));
		System.out.println(binlog(0));
	}
	
	public static int binlog( int bits ) // returns 0 for bits=0
	{
	    int log = 0;
	    if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
	    if( bits >= 256 ) { bits >>>= 8; log += 8; }
	    if( bits >= 16  ) { bits >>>= 4; log += 4; }
	    if( bits >= 4   ) { bits >>>= 2; log += 2; }
	    return log + ( bits >>> 1 );
	}
}
