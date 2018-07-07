package physical.controller.all;

import physical.dao.BodyDAO;
import physical.dao.ScoreDAO;
import physical.model.all.BodyLevel;
import physical.model.all.ScoreLevel;
import physical.model.echart.EchartData;
import physical.model.echart.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by ewang on 2018/7/6.
 */
@Controller
@RequestMapping("/physical/data")
public class DataController {

    @Autowired
    private BodyDAO bodyDAO;

    @Autowired
    private ScoreDAO scoreDAO;

    @RequestMapping("/body/A")
    @ResponseBody
    public EchartData showBodyA() {
        return findBodyData('A');
    }

    @RequestMapping("/body/B")
    @ResponseBody
    public EchartData showBodyB() {
        return findBodyData('B');
    }

    @RequestMapping("/body/C")
    @ResponseBody
    public EchartData showBodyC() {
        return findBodyData('C');
    }

    @RequestMapping("/body/D")
    @ResponseBody
    public EchartData showBodyD() {
        return findBodyData('D');
    }

    @RequestMapping("/score/A")
    @ResponseBody
    public EchartData showScoreA() {
        return findScoreData('A');
    }

    @RequestMapping("/score/B")
    @ResponseBody
    public EchartData showScoreB() {
        return findScoreData('B');
    }

    @RequestMapping("/score/C")
    @ResponseBody
    public EchartData showScoreC() {
        return findScoreData('C');
    }

    @RequestMapping("/score/D")
    @ResponseBody
    public EchartData showScoreD() {
        return findScoreData('D');
    }

    EchartData findBodyData(char level) {
        List<String> legend = new ArrayList<String>();
        List<Map> seriesData = new ArrayList<Map>();

        List<BodyLevel> list = level == 'A' ? bodyDAO.findAllBodyA() : level == 'B' ?
                bodyDAO.findAllBodyB() : level == 'C' ? bodyDAO.findAllBodyC() : bodyDAO.findAllBodyD();
        for (BodyLevel bodyLevel : list) {
            Map map = new HashMap();
            legend.add(bodyLevel.getMajor());
            map.put("value", bodyLevel.getCount());
            map.put("name", bodyLevel.getMajor());
            seriesData.add(map);
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("身高体重等级院系比重", "pie", seriesData));
        EchartData data = new EchartData(legend, null, series);
        return data;
    }

    EchartData findScoreData(char level) {
        List<String> legend = new ArrayList<String>();
        List<Map> seriesData = new ArrayList<Map>();

        List<ScoreLevel> list = level == 'A' ? scoreDAO.findAllScoreA() : level == 'B' ?
                scoreDAO.findAllScoreB() : level == 'C' ? scoreDAO.findAllScoreC() : scoreDAO.findAllScoreD();
        for (ScoreLevel scoreLevel : list) {
            Map map = new HashMap();
            legend.add(scoreLevel.getMajor());
            map.put("value", scoreLevel.getCount());
            map.put("name", scoreLevel.getMajor());
            seriesData.add(map);
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("体测总分等级院系比重", "pie", seriesData));
        EchartData data = new EchartData(legend, null, series);
        return data;
    }

}
