package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.peer.LightweightPeer;
//import javax.swing.SwingWorker;
import models.Tree;
import views.MainFrame;
import views.MyDialog;
import views.MyDialog2;

public class Controller implements ActionListener {

	MainFrame mf;
	Tree tree;
	MyDialog myDialog;
	MyDialog2 myDialog2;

	public Controller() {
		tree = new Tree();
		mf = new MainFrame(tree, this);
		myDialog = new MyDialog(this);
		myDialog2 = new MyDialog2(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case Init_Button:
			break;
		case ADD_BUTTON:
			showAddDialog();
			break;
		case DELETE_BUTTON:
			showDeleteDialog();
			break;
		case OK_ADD_BUTTON:
			addNode();
			myDialog.setVisible(false);
			break;
		case OK_DELETE_BUTTON:
			deleteNode();
			myDialog2.setVisible(false);
			break;
		case LIGHT_BUTTON:
//			SwingWorker hilo = new SwingWorker<Void, Void>() {
//				@Override
//				protected Void doInBackground() throws Exception {
//					for (int i = 1; i < 9; i++) {						
//						lightTree(i);
//						Thread.sleep(500);
//					}
//					return null;
//				}
//			};
//			hilo.execute();
			break;
		}
	}

	private void addNode() {
		tree.addNode(tree.createNode(Integer.valueOf(myDialog.getDataField().getText())));
		mf.updateTreePanel(tree);
	}

	private void deleteNode() {
		tree.deleteNodeByData(Integer.valueOf(myDialog2.getDataField().getText()));
		mf.updateTreePanel(tree);
	}

	private void showDeleteDialog() {
		myDialog2.setVisible(true);
	}

	private void showAddDialog() {
		myDialog.setVisible(true);
	}

	public void lightTree(int i) {
		tree.lightTree(i);
		mf.lightUpTreePanel();
	}
}
