package com.example.akash.independencedayapp;


import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuotesFragment extends Fragment {

    public QuotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_layout, container, false);

        TextView quoteTextView = view.findViewById(R.id.quote_text_view);
        quoteTextView.setText(getArguments().getString(getString(R.string.quote_text)));

        return view;
    }

    public static QuotesFragment newInstance(Context context, String quote) {

        QuotesFragment quotesFragment = new QuotesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(context.getResources().getString(R.string.quote_text), quote);
        quotesFragment.setArguments(bundle);

        return quotesFragment;
    }

}
