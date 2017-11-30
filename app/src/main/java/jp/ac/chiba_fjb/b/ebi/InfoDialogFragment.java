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
public class InfoDialogFragment extends DialogFragment {


    public InfoDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_dialog, container, false);
        Bundle a=getArguments();
        String ja1 = a.getString("JA");//1曲目の難易度.
        String di1 = a.getString("DI");
        String lv1 = a.getString("LV");
        String r1 = a.getString("R");
        TextView text1 = (TextView)view.findViewById(R.id.text1);
        TextView text2 = (TextView)view.findViewById(R.id.text2);
        TextView text3 = (TextView)view.findViewById(R.id.text3);
        TextView text4 = (TextView)view.findViewById(R.id.text4);
        text1.setText(ja1);
        text2.setText(di1);
        text3.setText(lv1);
        text4.setText(r1);
        return view;
    }

}
