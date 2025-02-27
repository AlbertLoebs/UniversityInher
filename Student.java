public class Student extends UniversityMember {
    
    private Advisor advisor;
    private String year;
    private int studentNumber;
    static int IDNUMBER = 1000;

    Student(){
        super();
    }

    Student(String name, Advisor advisor, String year){
        super(name);
        this.advisor = advisor;
        this.year = year;
        setStudentNumber();
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public int getStudentNumber(){
        return studentNumber;
    }

    public void setStudentNumber(){
        this.studentNumber = IDNUMBER;
        IDNUMBER++;
    }

    public Advisor getAdvisor(){
        return advisor;
    }

    public void setAdvisor(Advisor advisor){
       this.advisor = advisor;
    }

    @Override
    public String toString(){
        return String.format("%s, Year: %s, Student Number: %d", super.toString(), year, studentNumber);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Student)){
            return false;
        } else {
            Student stuObj = (Student) obj;
            return super.equals(stuObj)
            && (year.equals(stuObj.year))
            && studentNumber == stuObj.studentNumber;
        }
    }

}
