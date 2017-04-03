import java.util.*;



public class AltInsertDelete extends Methods{

	
	public static void main(String[] args) {
		
		int[]A={}, B={}, R={};
		
		//Initial User Input
		int n=0, ad=0, enc=0, qnc=0;
		String ed="", ecd="", qd="", qcd="";
		Scanner kb = new Scanner(System.in);
		Print("How many Elements are in the Array?");
		n= kb.nextInt();
		Print("Is the program using Array Doubling? 1 = Yes, 0 = No ");
		ad= kb.nextInt();
		ad= 1; /*Default*/
		Print("How are the elements Distributed? U = Uniform, N = Normal, C = Clumps ");
		ed=kb.next();
		if(ed.equalsIgnoreCase("c"))
		{
			Print("How many Element clumps are there?");
			enc=kb.nextInt();
			Print("How is the Element Clump Spacing Distributed? U = Uniform, N = Normal");
			ecd=kb.next();
		}
		Print("How are the Querries distributed? U = Uniform, N = Normal, C = Clumps ");
		qd=kb.next();
		if(qd.equalsIgnoreCase("c"))
		{
			Print("How many Querry clumps are there?");
			enc=kb.nextInt();
			Print("How is the Querry Clump Spacing Distributed? U = Uniform, N = Normal");
			ecd=kb.next();
		}
		Print();
		
		
		
		
		
		//Set-Up
		int q=(int)(Math.pow(2, (int)(Math.log(n)/Math.log(2))));
		if(ad==1)
		{
			if(ed.equalsIgnoreCase("u")){A=UADSetupA(n); B=ADSetupB(n); R=SetupR(q,n);}
			else if(ed.equalsIgnoreCase("n")){A=NADSetupA(n); B=ADSetupB(n); R=SetupR(q,n);}
			else if(ed.equalsIgnoreCase("c")){A=CADSetupA(n,enc,ecd); B=ADSetupB(n); R=SetupR(q,n);}
			else{Print("Please Start Over... Sorry");}
		}
		else
		{
			if(ed.equalsIgnoreCase("u")){A=USetupA(n); B=SetupB(n); R=SetupR(q,n);}
			else if(ed.equalsIgnoreCase("n")){A=NSetupA(n); B=SetupB(n); R=SetupR(q,n);}
			else if(ed.equalsIgnoreCase("c")){A=CSetupA(n,enc,ecd); B=SetupB(n); R=SetupR(q,n);}
			else{Print("Please Start Over... Sorry");}
		}
		
		
		//int[]A=NADSetupA(n), B=ADSetupB(n), R=SetupR(q,n);
		Count C=new Count(); Count P=new Count(); Count Q=new Count();
		C.count+=2*n;
		int Power=5;
		
		
		
		
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
			
			
			if(z%2==0)
			{
				int x=InsertSearch(A, B, C, y, n, code, z);
				R[z]=x;
				System.arraycopy(A, x, A, x+1, n-x);
				System.arraycopy(B, x, B, x+1, n-x);
				A[x]=y;
				B[x]=1;
				n++;
			}
			else
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

}
