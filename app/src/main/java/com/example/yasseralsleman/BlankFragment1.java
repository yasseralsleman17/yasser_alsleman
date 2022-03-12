package com.example.yasseralsleman;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.gridlayout.widget.GridLayout;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    LinearLayout linear_cat, linear_prof, linear_sub_category;

    ScrollView parentScrollView;
    HorizontalScrollView scroll, scroll2, scroll3;
    TextView tv;

    GridLayout gridLayout, gridLayout2;


    int images[]={R.drawable.im_11,R.drawable.im_33,R.drawable.im_22,R.drawable.im_33,R.drawable.im_11,R.drawable.im_22,R.drawable.im_33,R.drawable.im_22,R.drawable.im_11,R.drawable.im_22,R.drawable.im_33};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);

        parentScrollView = view.findViewById(R.id.parentScrollView);
        scroll = view.findViewById(R.id.scroll);
        scroll2 = view.findViewById(R.id.scroll2);
        scroll3 = view.findViewById(R.id.scroll3);
        gridLayout = view.findViewById(R.id.gridLayout);
        linear_prof = view.findViewById(R.id.linear_prof);
        linear_sub_category = view.findViewById(R.id.linear_sub_category);
        gridLayout2 = view.findViewById(R.id.gridLayout2);


        parentScrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                scroll.requestDisallowInterceptTouchEvent(false);
                scroll2.requestDisallowInterceptTouchEvent(false);
                scroll3.requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scroll.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // Disallow the touch request for parent scroll on touch of  child view
                parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        scroll2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // Disallow the touch request for parent scroll on touch of  child view
                parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        scroll3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // Disallow the touch request for parent scroll on touch of  child view
                parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        tv = view.findViewById(R.id.tv);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        linear_cat = view.findViewById(R.id.linear_cat);
        for (int i = 0; i < 10; i++)
            add_category(i);
        for (int i = 0; i < 10; i++)
            add_sub_category(i);

        for (int i = 0; i < 10; i++)
            add_prof(i);
        for (int i = 0; i < 6; i++)
            add_pic(i);
        for (int i = 0; i < 3; i++)
            add_pic2(i);

        return view;
    }

    private void add_pic2(int i) {
        View view = getLayoutInflater().inflate(R.layout.item, null);

        gridLayout2.addView(view);


    }

    private void add_sub_category(int i) {
        View view = getLayoutInflater().inflate(R.layout.sub_category, null);
        TextView sub_cat_title = view.findViewById(R.id.sub_cat_title);
        linear_sub_category.addView(view);

    }

    private void add_prof(int i) {


        View view = getLayoutInflater().inflate(R.layout.profile, null);

        TextView cat_title = view.findViewById(R.id.prof_title);
        ImageView image_prof = view.findViewById(R.id.image_prof);
        image_prof.setImageResource(images[i]);
        cat_title.setText("@user" + (i + 1));
        linear_prof.addView(view);
    }

    private void add_pic(int i) {


        View view = getLayoutInflater().inflate(R.layout.item, null);

        gridLayout.addView(view);
    }

    private void add_category(int i) {


        View view = getLayoutInflater().inflate(R.layout.category, null);
        TextView cat_title = view.findViewById(R.id.cat_title);
        cat_title.setText("main\nCATEGORY" + (i + 1));
        linear_cat.addView(view);

    }
}