package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import input.Input;
import input.Snapshot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class Logger implements CommandLineRunner{

    Snapshot snapshot;

    @Async
    public void getSnapshot(Input input) throws InterruptedException, JsonProcessingException {
        while (true) {
            Snapshot newSnapshot = input.getLatestDataPoints();
            System.out.println(new ObjectMapper().writeValueAsString(snapshot));
            Thread.sleep(200L);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        this.getSnapshot(Application.inputSimulator);
    }
}
