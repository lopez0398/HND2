package com.daniel.hnd2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.PersonajeBean;
import com.daniel.hnd2.beans.TipBean;

import java.util.List;

public class TipsAdapter extends ArrayAdapter<TipBean>{
    private Context context;
    private int resource;
    private List<TipBean> objects;

    public TipsAdapter(Context context, int resource, List<TipBean> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.objects=objects;
    }

    class ViewHolder{
        TextView txtItem;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if(view==null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource,null);
            viewHolder.txtItem = (TextView) view.findViewById(R.id.txtItem);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        TipBean tipBean = objects.get(position);

        viewHolder.txtItem.setText(tipBean.getTitulo());
        return view;
    }
}
