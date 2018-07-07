package physical.model.grade13.from16to17;

/**
 * created by ewang on 2018/7/6.
 */
public class AvgHeight {
    private final String major;

    private final double height;

    public AvgHeight(String major, double height) {
        this.major = major;
        this.height = height;
    }

    public String getMajor() {
        return major;
    }

    public double getHeight() {
        return height;
    }
}
