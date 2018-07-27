package trie;

import java.util.HashSet;

public class Value {
	private HashSet<String> pdfs;
	
	public Value(HashSet<String> pdfs) {
		this.pdfs = pdfs;
	}

	public HashSet<String> getPdfs() {
		return pdfs;
	}

	public void setPdfs(HashSet<String> pdfs) {
		this.pdfs = pdfs;
	}

	@Override
	public String toString() {
		String res = "";
		for (String string : pdfs) {
			res += string + " ";
		}
		return res;
	}
	
}
