package com.gl.GradedAlgo.Stocker.service;
/* We will use binary search to search share price and we will do ascending sort for that */
public class StockSearch {
	
	public static void binarySearch(double share[], int first, int last, double key){
		
			int mid=(first+last)/2;
			while(first<=last){
				if (share[mid]<key){
					first = mid+1;
				}else if(share[mid]==key){
					System.out.println("share"+key +"is present");
					break;
				}
				else{
					last = mid-1;
				}
				mid=(first+last)/2;
			}
			if(first>last){
				System.out.println("Share not found !");
			}
		}

}
