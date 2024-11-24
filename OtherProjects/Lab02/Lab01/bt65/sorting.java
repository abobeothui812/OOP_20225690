package bt65;

import java.util.Arrays;
public class sorting {
    public static void mergeSort (int[] arr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] A,int L,int M, int R){
        int i = L, j= M+1;
        int[] newArr = new int[R-L+1];
        for(int k= L;k<=R;k++){
            if(i>M){
                newArr[k-L]=A[j];
                j++;
            }
            else if(j>R){
                newArr[k-L]=A[i];
                i++;
            }
            else{
                if(A[i]<A[j]){
                    newArr[k-L]=A[i];
                    i++;
                }
                else{
                    newArr[k-L]=A[j];
                    j++;
                }
            }
        }

        for(int k=L;k<=R;k++){
            A[k]=newArr[k-L];
        }
    }
    public static void main(String[] args) {
        int[] arr = {1789, 2035, 1899, 1456, 2013};
        mergeSort(arr, 0, arr.length-1);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        int average = sum/arr.length;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

    }
}
