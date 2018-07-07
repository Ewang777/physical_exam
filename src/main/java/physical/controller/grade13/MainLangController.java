package physical.controller.grade13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by ewang on 2018/7/7.
 */
@Controller
@RequestMapping("/physical/lang")
public class MainLangController {

    @RequestMapping("/body")
    public ModelAndView getLangOfBody() {
        return new ModelAndView("/show_lang").addObject("factor", "body");
    }

    @RequestMapping("/sport")
    public ModelAndView getLangOfSport() {
        return new ModelAndView("/show_lang").addObject("factor", "sport");
    }
}
