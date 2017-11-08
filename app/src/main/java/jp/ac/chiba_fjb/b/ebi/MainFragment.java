package jp.ac.chiba_fjb.b.ebi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import jp.ac.chiba_fjb.b.ebi.data.Insertriyou;


/**
 * A simple {@link Fragment} subclass.
 */

public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener,Insertriyou.OnRecvListener {

    TextView t;
    double lv10 = 0.0;
    double lv20 = 0.0;
    double lv30 = 0.0;
    String lv1;
    String lv2;
    String lv3;
    String ja1;
    String ja2;
    String ja3;
    String di1;
    String di2;
    String di3;
    static Spinner s1;
    static Spinner s2;
    static Spinner s3;
    static Spinner s4;
    static Spinner s5;
    static Spinner s6;
    static Spinner s7;
    static Spinner s8;
    static Spinner s9;
    static ArrayAdapter<String> jan;
    static ArrayAdapter<String> nan;
    static ArrayAdapter<String> level;
    static String j[] = {"選択して下さい","POP&ANIME","niconico","東方Project","VARIETY","イロドリミドリ","言ノ葉Project","ORIGINAL"};
    static String n[] = {"選択して下さい","Basic","Advanced","Expert","Master"};
    static String[] lv = {"選択して下さい"};
    Calendar cal= Calendar.getInstance();


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time time = new Time("Asia/Tokyo");
                time.setToNow();
                String strDay = time.year + "年" + (time.month+1) + "月" + time.monthDay +"日"+time.hour + "時" + time.minute + "分" ;
                t = (TextView) view.findViewById(R.id.textView21);
                t.setText(strDay);
               Insertriyou st = new Insertriyou(getContext(),MainFragment.this);
            }
        });

        s1 = (Spinner) view.findViewById(R.id.spinner);
        s2 = (Spinner) view.findViewById(R.id.spinner2);
        s3 = (Spinner) view.findViewById(R.id.spinner3);
        s4 = (Spinner) view.findViewById(R.id.spinner4);
        s5 = (Spinner) view.findViewById(R.id.spinner5);
        s6 = (Spinner) view.findViewById(R.id.spinner6);
        s7 = (Spinner) view.findViewById(R.id.spinner7);
        s8 = (Spinner) view.findViewById(R.id.spinner8);
        s9 = (Spinner) view.findViewById(R.id.spinner9);

        jan = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,j);
        jan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        nan = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,n);
        nan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        level = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,lv);
        level.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(jan);
        s1.setOnItemSelectedListener(this);

        s2.setAdapter(nan);
        s2.setOnItemSelectedListener(this);

        setLevel(s3);
        s3.setOnItemSelectedListener(this);

        s4.setAdapter(jan);
        s4.setOnItemSelectedListener(this);

        s5.setAdapter(nan);
        s5.setOnItemSelectedListener(this);

        setLevel(s6);
        s6.setOnItemSelectedListener(this);

        s7.setAdapter(jan);
        s7.setOnItemSelectedListener(this);

        s8.setAdapter(nan);
        s8.setOnItemSelectedListener(this);

        setLevel(s9);
        s9.setOnItemSelectedListener(this);

        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle b=new Bundle();
                b.putString("DI1",di1);
                b.putString("DI2",di2);
                b.putString("DI3",di3);
                b.putString("JA1",ja1);
                b.putString("JA2",ja2);
                b.putString("JA3",ja3);
                b.putDouble("LV1",lv10);
                b.putDouble("LV2",lv20);
                b.putDouble("LV3",lv30);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f=new BlankFragment();
                f.setArguments(b);
                ft.replace(R.id.fragment,f);
                ft.commit();
            }
        });
    }
    public void setLevel(Spinner s){
        level = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,lv);
        level.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(level);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Spinner を取得
        Spinner spinner = (Spinner) parent;
        if(spinner.equals(s2)||spinner.equals(s5)||spinner.equals(s8)) {
            // 選択されたアイテムのテキストを取得
            String str = spinner.getSelectedItem().toString();
            if (str.equals("Basic")) {
                lv = new String[]{"選択して下さい", "1", "2", "3", "4", "5", "6"};
            } else if (str.equals("Advanced")) {
                lv = new String[]{"選択して下さい", "4", "5", "6", "7", "7+", "8", "8+", "9", "9+"};
            } else if (str.equals("Expert")) {
                lv = new String[]{"選択して下さい", "7", "7+", "8", "8+", "9", "9+", "10", "10+", "11", "11+", "12", "12+", "13"};
            } else if (str.equals("Master")) {
                lv = new String[]{"選択して下さい", "9", "9+", "10", "10+", "11", "11+", "12", "12+", "13", "13+", "14"};
            } else {
                lv = new String[]{"選択して下さい"};
            }
            if (spinner.equals(s2)) {
                setLevel(s3);
            } else if (spinner.equals(s5)) {
                setLevel(s6);
            } else if (spinner.equals(s8)) {
                setLevel(s9);
            }
        }else if(spinner.equals(s3)||spinner.equals(s6)||spinner.equals(s9)) {
            lv10 = 0.0;
            lv20 = 0.0;
            lv30 = 0.0;
            lv1 = (String) s3.getSelectedItem();//1曲目のレベル
            lv2 = (String) s6.getSelectedItem();//2~
            lv3 = (String) s9.getSelectedItem();//3~
            if (lv1.charAt(lv1.length() - 1) == '+') {
                lv10 = 0.5;
            }
            if (lv2.charAt(lv2.length() - 1) == '+') {
                lv20 = 0.5;
            }
            if (lv3.charAt(lv3.length() - 1) == '+') {
                lv30 = 0.5;
            }
            try {
                lv1 = lv1.replace("+", "");
                lv10 += Double.parseDouble(lv1);
                lv2 = lv2.replace("+", "");
                lv20 += Double.parseDouble(lv2);
                lv3 = lv3.replace("+", "");
                lv30 += Double.parseDouble(lv3);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ja1 = s1.getSelectedItem().toString();//1曲目のジャンル取得
        ja2 = s4.getSelectedItem().toString();//2曲目のジャンル取得
        ja3 = s7.getSelectedItem().toString();//3曲目のジャンル取得
        di1 = s2.getSelectedItem().toString();//1曲目のジャンル取得
        di2 = s5.getSelectedItem().toString();//2曲目のジャンル取得
        di3 = s8.getSelectedItem().toString();//3曲目のジャンル取得

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void OnRecv(boolean flg) {

    }
}
