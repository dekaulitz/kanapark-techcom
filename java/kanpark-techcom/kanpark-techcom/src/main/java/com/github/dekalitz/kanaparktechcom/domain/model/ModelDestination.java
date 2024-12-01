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
@AllArgsConstructor
public class ModelDestination extends ModelBase implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private Images images;
  private String rating;
  private Map<LanguageCode, String> descriptions;
  private String code;
  private boolean isActive;
  private Map<LanguageCode, String> name;
}
