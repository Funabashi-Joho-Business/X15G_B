package jp.ac.chiba_fjb.b.ebi.data;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by x15g008 on 2017/10/25.
 */

public class Insertriyou extends AsyncTask<Void, Void, Boolean>{
    public  interface OnRecvListener{
        public  void OnRecv(boolean flg);
    }
    Context mContext;
    OnRecvListener mListener;
    public Insertriyou(final Context con, final OnRecvListener listener){
        mContext = con;
        mListener = listener;
        execute();
    }
    @Override
    protected Boolean doInBackground(Void... voids) {
        syutoku dl = new syutoku();
        if(dl!=null) {
            TestDB db = new TestDB(mContext);

            try {
                Data[] list = dl.test2();
                if(list != null && list.length != 0) {
                    db.tabledateDaelete();
                    db.insertData(list);
                }
                db.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean flag) {
        super.onPostExecute(flag);
        mListener.OnRecv(flag);
    }
}
