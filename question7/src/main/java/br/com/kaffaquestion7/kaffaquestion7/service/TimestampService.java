package br.com.kaffaquestion7.kaffaquestion7.service;

import br.com.kaffaquestion7.kaffaquestion7.model.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class TimestampService {

    public Timestamp getCurrentTimestamp(){
        return new Timestamp();
    }

}
