package jp.ac.chiba_fjb.b.ebi;




import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jp.ac.chiba_fjb.b.ebi.data.TestDB;


public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment,new MainFragment());
        ft.commit();
        TestDB db = new TestDB(this);
        db.query("");
        db.close();

    }




}



