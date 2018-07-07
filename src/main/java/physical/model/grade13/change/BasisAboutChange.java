package physical.model.grade13.change;

/**
 * created by ewang on 2018/7/6.
 * From14To15/From15To16/From16To17
 */
public class BasisAboutChange {
    private final int studentId;

    private final double height;

    private final double weight;

    private final double sportScore;

    public BasisAboutChange(int studentId, double height, double weight, double sportScore) {
        this.studentId = studentId;
        this.height = height;
        this.weight = weight;
        this.sportScore = sportScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getSportScore() {
        return sportScore;
    }
}
