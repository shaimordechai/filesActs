package validate;

import com.google.common.io.Files;
import enums.ActionEnum;

import java.io.File;

public class Validator {
    private static final String TXT = "txt";

    public boolean validateAction(String act){
        try {
            ActionEnum.valueOf(act);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public boolean fileExists(String inFileName) {
        File file = new File(inFileName);
        return file.exists();
    }

    public boolean isTxtFile(String inFileName) {
        String extension = Files.getFileExtension(inFileName);
        return extension.equals(TXT);
    }

    public boolean validateInputArgs(String[] args) {
        return args.length == 3;
    }
}
