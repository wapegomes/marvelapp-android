package br.com.frameworksystem.marvelapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

//import br.com.frameworksystem.marvelapp.Mock;
import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.ui.adapters.EventAdapter;

/**
 * Created by wgomes on 22/06/16.
 */

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private Boolean isTablet;
    private WebView webView;


    public static Fragment newInstance() {
        return new EventFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (!isTablet) {
            return inflater.inflate(R.layout.fragment_recycler, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_recycler_tablet, container, false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);

        if (isTablet) {
            webView = (WebView) view.findViewById(R.id.webview_event_detail_tablet);
        }

//        eventAdapter = new EventAdapter(getActivity(), Mock.getEvents(), recyclerView);
//        recyclerView.setAdapter(eventAdapter);

    }
}
