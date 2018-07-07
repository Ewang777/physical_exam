package physical.model.grade13.from16to17;

/**
 * created by ewang on 2018/7/6.
 */
public class AvgLangOfSport {
    private final String sportLevel;

    private final double lang;

    public AvgLangOfSport(String sportLevel, double lang) {
        this.sportLevel = sportLevel;
        this.lang = lang;
    }

    public String getSportLevel() {
        return sportLevel;
    }

    public double getLang() {
        return lang;
    }
}
