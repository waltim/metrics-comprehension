package metrics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import util.IOEnum;

public class BuseWeimer {
		
    public void execute() {
        for (File file : listMainFolder()) {
            double resultFileA = avaliateCode(readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME));
            double resultFileB = avaliateCode(readFile(file, IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME));
            System.out.println(file.getAbsoluteFile().toString().replace(IOEnum.PATH_MAIN_FOLDER.getPropriedade(), "") + " - "+ formatResult(resultFileA) + " | " + formatResult(resultFileB));
        }
    }

    public String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(result);
    }

    public double avaliateCode(String code) {
        return raykernel.apps.readability.eval.Main.getReadability(code);
    }
    
    public List<File> listMainFolder() {
        File folder = new File(IOEnum.PATH_MAIN_FOLDER.getPropriedade());
        return Arrays.asList(folder.listFiles());
    }

    public String readFile(File folder, IOEnum file) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(folder.getAbsolutePath() + "\\" + file.getPropriedade())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
