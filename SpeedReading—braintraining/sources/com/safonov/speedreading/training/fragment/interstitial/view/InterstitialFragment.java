package com.safonov.speedreading.training.fragment.interstitial.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.fragment.interstitial.presenter.IInterstitialPresenter;
import com.safonov.speedreading.training.fragment.interstitial.presenter.InterstitialPresenter;
import com.speedreading.alexander.speedreading.R;

public class InterstitialFragment extends MvpFragment<IInterstitialView, IInterstitialPresenter> implements IInterstitialView {
    private static final String COURSE_TYPE_PARAM = "course_type";
    private static final String TRAINING_INDEX_PARAM = "training_index";
    private TrainingType courseType;
    /* access modifiers changed from: private */
    public InterstitialFragmentListener fragmentListener;
    @BindView(2131296803)
    LinearLayout pager;
    @BindView(2131296559)
    ProgressBar progressBar;
    @BindView(2131296608)
    RecyclerView recyclerView;
    @BindView(2131296444)
    TextView titleTv;
    @BindView(2131296443)
    ImageView topIv;
    @BindView(2131296563)
    TextView trainersLeft;
    private int trainingIndex;
    private Unbinder unbinder;

    @NonNull
    public IInterstitialPresenter createPresenter() {
        return new InterstitialPresenter();
    }

    public static InterstitialFragment newInstance(@NonNull TrainingType courseType2, int trainingIndex2) {
        InterstitialFragment fragment = new InterstitialFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_INDEX_PARAM, trainingIndex2);
        args.putSerializable(COURSE_TYPE_PARAM, courseType2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.trainingIndex = getArguments().getInt(TRAINING_INDEX_PARAM);
            this.courseType = (TrainingType) getArguments().getSerializable(COURSE_TYPE_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.interstitial_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        String[] titles = null;
        switch (this.courseType) {
            case ACCELERATOR_COURSE:
                this.topIv.setImageResource(R.drawable.training_menu_accelerator_icon);
                this.titleTv.setText(R.string.accelerator);
                titles = getResources().getStringArray(R.array.accelerator_course_training_titles);
                break;
            case PASS_COURSE:
                this.topIv.setImageResource(R.drawable.training_menu_base_course_icon);
                this.titleTv.setText(R.string.base_course_name);
                titles = getResources().getStringArray(R.array.pass_course_training_titles);
                break;
        }
        if (titles != null) {
            String[] icons = getResources().getStringArray(R.array.pass_course_training_icons);
            View page = inflater.inflate(R.layout.pass_course_training_page, (ViewGroup) null);
            ((TextView) page.findViewById(R.id.purchase_advantage_title_tv)).setText(titles[this.trainingIndex]);
            ((ImageView) page.findViewById(R.id.purchase_advantage_image_view)).setImageResource(getResources().getIdentifier(icons[this.trainingIndex], "drawable", getActivity().getPackageName()));
            this.trainersLeft.setText(getResources().getString(R.string.pass_course_trainers_left, new Object[]{Integer.valueOf(titles.length - this.trainingIndex)}));
            this.progressBar.setProgress(this.trainingIndex);
            this.progressBar.setMax(titles.length);
            this.pager.addView(page);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.recyclerView.setAdapter(new InterstitialAdapter(titles, this.trainingIndex));
            this.recyclerView.setOverScrollMode(2);
            this.recyclerView.setHasFixedSize(true);
        }
        return view;
    }

    @OnClick({2131296442})
    public void onStartButtonClick() {
        this.fragmentListener.onInterstitialFragmentListenerCompleted();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    @OnClick({2131296560})
    public void onRestartClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.interstitial_restart);
        builder.setMessage((int) R.string.interstitial_restart_description);
        builder.setPositiveButton((int) R.string.interstitial_restart_button, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                InterstitialFragment.this.fragmentListener.onPassCourseRestarted();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton((int) R.string.pass_descr_close, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private static class InterstitialAdapter extends RecyclerView.Adapter<ViewHolder> {
        private int selectedIndex;
        private String[] titles;

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView itemTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                this.itemTextView = (TextView) itemView;
            }
        }

        public InterstitialAdapter(@NonNull String[] titles2, int selectedIndex2) {
            this.titles = titles2;
            this.selectedIndex = selectedIndex2;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.interstitial_item, parent, false));
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            int lastIndex = getItemCount() - 1;
            if (position == 0) {
                holder.itemTextView.setCompoundDrawablesWithIntrinsicBounds(this.selectedIndex == 0 ? R.drawable.training_interstitial_first_selected_item : R.drawable.training_interstitial_first_item, 0, 0, 0);
            } else if (position == lastIndex) {
                holder.itemTextView.setCompoundDrawablesWithIntrinsicBounds(this.selectedIndex == lastIndex ? R.drawable.training_interstitial_last_selected_item : R.drawable.training_interstitial_last_item, 0, 0, 0);
            } else {
                holder.itemTextView.setCompoundDrawablesWithIntrinsicBounds(this.selectedIndex == position ? R.drawable.training_interstitial_selected_item : R.drawable.training_interstitial_item, 0, 0, 0);
            }
            holder.itemTextView.setText(this.titles[position]);
        }

        public int getItemCount() {
            return this.titles.length;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InterstitialFragmentListener) {
            this.fragmentListener = (InterstitialFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement InterstitialFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
    }
}
