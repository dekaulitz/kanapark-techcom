package com.github.dekalitz.kanaparktechcom.domain.model;

import com.github.dekalitz.kanaparktechcom.domain.model.constant.CurrencyCode;
import com.github.dekalitz.kanaparktechcom.domain.model.constant.LanguageCode;
import com.github.dekalitz.kanaparktechcom.domain.model.constant.ProductStatus;
import com.github.dekalitz.kanaparktechcom.domain.model.constant.ProductType;
import com.github.dekalitz.kanaparktechcom.domain.model.embeddable.EventDetails;
import com.github.dekalitz.kanaparktechcom.domain.model.embeddable.Images;
import com.github.dekalitz.kanaparktechcom.domain.model.embeddable.ProductPackage;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class ModelProduct extends ModelBase implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private ProductType productType;
  private String timeZone;
  private ProductStatus status;
  private CurrencyCode currency;
  private Map<LanguageCode, String> productName;
  private Map<LanguageCode, String> productDescription;
  private Map<LanguageCode, String> productUrls;
  private Images images;
  private String categoryId;
  private Set<String> subcategoryIds;
  private EventDetails eventDetails;
  private Set<String> tags;
//  private List<ProductPackage> packages;
  private String partnerId;
  private long popularityScore;
  private long startingPrice;

}
