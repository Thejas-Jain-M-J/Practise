package com.practice.sorting;

public class MergeSort {

    
    /**
     * @param arr
     * @param l
     * @param r
     */

     void merge(int[] arr,int l,int m,int r)
     {
        int n1=m-l+1;
        int n2=r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];
System.out.println("Left array starts");
        for (int i = 0; i < n1; ++i)
        {
            System.out.println(arr[l + i]);
        L[i] = arr[l + i];
        }
        System.out.println("Left array ends");
        System.out.println();
        System.out.println("Right array starts");
    for (int j = 0; j < n2; ++j)
    {
        System.out.println(arr[m + 1 + j]);
        R[j] = arr[m + 1 + j];
    }
    System.out.println("Right array ends");

        int i=0;int j=0;
        int k=l;

        while(i<n1 && j<n2)
        {
            if(L[i]<R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1)
        {
            arr[k++] = L[i++];
        }
        while(j<n2)
        {
            arr[k++] = R[j++];
        }
     }
    void sort(int[] arr,int l,int r)
    {
        if(l<r)
        {
            int m=l+(r-l)/2;

            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
            
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
        
        int[] arr = {7,8,4,2,1,3,9,3,5,1};

        new MergeSort().sort(arr,0,arr.length-1);
        printArray(arr);
    }

}
