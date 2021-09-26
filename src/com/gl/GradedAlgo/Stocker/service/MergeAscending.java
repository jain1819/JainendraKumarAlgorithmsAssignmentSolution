package com.gl.GradedAlgo.Stocker.service;
/* for sorting share in ascending order*/
public class MergeAscending {

	public   void merge(double share[], int left, int mid, int right) {
		// Finding sizes of two sub arrays to be merged
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;

		/* Creating temporary arrays */
		double leftArray[] = new double[leftArraySize];
		double rightArray[] = new double[rightArraySize];

		/* Copy data to temporary arrays, division of array */
		for (int i = 0; i < leftArraySize; ++i)
			leftArray[i] = share[left + i];
		for (int j = 0; j < rightArraySize; ++j)
			rightArray[j] = share[mid + 1 + j];

		/* Merge the temporary arrays, conquering the array */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] <= rightArray[j])// for descending (leftArray[i]>= rightArray[j] 
			{
				share[k] = leftArray[i];
				i++;
			} else {
				share[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of Left array if any */
		while (i < leftArraySize) {
			share[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of Right array if any */
		while (j < rightArraySize) {
			share[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts array[left...right] using merge()
	public  void sort(double[] share, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves, division of array
			sort(share, left, mid);
			sort(share, mid + 1, right);

			// Merge the sorted halves, conquering the array
			merge(share, left, mid, right);
		}
	}
	
	}

