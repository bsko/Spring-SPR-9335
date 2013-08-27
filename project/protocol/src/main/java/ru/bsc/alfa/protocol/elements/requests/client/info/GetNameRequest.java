package ru.bsc.alfa.protocol.elements.requests.client.info;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolObject;

/**
 * @author R. Malyshev
 */
@OperationId("ClientInfo:GetName")
public class GetNameRequest extends ProtocolObject {
  private static final long serialVersionUID = -5381620684253325676L;
}
