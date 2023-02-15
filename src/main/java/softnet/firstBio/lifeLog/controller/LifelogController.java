package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.dto.BloodSugarRequestDto;
import softnet.firstBio.lifeLog.dto.BloodSugarResponseDto;
import softnet.firstBio.lifeLog.service.LifelogServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/")
public class LifelogController {
    private final LifelogServiceImpl lifelogService;


    // BP
    @GetMapping("lifelog/Allbp")
    public List<BloodPressureResponseDto> findAllBp() {

        System.out.println(lifelogService.findAllBP());
        return lifelogService.findAllBP();
    }

    @PostMapping("lifelog/bp")
    public Long saveBP(@RequestBody BloodPressureRequestDto requestDto) {
        return lifelogService.saveBP(requestDto);
    }


    //BS
    @GetMapping("lifelog/Allbs")
    public List<BloodSugarResponseDto> findAllBs() {
        return lifelogService.findAllBS();
    }

    @PostMapping("lifelog/bs")
    public Long saveBS(@RequestBody BloodSugarRequestDto requestDto) {
        return lifelogService.saveBS(requestDto);
    }
}
