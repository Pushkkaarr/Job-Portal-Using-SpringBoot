package com.pushkar.JobApp;

import com.pushkar.JobApp.model.JobPost;
import com.pushkar.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

//    @RequestMapping = deafult is @GetMapping
//    @GetMapping = GET Method
//    @PostMapping = Post Method

    @Autowired
    private JobService service;

    @GetMapping({"/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addjob(){
        return "addjob";
    }

//    this explicilty tell this method uses POST
    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJobPost(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model){
        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}
