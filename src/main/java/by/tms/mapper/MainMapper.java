package by.tms.mapper;

import by.tms.dto.CatalogProductDto;
import by.tms.dto.LoginUserDto;
import by.tms.dto.ProductConfigurationDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.product.Product;
import by.tms.entity.Promotion;
import by.tms.entity.User;
import by.tms.entity.product.ProductConfiguration;
import by.tms.entity.product.VariationOption;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
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
    public Optional<ProductConfigurationDto> productToProductConfigurationDto(Product product) {
        if(product == null) {
            return Optional.empty();
        }

        ProductConfigurationDto productConfigurationDto = new ProductConfigurationDto();

        productConfigurationDto.setName(product.getName());
        productConfigurationDto.setPrice(product.getPrice());
        productConfigurationDto.setPromotion(product.);
        productConfigurationDto.setImage(product.getImage());
        productConfigurationDto.setPartNumber(product.getPartNumber());
        productConfigurationDto.setDescription(product.getDescription());
        productConfigurationDto.setVariationOptions(product.);

        return Optional.of(productConfigurationDto);
    }

    @Override
    public Optional<CatalogProductDto> productToCatalogProduct(Product product) {
        if(product == null){
            return Optional.empty();
        }

        CatalogProductDto catalogProductDto = new CatalogProductDto();

        catalogProductDto.setName(product.getName());
        catalogProductDto.setPrice(product.getPrice());
        catalogProductDto.setPromotion(product.);
        catalogProductDto.setImage(product.getImage());

        return Optional.of(catalogProductDto);
    }

}
