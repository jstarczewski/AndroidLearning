package com.clakestudio.pc.recyclerviewtutorial.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.clakestudio.pc.recyclerviewtutorial.R;
import com.clakestudio.pc.recyclerviewtutorial.data.FakeDataSource;
import com.clakestudio.pc.recyclerviewtutorial.data.ListItem;
import com.clakestudio.pc.recyclerviewtutorial.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOUR = "EXTRA_COLOUR";

    private List<ListItem> listOdData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        controller = new Controller(this, new FakeDataSource());

    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("")
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOdData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                coloredCircle = itemView.findViewById(R.id.iv_list_item_circle);
                dateAndTime = (TextView)itemView.findViewById(R.id.tv_date_and_time);
                message = (TextView)itemView.findViewById(R.id.tv_message);
                container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {
                ListItem listItem = listOdData.get(this.getAdapterPosition());
                controller.onListItemClick(listItem);
            }
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            CustomViewHolder customViewHolder = new CustomViewHolder(v);

            return customViewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = listOdData.get(position);
            holder.coloredCircle.setBackgroundResource(currentItem.getColorResource());
            holder.dateAndTime.setText(currentItem.getDateAndTime());
            holder.message.setText(currentItem.getMessage());
        }

        @Override
        public int getItemCount() {
            return listOdData.size();
        }

    }

}
