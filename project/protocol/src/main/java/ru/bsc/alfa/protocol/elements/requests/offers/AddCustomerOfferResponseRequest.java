package ru.bsc.alfa.protocol.elements.requests.offers;

import com.google.gson.annotations.Since;
import ru.bsc.alfa.protocol.back.JMBPOptional;
import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * author: esedyshev
 */
@OperationId("PreapprovedOffers:AddCustomerOfferResponse")
public class AddCustomerOfferResponseRequest extends ProtocolObject
{
  @Since(1.0) private boolean accepted;
  @Since(1.0) private Integer offerId;
  @Since(1.0) private Short offerSequence;

  @Since(1.0) @JMBPOptional
  private Integer denialCode;

  @Since(1.0) @JMBPOptional
  private String denialMessage;

  @Since(1.0) @JMBPOptional
  private String contactPhone;

  public AddCustomerOfferResponseRequest() {
  }


  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public Integer getOfferId() {
    return offerId;
  }

  public void setOfferId(Integer offerId) {
    this.offerId = offerId;
  }

  public Short getOfferSequence() {
    return offerSequence;
  }

  public void setOfferSequence(Short offerSequence) {
    this.offerSequence = offerSequence;
  }

  public Integer getDenialCode() {
    return denialCode;
  }

  public void setDenialCode(Integer denialCode) {
    this.denialCode = denialCode;
  }

  public String getDenialMessage() {
    return denialMessage;
  }

  public void setDenialMessage(String denialMessage) {
    this.denialMessage = denialMessage;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }
}
