

import java.util.Scanner;

class prefinalsActivity1
{

    public enum hundreds {OneHundred, TwoHundred, ThreeHundred, FourHundred, FiveHundred, SixHundred, SevenHundred, EightHundred, NineHundred}
    public enum tens {Twenty, Thirty, Forty, Fifty, Sixty, Seventy, Eighty, Ninety}
    public enum ones {One, Two, Three, Four, Five, Six, Seven, Eight, Nine}
    public enum denom {Thousand, Lakhs, Crores}
    public enum splNums { Ten, Eleven, Twelve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen}
    public static String text = "";

    public static void main(String[] args) 
    {
        System.out.println("Enter a Number to convert into words");
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        int rem = 0;
        int i = 0;
        while(num > 0)
        {
            if(i == 0){
                rem = (int) (num % 1000);
                printText(rem);
                num = num / 1000;
                i++;
            }
            else if(num > 0)
            {
                rem = (int) (num % 100);
                if(rem > 0)
                    text = denom.values()[i - 1]+ " " + text;
                printText(rem);
                num = num / 100;
                i++;
            }
        }
        // if the input is zero then it will be 'zero'
        if(i > 0)
            System.out.println(text);
        else
            System.out.println("Zero");
    }

    public static void printText(int num)
    	// printing the text
    {
        if(!(num > 9 && num < 19))
        {
            if(num % 10 > 0)
                getOnes(num % 10);

            num = num / 10;
            if(num % 10 > 0)
                getTens(num % 10);

            num = num / 10;
            if(num > 0)
                getHundreds(num);
        }
        else
        {
            getSplNums(num % 10);
        }
    }
    // get the numbers
    public static void getSplNums(int num)
    {
        text = splNums.values()[num]+ " " + text;
    }

    public static void getHundreds(int num)
    {
        text = hundreds.values()[num - 1]+ " " + text;
    }

    public static void getTens(int num)
    {
        text = tens.values()[num - 2]+ " " + text;
    }

    public static void getOnes(int num)
    {
        text = ones.values()[num - 1]+ " " + text;
    }
}