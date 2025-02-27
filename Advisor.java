import java.util.ArrayList;

public class Advisor extends UniversityMember  {
    
    private String department;
    private ArrayList<Student> advStudentList = new ArrayList<>();

    Advisor(){
        super();
    }

    Advisor(String department, String name){
        super(name);
        this.department = department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public void addStudentToAdvisor(Student student){

        advStudentList.add(student);

    }

    public Student getStudentFromAdvisorList(int index){

        return advStudentList.get(index);

    }

    public int getNumStudentsInAdvisorList(){
        return advStudentList.size();
    }

    @Override
    public String toString(){
        return String.format("Advisor name: %s department: %s", super.toString(), department);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Advisor)){
            return false;
        } else {
            Advisor adv = (Advisor) obj;
            return super.equals(adv) && department.equals(adv.department);
        }
    }

}
