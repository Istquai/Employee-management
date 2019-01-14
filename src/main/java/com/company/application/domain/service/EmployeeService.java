package com.company.application.domain.service;

import com.company.application.domain.Mapper;
import com.company.application.domain.model.Employee;
import com.company.application.domain.model.Position;
import com.company.application.domain.repository.EmployeeRepository;
import com.company.application.domain.repository.PositionRepository;
import com.company.application.webui.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final EntityManager entityManager;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PositionRepository positionRepository, EntityManager entityManager) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.entityManager = entityManager;
    }

    public void addEmployee(EmployeeDto employeeDto) {
        Optional<Position> position = positionRepository.findById(employeeDto.getPositionId());

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        position.ifPresent(employee::setPosition);

        employeeRepository.save(employee);

    }

    public List<EmployeeDto> findEmployee(EmployeeDto searchEmployeeDto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchEmployeeDto.getEmail() != null) {
            predicates.add(cb.equal(employee.get("email"), searchEmployeeDto.getEmail()));
        }

        if (searchEmployeeDto.getFirstName() != null) {
            predicates.add(cb.equal(employee.get("firstName"), searchEmployeeDto.getFirstName()));
        }

        if (searchEmployeeDto.getLastName() != null) {
            predicates.add(cb.equal(employee.get("lastName"), searchEmployeeDto.getLastName()));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return query.getResultList().stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll().stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
