package application;

import metrics.BuseWeimer;
import metrics.Posnett;
import utils.IOEnum;
import utils.ReplaceHTMLCode;

public class Program {

	public static void main(String[] args) {
		
		System.out.println(IOEnum.PATH_MAIN_FOLDER.getPropriedade());
		
//		 Utilizar o script ReplaceHTMLCode para formatar os arquivos a.txt e b.txt apenas quando os trechos forem extraídos via scrapy(Crawler) e vierem com codificações HTML.
//		
//        ReplaceHTMLCode code = new ReplaceHTMLCode();
//        code.execute();
		System.out.println("-----BUSE AND WEIMER METRICS-----");
        BuseWeimer bw = new BuseWeimer();
        bw.execute();
        System.out.println("-----POSNETT METRICS-----");
        Posnett pm = new Posnett();
        pm.avaliate();
		
		
	}
}
