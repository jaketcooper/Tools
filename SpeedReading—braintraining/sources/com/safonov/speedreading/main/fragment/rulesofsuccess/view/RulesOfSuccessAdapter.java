package com.safonov.speedreading.main.fragment.rulesofsuccess.view;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class RulesOfSuccessAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String[] items;

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder target2, View source) {
            this.target = target2;
            target2.titleTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.item_message_text_view, "field 'titleTextView'", TextView.class);
        }

        @CallSuper
        public void unbind() {
            ViewHolder target2 = this.target;
            if (target2 == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            target2.titleTextView = null;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131296461)
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind((Object) this, itemView);
        }
    }

    public void setItems(@NonNull String[] titles) {
        this.items = titles;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rule_of_success_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(String.valueOf(position + 1) + ". " + this.items[position]);
    }

    public int getItemCount() {
        return this.items.length;
    }
}
