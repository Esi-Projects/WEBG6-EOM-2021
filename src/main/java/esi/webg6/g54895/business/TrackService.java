package esi.webg6.g54895.business;

import esi.webg6.g54895.db.TrackRepository;
import esi.webg6.g54895.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public void updateTrackStream(Long trackId, Long stream){
        trackRepository.updateTrackStream(trackId, stream);
    }

    public List<Track> getTracksByStreamGreaterThanEqual(Long stream){
        return trackRepository.findByStreamGreaterThanEqual(stream);
    }
}
