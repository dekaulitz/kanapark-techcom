package com.github.dekalitz.kanaparktechcom.domain.model.embeddable;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Images implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private String small;
  private String medium;
  private String large;

}
