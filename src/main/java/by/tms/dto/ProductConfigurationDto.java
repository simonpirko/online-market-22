package by.tms.dto;

/*
    @author Ilya Moiseenko on 27.11.23
*/

import by.tms.entity.Promotion;
import by.tms.entity.catalogProduct.VariationOption;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductConfigurationDto {

    private String name;
    private BigDecimal price;
    private Promotion promotion;
    private byte[] image;
    private String partNumber;
    private String description;
    private List<VariationOption> variationOptions;
}
