package com.github.dekalitz.kanaparktechcom.domain.model.embeddable;

import com.github.dekalitz.kanaparktechcom.domain.model.constant.LanguageCode;
import com.github.dekalitz.kanaparktechcom.domain.model.constant.PricingType;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPackage implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private PricingType pricingType;
  private String packageId;
  private Map<LanguageCode, String> packageName;
  private double price;
  private int quantityAvailable;
  private List<PackagePriceTier> priceTiers;
}
