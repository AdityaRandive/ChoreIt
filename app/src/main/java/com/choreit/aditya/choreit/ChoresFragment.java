package com.choreit.aditya.choreit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChoresFragment extends Fragment {
    private static final String TAG = "ChoresFragment";
    private PopupWindow popupWindow;
    ListView list;
    private List<String> itemList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chores_fragment, container, false);

        itemList = new ArrayList<String>();
        list = (ListView) view.findViewById(R.id.chores_list);

        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.chores_textview, itemList);
        list.setAdapter(arrayAdapter);

        FloatingActionButton chores_fab = (FloatingActionButton) view.findViewById(R.id.chores_fab);
        chores_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chores functionality
                addChores(v);

            }
        });

        return view;
    }

    public void addChores(View view) {
        popupWindow = new PopupWindow(view, 700, 300, true);
        View popupLayout = getLayoutInflater().inflate(R.layout.chores_popup, null);
        popupWindow.setContentView(popupLayout);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0,0);

        final EditText userInput = (EditText) popupLayout.findViewById(R.id.ETNewChore);

        final Button button = (Button) popupLayout.findViewById(R.id.ChoreAddBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String itemToAdd = userInput.getText().toString();
                if (itemToAdd.isEmpty() || itemToAdd == null) {
                    Toast toast = Toast.makeText(getActivity(), "Please enter a non-empty value and try again", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    itemList.add(itemToAdd);
                    list.setAdapter(arrayAdapter);
                    popupWindow.dismiss();
                    Toast toast = Toast.makeText(getActivity(), itemToAdd + " successfully added to list", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
