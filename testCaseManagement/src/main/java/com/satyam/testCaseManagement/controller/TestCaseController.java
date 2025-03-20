package com.satyam.testCaseManagement.controller;

import com.satyam.testCaseManagement.dto.TestCaseDTO;
import com.satyam.testCaseManagement.service.TestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import java.util.List;

    @RestController
    @RequestMapping("/api/testcases")
    @Tag(name = "Test Case Management", description = "APIs for managing test cases")
    public class TestCaseController {

        private final TestCaseService testCaseService;

        public TestCaseController(TestCaseService testCaseService) {
            this.testCaseService = testCaseService;
        }

        @PostMapping
        @Operation(summary = "Create a new test case")
        public ResponseEntity<TestCaseDTO> createTestCase(@Valid @RequestBody TestCaseDTO testCaseDTO) {
            return ResponseEntity.ok(testCaseService.createTestCase(testCaseDTO));
        }

       /* @GetMapping
        public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
            return ResponseEntity.ok(testCaseService.getAllTestCases());
            }
*/
       @GetMapping
       @Operation(summary = "Get all test cases with pagination")
       public ResponseEntity<List<TestCaseDTO>> getAllTestCases(
               @RequestParam(defaultValue = "0") int page,
               @RequestParam(defaultValue = "10") int size,
               @RequestParam(defaultValue = "createdAt") String sortBy) {
           return ResponseEntity.ok(testCaseService.getAllTestCases(page, size, sortBy));
        }

        @GetMapping("/{id}")
        @Operation(summary = "Get a test case by ID")
        public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable String id) {
            return ResponseEntity.ok(testCaseService.getTestCaseById(id));
        }

        @PutMapping("/{id}")
        @Operation(summary = "Update a test case")
        public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable String id, @RequestBody TestCaseDTO testCaseDTO) {
            return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseDTO));
        }

     /*   @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteTestCase(@PathVariable String id) {
            testCaseService.deleteTestCase(id);
            return ResponseEntity.ok("Test case deleted successfully");
        }

     */
        @DeleteMapping("/{id}")
        @Operation(summary = "Delete a test case")
        public ResponseEntity<Void> deleteTestCase(@PathVariable String id) {
            testCaseService.deleteTestCase(id);
            return ResponseEntity.noContent().build();
        }


    }

