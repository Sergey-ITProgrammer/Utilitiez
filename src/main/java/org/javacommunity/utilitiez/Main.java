package org.javacommunity.utilitiez;

import org.javacommunity.utilitiez.console.ConsoleInit;
import org.javacommunity.utilitiez.fx.FxInit;
import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;
import org.javacommunity.utilitiez.services.analyzer.hyperbeast.AnalyzerServiceImpl;
import org.javacommunity.utilitiez.services.reporting.ReportingService;
import org.javacommunity.utilitiez.services.reporting.hyperbeast.ConsoleReportingServiceImpl;
import org.javacommunity.utilitiez.services.reporting.hyperbeast.HTMLReportingServiceImpl;
import org.javacommunity.utilitiez.services.reporting.hyperbeast.PlainTextReportingServiceImpl;
import org.javacommunity.utilitiez.services.scavenger.ScavengerService;
import org.javacommunity.utilitiez.services.scavenger.hyperbeast.ScavengerServiceImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    /** 
     * Treat this method as it was your Main.
     * The code inside the startDebug method, is just a sample,
     * feel free to delete it and write your own.
     */
    
    private static void startDebug(String[] args) throws NoSuchAlgorithmException, IOException {

        // Testing my scavenger.
        ScavengerService myTestScavenger = new ScavengerServiceImpl();

        final List<Path> filesFound = myTestScavenger.findAll();
//        System.out.println("I'm gonna print all the files I found!");
//        filesFound.forEach(System.out::println);

        // Testing my analyzer
        AnalyzerService myTestAnalyzer = new AnalyzerServiceImpl();

        int amountOfFilesToRetrieve = 10;
        final List<Path> biggestFiles = myTestAnalyzer.getBiggestFiles(filesFound, amountOfFilesToRetrieve);

        final Set<Path> duplicates = myTestAnalyzer.getDuplicates(filesFound);

        final Map<Path, String> unknownFiles = myTestAnalyzer.getUnknownFiles(filesFound);

        if(filesFound.isEmpty()) System.out.println("FOLDER IS EMPTY!");
        // Testing my reporting service
        ReportingService myTestReporting = new PlainTextReportingServiceImpl();

        myTestReporting.generateReportForBiggestFile(biggestFiles);
        myTestReporting.generateReportForDuplicates(duplicates);
        myTestReporting.generateReportForUnknownFiles(unknownFiles);
    }

    /**************************************/
    /*** Ignore stuff over this comment ***/
    /**************************************/
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        logger.info(() -> messages.getString("main.start"));

        if (args.length == 0) {
            startDebug(args);
        } else if ("FX".equalsIgnoreCase(args[0])) {
            FxInit.main(args);
        } else if ("CONSOLE".equalsIgnoreCase(args[0])) {
            ConsoleInit.main(args);
        } else {
            throw new IllegalArgumentException(messages.getString("exception.unsupported.not-implemented"));
        }
    }

}
