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
    
    public HistoricalLogsModel addLog(Double s1, Double s2, Double s3, Double s4, Integer load, String status, String datetime)
    {
        if(s1 == null && s2 == null && s3 == null && s4== null && load == null && status == null && datetime == null) {
            return null;
        }
        else
        {
            HistoricalLogsModel historicalModel = new HistoricalLogsModel();
            historicalModel.setS1(s1);
            historicalModel.setS2(s2);
            historicalModel.setS3(s3);
            historicalModel.setS4(s4);
            historicalModel.setLoad(load);
            historicalModel.setStatus(status);
            historicalModel.setDatetime(datetime);
            return historicalLogsRepository.save(historicalModel);
        }
    }
}
