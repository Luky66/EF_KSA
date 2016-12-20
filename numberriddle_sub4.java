
package numberriddle;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Subtask4
{
    public static void main(String[] args)
    {
        // set up file import
        String inputFilePath = "textFiles/sub4/numberriddle-sub4-example.txt";
        String outputFilePath = "textFiles/sub4/numberridle-sub4-example-output.txt";
        File file = new File(inputFilePath);
        Scanner scanner = null;
        PrintStream out = null;
        
        // set up input values
        int numberOfTestCases;  // T
        int numberOfValues;     // N
        int targetResult;       // R
        int[] values = null;    // n_i
        
        int[] array = null; // 
        
        
        // Read the input file
        try {  scanner = new Scanner(file); } catch(FileNotFoundException e) {System.out.println("ERROR: Input File not found!"); }
        // Set up PrintStream to write to the output file
        try { out = new PrintStream(outputFilePath); } catch (FileNotFoundException e) {System.out.println("ERROR: Input File not found!"); }
        
        
// ----- Main part ----------------------------------------
        
        numberOfTestCases = scanner.nextInt(); // Set T
        for(int i=1; i<=numberOfTestCases; i++)
        {
            //output = false;
            numberOfValues = scanner.nextInt(); // Set N
            targetResult = scanner.nextInt(); // Set R
            values = new int[numberOfValues]; // Creates Array of length N, representing all the imput values
            int sum = 0; // creates and sets the sum to 0
            
            // Fills the array with the given values and calculates the sum
            for(int j=0; j<numberOfValues; j++)
            {
                int x;
                x = scanner.nextInt();
                values[j] = x;
                sum += x;
            }
            // sum is now equals the sum of the N given values
            array = new int[sum+1]; // Creates an array from 0 to sum
            
            
            // ----- start of the algorithm -----
            /*
                Create an array from 0 to sum.
                enter a value for all indexes that can be reached.
                If R is reachable the array at index R will be "1".
                if that is the case, output "YES", else: "NO"
            */
            
            array[sum] = 1; // sets start value for the algorithm
            
            for(int j=1; j<numberOfValues; j++) // repeat for every value which can be added or subtracted
            {
                if(array[targetResult] == 1) // checks if R can be already reached
                {
                    // if so, stop here
                    break;
                }
                
                for(int k=targetResult; k<sum+1; k++) // search for all values with "1"
                {
                    if(array[k] == 1)
                    {
                        // We found a "1"!
                        if(k == targetResult) // checks if it's R
                        {
                            break;
                        }
                        array[k-2*values[j]] = 1; // goes to the next smaller index which can be reached and sets it to 1
                        // *Note: this will be done for all the 1s*
                    }
                }
            }
            
            // Check whether or not R can be reached
            if(array[targetResult] == 1)
            {
                // R can be reached
                System.out.println("Case #"+i+": YES");
                out.println("Case #"+i+": YES");
            }
            else
            {
                // R can't be reached
                System.out.println("Case #"+i+": NO");
                out.println("Case #"+i+": NO");
            }
        }
    }
}
