package jp.ac.chiba_fjb.b.ebi.data;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by x15g002 on 2017/10/31.
 */

    class urlData {


}
public class ChuniReader2 {
    public static boolean recvTest() {
        int i = 0;
        int b = 0;
        ArrayList<String> janru = new <String>ArrayList();
        janru.add("http://www.sdvx.in/chunithm/sort/pops.js");
        janru.add("http://www.sdvx.in/chunithm/sort/niconico.js");
        janru.add("http://www.sdvx.in/chunithm/sort/toho.js");
        janru.add("http://www.sdvx.in/chunithm/sort/variety.js");
        janru.add("http://www.sdvx.in/chunithm/sort/irodorimidori.js");
        janru.add("http://www.sdvx.in/chunithm/sort/kotonoha.js");
        janru.add("http://www.sdvx.in/chunithm/sort/original.js");
        janru.add("http://www.sdvx.in/chunithm/chfiles/end.js");
        janru.add("http://www.sdvx.in/chunithm/chfiles/course.js");
        for (i = 0; i < janru.size(); i++) {
            String content = HttpReader.getContent(janru.get(i));

            if (content == null)
                return false;

            //検索パターンを設定
            Pattern p = Pattern.compile(
                    //"document.write(\"<script type=text/javascript src=/chunithm/03/js/(.*?)></script>\");"
                    "src=(.*?)>"
            );

            // "<script type=text/javascript src=(.*?)>.*?",Pattern.DOTALL);
            Matcher m = p.matcher(content);
            if (i == 0) {
                ArrayList<String> POPSANIME = new <String>ArrayList();
                while (m.find()) {
                    POPSANIME.add(m.group(1));
                    System.out.format("サイト:%s\n", POPSANIME.get(b));
                    // m.group(1));
                    b++;
                }
            } else if (i == 1) {
                ArrayList<String> niconico = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    niconico.add(m.group(1));
                    System.out.format("サイト:%s\n", niconico.get(b));
                    // m.group(1));
                    b++;
                }
            } else if (i == 2) {
                ArrayList<String> touhou = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    touhou.add(m.group(1));
                    System.out.format("サイト:%s\n", touhou.get(b));
                    // m.group(1));
                    b++;
                }
            } else if (i == 3) {
                ArrayList<String> variety = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    variety.add(m.group(1));
                    System.out.format("サイト:%s\n", variety.get(b));
                    // m.group(1));
                    b++;
                }
            }else if (i == 4) {
                ArrayList<String> irodorimidori= new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    irodorimidori.add(m.group(1));
                    System.out.format("サイト:%s\n", irodorimidori.get(b));
                    // m.group(1));
                    b++;
                }
            }else if (i == 5) {
                ArrayList<String> kotonoha = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    kotonoha.add(m.group(1));
                    System.out.format("サイト:%s\n", kotonoha.get(b));
                    // m.group(1));
                    b++;
                }
            }else if (i == 6) {
                ArrayList<String> original = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    original.add(m.group(1));
                    System.out.format("サイト:%s\n", original.get(b));
                    // m.group(1));
                    b++;
                }
            }else if (i == 7) {
                ArrayList<String> WE = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    WE.add(m.group(1));
                    System.out.format("サイト:%s\n", WE.get(b));
                    // m.group(1));
                    b++;
                }
            }else if (i == 8) {
                ArrayList<String> course = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    course.add(m.group(1));
                    System.out.format("サイト:%s\n", course.get(b));
                    // m.group(1));
                    b++;
                }
            }
        }
        return true;
    }
}
