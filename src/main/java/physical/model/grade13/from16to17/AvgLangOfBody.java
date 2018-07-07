package physical.model.grade13.from16to17;

/**
 * created by ewang on 2018/7/6.
 */
public class AvgLangOfBody {
    private final String bodyLevel;

    private final double lang;

    public AvgLangOfBody(String bodyLevel, double lang) {
        this.bodyLevel = bodyLevel;
        this.lang = lang;
    }

    public String getBodyLevel() {
        return bodyLevel;
    }

    public double getLang() {
        return lang;
    }
}
