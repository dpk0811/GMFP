package com.gmfp.controller;

import com.gmfp.model.PredictionModel;
import com.gmfp.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class PredictionController {

    List<PredictionModel> readRow;
    @Autowired
    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/prediction")
    public String getPredictionPage(@ModelAttribute PredictionModel predictionModel, Model model)
    {
        System.out.println("Predicting");
        readRow = predictionService.readData(predictionModel.getS1(),predictionModel.getS2(),
                predictionModel.getS3(),predictionModel.getS4(),predictionModel.getLoad());
        return "prediction_page";
    }
}
