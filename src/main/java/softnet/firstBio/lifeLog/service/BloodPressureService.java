package softnet.firstBio.lifeLog.service;

import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;

import java.util.List;

public interface BloodPressureService {

    public List<BloodPressureResponseDto> findAll();
    public BloodPressureResponseDto findById(Long id);
    public Long save(BloodPressureRequestDto requestDto);

}
