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
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private double latitude;
  private double longitude;

}
