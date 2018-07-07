package physical.controller.grade13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import physical.dao.AvgLangOfBodyDAO;
import physical.dao.AvgLangOfSportDAO;
import physical.model.echart.EchartData;
import physical.model.echart.Series;
import physical.model.grade13.from16to17.AvgLangOfBody;
import physical.model.grade13.from16to17.AvgLangOfSport;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical/data/lang")
public class DataLangController {

    @Autowired
    private AvgLangOfBodyDAO avgLangOfBodyDAO;

    @Autowired
    private AvgLangOfSportDAO avgLangOfSportDAO;

    @RequestMapping("/body")
    @ResponseBody
    public EchartData getLangOfBodyData() {
        List<String> category = new ArrayList<String>();
        List<Double> serisData = new ArrayList<Double>();
        List<AvgLangOfBody> list = avgLangOfBodyDAO.findAllLangOfBody();
        for (AvgLangOfBody avgLangOfBody : list) {
            category.add(avgLangOfBody.getBodyLevel());
            serisData.add(avgLangOfBody.getLang());
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("肺活量比较", "bar", serisData));
        EchartData data = new EchartData(null, category, series);
        return data;
    }

    @RequestMapping("/sport")
    @ResponseBody
    public EchartData getLangOfSportData() {
        List<String> category = new ArrayList<String>();
        List<Double> serisData = new ArrayList<Double>();
        List<AvgLangOfSport> list = avgLangOfSportDAO.findAllLangOfSport();
        for (AvgLangOfSport avgLangOfSport : list) {
            category.add("运动" + avgLangOfSport.getSportLevel());
            serisData.add(avgLangOfSport.getLang());
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("肺活量比较", "bar", serisData));
        EchartData data = new EchartData(null, category, series);
        return data;
    }
}
