package com.array;

import java.util.Arrays;

public class MergeTwoArrays {
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int newLength = len1+len2;
        double result = 0;
        int[] dummyArray = new int[newLength];
        int i = 0, j = 0, k = 0;

        while(i < len1) {
            dummyArray[k++] = nums1[i++]; 
        }

        while(j < len2) {
            dummyArray[k++] = nums2[j++];
        }

        Arrays.sort(dummyArray);

        if(dummyArray.length % 2 != 0) {
            int index = (dummyArray.length / 2);
            result = dummyArray[index];
        } else {
            int index1 = (dummyArray.length / 2);
            int index2 = index1 - 1;
            result = (dummyArray[index1] + dummyArray[index2])/2;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	int[] arr1 = {1,3};
    	int[] arr2 = {2,4};
    	System.out.println("Median is "+findMedianSortedArrays(arr1, arr2));
    }
}