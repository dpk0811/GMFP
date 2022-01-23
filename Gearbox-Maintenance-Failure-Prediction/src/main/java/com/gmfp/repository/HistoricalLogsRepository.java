package com.gmfp.repository;

import com.gmfp.model.HistoricalLogsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricalLogsRepository extends JpaRepository<HistoricalLogsModel,Integer> {
    
    @Override
    List<HistoricalLogsModel> findAll();

    

}
