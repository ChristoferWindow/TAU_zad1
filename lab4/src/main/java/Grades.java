import static java.lang.Math.ceil;

public class Grades {

    private float[] grades;

    public boolean doYouPassTau(int grade) {
        return grade > 2;
    }

    public float getAverage(float[] grades) {
        int noOfElements = grades.length;

        float sum = 0;
        for (float value : grades) {
            sum += value;
        }

        return (float) ceil(sum / noOfElements);
    }

    public String isMyMomHappyFromMyGrades() {
        if (this.grades.length < 1) {
            return "You don't have any grades";
        }

        return this.getAverage(this.grades) > 4
                ? "Your mom is happy"
                : "Your mom is sad **crying**";
    }

    public void setGrades(float[] grades) {
        this.grades = grades;
    }

    public float[] getGrades(){
        return this.grades;
    }
}