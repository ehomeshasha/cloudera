package stubs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("\\.([-a-zA-z]+?)\\s+HTTP");
		String s = "96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] \"GET /cat.jpg HTTP/1.1\" 200 12433";
		Matcher m = p.matcher(s);
		boolean rs = m.find();
		if(rs) {
			System.out.println(m.group(1));
		}
	}

}
