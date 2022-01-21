package com.gmfp.controller;

import com.gmfp.model.PredictionModel;
import com.gmfp.model.UserModel;
import com.gmfp.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
        //model.addAttribute("readRow",  readRow);
        String[] s = PredictionTimer();
        try {
            Thread.sleep(1000);
        }catch (Exception exception){}
        model.addAttribute("s1", s[0]);
        model.addAttribute("s2", s[1]);
        model.addAttribute("s3", s[2]);
        model.addAttribute("s4", s[3]);
        model.addAttribute("load", s[4]);
        model.addAttribute("status", s[5]);
        model.addAttribute("allData", s);
        return "prediction_page";
    }

    private String[] PredictionTimer()
    {
        final String[] Status = new String[6];
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for(PredictionModel predictionModel: readRow)
                {
                    Status[0] = predictionModel.getS1().toString();
                    Status[1] = predictionModel.getS2().toString();
                    Status[2] = predictionModel.getS3().toString();
                    Status[3] = predictionModel.getS4().toString();
                    Status[4] = predictionModel.getLoad().toString();

                    if(((PredictionModel)predictionModel).getS1() < 4)
                        Status[5] = "Healthy";
                    else if(((PredictionModel)predictionModel).getS1() > 4 && ((PredictionModel)predictionModel).getS1() < 5.5)
                        Status[5] = "Due for Maintenance";
                    else
                        Status[5] = "Failure";
                }
            }
        };
        timer.schedule(timerTask, 50);
        return Status;
    }
}
