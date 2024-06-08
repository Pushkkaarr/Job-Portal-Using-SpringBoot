package com.pushkar.JobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

//     This are all annotations of LomBok , which helps to reduce code
//     by which we have not to create getter and setters for all the below variables by mentioning @Data class
@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;

}
