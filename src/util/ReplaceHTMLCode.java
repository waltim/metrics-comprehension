package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import metrics.BuseWeimer;

public class ReplaceHTMLCode {

    
    public void execute() {
        BuseWeimer ac = new BuseWeimer();
        for (File file : ac.listMainFolder()) {
            try {
                stringToFile(replaceHTMLCode(ac.readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME)), new File(file.getAbsoluteFile() + "//" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME.getPropriedade()));
                stringToFile(replaceHTMLCode(ac.readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME)), new File(file.getAbsoluteFile() + "//" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME.getPropriedade()));

                stringToFile(includeDefaultMethod(ac.readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME)), new File(file.getAbsoluteFile() + "//" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME.getPropriedade()));
                stringToFile(includeDefaultMethod(ac.readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME)), new File(file.getAbsoluteFile() + "//" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME.getPropriedade()));

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println(replaceHTMLCode(ac.readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME)));
        }
    }

    public String replaceHTMLCode(String in) {
        return in.replace("&gt;", ">").replace("&lt;", "<").replace("&amp;", "&");
    }

    public String includeDefaultMethod(String textFile) {
        if (!hasMethod(textFile)) {
            textFile = "public void test(){" + System.lineSeparator() + textFile + System.lineSeparator() + "}";
        }
        return textFile;
    }

    public boolean hasMethod(String textString) {
        return (textString.contains("public") || textString.contains("private") || textString.contains("protected"));
    }

    public File stringToFile(String text, File oldFile) throws IOException {
        FileWriter fw = new FileWriter(oldFile);
        fw.write(text);
        fw.close();
        return oldFile;
    }
}
