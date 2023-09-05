package com.safonov.speedreading.reader.reader.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentPagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.widget.AppCompatCheckBox;
import android.support.p003v7.widget.AppCompatSeekBar;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.android.gms.ads.InterstitialAd;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.safonov.speedreading.purchase.view.PurchaseActivity;
import com.safonov.speedreading.purchase.view.PurchaseBookActivity;
import com.safonov.speedreading.reader.reader.model.TimerModeModel;
import com.safonov.speedreading.reader.reader.presenter.IReaderPresenter;
import com.safonov.speedreading.reader.reader.presenter.ReaderPreferenceUtil;
import com.safonov.speedreading.reader.reader.presenter.ReaderPresenter;
import com.safonov.speedreading.reader.reader.settings.ReaderSettingsActivity;
import com.safonov.speedreading.reader.repository.BookController;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.Fb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.TxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.safonov.speedreading.training.util.course.ReaderTimerModeSaveUtil;
import com.speedreading.alexander.speedreading.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReaderActivity extends MvpActivity<IReaderView, IReaderPresenter> implements IReaderView {
    public static final String BOOK_DESCRIPTION_ID_PARAM = "book_description_id";
    public static final String BOOK_ID = "book_id";
    public static final String LOAD_BOOK = "load_book";
    private static final int PURCHASE_REQUEST_CODE = 1002;
    public static final int READING_MODE_DEFAULT = 0;
    public static final int READING_MODE_FAST = 1;
    public static final int READING_MODE_FLASH = 2;
    public static final int READING_MODE_PENCIL_FRAME = 3;
    private static final int SETTINGS_REQUEST_CODE = 101;
    public static final String SHOULD_LOAD_BOOK = "should_load_book";
    public static final int TIMER_MODE_ACCELERATOR_COURSE = 2;
    public static final int TIMER_MODE_NONE = 0;
    public static final String TIMER_MODE_PARAM = "timer_mode";
    public static final int TIMER_MODE_PASS_COURSE = 1;
    @BindColor(17170435)
    int blackColor;
    @BindView(2131296359)
    TextView contentTextView;
    @BindView(2131296564)
    View frameLayout;
    @BindView(2131296565)
    View frameView;
    /* access modifiers changed from: private */
    public GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDown(MotionEvent e) {
            int x = (int) e.getX();
            int pageWidth = ReaderActivity.this.contentTextView.getWidth();
            int thirdPartOfPageWidth = pageWidth / 3;
            if (x < thirdPartOfPageWidth) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onPageViewLeftClick();
                return false;
            } else if (thirdPartOfPageWidth > x || x > pageWidth - thirdPartOfPageWidth) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onPageViewRightClick();
                return false;
            } else {
                ((IReaderPresenter) ReaderActivity.this.presenter).onPageViewCenterClick(false);
                return true;
            }
        }

        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            ((IReaderPresenter) ReaderActivity.this.presenter).onPageViewCenterClick(true);
            return false;
        }
    };
    @BindColor(17170437)
    int greyColor;
    protected InterstitialAd interstitialAd;
    @BindView(2131296533)
    TextView lineCountTextView;
    private Menu menu;
    @BindView(2131296526)
    TextView navigationChapterTitleTextView;
    @BindView(2131296529)
    TextView navigationPageTextView;
    @BindView(2131296535)
    AppCompatSeekBar navigationSeekBar;
    @BindView(2131296536)
    View navigationView;
    @BindView(2131296552)
    TextView pageTextView;
    @BindView(2131296530)
    View pencilFrameLayout;
    @BindView(2131296590)
    ProgressBar progressBar;
    private ProgressDialog progressDialog;
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onNavigationSeekBarPageChanged(progress);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ((IReaderPresenter) ReaderActivity.this.presenter).onNavigationSeekBarPageSelected();
        }
    };
    SharedPreferences sharedPreferences;
    @BindView(2131296711)
    TextView speedTextView;
    private String textSize;
    @BindView(2131296775)
    TextView timeTextView;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    @NonNull
    public IReaderPresenter createPresenter() {
        IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(this).getBookDescriptionDao();
        ReaderPreferenceUtil readerPreferenceUtil = new ReaderPreferenceUtil(this);
        ReaderTimerModeSaveUtil readerTimerModeSaveUtil = new ReaderTimerModeSaveUtil(this);
        Fb2Dao fb2Dao = new Fb2Dao(this, bookDescriptionDao);
        EpubDao epubDao = new EpubDao(this, bookDescriptionDao);
        TxtDao txtDao = new TxtDao(this, bookDescriptionDao);
        this.sharedPreferences = getSharedPreferences("load_book", 0);
        return new ReaderPresenter(new BookController(bookDescriptionDao, fb2Dao, epubDao, txtDao), readerPreferenceUtil, readerTimerModeSaveUtil, this.sharedPreferences.getLong("book_id", -1));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.reader_activity);
        getWindow().getDecorView().setSystemUiVisibility(1);
        this.textSize = PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.reader_settings_text_size_key), getString(R.string.reader_settings_text_size_default_value));
        this.unbinder = ButterKnife.bind((Activity) this);
        this.gestureDetector = new GestureDetector(this, this.gestureListener);
        this.contentTextView.setTextSize(2, Float.valueOf(this.textSize).floatValue());
        this.contentTextView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return ReaderActivity.this.gestureDetector.onTouchEvent(event);
            }
        });
        this.navigationSeekBar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
        long bookDescriptionId = getIntent().getLongExtra(BOOK_DESCRIPTION_ID_PARAM, 0);
        ((IReaderPresenter) this.presenter).init(getIntent().getIntExtra(TIMER_MODE_PARAM, 0), bookDescriptionId);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.format_list /*2131296412*/:
                ((IReaderPresenter) this.presenter).onShowReadingModeDialogClick();
                return true;
            case R.id.settings /*2131296669*/:
                startActivityForResult(new Intent(this, ReaderSettingsActivity.class), 101);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        getMenuInflater().inflate(R.menu.reader_menu, menu2);
        this.menu = menu2;
        return true;
    }

    public void setActionBarSelectReadingModeVisibility(boolean visible) {
        this.menu.findItem(R.id.format_list).setVisible(visible);
    }

    public void onBackPressed() {
        ((IReaderPresenter) this.presenter).onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ((IReaderPresenter) this.presenter).onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ((IReaderPresenter) this.presenter).onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((IReaderPresenter) this.presenter).onResume();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle((CharSequence) title);
    }

    public void hideActionBar() {
        getSupportActionBar().hide();
    }

    public void showActionBar() {
        getSupportActionBar().show();
    }

    public void setPencilFrameViewVisibility(boolean visible) {
        int i;
        int i2 = 0;
        View view = this.frameLayout;
        if (visible) {
            i = 0;
        } else {
            i = 4;
        }
        view.setVisibility(i);
        View view2 = this.pencilFrameLayout;
        if (!visible) {
            i2 = 4;
        }
        view2.setVisibility(i2);
    }

    public void setPencilFrameView(int topY, int bottomY) {
        this.frameLayout.setY(((float) topY) + this.contentTextView.getY());
        this.frameView.getLayoutParams().height = bottomY - topY;
        this.frameView.requestLayout();
    }

    public void setPencilFrameLineCountView(int lineCount) {
        this.lineCountTextView.setText(getString(R.string.reader_pencil_frame_selected_line_count, new Object[]{Integer.valueOf(lineCount)}));
    }

    @OnClick({2131296531})
    public void onMib() {
        ((IReaderPresenter) this.presenter).onPencilFrameMinusClick();
    }

    @OnClick({2131296532})
    public void onPlb() {
        ((IReaderPresenter) this.presenter).onPencilFramePlusClick();
    }

    public void setText(CharSequence text) {
        this.contentTextView.setText(text);
    }

    public void setPrimaryTextColor() {
        this.contentTextView.setTextColor(this.blackColor);
    }

    public void setSecondaryTextColor() {
        this.contentTextView.setTextColor(this.greyColor);
    }

    public void setPageView(int currentPage, int maxPage) {
        this.pageTextView.setText(getString(R.string.reader_page, new Object[]{Integer.valueOf(currentPage), Integer.valueOf(maxPage)}));
    }

    public void setSpeedView(int speed) {
        this.speedTextView.setText(getString(R.string.reader_speed, new Object[]{Integer.valueOf(speed)}));
    }

    public void setSpeedViewVisibility(boolean visible) {
        this.speedTextView.setVisibility(visible ? 0 : 4);
    }

    private static class TimeConverterUtil {
        private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());

        private TimeConverterUtil() {
        }

        public static String format(long timeMilliSeconds) {
            return simpleDateFormat.format(new Date(timeMilliSeconds));
        }
    }

    public void setTimerView(long time) {
        this.timeTextView.setText(getString(R.string.reader_timer_mode_time, new Object[]{TimeConverterUtil.format(time)}));
    }

    public void setTimerViewVisibility(boolean visible) {
        this.timeTextView.setVisibility(visible ? 0 : 8);
    }

    public void initProgressViewProgress(int max) {
        this.progressBar.setMax(max);
    }

    public void setProgressViewProgress(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void setProgressViewVisibility(boolean visible) {
        this.progressBar.setVisibility(visible ? 0 : 4);
    }

    public void seNavigationViewVisibility(boolean visible) {
        this.navigationView.setVisibility(visible ? 0 : 4);
    }

    public void initNavigationSeekBar(int max) {
        this.navigationSeekBar.setMax(max);
    }

    public void setNavigationSeekBar(int progress) {
        this.navigationSeekBar.setProgress(progress);
    }

    @OnClick({2131296529})
    public void onNavigationPageViewClick() {
        ((IReaderPresenter) this.presenter).onNavigationPageViewClick();
    }

    public void setNavigationPageView(int currentPage, int maxPage) {
        this.navigationPageTextView.setText(getString(R.string.reader_navigation_page, new Object[]{Integer.valueOf(currentPage), Integer.valueOf(maxPage)}));
    }

    @OnClick({2131296526})
    public void onNavigationChapterClick() {
        ((IReaderPresenter) this.presenter).onNavigationChapterViewClick();
    }

    public void setNavigationChapterView(String chapterTitle) {
        this.navigationChapterTitleTextView.setText(chapterTitle);
    }

    @OnClick({2131296534})
    public void onNavigationPreviousPageClick() {
        ((IReaderPresenter) this.presenter).onNavigationPreviousPageViewClick();
    }

    @OnClick({2131296528})
    public void onNavigationNextPageClick() {
        ((IReaderPresenter) this.presenter).onNavigationNextPageViewClick();
    }

    public void showSelectChapterDialog(String[] items) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((int) R.string.reader_select_chapter_dialog_title);
        builder.setItems((CharSequence[]) items, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onNavigationChapterSelected(i);
            }
        });
        builder.create().show();
    }

    public void showSelectPageDialog(int currentPage, int maxPage) {
        final NumberPicker numberPicker = new NumberPicker(this);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(maxPage);
        numberPicker.setValue(currentPage);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((int) R.string.reader_select_page_dialog_title);
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 66) {
                    return false;
                }
                dialogInterface.dismiss();
                return true;
            }
        });
        builder.setPositiveButton((int) R.string.reader_select_page_dialog_select, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                numberPicker.clearFocus();
                ((IReaderPresenter) ReaderActivity.this.presenter).onNavigationPageSelected(numberPicker.getValue() - 1);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton((int) R.string.reader_select_page_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(numberPicker, new FrameLayout.LayoutParams(-2, -2, 17));
        builder.setView((View) frameLayout2);
        builder.create().show();
    }

    public void showSelectReadingModeDialog(int selectedItemIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((int) R.string.reader_select_reading_mode_dialog_title);
        builder.setSingleChoiceItems((int) R.array.reader_reading_modes_dialog_items, selectedItemIndex, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onReadingModeSelected(i);
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void showPurchasePremiumDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle((int) R.string.reader_purchase_premium_dialog_title);
        builder.setMessage((int) R.string.reader_purchase_premium_dialog_message);
        builder.setNegativeButton((int) R.string.reader_purchase_premium_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((int) R.string.reader_purchase_premium_dialog_purchase, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ReaderActivity.this.startActivity(new Intent(ReaderActivity.this, PurchaseActivity.class));
            }
        });
        builder.create().show();
    }

    public void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle((int) R.string.reader_exit_dialog_title);
        builder.setMessage((int) R.string.reader_exit_dialog_message);
        builder.setNegativeButton((int) R.string.reader_exit_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((int) R.string.reader_exit_dialog_exit, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ReaderActivity.this.finish();
            }
        });
        builder.create().show();
    }

    public void showTimerModeDialog(@NonNull TimerModeModel[] timerModeModels) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle((int) R.string.reader_timer_mode_dialog_title);
        builder.setMessage((int) R.string.reader_timer_mode_dialog_message);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        for (TimerModeModel timerModeModel : timerModeModels) {
            AppCompatCheckBox checkBox = (AppCompatCheckBox) getLayoutInflater().inflate(R.layout.reader_timer_mode_dialog_item, linearLayout, false);
            switch (timerModeModel.getReadingMode()) {
                case 0:
                    checkBox.setText(R.string.reader_guide_dialog_default_reading_title);
                    break;
                case 1:
                    checkBox.setText(R.string.reader_guide_dialog_fast_reading_title);
                    break;
                case 2:
                    checkBox.setText(R.string.reader_guide_dialog_flash_reading_title);
                    break;
                case 3:
                    checkBox.setText(R.string.reader_guide_dialog_pencil_frame_reading_title);
                    break;
            }
            checkBox.setChecked(timerModeModel.isCompleted());
            linearLayout.addView(checkBox);
        }
        builder.setView((View) linearLayout);
        builder.setPositiveButton((int) R.string.reader_timer_mode_dialog_start, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onTimerModeDialogClosed();
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void showTimerModeCompletedDialog(@NonNull TimerModeModel[] timerModeModels) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle((int) R.string.reader_timer_mode_dialog_completed_title);
        builder.setMessage((int) R.string.reader_timer_mode_dialog_completed_message);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        for (TimerModeModel timerModeModel : timerModeModels) {
            AppCompatCheckBox checkBox = (AppCompatCheckBox) getLayoutInflater().inflate(R.layout.reader_timer_mode_dialog_item, linearLayout, false);
            switch (timerModeModel.getReadingMode()) {
                case 0:
                    checkBox.setText(R.string.reader_guide_dialog_default_reading_title);
                    break;
                case 1:
                    checkBox.setText(R.string.reader_guide_dialog_fast_reading_title);
                    break;
                case 2:
                    checkBox.setText(R.string.reader_guide_dialog_flash_reading_title);
                    break;
                case 3:
                    checkBox.setText(R.string.reader_guide_dialog_pencil_frame_reading_title);
                    break;
            }
            checkBox.setChecked(true);
            linearLayout.addView(checkBox);
        }
        builder.setView((View) linearLayout);
        builder.setPositiveButton((int) R.string.reader_timer_mode_dialog_end, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onTimerModeCompletedDialogClosed();
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static class GuideDialogFragment extends DialogFragment {
        private static final int FRAGMENT_COUNT = 4;
        /* access modifiers changed from: private */
        public DismissListener dismissListener;

        interface DismissListener {
            void dismiss(boolean z);
        }

        public void setDismissListener(DismissListener dismissListener2) {
            this.dismissListener = dismissListener2;
        }

        public void onResume() {
            ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
            params.width = -1;
            params.height = -2;
            getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
            super.onResume();
        }

        @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.reader_guide_dialog, (ViewGroup) null);
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
            viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                public Fragment getItem(int position) {
                    switch (position) {
                        case 0:
                            return new ReadingGuideFragment();
                        case 1:
                            return new FastReadingGuideFragment();
                        case 2:
                            return new FlashReadingGuideFragment();
                        case 3:
                            return new PencilFrameReadingGuideFragment();
                        default:
                            return null;
                    }
                }

                public int getCount() {
                    return 4;
                }
            });
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
            tabLayout.setupWithViewPager(viewPager);
            for (int i = 0; i < 4; i++) {
                tabLayout.getTabAt(i).setText((CharSequence) String.valueOf(i + 1));
            }
            final CheckBox dontShowAgainCheckBox = (CheckBox) view.findViewById(R.id.dont_show_again_check_box);
            ((Button) view.findViewById(R.id.close_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GuideDialogFragment.this.dismiss();
                    if (GuideDialogFragment.this.dismissListener != null) {
                        GuideDialogFragment.this.dismissListener.dismiss(!dontShowAgainCheckBox.isChecked());
                    }
                }
            });
            return view;
        }
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    public void setAd() {
    }

    public void setBookPurchaseActivity() {
        startActivityForResult(new Intent(this, PurchaseBookActivity.class), 1002);
    }

    public static class ReadingGuideFragment extends Fragment {
        @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.reader_guide_dialog_default_reading, container, false);
        }
    }

    public static class FastReadingGuideFragment extends Fragment {
        @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.reader_guide_dialog_fast_reading, container, false);
        }
    }

    public static class FlashReadingGuideFragment extends Fragment {
        @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.reader_guide_dialog_flash_reading, container, false);
        }
    }

    public static class PencilFrameReadingGuideFragment extends Fragment {
        @Nullable
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.reader_guide_dialog_pencil_frame_reading, container, false);
        }
    }

    public void showGuideDialog() {
        GuideDialogFragment dialogFragment = new GuideDialogFragment();
        dialogFragment.setDismissListener(new GuideDialogFragment.DismissListener() {
            public void dismiss(boolean shouldShow) {
                ((IReaderPresenter) ReaderActivity.this.presenter).onGuideDialogClosed(shouldShow);
            }
        });
        dialogFragment.show(getSupportFragmentManager(), (String) null);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            this.textSize = data.getStringExtra(getString(R.string.reader_settings_text_size_key));
            this.contentTextView.setTextSize(2, Float.valueOf(this.textSize).floatValue());
            this.contentTextView.post(new Runnable() {
                public void run() {
                    ((IReaderPresenter) ReaderActivity.this.presenter).requestToSplitBook(ReaderActivity.this.contentTextView.getPaint(), (ReaderActivity.this.contentTextView.getWidth() - ReaderActivity.this.contentTextView.getPaddingLeft()) - ReaderActivity.this.contentTextView.getPaddingRight(), (ReaderActivity.this.contentTextView.getHeight() - ReaderActivity.this.contentTextView.getPaddingTop()) - ReaderActivity.this.contentTextView.getPaddingBottom());
                }
            });
        }
        if (requestCode == 1002 && resultCode == -1) {
            ((IReaderPresenter) this.presenter).onPageViewRightClick();
        }
    }

    public void setCourseActivityResult(boolean completed) {
        setResult(completed ? -1 : 0);
    }

    public void showProgressDialog() {
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setTitle(R.string.reader_file_opening);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    public void dismissProgressDialog() {
        this.progressDialog.dismiss();
    }

    public void showErrorMessage() {
        Toast.makeText(this, R.string.reader_file_opening_error, 1).show();
    }

    public void onRequestToGetTextViewData() {
        this.contentTextView.post(new Runnable() {
            public void run() {
                ((IReaderPresenter) ReaderActivity.this.presenter).requestToSplitBook(ReaderActivity.this.contentTextView.getPaint(), (ReaderActivity.this.contentTextView.getWidth() - ReaderActivity.this.contentTextView.getPaddingLeft()) - ReaderActivity.this.contentTextView.getPaddingRight(), (ReaderActivity.this.contentTextView.getHeight() - ReaderActivity.this.contentTextView.getPaddingTop()) - ReaderActivity.this.contentTextView.getPaddingBottom());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
    }
}
