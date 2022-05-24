package esi.webg6.g54895.rest;

import esi.webg6.g54895.business.TrackService;
import esi.webg6.g54895.model.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TrackRestController {

    @Autowired
    private final TrackService trackService;

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTrackByStreamGreaterThan(@RequestParam long stream) {
        List<Track> tracks = trackService.getTracksByStreamGreaterThanEqual(stream);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

}
