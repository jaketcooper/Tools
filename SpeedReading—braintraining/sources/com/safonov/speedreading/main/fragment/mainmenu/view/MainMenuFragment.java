package com.safonov.speedreading.main.fragment.mainmenu.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.p005rd.animation.AbsAnimation;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.ratedialog.RateDialog;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.TrainingFragmentListener;
import com.safonov.speedreading.main.fragment.mainmenu.presenter.IMainMenuPresenter;
import com.safonov.speedreading.main.fragment.mainmenu.presenter.MainMenuPresenter;
import com.safonov.speedreading.reader.library.library.view.LibraryFragmentListener;
import com.safonov.speedreading.reader.reader.view.ReaderActivity;
import com.safonov.speedreading.reader.repository.BookController;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.Fb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.TxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.view.TrainingActivity;
import com.safonov.speedreading.training.fragment.passcource.repository.PassCourseRealmUtil;
import com.speedreading.alexander.speedreading.R;
import java.util.Locale;
import java.util.Random;

public class MainMenuFragment extends MvpFragment<IMainMenuView, IMainMenuPresenter> implements IMainMenuView {
    private static final int PURCHASE_REQUEST_CODE = 1002;
    @BindColor(2131099693)
    int colorAccent;
    @BindView(2131296407)
    ProgressBar focusAttentionPB;
    private LibraryFragmentListener libraryFragmentListener;
    private MenuFragmentListener menuFragmentListener;
    private PassCourseRealmUtil passCourseRealmUtil;
    @BindView(2131296568)
    TextView pointsLeftTV;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296585)
    TextView profileTitleTV;
    String randomRecomendationLink;
    @BindView(2131296602)
    TextView recomendationDescriptionView;
    int recomendationIndex;
    @BindView(2131296605)
    TextView recomendationTitleView;
    @BindView(2131296648)
    TextView scoreTextView;
    @BindView(2131296693)
    TextView speedReadingBookNotTV;
    @BindView(2131296696)
    TextView speedReadingBookStartTV;
    /* access modifiers changed from: private */
    public TrainingFragmentListener trainingMenuFragmentListener;
    private Unbinder unbinder;

    @NonNull
    public IMainMenuPresenter createPresenter() {
        this.passCourseRealmUtil = new PassCourseRealmUtil(App.get().getPassCourseConfiguration());
        return new MainMenuPresenter(this.passCourseRealmUtil);
    }

    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_main_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (getActivity().getSharedPreferences("load_book", 0).getLong("book_id", -1) > -1) {
            this.speedReadingBookStartTV.setVisibility(0);
            this.speedReadingBookNotTV.setVisibility(4);
        } else {
            this.speedReadingBookStartTV.setVisibility(4);
            this.speedReadingBookNotTV.setVisibility(0);
        }
        RateDialog rateDialog = new RateDialog(getContext());
        if (rateDialog.isShouldShow()) {
            rateDialog.show();
        }
        String[] arrayTitles = getResources().getStringArray(R.array.recommendation_services_title);
        String[] arrayDescriptions = getResources().getStringArray(R.array.recommendation_services_description);
        String[] arrayLinks = getResources().getStringArray(R.array.recommendation_services_link);
        this.recomendationIndex = new Random().nextInt(arrayTitles.length);
        String randomTitle = arrayTitles[this.recomendationIndex];
        String randomDescription = arrayDescriptions[this.recomendationIndex];
        this.randomRecomendationLink = arrayLinks[this.recomendationIndex];
        this.recomendationTitleView.setText(randomTitle);
        this.recomendationDescriptionView.setText(randomDescription);
        return view;
    }

    @OnClick({2131296604})
    public void onRecomendationClick() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.randomRecomendationLink)));
    }

    public void onSpeedreadingbookClick() {
        if (Locale.getDefault().getLanguage().equals("ru")) {
            long bookId = getContext().getSharedPreferences("load_book", 0).getLong("book_id", -1);
            if (bookId > -1) {
                int timerModeParam = getActivity().getIntent().getIntExtra(ReaderActivity.TIMER_MODE_PARAM, 0);
                Intent intent = new Intent(getContext(), ReaderActivity.class);
                intent.putExtra(ReaderActivity.BOOK_DESCRIPTION_ID_PARAM, bookId);
                intent.putExtra(ReaderActivity.TIMER_MODE_PARAM, timerModeParam);
                if (timerModeParam == 0) {
                    startActivity(intent);
                } else {
                    startActivityForResult(intent, TrainingActivity.COURSE_REQUEST_CODE);
                }
            }
        }
    }

    @OnClick({2131296692})
    public void onspeedReadingBookClick2() {
        long bookId = getContext().getSharedPreferences("load_book", 0).getLong("book_id", -1);
        if (bookId > -1) {
            IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getContext()).getBookDescriptionDao();
            this.libraryFragmentListener.onLibraryBookOpen(new BookController(bookDescriptionDao, new Fb2Dao(getContext(), bookDescriptionDao), new EpubDao(getContext(), bookDescriptionDao), new TxtDao(getContext(), bookDescriptionDao)).findBookDescription(bookId));
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IMainMenuPresenter) this.presenter).init();
    }

    @OnClick({2131296692})
    public void speedReadingBookClick() {
    }

    public void setPassCourseView(int score, int bestScore, PassCourseRatingState ratingState, int completedPart, int uncompletedPart) {
        String scoreText = getString(R.string.pass_course_rating_score, Integer.valueOf(completedPart), Integer.valueOf(uncompletedPart + completedPart));
        this.profileTitleTV.setText(ratingState.getTitleRes());
        PassCourseRatingState nextRang = PassCourseRatingState.EXPERT;
        PassCourseRatingState[] rangs = PassCourseRatingState.values();
        if (ratingState.getUncompletedPart() != 0) {
            for (int i = 0; i < rangs.length; i++) {
                if (rangs[i].getCompletedPart() == ratingState.getCompletedPart()) {
                    nextRang = rangs[i + 1];
                }
            }
            int pointsLeft = getScoreByState(nextRang) - completedPart;
            this.pointsLeftTV.setText(getString(R.string.course_need_points, Integer.valueOf(pointsLeft), getString(nextRang.getTitleRes())));
        } else {
            this.pointsLeftTV.setText(getString(R.string.course_max_points));
        }
        int startIndex = scoreText.indexOf(47) + 1;
        int endIndex = scoreText.length();
        this.scoreTextView.setText(scoreText);
        this.focusAttentionPB.setMax(uncompletedPart + completedPart);
        this.focusAttentionPB.setProgress(completedPart);
        new SpannableString(scoreText).setSpan(new ForegroundColorSpan(this.colorAccent), startIndex, endIndex, 33);
    }

    private int getScoreByState(PassCourseRatingState state) {
        switch (state) {
            case GENIUS:
                return 1000;
            case PROFESSOR:
                return 900;
            case GURU:
                return 750;
            case MASTER:
                return 650;
            case EXPERT:
                return 500;
            case LEARNER:
                return AbsAnimation.DEFAULT_ANIMATION_TIME;
            default:
                return 0;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.passCourseRealmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrainingFragmentListener) {
            this.trainingMenuFragmentListener = (TrainingFragmentListener) context;
            if (context instanceof MenuFragmentListener) {
                this.menuFragmentListener = (MenuFragmentListener) context;
                if (context instanceof LibraryFragmentListener) {
                    this.libraryFragmentListener = (LibraryFragmentListener) context;
                    return;
                }
                throw new RuntimeException(context.toString() + " must implement LibraryFragmentListener");
            }
            throw new RuntimeException(context.toString() + " must implement MenuFragmentListener");
        }
        throw new RuntimeException(context.toString() + " must implement TrainingFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingMenuFragmentListener = null;
        this.menuFragmentListener = null;
        this.libraryFragmentListener = null;
    }

    @OnClick({2131296487})
    public void onStartPassCourseClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.pass_descr_title);
        builder.setMessage((int) R.string.pass_descr);
        builder.setPositiveButton((int) R.string.pass_descr_start, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainMenuFragment.this.trainingMenuFragmentListener.requestToStartTraining(TrainingType.PASS_COURSE);
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

    @OnClick({2131296489})
    public void onRandomTrainerClick() {
        this.trainingMenuFragmentListener.requestToStartTraining(TrainingType.randomTraining());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1002 || resultCode == -1) {
        }
    }
}
