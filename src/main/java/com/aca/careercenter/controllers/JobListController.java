package com.aca.careercenter.controllers;

import com.aca.careercenter.dao.JobDao;
import com.aca.careercenter.dto.Job;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vahe on 4/21/2017
 */
@ManagedBean(name = "jobListController", eager = true)
@RequestScoped
public class JobListController {

    private List<Job> jobList;
    private String content;

    public JobListController() {
        jobList = JobDao.INSTANCE.getApprovedJobAnnouncements();
    }

    public void showJobPost(int jobId){
        Optional<Job> job= jobList.stream().filter(t -> t.getId() == jobId).findFirst();
        job.ifPresent(j -> content = j.getContent());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Job> getApprovedJobs() {
        return null;
    }

    public List<Job> getNotApprovedJobs() {
        return null;
    }

    void deleteJob() {

    }

    void approveJob() {

    }

    public String goToPostNewJobPage() {
        return "admin";
    }

    public String postNewJob() {
        return "post?faces-redirect=true";
    }
}
