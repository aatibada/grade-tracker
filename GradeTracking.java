/*
Ahyana Atiba-Davies and James Jin
April 23, 2023
This program will assist students in their grade tracking/estimating needs. 
*/
import java.util.Scanner;

public class GradeTracking {
   // Main method (Ahyana Atiba-Davies)
   public static void main(String [] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Welcome to our Grade Tracker!");
      System.out.println("This program will help you assess your current grade in a course and the score needed on your final to obtain your desired final grade.\n");
      
      // Create hw array, prompt user to its enter weight, and prompt user to enter hw grades
      System.out.print("Please enter the number of homework assignments you have had: ");
      int hNum = input.nextInt();
      double hAsgmt [] = new double[hNum];
      System.out.print("Please enter the weight of your homework assignments in decimal format (ex: 20% = 0.20): ");
      double hWgt = input.nextDouble();
      for (int i = 0; i < hAsgmt.length; i++) {
         System.out.printf("Please enter the percentage grade you received for homework #%d: ", i + 1);
         hAsgmt[i] = input.nextDouble();
      }
      
      // Create quiz array, prompt user to its enter weight, and prompt user to enter quiz grades
      System.out.print("Please enter the number of quizzes you have had: ");
      int qNum = input.nextInt();
      double qAsgmt [] = new double[qNum];
      System.out.print("Please enter the weight of your quizzes in decimal format (ex: 20% = 0.20): ");
      double qWgt = input.nextDouble();
      for (int i = 0; i < qAsgmt.length; i++) {
         System.out.printf("Please enter the percentage grade you received for quiz #%d: ", i + 1);
         qAsgmt[i] = input.nextDouble();
      }
      
      // Create midterm array, prompt user to its enter weight, and prompt user to enter midterm grade
      double mAsgmt [] = new double[1];
      System.out.print("Please enter the weight of your midterm in decimal format (ex: 20% = 0.20): ");
      double mWgt = input.nextDouble();
      System.out.print("Please enter the percentage grade you received on your midterm: ");
      mAsgmt[0] = input.nextDouble();
      
      // Create project array, prompt user to its enter weight, and prompt user to enter project grade
      double pAsgmt [] = new double[1];
      System.out.print("Please enter the weight of your project in decimal format (ex: 20% = 0.20): ");
      double pWgt = input.nextDouble();
      System.out.print("Please enter the percentage grade you received on your project: ");
      pAsgmt[0] = input.nextDouble();  

      
      // Print table with assignments and weights
   
      // Call weight average method on each assignment category and add value to totalWgtAvg
      double totalWgtAvg = 0; 
      totalWgtAvg += wgtAvg(hAsgmt, hWgt);
      totalWgtAvg += wgtAvg(qAsgmt, qWgt);
      totalWgtAvg += wgtAvg(mAsgmt, mWgt);
      totalWgtAvg += wgtAvg(pAsgmt, pWgt);
      totalWgtAvg /= (hWgt + qWgt + mWgt + pWgt);
      
      // Print totalWgtAvg and call letter grade method
      letterGrade(totalWgtAvg);  
      
      // Call final grade method 
      double fWgt = 1.0 - (hWgt + qWgt + mWgt + pWgt);
      finalExamGrade(totalWgtAvg, fWgt);   
   }
   
   // Weight average calculation method (Ahyana Atiba-Davies)
   public static double wgtAvg(double [] asgmt, double asgmtWgt) {
      // Calculate assignment score total 
      double asgmtTotal = 0;
      for (int i = 0; i < asgmt.length; i++) {
         asgmtTotal += asgmt[i];
      }
      // Calculate percent average 
      double pctAvg = asgmtTotal / asgmt.length;
      // Calculate weighted average 
      double wgtAvg = (pctAvg * asgmtWgt);
      // Return weighted average 
      return wgtAvg;
   }
   
   // Letter grade method (Ahyana Atiba-Davies)
   public static void letterGrade(double pct) {
      // Selection structure to determine lgrade 
      String grade;
      if (pct >= 97)
         grade = "A+";
         else if (pct >= 93)
            grade = "A";
            else if (pct >= 90)
               grade = "A-";
               else if (pct >= 87)
                  grade = "B+";
                  else if (pct >= 83)
                     grade = "B";
                     else if (pct >= 80)
                        grade = "B-";
                        else if (pct >= 77)
                           grade = "C+";
                           else if (pct >= 73)
                              grade = "C";
                              else if (pct >= 70)
                                 grade = "C-";
                                 else if (pct >= 67)
                                    grade = "D+";
                                    else if (pct >= 63)
                                       grade = "D";
                                       else if (pct >= 60)
                                          grade = "D-";
                                          else 
                                          grade = "F";
      // Print totalWgtAvg and lgrade
      System.out.printf("\nCurrently, you have a %s and your weighted average is %5.2f.\n", grade, pct);
   } 
   
   // Final exam grade method (James Jin)
   public static void finalExamGrade(double currentGrade, double finalWeight) {
      Scanner input = new Scanner(System.in);
  
	   double desiredGrade = 0;
      double finalExamGrade = 0;
      
      while (true) {
         System.out.print("Enter your desired grade (as a percentage): ");
         desiredGrade = input.nextDouble();

         // finalExamGrade = (desiredGrade - ((1.0 - finalWeight) * currentGrade)) / finalWeight;
         
         finalExamGrade = (desiredGrade - currentGrade * (1.0 - finalWeight)) / finalWeight;

         if (finalExamGrade > 100 || finalExamGrade < 0) {
             System.out.println("Desired grade is not achievable, Please enter a new grade.");
         } else {
             break;
         }
     }
        System.out.printf("The score needed on the final exam is: %.2f\n", finalExamGrade);
    }
}