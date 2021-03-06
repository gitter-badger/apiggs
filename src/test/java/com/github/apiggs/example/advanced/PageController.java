package com.github.apiggs.example.advanced;

import com.github.apiggs.example.common.*;
import com.github.apiggs.example.hello.Greeting;
import org.jruby.ir.Tuple;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @index 4
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseController {

    /**
     * 默认页面，由于不是restful的，restdoc将忽略该Endpoint
     *
     * @return
     */
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView();
    }

    /**
     * Hello with ResponseBody
     *  *********
     * 由于带有@ResponseBody，restdoc将解析该Endpoint
     * <p>
     * hhh
     * \*********
     *  *********
     * hhhh
     * *********
     * <p>
     * class ************** {
     * <p>
     * }
     *
     * @return
     */
    @GetMapping("/hello")
    @ResponseBody
    public Greeting hello() {
        return new Greeting(1, "hello world");
    }


    /**
     * 未知的多泛型的tuple 演示
     *
     * @return
     */
    @GetMapping("/tuple")
    @ResponseBody
    public Tuple<UserDTO, User> tuple() {
        return null;
    }

    /**
     * 多个RequestMethod
     *
     * @return
     */
    @RequestMapping(value = "/multiMethod", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public ResultData multiMethod() {
        return null;
    }

    @PostMapping("/multi")
    @ResponseBody
    public ResultData<Wrapper<UserDTO>> multi(@RequestBody ResultData<Wrapper<List<UserDTO>>> resultData) {
        return null;
    }
}
