package com.pushkar.JobApp;

import com.pushkar.JobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

//    @RequestMapping = deafult is @GetMapping
//    @GetMapping = GET Method
//    @PostMapping = Post Method

    @GetMapping({"/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addjob(){
        return "addjob";
    }

//    this explicilty tell this method uses POST
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        return "success";
    }
}
