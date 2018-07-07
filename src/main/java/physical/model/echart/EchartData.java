package physical.model.echart;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ewang on 2018/7/7.
 */
public class EchartData {
    public List<String> legend = new ArrayList<String>();// 数据分组
    public List<String> category = new ArrayList<String>();// 横坐标
    public List<Series> series = new ArrayList<Series>();// 纵坐标

    public EchartData(List<String> legendList, List<String> categoryList,
                      List<Series> seriesList) {
        this.legend = legendList;
        this.category = categoryList;
        this.series = seriesList;
    }

    public List<String> getLegend() {
        return legend;
    }

    public List<String> getCategory() {
        return category;
    }

    public List<Series> getSeries() {
        return series;
    }
}
