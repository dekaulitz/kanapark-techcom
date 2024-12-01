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

@ToString
@EqualsAndHashCode(callSuper = false)
public class ModelCountry extends ModelBase implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private Images images;
  private String rating;
  private Map<LanguageCode, String> description;
  private String code;
  private boolean isActive;
  private Map<LanguageCode, String> name;
}
