package example.stepbystep_remain;
import java.util.*;
import java.io.*;
public class Q11365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input =br.readLine();
			if(input.equals("END")) {
				break;
			}
			int length = input.length();
			for(int i=0; i<length;i++) {
				System.out.print(input.substring(length-i-1, length-i));
			}
			System.out.println();
			
		}
	}

}
