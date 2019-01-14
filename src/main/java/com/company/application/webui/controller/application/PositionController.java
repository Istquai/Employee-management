package com.company.application.webui.controller.application;

import com.company.application.domain.service.PositionService;
import com.company.application.webui.controller.Mappings;
import com.company.application.webui.dto.PositionCountDto;
import com.company.application.webui.dto.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Mappings.POSITION)
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public void addPosition(@RequestBody  PositionDto positionDto) {
        positionService.addPosition(positionDto);
    }

    @GetMapping
    public List<PositionDto> getPositions(){
        return positionService.getPositions();
    }

    @GetMapping("/count")
    public List<PositionCountDto> getPositionWithAssignedEmployeeCount() {
        return positionService.getPositionsWithAssignedEmployeeCount();
    }
}
