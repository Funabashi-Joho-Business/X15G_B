package jp.ac.chiba_fjb.b.ebi.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oikawa on 2017/10/02.
 */


public class ChuniReader {
    public static boolean recvTest(){
        int i=15;
        String adr = "https://chunithm.sega.jp/player/music/pops_anime.html";
        String content = HttpReader.getContent(adr);
        if(content == null)
            return false;

        //検索パターンを設定  .*?ワイルドカード
        Pattern p = Pattern.compile(
                "<h3 class=\"musiclist__item__right__name\">(.*?)</h3>.*?"+
                      "<dl class=\"musiclist__item__right__artist\">(.*?)</dl>.*?"+
                        "<img src=\"(.*?)\">.*?"+
                        "<div class=\"musiclist__item__level__box__num musiclist__item__level__box__num-1\">(.*?)</div>.*?"+
                        "<div class=\"musiclist__item__level__box__num musiclist__item__level__box__num-2\">(.*?)</div>.*?"+
                        "<div class=\"musiclist__item__level__box__num musiclist__item__level__box__num-3\">(.*?)</div>.*?"+
                        "<div class=\"musiclist__item__level__box__num musiclist__item__level__box__num-4\">(.*?)</div>",Pattern.DOTALL);
//                          "<div class=\"musiclist__item musiclist__item-pops_anime is-active is-secret\"id=\"music15\".*?>(.*?)</div>",Pattern.DOTALL);

        Matcher m = p.matcher(content);
            while(m.find()){
          System.out.format("1:%s\n 2:%s\n 3:%s\n 4:%s %s %s %s",m.group(1),m.group(2),m.group(3),m.group(4),m.group(5),m.group(6),m.group(7));
        }
        return true;

    }
}