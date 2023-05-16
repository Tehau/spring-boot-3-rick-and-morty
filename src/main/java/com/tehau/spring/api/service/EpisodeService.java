package com.tehau.spring.api.service;

import com.tehau.spring.api.model.Episode;
import com.tehau.spring.api.repository.EpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    private EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }


    public List<Episode> findAll() {
        return episodeRepository.findAll();
    }

    public Optional<Episode> findById(Long id){
        return episodeRepository.findById(id);
    }

    public Episode save(Episode episode) {
        return episodeRepository.save(new Episode(episode.getUrl()));
    }

    public void deleteById(Long id) {
        episodeRepository.deleteById(id);
    }

    public Episode update(long id , Episode newEpisode) {
        return findById(id)
                .map(episode_db -> {
                    episode_db.setUrl(newEpisode.getUrl());
                    return episodeRepository.save(episode_db);
                }).orElseGet(() -> {
                    return episodeRepository.save(newEpisode);
                });
    }
}
