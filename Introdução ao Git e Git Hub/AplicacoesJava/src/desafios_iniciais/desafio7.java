package desafios_iniciais;
import java.util.Scanner;
public class desafio7 {
/*Fases da Lua*/
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        int inicio = leitor.nextInt();
        int fim = leitor.nextInt();
        
        if (inicio >= 0 && fim <= 2) {
            System.out.println("nova");
        } 
        else if (fim > inicio && fim <= 96) {
            System.out.println("crescente");
        } else if (inicio > fim  && fim <= 100) {
            System.out.println("minguante");
        } else { 
            System.out.println("cheia");
        }

    }

}
