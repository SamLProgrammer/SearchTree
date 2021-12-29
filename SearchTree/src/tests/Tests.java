package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Node;
import models.Tree;

class Tests {

	@Test
	void test() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		tree.addNode(node1);
		tree.addNode(node);
		assertEquals(tree.getRootNode(), node1);
		assertEquals(tree.getRootNode().getLeftNode(), node);
		assertEquals(tree.getRootNode().getRightNode(), null);
		}
	
	@Test
	void test1() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node3 = new Node(10);		
		tree.addNode(node1);
		tree.addNode(node);
		tree.addNode(node3);
		assertEquals(tree.getRootNode(), node1);
		assertEquals(tree.getRootNode().getLeftNode(), node);
		assertEquals(tree.getRootNode().getRightNode(), node3);
		assertEquals(tree.getRootNode().getRightNode().getLeftNode(), null);
		assertEquals(tree.getRootNode().getLeftNode().getLeftNode(), null);
	}
	
	@Test
	void test2() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node3 = new Node(10);	
		Node node4 = new Node(1);	
		tree.addNode(node1);
		tree.addNode(node);
		tree.addNode(node3);
		tree.addNode(node4);
		assertEquals(tree.getRootNode(), node1);
		assertEquals(tree.getRootNode().getLeftNode().getLeftNode(), node4);		
		assertEquals(tree.getRootNode().getLeftNode().getRightNode(), null);		
	}
	
	@Test
	void test3() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(10);	
		Node node4 = new Node(1);	
		tree.addNode(node1);
		tree.addNode(node);
		tree.addNode(node3);
		tree.addNode(node4);
		tree.addNode(node2);
		assertEquals(tree.getRootNode(), node1);
		assertEquals(tree.getRootNode().getLeftNode().getLeftNode(), node4);		
		assertEquals(tree.getRootNode().getLeftNode().getRightNode(), null);		
		assertEquals(tree.getRootNode().getRightNode().getRightNode(), null);		
		assertEquals(tree.getRootNode().getRightNode().getLeftNode(), node2);		
	}
	
	@Test
	void test4() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(10);	
		Node node4 = new Node(1);
		Node node0 = new Node(4);
		tree.addNode(node1);
		tree.addNode(node);
		tree.addNode(node3);
		tree.addNode(node4);
		tree.addNode(node2);
		tree.addNode(node0);
		assertEquals(tree.getRootNode().getLeftNode().getData(), 3);
		assertEquals(tree.getRootNode().getRightNode().getData(), 10);
		assertEquals(tree.getRootNode().getLeftNode().getRightNode().getData(), 4);
		assertEquals(tree.getRootNode().getLeftNode().getLeftNode().getData(), 1);
		assertEquals(tree.getRootNode().getRightNode().getLeftNode().getData(), 7);
		assertEquals(tree.getRootNode().getRightNode().getRightNode(), null);
	}
	
	@Test
	void test5() {
		Tree tree = new Tree();
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(10);	
		Node node4 = new Node(1);
		Node node0 = new Node(4);
		tree.addNode(node1);
		tree.addNode(node);
		tree.addNode(node3);
		tree.addNode(node4);
		tree.addNode(node2);
		tree.addNode(node0);
//		System.out.println(tree.belowFindNode(tree.getRootNode(), node0).getData());
//		assertEquals(null, tree.getRootNode().getLeftNode().getLeftNode());
	}

}
