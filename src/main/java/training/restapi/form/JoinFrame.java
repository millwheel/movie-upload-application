package training.restapi.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinFrame {
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
}
