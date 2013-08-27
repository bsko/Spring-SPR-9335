package ru.bsc.alfa.protocol.markup;

import com.google.gson.annotations.Since;

import java.io.Serializable;

/**
 * Поле сообщения в новом jmbp протоколе
 * @author Yuri Khrustalyov
 * 27.03.12
 */

public class Field<T extends Serializable> implements Serializable {

  @Since(1.0) private String name;
  @Since(1.0) private String description;
  @Since(1.0) private String hint;
  @Since(1.0) private Type type;

  @Since(1.0) private String defaultValue;

  @Since(1.0) private Boolean required;
  @Since(1.0) private Boolean visible;
  @Since(1.0) private Boolean isProtected;
  @Since(1.0) private Boolean confirmationScreenOnly;

  @Since(1.0) private Rendering rendering;

  @Since(1.0) private String contentType;

  @Since(1.0) private String validationErrorMessage;

  private T value;

  public Field() {
  }

  public String getName() {
    return name;
  }

  public Field<T> setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Field<T> setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getHint() {
    return hint;
  }

  public Field<T> setHint(String hint) {
    this.hint = hint;
    return this;
  }

  public Type getType() {
    return type;
  }

  public Field<T> setType(Type type) {
    this.type = type;
    return this;
  }

  public Rendering getRendering() {
    return rendering;
  }

  public Field<T> setRendering(Rendering rendering) {
    this.rendering = rendering;
    return this;
  }

  public T getValue() {
    return value;
  }

  public Field<T> setValue(T value) {
    this.value = value;
    return this;
  }

  public Boolean isRequired() {
    return required;
  }

  public Field<T> setRequired(Boolean required) {
    this.required = required;
    return this;
  }

  public Boolean isVisible() {
    return visible;
  }

  public Field<T> setVisible(Boolean visible) {
    this.visible = visible;
    return this;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public Field<T> setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  public String getContentType() {
    return contentType;
  }

  public Field<T> setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public String getValidationErrorMessage() {
    return validationErrorMessage;
  }

  public Field<T> setValidationErrorMessage(String validationErrorMessage) {
    this.validationErrorMessage = validationErrorMessage;
    return this;
  }

  public Boolean getProtected() {
    return isProtected;
  }

  public Field<T> setProtected(Boolean aProtected) {
    isProtected = aProtected;
    return this;
  }

  /**
   * Определяет, предназначено ли поле для хранения суммы.
   * @return true, если {@link RenderingType} поля равен {@code RenderingType.Amount}, иначе false.
   */
  public boolean isAmount() {
    return RenderingType.Amount.equals(this.getRendering().getRenderingType());
  }

  /**
   * Определяет, предназначено ли поле для хранения даты.
   * @return true, если {@link RenderingType} поля равен {@code RenderingType.Date}, иначе false.
   */
  public boolean isDate() {
    return RenderingType.Date.equals(this.getRendering().getRenderingType());
  }

  /**
   * Определяет, является ли поле видимым
   * @return {@code field.isVisible() || field.isRequired()}
   */
  public boolean isFieldVisible() {
    return this.isVisible() || this.isRequired();
  }

  public Boolean isConfirmationScreenOnly() {
    return confirmationScreenOnly;
}

  public void setConfirmationScreenOnly(Boolean confirmationScreenOnly) {
    this.confirmationScreenOnly = confirmationScreenOnly;
  }
}
