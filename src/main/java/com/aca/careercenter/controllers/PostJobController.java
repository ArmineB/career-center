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

    private Job job;

    public void postJob(){
        JobDao.INSTANCE.postJob(job);
    }

    public Job getJob() {
        return job;
    }
}
