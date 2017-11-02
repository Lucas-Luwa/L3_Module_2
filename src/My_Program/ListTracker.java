package My_Program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListTracker implements ActionListener {
	ArrayList<String> Task = new ArrayList<String>();
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	String file;
	String killfile;
	String Total;

	public static void main(String[] args) {
		ListTracker LT = new ListTracker();
		LT.Create();
	}

	void Create() {
		f.add(p);
		f.setVisible(true);
		f.setSize(200, 130);
		p.add(b);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		b.setText("Add Task");
		b2.setText("Remove Task");
		b3.setText("Save");
		b4.setText("Load");
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(b)) {
			file = JOptionPane.showInputDialog("Add a task.");
			Task.add(file);
		}
		if (e.getSource().equals(b2)) {
			killfile = JOptionPane.showInputDialog("Remove a task by giving a number.");
			int y = Integer.parseInt(killfile);
			Task.remove(y);
		}
		if (e.getSource().equals(b3)) {
			for (int i = 0; i < Task.size(); i++) {
				Total += Task.get(i);

			}
			try {
				FileWriter fw = new FileWriter("src/My_Program/test4.txt");
				fw.write(Total);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
