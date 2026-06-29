package com.paysafe.payments.serialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysafe.payments.model.settlement.Settlement;

public class SettlementListOrObjectDeserializer extends JsonDeserializer<List<Settlement>> {
  @Override
  public List<Settlement> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    ObjectMapper mapper = (ObjectMapper) p.getCodec();
    JsonNode node = mapper.readTree(p);
    List<Settlement> settlements = new ArrayList<>();
    if (node.isArray()) {
      for (JsonNode item : node) {
        settlements.add(mapper.treeToValue(item, Settlement.class));
      }
    } else if (node.isObject()) {
      settlements.add(mapper.treeToValue(node, Settlement.class));
    }
    return settlements;
  }
}