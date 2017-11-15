package jp.ac.chiba_fjb.b.ebi.data;

import android.content.Context;

/**
 * Created by x15g008 on 2017/10/25.
 */

public class Insertriyou {


    public  interface OnRecvListener{
        public  void OnRecv(boolean flg);
    }
    Data[] list;
    public Insertriyou(final Context con, final OnRecvListener listener){

        new Thread(){
            @Override
            public void run() {
                syutoku dl = new syutoku();
                if(dl!=null){
                    TestDB db = new TestDB(con);
                    db.tabledateDaelete();
                    try {
                        list = dl.test2();
                        db.insertData(list);
                        listener.OnRecv(true);
                        return;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    listener.OnRecv(false);
                }
            }
        }.start();

    }

}
