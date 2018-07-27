package trie;

import java.util.ArrayList;
import java.util.HashSet;

import edu.princeton.cs.algs4.TST;

public class Insert {
	private TST<Value> tst;
	public Insert(TST<Value> tst) {
		this.tst = tst;
	}
	
	public TST<Value> getTst() {
		return tst;
	}

	public void setTst(TST<Value> tst) {
		this.tst = tst;
	}
	public void insert(ArrayList<String> palavras, String pdf_id){
		HashSet<String> pdfs;
		Value v; 
		for (String string : palavras) {
			v = tst.get(string);
			if(v!= null){
				pdfs = v.getPdfs();
				pdfs.add(pdf_id);
				v.setPdfs(pdfs);
				
			}else{
				pdfs = new HashSet<>();
				pdfs.add(pdf_id);
				v = new Value(pdfs);
				
			}
			tst.put(string,v);
			
		}
	}
	
	
}
