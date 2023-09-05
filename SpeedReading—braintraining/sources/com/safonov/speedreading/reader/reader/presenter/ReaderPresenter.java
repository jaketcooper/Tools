package com.safonov.speedreading.reader.reader.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Spanned;
import android.text.TextPaint;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.BookUtil;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.application.util.timeticker.TimeDownTicker;
import com.safonov.speedreading.reader.reader.async.BookContentLoaderAsyncTask;
import com.safonov.speedreading.reader.reader.async.BookContentLoaderAsyncTaskListener;
import com.safonov.speedreading.reader.reader.async.BookSeparatorAsyncTask;
import com.safonov.speedreading.reader.reader.async.BookSeparatorAsyncTaskListener;
import com.safonov.speedreading.reader.reader.model.TimerModeModel;
import com.safonov.speedreading.reader.reader.util.BookProgressUtil;
import com.safonov.speedreading.reader.reader.util.TimerModeUtil;
import com.safonov.speedreading.reader.reader.util2.PageSplitter;
import com.safonov.speedreading.reader.reader.util2.PencilFramePageSelector;
import com.safonov.speedreading.reader.reader.util2.SplittedBook;
import com.safonov.speedreading.reader.reader.util2.WordSelector;
import com.safonov.speedreading.reader.reader.view.IReaderView;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.training.util.course.ReaderTimerModeSaveUtil;
import com.safonov.speedreading.training.util.course.TimerModeSave;
import java.util.Locale;

public class ReaderPresenter extends MvpBasePresenter<IReaderView> implements IReaderPresenter {
    private static final int DEFAULT_PAGE_CHANGE_DELAY = 200;
    private static final int MAX_PREMIUM_SPEED = 3000;
    private static final int MAX_SPEED = 550;
    private static final int MIN_SPEED = 100;
    private static final int PENCIL_FRAME_SELECTED_LINE_COUNT_MAX = 10;
    private static final int PENCIL_FRAME_SELECTED_LINE_COUNT_MIN = 1;
    private static final int SPEED_STEP = 50;
    /* access modifiers changed from: private */
    public BookContent bookContent;
    private IBookController bookController;
    /* access modifiers changed from: private */
    public BookDescription bookDescription;
    private BookUtil bookUtil = App.get().getBookUtil();
    /* access modifiers changed from: private */
    public boolean fastReadingPaused = true;
    private Runnable fastReadingThread = new Runnable() {
        public void run() {
            if (!ReaderPresenter.this.fastReadingPaused) {
                if (ReaderPresenter.this.fastReadingWordSelector == null) {
                    WordSelector unused = ReaderPresenter.this.fastReadingWordSelector = new WordSelector(ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex));
                }
                Spanned worldSelectorPage = ReaderPresenter.this.fastReadingWordSelector.getPageWithNextSelectedWord();
                if (worldSelectorPage != null) {
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setText(worldSelectorPage);
                    }
                    ReaderPresenter.this.handler.postDelayed(this, (long) (60000 / ReaderPresenter.this.speed));
                } else if (ReaderPresenter.this.isViewAttached()) {
                    if (ReaderPresenter.this.updateSpeedReadingBookView() && ReaderPresenter.this.pageIndex < ReaderPresenter.this.pageCount - 1) {
                        ReaderPresenter.access$408(ReaderPresenter.this);
                        ((IReaderView) ReaderPresenter.this.getView()).setPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationSeekBar(ReaderPresenter.this.pageIndex);
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                    }
                    WordSelector unused2 = ReaderPresenter.this.fastReadingWordSelector = null;
                    ReaderPresenter.this.handler.postDelayed(this, 200);
                } else {
                    boolean unused3 = ReaderPresenter.this.fastReadingPaused = false;
                    WordSelector unused4 = ReaderPresenter.this.fastReadingWordSelector = null;
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public WordSelector fastReadingWordSelector;
    /* access modifiers changed from: private */
    public int flashModeCurrentTime;
    private Runnable flashReadingThread = new Runnable() {
        private static final int FLASH_MODE_PROGRESS_DELAY = 100;
        private CharSequence currentPage;
        private int flashModeCurrentPageDelay;

        private int getFlashModeReadingDelay(CharSequence page, int speed) {
            return (60000 / speed) * page.toString().split("[\\s']").length;
        }

        public void run() {
            if (!ReaderPresenter.this.fastReadingPaused) {
                if (ReaderPresenter.this.speedHasChanged) {
                    if (this.currentPage == null) {
                        this.currentPage = ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex);
                    }
                    int oldDelay = this.flashModeCurrentPageDelay;
                    int remainder = oldDelay - ReaderPresenter.this.flashModeCurrentTime;
                    this.flashModeCurrentPageDelay = (oldDelay - remainder) + ((int) (((float) getFlashModeReadingDelay(this.currentPage, ReaderPresenter.this.speed)) * (((float) remainder) / ((float) oldDelay))));
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).initProgressViewProgress(this.flashModeCurrentPageDelay);
                    }
                    boolean unused = ReaderPresenter.this.speedHasChanged = false;
                }
                if (ReaderPresenter.this.flashModeCurrentTime == 0) {
                    this.currentPage = ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex);
                    this.flashModeCurrentPageDelay = getFlashModeReadingDelay(this.currentPage, ReaderPresenter.this.speed);
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setText(this.currentPage);
                        ((IReaderView) ReaderPresenter.this.getView()).setPrimaryTextColor();
                        ((IReaderView) ReaderPresenter.this.getView()).initProgressViewProgress(this.flashModeCurrentPageDelay);
                    }
                } else if (ReaderPresenter.this.flashModeCurrentTime > this.flashModeCurrentPageDelay - (this.flashModeCurrentPageDelay / 10) && ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).setSecondaryTextColor();
                }
                int unused2 = ReaderPresenter.this.flashModeCurrentTime = ReaderPresenter.this.flashModeCurrentTime + 100;
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).setProgressViewProgress(ReaderPresenter.this.flashModeCurrentTime);
                }
                if (ReaderPresenter.this.flashModeCurrentTime >= this.flashModeCurrentPageDelay) {
                    int unused3 = ReaderPresenter.this.flashModeCurrentTime = 0;
                    if (ReaderPresenter.this.isViewAttached()) {
                        if (ReaderPresenter.this.updateSpeedReadingBookView() && ReaderPresenter.this.pageIndex < ReaderPresenter.this.pageCount - 1) {
                            ReaderPresenter.access$408(ReaderPresenter.this);
                            ((IReaderView) ReaderPresenter.this.getView()).setPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationSeekBar(ReaderPresenter.this.pageIndex);
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                        }
                        ReaderPresenter.this.handler.post(this);
                        return;
                    }
                    boolean unused4 = ReaderPresenter.this.fastReadingPaused = true;
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setPrimaryTextColor();
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                        return;
                    }
                    return;
                }
                ReaderPresenter.this.handler.postDelayed(this, 100);
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isFirstLaunch = true;
    private boolean navigationViewShowing;
    /* access modifiers changed from: private */
    public int pageCount;
    /* access modifiers changed from: private */
    public int pageIndex;
    /* access modifiers changed from: private */
    public int pageWidth;
    int pencilFrameLineIndex;
    /* access modifiers changed from: private */
    public PencilFramePageSelector pencilFramePageSelector;
    private Runnable pencilFrameReadingThread = new Runnable() {
        public void run() {
            if (!ReaderPresenter.this.fastReadingPaused) {
                if (ReaderPresenter.this.pencilFramePageSelector == null) {
                    PencilFramePageSelector unused = ReaderPresenter.this.pencilFramePageSelector = new PencilFramePageSelector(ReaderPresenter.this.textPaint, ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex), ReaderPresenter.this.pageWidth);
                }
                PencilFramePageSelector.PencilFrameDataSet dataSet = ReaderPresenter.this.pencilFramePageSelector.getFrameCoordinates(ReaderPresenter.this.pencilFrameLineIndex, ReaderPresenter.this.pencilFrameSelectedLineCount);
                if (dataSet == null) {
                    ReaderPresenter.this.pencilFrameLineIndex = 0;
                    PencilFramePageSelector unused2 = ReaderPresenter.this.pencilFramePageSelector = null;
                    if (ReaderPresenter.this.isViewAttached()) {
                        if (ReaderPresenter.this.updateSpeedReadingBookView() && ReaderPresenter.this.pageIndex < ReaderPresenter.this.pageCount - 1) {
                            ReaderPresenter.access$408(ReaderPresenter.this);
                            ((IReaderView) ReaderPresenter.this.getView()).setPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationSeekBar(ReaderPresenter.this.pageIndex);
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                            ((IReaderView) ReaderPresenter.this.getView()).setNavigationPageView(ReaderPresenter.this.pageIndex + 1, ReaderPresenter.this.pageCount);
                            ((IReaderView) ReaderPresenter.this.getView()).setText(ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex));
                        }
                        ReaderPresenter.this.handler.post(this);
                        return;
                    }
                    boolean unused3 = ReaderPresenter.this.fastReadingPaused = false;
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setNavigationChapterView(ReaderPresenter.this.splittedBook.getTitle(ReaderPresenter.this.pageIndex));
                        return;
                    }
                    return;
                }
                ReaderPresenter.this.pencilFrameLineIndex += ReaderPresenter.this.pencilFrameSelectedLineCount;
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).setPencilFrameView(dataSet.getFrameTopY(), dataSet.getFrameBottomY());
                }
                ReaderPresenter.this.handler.postDelayed(this, (long) ((60000 * dataSet.getWordCount()) / ReaderPresenter.this.speed));
            }
        }
    };
    int pencilFrameSelectedLineCount;
    /* access modifiers changed from: private */
    public ReaderPreferenceUtil preferenceUtil;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private int previousAdsPage = 0;
    private ReaderTimerModeSaveUtil readerTimerModeSaveUtil;
    private int readingMode;
    /* access modifiers changed from: private */
    public int speed;
    /* access modifiers changed from: private */
    public boolean speedHasChanged;
    private long speedReadingBookId;
    /* access modifiers changed from: private */
    public SplittedBook splittedBook;
    /* access modifiers changed from: private */
    public TextPaint textPaint;
    /* access modifiers changed from: private */
    public int timerMode;
    /* access modifiers changed from: private */
    public int timerModeIndex;
    /* access modifiers changed from: private */
    public TimerModeModel[] timerModeModels;
    /* access modifiers changed from: private */
    public long timerRemindingTime;
    private TimeDownTicker timerTicker;

    static /* synthetic */ int access$208(ReaderPresenter x0) {
        int i = x0.timerModeIndex;
        x0.timerModeIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(ReaderPresenter x0) {
        int i = x0.timerModeIndex;
        x0.timerModeIndex = i - 1;
        return i;
    }

    static /* synthetic */ int access$408(ReaderPresenter x0) {
        int i = x0.pageIndex;
        x0.pageIndex = i + 1;
        return i;
    }

    public ReaderPresenter(@NonNull IBookController bookController2, @NonNull ReaderPreferenceUtil readerPreferenceUtil, @NonNull ReaderTimerModeSaveUtil readerTimerModeSaveUtil2, long speedReadingBookId2) {
        this.bookController = bookController2;
        this.preferenceUtil = readerPreferenceUtil;
        this.readerTimerModeSaveUtil = readerTimerModeSaveUtil2;
        this.speedReadingBookId = speedReadingBookId2;
    }

    public void init(int selectedTimerMode, long bookDescriptionId) {
        this.timerMode = selectedTimerMode;
        if (this.timerMode == 0) {
            this.readingMode = 0;
        } else {
            if (isViewAttached()) {
                ((IReaderView) getView()).setTimerViewVisibility(true);
            }
            this.timerModeIndex = 0;
            this.timerModeModels = TimerModeUtil.getTimerModeModels(this.timerMode);
            TimerModeSave save = this.readerTimerModeSaveUtil.load(this.timerMode);
            if (save != null) {
                for (int i = 0; i < save.remainingTimes.length; i++) {
                    this.timerModeModels[i].setRemainingTime(save.remainingTimes[i]);
                    if (!this.timerModeModels[i].isCompleted()) {
                        break;
                    }
                    this.timerModeIndex++;
                }
            }
            this.timerRemindingTime = this.timerModeModels[this.timerModeIndex].getRemainingTime();
            this.timerTicker = new TimeDownTicker();
            this.timerTicker.setTickerListener(new TimeDownTicker.TickerListener() {
                public void onStart() {
                }

                public void onTick(long playedTime) {
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).setTimerView(playedTime);
                    }
                }

                public void onEnd() {
                    boolean unused = ReaderPresenter.this.fastReadingPaused = true;
                    ReaderPresenter.this.timerModeModels[ReaderPresenter.this.timerModeIndex].setRemainingTime(0);
                    ReaderPresenter.access$208(ReaderPresenter.this);
                    if (ReaderPresenter.this.timerModeIndex < ReaderPresenter.this.timerModeModels.length) {
                        long unused2 = ReaderPresenter.this.timerRemindingTime = ReaderPresenter.this.timerModeModels[ReaderPresenter.this.timerModeIndex].getRemainingTime();
                        if (ReaderPresenter.this.isViewAttached()) {
                            ((IReaderView) ReaderPresenter.this.getView()).setText(ReaderPresenter.this.splittedBook.getPage(ReaderPresenter.this.pageIndex));
                            ((IReaderView) ReaderPresenter.this.getView()).showTimerModeDialog(ReaderPresenter.this.timerModeModels);
                            return;
                        }
                        return;
                    }
                    ReaderPresenter.access$210(ReaderPresenter.this);
                    if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).showTimerModeCompletedDialog(ReaderPresenter.this.timerModeModels);
                    }
                }
            });
        }
        this.speed = this.preferenceUtil.getSpeed();
        this.pencilFrameSelectedLineCount = this.preferenceUtil.getPencilSelectedLineCount();
        this.bookDescription = this.bookController.findBookDescription(bookDescriptionId);
        if (isViewAttached()) {
            ((IReaderView) getView()).setActionBarTitle(this.bookDescription.getTitle());
        }
        new BookContentLoaderAsyncTask(this.bookController, new BookContentLoaderAsyncTaskListener() {
            public void onBookContentLoaderPreExecute() {
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).showProgressDialog();
                }
            }

            public void onBookContentLoaderExecuteSuccess(BookContent content) {
                BookContent unused = ReaderPresenter.this.bookContent = content;
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).dismissProgressDialog();
                    ((IReaderView) ReaderPresenter.this.getView()).onRequestToGetTextViewData();
                }
            }

            public void onBookContentLoaderExecuteError() {
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).dismissProgressDialog();
                    ((IReaderView) ReaderPresenter.this.getView()).showErrorMessage();
                    ((IReaderView) ReaderPresenter.this.getView()).finish();
                }
            }
        }).execute(new BookDescription[]{this.bookDescription});
    }

    public void requestToSplitBook(@NonNull TextPaint textPaint2, int pageWidth2, int pageHeight) {
        this.textPaint = textPaint2;
        this.pageWidth = pageWidth2;
        new BookSeparatorAsyncTask(new PageSplitter(textPaint2, pageWidth2, pageHeight), new BookSeparatorAsyncTaskListener() {
            public void onPreBookSeparate() {
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).showProgressDialog();
                }
            }

            public void onPostBookSeparate(SplittedBook book) {
                boolean z;
                SplittedBook unused = ReaderPresenter.this.splittedBook = book;
                int unused2 = ReaderPresenter.this.pageIndex = BookProgressUtil.getPageIndex(ReaderPresenter.this.splittedBook, ReaderPresenter.this.bookDescription.getBookOffset());
                int unused3 = ReaderPresenter.this.pageCount = ReaderPresenter.this.splittedBook.getPageCount();
                int unused4 = ReaderPresenter.this.flashModeCurrentTime = 0;
                WordSelector unused5 = ReaderPresenter.this.fastReadingWordSelector = null;
                PencilFramePageSelector unused6 = ReaderPresenter.this.pencilFramePageSelector = null;
                if (ReaderPresenter.this.isFirstLaunch) {
                    if (ReaderPresenter.this.preferenceUtil.shouldShowGuideDialog()) {
                        if (ReaderPresenter.this.isViewAttached()) {
                            ((IReaderView) ReaderPresenter.this.getView()).showGuideDialog();
                        }
                    } else if (ReaderPresenter.this.timerMode == 0) {
                        if (ReaderPresenter.this.isViewAttached()) {
                            ((IReaderView) ReaderPresenter.this.getView()).showSelectReadingModeDialog(0);
                        }
                    } else if (ReaderPresenter.this.isViewAttached()) {
                        ((IReaderView) ReaderPresenter.this.getView()).showTimerModeDialog(ReaderPresenter.this.timerModeModels);
                    }
                    boolean unused7 = ReaderPresenter.this.isFirstLaunch = false;
                }
                if (ReaderPresenter.this.isViewAttached()) {
                    ((IReaderView) ReaderPresenter.this.getView()).dismissProgressDialog();
                    IReaderView iReaderView = (IReaderView) ReaderPresenter.this.getView();
                    if (ReaderPresenter.this.timerMode == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iReaderView.setActionBarSelectReadingModeVisibility(z);
                    ((IReaderView) ReaderPresenter.this.getView()).hideActionBar();
                    ((IReaderView) ReaderPresenter.this.getView()).initNavigationSeekBar(ReaderPresenter.this.pageCount - 1);
                    ((IReaderView) ReaderPresenter.this.getView()).seNavigationViewVisibility(false);
                }
                ReaderPresenter.this.updateViewsOnPageChange();
            }
        }).execute(new BookContent[]{this.bookContent});
    }

    public void onShowReadingModeDialogClick() {
        if (isViewAttached()) {
            ((IReaderView) getView()).showSelectReadingModeDialog(this.readingMode);
        }
    }

    public void onReadingModeSelected(int readingModeIndex) {
        this.readingMode = readingModeIndex;
        switch (readingModeIndex) {
            case 0:
                this.fastReadingWordSelector = null;
                this.fastReadingPaused = true;
                if (isViewAttached()) {
                    ((IReaderView) getView()).setPencilFrameViewVisibility(false);
                    ((IReaderView) getView()).setPrimaryTextColor();
                    ((IReaderView) getView()).setText(this.splittedBook.getPage(this.pageIndex));
                    ((IReaderView) getView()).setSpeedViewVisibility(false);
                    ((IReaderView) getView()).setProgressViewVisibility(false);
                    return;
                }
                return;
            case 1:
                if (isViewAttached()) {
                    ((IReaderView) getView()).setPencilFrameViewVisibility(false);
                    ((IReaderView) getView()).setPrimaryTextColor();
                    ((IReaderView) getView()).setSpeedViewVisibility(true);
                    ((IReaderView) getView()).setSpeedView(this.speed);
                    ((IReaderView) getView()).setProgressViewVisibility(false);
                    return;
                }
                return;
            case 2:
                this.fastReadingWordSelector = null;
                if (isViewAttached()) {
                    ((IReaderView) getView()).setPencilFrameViewVisibility(false);
                    ((IReaderView) getView()).setText(this.splittedBook.getPage(this.pageIndex));
                    ((IReaderView) getView()).setProgressViewVisibility(true);
                    ((IReaderView) getView()).setSpeedView(this.speed);
                    ((IReaderView) getView()).setSpeedViewVisibility(true);
                    return;
                }
                return;
            case 3:
                if (isViewAttached()) {
                    ((IReaderView) getView()).setPencilFrameViewVisibility(true);
                    ((IReaderView) getView()).setPencilFrameLineCountView(this.pencilFrameSelectedLineCount);
                    ((IReaderView) getView()).setPrimaryTextColor();
                    ((IReaderView) getView()).setSpeedViewVisibility(true);
                    ((IReaderView) getView()).setSpeedView(this.speed);
                    ((IReaderView) getView()).setProgressViewVisibility(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onGuideDialogClosed(boolean shouldShowAgain) {
        this.preferenceUtil.setShouldShowGuideDialog(shouldShowAgain);
        if (this.timerMode == 0) {
            if (isViewAttached()) {
                ((IReaderView) getView()).showSelectReadingModeDialog(0);
            }
        } else if ((this.timerMode == 1 || this.timerMode == 2) && isViewAttached()) {
            ((IReaderView) getView()).showTimerModeDialog(this.timerModeModels);
        }
    }

    public void onTimerModeDialogClosed() {
        boolean z;
        boolean z2 = true;
        this.readingMode = this.timerModeModels[this.timerModeIndex].getReadingMode();
        if (this.readingMode != 0) {
            ((IReaderView) getView()).setSpeedView(this.speed);
            ((IReaderView) getView()).setSpeedViewVisibility(true);
        } else {
            ((IReaderView) getView()).setSpeedViewVisibility(false);
        }
        if (isViewAttached()) {
            ((IReaderView) getView()).setTimerView(this.timerModeModels[this.timerModeIndex].getRemainingTime());
            IReaderView iReaderView = (IReaderView) getView();
            if (this.readingMode == 2) {
                z = true;
            } else {
                z = false;
            }
            iReaderView.setProgressViewVisibility(z);
            IReaderView iReaderView2 = (IReaderView) getView();
            if (this.readingMode != 3) {
                z2 = false;
            }
            iReaderView2.setPencilFrameViewVisibility(z2);
        }
    }

    public void onTimerModeCompletedDialogClosed() {
        if (isViewAttached()) {
            ((IReaderView) getView()).setCourseActivityResult(true);
            ((IReaderView) getView()).finish();
        }
    }

    public void onPageViewLeftClick() {
        if (this.readingMode != 0) {
            this.speed -= 50;
            if (this.speed < 100) {
                this.speed = 100;
            }
            this.speedHasChanged = true;
            if (isViewAttached()) {
                ((IReaderView) getView()).setSpeedView(this.speed);
            }
        } else if (this.pageIndex > 0) {
            this.pageIndex--;
            updateViewsOnPageChange();
        }
    }

    public void onPageViewRightClick() {
        if (this.readingMode != 0) {
            this.speed += 50;
            if (this.premiumUtil.isPremiumUser()) {
                if (this.speed > 3000) {
                    this.speed = 3000;
                }
            } else if (this.speed > MAX_SPEED) {
                this.speed = MAX_SPEED;
                this.fastReadingPaused = true;
                if (isViewAttached()) {
                    ((IReaderView) getView()).showPurchasePremiumDialog();
                }
            }
            this.speedHasChanged = true;
            if (isViewAttached()) {
                ((IReaderView) getView()).setSpeedView(this.speed);
            }
        } else if (this.pageIndex < this.pageCount - 1 && updateSpeedReadingBookView()) {
            this.pageIndex++;
            updateViewsOnPageChange();
        }
    }

    public void onPageViewCenterClick(boolean isDoubleClick) {
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        if (this.readingMode == 0) {
            if (isDoubleClick && isViewAttached()) {
                if (this.navigationViewShowing) {
                    ((IReaderView) getView()).hideActionBar();
                    ((IReaderView) getView()).seNavigationViewVisibility(false);
                    if (this.timerMode == 1 || this.timerMode == 2) {
                        this.timerTicker.start(this.timerRemindingTime);
                    }
                } else {
                    ((IReaderView) getView()).showActionBar();
                    ((IReaderView) getView()).seNavigationViewVisibility(true);
                    if (this.timerMode == 1 || this.timerMode == 2) {
                        this.timerRemindingTime = this.timerTicker.cancel();
                    }
                }
                if (!this.navigationViewShowing) {
                    z = true;
                } else {
                    z = false;
                }
                this.navigationViewShowing = z;
            }
        } else if (isDoubleClick) {
            if (!this.fastReadingPaused) {
                if (this.timerMode == 1 || this.timerMode == 2) {
                    this.timerRemindingTime = this.timerTicker.cancel();
                }
                this.fastReadingPaused = true;
            }
            if (this.navigationViewShowing) {
                if (isViewAttached()) {
                    ((IReaderView) getView()).hideActionBar();
                    ((IReaderView) getView()).seNavigationViewVisibility(false);
                }
            } else if (isViewAttached()) {
                ((IReaderView) getView()).showActionBar();
                ((IReaderView) getView()).seNavigationViewVisibility(true);
            }
            if (this.navigationViewShowing) {
                z3 = false;
            }
            this.navigationViewShowing = z3;
        } else if (!this.navigationViewShowing) {
            if (!this.fastReadingPaused) {
                z2 = true;
            }
            this.fastReadingPaused = z2;
            if (!this.fastReadingPaused) {
                if (this.readingMode == 1) {
                    this.handler.post(this.fastReadingThread);
                } else if (this.readingMode == 2) {
                    this.handler.post(this.flashReadingThread);
                } else if (this.readingMode == 3) {
                    this.handler.post(this.pencilFrameReadingThread);
                }
                if (this.timerMode == 1 || this.timerMode == 2) {
                    this.timerTicker.start(this.timerRemindingTime);
                }
            } else if (this.timerMode == 1 || this.timerMode == 2) {
                this.timerRemindingTime = this.timerTicker.cancel();
            }
        }
    }

    public void onNavigationNextPageViewClick() {
        if (this.pageIndex < this.pageCount - 1 && updateSpeedReadingBookView()) {
            this.pageIndex++;
            this.flashModeCurrentTime = 0;
            this.fastReadingWordSelector = null;
            updateViewsOnPageChange();
        }
    }

    public void onNavigationPreviousPageViewClick() {
        if (this.pageIndex > 0) {
            this.pageIndex--;
            this.flashModeCurrentTime = 0;
            this.fastReadingWordSelector = null;
            updateViewsOnPageChange();
        }
    }

    public void onNavigationSeekBarPageChanged(int pageIndex2) {
        this.pageIndex = pageIndex2;
        if (isViewAttached()) {
            ((IReaderView) getView()).setNavigationChapterView(this.splittedBook.getTitle(pageIndex2));
            ((IReaderView) getView()).setNavigationPageView(pageIndex2 + 1, this.pageCount);
        }
    }

    public void onNavigationSeekBarPageSelected() {
        this.flashModeCurrentTime = 0;
        this.fastReadingWordSelector = null;
        this.pencilFramePageSelector = null;
        this.pencilFrameLineIndex = 0;
        if (isViewAttached() && updateSpeedReadingBookView()) {
            ((IReaderView) getView()).setPageView(this.pageIndex + 1, this.pageCount);
            ((IReaderView) getView()).setPrimaryTextColor();
            ((IReaderView) getView()).setText(this.splittedBook.getPage(this.pageIndex));
        }
    }

    public void onNavigationChapterViewClick() {
        if (isViewAttached()) {
            String[] items = new String[this.splittedBook.getTitles().size()];
            ((IReaderView) getView()).showSelectChapterDialog((String[]) this.splittedBook.getTitles().toArray(items));
        }
    }

    public void onNavigationChapterSelected(int chapterIndex) {
        this.flashModeCurrentTime = 0;
        this.fastReadingWordSelector = null;
        this.pencilFramePageSelector = null;
        this.pencilFrameLineIndex = 0;
        this.pageIndex = this.splittedBook.getPageIndexByTitle(chapterIndex);
        if (updateSpeedReadingBookView()) {
            updateViewsOnPageChange();
        }
    }

    public void onNavigationPageViewClick() {
        if (isViewAttached() && updateSpeedReadingBookView()) {
            ((IReaderView) getView()).showSelectPageDialog(this.pageIndex + 1, this.pageCount);
        }
    }

    public void onNavigationPageSelected(int pageIndex2) {
        this.fastReadingWordSelector = null;
        this.pencilFramePageSelector = null;
        this.pencilFrameLineIndex = 0;
        this.pageIndex = pageIndex2;
        if (updateSpeedReadingBookView()) {
            updateViewsOnPageChange();
        }
    }

    public void onPencilFrameMinusClick() {
        this.pencilFrameSelectedLineCount--;
        if (this.pencilFrameSelectedLineCount < 1) {
            this.pencilFrameSelectedLineCount = 1;
        }
        if (isViewAttached()) {
            ((IReaderView) getView()).setPencilFrameLineCountView(this.pencilFrameSelectedLineCount);
        }
    }

    public void onPencilFramePlusClick() {
        this.pencilFrameSelectedLineCount++;
        if (this.pencilFrameSelectedLineCount > 10) {
            this.pencilFrameSelectedLineCount = 10;
        }
        if (isViewAttached()) {
            ((IReaderView) getView()).setPencilFrameLineCountView(this.pencilFrameSelectedLineCount);
        }
    }

    /* access modifiers changed from: private */
    public boolean updateSpeedReadingBookView() {
        if (!isViewAttached() || this.speedReadingBookId != this.bookDescription.getId() || BookProgressUtil.getProgress(this.pageIndex, this.pageCount) <= 30 || this.bookUtil.isBookPurchased() || !Locale.getDefault().getLanguage().equals("ru")) {
            return true;
        }
        ((IReaderView) getView()).setBookPurchaseActivity();
        this.pageIndex = BookProgressUtil.getPageFromProgress(30, this.pageCount);
        return false;
    }

    /* access modifiers changed from: private */
    public void updateViewsOnPageChange() {
        if (isViewAttached()) {
            ((IReaderView) getView()).setPrimaryTextColor();
            ((IReaderView) getView()).setText(this.splittedBook.getPage(this.pageIndex));
            ((IReaderView) getView()).setPageView(this.pageIndex + 1, this.pageCount);
            ((IReaderView) getView()).setNavigationSeekBar(this.pageIndex);
            ((IReaderView) getView()).setNavigationChapterView(this.splittedBook.getTitle(this.pageIndex));
            ((IReaderView) getView()).setNavigationPageView(this.pageIndex + 1, this.pageCount);
        }
    }

    public void onPause() {
        this.fastReadingPaused = true;
        if (this.timerMode == 1 || this.timerMode == 2) {
            this.timerRemindingTime = this.timerTicker.cancel();
        }
    }

    public void onStop() {
        this.preferenceUtil.setSpeed(this.speed);
        this.preferenceUtil.setPencilSelectedLineCount(this.pencilFrameSelectedLineCount);
        if (this.timerMode == 1 || this.timerMode == 2) {
            if (this.timerRemindingTime != 0) {
                this.timerModeModels[this.timerModeIndex].setRemainingTime(this.timerRemindingTime);
            }
            long[] remainingTimes = new long[this.timerModeModels.length];
            for (int i = 0; i < this.timerModeModels.length; i++) {
                remainingTimes[i] = this.timerModeModels[i].getRemainingTime();
            }
            this.readerTimerModeSaveUtil.save(this.timerMode, remainingTimes);
        }
        this.bookDescription.setProgress(BookProgressUtil.getProgress(this.pageIndex, this.pageCount));
        this.bookDescription.setBookOffset(BookProgressUtil.getBookOffset(this.splittedBook, this.pageIndex));
        this.bookController.updateBookDescription(this.bookDescription);
    }

    public void onResume() {
    }

    public void onBackPressed() {
        this.fastReadingPaused = true;
        if (isViewAttached()) {
            ((IReaderView) getView()).showExitDialog();
        }
    }
}
