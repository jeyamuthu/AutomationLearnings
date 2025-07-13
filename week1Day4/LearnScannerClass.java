package week1Day4;

import java.util.*;

public class LearnScannerClass {

	public int sum(int a,int b)
	{
		return a+b;
	}
	public int multiply(int a,int b)
	{
		return a*b;
	}
	public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
     int a = s.nextInt();
     int b = s.nextInt();
     LearnScannerClass l = new LearnScannerClass();
     System.out.println(l.sum(a, b));
     System.out.println (l.multiply(a, b));
     

	}

}
