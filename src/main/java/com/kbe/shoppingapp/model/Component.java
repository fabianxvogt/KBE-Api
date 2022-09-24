package com.kbe.shoppingapp.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class Component {

  @Transient
  public static final String SEQUENCE_NAME = "component";

  private @Id String id;
  private String name;
  private String componentTypeId;
  private List<Component> components; 
  private List<String> componentIds; 
  //private ComponentType componentType;
  private Float usdPrice;
  
  Component() {}

  Component(String name, String componentTypeId, Float usdPrice, List<String> componentIds) {

    this.name = name;
    this.componentTypeId = componentTypeId;
    //this.componentType = componentType;
    this.usdPrice = usdPrice;
    this.componentIds = componentIds;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getComponentTypeId() {
    return this.componentTypeId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setComponentTypeId(String componentTypeId) {
    this.componentTypeId = componentTypeId;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Component))
      return false;
      Component c = (Component) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Component{" + 
      "id=" + this.id + ", " + 
      "name='" + this.name + "\'," +
      "componentTypeId=" + this.componentTypeId + 
    "}";
  }
  

  public void setUsdPrice(Float usdPrice) {
    this.usdPrice = usdPrice;
  }
  public Float getUsdPrice() {
    return this.usdPrice;
  }
  // public void setComponentType(ComponentType componentType) {
  //   this.componentType = componentType;
  // }
  // public ComponentType getComponentType() {
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