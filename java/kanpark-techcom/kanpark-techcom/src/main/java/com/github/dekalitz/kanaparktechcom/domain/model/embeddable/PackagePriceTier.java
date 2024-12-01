package com.github.dekalitz.kanaparktechcom.domain.model.embeddable;

import com.github.dekalitz.kanaparktechcom.domain.model.constant.LanguageCode;
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
public class PackagePriceTier implements Serializable {

  @Serial
  private final static long serialVersionUID = 1L;
  private String tierId;
  private Map<LanguageCode, String> tierName; // lang : description
  private double price;
  private int minQuantity;
  private Commission commission;
}
