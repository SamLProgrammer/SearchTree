package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import models.Tree;

public class MainFrame extends JFrame{

	private TreePanel treePanel;
	private SouthPanel southPanel;
	
	public MainFrame(Tree tree, ActionListener listener) {
		initComponents(tree, listener);
		locate();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void locate() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(dimension.getWidth()/2 - this.getWidth()/2), (int)(dimension.getHeight()/2 - this.getHeight()/2));
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	private void initComponents(Tree tree,ActionListener listener) {
		treePanel = new TreePanel(tree);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(treePanel);
		scrollPanel.setPreferredSize(treePanel.getPreferredSize());
		southPanel = new SouthPanel(listener);
		add(scrollPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public void updateTreePanel(Tree tree) {
		treePanel.updateTreePanel(tree);
	}
	
	public void lightUpTreePanel() {
		treePanel.lightTreePanel();
	}
	
//	public void lightOffTreePanel() {
//		treePanel.lightOff();
//	}
	
}
