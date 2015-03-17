package com.assembly.line.pk;

public class Assembly_line {
	
	public int cost; //final cost of destination
	public int assembly_line; //assembly line through which we reach
	
	public void Fastest_Way(int a[][],int t[][],int e1,int e2,int x1,int x2,int n,int lines) {
		
		int f1[] = new int[n];	//line1
		int f2[] = new int[n];	//line2
		int l1[] = new int[n];
		int l2[] = new int[n];
		
		//printing time spent at station
		for(int i=0;i<lines;i++) {
			for(int j=0; j<n;j++) {
				System.out.print( a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//print values time required to make a switch from a station on one line to the other
		for(int i=0;i<lines;i++) {
			for(int j=0; j<n;j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		f1[0] = e1 + a[0][0];
		System.out.println("Station 1 starting: " + f1[0]);
		
		f2[0] = e2 + a[1][0];
		System.out.println("Station 2 starting: " + f2[0]);
		System.out.println();

		for(int j=1; j<n; j++) {
			if((f1[j-1] + a[0][j]) <= (f2[j-1] + t[1][j-1] + a[0][j])) { // checking weather it has to switch line or not
				f1[j] = f1[j-1] + a[0][j]; //same line so only adding station time
				l1[j] = 1;
			}
			else {
				f1[j] = f2[j-1] + t[1][j-1] + a[0][j]; //switching line so time to switch line added
				l1[j] = 2;	// line switched
			}

			if((f2[j-1] + a[1][j]) <= (f1[j-1] + t[0][j-1] + a[1][j])) { //checking the other line weather it has to switch line or not
				f2[j] = f2[j-1] + a[1][j]; //same line so only adding station time
				l2[j] = 2;
			}
			else {
				f2[j] = f1[j-1] + t[0][j-1] + a[1][j]; //switching line so time to switch line added
				l2[j] = 1;			// line switched
			}
		}

		if((f1[n-1] + x1) <= (f2[n-1] + x2)) { // now finally checking which line gives min cost
			cost = f1[n-1] + x1; //if the above condition satisfied then final cost added
			assembly_line = 1; // final cost through assembly line 1
		}

		else {
			cost = f2[n-1] + x2; //min final cost
			assembly_line = 2; // final cost through assembly line 1
		}

		System.out.println("Final cost: "+cost);
		System.out.println("Assembly line: " + assembly_line);
	}
}
