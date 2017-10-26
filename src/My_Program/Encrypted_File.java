package My_Program;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Encrypted_File {

	public static void main(String[] args) {
		String yEncrypted = "";
		String y = JOptionPane.showInputDialog("Give a message!");

		for (int i = 0; i < y.length(); i++) {
			yEncrypted += (char) (y.charAt(i) * 2 +y.length());
		}
		System.out.println(yEncrypted);

		try {
			FileWriter fw = new FileWriter("src/My_Program/test3.txt");
			//fw.write("\nThis is me writing a message");
			fw.write(" " + yEncrypted);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}