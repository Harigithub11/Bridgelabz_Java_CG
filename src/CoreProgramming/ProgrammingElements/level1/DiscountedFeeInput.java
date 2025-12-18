package CoreProgramming.ProgrammingElements.level1;

import java.util.Scanner;

public class DiscountedFeeInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the fee: ");

        double fee = input.nextDouble();
        
        System.out.print("Enter the discount Percentage: ");
        double discountPercent = input.nextDouble();

        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        System.out.println(
            "The discount amount is INR " + discount +
            " and final discounted fee is INR " + finalFee
        );

        input.close();
    }
}
