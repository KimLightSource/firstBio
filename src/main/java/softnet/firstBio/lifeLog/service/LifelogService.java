package softnet.firstBio.lifeLog.service;

import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.dto.BloodSugarRequestDto;
import softnet.firstBio.lifeLog.dto.BloodSugarResponseDto;

import java.util.List;

public interface LifelogService {

    // BP
    public List<BloodPressureResponseDto> findAllBP();
    public Long saveBP(BloodPressureRequestDto requestDto);


    //BS
    public List<BloodSugarResponseDto> findAllBS();
    public Long saveBS(BloodSugarRequestDto requestDto);
}
