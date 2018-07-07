package physical.model.grade13.from16to17;

/**
 * created by ewang on 2018/7/6.
 */
public class AvgWeight {
    private final String major;

    private final double weight;

    public AvgWeight(String major, double weight) {
        this.major = major;
        this.weight = weight;
    }

    public String getMajor() {
        return major;
    }

    public double getWeight() {
        return weight;
    }
}
