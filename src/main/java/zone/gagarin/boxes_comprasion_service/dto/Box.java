package zone.gagarin.boxes_comprasion_service.dto;

import javax.validation.constraints.NotNull;

public class Box {

  @NotNull
  private Double length;
  @NotNull
  private Double weight;
  @NotNull
  private Double height;

  public Box() {
  }

  public Box(Double length, Double weight, Double height) {
    this.length = length;
    this.weight = weight;
    this.height = height;
  }

  public Double getLength() {
    return length;
  }

  public void setLength(Double length) {
    this.length = length;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }
}
