package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testGetParametersFromConfig() {
        //Given
        //When
        //Then
        assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
        assertEquals("38ec3a02edea8c89477f039edba95628", trelloConfig.getTrelloAppKey());
        assertEquals("bf37e77de1aa02d1e74779ebfd87e53134ac925d57deef75be290c2bc0fcf8a1", trelloConfig.getTrelloToken());
        assertEquals("piotrrosinski1", trelloConfig.getTrelloUsername());
    }
}