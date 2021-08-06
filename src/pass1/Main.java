package pass1;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand= new Random();
        StringBuilder sb = new StringBuilder();
        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Enter the proposite of this password");
        String proposyte = myObj2.nextLine();
		char[] specialCharacters= {'!','[',']','#','$','@','%','^','&',
				'*','(',')','-','_','=','+',',','<','.','>','/','?','~','`'};
		char[] nums= {'1','2','3','4','5','6','7','8','9','0'};
		
		char[] lyric= {'a','b','c','d','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		ArrayList<Character> password=new ArrayList<Character>();
		boolean Verdad=false;
		while(Verdad==false) {
			int random=rand.nextInt(3);
			if(random==0) {
				int ran_special=rand.nextInt(specialCharacters.length);
				password.add(specialCharacters[ran_special]);

			}else if(random==1) {
				int ran_num=rand.nextInt(nums.length);
				password.add(nums[ran_num]);

			}else if(random==2) {
				int ran_lyrics=rand.nextInt(lyric.length);
				password.add(lyric[ran_lyrics]);
			}
			if(password.size()>15) {
				int random2=rand.nextInt(6);
				if(random==2) {
					Verdad=true;
				}
			}

		}
		for (Character ch:password) {
			sb.append(ch);
		}
		String password_final=sb.toString();
		String line=proposyte+": "+password_final;
		try {
	      File myObj = new File("password.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		try(PrintWriter output = new PrintWriter(new FileWriter("password.txt",true))) 
		{
		    output.printf("%s\r\n", line);
		} 
		catch (Exception e) {}
		System.out.println("Password is: "+password_final);
		System.out.println(password.size());
	}

}
