package com.example.task21.service;

import com.example.task21.entity.DogEntity;
import com.example.task21.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@ManagedResource(objectName = "Task22:name=UpdateFilesWithDBData")
public class ScheduleService {
    final static String PATH = "src/task22Data";

    @Autowired
    private DogService dogService;
    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 */30 * * * *")
    @ManagedOperation
    public void updateFiles() throws IOException, InterruptedException {
        File dir = new File(PATH);
        System.out.println("CRON START");
        if(dir.exists()) {
            deleteDir(dir);
        }
        System.out.println("CRON REMOVE DIR");

        Thread.sleep(10000);
        System.out.println("CRON FINISH TIMEOUT");

        if(!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("CRON MAKE DIR");

        new File(dir.getAbsolutePath() + "/dog.txt").createNewFile();
        new File(dir.getAbsolutePath() + "/user.txt").createNewFile();
        FileWriter dogWriter = new FileWriter(dir.getAbsolutePath() + "/dog.txt");
        FileWriter userWriter = new FileWriter(dir.getAbsolutePath() + "/user.txt");
        String dogData = "";
        String userData = "";
        try {
            List<DogEntity> dogs = dogService.getAll().get();
            dogData = dogs.stream().map(i -> "dog( " + i.getName() + ", " + i.getBreed() + " );").collect(Collectors.joining("\n"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            List<UserEntity> users = userService.filterByFields("", "").get();
            userData = users.stream().map(i -> "user( " + i.getFirstName() + ", " + i.getLastName() + " );").collect(Collectors.joining("\n"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        dogWriter.write(dogData);
        userWriter.write(userData);
        dogWriter.close();
        userWriter.close();
        System.out.println("CRON CREATE FILES");
    }

    private static void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (!Files.isSymbolicLink(f.toPath())) {
                    deleteDir(f);
                }
            }
        }
        file.delete();
    }

}
