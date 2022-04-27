package metrics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import util.IOEnum;

public class Posnett {
	public void avaliate() {
		for (File file : listMainFolder()) {

			File fileA = new File(
					file.getAbsolutePath() + "\\" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_A_FILE_NAME.getPropriedade());
			File fileB = new File(
					file.getAbsolutePath() + "\\" + IOEnum.PATH_MAIN_FOLDER.DEFAULT_B_FILE_NAME.getPropriedade());

			System.out.println(file.getAbsoluteFile().toString().replace(IOEnum.PATH_MAIN_FOLDER.getPropriedade(), "")
					+ " - " + formatResult(avaliateCode(fileA)) + " | " + formatResult(avaliateCode(fileB)));

//            System.out.println(fileA.getAbsolutePath() + " | " +);
//            System.out.println(fileB.getAbsolutePath() + " | " + );
//            avaliateCode(fileA);
//            avaliateCode(fileB);
		}
	}

	public String formatResult(double result) {
		DecimalFormat df = new DecimalFormat("#.###");
		return df.format(result);
	}

	public List<File> listMainFolder() {
		File folder = new File(IOEnum.PATH_MAIN_FOLDER.getPropriedade());
		return Arrays.asList(folder.listFiles());
	}

	public String readFile(File folder, IOEnum file) {
		String content = "";
		try {
			content = new String(
					Files.readAllBytes(Paths.get(folder.getAbsolutePath() + "\\" + file.getPropriedade())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public double avaliateCode(File fileToRead) {
		String[] arg = { "--file", fileToRead.getAbsolutePath() };
		return execute(arg);
	}

	public double execute(String[] args) {
		if (args.length == 1) {
			System.out.println(PosnettMetric.entropy(Parser.parseMethodDeclaration(args[0])));
		} else if (args.length == 2 && args[0].equals("--file")) {
			try {
				String contents = new String(Files.readAllBytes(Paths.get(args[1])));
				// System.out.println(contents);
				return PosnettMetric.simpleReadability(Parser.parseMethodDeclaration(contents));
			} catch (Exception e) {
				System.out.println(Paths.get(args[1]));

				// comentar essa linha para mostrar apenas os erros
				System.err.print(e.getMessage());
			}
		}
		return 0;
	}
}
