package com.application.frago;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFragment extends Fragment {

    // List of items
    String itemList[] = {"Jablko", "Banan"};
    // List of images
    int imageList[] = {R.drawable.apple, R.drawable.banana};

    // ListView
    ListView listView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shopping_list_activity, container, false);    // prirazeni XML pro pohled

        listView = view.findViewById(R.id.shoppingListView);    // priradit listView k danemu elementu

        // Set up the custom adapter
        OwnAdapter ownAdapter = new OwnAdapter(getActivity(), itemList, imageList); // vytvoreni promenne vlastniho adapteru
        listView.setAdapter(ownAdapter);    //nastavit adapter pro listview

        return view;
    }
}
