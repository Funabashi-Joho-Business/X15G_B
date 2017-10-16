package jp.ac.chiba_fjb.b.ebi.data;

        import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

class Data{
    public String name;
    public int age;
}
class DataList{
    public List<Data> list;
}

public class ExampleUnitTest {
    //@Test
    public void Test1() throws Exception {
        Data data = Json.send(https://chunithm.sega.jp/js/music/json/common.json,null,Data.class);
        if(data == null)
            System.out.println("受信エラー");
        else {
            System.out.println(data.name);
            System.out.println(data.age);
        }
    }

    @Test
    public void test2() throws Exception {
        DataList dataList = Json.send(GASのアドレス,null,DataList.class);
        if(dataList == null)
            System.out.println("受信エラー");
        else {
            List<Data> list = dataList.list;
            for(Data data : list){
                System.out.println(data.name);
                System.out.println(data.age+"\n");
            }
        }
    }
}