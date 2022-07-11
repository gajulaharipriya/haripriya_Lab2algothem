package com.hari.notecount.service;

public class MergeSortImplementation {
	void merge(int arr[], int left, int mid, int right) {
		//find size of 2 sub array to be merged
		int n1 = mid -left +1;
		int n2 = right - mid;
		
		//create temporary array 
		int leftArray[] = new int[n1];
		int rightArray[]= new int[n2];
		
		//copy data to temporary arrays
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];
		
	    //merge the temporary arrays
		
		// initial indexes of 1st and second sub-arrays
		int i = 0, j=0;
		
		//Initial index of merged sub array 
		int k = left;
		while (i < n1 && j < n2) {
			
		     
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		// copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		
		//copy remaining elements of R[] if any 
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		    }
		}
	//main function that sorts array [left...right] using merge()
	public void sort(int[] notes,int left,int right)  {
		if (left < right) {
			//find the middle point
			int mid = (left + right) /2;
			
			//sort first and second halves
			sort(notes, left, mid);
			sort(notes, mid + 1, right);
			
			//merge the sorted halves
			merge(notes, left, mid, right);
		}
	}

}