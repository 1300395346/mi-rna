package com.rna.controller;

public class BinarySearch {
    public static void main(String[] args) {
        int []arr={-5,1,2,3,5};
        System.out.println(binarySearch2(arr, -99, 5));
    }
    public static int binarySearch1(int [] arr,int x,int n){
        int left =  0;int right = n-1;
        while (left<=right){
            int middle = (left+right)/2;
            if(x==arr[middle])return middle;
            if(x>arr[middle])left = middle;
            else right=middle;
        }
        return -1;
    }

    public static int binarySearch2(int [] arr,int x,int n){
        int left =  0;int right = n-1;
        while (left<right-1){
            int middle = (left+right)/2;
            if(x<arr[middle])right=middle;
            else left=middle;
        }
        if (x==arr[left]) return left;
        else return -1;
    }
}
