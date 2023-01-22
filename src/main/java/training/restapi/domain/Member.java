package training.restapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirm;
    private Boolean membership;
}
