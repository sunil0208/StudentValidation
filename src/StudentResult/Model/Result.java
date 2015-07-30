package StudentResult.Model;

/**
 * Created by sachin on 11/3/2014.
 */
public class Result {
    private float total;
    private float percentage;
    private String status;
    private String examination;
    private int examId;


    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPercentage() {
        return percentage;
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }


}
