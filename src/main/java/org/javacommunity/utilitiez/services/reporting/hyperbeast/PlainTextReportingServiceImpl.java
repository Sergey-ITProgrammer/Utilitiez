package org.javacommunity.utilitiez.services.reporting.hyperbeast;

import org.javacommunity.utilitiez.services.reporting.ReportingService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlainTextReportingServiceImpl implements ReportingService {
    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "BiggestFile.txt");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("BiggestFiles\n");

        for (Path i : biggestFiles) {
            writer.write(String.valueOf(i) + "\n");
        }

        writer.close();
    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "Duplicates.txt");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("Duplicates\n");

        for (Path i : duplicates) {
            writer.write(String.valueOf(i) + "\n");
        }

        writer.close();
    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "UnknownFiles.txt");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("UnknownFiles\n");

        for (Map.Entry<Path, String> i : unknownFiles.entrySet()) {
            writer.write(String.valueOf(i) + "\n");
        }

        writer.close();
    }
}
