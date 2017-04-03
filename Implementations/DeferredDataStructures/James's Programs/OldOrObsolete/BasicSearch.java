import java.util.Arrays;
import java.util.Scanner;


public class BasicSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//SET UP
		//Setting up and Initializing Variables/Arrays
		
		Scanner Nin = new Scanner(System.in);
		System.out.println("How Many Elements are in the Unsorted List?"); //Prompts the user for n
		int n = Nin.nextInt(); //Number of Elements
		System.out.println("How many Queries would you like answered?"); //Prompts the user for q
		int q = Nin.nextInt(); //Number of Selection Queries
		int count = 0; //Number of Comparisons used
		int [] A = new int[n]; //Array to hold the elements
		int [] B = new int[n]; //Bit Vector used to mark pivots.
		int [] R = new int [q+2]; //Array of Query Answers
		R[0]=0; R[q+1]=n; //Sets the lowest rank to 0 and the highest rank to n
		for(int i=0; i<n; i++)//Assigns values to the Elements
		{A[i]=(int)(1+n*Math.random());}
		
		//PREPROCESSING PHASE
		//Find Min and Max and swap them into A[0] and A[n-1], respectively
		
		//Find Min
		int minIndex=0;
		for(int i=0; i<n; i++)
		{if(A[i]<A[minIndex]){minIndex=i;}}
		Swap(A, 0, minIndex);//Swap min into position 0
		count+=n;
		
		//Find Max
		int maxIndex=0;
		for(int i=0; i<n; i++)
		{if(A[i]>A[maxIndex]){maxIndex=i;}}
		Swap(A, maxIndex, n-1);//Swap max into position n-1
		count+=n;
		
		B[0]=B[n-1]=1;//Marks positions 0 and n-1 as pivots
		
		
		
		//PERFORMING SEARCH
		//Defines queries and then partially sorts the array until all queries are answered
		int j=0; //answer to query
		
		for(int x=0; x<q; x++)
		{
			
			int p =(int)(1+n*Math.random());//Defines the Search Query
			
			
			
			
			//Perform Binary Search
			int i=-1; int iMin=0; int iMax=A.length-1; int iMid=-1;
			count++;
			if(p<A[iMin])
				i=-2;
			else if (p>A[iMax])
				{
					count++;
					i=-3; 
				}
			else
			{
				count++;
			  do
			    {
			      if(iMid==iMin)
			    	  {i=iMid; break;}
				  
				  /* calculate the midpoint for roughly equal partition */
			      iMid = iMin+((iMax-iMin)/2);
			 
			      // determine which subarray to search
			      count++;
			      if (A[iMid] < p)
			        // change min index to search upper subarray
			        iMin = iMid + 1;
			      else if (A[iMid] > p)
			        // change max index to search lower subarray
			        {iMax = iMid - 1; count++;}
			      else
			        // key found at index imid
			        {count+=2; i= iMid;}
			    }while(p!=A[iMid]);
			}
			//End Binary Search
			
			
			
			if(i==-2)//Case where p<A[0]
				j=0;
			else if(i==-3)//Case where p>A[n-1] 
				j=A.length;
			else if(A[i]==p && B[i]==1)//Case where p=A[i] and B[i]=1, Element is found and is in proper sorted position
				j=i;
			else//Perform Selection Query on subinterval
			{
				//Find SubInterval
				int left, right;
				if(B[i]==1)
				{
					if(p>A[i])
					{
						left=i; right=i+1;
						while(B[right]!=1){right++;}
					}
					else
					{
						right=i; left=i-1;
						while(B[left]!=1){left--;}
					}
				}
				else
				{
					left=i; right=i;
					while(B[left]!=1){left--;}
					while(B[right]!=1){right++;}
				}
				
				
				//Check endpoints
				count++;
				if(A[left]==p)
					j=left+1;
				else if(A[right]==p)
					{j=right+1; count++;}
				else
				{
					count++;
					int intervalLength=right-left-1;
					
					if(intervalLength==0)
						j=left+1;
					else if(intervalLength==1)
					{
						count++;
						if(p<A[left+1])
							j=left+1;
						else
							j=left+2;
						
						B[left+1]=1;
					}
					else if(intervalLength==2)
					{
						count++;
						if(A[left=2]<A[left+1])
							Swap(A, left+1, left+2);
						
						
						if(p<A[left+1])
							{j=left+1; count--;}
						else if(p<A[left+2])
							j=left+2;
						else
							j=left+3;
						count+=2;
						
						B[left+1]=B[left+2]=1;
					}
					else
					{
						left++; right--;//make left and right be within the unsorted interval instead of the left and right side pivots
						int storeIndex;
						do
						{
							if(B[left]==1 && A[left]==p)
								break;
							//Median of Three Partitioning
							int med=(left + right)/2;
							count++;
							if(A[med]<A[left]){int temp = A[med];A[med]=A[left];A[left]=temp;}
							count++;
							if(A[right]<A[left]){int temp = A[right];A[right]=A[left];A[left]=temp;}
							count++;
							if(A[right]<A[med]){int temp = A[med];A[med]=A[right];A[right]=temp;}
							
							//Partition about the Median element
							int pivotValue=A[med];
							Swap(A, med, right);
							storeIndex=left;
							for(int l=left; l<right; l++)
							{
								count++;
								if(A[l]<pivotValue)
								{
									int tempj=A[l];
									A[l]=A[storeIndex];
									A[storeIndex]=tempj;
									storeIndex++;
								}
							}
							int tempStoreIndex=A[storeIndex];
							A[storeIndex]=A[right];
							A[right]=tempStoreIndex;
							
							B[storeIndex]=1; //Mark Pivot found from Partitioning
													
							//Determine which interval to recurse on
							if(p<A[storeIndex])
								right=storeIndex-1;
							else if(p>=A[storeIndex])
								left=storeIndex+1;
							else
								;
							
							
							
						}while(right>left);
						
						
						if(B[left]==0)
						{
							if(p<A[left])
								j=left;
							else if(p>A[left])
								j=left+1;
							else
								j=left;
							B[left]=1;
						}
						else if(B[left]==1)
						{
							if(A[left]==p)
								j=left;
						}
					}//End partitioning loop
				}	
			}//End of Search Query
			R[x]=j;
		} //All Queries have been answered
		
		Arrays.sort(R); //Sorts Querries
		long BonQ=(long)(n*Math.log(n)/Math.log(2)); //BonQ represents the lower bound of finding the Q queries
		for(int x=1; x<q+1; x++)
			BonQ-=(long)((R[x]-R[x-1])*((Math.log(R[x]-R[x-1])/Math.log(2))));
		
		long BonP = (long)(n*Math.log(n)/Math.log(2)); //BonP represents the lower bound of finding Pivots.
		long IL=0;
		for(int i=1; i<n;i++)
		{
			if(B[i]==0)
				IL++;
			else
			{
				if(IL==0)
					;
				else
					BonP-=(long)(IL*Math.log(IL)/Math.log(2));
				IL=0;
			}
		}
		
		//DISPLAY RESULTS
		System.out.println("Count: " + count);
		System.out.println("BonQ: " + BonQ);
		System.out.println("BonP: " + BonP);
		
	}
	
	public static void Swap(int [] A, int x, int y)
	{
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}

}
