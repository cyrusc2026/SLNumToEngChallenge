import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input a number from 0 to 999");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        //only takes integers
        System.out.println(numToEng(input));
    }
    public static String numToEng(int num){
        if (num > 999 || num < 0){
            System.out.println("Your number doesn't fit within in the parameters");
            System.exit(13);
        }
        String answer = "";
        String[] units = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        //index = number represented
        String[] tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        //empty space as placeholder for cases where this array won't be used (0 doesn't have a tens unit and 1 is covered by the ones array)
        String[] ones = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        int unit = num%10;
        int ten = (num/10)%10;
        int hundred = (num/100);
        //splits all to individual units
        if (unit == 0 && ten == 0 && hundred == 0) return "zero";
        //need to return here so that it won't break algorithm
        if (hundred != 0){
            // check if there is a hundred place
            answer += (units[hundred] + " hundred ");
        }
        if (ten == 1){
            //need to make separate case for number for 10<19 as they don't follow normal conventions such as "twenty one" instead have "eleven"
            answer += ones[unit];
            return answer;
            //directly takes from the ones Array and returns at it already covers the zero digit
        } else if (ten > 1){
            answer += (tens[ten] +" ");
        }
        if (unit != 0){
            answer += (units[unit]);
        }
        return answer;
    }
}