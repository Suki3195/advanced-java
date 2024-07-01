package codingQuestions;

public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 2002;
        int med_num=num;
        int rev_num = 0;

        while (med_num>0){
            rev_num = rev_num*10 + med_num%10;
            med_num=med_num/10;
        }
        System.out.println(" reverse number = " + rev_num);
        if(rev_num==num){
            System.out.println(" Palindrome Number");

        }

    }
}
