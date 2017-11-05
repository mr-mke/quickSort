package quicksort;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]){
        
        int i,r,s;
        int n=100;
        int runs=10;
        int tottime=0;
        int arr[];
        int timelist[];
        Random randomGenerator = new Random();
        
        timelist= new int[10];
        
        if(args.length == 1){
            n=Integer.parseInt(args[0]);
        }

        if(args.length == 2){
            n=Integer.parseInt(args[0]);
            runs=Integer.parseInt(args[1]);
        }       

        for(s=1;s<=5;s++){
            arr= new int[n];

            for(r=1;r<=runs;r++){
                System.out.println("Starting run no."+r);
                System.out.println("Generating array for run no."+r);
                for(i=0;i<n;i++){
                    arr[i] = randomGenerator.nextInt(n);
                }

                System.out.println("Array generated...");

                System.out.println("Sorting array...");

                Instant start = Instant.now();
                quickSort(arr, 0, n-1);
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);

                System.out.println("Array sorted...");
                System.out.println("Array size: "+ arr.length +" elements");
                System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds in run no."+r);
                tottime += timeElapsed.toMillis();
            }

            System.out.println("Average time taken for  "+ runs +" runs = "+ tottime/runs +" milliseconds");
            n=n*10;
            timelist[s]=tottime/runs;
        }
        System.out.println("Average time taken for  all runs:\r\n "+Arrays.toString(timelist));
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
