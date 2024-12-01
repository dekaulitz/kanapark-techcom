package com.github.dekalitz.kanaparktechcom.application.dto.param;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
public class ParamBase implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private long limit = 8;

}
