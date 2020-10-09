package com.rest.API.model;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "shopping")
public class Shopping {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date CreatedDate;

    public Shopping(Long id, String name, Date CreatedDate) {
        this.id = id;
        this.name = name;
        this.CreatedDate = CreatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    
    
    

}