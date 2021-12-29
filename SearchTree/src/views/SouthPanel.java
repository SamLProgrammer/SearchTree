package views;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Actions;

public class SouthPanel extends JPanel{

	JButton addbtn, deletebtn, lightTreeButton;
	
	public SouthPanel(ActionListener listener) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		addbtn = new JButton("ADD NODE");
		addbtn.addActionListener(listener);
		addbtn.setActionCommand(Actions.ADD_BUTTON.name());
		deletebtn = new JButton("DELETE NODE");
		deletebtn.addActionListener(listener);
		deletebtn.setActionCommand(Actions.DELETE_BUTTON.name());
		lightTreeButton = new JButton("LIGHT TREE");
		lightTreeButton.addActionListener(listener);
		lightTreeButton.setActionCommand(Actions.LIGHT_BUTTON.name());
		add(addbtn);
		add(deletebtn);
		add(lightTreeButton);
	}
	
}
