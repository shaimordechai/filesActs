package main;

import db.DBHelper;
import dto.InputParamsDTO;
import enums.ActionEnum;
import files.FileTools;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validate.Validator;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int ERROR_STATUS = 1;


    public static void main(String[] args) {
        InputParamsDTO inputParamsDTO = validate(args);
        List<String> lines = readFile(inputParamsDTO.getInputFile());
        createAction(inputParamsDTO.getAct(), lines);
        writeToFile(inputParamsDTO.getOutputFile(), lines);
        writeToDB(inputParamsDTO);

        logger.info(getFinalMessage(inputParamsDTO));
    }

    private static String getFinalMessage(InputParamsDTO inputParamsDTO) {
        return new StringBuilder(inputParamsDTO.getInputFile())
                .append(" ")
                .append(inputParamsDTO.getAct().toString())
                .append(" to: ")
                .append(inputParamsDTO.getOutputFile())
                .toString();
    }

    private static void createAction(ActionEnum act, List<String> lines) {
        act.getInstance().doAction(lines);
    }

    private static void writeToDB(InputParamsDTO inputParamsDTO) {
        DBHelper dbHelper = new DBHelper();
       // dbHelper.writeData(inputParamsDTO);
    }

    private static void writeToFile(String outFile, List<String> lines) {
        FileTools fileTools = new FileTools();
        fileTools.writeFile(outFile, lines);
    }

    private static List<String> readFile(String input) {
        FileTools fileTools = new FileTools();
        fileTools.readFile(input);
        return fileTools.getLines();
    }

    private static InputParamsDTO validate(String[] args) {
        String outFileFromUser = args[1];
        String outFile = args[1];
        int counter = 0;
        Validator validator = new Validator();

        if(!validator.validateInputArgs(args)){
            logger.error("Invalid input. Should be <input file> <output file> <action>." +
                    " Example: input.txt output.txt SHUFFLE");
            System.exit(ERROR_STATUS);
        }

        if(!validator.fileExists(args[0])) {
            logger.error("Input file " + args[0] + " does not exists!");
            System.exit(ERROR_STATUS);
        }

        if(!validator.isTxtFile(args[0])) {
            logger.error("Input file " + args[0] + " is not a text file!");
            System.exit(ERROR_STATUS);
        }

        if(!validator.isTxtFile(outFile)) {
            logger.error("Output file " + args[0] + " is not a text file!");
            System.exit(ERROR_STATUS);
        }

        while (validator.fileExists(outFile)) {
            counter++;
            outFile = addCounterToFileName(outFileFromUser  , counter);
        }

        if(!validator.validateAction(args[2])) {
            logger.error("No enum Action: " + args[2]);
            System.exit(ERROR_STATUS);
        }

        return new InputParamsDTO(args[0], outFile, ActionEnum.valueOf(args[2])) ;
    }

    private static String addCounterToFileName(String outFile, int counter) {
        String substring = outFile.substring(0, outFile.lastIndexOf("."));
        StringBuilder sb = new StringBuilder(substring)
                .append("(")
                .append(counter)
                .append(")")
                .append(".")
                .append("txt");
        return sb.toString();
    }
}
