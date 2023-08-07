package com.demo.jwt.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Data
public class Auditable {
    @JsonIgnore
    @Column(name="uuid")
    private String uuid;

    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_datetime")
    private Date createdDatetime;

    @LastModifiedBy
    @Column(name = "modified_by")
    private Long modifiedBy;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modified_datetime")
    private Date modifiedDatetime;

    @JsonIgnore
    @Version
    @Column(name = "version")
    private Integer version;

    @PrePersist
    public void onCreate() {
        this.createdDatetime = java.sql.Timestamp.valueOf(LocalDateTime.now());
        this.modifiedDatetime = java.sql.Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.modifiedDatetime = java.sql.Timestamp.valueOf(LocalDateTime.now());
    }
}
