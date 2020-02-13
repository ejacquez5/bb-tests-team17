import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class opfinder{

   public static void main(String[] args) throws IOException {
      int opcount = 0;
      File f1=new File("/Users/Null/Desktop/last semes/v&v/code/opcheck.txt"); 
      String[] words=null;  
      FileReader fr = new FileReader(f1);    
      BufferedReader br = new BufferedReader(fr);   
      String inputs;  
      while((inputs=br.readLine())!=null)
      {
         words=inputs.split(" ");  
         for(int i=0;i<words.length;i++)
         {
            for(int j=0;j<words[i].length();j++)
            {
               char ch=words[i].charAt(j); 
               if(ch == ';' || ch == '+' || ch == '<' ||ch == '>' || ch == '='|| ch == '.'||ch =='-') {//checking for ops
                    opcount++;
                 }
            } 
         }
      }
      System.out.println("op count is = "+opcount+"*row + "+opcount+"*col");
   }
}