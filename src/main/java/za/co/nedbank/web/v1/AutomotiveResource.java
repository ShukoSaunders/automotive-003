package za.co.nedbank.web.v1;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import za.co.nedbank.service.AutomotiveService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/automotive")
@Tag(name = "Automotive Resource", description = "Vehicles Data REST API")
public class AutomotiveResource {
    private final AutomotiveService service;

    @GetMapping("/getCountTrendPerCarMake")
    @Operation(summary = "Get Vehicle Count Trend Per Make")
    public Map<String, Long> getCountTrendPerCarMake() {
        return service.getCountTrendPerCarMake();
    }

    @GetMapping("/getCountTrendPerYearModel")
    @Operation(summary = "Get Vehicle Count Trend Per Model")
    public Map<String, Long> getCountTrendPerYearModel() {
        return service.getCountTrendPerYearModel();
    }

    @GetMapping("/getAverageYearlyProductionRate")
    @Operation(summary = "Get Vehicle Average Yearly Production Rate")
    public Map<String, Long> getAverageYearlyProductionRate() {
        return service.getAverageYearlyProductionRate();
    }
}

