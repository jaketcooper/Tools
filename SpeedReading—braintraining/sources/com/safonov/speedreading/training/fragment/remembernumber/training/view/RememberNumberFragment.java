package com.safonov.speedreading.training.fragment.remembernumber.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.remembernumber.repository.RememberNumberRealmUtil;
import com.safonov.speedreading.training.fragment.remembernumber.training.model.RememberNumberModel;
import com.safonov.speedreading.training.fragment.remembernumber.training.presenter.IRememberNumberPresenter;
import com.safonov.speedreading.training.fragment.remembernumber.training.presenter.RememberNumberPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class RememberNumberFragment extends MvpFragment<IRememberNumberView, IRememberNumberPresenter> implements IRememberNumberView, IAnimatedFragment {
    private static final int CARD_TEXT_SIZE_SP = 40;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindColor(2131099674)
    int acceptGreen;
    @BindViews({2131296610, 2131296611, 2131296612, 2131296613, 2131296614, 2131296615, 2131296616, 2131296617, 2131296618, 2131296609, 2131296619})
    List<View> buttons;
    private final LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    @BindDimen(2131165347)
    int cardMargin;
    @BindDimen(2131165348)
    int cardPadding;
    private List<TextView> cards = new ArrayList();
    @BindView(2131296620)
    LinearLayout cardsLayout;
    @BindColor(2131099693)
    int colorAccent;
    private int configId;
    @BindView(2131296590)
    ProgressBar progressBar;
    @BindView(2131296607)
    TextView recordTextView;
    @BindColor(2131099757)
    int reject_red;
    private RememberNumberModel rememberNumberModel;
    private RememberNumberRealmUtil rememberNumberRealmUtil;
    @BindView(2131296648)
    TextView scoreTextView;
    private RememberNumberTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    @NonNull
    public IRememberNumberPresenter createPresenter() {
        this.rememberNumberRealmUtil = new RememberNumberRealmUtil(((App) getActivity().getApplication()).getRememberNumberRealm());
        this.rememberNumberModel = new RememberNumberModel();
        return new RememberNumberPresenter(this.rememberNumberModel, this.rememberNumberRealmUtil);
    }

    public static RememberNumberFragment newInstance(int configId2) {
        Log.d("configId", "" + configId2);
        RememberNumberFragment fragment = new RememberNumberFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remember_number_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IRememberNumberPresenter) this.presenter).startTraining(this.configId);
    }

    @OnClick({2131296610, 2131296611, 2131296612, 2131296613, 2131296614, 2131296615, 2131296616, 2131296617, 2131296618, 2131296609})
    public void onNumberButtonClick(Button button) {
        ((IRememberNumberPresenter) this.presenter).onNumberButtonPressed(button.getText().toString());
    }

    @OnClick({2131296619})
    public void onBackspaceButtonClick() {
        ((IRememberNumberPresenter) this.presenter).onBackspaceButtonPressed();
    }

    public void updateScoreView(int score) {
        this.scoreTextView.setText(getString(R.string.remember_number_score, Integer.valueOf(score)));
    }

    public void updateBestScoreView(int record) {
        this.recordTextView.setText(getString(R.string.remember_number_best_score, Integer.valueOf(record)));
    }

    public void initProgressBar(int maxProgress) {
        this.progressBar.setMax(maxProgress);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void setButtonsEnabled(boolean enabled) {
        for (View button : this.buttons) {
            button.setEnabled(enabled);
        }
    }

    public void setCardViews(int count) {
        this.cardLayoutParams.setMargins(this.cardMargin, 0, this.cardMargin, 0);
        if (this.cards.isEmpty()) {
            for (int i = 0; i < count; i++) {
                TextView card = createCard();
                this.cards.add(card);
                this.cardsLayout.addView(card);
            }
            return;
        }
        if (count == this.cards.size() + 1) {
            TextView card2 = createCard();
            this.cards.add(card2);
            this.cardsLayout.addView(card2);
        }
        if (count == this.cards.size() - 1) {
            this.cards.remove(count - 1);
            this.cardsLayout.removeViewAt(count - 1);
        }
    }

    private TextView createCard() {
        TextView card = new TextView(getContext());
        card.setLayoutParams(this.cardLayoutParams);
        card.setPadding(this.cardPadding, this.cardPadding, this.cardPadding, this.cardPadding);
        card.setGravity(17);
        card.setTextSize(2, 40.0f);
        return card;
    }

    public void setCardsValues(String[] values) {
        for (int i = 0; i < this.cards.size(); i++) {
            this.cards.get(i).setText(values[i]);
        }
    }

    public void setCardValueAt(int cardIndex, String value) {
        this.cards.get(cardIndex).setText(value);
    }

    public void setCardsDefaultValues() {
        for (TextView card : this.cards) {
            card.setText("_");
        }
    }

    public void sedDefaultCardValueAt(int cardIndex) {
        this.cards.get(cardIndex).setText("_");
    }

    public void setCardsDefaultBackground() {
        for (TextView card : this.cards) {
            card.setBackgroundResource(R.drawable.remember_number_card_background);
        }
    }

    public void setCardAnswerBackgroundAt(int cardIndex, boolean isTrueAnswer) {
        this.cards.get(cardIndex).setBackgroundResource(isTrueAnswer ? R.drawable.remember_number_card_success_background : R.drawable.remember_number_card_error_background);
        this.cards.get(cardIndex).setTextColor(-1);
    }

    public void setCardsDefaultTextColor() {
        for (TextView card : this.cards) {
            card.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public void setBlinkCardsTextColor() {
        for (TextView card : this.cards) {
            card.setTextColor(this.colorAccent);
        }
    }

    public void pauseAnimations() {
        ((IRememberNumberPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((IRememberNumberPresenter) this.presenter).resumeTraining();
    }

    public void onDestroy() {
        super.onDestroy();
        this.rememberNumberModel = null;
        this.rememberNumberRealmUtil.close();
        this.rememberNumberRealmUtil = null;
        ((IRememberNumberPresenter) this.presenter).cancelTraining();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    public void onRememberNumberTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onRememberNumberTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RememberNumberTrainingCompleteListener) {
            this.trainingCompleteListener = (RememberNumberTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement RememberNumberTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
