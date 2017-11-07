package jp.ac.chiba_fjb.b.ebi;


import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle b=getArguments();
        String ja1 = b.getString("JA1");//1曲目のジャンル
        String ja2 = b.getString("JA2");//2曲目のジャンル
        String ja3 = b.getString("JA3");//3曲目のジャンル
        String di1 = b.getString("DI1");//1曲目の難易度
        String di2 = b.getString("DI2");//2曲目の難易度
        String di3 = b.getString("DI3");//3曲目の難易度
        Double lv1 = b.getDouble("LV1");//1曲目のレベル
        Double lv2 = b.getDouble("LV2");//2曲目のレベル
        Double lv3 = b.getDouble("LV3");//3曲目のレベル
        TextView text = (TextView)view.findViewById(R.id.textView7);
        StringBuilder lv10 = new StringBuilder();
        StringBuilder lv20 = new StringBuilder();
        StringBuilder lv30 = new StringBuilder();
        if(((int)(lv1*10))%10==5){
            lv1=lv1-0.5;
            int lv11 = (int) (lv1/100*100);
            String lv111 = String.valueOf(lv11);
            lv10.append(lv111);
            lv10.append("+");
        } else {
            lv10.append((int) (lv1 / 100 * 100));
        }
        if(((int)(lv2*10))%10==5){
            lv2=lv2-0.5;
            int lv22 = (int) (lv2/100*100);
            String lv222 = String.valueOf(lv22);
            lv20.append(lv222);
            lv20.append("+");
        } else {
            lv20.append((int) (lv2 / 100 * 100));
        }
        if(((int)(lv3*10))%10==5){
            lv3=lv3-0.5;
            int lv33 = (int) (lv3/100*100);
            String lv333 = String.valueOf(lv33);
            lv30.append(lv333);
            lv30.append("+");
        } else {
            lv30.append((int) (lv3/ 100 * 100));
        }
        text.setText(lv30);
    }
}