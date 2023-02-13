package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;
import softnet.firstBio.lifeLog.service.BloodPressureServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/")
public class BloodPressureController {
    private final BloodPressureServiceImpl bloodPressureService;

    @GetMapping("lifelog/Allbp")
    public List<BloodPressureResponseDto> findAllBp() {

        System.out.println(bloodPressureService.findAll());
        return bloodPressureService.findAll();
    }

    @PostMapping("lifelog/bp")
    public Long save(@RequestBody BloodPressureRequestDto requestDto) {
        return bloodPressureService.save(requestDto);
    }





}
