package softnet.firstBio.lifeLog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.dto.BloodSugarRequestDto;
import softnet.firstBio.lifeLog.dto.BloodSugarResponseDto;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;
import softnet.firstBio.lifeLog.repo.BloodSugarRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LifelogServiceImpl implements LifelogService{
    private final BloodPressureRepository bloodPressureRepository;
    private final BloodSugarRepository bloodSugarRepository;

    //BP
    public List<BloodPressureResponseDto> findAllBP() {
        List<BloodPressure> bloodPressures = bloodPressureRepository.findAll();
        List<BloodPressureResponseDto> bloodPressureResponseDtos= new ArrayList<>();
        for(BloodPressure bloodPressure : bloodPressures) {
            bloodPressureResponseDtos.add(new BloodPressureResponseDto(bloodPressure));
        }
        return bloodPressureResponseDtos;
    };

    @Transactional
    public Long saveBP(BloodPressureRequestDto requestDto) {
        return bloodPressureRepository.save(requestDto.toEntity()).getId();
    }






    //BS
    public List<BloodSugarResponseDto> findAllBS() {
        List<BloodSugar> bloodSugars = bloodSugarRepository.findAll();
        List<BloodSugarResponseDto> bloodSugarResponseDtos= new ArrayList<>();
        for(BloodSugar bloodSugar : bloodSugars) {
            bloodSugarResponseDtos.add(new BloodSugarResponseDto(bloodSugar));
        }
        return bloodSugarResponseDtos;
    };

    @Transactional
    public Long saveBS(BloodSugarRequestDto requestDto) {
        return bloodSugarRepository.save(requestDto.toEntity()).getId();
    }
}
