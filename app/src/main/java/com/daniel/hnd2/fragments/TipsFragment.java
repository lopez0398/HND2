package com.daniel.hnd2.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.activities.ObjetoActivity;
import com.daniel.hnd2.activities.TipActivity;
import com.daniel.hnd2.adapters.TipsAdapter;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.beans.TipBean;
import com.daniel.hnd2.test.ModeloTip;

import java.util.ArrayList;

public class TipsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<TipBean> tips;
    private ListView listTips;
    public static final String TIP_KEY="TIP_KEY";

    public TipsFragment() {
        // Required empty public constructor
    }

    public static TipsFragment newInstance(){
        return new TipsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        listTips = (ListView) view.findViewById(R.id.listTips);
        tips = ModeloTip.getTips();

        TipsAdapter adapter = new TipsAdapter(getActivity(), R.layout.item, tips);
        listTips.setAdapter(adapter);
        listTips.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
        TipBean tipBean = tips.get(posicion);
        Intent intent = new Intent(getActivity(), TipActivity.class);
        intent.putExtra(TIP_KEY, tipBean);

        startActivity(intent);
    }
}
