package esi.webg6.g54895.rest;

import esi.webg6.g54895.business.TrackService;
import esi.webg6.g54895.model.Artist;
import esi.webg6.g54895.model.Track;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TrackRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackService trackService;

    @Test
    void getTrackByStreamGreaterThan() throws Exception {
        long stream = 123456789;
        Artist artist = new Artist("mockito", "Mockito MVC Artist");
        Track track = new Track(1, "Mockito MVC Track", 123456789, artist);
        Mockito.when(trackService.getTracksByStreamGreaterThanEqual(stream)).thenReturn(Arrays.asList(track));
        mockMvc.perform(get("/api/tracks").param("stream", String.valueOf(stream)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stream").value(stream));
    }
}