package za.co.nedbank.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import za.co.nedbank.data.model.CarMake;
import za.co.nedbank.data.repo.CarMakeRepository;

import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Log(topic = "SERVICE")
@RequiredArgsConstructor
public class AutomotiveService {
    private final CarMakeRepository repository;

    public Map<String, Long> getCountTrendPerCarMake() {
        return StreamSupport.stream(
                repository.findAll().spliterator(),
                false
        ).collect(Collectors.groupingBy(CarMake::getMake, Collectors.counting()));
    }

    public Map<String, Long> getCountTrendPerYearModel() {
        return StreamSupport.stream(
                repository.findAll().spliterator(),
                false
        ).collect(Collectors.groupingBy(CarMake::getYearModel, Collectors.counting()));
    }

    public Map<String, Long> getAverageYearlyProductionRate() {
        return StreamSupport.stream(
                repository.findAll().spliterator(),
                false
        ).collect(Collectors.groupingBy(CarMake::getYear, Collectors.counting()));
    }
}
