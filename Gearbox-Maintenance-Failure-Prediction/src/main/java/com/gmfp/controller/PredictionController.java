package com.gmfp.controller;

import com.gmfp.model.PredictionModel;
import com.gmfp.service.HistoricalLogsService;
import com.gmfp.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PredictionController {

    List<PredictionModel> readRow;
    @Autowired
    private final PredictionService predictionService;

    // @Autowired
    // private final HistoricalLogsService historicalLogsService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
        //this.historicalLogsService = historicalLogsService;
    }

    @GetMapping("/prediction")
    public String getPredictionPage(@ModelAttribute PredictionModel predictionModel, Model model)
    {
        System.out.println("Predicting");
        readRow = predictionService.readData(predictionModel.getS1(),predictionModel.getS2(),
                predictionModel.getS3(),predictionModel.getS4(),predictionModel.getLoad());
        return "prediction_page";
    }

    // @PostMapping("/addLog")
    // public void addLog(@RequestParam(value="s1")Double s1, @RequestParam(value="s2")Double s2, @RequestParam(value="s3")Double s3, @RequestParam(value="s4")Double s4,
    // @RequestParam(value="load")Integer load, @RequestParam(value="status")String status, @RequestParam(value="datetime")String datetime) 
    // {
    //     historicalLogsService.addLog(s1, s2, s3, s4, load, status, datetime);
    // }
}
