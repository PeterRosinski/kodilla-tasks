package com.crud.tasks.trello.client;

import com.crud.tasks.controller.TrelloBoardNotFoundException;
import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.api.key}")
    private String trelloAppKey;

    @Value("${trello.api.token}")
    private String trelloToken;

    @Value("${trello.username}")
    private String trelloUsername;

    private URI buildUrl() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
    }

    public List<TrelloBoardDto> getTrelloBoards() throws TrelloBoardNotFoundException {

        return Optional.ofNullable(Arrays.asList(restTemplate.getForObject(buildUrl(), TrelloBoardDto[].class))).orElseThrow(TrelloBoardNotFoundException::new);

    }
}
