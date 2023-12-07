package by.tms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.management.relation.Role;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
public class RegistrationUserDto {

    @NotEmpty
    @NotBlank
    @Range(min = 2,max = 16)
    private String username;

    @NotEmpty
    @NotBlank
    private String emailAddress;

    @NotEmpty
    @NotBlank
    private String phoneNumber;

    @NotEmpty
    @NotBlank
    @Range(min = 2,max = 16)
    private String password;


    public  RegistrationUserDto(){}
}



