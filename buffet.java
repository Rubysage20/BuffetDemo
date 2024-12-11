/* Name: Valerie Dawson
 * Overview: Demonstrates the functionality of the buffet system. It interacts
 * with the user to gather input information about the buffet, including the name
 * and zipcode. Then enters a while loop where the user can input the number of meals
 * for adults and childern. The program calculates the cost,tax, and total bill using 
 * The bill class. Then displays the buffet info.
 * Input: String buffetname, string buffetzipcode, int ofadult&kids meals
 * Output:
 * Variables: 
 * 
 * 
 */
import java.util.Scanner;

public class BuffetDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
            // Request the name and zip code of the buffet from the user
            System.out.print("Enter the buffet name: ");
            String buffetName = scan.nextLine();

            System.out.print("Enter the buffet zip code: ");
            String zipCode = scan.nextLine();

            // Use the Buffet class to set the buffet name and location
            Buffet buffet = new Buffet();
            buffet.setName(buffetName);
            buffet.setLocation(zipCode);
           

            // Start the while loop
            while (true) {
                // Request the number of meals for adults and children
                System.out.print("Enter the number of adult meals (-1 to exit): ");
               int adultMealQty = scan.nextInt();
                if (adultMealQty == -1) {
                    break;
                }

                System.out.print("Enter the number of child meals: ");
                int childMealQty = scan.nextInt();
                
                // Use the Bill class to instantiate adultBill and childBill objects
                Bill adultBill = new Bill(adultMealQty);
                Bill childBill = new Bill(childMealQty);

                // Use the Bill class to calculate the adult and child costs
                double adultCost = adultBill.calcAdultCost();
                double childCost = childBill.calcChildCost();
                
                // Calculate the tax
                double adultTax = Bill.calcTax(adultCost);
                double childTax = Bill.calcTax(childCost);

                // Totals the costs
                double totalAdultCost = adultCost + adultTax; 
                double totalChildCost = childCost + childTax;
                double total = adultTax + childTax;

                // Display buffet information
                System.out.println("Buffet:" + buffet.toString());

                // Display adult and child costs
                System.out.println("Adult Costs:");
                System.out.println("Meal Quantity:" + adultBill);
                System.out.println("Total Cost:" + totalAdultCost);
                System.out.println();
                
                System.out.println("Child Costs:");
                System.out.println("Meal Quantity:" +childBill);
                System.out.println("Total Cost:" + totalChildCost);
                System.out.println();

                // Display subtotal
                System.out.printf("Subtotal: $%.2f\n" + (adultCost + childCost));

                // Display tax
                System.out.printf("Tax: $%.2f\n", Bill.TAXRATE + total);

                // Display total
                System.out.printf("Total: $%.2f\n", ( adultCost + childCost)/total);
            }
            
        }
