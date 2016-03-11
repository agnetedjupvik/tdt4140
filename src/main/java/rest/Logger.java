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

    Snapshot snapshot = new Snapshot();

    @Async
    public Snapshot getSnapshot(Input input, Snapshot lastSnapshot) throws InterruptedException, JsonProcessingException {
        while (true) {
            Snapshot newSnapshot = new Snapshot(input.getLatestDataPoints());
            System.out.print(Snapshot.differenceToJson(newSnapshot, lastSnapshot));
            lastSnapshot = newSnapshot;
            Thread.sleep(200L);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        this.snapshot = this.getSnapshot(Application.inputSimulator, snapshot);
    }
}
