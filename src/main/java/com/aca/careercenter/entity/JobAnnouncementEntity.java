package com.aca.careercenter.entity;

import javax.persistence.*;

/**
 * Created by Vahe on 4/21/2017
 */
@Entity
@Table(name = "job_announcement")
public class JobAnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content",columnDefinition="blob")
    private byte[] content;
    @Column(name = "approved")
    private boolean approved;
    @Column(name = "postDate")
    private String postDate;

    public JobAnnouncementEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
}
