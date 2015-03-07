package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static com.habuma.spitter.mvc.HomeController.DEFAULT_SPITTLES_PER_PAGE;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles =
                asList(new Spittle(), new Spittle(), new Spittle());

        SpitterService spitterService = mock(SpitterService.class);//<co id="co_mockSpitterService"/>

        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).
                thenReturn(expectedSpittles);

        HomeController controller =
                new HomeController(spitterService); //<co id="co_createController"/>

        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model); //<co id="co_callShowHomePage"/>

        assertEquals("home", viewName);

        assertSame(expectedSpittles, model.get("spittles")); //<co id="co_assertResults"/>
        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }
}
