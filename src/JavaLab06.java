import java.util.*;
public class JavaLab06 {
    public static void main(String[] args){
        //reading stream
        Scanner input = new Scanner(System.in);

        //creating array
        int[] arr = new int[5];

        //initialize with random numbers
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(1 + Math.random() * 10);
        }

        //display the array
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        //control variable for while loop
        boolean controlVal = false;

        //runs until the correct output is entered and the control variable is changed
        while(!controlVal){

            //try block, it is important to put if statement first or else program will
            //generate arrayoutofbounds error before the exception a or b can be thrown
            try{
                System.out.println("\nEnter an index of a value in the array: ");
                int index = input.nextInt();

                //throws ExceptionA
                if(index < 0)
                    throw new ExceptionA();

                //throws ExceptionB
                if(index > arr.length-1)
                    throw new ExceptionB();

                //output and change the control variable
                System.out.println("the value at index " + index + " is " + arr[index]);
                controlVal = true;
            }

            //catch ExceptionA, display message, and clear the buffer
            catch (ExceptionA exa){
                System.out.println(exa.toString());
                input.nextLine();
            }

            //catch ExceptionB, display message, and clear the buffer
            catch (ExceptionB exb){
                System.out.println(exb.toString());
                input.nextLine();
            }
        } //while loop
    }//main


}

class ExceptionA extends Exception{
    //override toString
    @Override
    public String toString() {
        return "Exception A: index cannot be negative";
    }
}

class ExceptionB extends Exception{
    //Override toString
    @Override
    public String toString() {
        return "Exception B: Number cannot be >= array length";
    }
}
