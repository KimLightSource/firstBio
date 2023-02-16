package softnet.firstBio.lifeLog.service;

import softnet.firstBio.lifeLog.dto.*;

import java.util.List;

public interface LifelogService {

    public List<Object> latestLifelog();


    // BP
    public List<BloodPressureResponseDto> findAllBP();
    public Long saveBP(BloodPressureRequestDto requestDto);


    //BS
    public List<BloodSugarResponseDto> findAllBS();
    public Long saveBS(BloodSugarRequestDto requestDto);

    //WEIGHT
    public List<WeightResponseDto> findAllWeight();
    public Long saveWeight(WeightRequestDto requestDto);


}
