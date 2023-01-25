package training.restapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Video {
    private Long id;
    private String name;
    private String date;
    private String userName;
}