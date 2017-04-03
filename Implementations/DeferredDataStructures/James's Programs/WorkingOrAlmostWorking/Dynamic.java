import java.util.*;



public class Dynamic extends Methods{

	
	public static void main(String[] args) {
		
		int[]A={}, B={}, R={};
		
		//Initial User Input
		int n=0, ad=0, enc=0, qnc=0, is=0;
		String ed="", ecd="", qd="", qcd="", qt="";
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
		Print("What kind of Querries? \nS = Selection, IO = Inserts Only, DO = Deletes Only, HDI = q/2 Deletes then q/2 Inserts, ADI = Alternating Delete Inserts");
		qt=kb.next();
		if(!qt.equalsIgnoreCase("s"))
		{
			Print("Use selections with Insert Search? 1 for yes, 0 for no ");
			is=kb.nextInt();
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
		
		Count C=new Count(); Count P=new Count(); Count Q=new Count();
		C.count+=2*n;
		
		
		int nqt = QuerryType(qt);
		long time1= System.currentTimeMillis();
		switch (nqt){
		case 1: Selection(n, q, A, B, R, C, P, Q, qd, qnc, qcd); break;
		case 2: Insert(n, q, A, B, R, C, P, Q, qd, qnc, qcd, is); break;
		case 3: Delete(n, q, A, B, R, C, P, Q, qd, qnc, qcd); break;
		case 4: HalfDeleteInsert(n, q, A, B, R, C, P, Q, qd, qnc, qcd, is); break;
		case 5: AltDeleteInsert(n, q, A, B, R, C, P, Q, qd, qnc, qcd, is); break;
		}
		Print();
		double time = (double)((System.currentTimeMillis()-time1)*.001);
		PrintTime(time);
		
	}
}
