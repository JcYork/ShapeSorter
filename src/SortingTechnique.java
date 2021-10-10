public class SortingTechnique {
    //Sorting algorithm adapted from similar implementation on https://www.geeksforgeeks.org/insertion-sort/
    //An implementation of insertion sort.
    public static void InsertionSort(Shape[] shapes){
        for(int i = 1; i < shapes.length; i++){
            Shape insertee = shapes[i];
            int j = i - 1;
            while(j >= 0 && shapes[j].compareTo(insertee) > 0){
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j+1] = insertee;
        }
        //System.out.println("Debug: I'm all done sorting");
    }
}
