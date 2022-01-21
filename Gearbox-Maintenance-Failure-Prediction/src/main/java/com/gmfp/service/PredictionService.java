package com.gmfp.service;

import com.gmfp.model.PredictionModel;
import com.gmfp.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    @Autowired
    private final PredictionRepository predictionRepository;

    public PredictionService(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    public List<PredictionModel> readData(Double s1, Double s2, Double s3, Double s4, Integer load)
    {
        List<PredictionModel> predictionModel = predictionRepository.findAll();

        return predictionModel;
    }
}
