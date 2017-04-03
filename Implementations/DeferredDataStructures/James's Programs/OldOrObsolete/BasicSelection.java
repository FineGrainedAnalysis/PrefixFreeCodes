import java.util.Arrays;
import java.util.Scanner;

public class BasicSelection {

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
		
		
		//PERFORMING SELECTION
		//Defines queries and then partially sorts the array until all queries are answered
		
		for(int i=1; i<q+1; i++)
		{
			int k = (int)(1+n*Math.random()); //Define k
			R[i]=k;
			//Check Bitvector
			if(B[k]==1){;}
			//Selection
			else
			{
				//Find the Interval
				//Scans left and right from k to find the closest pivots
				int left=k; int right=k;
				while(B[left]!=1){left--;}
				while(B[right]!=1){right++;}
				left++;right--;
				int intervalLength = right-left+1;//Length of the interval [left, right]
				if(intervalLength<1)
					;
					
				
				//If the interval length is 4 or less, sort the interval and mark all positions as pivots.
				if(intervalLength==1)
				{
					B[left]=1;
				}
				
				else if(intervalLength==2)
				{
					count++;
					if(A[right]<A[left])
						Swap(A,left,right);
					B[left]=B[right]=1;
					//BonP+=1;
				}
				
				else if(intervalLength==3)
				{
					int med=(left + right)/2;
					count++;
					if(A[med]<A[left]){int temp = A[med];A[med]=A[left];A[left]=temp;}
					count++;
					if(A[right]<A[left]){int temp = A[right];A[right]=A[left];A[left]=temp;}
					count++;
					if(A[right]<A[med]){int temp = A[med];A[med]=A[right];A[right]=temp;}
					B[left]=B[med]=B[right]=1;
					//BonP+=3;
				}
				
				else if(intervalLength==4)
				{
					int a=A[left];int b=A[left+1];int c=A[left+2];int d=A[left+3];int low1, low2, high1, high2;
					
					count++;
					if(b<a){low1=b;high1=a;}
					else{low1=a;high1=b;}
					count++;
					if(d<c){low2=d;high2=c;}
					else{low2=c;high2=d;}
					
					count++;
					if(low1<low2)
					{A[left]=low1;
						count++;
						if(high1<low2)
						{A[left+1]=high1;A[left+2]=low2;A[left+3]=high2;}
						else
						{A[left+1]=low2;
							count++;
							if(high1<high2){A[left+2]=high1;A[left+3]=high2;}
							else{A[left+2]=high2;A[left+3]=high1;}
						}
					}
					else
					{A[left]=low2;
						count++;
						if(high2<low1){A[left+1]=high2;A[left+2]=low1;A[left+3]=high1;}
						else
						{A[left+1]=low1;
							count++;
							if(high1<high2){A[left+2]=high1;A[left+3]=high2;}
							else{A[left+2]=high2;A[left+3]=high1;}
						}
					}
					B[left]=B[left+1]=B[left+2]=B[left+3]=1;
					//BonP+=5;
				}
				
				else
				{
					//Loop to recurse QuickSelect if necessary
					do
					{
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
						int storeIndex=left;
						for(int j=left; j<right; j++)
						{
							count++;
							if(A[j]<pivotValue)
							{
								int tempj=A[j];
								A[j]=A[storeIndex];
								A[storeIndex]=tempj;
								storeIndex++;
							}
						}
						int tempStoreIndex=A[storeIndex];
						A[storeIndex]=A[right];
						A[right]=tempStoreIndex;
						
						B[storeIndex]=1; //Mark Pivot found from Partitioning
												
						//Determine which interval to recurse on
						if(k<storeIndex)
							right=storeIndex-1;
						else if(k>storeIndex)
							left=storeIndex+1;
						else
							;
					}while(B[k] != 1);
					
				}
				
				
				
				
			}
			
		}//End of Selection
		
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
