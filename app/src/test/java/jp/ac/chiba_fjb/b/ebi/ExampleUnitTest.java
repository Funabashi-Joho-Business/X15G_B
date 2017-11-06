package jp.ac.chiba_fjb.b.ebi;

import org.junit.Test;

import jp.ac.chiba_fjb.b.ebi.data.ChuniReader;
import jp.ac.chiba_fjb.b.ebi.data.ChuniReader2;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Test() throws Exception {
        if(!ChuniReader2.recvTest())
            System.out.println("接続エラー");
    }
}