package jp.ac.chiba_fjb.b.ebi;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.ac.chiba_fjb.b.ebi.data.Data2;
import jp.ac.chiba_fjb.b.ebi.data.SQLite;
import jp.ac.chiba_fjb.b.ebi.data.TestDB;

class ImageGetTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView image;

    public ImageGetTask(ImageView _image) {
        image = _image;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap image;
        try {
            URL imageUrl = new URL(params[0]);
            InputStream imageIs;
            imageIs = imageUrl.openStream();
            image = BitmapFactory.decodeStream(imageIs);
            return image;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    protected void onPostExecute(Bitmap result) {
        // 取得した画像をImageViewに設定します。
        image.setImageBitmap(result);
    }
}
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
        String ja1 = b.getString("JA1");//1曲目の難易度
        String ja2 = b.getString("JA2");//2曲目の
        String ja3 = b.getString("JA3");//3曲目の
        String di1 = b.getString("DI1");//1曲目のジャンル
        String di2 = b.getString("DI2");//2曲目の
        String di3 = b.getString("DI3");//3曲目の
        String lv1 = b.getString("LV1");//1曲目のレベル
        String lv2 = b.getString("LV2");//2曲目のレベル
        String lv3 = b.getString("LV3");//3曲目のレベル
        String di10 = "";
        String di20 = "";
        String di30 = "";
        if(di1=="POP&ANIME"){
            di10 = "pops_anime";
        }else if(di1=="東方Project"){
            di10 ="toho";
        }else if(di1=="VARIETY"){
            di10 ="variety";
        }else if(di1=="イロドリミドリ"){
            di10 ="irodorimidori";
        }else if(di1=="言ノ葉Project"){
            di10 ="kotonoha";
        }else if(di1=="ORIGINAL"){
            di10 ="original";
        }else{
            di10="niconico";
        }
        if(di2=="POP&ANIME"){
            di20 = "pops_anime";
        }else if(di2=="東方Project"){
            di20 ="toho";
        }else if(di2=="VARIETY"){
            di20 ="variety";
        }else if(di2=="イロドリミドリ"){
            di20 ="irodorimidori";
        }else if(di2=="言ノ葉Project"){
            di20 ="kotonoha";
        }else if(di2=="ORIGINAL"){
            di20 ="original";
        }else{
            di20="niconico";
        }
        if(di3=="POP&ANIME"){
            di30 = "pops_anime";
        }else if(di3=="東方Project"){
            di30 ="toho";
        }else if(di3=="VARIETY"){
            di30 ="variety";
        }else if(di3=="イロドリミドリ"){
            di30 ="irodorimidori";
        }else if(di3=="言ノ葉Project"){
            di30 ="kotonoha";
        }else if(di3=="ORIGINAL"){
            di30 ="original";
        }else{
            di30="niconico";
        }
        TestDB db = new TestDB(getContext());
        ArrayList<Data2> unchi = db.getData(ja1,di10,lv1);
        ArrayList<Data2> unchi2 = db.getData(ja2,di20,lv2);
        ArrayList<Data2> unchi3 = db.getData(ja3,di30,lv3);
        db.close();
        TextView title = (TextView)view.findViewById(R.id.textView9);
        TextView title2 = (TextView)view.findViewById(R.id.textView10);
        TextView title3 = (TextView)view.findViewById(R.id.textView11);
        ImageView img1 = (ImageView)getView().findViewById(R.id.imageView);
        ImageView img2 = (ImageView)getView().findViewById(R.id.imageView3);
        ImageView img3 = (ImageView)getView().findViewById(R.id.imageView4);
        ImageGetTask task = new ImageGetTask(img1);
        ImageGetTask task2 = new ImageGetTask(img2);
        ImageGetTask task3 = new ImageGetTask(img3);
        Random rnd = new Random();
        if(unchi.size()==0) {
            title.setText("表示できません");
        }else{
            int ran = rnd.nextInt(unchi.size()-1);
            title.setText(unchi.get(ran).title);
            task.execute("https://chunithm.sega.jp/img/player/music/image/"+di10+"/"+unchi.get(ran).image);
        }
        if(unchi2.size()==0) {
            title2.setText("表示できません");
        }else{
            int ran = rnd.nextInt(unchi2.size()-1);
            title2.setText(unchi2.get(ran).title);
            task2.execute("https://chunithm.sega.jp/img/player/music/image/"+di20+"/"+unchi.get(ran).image);
        }
        if(unchi3.size()==0) {
            title3.setText("表示できません");
        }else{
            int ran = rnd.nextInt(unchi3.size()-1);
            title3.setText(unchi3.get(ran).title);
            task3.execute("https://chunithm.sega.jp/img/player/music/image/"+di30+"/"+unchi.get(ran).image);
        }
    }
}
