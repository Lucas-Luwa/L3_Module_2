package My_Program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	String file;
	String killfile;

	public static void main(String[] args) {
		ListTracker LT = new ListTracker();
		LT.Create();
	}

	void Create() {
		f.add(p);
		f.setVisible(true);
		f.setSize(200, 130);
		p.add(add);
		p.add(remove);
		p.add(save);
		p.add(load);
		add.setText("Add Task");
		remove.setText("Remove Task");
		save.setText("Save");
		load.setText("Load");
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(add)) {
			file = JOptionPane.showInputDialog("Add a task.");
			Task.add(file);
		}
		if (e.getSource().equals(remove)) {
			killfile = JOptionPane.showInputDialog("Remove a task by giving a number.");
			int y = Integer.parseInt(killfile);
			Task.remove(y);
		}
		if (e.getSource().equals(save)) {
			String Total = "";
			for (int i = 0; i < Task.size(); i++) {
				Total += Task.get(i) + "\n";
			}
			try {
				FileWriter fw = new FileWriter("src/My_Program/test4.txt");
				fw.write(Total);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			String locationfile = JOptionPane.showInputDialog("Please input a file location.");
			try {
				BufferedReader br = new BufferedReader(new FileReader(locationfile));
				String line = br.readLine();
				 Task = new ArrayList<String>();
				while (line != null) {

					Task.add(line);
					line = br.readLine();
				}
				String iterator = "";
				for (int i = 0; i < Task.size(); i++) {
					iterator +=(Task.get(i)+ "\n");
				}
				
				JOptionPane.showMessageDialog(null, iterator);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
}
