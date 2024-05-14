package racingcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.domain.RacingCar;
import racingcar.dto.RacingRequestDto;
import racingcar.dto.RacingResponseDto;
import racingcar.service.GetRacingCarResultService;
import racingcar.service.RaceService;
import racingcar.service.RacingCarResult;
import racingcar.service.SaveRacingCarService;

import java.util.List;

@RestController
public class RacingController {
    private final RaceService raceService;
private final SaveRacingCarService saveRacingCarService;

private final GetRacingCarResultService getRacingCarResultService;

    @Autowired
    public RacingController(RaceService raceService, SaveRacingCarService saveRacingCarService, GetRacingCarResultService getRacingCarResultService) {
        this.raceService = raceService;
        this.saveRacingCarService = saveRacingCarService;
        this.getRacingCarResultService = getRacingCarResultService;
    }

    @PostMapping("/plays")
    public ResponseEntity<RacingResponseDto> start(@RequestBody RacingRequestDto racingRequestDto){
        List<RacingCar> cars = raceService.carInit(racingRequestDto.getNames());
        RacingCarResult racingCarResult = raceService.race(cars, racingRequestDto.getCount());
        saveRacingCarService.saveRacingCarResult(racingCarResult);
        RacingResponseDto racingResponseDto= new RacingResponseDto(racingCarResult.getWinners(),racingCarResult.getCars());


        return ResponseEntity.ok().body(racingResponseDto);
    }

    @GetMapping("/plays")
    public ResponseEntity<List<RacingResponseDto>> playRacingCar() {

        List<RacingResponseDto> racingResponseDtos = getRacingCarResultService.getRacingCarResult();
        return ResponseEntity.ok().body(racingResponseDtos);
    }
}
