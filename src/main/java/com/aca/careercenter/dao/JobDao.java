package com.aca.careercenter.dao;

import com.aca.careercenter.dto.Job;
import com.aca.careercenter.entity.JobAnnouncementEntity;
import javafx.util.converter.LocalDateStringConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vahe on 4/21/2017
 */
public enum JobDao{

    INSTANCE();

    private final SessionFactory sessionFactory;

    JobDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Class.forName("mysql.jdbc.esiminch")
//        Connection connection = DriverManager.getConnection("asdfasdf") alternative in pure SQL way
    }

    public List<Job> getJobAnnouncements(){
        List<Job> jobs = new ArrayList<>();

        Session session = sessionFactory.openSession();

        List<JobAnnouncementEntity> jobEntityList =
                session.createCriteria(JobAnnouncementEntity.class).list();

        for (JobAnnouncementEntity entity : jobEntityList){
            Job job = new Job();
            populateDto(job, entity);
            jobs.add(job);
        }

        return jobs;
    }

    private void populateDto(Job job, JobAnnouncementEntity entity) {
        job.setId(entity.getId());
        job.setTitle(entity.getTitle());
        job.setCompanyName(entity.getCompanyName());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        job.setPostDate(LocalDate.parse(entity.getPostDate(), dtf));

        job.setContent(new String(entity.getContent()));
        job.setApproved(entity.isApproved());
    }

    public void postJob(Job job){
        JobAnnouncementEntity entity = new JobAnnouncementEntity();
        entity.setCompanyName(job.getCompanyName());
        entity.setTitle(job.getTitle());
        entity.setContent(job.getContent().getBytes());

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void deletePost(Job job){

    }

    public void approvePost(Job job){

    }

}
