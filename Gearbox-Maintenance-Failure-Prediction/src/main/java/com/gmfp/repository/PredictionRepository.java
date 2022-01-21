package com.gmfp.repository;

import com.gmfp.model.PredictionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<PredictionModel, Integer> {
//    Optional<PredictionModel> findByS1S2S3S4AndLoad(Double s1,Double s2,Double s3,Double s4, Integer load);

    @Override
    List<PredictionModel> findAll();
}
