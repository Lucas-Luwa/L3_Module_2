package My_Program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UNEncrypter {
public static void main(String[] args) {
String fileName = "";
	String yunencrypter = "";
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		 fileName = jfc.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
	}
	try {
		FileReader fr = new FileReader(fileName);
		int c = fr.read();
		String fileContents= "";
		while( c != -1) {
			fileContents += (char)((c - 27));
		
			c = fr.read();
		}
		fr.close();
		System.out.println(fileContents);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}