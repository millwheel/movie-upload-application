package training.restapi.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Boolean membership;

    public Member() {
    }

    public Member(String name, String email, String password, Boolean membership) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.membership = membership;
    }
}
