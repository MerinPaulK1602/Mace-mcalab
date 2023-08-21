


import java.io.*;

class FileWriteRead{

	public static void main(String args[])
	
	throws IOException{
	
	String s=" ";

		try{

InputStreamReader r = new InputStreamReader(System.in);
			
			BufferedReader br = new BufferedReader(r);
			
			System.out.println("Enter the string:");
			
			String str = br.readLine();
			
			FileWriter f = new FileWriter("/home/user/Desktop/2.txt");
			
			BufferedWriter wr = new BufferedWriter(f);
			
			wr.write(str);
			
			wr.append(" \texisting file use append");
			
			wr.close();
			
			System.out.println("Successfully written to the file");
			
			
	
		
		
			FileReader f1 = new FileReader("/home/user/Desktop/2.txt");
			
			BufferedReader br2 = new BufferedReader(f1);
			
			System.out.println("\n\n\nFile 2.txt\n");
			
			while ((s=br2.readLine())!=null){
			
				System.out.println(s);
				
			}
			
			r.close();
			
		}
		
		catch(IOException e){
			
			System.out.println(e);
			
		}
		
	}
	
}
	
			
