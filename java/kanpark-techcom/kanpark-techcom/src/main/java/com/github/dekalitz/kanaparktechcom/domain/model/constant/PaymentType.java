package com.github.dekalitz.kanaparktechcom.domain.model.constant;

public enum PaymentType {
  // Pembayaran segera atau di muka
  IMMEDIATE("Immediately", "Pembayaran segera atau di muka"),

  // Pembayaran per bulan
  MONTHLY_PAYMENT("Monthly Payment", "Pembayaran bulanan"),

  // Pembayaran berkala (kuartalan, tahunan, dll)
  PERIODIC_PAYMENT("Periodic Payment", "Pembayaran berkala");

  private final String name;
  private final String description;

  // Constructor
  PaymentType(String name, String description) {
    this.name = name;
    this.description = description;
  }

  // Getter for name
  public String getName() {
    return name;
  }

  // Getter for description
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return name + ": " + description;
  }
}
