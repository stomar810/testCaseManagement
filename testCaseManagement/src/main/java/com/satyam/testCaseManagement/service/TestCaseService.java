package com.satyam.testCaseManagement.service;

import com.satyam.testCaseManagement.dto.TestCaseDTO;
import com.satyam.testCaseManagement.model.TestCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TestCaseService {

    // Create a new test case
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);

    // Retrieve a test case by ID
    TestCaseDTO getTestCaseById(String id);

    // Update an existing test case
    TestCaseDTO updateTestCase(String id, TestCaseDTO testCaseDTO);

    // Delete a test case by ID
    void deleteTestCase(String id);

    // Retrieve all test cases with pagination & sorting
    /*Page<TestCaseDTO> getPaginatedTestCases(Pageable pageable);

    List<TestCaseDTO> getPaginatedTestCases();
 */
    // Retrieve all test cases without pagination
      List<TestCaseDTO> getAllTestCases(int page, int size, String sortBy);
       List<TestCaseDTO> getAllTestCases();

}
