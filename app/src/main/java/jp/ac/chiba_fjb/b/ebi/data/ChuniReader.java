package jp.ac.chiba_fjb.b.ebi.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oikawa on 2017/10/02.
 */

public class ChuniReader {
	public static boolean recvTest(){
		String adr = "https://weather.yahoo.co.jp/weather/jp/12/4510.html";
		String content = HttpReader.getContent(adr);
		if(content == null)
			return false;

		//検索パターンを設定
		Pattern p = Pattern.compile(
			"http://www.sdvx.in/chunithm.html"+
			"<img src=\".*?\" border=\"0\" alt=\"(.*?)\">.*?"+
			"<li class=\"high\"><em>(.*?)</em>.*?"+
			"<li class=\"low\"><em>(.*?)</em>",Pattern.DOTALL);
		Matcher m = p.matcher(content);
		while(m.find()){
			System.out.format("日付:%s 天気:%s 最高気温:%s 最低気温:%s\n",
				m.group(1),m.group(2),m.group(3),m.group(4));
		}
		return true;

	}
}
