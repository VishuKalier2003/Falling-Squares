/** There are several squares being dropped onto the X-axis of a 2D plane... You are given a 2D integer array positions where 
positions[i] = [lefti, sideLengthi] represents the ith square with a side length of sideLengthi that is dropped with its left 
edge aligned with X-coordinate lefti... Each square is dropped one at a time from a height above any landed squares... It then
falls downward (negative Y direction) until it either lands on the top side of another square or on the X-axis... A square 
brushing the left/right side of another square does not count as landing on it. Once it lands, it freezes in place and cannot 
be moved... After each square is dropped, you must record the height of the current tallest stack of squares...
Return an integer array ans where ans[i] represents the height described above after dropping the ith square...
* * Eg 1 :         positions = [[1,2],[2,3],[6,1]]                         Output = [2,5,5]
* * Eg 2 :         positions = [[100,100],[200,100]]                       Output = [100,100]
*/
import java.util.*;
public class FallingSquares
{
      public int[] HighestStack(int positions[][])
      {
            int ans[] = new int[positions.length];    // Answer array length defined...
            Arrays.sort(positions, (a, b) -> Integer.compare(a[0], b[0]));   //! Sorting => O(N log N)
            // Sorting the array in Increasing Order with a and b...
            System.out.println("The Sorted 2d array formed is : ");
            for(int i = 0; i < positions.length; i++)
                  System.out.print("["+positions[i][0]+", "+positions[i][1]+"], ");
            ans[0] = positions[0][1];     // The base or the first square output...
            System.out.println();
            int t = 1, max = ans[0];         // Declaring loop variables...
            while(t < positions.length)
            {
                  // If the two corresponding boxes are coinciding, then update the max height...
                  if((positions[t - 1][0] + positions[t - 1][1]) > positions[t][0])   //! Coinciding condition => O(1)
                  {
                        max = max + (positions[t - 1][0] + positions[t - 1][1]);
                        max = Math.max(Integer.MIN_VALUE, max);     // Taking the maximum out of the two...
                        ans[t] = max;     //! Solution array evaluation => O(1)
                  }
                  else
                        ans[t] = max;
                  t++;      // Incrementing t for every square...
            }
            return ans;
      }
      public static void main(String args[])
      {
            Scanner scanner = new Scanner(System.in);
            int x;
            System.out.print("Enter number of squares : ");
            x = scanner.nextInt();
            int array[][] = new int[x][2];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter position of "+(i+1)+" square : ");
                  array[i][0] = scanner.nextInt();
                  System.out.print("Enter the side of "+(i+1)+" square : ");
                  array[i][1] = scanner.nextInt();
            }
            FallingSquares fallingsquares = new FallingSquares();        // Object creation...
            int arr[] = fallingsquares.HighestStack(array);                 // Function calling...
            System.out.println("The Output array of Heights is : ");
            for(int i = 0; i < arr.length; i++)
                  System.out.print(arr[i]+", ");
            scanner.close();
      }      
}


//! Time Complexity - O(N log N) time...
//! Space Complexity - O(N) space...

/** //* DEDUCTIONS :- 
 * * Sort the array, becuase the number of falling sqaures is not dynamic, and we are checking for the coinciding squares...
 * * Secondly, we check the coinciding squares property by checking the range of previous square and the x coordinate of current square...
 * * Then, the values of the solution array can be derived iteratively...
*/