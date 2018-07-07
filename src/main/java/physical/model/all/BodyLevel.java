package physical.model.all;

/**
 * created by ewang on 2018/7/6.
 * 身高体重等级 肥胖A/超重B/正常C/低体重D
 * major 院系
 * count 人数
 */
public class BodyLevel {
    private final String major;

    private final int count;

    public BodyLevel(String major, int count) {
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
