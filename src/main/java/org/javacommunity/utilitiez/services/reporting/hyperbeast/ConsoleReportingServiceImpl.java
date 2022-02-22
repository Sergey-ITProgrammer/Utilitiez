package org.javacommunity.utilitiez.services.reporting.hyperbeast;

import org.javacommunity.utilitiez.services.reporting.ReportingService;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConsoleReportingServiceImpl implements ReportingService {
    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) {
        int amountOfFilesToRetrieve = 10;
        System.out.println("I'm gonna print the " + amountOfFilesToRetrieve + " biggest files: ");

        biggestFiles.forEach(System.out::println);
    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) {
        System.out.println("I'm gonna print the duplicated files found: ");

        duplicates.forEach(System.out::println);
    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) {
        System.out.println("I'm gonna print a map of the unknown files, and their most probable type");

        unknownFiles.entrySet().forEach(System.out::println);
    }
}
