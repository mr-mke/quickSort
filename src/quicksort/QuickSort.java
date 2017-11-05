package quicksort;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class QuickSort {
    public static void main(String args[]){
        
        int i;
        int n=100000;
        int arr[];
        Random randomGenerator = new Random();
        
        if(args.length != 0)
            n=Integer.parseInt(args[0]);

        arr= new int[n];

        for(i=0;i<n;i++){
            arr[i] = randomGenerator.nextInt(n);
        }

        System.out.println("Array generated...");
        
        System.out.println("Sorting array...");
        Instant start = Instant.now();
        quickSort(arr, 0, n-1);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("Array sorted!");
        System.out.println("Array size: "+ arr.length +" elements");
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

    }

    static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    static void quickSort(int arr[], int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)
                quickSort(arr, left, index - 1);
          if (index < right)
                quickSort(arr, index, right);
    }
    
}
