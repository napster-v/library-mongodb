package com.neeraj.libraryApi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class AppBaseModel {
    @Id
    private String id;
    @JsonIgnore
    @CreatedDate
    private LocalDateTime created;
    @JsonIgnore
    @LastModifiedDate
    private LocalDateTime modified;
    @JsonIgnore
    private boolean deleted = false;
}
