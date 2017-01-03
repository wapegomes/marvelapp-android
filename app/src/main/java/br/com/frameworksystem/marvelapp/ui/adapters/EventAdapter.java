package br.com.frameworksystem.marvelapp.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Event;
import br.com.frameworksystem.marvelapp.model.MarvelImage;
import br.com.frameworksystem.marvelapp.ui.activities.EventDetailActivity;

/**
 * Created by wgomes on 22/06/16.
 */
public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SELECT_VIEW = 100;
    private Context context;
    private List<Event> events;
    private RecyclerView recyclerView;
    private Boolean isTablet;
    private WebView webView;
    private boolean isSelectAll = false;

    public EventAdapter(Context context, List<Event> eventList, RecyclerView recyclerView,
                        boolean isTablet, WebView webView) {
        this.context = context;
        this.events = eventList;
        this.recyclerView = recyclerView;
        this.isTablet = isTablet;
        this.webView = webView;
    }

    public EventAdapter(Context context, List<Event> eventList, RecyclerView recyclerView,
                        boolean isTablet) {
        this.context = context;
        this.events = eventList;
        this.recyclerView = recyclerView;
        this.isTablet = isTablet;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == SELECT_VIEW) {
            view = LayoutInflater.from(context).inflate(R.layout.select_item, parent, false);
            EventAdapter.SelectViewHolder selectViewHolder = new EventAdapter.SelectViewHolder
                    (view);
            return selectViewHolder;
        }

        view = LayoutInflater.from(context)
                .inflate(R.layout.item_event, parent, false);
        EventAdapter.ViewHolder viewHolder = new EventAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            Event event = events.get(position);
            ViewHolder holderNew = (ViewHolder) holder;
            holderNew.checkbox.setChecked(isSelectAll);
            holderNew.eventTitle.setText(event.title);
            Picasso.with(context).load(event.thumbnail.getImageUrl(MarvelImage.Size.DETAIL))
                    .centerCrop().resize(400, 400).into(holderNew.eventImg);
        }

    }


    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return SELECT_VIEW;
        }
        return super.getItemViewType(position);
    }

    public class SelectViewHolder extends RecyclerView.ViewHolder {
        public SelectViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(onClickListener);

        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelectAll = true;
                notifyDataSetChanged();
            }
        };
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatCheckBox checkbox;
        ImageView eventImg;
        TextView eventTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            eventImg = (ImageView) itemView.findViewById(R.id.event_img);
            eventTitle = (TextView) itemView.findViewById(R.id.event_title);
            checkbox = (AppCompatCheckBox) itemView.findViewById(R.id.selectItem);

            itemView.setOnClickListener(onClickListener);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                Event event = events.get(position);
                if (!isTablet) {
                    Intent intent = new Intent(context, EventDetailActivity.class);
                    intent.putExtra("event", event);
                    context.startActivity(intent);
                } else {
                    //Apenas para exemplicar
                    webView.loadUrl(event.urls.get(0).url);
                }

            }
        };

    }
}
