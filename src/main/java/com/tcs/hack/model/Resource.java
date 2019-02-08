package com.tcs.hack.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Entity;

@Entity
public class Resource {
    @Id
    @GeneratedValue
    private int resourceId;
    private String resourceName;
    public Resource() {
        super();
        //	this.resourceId = resourceId;
    }
    public Resource(int resourceId) {
        super();
        this.resourceId = resourceId;
    }
    public Resource(int resourceId, String resourceName) {
        super();
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }

    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    @Override
    public String toString() {
        return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName +  "]";
    }
}