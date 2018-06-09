package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void TestMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloList1 = new ArrayList<>();
        List<TrelloListDto> trelloList2 = new ArrayList<>();
        trelloList1.add(new TrelloListDto("id1","list1",true));
        trelloList1.add(new TrelloListDto("id2", "list2", false));
        trelloList2.add(new TrelloListDto("id3", "list3", true));
        trelloBoardDto.add(new TrelloBoardDto("board1", "id1", trelloList1));
        trelloBoardDto.add(new TrelloBoardDto("board2", "id2", trelloList2));
        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDto);
        //Then
        assertEquals("board1", trelloBoard.get(0).getName());
        assertEquals(2,trelloBoard.get(0).getLists().size());
        assertEquals("board2", trelloBoard.get(1).getName());
        assertEquals(1,trelloBoard.get(1).getLists().size());
    }

    @Test
    public void TestMapToBoardsDto() {
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        List<TrelloList> trelloList1 = new ArrayList<>();
        List<TrelloList> trelloList2 = new ArrayList<>();
        trelloList1.add(new TrelloList("id1","list1",true));
        trelloList1.add(new TrelloList("id2", "list2", false));
        trelloList2.add(new TrelloList("id3", "list3", true));
        trelloBoard.add(new TrelloBoard("board1", "id1", trelloList1));
        trelloBoard.add(new TrelloBoard("board2", "id2", trelloList2));
        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals("board1", trelloBoardDto.get(0).getName());
        assertEquals(2,trelloBoardDto.get(0).getLists().size());
        assertEquals("board2", trelloBoardDto.get(1).getName());
        assertEquals(1,trelloBoardDto.get(1).getLists().size());
    }

    @Test
    public void TestMapToList() {
        //When
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("id1","list1",true));
        trelloListDto.add(new TrelloListDto("id2", "list2", false));
        //Given
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals(2,trelloList.size());
    }

    @Test
    public void TestMapToListDto() {
        //When
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("id1","list1",true));
        trelloList.add(new TrelloList("id2", "list2", false));
        //Given
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        //Then
        assertEquals(2,trelloListDto.size());
    }

    @Test
    public void TestMapToCardDto() {
        //When
        TrelloCard trellocard = new TrelloCard("name", "description", "pos", "id");
        //Given
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trellocard);
        //Then
        assertEquals("name", trelloCardDto.getName());
        assertEquals("description", trelloCardDto.getDescription());
        assertEquals("pos", trelloCardDto.getPos());
        assertEquals("id", trelloCardDto.getIdList());
    }

    @Test
    public void TestMapToCard() {
        //When
        TrelloCardDto trellocardDto = new TrelloCardDto("name", "description", "pos", "id");
        //Given
        TrelloCard trelloCard = trelloMapper.mapToCard(trellocardDto);
        //Then
        assertEquals("name", trelloCard.getName());
        assertEquals("description", trelloCard.getDescription());
        assertEquals("pos", trelloCard.getPos());
        assertEquals("id", trelloCard.getListId());

    }
}