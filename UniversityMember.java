public class UniversityMember {
    private String memberName;

    UniversityMember(){
        memberName = "";
    }   
    
    UniversityMember(String memberName){
        this.memberName = memberName;
    }

    public String getMemberName(){
        return memberName;
    }

    public void setMemberName(String memberName){
        this.memberName = memberName;
    }

    public String toString(){
        return String.format("%s", memberName);
    }

    public boolean equals(Object obj){
        if (!(obj instanceof UniversityMember)) {
            return false;
        }
        UniversityMember objUniMem = (UniversityMember) obj;
        return memberName.equals(objUniMem.memberName);
    }


}
