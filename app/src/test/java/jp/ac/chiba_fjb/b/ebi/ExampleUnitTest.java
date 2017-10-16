package jp.ac.chiba_fjb.b.ebi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.junit.Test;

import jp.ac.chiba_fjb.b.ebi.data.Json.Json;
@JsonIgnoreProperties(ignoreUnknown = true)
class Data{
    public int id;
    public int release;
    public String category;
    public String title;
    public String reading;
    public String artist;
    public String lev_bas;
    public String lev_adv;
    public String lev_exp;
    public String lev_mas;
    public String lev_WE;
}



/**
 * Created by x15g008 on 2017/10/16.
 */

public class ExampleUnitTest {
    //@Test
    String url ="https://chunithm.sega.jp/js/music/json/common.json";
    public void Test1() throws Exception {
        Data data = Json.send(url,null,Data.class);
        if(data == null)
            System.out.println("受信エラー");
        else {
            System.out.println(data.id);
            System.out.println(data.release);
            System.out.println(data.category);
            System.out.println(data.title);
            System.out.println(data.reading);
            System.out.println(data.artist);
            System.out.println(data.lev_bas);
            System.out.println(data.lev_adv);
            System.out.println(data.lev_exp);
            System.out.println(data.lev_mas);
        }
    }

    @Test
    public void test2() throws Exception {
        Data[] list = Json.send(url,null,Data[].class);
        if(list == null)
            System.out.println("受信エラー");
        else {
            //List<Data> list = dataList.list;
            for(Data data : list){
                System.out.println(data.id);
                System.out.println(data.release+"\n");
                System.out.println(data.category+"\n");
                System.out.println(data.title+"\n");
                System.out.println(data.artist+"\n");
                System.out.println(data.lev_bas+"\n");
                System.out.println(data.lev_adv+"\n");
                System.out.println(data.lev_exp+"\n");
                System.out.println(data.lev_mas+"\n");
            }
        }
    }
}
