package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import input.Input;
import input.Snapshot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


@Service
public class Logger implements CommandLineRunner {

    final ObjectMapper mapper = new ObjectMapper();

    @Async
    public void getSnapshot(Input input) throws InterruptedException, JsonProcessingException, FileNotFoundException {

        Snapshot snapshot = new Snapshot();
        File logFolder = new File("src/main/resources/logfiles");
        PrintWriter writer = new PrintWriter(logFolder.getPath() + '/' + System.currentTimeMillis());
        int i = 0;

        while (true) {
            long startTime = System.currentTimeMillis();
            Snapshot newSnapshot = new Snapshot(input.getLatestDataPoints());
            writer.print(Snapshot.differenceToJson(newSnapshot, snapshot, mapper));
            writer.flush();
            snapshot = newSnapshot;
            if (++i > 100) {
                writer.close();
                writer = new PrintWriter("src/main/resources/logfiles/" + System.currentTimeMillis());
                File[] files = logFolder.listFiles();
                Arrays.sort(files);
                if (files.length > 2) {
                    files[0].delete();
                }
                i = 0;
            }
            long sleepTime = startTime + 200 - System.currentTimeMillis();
            Thread.sleep(sleepTime > 0 ? sleepTime : 0);
        }

    }

    @Override
    public void run(String... args) throws Exception {
        this.getSnapshot(Application.inputSimulator);
    }
}
