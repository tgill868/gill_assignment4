package gill_problem2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;


public class DuplicateCounter {
	static HashMap<String, Integer> countMap = new HashMap<String, Integer>();
    
    static BufferedReader rdr1 = null;
    
    static BufferedWriter bf = null;;
	
	public static void count(String dataFile) {
		
        try
        {
        	rdr1 = new BufferedReader(new FileReader(dataFile));
        	
        }
        catch(IOException e) 
        {
        	System.out.println("Error Accessing File to Read");
        }
        try 
        {
            String currentLine = rdr1.readLine();
            
            while (currentLine != null)
            {   
                String[] words = currentLine.toLowerCase().split(" ");
               
                for (String word : words)
                {
                    if(countMap.containsKey(word))
                    {   
                        countMap.put(word, countMap.get(word)+1);
                    }
                    else
                    {
                        countMap.put(word, 1);
                    }
                }
                 
                currentLine = rdr1.readLine();
            }
            System.out.println(countMap);
  }	
        catch(Exception e) {
	  System.out.println("Error getting duplicate words");
  }
        try { rdr1.close();} 
        catch(Exception e) {
	  System.out.println("Error closing reader to file");
  }}
                 
	
	
	public static void write(String outputFile) {

        try{
            
            bf = new BufferedWriter( new FileWriter(outputFile));
 
            for(Entry<String, Integer> entry : countMap.entrySet()){
                
                bf.write( entry.getKey() + ":" + entry.getValue() );
               
                bf.newLine();
            }
            
            bf.flush();
 
        }catch(IOException e){
            System.out.println("Error Writing to File!");
        }finally{
            
            try{
                
                bf.close();
            }catch(Exception e)
            {
            	System.out.println("Error Closing output File!");
            }
        }
		
	}}	 
	   
	   
