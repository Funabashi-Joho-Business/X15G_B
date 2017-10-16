package jp.ac.chiba_fjb.b.ebi.data;

import org.junit.Test;

import java.util.List;

import jp.ac.chiba_fjb.b.ebi.data.Json.Json;

/**
 * Created by x15g008 on 2017/10/16.
 */

class Data{
    public int id;
    public int release;
    public String category;
    public String title;
    public String reading;
    public String artist;
    public int lev_bas;
    public int lev_adv;
    public int lev_exp;
    public int lev_mas;
    public int lev_WE;
}
class DataList{
    public List<Data> list;
}

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
            System.out.println(data.lev_WE);
        }
    }

    @Test
    public void test2() throws Exception {
        DataList dataList = Json.send(url,null,DataList.class);
        if(dataList == null)
            System.out.println("受信エラー");
        else {
            List<Data> list = dataList.list;
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
                System.out.println(data.lev_WE+"\n");
            }
        }
    }
}