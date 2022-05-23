package esi.webg6.g54895.web;

import esi.webg6.g54895.business.ArtistService;
import esi.webg6.g54895.business.TrackService;
import esi.webg6.g54895.model.Artist;
import esi.webg6.g54895.model.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TrackController {

    @Autowired
    private final TrackService trackService;

    @Autowired
    private final ArtistService artistService;

    @PostMapping("/artist")
    public String updateTrackStream(@RequestParam(name = "login") String login,
                                    @Valid Track track,
                                    Errors errors,
                                    Model model) {
        if (errors.hasErrors()) {
            Artist artist = artistService.getArtistByLogin(login);
            model.addAttribute("artist", artist);
            model.addAttribute("errors", errors.getFieldErrors());
            return "artist_detail";
        }
        System.out.println(track.toString());
        trackService.updateTrackStream(track.getId(), track.getStream());
        return "redirect:/artist?login=" + login;
    }
}
