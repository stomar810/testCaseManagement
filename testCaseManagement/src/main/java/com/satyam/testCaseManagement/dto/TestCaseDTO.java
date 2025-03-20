package com.satyam.testCaseManagement.dto;

import com.satyam.testCaseManagement.enums.Priority;
import com.satyam.testCaseManagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class TestCaseDTO {
        private String id;
        private String title;
        private String description;
        private Priority priority;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

}


