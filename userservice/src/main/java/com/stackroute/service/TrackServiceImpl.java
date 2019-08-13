package com.stackroute.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Service
public class TrackServiceImpl implements TrackService
{
   /* HttpURLConnection httpURLConnection;

    String URL="http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=spain&api_key=570552d5d79081a6120c14a93d74d147&format=json";
*/
    TrackRepository trackRepository;

    // Providing implementation for all methods of track
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }




    @Override
    public Track saveTrack(Track track) throws Exception
    {
        if(trackRepository.existsById(track.getId()))
        {
            throw new Exception("Track Already exist");
        }
        Track savetrack=trackRepository.save(track);

        if(savetrack==null)
        {
            throw new Exception("Track already present");
        }
        return savetrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track)  throws Exception
    {
        if (trackRepository.existsById(track.getId())) {
            Track trackobj = trackRepository.findById(track.getId()).get();
            trackobj.setComment(track.getComment());
            trackRepository.save(trackobj);
            return trackobj;
        } else {
            throw new Exception("Track not found");
        }
    }

    @Override
    public void deleteTrack(int id)
    {
        trackRepository.deleteById(id);
    }


}