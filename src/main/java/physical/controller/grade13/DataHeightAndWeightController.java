package physical.controller.grade13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import physical.dao.AvgHeightDAO;
import physical.dao.AvgWeightDAO;
import physical.model.echart.EchartData;
import physical.model.echart.Series;
import physical.model.grade13.from16to17.AvgHeight;
import physical.model.grade13.from16to17.AvgLangOfSport;
import physical.model.grade13.from16to17.AvgWeight;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical/data")
public class DataHeightAndWeightController {

    @Autowired
    private AvgHeightDAO avgHeightDAO;

    @Autowired
    private AvgWeightDAO avgWeightDAO;

    @RequestMapping("/HAndW")
    @ResponseBody
    public EchartData getHeightAndWeight() {
        List<String> category = new ArrayList<String>();
        List<Double> serisDataHeight = new ArrayList<Double>();
        List<Double> serisDataWeight = new ArrayList<Double>();
        List<AvgWeight> weights = avgWeightDAO.findAllWeight();
        List<AvgHeight> heights = avgHeightDAO.findAllHeight();
        for (AvgHeight avgHeight : heights) {
            category.add(avgHeight.getMajor());
            serisDataHeight.add(avgHeight.getHeight());
            for (AvgWeight avgWeight : weights) {
                if (avgWeight.getMajor().equals(avgHeight.getMajor())) {
                    serisDataWeight.add(avgWeight.getWeight());
                    break;
                }
            }
        }

        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("平均身高", "bar", serisDataHeight));
        series.add(new Series("平均体重", "bar", serisDataWeight));
        EchartData data = new EchartData(null, category, series);
        return data;
    }
}
