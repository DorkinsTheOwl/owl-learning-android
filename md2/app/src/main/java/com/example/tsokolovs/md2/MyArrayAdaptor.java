package com.example.tsokolovs.md2;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyArrayAdaptor extends ArrayAdapter<CharSequence> {

    public MyArrayAdaptor(Context context, int textViewResId, CharSequence[] strings) {
        super(context, textViewResId, strings);
    }

    public static MyArrayAdaptor createFromResource(
            Context context, int textArrayResId, int textViewResId) {

        Resources resources = context.getResources();
        CharSequence[] strings = resources.getTextArray(textArrayResId);

        return new MyArrayAdaptor(context, textViewResId, strings);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v;
        if (position == 0) {
            TextView tv = new TextView(getContext());
            tv.setVisibility(View.GONE);
            tv.setHeight(0);
            v = tv;
        } else {
            v = super.getDropDownView(position, null, parent);
        }
        parent.setVerticalScrollBarEnabled(false);
        return v;
    }
}