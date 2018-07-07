package physical.model.all;

/**
 * created by ewang on 2018/7/6.
 * 总成绩等级 优秀A/良好B/及格C/不及格D
 * major 院系
 * count 人数
 */
public class ScoreLevel {
    private final String major;

    private final int count;

    public ScoreLevel(String major, int count) {
        this.major = major;
        this.count = count;
    }

    public String getMajor() {
        return major;
    }

    public int getCount() {
        return count;
    }
}
