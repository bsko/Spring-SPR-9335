package ru.bsc.alfa.protocol.elements.responses.catalog;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.CatalogElement;

/**
 * @author rmalyshev
 *         date: 31.10.12
 */
@OperationId("Catalog:Item")
public class GetItemResponse extends ProtocolMarkupObject<CatalogElement> {
}
