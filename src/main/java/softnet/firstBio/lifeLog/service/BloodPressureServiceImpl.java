package softnet.firstBio.lifeLog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.dto.BloodPressureRequestDto;
import softnet.firstBio.lifeLog.dto.BloodPressureResponseDto;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BloodPressureServiceImpl {
    private final BloodPressureRepository bloodPressureRepository;

    public List<BloodPressureResponseDto> findAll() {
        List<BloodPressure> bloodPressures = bloodPressureRepository.findAll();
        List<BloodPressureResponseDto> bloodPressureResponseDtos= new ArrayList<>();
        for(BloodPressure bloodPressure : bloodPressures) {
            bloodPressureResponseDtos.add(new BloodPressureResponseDto(bloodPressure));
        }
        return bloodPressureResponseDtos;
    };

    public BloodPressureResponseDto findById(Long id) {
        BloodPressure bloodPressure = bloodPressureRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 혈압데이터가 없습니다. id="+id));
        return new BloodPressureResponseDto(bloodPressure);
    };

    @Transactional
    public Long save(BloodPressureRequestDto requestDto) {
        return bloodPressureRepository.save(requestDto.toEntity()).getId();
    }
}
