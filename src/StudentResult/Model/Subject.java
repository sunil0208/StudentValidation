package StudentResult.Model;

/**
 * Created by sachin on 11/18/2014.
 */
public class Subject {

    private int totalSubject;
    private float[] marks = new float[totalSubject];
    private int[] subjectId = new int[totalSubject];

    private String[] subjectName = new String[totalSubject];
    private int[] passMarks = new int[totalSubject];


    private int[] fullMarks=new int[totalSubject];

    public int getTotalSubject() {
        return totalSubject;
    }

    public void setTotalSubject(int totalSubject) {
        this.totalSubject = totalSubject;
    }

    public float[] getMarks() {
        return marks;
    }

    public void setMarks(float[] marks) {
        this.marks = marks;
    }

    public int[] getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int[] subjectId) {
        this.subjectId = subjectId;
    }

    public String[] getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String[] subjectName) {
        this.subjectName = subjectName;
    }

    public int[] getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(int[] passMarks) {
        this.passMarks = passMarks;
    }
    public int[] getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(int[] fullMarks) {
        this.fullMarks = fullMarks;
    }
}


