package br.com.mastertech.door.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateDoorRequest {

    @NotNull
    @NotBlank
    @JsonProperty("andar")
    private String floor;

    @NotNull
    @NotBlank
    @JsonProperty("sala")
    private String room;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}

