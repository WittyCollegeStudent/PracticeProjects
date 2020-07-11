package springdemo.di;

import org.junit.Test;
import springdemo.di.interfaces.Quest;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest quest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
        verify(quest, times(1)).embark();
    }

    @Test
    public void mockList() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(anyInt())).thenReturn("first");

        //following prints "first"
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        //following throws runtime exception
//        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList, times(1)).get(0);
        //argument matchers can also be written as Java 8 Lambdas
        mockedList.add("100");
        verify(mockedList).add(argThat((String str) -> str.length() < 5));
//        verify(mockedList).add(argThat((String someString) -> someString.length() > 5));

    }

}