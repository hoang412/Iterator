import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
public class Iterator {

   public static void main(String[] args) {
       ArrayList<Integer> theList = new ArrayList<>();
       initializeList(theList);
       displayList(theList);
       scanAndRemovePairs(theList);
       displayList(theList);
      
   }
   
   //This method will read the input from user
   public static void initializeList(ArrayList<Integer> theList){
	   Random rand = new Random();
	   int min = 10;
	   int max = 99;
	   
	   for(int i = 0; i < 20; i++) {
		   int num = rand.nextInt(max-min+1)+min;
		   theList.add(num);
	   }
	   System.out.print("The list of 20 numbers are: " );
	   
	   
   }
   
   /**
    * This method will remove any pair that has common digit
    * @param theList
    * @return true if the size of the list os 0
    * @return false if 
    */
   public static boolean scanAndRemovePairs(ArrayList<Integer> theList){
      
       while(true){
           ListIterator<Integer> lItr = theList.listIterator();
           int num1;// = lItr.next();
           int num2;
           boolean isRemoved = false;
           
           while(lItr.hasNext()){
               num1 = lItr.next();
               
               if(!lItr.hasNext()){
                   break;
               }
               
               num2 = lItr.next();
               if(removable(num1, num2)){
                   System.out.println("Removed n1 = "+num1+", n2 = " +num2);
                   lItr.remove();// remove the current number
                   lItr.previous();// go back to the previous number
                   lItr.remove(); // remove the previous number 
                   isRemoved = true;
                   continue;
               }
           }
           if(!isRemoved){
               break;
           }
       }
       if(theList.size()==0)
           return true;
       return false;
   }
   
   /**
    * This method will get the left and right digit of the number and compare it with the next
    * @param x
    * @param y
    * @return true if the pair have common digit, false otherwise
    * 
    */
   public static boolean removable(Integer x, Integer y){
	   int leftX = x/10; 	//get the left X digit
	   int rightX = x%10; 	//get the right Y digit
	   int leftY = y/10; 	//get the left X digit
	   int rightY = y%10; 	//get the right Y digit
	   
       if(leftX == leftY || leftX == rightY || rightX == leftY || rightX == rightY){
           return true;
       }
       return false;
   }
   
   // This method will display the list after removing the pair of number that have common digit
   public static void displayList(ArrayList<Integer> theList){
       ListIterator<Integer> lItr = theList.listIterator();
       System.out.print("\n[ ");
       while(lItr.hasNext()){
           System.out.print(" "+lItr.next()+" ");
       }
       System.out.print(" ]\n");
   }
}