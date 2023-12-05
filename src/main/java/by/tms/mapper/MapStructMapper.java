package by.tms.mapper;

import by.tms.dto.CatalogProductDto;
import by.tms.dto.LoginUserDto;
import by.tms.dto.ProductConfigurationDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.User;
import by.tms.entity.catalogProduct.ProductConfiguration;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    Optional<User> registrationUserDtoToUser(RegistrationUserDto registrationUserDto);
    Optional<LoginUserDto> userToLoginUserDto(User user);
    Optional<ProductConfigurationDto> productToProductConfigurationDto(ProductConfiguration productConfiguration);
    Optional<CatalogProductDto> productToCatalogProduct(ProductConfiguration productConfiguration);


}
