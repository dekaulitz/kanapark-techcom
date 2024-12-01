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
public class Location implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private String venue;
  private String address;
  private String city;
  private String country;
  private String zipCode;
}
