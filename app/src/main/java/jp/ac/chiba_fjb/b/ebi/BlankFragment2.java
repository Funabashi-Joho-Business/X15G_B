package jp.ac.chiba_fjb.b.ebi;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends DialogFragment {


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_dialog, container, false);
        Bundle a=getArguments();
        String ja3 = a.getString("JA3");//1曲目の難易度.
        String di3 = a.getString("DI3");
        String lv3 = a.getString("LV3");
        String r3 = a.getString("R3");
        TextView text1 = (TextView)view.findViewById(R.id.text1);
        TextView text2 = (TextView)view.findViewById(R.id.text2);
        TextView text3 = (TextView)view.findViewById(R.id.text3);
        TextView text4 = (TextView)view.findViewById(R.id.text4);
        text1.setText(ja3);
        text2.setText(di3);
        text3.setText(lv3);
        text4.setText(r3);
        return view;
    }

}
