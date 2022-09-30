package com.kbe.shoppingapp.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Product {
    
  @Transient
  public static final String SEQUENCE_NAME = "product";

  private @Id String id;
  private String name;
  private List<Component> components; 
  private List<String> componentIds; 
  private Float price;
  private String imageURL;
  private String description;
  private String categoryId;
  
  public Product() {}

  public Product(String name, String description, Float price, String imageURL, String categoryId, List<String> componentIds) {

    this.name = name;
    this.description = description;
    this.price = price;
    this.imageURL = imageURL;
    this.categoryId = categoryId;
    this.componentIds = componentIds;
  }

  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getCategoryId() {
    return this.categoryId;
  }
  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageURL() {
    return this.imageURL;
  }
  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Product))
      return false;
      Product c = (Product) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Product{" + 
      "id=" + this.id + ", " + 
      "name='" + this.name + "\'," +
      "description='" + this.description + "\'," +
      "price='" + this.getPrice() + "\'," +
      "imageURL='" + this.imageURL + "\'," +
    "}";
  }
  

  public void setPrice(Float price) {
    this.price = price;
  }
  public Float getPrice() {
    return this.price;
  }
  
  // public void setProductType(ProductType componentType) {
  //   this.componentType = componentType;
  // }
  // public ProductType getProductType() {
  //   return this.componentType;
  // }
  public void setComponents(List<Component> components) {
    this.components = components;
  }
  public List<Component> getComponents() {
    return this.components;
  }
  public void setComponentIds(List<String> componentIds) {
    this.componentIds = componentIds;
  }
  public List<String> getComponentIds() {
    return this.componentIds;
  }
}
