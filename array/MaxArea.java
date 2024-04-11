package com.array;

public class MaxArea {
	
	public static int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int area = 0;
		for(int i = 0; i < height.length; i++) {
			for(int j = 0; j < height.length; j++) {
				if(height[i] <= height[j]) {
					area = height[i]* (Math.abs(j-i));
					if(area > max) {
						max = area;
					}
				} else {
					continue;
				}
			}
		}
		return max;
		
	}
	
		public static int maxArea1(int[] height) {
	        int left = 0;
	        int right = height.length - 1;
	        int maxArea = 0;

	        while (left < right) {
	            int currentArea = Math.min(height[left], height[right]) * (right - left);
	            maxArea = Math.max(maxArea, currentArea);

	            if (height[left] < height[right]) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        return maxArea;
	    }
	
	
	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println("Max area is "+ maxArea(arr));
	}
}