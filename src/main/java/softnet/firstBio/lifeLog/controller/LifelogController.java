package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.dto.*;
import softnet.firstBio.lifeLog.service.LifelogService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("lifelog")
public class LifelogController {
    private final LifelogService lifelogService;

    @GetMapping()
    public List<Object> latestLifelog() {
        return lifelogService.latestLifelog();
    }


    // BP
    @GetMapping("Allbp")
    public List<BloodPressureResponseDto> findAllBp() {

        System.out.println(lifelogService.findAllBP());
        return lifelogService.findAllBP();
    }

    @PostMapping("bp")
    public Long saveBP(@RequestBody BloodPressureRequestDto requestDto) {
        return lifelogService.saveBP(requestDto);
    }


    //BS
    @GetMapping("Allbs")
    public List<BloodSugarResponseDto> findAllBs() {
        return lifelogService.findAllBS();
    }

    @PostMapping("bs")
    public Long saveBS(@RequestBody BloodSugarRequestDto requestDto) {
        return lifelogService.saveBS(requestDto);
    }


    //Weight

    @GetMapping("AllWeight")
    public List<WeightResponseDto> findAllWeight() {
        return lifelogService.findAllWeight();}


    @PostMapping("weight")
    public Long saveWeight(@RequestBody WeightRequestDto requestDto) {
        return lifelogService.saveWeight(requestDto);
    }
}
