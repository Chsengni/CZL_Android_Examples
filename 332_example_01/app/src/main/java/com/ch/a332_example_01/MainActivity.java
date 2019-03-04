package com.ch.a332_example_01;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ListView listView;
    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int se = v.getId();
        switch (se){
            case R.id.button1:
                List<String> data1 = new ArrayList<>();
                data1.add("北京");
                data1.add("上海");
                data1.add("武汉");
                final ArrayAdapter<String> adapter1 =new ArrayAdapter<>(
                        MainActivity.this,
                        R.layout.item_layout1,
                        R.id.tv,
                        data1
                );
                listView.setAdapter(adapter1);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String str = "你选择了"+adapter1.getItem(position);
                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.button2:
                List<Map<String,Object>> data2 = new ArrayList<>();
                Map<String,Object> listItem1 =new HashMap<>();
                listItem1.put("id",1);
                listItem1.put("name","张三");
                listItem1.put("salary",5000);
                data2.add(listItem1);
                Map<String,Object> listItem2 =new HashMap<>();
                listItem2.put("id",2);
                listItem2.put("name","李四");
                listItem2.put("salary",5800);
                data2.add(listItem2);
                Map<String,Object> listItem3 =new HashMap<>();
                listItem3.put("id",3);
                listItem3.put("name","王五");
                listItem3.put("salary",5500);
                data2.add(listItem3);
                final SimpleAdapter adapter2 = new SimpleAdapter(
                    MainActivity.this,
                    data2,
                    R.layout.item_layout2,
                    new String[]{"id","name","salary"},
                    new int[]{R.id.tv1,R.id.tv2,R.id.tv3}
                );
                listView.setAdapter(adapter2);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Map<String,Object> rec = (Map<String, Object>) adapter2.getItem(position);
                        String result ="【"+position+"】"+rec.get("id")+","+rec.get("name")+","+rec.get("salary");
                        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.button3:
                String[] names = new String[]{"虎头","弄玉","李清照","李白"};
                String[] descs = new String[]{"可爱的小孩","一个擅长音乐的女孩","一个擅长文学的女性","浪漫主义诗人"};
                int[]  imagesIds = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
                final List<Map<String,Object>> data3 = new ArrayList<>();
                for (int i=0;i<names.length;i++){
                    Map<String,Object> listItem = new HashMap<>();
                    listItem.put("header",imagesIds[i]);
                    listItem.put("personName",names[i]);
                    listItem.put("desc",descs[i]);
                    data3.add(listItem);
                }
                final BaseAdapter adapter3 = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return data3.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return data3.get(position);
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View item = View.inflate(getApplicationContext(),R.layout.item_layout3,null);
                        ImageView header = item.findViewById(R.id.header);
                        TextView name =item.findViewById(R.id.name);
                        TextView desc =item.findViewById(R.id.desc);
                        Map<String,Object> p =data3.get(position);
                        header.setImageResource((int) p.get("header"));
                        name.setText(p.get("personName")+"");
                        desc.setText(p.get("desc")+"");
                        return item;
                    }
                };
                listView.setAdapter(adapter3);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Map<String,Object> p = (Map<String, Object>) adapter3.getItem(position);
                        String result = "你选择了:"+p.get("personName");
                        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
    }
}
