package physical.controller.grade13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical/change")
public class MainChangeController {

    @RequestMapping("/stage1")
    public ModelAndView getFrom14To15(){
        return new ModelAndView("/show_change").addObject("stage",1);
    }

    @RequestMapping("/stage2")
    public ModelAndView getFrom15To16(){
        return new ModelAndView("/show_change").addObject("stage",2);
    }

    @RequestMapping("/stage3")
    public ModelAndView getFrom16To17(){
        return new ModelAndView("/show_change").addObject("stage",3);
    }
}
