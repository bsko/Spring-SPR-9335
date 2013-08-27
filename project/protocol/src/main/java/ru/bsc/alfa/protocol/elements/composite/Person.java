package ru.bsc.alfa.protocol.elements.composite;

import com.google.gson.annotations.Since;

import java.io.Serializable;

/**
 * Yuri Khrustalyov
 * 29.03.12
 */

public class Person implements Serializable {

  @Since(1.0) private String firstName;
  @Since(1.0) private String middleName;
  @Since(1.0) private String lastName;

  public Person() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
