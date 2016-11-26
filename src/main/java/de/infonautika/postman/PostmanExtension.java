package de.infonautika.postman;

import org.gradle.api.Project;
import org.gradle.api.file.FileTree;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PostmanExtension {
    public final static String NAME = "postman";

    private FileTree collections;
    private File environment;
    private boolean cliReport = true;
    private String xmlReportDir;
    private boolean stopOnError = false;

    public FileTree getCollections() {
        return collections;
    }

    public void setCollections(FileTree collections) {
        this.collections = collections;
    }

    public File getEnvironment() {
        return environment;
    }

    public void setEnvironment(File environment) {
        this.environment = environment;
    }

    public boolean getCliReport() {
        return cliReport;
    }

    public void setCliReport(boolean cliReporter) {
        this.cliReport = cliReporter;
    }

    public String getXmlReportDir() {
        return xmlReportDir;
    }

    public void setXmlReportDir(String xmlReport) {
        this.xmlReportDir = xmlReport;
    }

    public boolean getStopOnError() {
        return stopOnError;
    }

    void setStopOnError(boolean stopOnError) {
        this.stopOnError = stopOnError;
    }

    public PostmanExtension(final Project project) {
        Map<String, String> treeConfig = new HashMap<>();
        treeConfig.put("dir", "src/test");
        treeConfig.put("include", "**/*.postman_collection.json");
        this.collections = project.fileTree(treeConfig);
    }
}