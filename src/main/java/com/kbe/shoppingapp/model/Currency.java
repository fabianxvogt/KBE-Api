package com.kbe.shoppingapp.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Currency {

  @Transient
  public static final String SEQUENCE_NAME = "currency";

  private @Id String id;
  private String iso;
  private String name;
  private Float usdConversionRate;
  
  Currency() {}

  Currency(String name, Float usdConversionRate) {

    this.name = name;
    this.usdConversionRate = usdConversionRate;
    
  }
  public String getId() {
    return this.id;
  }  
  public void setId(String id) {
    this.id = id;
  }
  public String getIsoCode() {
    return this.iso;
  }

  public String getName() {
    return this.name;
  }
  public void setIsoCode(String iso) {
    this.iso = iso;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Currency))
      return false;
      Currency c = (Currency) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Currency{" + 
      "id=" + this.id + ", " + 
      "isoCode=" + this.iso + ", " + 
      "name='" + this.name + "\'," +
      "usdConversionRate=" + this.usdConversionRate + 
    "}";
  }

  public Float getUsdConversionRate() {
      return this.usdConversionRate;
  }  
  public void setUsdConversionRate(Float usdConversionRate) {
    this.usdConversionRate = usdConversionRate;
  }
}