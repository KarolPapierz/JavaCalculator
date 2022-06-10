import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to another calculator!\n");

        System.out.println("Please type out an operation:\n(commands will execute left to right regardless of order of operations)\n");
        Scanner scanner = new Scanner(System.in);
        String equasion = scanner.nextLine();
        System.out.println("Answer to the equasion " + calculate(equasion));
    }
    public static double calculate(String equasion){

        String[] numbers = equasion.split("[+-/*]");//zapisujemy liczby do tablicy
        String[] operators = equasion.split("[0123456789]");//zapisujemy operatory do tablicy

        System.out.println(Arrays.toString(numbers));//wypisujemy znalezione liczby
        System.out.println(Arrays.toString(operators));//wypisujemy znalezione operatory
        double answer = Integer.parseInt(numbers[0]);//ustawiam piwerszy element jako punkt startowy odpowiedzi
        numbers = Arrays.copyOfRange(numbers,1, numbers.length);//usuwam pierwszy element z tablicy
        int m=1;//licznik dla operatorow zaczynam od drugiego elementu
        for(int i = 0; i< numbers.length;i++) {
            switch (operators[m]) {
                case "+":
                    System.out.println(answer+ "+" + Integer.parseInt(numbers[i]));
                    answer += Integer.parseInt(numbers[i]);
                    break;
                case "-":
                    System.out.println(answer+ "-" + Integer.parseInt(numbers[i]));
                    answer -= Integer.parseInt(numbers[i]);
                    break;
                case "*":
                    System.out.println(answer+ "*" + Integer.parseInt(numbers[i]));
                    answer *= Integer.parseInt(numbers[i]);
                    break;
                case "/":
                    System.out.println(answer+ "/" + Integer.parseInt(numbers[i]));
                    answer /= Integer.parseInt(numbers[i]);
                    break;
            }
            if(m< operators.length-1) {
                m++;//iterujemy m dopuki sa operatory w tablicy
            }
        }



        return answer;
    }

}