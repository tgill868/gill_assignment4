package gill_problem1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateRemover {
	static HashMap<String,Integer> noDupz = new HashMap<String,Integer>();
	
	static ArrayList<String> uniqueWords = new ArrayList<String>();
	
	static BufferedReader br1;
	
	public static void remove(String dataFile) {
		
	
		try {
		
		br1 = new BufferedReader(new FileReader(dataFile));
		
		String lines = br1.readLine();
		
			while (lines != null) {
        	
        	String[]words=lines.toLowerCase().replace("."," ").split(" ");
        	System.out.print(Arrays.toString(words));
        	lines = br1.readLine();
        	for (String word : words) 
        	{
        		if (!noDupz.containsKey(word)) 
        		{
        			noDupz.put(word,1);
        		}
        		else 
        		{
        			uniqueWords.add(word);
        		}
        	}
        	}}
			
		catch(IOException e) 
			{
			System.out.print("Error Accessing File !");
			}
		
		try { 
			br1.close();
			}
		catch(IOException e) 
		{
			System.out.println("Error Closing Buffer Reader to Input File");
		}
	
	}
	
	
	public static void write(String outputFile) {
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(outputFile);
			} catch (IOException e) {
			
			System.out.println("Error Accessing to Output File");
		} 
		
		for(String str: uniqueWords) {
		  try {
			  
			writer.write(str + System.lineSeparator());
			
		} catch (IOException e) {
			System.out.println("Error Writing to Output File");
			}
		}
		
		
			
		try {
			writer.close();
			
		} catch (IOException e) {
			
			System.out.println("Error Closing Output File");
		}
             
          
         }}

