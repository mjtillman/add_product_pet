package com.AddPets;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="pets")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="name", length=100)
  private String name;

  @Column(name="animal", length=100)
  private String animalType;

  @Column(name="color", length=100)
  private String color;

  @Column(name="adoption_fee")
  private BigDecimal adoptionFee;

  public Pet() {}

  public Pet(String name, String animalType, String color, String adoptionFee) {
    this.name = name;
    this.animalType = animalType;
    this.color = color;
    this.adoptionFee = BigDecimal.valueOf(Float.parseFloat(adoptionFee));
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public BigDecimal getAdoptionFee() {
    return adoptionFee;
  }

  public void setAdoptionFee(String adoptionFee) {
    this.adoptionFee = BigDecimal.valueOf(Float.parseFloat(adoptionFee));
  }
}
