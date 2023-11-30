package com.dan.restone.challenges.relantionships_challenge.services;

import com.dan.restone.challenges.relantionships_challenge.models.dtos.EmployeeDTO;
import com.dan.restone.challenges.relantionships_challenge.models.entities.Employee;
import com.dan.restone.challenges.relantionships_challenge.repositories.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
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
    public EmployeeDTO getEmployee(Long id) {
        return modelMapper.map(getEmployeeById(id), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO assignLaptop(Long id) {
        //assign a free laptop to an employee if he has none
        Employee employee = getEmployeeById(id);
        employee.setLaptop(laptopService.getFreeLaptop());
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    private Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        //add throw exception?
        return employee.orElse(null);
    }
}
