package by.tms.mapper;

import by.tms.dto.CatalogProductDto;
import by.tms.dto.LoginUserDto;
import by.tms.dto.ProductConfigurationDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.User;
import by.tms.entity.catalogProduct.ProductConfiguration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MainMapper implements MapStructMapper{
    @Override
    public Optional<User> registrationUserDtoToUser(RegistrationUserDto registrationUserDto) {
        if(registrationUserDto == null){
            return Optional.empty();
        }

        User user = new User();

        user.setEmailAddress(registrationUserDto.getEmailAddress());
        user.setPhoneNumber(registrationUserDto.getPhoneNumber());
        user.setPassword(registrationUserDto.getPassword());

        return Optional.of(user);
    }

    @Override
    public Optional<LoginUserDto> userToLoginUserDto(User user) {
        if(user == null) {
            return Optional.empty();
        }

        LoginUserDto loginUserDto = new LoginUserDto();

        loginUserDto.setPhoneNumber(user.getPhoneNumber());
        loginUserDto.setPassword(user.getPassword());

        return Optional.of(loginUserDto);
    }

    @Override
    public Optional<ProductConfigurationDto> productToProductConfigurationDto(ProductConfiguration productConfiguration) {
        if(productConfiguration == null) {
            return Optional.empty();
        }

        ProductConfigurationDto productConfigurationDto = new ProductConfigurationDto();

        productConfigurationDto.setName(productConfiguration.getProduct().getName());
        productConfigurationDto.setPrice(productConfiguration.getProduct().getPrice());
        productConfigurationDto.setPromotion(productConfiguration.getPromotion());
        productConfigurationDto.setImage(productConfiguration.getProduct().getImage());
        productConfigurationDto.setPartNumber(productConfiguration.getProduct().getPartNumber());
        productConfigurationDto.setDescription(productConfiguration.getProduct().getDescription());
        productConfigurationDto.setVariationOptions(productConfiguration.getVariationOptions());

        return Optional.of(productConfigurationDto);
    }

    @Override
    public Optional<CatalogProductDto> productToCatalogProduct(ProductConfiguration productConfiguration) {
        if(productConfiguration == null){
            return Optional.empty();
        }

        CatalogProductDto catalogProductDto = new CatalogProductDto();

        catalogProductDto.setName(productConfiguration.getProduct().getName());
        catalogProductDto.setPrice(productConfiguration.getProduct().getPrice());
        catalogProductDto.setPromotion(productConfiguration.getPromotion());
        catalogProductDto.setImage(productConfiguration.getProduct().getImage());

        return Optional.of(catalogProductDto);
    }

}
