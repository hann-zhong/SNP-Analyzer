//Determine if the SNP is a silent mutation or if it causes a change in amino acids
//-------------------------------------------------------------------------------------------------------
import java.util.Scanner;
public class countBaseInGene{
    public static void main(String[] args){    
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the header & genome in the described format:");
        String header = s.nextLine();
        String genome = s.nextLine();
        int targetBase = s.nextInt();
        s.close();
        
        //empty string for the transcription step later
        String mRna = "";
        
        int length = genome.length();

        //change the pipe symbol to a slash, because the pipe isn't accepted as a delimiter.
        String newHeader = header.replace('|','/');

            
        //using a scanner to go through the header string so i can separate it into the parts i need
        //this separates the header into 5 sections 
        Scanner scan = new Scanner(newHeader).useDelimiter("/");
        String part1 = scan.next();
        String c1 = scan.next();
        String c2 = scan.next();
        String direction = scan.next();
        String lastPart = scan.next();
        scan.close();

        //taking the parts of the split up header that i need and turning them from string values to int values
        //basically just obtaining the coordinates 
        int coor1 = Integer.parseInt(c1);
        int coor2 = Integer.parseInt(c2);
        int dir = Integer.parseInt(direction);
           
        //finding index
        int diff = targetBase - coor1;
        System.out.println("index: " + diff);   
        
        //reverse the string if necessary
        if(dir == -1){
          String reverse = "";
          int count = length - 1;
             while (count >= 0){
            reverse += genome.charAt(count);
            count--;
          }
            char reverseBase = reverse.charAt(diff);
            System.out.println("nucleotide: " + reverseBase);
                
         //finding the codon for the SNP, only if the string has been reversed
         //also transcription of the DNA codon to the mRNA codon
          if ((diff  + 1) % 3 == 0){
           char a1 = reverse.charAt(diff - 2);
           char a2 = reverse.charAt(diff - 1);
           char a3 = reverse.charAt(diff);
           String rCodon3 = "" + a1 + a2 + a3;
           System.out.println("codon: " + a1 + a2 + a3);

        //transcription step: there are several scenarios because the target base could be at the start, middle or end
        //of the codon.
           if(a1 == 'A'){
             mRna += 'U';
           }
           if(a1 == 'G'){
             mRna += 'C';
           }
           if(a1 == 'C'){
             mRna += 'G';
           }
           if(a1 == 'T'){
             mRna += 'A';
           }

           if(a2 == 'A'){
             mRna += 'U';
           }
           if(a2 == 'G'){
             mRna += 'C';
           }
           if(a2 == 'C'){
             mRna += 'G';
           }
           if(a2 == 'T'){
             mRna += 'A';
           }

           if(a3 == 'A'){
             mRna += 'U';
           }
           if(a3 == 'G'){
             mRna += 'C';
           }
           if(a3 == 'C'){
             mRna += 'G';
           }
           if(a3 == 'T'){
             mRna += 'A';
           }  
           System.out.println("mRNA strand: " + mRna);
         }
        //------------------------------------------------------------------------------------------------     
         if((diff + 1) % 2 == 0){
           char d1 = reverse.charAt(diff - 1);
           char d2 = reverse.charAt(diff);
           char d3 = reverse.charAt(diff + 1);
           String rCodon2 = "" + d1 + d2 + d3;
           System.out.println("codon: " + d1 + d2 + d3);
           if(d1 == 'A'){
             mRna += 'U';
           }
           if(d1 == 'G'){
             mRna += 'C';
           }
           if(d1 == 'C'){
             mRna += 'G';
           }
           if(d1 == 'T'){
             mRna += 'A';
           }

           if(d2 == 'A'){
             mRna += 'U';
           }
           if(d2 == 'G'){
             mRna += 'C';
           }
           if(d2 == 'C'){
             mRna += 'G';
           }
           if(d2 == 'T'){
             mRna += 'A';
           }

           if(d3 == 'A'){
             mRna += 'U';
           }
           if(d3 == 'G'){
             mRna += 'C';
           }
           if(d3 == 'C'){
             mRna += 'G';
           }
           if(d3 == 'T'){
             mRna += 'A';
           }
           System.out.println("mRNA strand: " + mRna);
         }
        //------------------------------------------------------------------------------------------------
         if(((diff +1) % 2 != 0) & (diff +1) % 3 != 0){
           char n1 = reverse.charAt(diff);
           char n2 = reverse.charAt(diff + 1);
           char n3 = reverse.charAt(diff + 2);
           String rCodon1 = "" + n1 + n2 + n3;
           System.out.println("codon: " + n1 + n2 + n3);
           if(n1 == 'A'){
             mRna += 'U';
           }
           if(n1 == 'G'){
             mRna += 'C';
           }
           if(n1 == 'C'){
             mRna += 'G';
           }
           if(n1 == 'T'){
             mRna += 'A';
           }

           if(n2 == 'A'){
             mRna += 'U';
           }
           if(n2 == 'G'){
             mRna += 'C';
           }
           if(n2 == 'C'){
             mRna += 'G';
           }
           if(n2 == 'T'){
             mRna += 'A';
           }

           if(n3 == 'A'){
             mRna += 'U';
           }
           if(n3 == 'G'){
             mRna += 'C';
           }
           if(n3 == 'C'){
             mRna += 'G';
           }
           if(n3 == 'T'){
             mRna += 'A';
           }
           System.out.println("mRNA strand: " + mRna);
         }
        //------------------------------------------------------------------------------------------------  
        //if the direction isn't -1, it won't be reversed
        }else{
          char base = genome.charAt(diff);
          System.out.println("nucleotide: " + base);

        //finding the codon associated with the SNP
        //transcription
         if ((diff  + 1) % 3 == 0){
           char a1 = genome.charAt(diff - 2);
           char a2 = genome.charAt(diff - 1);
           char a3 = genome.charAt(diff);
           String codon3 = "" + a1 + a2 + a3;
           System.out.println("codon: " + a1 + a2 + a3);
        //------------------------------------------------------------------------------------------------
           if(a1 == 'A'){
             mRna += 'U';
           }
           if(a1 == 'G'){
             mRna += 'C';
           }
           if(a1 == 'C'){
             mRna += 'G';
           }
           if(a1 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------      
           if(a2 == 'A'){
             mRna += 'U';
           }
           if(a2 == 'G'){
             mRna += 'C';
           }
           if(a2 == 'C'){
             mRna += 'G';
           }
           if(a2 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------      
           if(a3 == 'A'){
             mRna += 'U';
           }
           if(a3 == 'G'){
             mRna += 'C';
           }
           if(a3 == 'C'){
             mRna += 'G';
           }
           if(a3 == 'T'){
             mRna += 'A';      
           }
           System.out.println("mRNA strand: " + mRna);
         }
        //------------------------------------------------------------------------------------------------     
         if((diff + 1) % 2 == 0){
           char d1 = genome.charAt(diff - 1);
           char d2 = genome.charAt(diff);
           char d3 = genome.charAt(diff + 1);
           String codon2 = "" + d1 + d2 + d3;
           System.out.println("codon: " + d1 + d2 + d3);
        //------------------------------------------------------------------------------------------------
           if(d1 == 'A'){
             mRna += 'U';
           }
           if(d1 == 'G'){
             mRna += 'C';
           }
           if(d1 == 'C'){
             mRna += 'G';
           }
           if(d1 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------       
           if(d2 == 'A'){
             mRna += 'U';
           }
           if(d2 == 'G'){
             mRna += 'C';
           }
           if(d2 == 'C'){
             mRna += 'G';
           }
           if(d2 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------      
           if(d3 == 'A'){
             mRna += 'U';
           }
           if(d3 == 'G'){
             mRna += 'C';
           }
           if(d3 == 'C'){
             mRna += 'G';
           }
           if(d3 == 'T'){
             mRna += 'A';
         }   
           System.out.println("mRNA strand: " + mRna);
        }
        //------------------------------------------------------------------------------------------------        
         if(((diff +1) % 2 != 0) & (diff +1) % 3 != 0){
           char n1 = genome.charAt(diff);
           char n2 = genome.charAt(diff + 1);
           char n3 = genome.charAt(diff + 2);
           String codon1 = "" + n1 + n2 + n3;
           System.out.println("codon: " + n1 + n2 + n3);
        //------------------------------------------------------------------------------------------------      
           if(n1 == 'A'){
             mRna += 'U';
           }
           if(n1 == 'G'){
             mRna += 'C';
           }
           if(n1 == 'C'){
             mRna += 'G';
           }
           if(n1 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------      
           if(n2 == 'A'){
             mRna += 'U';
           }
           if(n2 == 'G'){
             mRna += 'C';
           }
           if(n2 == 'C'){
             mRna += 'G';
           }
           if(n2 == 'T'){
             mRna += 'A';
           }
        //------------------------------------------------------------------------------------------------      
           if(n3 == 'A'){
             mRna += 'U';
           }
           if(n3 == 'G'){
             mRna += 'C';
           }
           if(n3 == 'C'){
             mRna += 'G';
           }
           if(n3 == 'T'){
             mRna += 'A';
         }
         System.out.println("mRNA strand: " + mRna);
        }
        //------------------------------------------------------------------------------------------------ 
        }
    }
}

