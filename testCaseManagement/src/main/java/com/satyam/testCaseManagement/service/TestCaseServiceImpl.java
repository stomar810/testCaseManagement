package com.satyam.testCaseManagement.service;

import com.satyam.testCaseManagement.dto.TestCaseDTO;
import com.satyam.testCaseManagement.exception.TestCaseNotFoundException;
import com.satyam.testCaseManagement.model.TestCase;
import com.satyam.testCaseManagement.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor // Lombok generates constructor for final fields
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    // Manually defining the constructor
    public TestCaseServiceImpl(TestCaseRepository testCaseRepository, ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCase = testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO getTestCaseById(String id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException("Test case with ID " + id + " not found"));
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO updateTestCase(String id, TestCaseDTO testCaseDTO) {
        TestCase existingTestCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException("TestCase with ID " + id + " not found"));

        // Map updated fields from DTO to entity
        modelMapper.map(testCaseDTO, existingTestCase);
        TestCase updatedTestCase = testCaseRepository.save(existingTestCase);

        return modelMapper.map(updatedTestCase, TestCaseDTO.class);
    }

    @Override
    public void deleteTestCase(String id) {
        if (!testCaseRepository.existsById(id)) {
            throw new TestCaseNotFoundException("TestCase with ID " + id + " not found.");
        }
        testCaseRepository.deleteById(id);
    }

/*    @Override
    public List<TestCaseDTO> getAllTestCases(int page, int size, String sortBy) {
        return List.of();
    }*/
    @Override
    public List<TestCaseDTO> getAllTestCases(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return testCaseRepository.findAll(pageable).stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }
}
