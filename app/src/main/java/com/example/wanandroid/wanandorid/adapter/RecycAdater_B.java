package com.example.wanandroid.wanandorid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;

import java.util.ArrayList;

public class RecycAdater_B extends RecyclerView.Adapter<RecycAdater_B.HHH> {
    private ArrayList<KnowledgeHierarchyData> list;
    private Context context;

    public RecycAdater_B(ArrayList<KnowledgeHierarchyData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<KnowledgeHierarchyData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HHH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recyc_b, null);
        HHH hhh = new HHH(inflate);
        return hhh;
    }

    @Override
    public void onBindViewHolder(@NonNull HHH hhh, int i) {
        hhh.name.setText(list.get(i).getName());
        String names="";
        for (int j = 0; j < list.get(i).getChildren().size(); j++) {
            String name = list.get(i).getChildren().get(j).getName();
            names+=name+"   ";
        }
        hhh.names.setText(names);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HHH extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView names;
        public HHH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            names=itemView.findViewById(R.id.names);
        }
    }
}
