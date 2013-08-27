package ru.bsc.alfa.protocol.elements.responses.catalog;

import ru.bsc.alfa.protocol.back.OperationId;
import ru.bsc.alfa.protocol.back.ProtocolMarkupObject;
import ru.bsc.alfa.protocol.elements.composite.CatalogElement;

import java.util.ArrayList;

/**
 * @author rmalyshev
 *         date: 31.10.12
 */
@OperationId("Catalog:Catalog")
public class GetCatalogResponse extends ProtocolMarkupObject<ArrayList<CatalogElement>> {
}
