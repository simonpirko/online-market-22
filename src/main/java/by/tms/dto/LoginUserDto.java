package by.tms.dto;


import by.tms.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


import javax.transaction.Transactional;

@Getter
@Setter
@ToString
public class LoginUserDto {

    @NotEmpty
    @NotBlank
    private String phoneNumber;

    @NotEmpty
    @NotBlank
    @Range(min = 2,max = 16)
    private String password;
    public LoginUserDto(){}
}



