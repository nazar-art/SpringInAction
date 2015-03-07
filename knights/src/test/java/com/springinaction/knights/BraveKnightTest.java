package com.springinaction.knights;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        Quest mockQuest = mock(Quest.class);     //<co id="co_createMockQuest"/>

        BraveKnight knight = new BraveKnight(mockQuest); //<co id="co_injectMockQuest"/>
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }
}
