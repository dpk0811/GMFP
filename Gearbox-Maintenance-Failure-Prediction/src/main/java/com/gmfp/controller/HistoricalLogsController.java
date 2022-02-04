package com.gmfp.controller;

import com.gmfp.model.HistoricalLogsModel;
import com.gmfp.service.HistoricalLogsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class HistoricalLogsController {

    @Autowired
    private final HistoricalLogsService historicalLogsService;

    public HistoricalLogsController(HistoricalLogsService historicalLogsService) {
        this.historicalLogsService = historicalLogsService;
    }

    @GetMapping("/historical")
    public String getHistoricalPage(Model model)
    {
        model.addAttribute("historicalRequest", new HistoricalLogsModel());
        return "historical_page";
    }

    @PostMapping("/addLogs")
    public HistoricalLogsModel addLog(@RequestParam(value="s1")Double s1, @RequestParam(value="s2")Double s2, @RequestParam(value="s3")Double s3, @RequestParam(value="s4")Double s4,
    @RequestParam(value="load")Integer load, @RequestParam(value="status")String status, @RequestParam(value="datetime")String datetime) 
    {
        HistoricalLogsModel historicalLogsModel = historicalLogsService.addLog(s1, s2, s3, s4, load, status, datetime);
        return historicalLogsModel;
    }
}
