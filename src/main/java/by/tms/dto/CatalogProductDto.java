package by.tms.dto;

/*
    @author Ilya Moiseenko on 27.11.23
*/

import by.tms.entity.Promotion;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogProductDto {

    private String name;
    private BigDecimal price;
    private Promotion promotion;
    private byte[] image;
}
