package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.EmployeeDTO;
import com.dan.restone.challenges.relantionships_challenge.models.dtos.LaptopDTO;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Employee;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Laptop;
import com.dan.restone.challenges.relantionships_challenge.repositories.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    private final LaptopService laptopService;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, LaptopService laptopService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.laptopService = laptopService;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO responseDTO = modelMapper.map(savedEmployee, EmployeeDTO.class);

        return responseDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeDTO assignLaptop(Long id) {
        //get free laptop
        Laptop freeLaptop = laptopService.getFirstFreeLaptop();
        //get target employee
        Employee employee = employeeRepository.findById(id).get();

        //update bro
        employee.setLaptop(freeLaptop);
        employeeRepository.save(employee);

        //update laptop
        laptopService.setLaptopAsAssigned(freeLaptop.getId());

        return modelMapper.map(employee, EmployeeDTO.class);

    }
}
