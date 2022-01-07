package com.obtaincare.UI.dataProviders;


public class FileReaderManager {


    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigReader configFileReader;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigReader() : configFileReader;
    }
}
