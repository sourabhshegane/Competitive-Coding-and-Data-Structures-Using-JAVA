public class BubbleSort{
    public static void main(String args[]) {
      int array[] = {2, 7, 4, 1, 5, 3};
      array = bubbleSort(array);
      
      for(int i = 0 ; i < array.length ; i ++){
          System.out.println("" + array[i]);
      }
    }
    
    public static int[] bubbleSort(int array[]){
        int numberOfPasses = 0;

        for(int k = 0 ; k < array.length ; k ++){
            boolean swapped = false;
            numberOfPasses++;
        
            for(int i = 0 ; i < ((array.length - 1) - k) ; i ++){
                
                if(array[i] > array[i + 1]){
                   /* System.out.println("Element @ i : " + array[i]);
                    System.out.println("Element @ i+1 : " + array[i + 1]);*/
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
        }
        
        System.out.println("Total number of passes required to sort this array using bubble sort is " + numberOfPasses);
        return array;
    }
}

//Time Complexity : O(n^2)
