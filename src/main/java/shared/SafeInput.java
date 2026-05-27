package shared;

import java.util.Scanner;

public class SafeInput {
    private static final Scanner read = new Scanner(System.in);
    public static int SafeInt(){
        String input;
        do {
            System.out.println("Digite um número inteiro:  ");
            input = read.nextLine();
        } while(!input.matches("\\d+"));
        return Integer.parseInt(input);
    }
    public static int SafeRangeInt(int min, int max){
        int actual;
        do{
            actual = SafeInt();
            if(actual < min && actual > max){
                System.out.println("Digite um valor maior que " + min + " e menor que " + max);
            }
        } while(actual < min && actual > max);
        return actual;
    }
    public static String SafeString() {
        return read.nextLine();
    }
}
