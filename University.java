import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class University {
    private String univName;
    private ArrayList<Advisor> advList = new ArrayList<>();
    private ArrayList<Student> freshmanStudList = new ArrayList<>();
    private ArrayList<Student> sophomoreStudList = new ArrayList<>();
    private ArrayList<Student> juniorStudList = new ArrayList<>();
    private ArrayList<Student> seniorStudList = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);


    University(){

    }

    University(String univName){
        this.univName = univName;
    }

    public String getUnivName(){
        return univName;
    }

    public void setUnivName(String univname){
        this.univName = univname;
    }

    public void hireAdvisors() throws FileNotFoundException {
        
        System.out.print("Please enter the name of the input file with advisor's name and department: ");
        String fileName = keyboard.nextLine();
        File inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.out.printf("The file %s does not exist", inputFile);
            System.exit(0);
        }

        Scanner inputReader = new Scanner(inputFile);
        while(inputReader.hasNextLine()){
            String name = inputReader.nextLine();
            String department = inputReader.nextLine();
            Advisor advisor = new Advisor(name, department);
            advList.add(advisor);
        }
        inputReader.close();

    }

    public void admitStudents() throws FileNotFoundException {

        System.out.print("Please enter the name of the input file with student's name and year: ");
        String fileName = keyboard.nextLine();
        File inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.out.printf("The file %s does not exist", inputFile);
            System.exit(0);
        }

        Scanner inputReader = new Scanner(inputFile);
        int advisorIndex = 0;
        while(inputReader.hasNextLine()){
            String name = inputReader.nextLine();
            String year = inputReader.nextLine();
            if (!year.equals("Freshman") && !year.equals("Sophomore") && !year.equals("Junior") && !year.equals("Senior")) {
                System.out.printf("Student %s has an illegal year: %s and is rejected%n", name, year);
                continue;
            }
            Advisor advisor = advList.get(advisorIndex);
            advisorIndex++;
            if(advisorIndex == advList.size()){
                advisorIndex = 0;
            }

            Student student = new Student(name, advisor, year);
            advisor.addStudentToAdvisor(student);

            switch (year) {
                case "Freshman":
                    freshmanStudList.add(student);
                    break;
                case "Sophomore":
                    sophomoreStudList.add(student);
                    break;
                case "Junior":
                    juniorStudList.add(student);
                    break;
                case "Senior":
                    seniorStudList.add(student);
                    break;
            }
        }
        inputReader.close();
    }

    public void printUniversityCommunity() throws FileNotFoundException{
        System.out.print("Please enter the name of the output file: ");
        String fileName = keyboard.nextLine();
        PrintWriter outputWriter = new PrintWriter(new File(fileName));

        outputWriter.printf("Cal State Dominguez Hills's Community Of Advisors and Their Students\n\n");

        for (int i = 0; i < advList.size(); i++) {
            Advisor advisor = advList.get(i);
            outputWriter.printf("Students advised by %s%n", advisor);
            int numStudents = advisor.getNumStudentsInAdvisorList();
            for (int j = 0; j < numStudents; j++) {
                Student student = advisor.getStudentFromAdvisorList(j);
                outputWriter.printf("  %s%n", student);
            }
            outputWriter.printf("\n");
        }


        outputWriter.printf("Cal State Dominguez Hills's List Of Students By Year\n\n");
        
        outputWriter.printf("FRESHMAN STUDENTS\n");
        for(int i = 0; i < freshmanStudList.size(); i++){
            outputWriter.printf("%s\n",freshmanStudList.get(i));
        }

        outputWriter.printf("\n");

        outputWriter.printf("SOPHOMORE STUDENTS\n");
        for(int i = 0; i < sophomoreStudList.size(); i++){
            outputWriter.printf("%s\n",sophomoreStudList.get(i));
        }
        
        outputWriter.printf("\n");

        outputWriter.printf("JUNIOR STUDENTS\n");
        for(int i = 0; i < juniorStudList.size(); i++){
            outputWriter.printf("%s\n",juniorStudList.get(i));
        }

        outputWriter.printf("\n");

        outputWriter.printf("SENIOR STUDENTS\n");
        for(int i = 0; i < seniorStudList.size(); i++){
            outputWriter.printf("%s\n",seniorStudList.get(i));
        }
        outputWriter.close();
    }
}
