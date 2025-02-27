import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateNewUniversity {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Request the name of the University
        System.out.print("Enter the name of the University: ");
        String universityName = keyboard.nextLine();

        // Create a University with the entered name
        University university = new University(universityName);

            university.hireAdvisors();
            university.admitStudents();
            university.printUniversityCommunity();
        
            keyboard.close();
        }
    }