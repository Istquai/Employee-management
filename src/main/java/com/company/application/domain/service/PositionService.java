package com.company.application.domain.service;

import com.company.application.domain.Mapper;
import com.company.application.domain.model.Position;
import com.company.application.domain.repository.EmployeeRepository;
import com.company.application.domain.repository.PositionRepository;
import com.company.application.webui.dto.PositionCountDto;
import com.company.application.webui.dto.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository, EmployeeRepository employeeRepository) {
        this.positionRepository = positionRepository;
        this.employeeRepository = employeeRepository;
    }

    public void addPosition(PositionDto positionDto) {
        Position position = new Position();
        position.setName(positionDto.getName());
        positionRepository.save(position);
    }

    public List<PositionDto> getPositions() {
        return positionRepository.findAll().stream().map(position -> {
            PositionDto positionDto = new PositionDto();
            positionDto.setName(position.getName());
            positionDto.setPositionId(position.getId());
            positionDto.setEmployeeDtos(employeeRepository
                    .findByPositionId(position.getId())
                    .stream()
                    .map(Mapper::mapToDto)
                    .collect(Collectors.toList()));
            return positionDto;
        }).collect(Collectors.toList());
    }

    public List<PositionCountDto> getPositionsWithAssignedEmployeeCount() {
        return positionRepository.findAll().stream().map(position -> {
            PositionCountDto positionCountDto = new PositionCountDto();
            positionCountDto.setPositionName(position.getName());
            positionCountDto.setEmployeeCount(position.getEmployees().size());
            return positionCountDto;
        }).collect(Collectors.toList());
    }
}
