package My_Program;

import java.io.FileWriter;
import java.io.IOException;

public class CopyrightADDER {
public static void main(String[] args) {
	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/IntroToFileIO.java", true);
		
		
		
		fw.write("//Copyright © 2017 by Lucas Luwa");
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
