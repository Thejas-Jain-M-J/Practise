package com.practice.sorting;

public class QuickSort {

int partition(int[] arr,int low, int high)
{

    int pivot=arr[low];
    int k=high;
    System.out.println("pivot -> "+pivot);
    System.out.println("Array starts");
    for(int i=high;i>low;i--)
    {
        
        if(arr[i] > pivot)
        {
            
            swap(arr,i,k--);
        }
    }
    
    swap(arr,low,k);
    for(int j=0;j<arr.length;j++)
    {
        System.out.println(arr[j]);
    }
    System.out.println("Array ends");
    System.out.println("k "+k);
    System.out.println();
    return k;
}


public static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
void quickSort(int[] arr, int low, int high)
{
    if(low<high)
    {
        int i=partition(arr, low, high);

        quickSort(arr,low,i-1);
        quickSort(arr, i+1, high);
    }

}

static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

public static void main(String[] args) {

    int[] arr = {4,3,1,7,9,5,6,7,3,1,8};
    new QuickSort().quickSort(arr, 0, arr.length-1);
    printArray(arr);
}

}
