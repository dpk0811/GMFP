package com.gmfp.service;

import com.gmfp.model.HistoricalLogsModel;
import com.gmfp.repository.HistoricalLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalLogsService {

    @Autowired
    private final HistoricalLogsRepository historicalLogsRepository;

    public HistoricalLogsService(HistoricalLogsRepository historicalLogsRepository) {
        this.historicalLogsRepository = historicalLogsRepository;
    }

    public List<HistoricalLogsModel> readData(Double s1, Double s2, Double s3, Double s4, Integer load,String status, String datetime)
    {
        List<HistoricalLogsModel> historicalLogsModel = historicalLogsRepository.findAll();

        return historicalLogsModel;
    }
    
}
