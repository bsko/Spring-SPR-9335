package ru.bsc.alfa.protocol.markup;

import com.google.gson.annotations.Since;
import java.io.Serializable;

/**
 * Yuri Khrustalyov
 * 28.03.12
 */

public class Rendering implements Serializable {

  @Since(1.0) private Integer length;
  @Since(1.0) private String regex;
  @Since(1.0) private RenderingType renderingType;

  public Rendering() {
  }

  public Rendering(RenderingType renderingType) {
    this.renderingType = renderingType;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public RenderingType getRenderingType() {
    return renderingType;
  }

  public void setRenderingType(RenderingType renderingType) {
    this.renderingType = renderingType;
  }
}
