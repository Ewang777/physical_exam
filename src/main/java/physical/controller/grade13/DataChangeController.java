package physical.controller.grade13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import physical.dao.BasisDAO;
import physical.model.echart.EchartData;
import physical.model.echart.Series;
import physical.model.grade13.change.BasisAboutChange;
import physical.model.grade13.from16to17.AvgLangOfSport;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical/data/change")
public class DataChangeController {

    @Autowired
    private BasisDAO basisDAO;

    @RequestMapping("/stage1")
    @ResponseBody
    public EchartData getFrom14To15() {
        return getData(1);
    }

    @RequestMapping("/stage2")
    @ResponseBody
    public EchartData getFrom15To16() {
        return getData(2);
    }

    @RequestMapping("/stage3")
    @ResponseBody
    public EchartData getFrom16To17() {
        return getData(3);
    }

    EchartData getData(int stage) {
        List<Series> series = new ArrayList<Series>();// 纵坐标
        List<BasisAboutChange> list = stage == 1 ? basisDAO.findAllBasisFrom14To15() : stage == 2 ? basisDAO.findAllBasisFrom15To16() : basisDAO.findAllBasisFrom16To17();
        for (BasisAboutChange basisAboutChange : list) {
            List<Double> serisData = new ArrayList<Double>();
            serisData.add(basisAboutChange.getHeight());
            serisData.add(basisAboutChange.getWeight());
            serisData.add(basisAboutChange.getSportScore());
            series.add(new Series("Basis","scatter",serisData));
        }
        EchartData data = new EchartData(null, null, series);
        return data;
    }
}
