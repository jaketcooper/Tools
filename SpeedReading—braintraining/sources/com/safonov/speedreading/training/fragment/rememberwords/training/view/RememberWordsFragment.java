package com.safonov.speedreading.training.fragment.rememberwords.training.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.rememberwords.repository.IRememberWordsRepository;
import com.safonov.speedreading.training.fragment.rememberwords.repository.RememberWordsRealmUtil;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import com.safonov.speedreading.training.fragment.rememberwords.training.presenter.IRememerWordsPresenter;
import com.safonov.speedreading.training.fragment.rememberwords.training.presenter.RememberWordsPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RememberWordsFragment extends MvpFragment<IRememberWordsView, IRememerWordsPresenter> implements IRememberWordsView, IAnimatedFragment, View.OnClickListener {
    public static final int DEFAULT_DURATION = 0;
    public static final int DEFAULT_ELEVATION = 3;
    public static final int DEFAULT_LEVELS_COUNT = 20;
    public static final int DEFAULT_MARGIN = 6;
    public static final int SHOW_WORD_DURATION = 3000;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    /* access modifiers changed from: private */
    public int answerCount = 0;
    @BindView(2131296298)
    LinearLayout answerLayout;
    List<String> answerList = new ArrayList();
    @BindView(2131296297)
    LinearLayout answersContainer;
    RememberWordsConfig config;
    private int configId;
    /* access modifiers changed from: private */
    public int correctCount = 0;
    private int correctLevelsCount = 0;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public int incorrectCount = 0;
    private int incorrectLevelsCount = 0;
    private Runnable pointTextViewRunnable = new Runnable() {
        public void run() {
            RememberWordsFragment.this.pointsTextView.setVisibility(4);
        }
    };
    @BindView(2131296569)
    TextView pointsTextView;
    /* access modifiers changed from: private */
    public Runnable preShowWordRunnable = new Runnable() {
        public void run() {
            Collections.shuffle(RememberWordsFragment.this.words);
            int countRow = 0;
            int count = 0;
            boolean isNeedWordsForRequest = true;
            for (String word : RememberWordsFragment.this.words) {
                if (countRow == 0) {
                    RememberWordsFragment.this.rowsRequest.add(RememberWordsFragment.this.createTableRow(RememberWordsFragment.this.wordsLayout));
                }
                if (isNeedWordsForRequest) {
                    RememberWordsFragment.this.requestList.add(word);
                    TextView unused = RememberWordsFragment.this.createTextViewForRequest(word, RememberWordsFragment.this.rowsRequest.get(RememberWordsFragment.this.rowsRequest.size() - 1));
                }
                countRow++;
                count++;
                if (countRow == 3) {
                    countRow = 0;
                }
                if (count == RememberWordsFragment.this.wordsCount) {
                    isNeedWordsForRequest = false;
                }
                RememberWordsFragment.this.answerList.add(word);
                if (count == (RememberWordsFragment.this.wordsCount + RememberWordsFragment.this.wordsCount) - 1) {
                    break;
                }
            }
            Collections.shuffle(RememberWordsFragment.this.answerList);
            int count2 = 0;
            int countRow2 = 0;
            for (String word2 : RememberWordsFragment.this.answerList) {
                if (countRow2 == 0) {
                    RememberWordsFragment.this.rowsAnswer.add(RememberWordsFragment.this.createTableRow(RememberWordsFragment.this.tableLayout));
                }
                Button unused2 = RememberWordsFragment.this.createButtonForTableRow(word2, RememberWordsFragment.this.rowsAnswer.get(RememberWordsFragment.this.rowsAnswer.size() - 1));
                countRow2++;
                count2++;
                if (countRow2 == 3) {
                    countRow2 = 0;
                }
            }
            RememberWordsFragment.this.handler.postDelayed(RememberWordsFragment.this.showWordRunnable, 0);
        }
    };
    /* access modifiers changed from: private */
    public int progress = 0;
    @BindView(2131296407)
    ProgressBar progressBar;
    @BindView(2131296408)
    TextView recordTextView;
    private RememberWordsRealmUtil rememberWordsRealmUtil;
    List<String> requestList = new ArrayList();
    private Runnable restartRunnable = new Runnable() {
        public void run() {
            int unused = RememberWordsFragment.this.incorrectCount = 0;
            int unused2 = RememberWordsFragment.this.answerCount = 0;
            int unused3 = RememberWordsFragment.this.correctCount = 0;
            RememberWordsFragment.this.wordsLayout.removeAllViews();
            RememberWordsFragment.this.answersContainer.removeAllViews();
            RememberWordsFragment.this.requestList.clear();
            RememberWordsFragment.this.answerList.clear();
            RememberWordsFragment.this.rowsRequest.clear();
            RememberWordsFragment.this.rowsAnswer.clear();
            RememberWordsFragment.this.answerLayout.setVisibility(8);
            RememberWordsFragment.this.wordsLayout.setVisibility(8);
            RememberWordsFragment.this.statisticsLayout.setVisibility(8);
            RememberWordsFragment.this.progressBar.setProgress(RememberWordsFragment.this.progress);
            RememberWordsFragment.this.handler.postDelayed(RememberWordsFragment.this.preShowWordRunnable, 0);
        }
    };
    List<TableRow> rowsAnswer = new ArrayList();
    List<TableRow> rowsRequest = new ArrayList();
    @BindView(2131296409)
    TextView score;
    private int scoreVal = 0;
    @BindView(2131296430)
    HorizontalScrollView scrollView;
    /* access modifiers changed from: private */
    public Runnable showAnswerRunnable = new Runnable() {
        public void run() {
            RememberWordsFragment.this.wordsLayout.setVisibility(8);
            RememberWordsFragment.this.statisticsLayout.setVisibility(0);
            RememberWordsFragment.this.answerLayout.setVisibility(0);
        }
    };
    /* access modifiers changed from: private */
    public Runnable showWordRunnable = new Runnable() {
        public void run() {
            RememberWordsFragment.this.wordsLayout.setVisibility(0);
            RememberWordsFragment.this.answerLayout.setVisibility(8);
            RememberWordsFragment.this.statisticsLayout.setVisibility(8);
            RememberWordsFragment.this.handler.postDelayed(RememberWordsFragment.this.showAnswerRunnable, 3000);
        }
    };
    @BindView(2131296410)
    LinearLayout statisticsLayout;
    @BindView(2131296733)
    TableLayout tableLayout;
    private RememberWordsTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;
    List<String> words;
    /* access modifiers changed from: private */
    public int wordsCount = 0;
    @BindView(2131296840)
    TableLayout wordsLayout;

    @NonNull
    public IRememerWordsPresenter createPresenter() {
        this.rememberWordsRealmUtil = new RememberWordsRealmUtil(((App) getActivity().getApplication()).getRememberWordsRealm());
        this.config = this.rememberWordsRealmUtil.getConfig(this.configId);
        this.wordsCount = this.config.getStartWordsCount();
        RememberWordsResult bestResult = this.rememberWordsRealmUtil.getBestResult(this.configId);
        TextView textView = this.recordTextView;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bestResult == null ? 0 : bestResult.getScore());
        textView.setText(getString(R.string.remember_number_best_score, objArr));
        return new RememberWordsPresenter(this.rememberWordsRealmUtil);
    }

    public static RememberWordsFragment newInstance(int configId2) {
        Log.d("configId", "" + configId2);
        RememberWordsFragment fragment = new RememberWordsFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.words = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.speed_reading_words)));
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remember_words_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.progressBar.setMax(20);
        this.progressBar.setProgress(this.progress);
        this.score.setText(getString(R.string.remember_number_score, Integer.valueOf(this.scoreVal)));
        this.handler.postDelayed(this.preShowWordRunnable, 0);
        return view;
    }

    public void setPointsTextViewCorrect() {
        this.pointsTextView.setVisibility(0);
        this.pointsTextView.setText("+1");
        this.pointsTextView.setTextColor(getResources().getColor(17170453));
        this.pointsTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.points_scale));
    }

    public void setPointsTextViewIncorrect() {
        this.pointsTextView.setVisibility(0);
        this.pointsTextView.setText("-1");
        this.pointsTextView.setTextColor(getResources().getColor(17170455));
        this.pointsTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.points_scale));
    }

    public void onRememberWordsTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onRememberWordsTrainingCompleted(trainingResultId);
    }

    public void pauseAnimations() {
    }

    public void resumeAnimations() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RememberWordsTrainingCompleteListener) {
            this.trainingCompleteListener = (RememberWordsTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement RememberNumberTrainingCompleteListener");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.preShowWordRunnable);
        this.handler.removeCallbacks(this.showWordRunnable);
        this.handler.removeCallbacks(this.showAnswerRunnable);
        this.handler.removeCallbacks(this.restartRunnable);
        this.handler.removeCallbacks(this.pointTextViewRunnable);
        this.handler = null;
        this.presenter = null;
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }

    public void onClick(View v) {
        String word = String.valueOf(((Button) v).getText());
        v.setEnabled(false);
        this.answerCount++;
        if (this.requestList.contains(word)) {
            this.answersContainer.addView(createTextViewForAnswer(word, true));
            this.correctCount++;
            this.scoreVal++;
            this.score.setText(getString(R.string.remember_number_score, Integer.valueOf(this.scoreVal)));
            setPointsTextViewCorrect();
        } else {
            this.answersContainer.addView(createTextViewForAnswer(word, false));
            this.incorrectCount++;
            this.correctLevelsCount = 0;
            this.scoreVal--;
            if (this.scoreVal < 0) {
                this.scoreVal = 0;
            }
            this.score.setText(getString(R.string.remember_number_score, Integer.valueOf(this.scoreVal)));
            setPointsTextViewIncorrect();
        }
        if (this.scrollView != null) {
            this.scrollView.fullScroll(66);
        }
        if (this.pointsTextView != null) {
            this.handler.postDelayed(this.pointTextViewRunnable, 500);
        }
        if (this.answerCount >= this.requestList.size()) {
            if (this.correctCount == this.requestList.size()) {
                this.correctLevelsCount++;
                this.incorrectCount = 0;
                if (this.correctLevelsCount == 3) {
                    this.wordsCount++;
                    this.rememberWordsRealmUtil.updateConfigWordsCount(this.configId, this.wordsCount);
                    this.correctLevelsCount = 0;
                }
            } else {
                this.correctLevelsCount = 0;
                this.incorrectCount++;
                if (this.incorrectCount == 3) {
                    this.wordsCount--;
                    this.rememberWordsRealmUtil.updateConfigWordsCount(this.configId, this.wordsCount);
                    this.incorrectCount = 0;
                }
            }
            this.tableLayout.removeAllViews();
            this.progress++;
            if (this.progress == 20) {
                RememberWordsResult result = new RememberWordsResult();
                result.setScore(this.scoreVal);
                this.rememberWordsRealmUtil.addResult(result, this.configId, new IRememberWordsRepository.OnSingleTransactionCallback() {
                    public void onTransactionCompleted(int id) {
                        RememberWordsFragment.this.onRememberWordsTrainingCompleted(id);
                    }
                });
                return;
            }
            this.handler.postDelayed(this.restartRunnable, 3000);
        }
    }

    /* access modifiers changed from: private */
    public TextView createTextViewForRequest(String text, TableRow row) {
        int defaultIndenting = dpToPx(6);
        TableRow.LayoutParams params = new TableRow.LayoutParams(-1, -2, 1.0f);
        params.setMargins(defaultIndenting, defaultIndenting, defaultIndenting, defaultIndenting);
        TextView result = new TextView(getActivity());
        result.setLayoutParams(params);
        result.setText(text);
        result.setTextSize(2, 14.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            result.setTextAlignment(4);
        } else {
            result.setGravity(17);
        }
        setBackground(result, R.drawable.rounded_corners_gray);
        setDefaultElevation(result);
        result.setPadding(defaultIndenting, defaultIndenting * 2, defaultIndenting, defaultIndenting * 2);
        row.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.alpha));
        row.addView(result);
        return result;
    }

    private TextView createTextViewForAnswer(String text, boolean isTrueAnswer) {
        int defaultIndenting = dpToPx(6);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        params.setMargins(defaultIndenting, defaultIndenting, defaultIndenting, defaultIndenting);
        TextView result = new TextView(getActivity());
        result.setLayoutParams(params);
        result.setText(text);
        result.setTextSize(2, 16.0f);
        if (isTrueAnswer) {
            setBackground(result, R.drawable.rounded_corners);
        } else {
            setBackground(result, R.drawable.rounded_corners_red);
        }
        setDefaultElevation(result);
        result.setPadding(defaultIndenting, defaultIndenting, defaultIndenting, defaultIndenting);
        result.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.bounce));
        return result;
    }

    /* access modifiers changed from: private */
    public Button createButtonForTableRow(String text, TableRow row) {
        Button button = createButton(text);
        row.addView(button);
        row.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.alpha));
        return button;
    }

    private Button createButton(String text) {
        int defaultIndenting = dpToPx(6);
        TableRow.LayoutParams params = new TableRow.LayoutParams(-1, -2, 1.0f);
        params.setMargins(defaultIndenting, defaultIndenting, defaultIndenting, defaultIndenting);
        Button result = new Button(getActivity());
        result.setLayoutParams(params);
        result.setText(text);
        result.setTextSize(2, 12.0f);
        if (Build.VERSION.SDK_INT >= 23) {
            result.setTextAppearance(16974259);
        } else {
            result.setTextAppearance(getActivity(), 16974259);
        }
        result.setAllCaps(false);
        setBackground(result, R.drawable.rounded_corners_gray);
        setDefaultElevation(result);
        result.setPadding(defaultIndenting / 2, defaultIndenting, defaultIndenting / 2, defaultIndenting);
        result.setOnClickListener(this);
        return result;
    }

    /* access modifiers changed from: private */
    public TableRow createTableRow(TableLayout layout) {
        TableRow tableRow = new TableRow(getActivity());
        tableRow.setLayoutParams(new TableRow.LayoutParams(-1, -2));
        layout.addView(tableRow);
        return tableRow;
    }

    private void setBackground(View v, int bacgroundId) {
        if (Build.VERSION.SDK_INT < 16) {
            v.setBackgroundDrawable(getResources().getDrawable(bacgroundId));
        } else {
            v.setBackground(getResources().getDrawable(bacgroundId));
        }
    }

    private void setDefaultElevation(View v) {
        if (Build.VERSION.SDK_INT >= 21) {
            v.setElevation((float) dpToPx(3));
        }
    }

    public int dpToPx(int dp) {
        return Math.round(((float) dp) * getResources().getDisplayMetrics().density);
    }
}
