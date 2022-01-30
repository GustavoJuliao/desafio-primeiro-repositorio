package desafios_iniciais;
import java.util.Scanner;
public class desafio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int C = sc.nextInt();
		if (L % 2 == C % 2) System.out.println(1);
		//if((     )     ==0)    	System.out.println(1);
        else
	        	System.out.println(0);
		sc.close();
	}

}
