package br.com.mastertech.access.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import javax.validation.constraints.NotNull;

public class AccessResponse {

    @JsonProperty("porta_id")
    private Long doorId;

    @JsonProperty("cliente_id")
    private Long customerId;

    public Long getDoorId() {
        return doorId;
    }

    public void setDoorId(Long doorId) {
        this.doorId = doorId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
