package models;

import java.util.ArrayList;

public class Tree {

	private Node rootNode;

	public Tree() {
		initTree();
	}

	private void initTree() {
		generateNodes(20);
		showTree();
	}

	// ================================== UPPER METHODS
	// =================================

	public void showTree() {
		belowShowTree(rootNode);
	}

	public Node createNode(int data) {
		return new Node(data);
	}

	public void addNode(Node node) {
		belowAddNode(rootNode, node);
		balanceTreeAfterAdding();
	}

	public Node findNode(Node node) {
		return belowFindNode(rootNode, node);
	}

	public Node findNodeByData(int data) {
		return belowFindNodeByData(rootNode, data);
	}

	public void deleteNodeByData(int data) {
		deleteNode(belowFindNodeByData(rootNode, data));
//		balanceTreeAfterAdding();
	}

	public void deleteNode(Node node) {
		if (node != null) {
			belowDeleteNode2(findNode(node));
		}
	}

	public Node findFatherNode(Node node) {
		Node auxNode = new Node();
		if (node == rootNode) {
			auxNode = rootNode;
		} else {
			auxNode = belowFindFatherNode(rootNode, node);
		}

		return auxNode;
	}

	public void lightTree(int i) {
		inOrderLightTree(rootNode, i);
	}

	public void balanceTreeAfterAdding() {
		balanceTreeAfterAdding(rootNode);
	}

//	public void balanceFullTree() {
//		balanceFullTree(rootNode);
//	}

	public int countLevels() {
		int levels = 0;
		if (rootNode != null) {
			levels = countTreeLevels(rootNode, 1);
		}
		return levels;
	}

	// =============================== BELLOW ESSENTIAL METHODS
	// =============================

	public Node belowFindNode(Node fatherNode, Node node) { // probado, full
		if (fatherNode.equals(node)) {
			return fatherNode;
		} else {
			if (fatherNode.getLeftNode() != null && belowFindNode(fatherNode.getLeftNode(), node) != null) {
				return belowFindNode(fatherNode.getLeftNode(), node);
			}
			if (fatherNode.getRightNode() != null && belowFindNode(fatherNode.getRightNode(), node) != null) {
				return belowFindNode(fatherNode.getRightNode(), node);
			} else {
				return null;
			}
		}
	}

	public Node belowFindNodeByData(Node node, int data) { // probado, full
		Node auxNode = null;
		if (node != null) {
			if (node.getData() == data) {
				auxNode = node;
			} else {
				if (node.getData() > data) {
					auxNode = belowFindNodeByData(node.getLeftNode(), data);
				} else {
					auxNode = belowFindNodeByData(node.getRightNode(), data);
				}
			}
		}
		return auxNode;
	}

	public Node belowFindFatherNode(Node fatherNode, Node node) { // probado, full
		if (!fatherNode.isLeave() && sonEqualsToNode(fatherNode, node) != null) {
			return fatherNode;
		} else {
			if (fatherNode.getLeftNode() != null && belowFindFatherNode(fatherNode.getLeftNode(), node) != null) {
				return belowFindFatherNode(fatherNode.getLeftNode(), node);
			}
			if (fatherNode.getRightNode() != null && belowFindFatherNode(fatherNode.getRightNode(), node) != null) {
				return belowFindFatherNode(fatherNode.getRightNode(), node);
			} else {
				return null;
			}
		}
	}

	public void belowAddNode(Node fatherNode, Node node) { // probado, full
		if (fatherNode == null) {
			rootNode = node;
		} else {
			if (node.getData() > fatherNode.getData()) {
				if (fatherNode.getRightNode() == null) {
					fatherNode.setRightNode(node);
				} else {
					belowAddNode(fatherNode.getRightNode(), node);
				}
			} else {
				if (fatherNode.getLeftNode() == null) {
					fatherNode.setLeftNode(node);
				} else {
					belowAddNode(fatherNode.getLeftNode(), node);
				}
			}
		}
	}

//	public void belowDeleteNode2(Node node, int aja) { // probado funciona
//		if (node.isLeave()) {
//			if (node == rootNode) {
//				rootNode = null;
//			} else {
//				Node father = findFatherNode(node);
//				if (sonEqualsToNode(father, node).equals(father.getLeftNode())) {
//					father.setLeftNode(null);
//				} else {
//					father.setRightNode(null);
//				}
//			}
//		} else if (node.getLeftNode() == null || node.getRightNode() == null) {
//			if (node.getLeftNode() == null) {
//				if (node.equals(rootNode)) {
//					rootNode = node.getRightNode();
//				} else {
//					Node father = findFatherNode(node);
//					if (father.getLeftNode() != null && father.getLeftNode().equals(node)) {
//						father.setLeftNode(node.getRightNode());
//					} else {
//						father.setRightNode(node.getRightNode());
//					}
//				}
//			} else {
//				if (node.equals(rootNode)) {
//					rootNode = node.getLeftNode();
//				} else {
//					Node father = findFatherNode(node);
//					if (father.getLeftNode() != null && father.getLeftNode().equals(node)) {
//						father.setLeftNode(node.getLeftNode());
//					} else {
//						father.setRightNode(node.getLeftNode());
//					}
//				}
//			}
//		} else {
//			node.setData(leftestNode(node.getRightNode()).getData());
//			belowDeleteNode2(leftestNode(node.getRightNode()), 1);
//		}
//	}
	public void belowDeleteNode2(Node node) { // probado funciona
		if (node.isLeave()) {
			if (node == rootNode) {
				rootNode = null;
			} else {
				Node father = findFatherNode(node);
				if (node.equals(father.getLeftNode())) {
					father.setLeftNode(null);
				} else {
					father.setRightNode(null);
				}
			}
		} else if (node.getLeftNode() == null || node.getRightNode() == null) {
			if (node.getLeftNode() == null) {
				if (node.equals(rootNode)) {
					rootNode = node.getRightNode();
				} else {
					Node father = findFatherNode(node);
					if (father.getLeftNode() != null && father.getLeftNode().equals(node)) {
						father.setLeftNode(node.getRightNode());
					} else {
						father.setRightNode(node.getRightNode());
					}
				}
			} else {
				if (node.equals(rootNode)) {
					rootNode = node.getLeftNode();
				} else {
					Node father = findFatherNode(node);
					if (father.getLeftNode() != null && father.getLeftNode().equals(node)) {
						father.setLeftNode(node.getLeftNode());
					} else {
						father.setRightNode(node.getLeftNode());
					}
				}
			}
		} else {
			node.setData(leftestNode(node.getRightNode()).getData());
			belowDeleteNode2(leftestNode(node.getRightNode()));
		}
	}

	// ================================= BALANCING METHODS
	// =================================

	public void balanceTreeAfterAdding(Node node) {
		if (node != null) {
			balanceTreeAfterAdding(node.getLeftNode());
			balanceTreeAfterAdding(node.getRightNode());
			if (balanceFactor(node) <= -2) {
				leftBalanceSubTreeAfterAdding(node);
			}
			if (balanceFactor(node) >= 2) {
				rightBalanceSubTreeAfterAdding(node);
			}
		}
	}

	public void rightBalanceSubTreeAfterAdding(Node node) {
		if (rootNode != node) {
			if (balanceFactor(node.getLeftNode()) == -1 || balanceFactor(node.getLeftNode()) == 0) {
				Node fatherNode = findFatherNode(node);
				Node auxNode = node.getLeftNode().getRightNode();
				Node auxNode2 = node.getLeftNode();
				node.getLeftNode().setRightNode(auxNode.getLeftNode());
				node.setLeftNode(auxNode.getRightNode());
				auxNode.setRightNode(node);
				auxNode.setLeftNode(auxNode2);
				if (fatherNode.getRightNode() == node) {
					fatherNode.setRightNode(auxNode);
				} else {
					fatherNode.setLeftNode(auxNode);
				}
				balanceTreeAfterAdding(auxNode);
			} else {
				Node fatherNode = findFatherNode(node);
				Node auxNode = node.getLeftNode();
				node.setLeftNode(auxNode.getRightNode());
				auxNode.setRightNode(node);
				if (fatherNode.getRightNode() == node) {
					fatherNode.setRightNode(auxNode);
				} else {
					fatherNode.setLeftNode(auxNode);
				}
				balanceTreeAfterAdding(auxNode);
			}
		} else {
			if (balanceFactor(node.getLeftNode()) == -1 || balanceFactor(node.getLeftNode()) == 0) {
				Node auxNode = node.getLeftNode().getRightNode();
				Node auxNode2 = node.getLeftNode();
				node.getLeftNode().setRightNode(auxNode.getLeftNode());
				node.setLeftNode(auxNode.getRightNode());
				auxNode.setRightNode(node);
				auxNode.setLeftNode(auxNode2);
				rootNode = auxNode;
				balanceTreeAfterAdding(auxNode);
			} else {
				Node auxNode = node.getLeftNode();
				node.setLeftNode(auxNode.getRightNode());
				auxNode.setRightNode(node);
				rootNode = auxNode;
				balanceTreeAfterAdding(auxNode);
			}
		}
	}

	public void leftBalanceSubTreeAfterAdding(Node node) {
		if (rootNode != node) {
			if (balanceFactor(node.getRightNode()) == 1 || balanceFactor(node.getRightNode()) == 0) {
				Node fatherNode = findFatherNode(node);
				Node auxNode = node.getRightNode().getLeftNode();
				Node auxNode2 = node.getRightNode();
				node.getRightNode().setLeftNode(auxNode.getRightNode());
				node.setRightNode(auxNode.getLeftNode());
				auxNode.setLeftNode(node);
				auxNode.setRightNode(auxNode2);
				if (fatherNode.getRightNode() == node) {
					fatherNode.setRightNode(auxNode);
				} else {
					fatherNode.setLeftNode(auxNode);
				}
				balanceTreeAfterAdding(auxNode);
			} else {
				Node fatherNode = findFatherNode(node);
				Node auxNode = node.getRightNode();
				node.setRightNode(auxNode.getLeftNode());
				auxNode.setLeftNode(node);
				if (fatherNode.getRightNode() == node) {
					fatherNode.setRightNode(auxNode);
				} else {
					fatherNode.setLeftNode(auxNode);
				}
				balanceTreeAfterAdding(auxNode);
			}
		} else {
			if (balanceFactor(node.getRightNode()) == 1 || balanceFactor(node.getRightNode()) == 0) {
				Node auxNode = node.getRightNode().getLeftNode();
				Node auxNode2 = node.getRightNode();
				node.getRightNode().setLeftNode(auxNode.getRightNode());
				node.setRightNode(auxNode.getLeftNode());
				auxNode.setLeftNode(node);
				auxNode.setRightNode(auxNode2);
				rootNode = auxNode;
				balanceTreeAfterAdding(auxNode);
			} else {
				Node auxNode = node.getRightNode();
				node.setRightNode(auxNode.getLeftNode());
				auxNode.setLeftNode(node);
				rootNode = auxNode;
				balanceTreeAfterAdding(auxNode);
			}
		}
	}

	// ================================== UTILITY METHODS
	// ===================================

	public int countTreeLevels(Node node, int counter) {
		int levels = counter;
		int auxLevel;
		if (!node.isLeave()) {
			if (node.getLeftNode() != null) {
				levels = countTreeLevels(node.getLeftNode(), counter + 1);
			}
			if (node.getRightNode() != null
					&& (auxLevel = countTreeLevels(node.getRightNode(), counter + 1)) > levels) {
				levels = auxLevel;
			}
		}
		return levels;
	}

	public int balanceFactor(Node node) {
		int left = 0, right = 0;
		if (!node.isLeave()) {
			if (node.getLeftNode() != null) {
				left = countTreeLevels(node.getLeftNode(), 1);
			}
			if (node.getRightNode() != null) {
				right = countTreeLevels(node.getRightNode(), 1);
			}
		}
		return left - right;
	}

	public Node sonEqualsToNode(Node fatherNode, Node node) {
		Node auxNode = new Node();
		if (fatherNode.getLeftNode() != null && fatherNode.getLeftNode().equals(node)) {
			auxNode = fatherNode.getLeftNode();
		} else if (fatherNode.getRightNode() != null && fatherNode.getRightNode().equals(node)) {
			auxNode = fatherNode.getRightNode();
		} else {
			auxNode = null;
		}
		return auxNode;
	}

	public Node leftestNode(Node node) {
		if (node.getLeftNode() == null) {
			return node;
		} else {
			return leftestNode(node.getLeftNode());
		}
	}
	
	public Node rightestNode(Node node) {
		if(node.getRightNode() == null) {
			return node;
		} else {
			return leftestNode(node.getRightNode());
		}
	}

	public void belowShowTree(Node node) {
		if (node != null) {
			belowShowTree(node.getLeftNode());
			System.out.println(node.getData());
			belowShowTree(node.getRightNode());
		}
	}

	public void inOrderLightTree(Node node, int i) {
		if (node != null && i < 0) {
			inOrderLightTree(node.getLeftNode(), i - 1);
			node.setPainted(true);
			inOrderLightTree(node.getRightNode(), i - 1);
		}
	}

	public void generateNodes(int amount) {
		ArrayList<Node> nodesList = new ArrayList<Node>();
		for (int i = 0; i < amount; i++) {
			int data = 1;
			do {
				data = 1 + ((int) (Math.random() * amount));
			} while (nodeExists(nodesList, data));
			nodesList.add(createNode(data));
		}
		for (Node node : nodesList) {
			addNode(node);
		}
	}

	public boolean balancingTest() {
		boolean flag = false;
		if (isTreeBalanced(rootNode) == 0 && countNodes(rootNode) == 20) {
			flag = true;
		}
		return flag;
	}

	public int isTreeBalanced(Node node) {
		if (node == null) {
			return 0;
		}
		if (balanceFactor(node) > 1 || balanceFactor(node) < -1) {
			return 1;
		} else {
			return isTreeBalanced(node.getLeftNode()) + isTreeBalanced(node.getRightNode());
		}
	}

	public int countNodes(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.isLeave()) {
			return 1;
		} else {
			return countNodes(node.getRightNode()) + countNodes(node.getLeftNode()) + 1;
		}
	}

	public boolean nodeExists(ArrayList<Node> list, int data) {
		boolean flag = false;
		for (Node node : list) {
			if (node.getData() == data) {
				flag = true;
			}
		}
		return flag;
	}

	// ================================== GETTERS && SETTERS
	// ================================

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

}
