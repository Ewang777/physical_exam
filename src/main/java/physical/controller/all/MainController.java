package physical.controller.all;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by ewang on 2018/7/6.
 */
@Controller
@RequestMapping("/physical")
public class MainController {

    @RequestMapping("/body/A")
    public ModelAndView showBodyA() {
        return new ModelAndView("/show_body").addObject("level", "A");
    }

    @RequestMapping("/body/B")
    public ModelAndView showBodyB() {
        return new ModelAndView("/show_body").addObject("level", "B");
    }

    @RequestMapping("/body/C")
    public ModelAndView showBodyC() {
        return new ModelAndView("/show_body").addObject("level", "C");
    }

    @RequestMapping("/body/D")
    public ModelAndView showBodyD() {
        return new ModelAndView("/show_body").addObject("level", "D");
    }

    @RequestMapping("/score/A")
    public ModelAndView showScoreA() {
        return new ModelAndView("/show_score").addObject("level", "A");
    }

    @RequestMapping("/score/B")
    public ModelAndView showScoreB() {
        return new ModelAndView("/show_score").addObject("level", "B");
    }

    @RequestMapping("/score/C")
    public ModelAndView showScoreC() {
        return new ModelAndView("/show_score").addObject("level", "C");
    }

    @RequestMapping("/score/D")
    public ModelAndView showScoreD() {
        return new ModelAndView("/show_score").addObject("level", "D");
    }
}
