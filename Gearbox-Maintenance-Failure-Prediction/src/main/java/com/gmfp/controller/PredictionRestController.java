package com.gmfp.controller;

import java.util.List;

import com.gmfp.model.PredictionModel;
import com.gmfp.service.PredictionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionRestController {
    
    @Autowired
    private final PredictionService predictionService;

    public PredictionRestController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @RequestMapping("/getData")
    public List<PredictionModel> getAllData(@ModelAttribute PredictionModel predictionModel)
    {
        List<PredictionModel> readRow = predictionService.readData(predictionModel.getS1(),predictionModel.getS2(),
                predictionModel.getS3(),predictionModel.getS4(),predictionModel.getLoad());
                return readRow;
    }
}
