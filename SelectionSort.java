//Selection Sort Algorithm. For tutorial : https://www.youtube.com/watch?v=GUDLRan2DWM&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=2

public class SelectionSort{
    public static void main(String args[]) {
      int array[] = {2, 7, 4, 1, 5, 3, 0};
      int sortedArray[] = selectionSort(array);
      
      System.out.println("Array after sorting");
      for(int k = 0 ; k < sortedArray.length ; k ++){
        System.out.println(sortedArray[k]);    
      }
      
    }
    
    public static int[] selectionSort(int array[]){
        for(int i = 0 ; i < (array.length - 1) ; i++){
            int indexToBeSwappedWith = i;
            
            //Iterate through the remaining array
            for(int j = (i + 1) ; j < (array.length) ; j ++){
                if(array[j] < array[indexToBeSwappedWith])
                    indexToBeSwappedWith = j;
            }
            
            /*System.out.println("DEBUG : Ith element : " + array[i]);
            System.out.println("DEBUG : Jth element : " + array[indexToBeSwappedWith]);*/
            
            //Swap current Ith index with index of smaller number present in remaining array iterated by j
            int temp = array[i];
            array[i] = array[indexToBeSwappedWith];
            array[indexToBeSwappedWith] = temp;
        }
        
        return array;
    }
}