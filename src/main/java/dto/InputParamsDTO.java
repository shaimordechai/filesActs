package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.ActionEnum;

public class InputParamsDTO {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");


    private String inputFile;
    private String outputFile;
    private ActionEnum act;
    private String creationDate;

    public InputParamsDTO(String inputFile, String outputFile, ActionEnum act) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.act = act;
        this.creationDate = DATE_FORMAT.format(new Date());
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public ActionEnum getAct() {
        return act;
    }

    public void setAct(ActionEnum act) {
        this.act = act;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
