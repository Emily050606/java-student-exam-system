/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examtest;

import java.util.Scanner;

public class ExamTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String studentID = "";

        System.out.print("Enter student ID: ");
        while (true) {
            if (s.hasNextLine()) {
                studentID = s.nextLine(); // Get the input as a String
                // Check if the input is numeric and exactly 8 digits
                if (studentID.matches("\\d{8}")) {
                    break; // If it matches, break out of the loop
                } else {
                    System.out.println("Invalid input. Please enter a numerical student ID of exactly 8 digits.");
                }
            } else {
                s.next(); // Consume the invalid input
            }
            System.out.print("Enter student ID: ");
        }
        
        System.out.print("Enter student name: ");
        String studentName = s.nextLine(); // Read the full line for student name

        // Loop until the input matches the pattern [a-zA-Z ]+ (only letters and spaces)
        while (!studentName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid input. Please enter an alphabetic student name without numbers:");
            System.out.print("Enter student name: "); // Re-prompt inside the loop
            studentName = s.nextLine(); // Read the name again
        }
        studentName = studentName.toUpperCase(); // Convert the name to uppercase     
        
        System.out.print("Enter Level: ");
        while (!s.hasNextInt()) { // Check if the next input is not an integer
            System.out.println("Invalid input. Please enter a numerical level.");
            s.next(); // Consume the invalid input
            System.out.print("Enter Level: ");
        }
        int level = s.nextInt();
  
        
        //prompt for six subject
        int[] scores = new int[6];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            while (true) {
                if (s.hasNextInt()) {
                    int score = s.nextInt();
                    if (score >= 0 && score <= 100) {
                        scores[i] = score;
                        break; // Valid score, break out of the loop
                    } else {
                        System.out.print("Score must be between 0 and 100. \nPlease enter again: ");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numerical score.");
                    s.next(); // Consume the invalid non-integer input
                    System.out.print("Enter score for subject " + (i + 1) + ": ");
                }
            }
        }

        // Create an Exam object with the input data    
        Exam exam = new Exam(studentID, studentName, level, scores);
        
        //display student information
        System.out.println("======Student Exam Information======");
        System.out.println(exam.toString());
        System.out.println("====================================");
        
        //close the scanner
        s.close();
    }
}
    