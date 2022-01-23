package com.gmfp.controller;

import com.gmfp.model.HistoricalLogsModel;
import com.gmfp.service.HistoricalLogsService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


@Controller
public class HistoricalLogsController {
    public HistoricalLogsController(HistoricalLogsService historicalLogsService) {
    }


    @GetMapping("/historical")
    public String getHistoricalPage(Model model)
    {
        model.addAttribute("historicalRequest", new HistoricalLogsModel());
        return "historical_page";
    }
}
