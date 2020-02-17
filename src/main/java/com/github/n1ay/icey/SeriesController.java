package com.github.n1ay.icey;

import com.github.n1ay.icey.data.model.Series;
import com.github.n1ay.icey.data.repository.SeriesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SeriesController {

    final SeriesRepository seriesRepository;

    public SeriesController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/")
    public List<String> list() {
        List<String> titles = new ArrayList<>();
        seriesRepository.findAll().forEach(series -> titles.add(series.getTitle()));
        return titles;
    }

    @PostMapping("/")
    public String post() {
        Series series = new Series();
        series.setTitle(UUID.randomUUID().toString());
        seriesRepository.save(series);
        return series.getTitle();
    }
}
