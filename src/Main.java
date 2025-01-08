import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Input a number from 0 to 999");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            // Check if the input is an integer string
            char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
            for (int i = 0; i < input.length(); i++) {
                boolean charCheck = false;
                for (int j = 0; j<10; j++) {
                    if (input.charAt(i) == (numbers[j])) {
                        charCheck = true;
                        //checks if actually integer in the string
                        break;
                        //saves time
                    }
                }
                if (!charCheck) throw new Error("This is not a number!");
            }
            if (Integer.parseInt(input) > 999 || Integer.parseInt(input) < 0){
                throw new Error("Your number doesn't fit within in the parameters!");
                //checks if user can read
            }
            //only takes integers
            System.out.println(numToEng(Integer.parseInt(input)));
        }
    }
    public static String numToEng(int num){
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