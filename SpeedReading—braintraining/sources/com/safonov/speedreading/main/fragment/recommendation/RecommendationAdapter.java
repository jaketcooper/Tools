package com.safonov.speedreading.main.fragment.recommendation;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.safonov.speedreading.main.fragment.recommendation.model.Recommendation;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class RecommendationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnItemClickListener itemClickListener;
    private List<Recommendation> items = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder target2, View source) {
            this.target = target2;
            target2.favoriteImageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.item_favorite_image_view, "field 'favoriteImageView'", ImageView.class);
            target2.titleTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.item_title_text_view, "field 'titleTextView'", TextView.class);
            target2.messageTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.item_message_text_view, "field 'messageTextView'", TextView.class);
            target2.layout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.recommendation_item_view, "field 'layout'", LinearLayout.class);
        }

        @CallSuper
        public void unbind() {
            ViewHolder target2 = this.target;
            if (target2 == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            target2.favoriteImageView = null;
            target2.titleTextView = null;
            target2.messageTextView = null;
            target2.layout = null;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(2131296459)
        ImageView favoriteImageView;
        private OnItemClickListener itemClickListener;
        @BindView(2131296603)
        LinearLayout layout;
        @BindView(2131296461)
        TextView messageTextView;
        @BindView(2131296463)
        TextView titleTextView;

        ViewHolder(View itemView, OnItemClickListener itemClickListener2) {
            super(itemView);
            ButterKnife.bind((Object) this, itemView);
            this.itemClickListener = itemClickListener2;
            this.layout.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (this.itemClickListener != null) {
                this.itemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public RecommendationAdapter(OnItemClickListener itemClickListener2) {
        this.itemClickListener = itemClickListener2;
    }

    public void addItem(@NonNull Recommendation advice) {
        this.items.add(advice);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        this.items.remove(position);
        notifyItemRemoved(position);
    }

    public void setItems(@NonNull List<Recommendation> items2) {
        this.items.clear();
        this.items.addAll(items2);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommendation_item, parent, false), this.itemClickListener);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Recommendation advice = this.items.get(position);
        holder.titleTextView.setText(advice.getTitle());
        holder.messageTextView.setText(advice.getDescription());
    }

    public int getItemCount() {
        return this.items.size();
    }
}
