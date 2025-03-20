package com.satyam.testCaseManagement.repository;

import com.satyam.testCaseManagement.model.TestCase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TestCaseRepository extends MongoRepository<TestCase, String>{
}
