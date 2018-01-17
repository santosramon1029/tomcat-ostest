package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.ResourceBundle;

public class ApplicationPathTest {

	public static void main(String[] args) throws Exception{
		File file = new File("");
		String context = file.getAbsolutePath();
		try (BufferedReader br = new BufferedReader( new InputStreamReader(
				new FileInputStream( new File(context + "/src/main/resources/testPath.txt") ) ) )){
			
			while(br.ready()) {
				System.out.println(br.readLine());
			}
			
			try(InputStream in = new FileInputStream( new File(context + "/src/main/resources/dbconfig.properties") ) ){
				Properties props = new Properties();
				props.load(in);
				System.out.println(props.get("br.com.stm.db.databaseClass"));
			}
		}
	}
}
