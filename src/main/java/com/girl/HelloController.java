package com.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Black
 * @RestController = @Controller + @ResponseBody
 * @time 2018/4/22.
 */
@RestController
//@Controller
//@RequestMapping("/girl")
public class HelloController {
    @Value("${CupSize}")
    private String CupSize;

    @Value("${Age}")
    private Integer Age;

    @Value("${Content}")
    private String Content;

    @Autowired
    private GirlProperties girl;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String hello() {
        //return "hello spring boot!!!" + CupSize + " " + Age + " " + Content;
        return girl.getName();
        //return "index";
    }

    @RequestMapping(value = {"/hellopost", "/hipost"}, method = RequestMethod.POST)
    public String helloPost() {
        //return "hello spring boot!!!" + CupSize + " " + Age + " " + Content;
        return girl.getName();
        //return "index";
    }

    @RequestMapping(value = "/helloone/{id}", method = RequestMethod.GET)
    //http://localhost:8080/girl/helloone/25
    public String helloone(@PathVariable("id") Integer id) {
        //return "hello spring boot!!!" + CupSize + " " + Age + " " + Content;
        return "id: " + id;
        //return "index";

    }

    @RequestMapping(value = "/hellotwo", method = RequestMethod.GET)
    //http://localhost:8080/girl/hellotwo?id=111
    public String hellotwo(@RequestParam("id") Integer myId) {
        //return "hello spring boot!!!" + CupSize + " " + Age + " " + Content;
        return "id: " + myId;
        //return "index";

    }

    //@RequestMapping(value = "/hello3", method = RequestMethod.GET)
    //组合注解
    @GetMapping
    //http://localhost:8080/girl/hello3?id=
    public String hello3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        //return "hello spring boot!!!" + CupSize + " " + Age + " " + Content;
        return "id: " + myId;
        //return "index";

    }
}