package com.pushkar.JobApp;

import com.pushkar.JobApp.model.JobPost;
import com.pushkar.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("jobPost/{postId}")
    @ResponseBody //for returning actual data and not the view pages // we also use @RestController for all if no JSP pages
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAlljobs(){
        return service.getAllJobPosts();
    }

    @PostMapping("jobPost")
    public void addjob(@RequestBody JobPost job){
        System.out.println("here");
       service.addJobPost(job);
        System.out.println("done");
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

//    this explicilty tell this method uses POST
    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost){
        service.addJobPost(jobPost);
        return "success";
    }

//    public List<JobPost> searchByKeyword(){
//
//    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model){
        List<JobPost> jobPosts = service.getAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}
