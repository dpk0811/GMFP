package com.gmfp.controller;
import java.util.List;

import com.gmfp.model.HistoricalLogsModel;
import com.gmfp.service.HistoricalLogsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricalLogsRestController {
    @Autowired
    private final HistoricalLogsService historicalLogsService;

    public HistoricalLogsRestController(HistoricalLogsService historicalLogsService) {
        this.historicalLogsService = historicalLogsService;
    }

    @RequestMapping("/historicallogs")
    public List<HistoricalLogsModel> getAllData(@ModelAttribute HistoricalLogsModel historicalLogsModel)
    {
        List<HistoricalLogsModel> readRow = historicalLogsService.readData(historicalLogsModel.getS1(),historicalLogsModel.getS2(),
        historicalLogsModel.getS3(),historicalLogsModel.getS4(),historicalLogsModel.getLoad(), historicalLogsModel.getStatus(), historicalLogsModel.getDatetime());
                return readRow;
    }

}
