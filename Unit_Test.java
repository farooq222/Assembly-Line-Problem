package com.assembly.line.pk;

public class Unit_Test {
	
	static int n = 6; //total number of stations
	static int lines = 2; //this is for 2 assembly lines
	static int a[][] = {{7,9,3,4,8,4}, {8,5,6,4,5,7}}; //its the time spent at Station Si,j
	static int t[][] = {{0,2,3,1,3,4}, {0,2,1,2,2,1}}; //its the time required to make a switch from a station on one line to the other
	static int e1 = 2; //its the entry time of a chases in a line
	static int e2 = 4;	//its the entry time of a chases in a line
	static int x1 = 3; //its the exit time of a complete car from a line
	static int x2 = 3; //its the exit time of a complete car from a line
	
	public static void main(String[] args) {
		Assembly_line line = new Assembly_line();
		line.Fastest_Way(a,t,e1,e2,x1,x2,n,lines);
		
		if(line.cost == 38 && line.assembly_line ==1){
			System.out.println();
			System.out.println("Unit test: Pass.");
		}
		else{
			System.out.println("Unit test: Fail.");
		}
		
	}
}
