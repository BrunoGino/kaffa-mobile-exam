package br.com.kaffaquestion7.kaffaquestion7.controller;

import br.com.kaffaquestion7.kaffaquestion7.controller.dto.TimestampDTO;
import br.com.kaffaquestion7.kaffaquestion7.model.Timestamp;
import br.com.kaffaquestion7.kaffaquestion7.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TimestampController {
    @Autowired
    private TimestampService timestampService;

    @GetMapping

    public TimestampDTO getCurrentTimestamp() {
        return TimestampDTO.convertOne(timestampService.getCurrentTimestamp());
    }

}
