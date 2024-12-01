package com.github.dekalitz.kanaparktechcom.domain.model;

import com.github.dekalitz.kanaparktechcom.domain.model.constant.LanguageCode;
import com.github.dekalitz.kanaparktechcom.domain.model.embeddable.Images;
import java.io.Serial;
import java.io.Serializable;
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
public class ModelPromoBanner extends ModelBase implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Map<LanguageCode, String> title; // Untuk multi-language
  private Map<LanguageCode, String> description; // Untuk multi-language
  private String startDate;
  private String endDate;
  private String discountType;
  private Double discountValue;
  private Double minimumPurchase; // Bisa null jika tidak ada minimum pembelian
  private Map<LanguageCode, String> termsConditions; // Untuk multi-language
  private boolean isActive;
  private Images images;
}
