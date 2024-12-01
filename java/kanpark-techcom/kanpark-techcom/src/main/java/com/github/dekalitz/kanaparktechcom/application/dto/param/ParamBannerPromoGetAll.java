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
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ParamBannerPromoGetAll extends ParamBase implements Serializable {

  @Serial
  private final static long serialVersionUID = 1L;

}
