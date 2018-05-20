package com.crud.tasks.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreatedTrelloCardBadges {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private CreatedTrelloCardBadgesAttachmentsByType attachmentsByType;
}
