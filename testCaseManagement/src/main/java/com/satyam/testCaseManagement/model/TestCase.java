package com.satyam.testCaseManagement.model;

import com.satyam.testCaseManagement.enums.Priority;
import com.satyam.testCaseManagement.enums.Status;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "testCases") // MongoDB Collection
@Data

public class TestCase {
    @Id
    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    @CreatedDate
    private LocalDateTime createdAt;

    // Constructor to auto-set createdAt
    public TestCase(String title, String description, Priority priority, Status status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdAt = LocalDateTime.now(); // ✅ Auto-set creation time
    }
}
