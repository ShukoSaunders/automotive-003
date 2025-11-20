package za.co.nedbank.data.model;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarMake implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String make;
    @Column(name = "car_year")
    private String year;
    private String color;
    private String model;
    @Enumerated(EnumType.STRING)
    private CarShape shape;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @Transient
    public String getYearModel() {
        return year + " " + model;
    }

    public static CarMake fromLine(String e) {
        String[] split = e.split(",");
        return CarMake.builder()
                .year(split[0])
                .color(split[1])
                .shape(CarShape.valueOf(split[2]))
                .make(split[3])
                .model(split[4])
                .transmissionType(TransmissionType.valueOf(split[5]))
                .fuelType(FuelType.valueOf(split[6]))
                .build();
    }
}
