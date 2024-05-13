package racingcar.service;

import org.springframework.stereotype.Service;
import racingcar.domain.RacingCar;
import racingcar.dto.RacingResponseDto;
import racingcar.repository.dao.*;
import racingcar.repository.entity.GameEntity;
import racingcar.repository.entity.PositionEntity;
import racingcar.repository.entity.WinnerEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GetRacingCarResultService {
    private final JdbcUserDao jdbcUserDao;
    private final JdbcGameDao jdbcGameDao;
    private final JdbcPositionDao jdbcPositionDao;
    private final JdbcWinnerDao jdbcWinnerDao;

    public GetRacingCarResultService(JdbcUserDao jdbcUserDao, JdbcGameDao jdbcGameDao, JdbcPositionDao jdbcPositionDao, JdbcWinnerDao jdbcWinnerDao) {
        this.jdbcUserDao = jdbcUserDao;
        this.jdbcGameDao = jdbcGameDao;
        this.jdbcPositionDao = jdbcPositionDao;
        this.jdbcWinnerDao = jdbcWinnerDao;
    }

    public List<RacingResponseDto> getRacingCarResult(){
        List<RacingResponseDto> racingResponseDtoList = new ArrayList<>();

        List<GameEntity> gameEntityList = jdbcGameDao.findAll();
        for (GameEntity gameEntity : gameEntityList) {
            RacingResponseDto racingResponseDto= new RacingResponseDto(getWinners(jdbcWinnerDao.findByGameId(gameEntity.getId())),
                    getCars(jdbcPositionDao.findByGameId(gameEntity.getId())));
            racingResponseDtoList.add(racingResponseDto);
        }
        return racingResponseDtoList;
    }

    private List<String> getWinners(List<WinnerEntity> winnerEntityList){
        List<String> winners= winnerEntityList.stream()
                .map(WinnerEntity-> jdbcUserDao.findById(WinnerEntity.getUserId()).getName())
                .collect(toList());

        return winners;
    }
    private List<RacingCar> getCars(List<PositionEntity> positionEntityList){
        List<RacingCar> cars = positionEntityList.stream()
                .map(PositionEntity-> new RacingCar(jdbcUserDao.findById(PositionEntity.getUserId()).getName(),
                        PositionEntity.getPosition()))
                .collect(toList());

        return cars;
    }

}
