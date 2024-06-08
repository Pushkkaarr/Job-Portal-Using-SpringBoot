package com.pushkar.JobApp.service;

import com.pushkar.JobApp.model.JobPost;
import com.pushkar.JobApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepository repo;

    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }

    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();
    }
}
