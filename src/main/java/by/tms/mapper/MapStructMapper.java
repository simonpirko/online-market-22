package by.tms.mapper;

import by.tms.dto.CatalogProductDto;
import by.tms.dto.LoginUserDto;
import by.tms.dto.ProductConfigurationDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.User;
import by.tms.entity.product.ProductConfiguration;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    User registrationUserDtoToUser(RegistrationUserDto registrationUserDto);
    LoginUserDto userToLoginUserDto(User user);
    ProductConfigurationDto productToProductConfigurationDto(ProductConfiguration productConfiguration);
    CatalogProductDto productToCatalogProduct(ProductConfiguration productConfiguration);

}
