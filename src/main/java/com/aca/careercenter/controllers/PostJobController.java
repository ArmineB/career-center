package com.aca.careercenter.controllers;

import com.aca.careercenter.dao.JobDao;
import com.aca.careercenter.dto.Job;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vahe on 4/21/2017
 */
@ManagedBean(name = "postJobController", eager = true)
@SessionScoped
public class PostJobController {

    private String companyName;
    private String jobTitle;
    private String content;

    public void postJob(){
        Job job = new Job();

        job.setTitle(jobTitle);
        job.setContent(content);
        JobDao.INSTANCE.postJob(job);
    }

}
