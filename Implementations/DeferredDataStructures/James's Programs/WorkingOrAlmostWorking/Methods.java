import java.util.*;



public class Methods {

	
	public static void Swap(int[]A, int b, int c)
	{
		int temp=A[b];
		A[b]=A[c];
		A[c]=temp;
	}
	//SET-UP
	public static int[] SetupA(int n)
	{
		int[]A=new int[n];
		for(int x=0; x<n; x++)
		{A[x]=(int)(2000000000*Math.random());}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;
		
	}
	
	public static int[] ADSetupA(int n)
	{
		int[]A=new int[2*n];
		for(int x=0; x<n; x++)
		{A[x]=(int)(2000000000*Math.random());}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;
	}

	public static int[] UADSetupA(int n)
	{
		int[]A=new int[2*n];
		for(int x=0; x<n; x++)
		{A[x]=(int)(2000000000*Math.random());}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}
	
	public static int[] USetupA(int n)
	{
		int[]A=new int[n];
		for(int x=0; x<n; x++)
		{A[x]=(int)(2000000000*Math.random());}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}

	public static int[] NADSetupA(int n)
	{
		
		
		int[]A=new int[2*n];
		for(int x=0; x<n; x++)
		{
			double v1=0, v2=0, temp=0, s=0;
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = (682000000*temp)+1000000000;
			}while(temp<0 || temp>2000000000);
			A[x]=(int)(temp);
		}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}
	
	public static int[] NSetupA(int n)
	{
		
		
		int[]A=new int[n];
		for(int x=0; x<n; x++)
		{
			double v1=0, v2=0, temp=0, s=0;
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = (682000000*temp)+1000000000;
			}while(temp<0 || temp>2000000000);
			A[x]=(int)(temp);
		}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}
	
	public static int[] CADSetupA(int n, int numberOfClumps, String clumpDistribution)
	{
		String cd = clumpDistribution;
		
		int[]A=new int[2*n];
		for(int x=0; x<n; x++)
		{
			int nc = numberOfClumps;
			int mean=(int)(2000000000/(double)(nc+1));
			int std=(int)(mean/(double)nc);
			int spacing=0;
			double v1=0, v2=0, temp=0, s=0;
			
			if(cd.equalsIgnoreCase("u")){spacing = (int)(nc*Math.random()+1);}
			else
			{
				v1=0; v2=0; temp=0; s=0;
				do{
				do{
				v1=2*(Math.random())-1;
				v2=2*(Math.random())-1;
				s=v1*v1 + v2*v2;
				}while(s>=1 || s==0);
				s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
				temp = v1*s;
				temp = ((nc/6)*temp)+(nc/2);
				}while(temp<0 || temp>nc);
				spacing = (int)(temp);
			}
			
			v1=0; v2=0; temp=0; s=0;
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = (std*temp)+(spacing*mean);
			}while(temp<0 || temp>2000000000);
			A[x] = (int)(temp);
		}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}

	public static int[] CSetupA(int n, int numberOfClumps, String clumpDistribution)
	{
		String cd = clumpDistribution;
		
		int[]A=new int[n];
		for(int x=0; x<n; x++)
		{
			int nc = numberOfClumps;
			int mean=(int)(2000000000/(double)(n+1));
			int std=(int)(mean/(double)n);
			int spacing=0;
			double v1=0, v2=0, temp=0, s=0;
			
			if(cd.equalsIgnoreCase("u")){spacing = (int)(nc*Math.random()+1);}
			else if(cd.equalsIgnoreCase("n"))
			{
				v1=0; v2=0; temp=0; s=0;
				do{
				do{
				v1=2*(Math.random())-1;
				v2=2*(Math.random())-1;
				s=v1*v1 + v2*v2;
				}while(s>=1 || s==0);
				s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
				temp = v1*s;
				temp = ((nc/6)*temp)+(nc/2);
				}while(temp<0 || temp>nc);
				spacing = (int)(temp);
			}
			
			v1=0; v2=0; temp=0; s=0;
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = (std*temp)+(spacing*mean);
			}while(temp<0 || temp>2000000000);
			A[x] = (int)(temp);
		}
		
		int maxpos=0;
		for(int x=0; x<n; x++)
		{if(A[x]>A[maxpos]){maxpos=x;}}
		Swap(A, maxpos, n-1);
		
		int minpos=n-1;
		for(int x=0; x<n; x++)
		{if(A[x]<A[minpos]){minpos=x;}}
		Swap(A, minpos, 0);
		
		return A;	
	}
	
	public static int[] SetupB(int n)
	{
		int[]B=new int[n];
		B[0]=B[n-1]=1;
		return B;
	}
	
	public static int[] ADSetupB(int n)
	{
		int[]B=new int[2*n];
		B[0]=B[n-1]=1;
		return B;
	}
	
	public static int[] SetupR(int q, int n)
	{
		int[]R = new int[q+2];
		R[q+1]=n;
		return R;
	}
	
	public static int USelectQuerry(int n)
	{
		return (int)(n * Math.random());
	}
	
	public static int NSelectQuerry(int n)
	{
		int mean = n/2;
		int std = (int)(n*.341);
		
		double v1=0, v2=0, temp=0, s=0;
		do{
		do{
		v1=2*(Math.random())-1;
		v2=2*(Math.random())-1;
		s=v1*v1 + v2*v2;
		}while(s>=1 || s==0);
		s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
		temp = v1*s;
		temp = (std*temp)+mean;
		}while(temp<0 || temp>n);
		int total = (int)(temp);
		return total;
	}
	
	public static int CSelectQuerry(int n, int nc, String qcd)
	{
		
		int mean = n/(nc+1);
		int std = (int)(mean/nc);
		double v1=0, v2=0, temp=0, s=0;
		int spacing = 0;
		
		if(qcd.equalsIgnoreCase("u"))
		{
			spacing = (int)(nc*Math.random() + 1);
		}
		else if(qcd.equalsIgnoreCase("n"))
		{
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = ((nc/6)*temp)+(nc/2);
			}while(temp<0 || temp>nc);
			spacing = (int)(temp);
		}
		v1=0; v2=0; temp=0; s=0;
		
		do{
		do{
		v1=2*(Math.random())-1;
		v2=2*(Math.random())-1;
		s=v1*v1 + v2*v2;
		}while(s>=1 || s==0);
		s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
		temp = v1*s;
		temp = (std*temp)+(spacing*mean);
		}while(temp<0 || temp>n);
		int total = (int)(temp);
		return total;
	}
	
	public static int UQuerry()
	{
		return (int)(2000000000 * Math.random());
	}
	
	public static int NQuerry()
	{
		double v1=0, v2=0, temp=0, s=0;
		do{
		do{
		v1=2*(Math.random())-1;
		v2=2*(Math.random())-1;
		s=v1*v1 + v2*v2;
		}while(s>=1 || s==0);
		s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
		temp = v1*s;
		temp = (682000000*temp)+1000000000;
		}while(temp<0 || temp>2000000000);
		int total = (int)(temp);
		return total;
	}
	
	public static int CQuerry(int NumClumps, String type)
	{
		int n=NumClumps;
		int mean=(int)(2000000000/(double)(n+1));
		int std=(int)(mean/(double)n);
		double v1=0, v2=0, temp=0, s=0;
		int spacing=0;
		
		if(type.equalsIgnoreCase("u"))
		{
			spacing = (int)(n*Math.random()+1);
		}
		else if(type.equalsIgnoreCase("n"))
		{
			do{
			do{
			v1=2*(Math.random())-1;
			v2=2*(Math.random())-1;
			s=v1*v1 + v2*v2;
			}while(s>=1 || s==0);
			s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
			temp = v1*s;
			temp = ((n/6)*temp)+(n/2);
			}while(temp<0 || temp>n);
			spacing = (int)(temp);
		}
		
		
		
		v1=0; v2=0; temp=0; s=0;
		do{
		do{
		v1=2*(Math.random())-1;
		v2=2*(Math.random())-1;
		s=v1*v1 + v2*v2;
		}while(s>=1 || s==0);
		s=Math.sqrt((-2*Math.log(s)/Math.log(Math.E))/s);
		temp = v1*s;
		temp = (std*temp)+(spacing*mean);
		}while(temp<0 || temp>2000000000);
		int total = (int)(temp);
		return total;
	}
		
	public static int QuerryType(String qt)
	{
		if(qt.equalsIgnoreCase("s")){return 1;}
		if(qt.equalsIgnoreCase("io")){return 2;}
		if(qt.equalsIgnoreCase("do")){return 3;}
		if(qt.equalsIgnoreCase("hdi")){return 4;}
		if(qt.equalsIgnoreCase("adi")){return 5;}
		return 1;
	}
	//Querry Calls
	public static void Selection(int n, int q, int[]A, int[]B, int[]R, Count C, Count P, Count Q, String qd, int qnc, String qcd)
	{
		int Power=5;
		
		for(int z=1; z<q+1; z++)
		{
			int i = 0;
			do
			{
				if(qd.equalsIgnoreCase("u")){i=USelectQuerry(n);}
				else if(qd.equalsIgnoreCase("n")){i=NSelectQuerry(n);}
				else if(qd.equalsIgnoreCase("c")){i=CSelectQuerry(n, qnc, qcd);}
			}while(i==A[0] || i == A[n-1]);
			//int i = (int)(n*Math.random());
			R[z]=i;
			Select(A, B, C, i);
			if(z==Math.pow(2, Power))
			{
				P.count=PCount(B, n);
				Q.count=QCount(R, n, q);
				System.out.println("2^" + Power + " " + C.count + " " + Q.count + " " + P.count);
				Power++;
			}
		}
		
		P.count=PCount(B, n);
		Q.count=QCount(R, n, q);
		
		PrintResults(C.count, Q.count, P.count);
	}
	
	public static void Insert(int n, int q, int[]A, int[]B, int[]R, Count C, Count P, Count Q, String qd, int qnc, String qcd, int is)
	{
		int Power = 5;
		int code=1;//1=Binary, 2=Inter, 3=Mix
		for(int z=1; z<q+1; z++)
		{
			int y = 0;
			do
			{
				if(qd.equalsIgnoreCase("u")){y=UQuerry();}
				else if(qd.equalsIgnoreCase("n")){y=NQuerry();}
				else if(qd.equalsIgnoreCase("c")){y=CQuerry(qnc, qcd);}
			}while(y==A[0] || y == A[n-1]);
			
			int x=InsertSearch(A, B, C, y, n, code, z, is);
			R[z]=x;
			System.arraycopy(A, x, A, x+1, n-x);
			System.arraycopy(B, x, B, x+1, n-x);
			A[x]=y;
			B[x]=1;
			n++;
			
			if(z==Math.pow(2, Power))
			{
				P.count=PCount(B, n);
				Q.count=QCount(R, n, q);
				System.out.println("2^" + Power + " " + C.count + " " + Q.count + " " + P.count);
				Power++;
			}
		}
		
		P.count=PCount(B, n);
		Q.count=QCount(R, n, q);
		
		PrintResults(C.count, Q.count, P.count);
	}
	
	public static void Delete(int n, int q, int[]A, int[]B, int[]R, Count C, Count P, Count Q, String qd, int qnc, String qcd)
	{
		int Power = 5;
		int code=1;//1=Binary, 2=Inter, 3=Mix
		for(int z=1; z<q+1; z++)
		{
			int y = 0;
			do
			{
				if(qd.equalsIgnoreCase("u")){y=UQuerry();}
				else if(qd.equalsIgnoreCase("n")){y=NQuerry();}
				else if(qd.equalsIgnoreCase("c")){y=CQuerry(qnc, qcd);}
			}while(y==A[0] || y == A[n-1]);

			int x=DeleteSearch(A, B, C, y, n, code, z);
			R[z]=x;
			if(A[x]==y)
			{
				System.arraycopy(A, x, A, x-1, n-x);
				System.arraycopy(B, x, B, x-1, n-x);
				A[n]=0;
				B[n]=0;
				n--;
			}
			
			if(z==Math.pow(2, Power))
			{
				P.count=PCount(B, n);
				Q.count=QCount(R, n, q);
				System.out.println("2^" + Power + " " + C.count + " " + Q.count + " " + P.count);
				Power++;
			}
		}
		
		P.count=PCount(B, n);
		Q.count=QCount(R, n, q);
		
		PrintResults(C.count, Q.count, P.count);
	}
	
	public static void HalfDeleteInsert(int n, int q, int[]A, int[]B, int[]R, Count C, Count P, Count Q, String qd, int qnc, String qcd, int is)
	{
		int Power = 5;
		int code=1;//1=Binary, 2=Inter, 3=Mix
		for(int z=1; z<q+1; z++)
		{
			int y = 0;
			do
			{
				if(qd.equalsIgnoreCase("u")){y=UQuerry();}
				else if(qd.equalsIgnoreCase("n")){y=NQuerry();}
				else if(qd.equalsIgnoreCase("c")){y=CQuerry(qnc, qcd);}
			}while(y==A[0] || y == A[n-1]);

			
			if(z<(q/2))
			{
				int x=DeleteSearch(A, B, C, y, n, code, z);
				R[z]=x;
				if(A[x]==y)
				{
					System.arraycopy(A, x, A, x-1, n-x);
					System.arraycopy(B, x, B, x-1, n-x);
					A[n]=0;
					B[n]=0;
					n--;
				}
			}
			if(z>=(q/2))
			{
				int x=InsertSearch(A, B, C, y, n, code, z, is);
				R[z]=x;
				System.arraycopy(A, x, A, x+1, n-x);
				System.arraycopy(B, x, B, x+1, n-x);
				A[x]=y;
				B[x]=1;
				n++;
			}
			
			if(z==Math.pow(2, Power))
			{
				P.count=PCount(B, n);
				Q.count=QCount(R, n, q);
				System.out.println("2^" + Power + " " + C.count + " " + Q.count + " " + P.count);
				Power++;
			}
		}
		
		P.count=PCount(B, n);
		Q.count=QCount(R, n, q);
		
		PrintResults(C.count, Q.count, P.count);
	}
	
	public static void AltDeleteInsert(int n, int q, int[]A, int[]B, int[]R, Count C, Count P, Count Q, String qd, int qnc, String qcd, int is)
	{
		int Power = 5;
		int code=1;//1=Binary, 2=Inter, 3=Mix
		for(int z=1; z<q+1; z++)
		{
			int y = 0;
			do
			{
				if(qd.equalsIgnoreCase("u")){y=UQuerry();}
				else if(qd.equalsIgnoreCase("n")){y=NQuerry();}
				else if(qd.equalsIgnoreCase("c")){y=CQuerry(qnc, qcd);}
			}while(y==A[0] || y == A[n-1]);

			
			if(z%2==1)
			{
				int x=DeleteSearch(A, B, C, y, n, code, z);
				R[z]=x;
				if(A[x]==y)
				{
					System.arraycopy(A, x, A, x-1, n-x);
					System.arraycopy(B, x, B, x-1, n-x);
					A[n]=0;
					B[n]=0;
					n--;
				}
			}
			if(z%2==0)
			{
				int x=InsertSearch(A, B, C, y, n, code, z, is);
				R[z]=x;
				System.arraycopy(A, x, A, x+1, n-x);
				System.arraycopy(B, x, B, x+1, n-x);
				A[x]=y;
				B[x]=1;
				n++;
			}
			
			if(z==Math.pow(2, Power))
			{
				P.count=PCount(B, n);
				Q.count=QCount(R, n, q);
				System.out.println("2^" + Power + " " + C.count + " " + Q.count + " " + P.count);
				Power++;
			}
		}
		
		P.count=PCount(B, n);
		Q.count=QCount(R, n, q);
		
		PrintResults(C.count, Q.count, P.count);
	}
	
	//SELECT
	public static int Select(int[]A, int[]B, Count C, int i)
	{
		if(B[i]==1)
			{return A[i];}
		else
		{
			int left=i; int right=i;
			while(B[left]==0){left--;} 
			while(B[right]==0){right++;}
			left++; right--;
			return RSelect(A, B, C, i, left, right);
		}	
	}
	
	public static int RSelect(int[]A, int[]B, Count C, int i, int left, int right)
	{
		if(left==right)
		{
			B[left]=1;
			return A[left];
		}
		int med=(left + right)/2;
		C.count++;
		if(A[med]<A[left]){int temp = A[med];A[med]=A[left];A[left]=temp;}
		C.count++;
		if(A[right]<A[left]){int temp = A[right];A[right]=A[left];A[left]=temp;}
		C.count++;
		if(A[right]<A[med]){int temp = A[med];A[med]=A[right];A[right]=temp;}
		
		//Partition about the Median element
		int pivotValue=A[med];
		Swap(A, med, right);
		int storeIndex=left;
		for(int j=left; j<right; j++)
		{
			C.count++;
			if(A[j]<pivotValue)
			{
				Swap(A, j, storeIndex);
				storeIndex++;
			}
		}
		Swap(A, storeIndex, right);
		
		B[storeIndex]=1; //Mark Pivot found from Partitioning
								
		//Determine which interval to recurse on
		if(i<storeIndex)
			return RSelect(A, B, C, i, left, storeIndex-1);
		else if(i>storeIndex)
			return RSelect(A, B, C, i, storeIndex+1, right);
		else
			return A[storeIndex];
	}
	//SEARCH
	public static int Search(int[]A, int[]B, Count C, int y, int n, int code)
	{
		int len=n;
		C.count++;
		if(y<=A[0]){return 0;}
		C.count++;
		if(y>A[len-1]){return len;}
		C.count++;
		if(y==A[len-1]){return len-1;}
		
		int left=0; int right=len-1; int SPos=0;
		
		while(left+1<right)
		{
			if(code==1)
			{SPos=BinarySearch(left, right);}
			else if(code==2)
			{	
				SPos=InterSearch(A, left, right, y);
				if(SPos<(left-1) || SPos>(right+1))
				{
					left=right=SPos;
					return SSelect(A, B, C, y, left, right);
				}
			}
			C.count++;C.count++;
			if(y<A[SPos]){C.count--; right=SPos-1;}
			else if(y>A[SPos]){left=SPos+1;}
			else {left=right=SPos;}
		}
			
		return SSelect(A, B, C, y, left, right);	
		
	}
	
	public static int InsertSearch(int[]A, int[]B, Count C, int y, int n, int code, int z, int is)
	{
		int len=n;
		C.count++;
		if(y<=A[0]){return 0;}
		C.count++;
		if(y>A[len-1]){return len;}
		C.count++;
		if(y==A[len-1]){return len-1;}
		
		int left=0; int right=len-1; int SPos=0;
		
		while(left+1<right)
		{
			if(code==1)
			{SPos=BinarySearch(left, right);
			//Print("Spos", SPos); Print();
			}
			else if(code==2)
			{	
				SPos=InterSearch(A, left, right, y);
				int m = (int)((A[right]-A[left])/(double)(right-left));
				if(m<0)
				{break;}
				if(SPos<(left/*-1*/) || SPos>(right/*+1*/))//CHANGED
				{
					//left=right=SPos;
					//return SSelect(A, B, C, y, left, right);
					break;
				}
			}
			else if(code==3)
			{
				if(z>.25*n)
				{
					SPos=InterSearch(A, left, right, y);
					int m = (int)((A[right]-A[left])/(double)(right-left));
					if(m<0)
					{break;}
					if(SPos<(left/*-1*/) || SPos>(right/*+1*/))//CHANGED
					{
						//left=right=SPos;
						//return SSelect(A, B, C, y, left, right);
						break;
					}
				}
				else
				{
					SPos=BinarySearch(left, right);
				}
			}
			
			C.count++;C.count++;
			if(y<A[SPos]){C.count--; right=SPos-1;}
			else if(y>A[SPos]){left=SPos+1;}
			else {left=right=SPos;}
		}
		
		if(is==0)
		{
			if(right==0)
				return 1;
			while(B[right]==0){right++;} 
			right--;
			return right;
		}
		else
		{
			return SSelect(A, B, C, y, left, right);
		}
		
	}

	public static int DeleteSearch(int[]A, int[]B, Count C, int y, int n, int code, int z)
	{
		int len=n;
		//Print(len); Print();
		C.count++;
		if(y<=A[0]){return 0;}
		C.count++;
		if(y>A[len-1]){return len;}
		C.count++;
		if(y==A[len-1]){return len-1;}
		
		int left=0; int right=len-1; int SPos=0;
		
		while(left+1<right)
		{
			if(code==1)
			{SPos=BinarySearch(left, right);
			//Print("Spos", SPos); Print();
			}
			else if(code==2)
			{	
				SPos=InterSearch(A, left, right, y);
				int m = (int)((A[right]-A[left])/(double)(right-left));
				if(m<0)
				{break;}
				if(SPos<(left) || SPos>(right))
				{
					//left=right=SPos;
					//return SSelect(A, B, C, y, left, right);
					break;
				}
			}
			else if(code==3)
			{
				if(z>.25*n)
				{
					SPos=InterSearch(A, left, right, y);
					int m = (int)((A[right]-A[left])/(double)(right-left));
					if(m<0)
					{break;}
					if(SPos<(left/*-1*/) || SPos>(right/*+1*/))//CHANGED
					{
						//left=right=SPos;
						//return SSelect(A, B, C, y, left, right);
						break;
					}
				}
				else
				{
					SPos=BinarySearch(left, right);
				}
			}
			/*
			Print(left);
			System.out.print(" ");
			Print(right);
			Print();
			*/
			C.count++;C.count++;
			if(y<A[SPos]){C.count--; right=SPos-1;}
			else if(y>A[SPos]){left=SPos+1;}
			else {left=right=SPos;}
		}
		/*
		Print(left);
		System.out.print(" ");
		Print(right);
		Print();
		*/
		return SSelect(A, B, C, y, left, right);	
		
	}
	
	public static int SSelect(int[]A, int[]B, Count C, int y, int left, int right)
	{
		while(B[left]==0){left--;} 
		while(B[right]==0){right++;}
		left++; right--;
		
		C.count++;
		if(y==A[left-1]){return left-1;}
		C.count++;
		if(y==A[right+1]){return right+1;}
		
		return RSSelect(A, B, C, y, left, right);
	}
	
	public static int RSSelect(int[]A, int[]B, Count C, int y, int left, int right)
	{
		while(true)
		{
			if(left>=right || left+1==right)
			{
				//System.out.println(left);
				int pos=left;//CHANGED
				//System.out.println(B[pos-1] + " " + B[pos] + " " + B[pos+1]);
				return RSSelectTerminate(A, B, C, y, pos);
			}
			int med=(left + right)/2;
			C.count++;
			if(A[med]<A[left]){int temp = A[med];A[med]=A[left];A[left]=temp;}
			C.count++;
			if(A[right]<A[left]){int temp = A[right];A[right]=A[left];A[left]=temp;}
			C.count++;
			if(A[right]<A[med]){int temp = A[med];A[med]=A[right];A[right]=temp;}
			
			//Partition about the Median element
			int pivotValue=A[med];
			Swap(A, med, right);
			int storeIndex=left;
			for(int j=left; j<right; j++)
			{
				C.count++;
				if(A[j]<pivotValue)
				{
					Swap(A, j, storeIndex);
					storeIndex++;
				}
			}
			Swap(A, storeIndex, right);
			
			B[storeIndex]=1; //Mark Pivot found from Partitioning
									
			//Determine which interval to recurse on
			C.count++;
			//System.out.println(left+ " " + right + " " + storeIndex);
			//System.out.println(A[left] + " " + A[right] +" " + A[storeIndex] + " " + y);
			if(y<A[storeIndex])
				{
					//return RSSelect(A, B, C, y, left, storeIndex-1); 
					right=storeIndex-1;
				}
			else
				{
					//return RSSelect(A, B, C, y, storeIndex+1, right);
					left=storeIndex+1;
				}
		}
	}
	
	public static int RSSelectTerminate(int[]A, int[]B, Count C, int y, int pos)
	{
		if(B[pos]==0)
		{
			//System.out.println("************");
		
			if(B[pos-1]==1 && B[pos+1]==1)
			{
				//System.out.println("*********************");
				B[pos]=1;
				C.count++;
				if(y<A[pos])
					return pos;
				else
					return pos+1;
			}
			else
				return pos;
		}
		else
		{
			C.count++;
			if(y<A[pos])
				return pos;
			else
				return pos+1;
		}
		
	}
	//HELPER SEARCH
	public static int BinarySearch(int left, int right)
	{
		return (left+right)/2;
	}
	
	public static int InterSearch(int[]A, int l, int r, int y)
	{
		int m = (int)((A[r]-A[l])/(double)(r-l));
		int x = (int)((y-A[l])/(double)m) + 1;
		//System.out.println(l+ " " + A[l] + " " + r + " " + A[r] + " " + y);
		//System.out.println(m); System.out.println(x);
		return x;
	}
	//GENERAL
	public static int PCount(int[]B, int n)
	{
		long BonP = (long)(n*Math.log(n)/Math.log(2)); //BonP represents the lower bound of finding Pivots.
		long IL=0;
		for(int z=1; z<n;z++)
		{
			if(B[z]==0)
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
		return (int)(BonP);
	}
	
	public static int QCount(int[]R, int n, int q)
	{
		int [] R1 = new int[q+2];
		for (int z = 0; z < q+2; z++)
			R1[z] = R[z];
		Arrays.sort(R1); //Sorts Queries
		long BonQ=(long)(n*Math.log(n)/Math.log(2)); //BonQ represents the lower bound of finding the Q queries
		for(int z=1; z<q+2; z++)
			BonQ-=(long)((R1[z]-R1[z-1])*((Math.log(R1[z]-R1[z-1])/Math.log(2))));
		return (int)(BonQ);
	}
	
	public static void CPrint(int x)
	{
		int numDig = (int)(Math.ceil((Math.log(x)/Math.log(10))));
		int sections = (int)(Math.ceil(numDig/(double)3));
		int[]hold = new int[sections+1];
		hold[sections]=0;
		for(int z=sections-1; z>-1; z--)
		{
			int y = x-hold[z+1];
			hold[z]=(int)(y%(Math.pow(10, 3*(sections-z))))/(int)(Math.pow(10, 3*(sections-z-1)));
		}
		for(int z=0; z<sections-1; z++)
			System.out.print(hold[z] + ",");
		System.out.print(hold[sections-1]);
	}
	
	public static void PrintResults(int C, int Q, int P)
	{
		System.out.println("");
		System.out.println("  Count:       BonQ:        BonP:");
		//System.out.println("");
		CPrint(C);
		System.out.print("   ");
		CPrint(Q);
		System.out.print("   ");
		CPrint(P);
		
	}
	
	public static void Print(int[]A)
	{
		for(int z = 0; z<A.length; z++)
		{
			System.out.print(A[z] + " ");
		}
	}
	
	public static void Print(int A)
	{
		System.out.print(A);
	}
	
	public static void Print()
	{
		System.out.println();
	}
	
	public static void Print(String s, int A)
	{
		System.out.print(s +" " + A);
	}
	
	public static void Print(String s)
	{
		System.out.println(s);
	}
	
	public static void PrintTime(double time)
	{
		//System.out.println(time);
		double dec = time%1;
		int temp=(int)(time);
		//System.out.println(temp);
		int seconds = temp%60;
		//System.out.println(seconds);
		int tempmins=temp-seconds;
		int mins=tempmins/60;
		double combineseconds = (double)seconds + dec;
		//System.out.println(combineseconds);
		//System.out.println(mins + " min " + seconds+dec + " s");
		System.out.println(mins + " min " + combineseconds + " s");
		}
	
	
	
	
}
