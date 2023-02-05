package training.restapi.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String userName;

    public Video() {
    }
}