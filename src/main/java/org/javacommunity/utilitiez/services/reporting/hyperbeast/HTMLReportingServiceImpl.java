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

public class HTMLReportingServiceImpl implements ReportingService {
    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "BiggestFile.html");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("<h1>" + "BiggestFiles" + "</h1>");

        for (Path i : biggestFiles) {
            writer.write("<h3>" + String.valueOf(i) + "</h3>");
        }

        writer.close();
    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "Duplicates.html");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("<h1>" + "Duplicates" + "</h1>");

        for (Path i : duplicates) {
            writer.write("<h3>" + String.valueOf(i) + "</h3>");
        }

        writer.close();
    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) throws IOException {
        Path path = Paths.get("/home", "sergey", "Desktop", "UnknownFiles.html");

        File file = new File(String.valueOf(path));

        if (file.createNewFile()) {
            System.out.println("File's created");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("<h1>" + "UnknownFiles" + "</h1>");

        for (Map.Entry<Path, String> i : unknownFiles.entrySet()) {
            writer.write("<h3>" + String.valueOf(i) + "</h3>");
        }

        writer.close();
    }
}
