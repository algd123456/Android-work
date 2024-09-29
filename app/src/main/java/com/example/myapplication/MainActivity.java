package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.resources.TextAppearanceConfig;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String []names={"手撕面包","华夫饼","小麻花","每日坚果","盐焗鸡蛋","原味肉松饼"};
    private String []prices={"￥32.90","￥36.90","￥18.80","￥19.90","￥30.70","￥34.90"};
    private String []shops={"良品铺子旗舰店","百草味旗舰店","比比赞旗舰店","憨豆熊旗舰店","无穷旗舰店","良品铺子旗舰店"};
    private int[] pictures={
            R.drawable.tear_bread,R.drawable.waffle,R.drawable.dough_twist,R.drawable.daily_nuts,
            R.drawable.salt_baked_eggs,R.drawable.meat_floss};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.lv_list);
        MyBaseAdapter mAdapter=new MyBaseAdapter(this);
        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter {
        private Context mContext;
        public MyBaseAdapter(Context context){
            this.mContext=context;
        }
        public  int getCount(){
            return  names.length;
        }
        public  Object getItem(int position){
            return names[position];
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            TextView tv_goods_name=convertView.findViewById(R.id.tv_goods_name);
            TextView tv_price=convertView.findViewById(R.id.tv_price);
            TextView tv_shop=convertView.findViewById(R.id.tv_shop);
            ImageView iv_img=convertView.findViewById(R.id.iv_img);
            tv_goods_name.setText(names[position]);
            tv_price.setText(prices[position]);
            tv_shop.setText(shops[position]);
            iv_img.setBackgroundResource(pictures[position]);
            return convertView;
        }
    }
}