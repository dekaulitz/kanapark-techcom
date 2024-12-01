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
public class Commission implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private String type; // e.g., "percentage" or "amount"
  private double value;
}
