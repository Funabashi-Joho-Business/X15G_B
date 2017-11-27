package jp.ac.chiba_fjb.b.ebi.data;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by x15g002 on 2017/10/31.
 */

class ArrayData{
    public String title2;
    public String URL2;
}

public class ChuniReader2 {
    public static  ArrayList<ArrayData> recvTest() {
        int i = 0;
        int b = 0;
        String URL_2 ;
        ArrayList<ArrayData> URL_DATA = new ArrayList<ArrayData>();
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
                return null;

            //検索パターンを設定
            Pattern p = Pattern.compile(
                    //"document.write(\"<script type=text/javascript src=/chunithm/03/js/(.*?)></script>\");"
                    "src=(.*?)>.*;//(.*?)\n"
            );

            // "<script type=text/javascript src=(.*?)>.*?",Pattern.DOTALL);
            Matcher m = p.matcher(content);
            if (i == 0) {
                //        ArrayList<String> POPSANIME = new <String>ArrayList();]
            //    http://www.sdvx.in/chunithm/03/03050mst.htm
                // /chunithm/03/js/03050sort.js
                while (m.find()) {
                    ArrayData at = new ArrayData();
                String data = m.group(1);
                 String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    at.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    at.title2 = m.group(2);
                    URL_DATA.add(at);
                    System.out.format("サイト:%s" + "_________" + "%s\n", at.URL2, at.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 1) {
                //    ArrayList<String> niconico = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData bt = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    bt.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    bt.title2 = m.group(2);
                    URL_DATA.add(bt);
                    System.out.format("サイト:%s" + "_________" + "%s\n", bt.URL2, bt.title2);;
                    // m.group(1));
                    b++;
                }
            } else if (i == 2) {
                //       ArrayList<String> touhou = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData ct = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    ct.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    ct.title2 = m.group(2);
                    URL_DATA.add(ct);
                    System.out.format("サイト:%s" + "_________" + "%s\n", ct.URL2, ct.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 3) {
                //     ArrayList<String> variety = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData dt = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    dt.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    dt.title2 = m.group(2);
                    URL_DATA.add(dt);
                    System.out.format("サイト:%s" + "_________" + "%s\n", dt.URL2, dt.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 4) {
                //    ArrayList<String> irodorimidori= new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData et = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    et.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    et.title2 = m.group(2);
                    URL_DATA.add(et);
                    System.out.format("サイト:%s" + "_________" + "%s\n", et.URL2, et.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 5) {
                //       ArrayList<String> kotonoha = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData ft = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    ft.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    ft.title2 = m.group(2);
                    URL_DATA.add(ft);
                    System.out.format("サイト:%s" + "_________" + "%s\n", ft.URL2, ft.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 6) {
                //    ArrayList<String> original = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData gt = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    gt.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    gt.title2 = m.group(2);
                    URL_DATA.add(gt);
                    System.out.format("サイト:%s" + "_________" + "%s\n", gt.URL2, gt.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 7) {
                //     ArrayList<String> WE = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData ht = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    ht.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    ht.title2 = m.group(2);
                    URL_DATA.add(ht);
                    System.out.format("サイト:%s" + "_________" + "%s\n", ht.URL2, ht.title2);
                    // m.group(1));
                    b++;
                }
            } else if (i == 8) {
                //   ArrayList<String> course = new <String>ArrayList();
                b = 0;
                while (m.find()) {
                    ArrayData it = new ArrayData();
                    String data = m.group(1);
                    String Adata  = data.substring(10,12); // /chunthm/03
                    String Bdata  = data.substring(15,21);
                    it.URL2 = "http://www.sdvx.in/chunithm/"+Adata+Bdata+"mst.htm";
                    it.title2 = m.group(2);
                    URL_DATA.add(it);
                    System.out.format("サイト:%s" + "_________" + "%s\n", it.URL2, it.title2);
                    // m.group(1));
                    b++;
                }
            }
        }
        return URL_DATA;
    }
}
