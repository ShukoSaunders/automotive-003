package za.co.nedbank.configuration;

import lombok.extern.java.Log;
import lombok.RequiredArgsConstructor;
import za.co.nedbank.data.model.CarMake;
import za.co.nedbank.data.repo.CarMakeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
@RequiredArgsConstructor
@Log(topic = "DATA_LOADER")
public class DataLoader implements CommandLineRunner {
    private final CarMakeRepository repository;
    @Value("${spring.data.file}")
    private String filePath;

    @Override
    public void run(String... args) throws Exception {
        List<CarMake> entries = Files.readAllLines(Paths.get(filePath))
                .stream()
                .skip(1)
                .map(CarMake::fromLine)
                .toList();
        repository.saveAll(entries);
    }
}
