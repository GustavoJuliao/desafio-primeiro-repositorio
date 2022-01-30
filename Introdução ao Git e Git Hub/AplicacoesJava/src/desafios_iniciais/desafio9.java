package desafios_iniciais;
import java.io.IOException;
import java.util.Scanner;
public class desafio9 {

    public static void main(String[] args) throws IOException {
    	Scanner leitor = new Scanner(System.in);
    	int senha = leitor.nextInt();
        while(senha != 2002){
          System.out.println("Senha Invalida");
    	    senha = leitor.nextInt();
        }
      System.out.println("Acesso Permitido");
      
    }

}
