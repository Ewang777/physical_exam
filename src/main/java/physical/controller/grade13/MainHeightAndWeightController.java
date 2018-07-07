package physical.controller.grade13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical")
public class MainHeightAndWeightController {

    @RequestMapping("/HAndW")
    public ModelAndView getHeightAndWeight(){
        return new ModelAndView("/show_height_and_weight");
    }
}
