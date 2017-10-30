package jp.ac.chiba_fjb.b.ebi.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by oikawa on 2017/10/02.
 * Webデータ読み取り用
 */

public class HttpReader {
	final static String AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; ja; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6";
	final static int TIMEOUT = 10000;
	public static String getContent(String adr){
		try {
			URL url = new URL(adr);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("User-Agent", AGENT);
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			con.setConnectTimeout(TIMEOUT);
			con.setReadTimeout(TIMEOUT);

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String str;
			while ( null != ( str = br.readLine() ) ) {
				sb.append(str+"\n");
			}
			br.close();
			con.disconnect();

			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
