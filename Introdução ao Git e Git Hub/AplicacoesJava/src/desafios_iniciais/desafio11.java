package desafios_iniciais;

import java.util.Scanner;
public class desafio11 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] TOPS = {1, 3, 5, 10, 25, 50, 100};
        int k = scan.nextInt();
        int resultado=0;
        
        if(k == 1){
          resultado = 1;
        }else if(k>1 && k<=3){
          resultado = 3;
        }else if(k>3 && k<=5){
          resultado = 5;
        }else if(k>5 && k<=10){
          resultado = 10;
        }else if(k>10 && k<=25){
          resultado = 25;
        }else if(k>25 && k<=50){
          resultado = 50;
        }else if(k>50 && k<=100){
          resultado = 100;
        }
        System.out.println("Top "+ resultado);
      
    }

}
