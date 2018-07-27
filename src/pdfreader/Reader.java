package pdfreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import edu.princeton.cs.algs4.TST;
import trie.Insert;

public class Reader {
	public static ArrayList<String> execute(String pdf){
		File pdfFile = new File(pdf);
		ArrayList<String> palavras = new ArrayList<>();
		try {
			PDDocument doc = PDDocument.load(pdfFile);
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(doc);
			text = text.replaceAll("Públ ico", "Público").replace("R E S O L V E", "RESOLVE");
			String pattern = "\\d\\.\\d";
			// Create a Pattern object
		    Pattern r = Pattern.compile(pattern);

		    // Now create matcher object.
		    Matcher m = r.matcher(text);
		    while(m.find()){
		    	text = text.replaceAll(m.group(), m.group().replaceAll("\\.|", ""));
		    	
		    }
			String[] words = text.replaceAll(";|\\.|,", " ").split(" ");
			
			for (String string : words) {
				if(string.matches("(.*)\\S+(.*)|(.*)\\d(.*)"))
					palavras.add(string);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return palavras;
	}
	public static void main(String[] args) {
		ArrayList<String> al = Reader.execute("data/informativo_1_2018.pdf");	
		Insert ins = new Insert(new TST<>());
		ins.insert(al, "1");
		for (String string :ins.getTst().keys()) {
			System.out.println(string);
			System.out.println(ins.getTst().get(string));
		}
	}
}
