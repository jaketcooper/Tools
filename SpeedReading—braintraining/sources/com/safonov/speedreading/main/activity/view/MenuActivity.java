package com.safonov.speedreading.main.activity.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.notifications.AlarmHandleService;
import com.safonov.speedreading.application.util.BookUtil;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.application.util.ValueAnimatorEnablerUtil;
import com.safonov.speedreading.main.MenuFragmentType;
import com.safonov.speedreading.main.activity.presenter.IMenuPresenter;
import com.safonov.speedreading.main.activity.presenter.MenuPresenter;
import com.safonov.speedreading.main.fragment.acceleratormenu.AcceleratorTrainingMenuFragment;
import com.safonov.speedreading.main.fragment.description.DescriptionFragment;
import com.safonov.speedreading.main.fragment.mainmenu.view.MainMenuFragment;
import com.safonov.speedreading.main.fragment.motivators.view.MotivatorsFragment;
import com.safonov.speedreading.main.fragment.motivatorsmenu.view.MotivatorsMenuFragment;
import com.safonov.speedreading.main.fragment.profile.view.ProfileFragment;
import com.safonov.speedreading.main.fragment.recommendation.view.RecomendationFragment;
import com.safonov.speedreading.main.fragment.rulesofsuccess.view.RulesOfSuccessFragment;
import com.safonov.speedreading.main.fragment.settings.MainSettingsFragment;
import com.safonov.speedreading.main.fragment.trainingmenu.view.TrainingMenuFragment;
import com.safonov.speedreading.purchase.view.PurchaseActivity;
import com.safonov.speedreading.reader.library.activity.view.BackPressedListener;
import com.safonov.speedreading.reader.library.detail.view.BookDetailFragment;
import com.safonov.speedreading.reader.library.fileexplorer.async.BookAddAsyncTaskListener;
import com.safonov.speedreading.reader.library.fileexplorer.view.FileExplorerFragment;
import com.safonov.speedreading.reader.library.fileexplorer.view.FileExplorerFragmentListener;
import com.safonov.speedreading.reader.library.library.view.LibraryFragment;
import com.safonov.speedreading.reader.library.library.view.LibraryFragmentListener;
import com.safonov.speedreading.reader.reader.view.ReaderActivity;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.view.TrainingActivity;
import com.speedreading.alexander.speedreading.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.ActivityCheckout;
import org.solovyev.android.checkout.Checkout;
import org.solovyev.android.checkout.Inventory;
import org.solovyev.android.checkout.ProductTypes;

public class MenuActivity extends MvpActivity<IMenuView, IMenuPresenter> implements IMenuView, SharedPreferences.OnSharedPreferenceChangeListener, LibraryFragmentListener, FileExplorerFragmentListener {
    public static final String BOOK_ID = "book_id";
    public static final String LOAD_BOOK = "load_book";
    private static final int PURCHASE_REQUEST_CODE = 1002;
    public static final String SHOULD_LOAD_BOOK = "should_load_book";
    private IBookController bookController;
    /* access modifiers changed from: private */
    public BookUtil bookUtil = App.get().getBookUtil();
    private ActivityCheckout checkout = Checkout.forActivity(this, App.get().getBilling());
    private Fragment currentFragment;
    String filePath;
    /* access modifiers changed from: private */
    public InterstitialAd interstitialAd = new InterstitialAd(this);
    private BookAddAsyncTaskListener listener;
    private Menu menu;
    @BindView(2131296323)
    BottomNavigationView navigation;
    @BindString(2131624155)
    String notifyKey;
    @BindString(2131624156)
    String notifyTimeKey;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home /*2131296276*/:
                    ((IMenuPresenter) MenuActivity.this.presenter).requestToSetFragment(MenuFragmentType.MAIN_MENU);
                    return true;
                case R.id.action_materials /*2131296278*/:
                    ((IMenuPresenter) MenuActivity.this.presenter).requestToSetFragment(MenuFragmentType.MOTIVATORS_MENU);
                    return true;
                case R.id.action_profile /*2131296284*/:
                    ((IMenuPresenter) MenuActivity.this.presenter).requestToSetFragment(MenuFragmentType.PROFILE);
                    return true;
                case R.id.action_reading /*2131296285*/:
                    ((IMenuPresenter) MenuActivity.this.presenter).requestToSetFragment(MenuFragmentType.LIBRARY);
                    return true;
                case R.id.action_training /*2131296287*/:
                    ((IMenuPresenter) MenuActivity.this.presenter).requestToSetFragment(MenuFragmentType.TRAINING_MENU);
                    return true;
                default:
                    return false;
            }
        }
    };
    String path;
    /* access modifiers changed from: private */
    public PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296268)
    View purchasePremiumView;
    SharedPreferences sharedPreferences;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    @NonNull
    public IMenuPresenter createPresenter() {
        return new MenuPresenter();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.main_menu_activity);
        ValueAnimatorEnablerUtil.init(this);
        this.checkout.start();
        this.checkout.loadInventory(Inventory.Request.create().loadAllPurchases(), new Inventory.Callback() {
            public void onLoaded(@Nonnull Inventory.Products products) {
                Inventory.Product productInApp = products.get(ProductTypes.IN_APP);
                Inventory.Product productSubs = products.get(ProductTypes.SUBSCRIPTION);
                if (productInApp.isPurchased(BookUtil.BOOK_SKU)) {
                    MenuActivity.this.bookUtil.setBookPurchased(true);
                } else {
                    MenuActivity.this.bookUtil.setBookPurchased(false);
                }
                if (productSubs.isPurchased(PremiumUtil.PREMIUM_USER_SKU) || productInApp.isPurchased(PremiumUtil.PREMIUM_USER_SKU_UNSUB) || productSubs.isPurchased(PremiumUtil.PREMIUM_USER_SKU_MONTH) || productSubs.isPurchased(PremiumUtil.PREMIUM_USER_SKU_HALF_YEAR) || productSubs.isPurchased(PremiumUtil.PREMIUM_USER_SKU_YEAR)) {
                    MenuActivity.this.premiumUtil.setPremiumUser(true);
                } else {
                    MenuActivity.this.premiumUtil.setPremiumUser(false);
                }
            }
        });
        if (Build.VERSION.SDK_INT < 26) {
            startService(new Intent(this, AlarmHandleService.class));
        }
        this.interstitialAd.setAdUnitId(getString(R.string.interstitial_advertisement_id));
        if (!this.premiumUtil.isPremiumUser()) {
            this.interstitialAd.loadAd(new AdRequest.Builder().build());
        }
        this.unbinder = ButterKnife.bind((Activity) this);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        this.navigation.setOnNavigationItemSelectedListener(this.onNavigationItemSelectedListener);
        this.sharedPreferences = getSharedPreferences("load_book", 0);
        if (this.sharedPreferences.getBoolean("should_load_book", true) && Locale.getDefault().getLanguage().equals("ru")) {
            this.path = getApplicationInfo().dataDir + File.separator + BookDescriptionDatabaseHelper.BOOK_TABLE;
            IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(this).getBookDescriptionDao();
            final long bookId = bookDescriptionDao.getNextItemId();
            this.filePath = this.path + File.separator + bookId + File.separator + FileUtil.FB2;
            BookDescription findBookDescription = bookDescriptionDao.findBookDescription(this.filePath);
            BookDescription bookDescription = new BookDescription();
            bookDescription.setId(bookId);
            this.sharedPreferences.edit().putLong("book_id", bookId).apply();
            bookDescription.setFilePath(this.filePath);
            bookDescription.setType(FileUtil.FB2);
            String bookTitle = getResources().getString(R.string.speed_reading_book_name);
            String bookLanguage = getResources().getString(R.string.speed_reading_book_language);
            bookDescription.setAuthor(getResources().getString(R.string.speed_reading_book_author));
            bookDescription.setTitle(bookTitle);
            bookDescription.setLanguage(bookLanguage);
            bookDescriptionDao.addBookDescription(bookDescription);
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.mkdirs();
                this.filePath += File.separator + "SpeedReading.json";
                copyFile("SpeedReading.json");
            }
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_title));
            ad.setMessage((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_description));
            ad.setPositiveButton((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_answer_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    if (bookId > -1) {
                        int timerModeParam = MenuActivity.this.getIntent().getIntExtra(ReaderActivity.TIMER_MODE_PARAM, 0);
                        Intent intent = new Intent(MenuActivity.this, ReaderActivity.class);
                        intent.putExtra(ReaderActivity.BOOK_DESCRIPTION_ID_PARAM, bookId);
                        intent.putExtra(ReaderActivity.TIMER_MODE_PARAM, timerModeParam);
                        if (timerModeParam == 0) {
                            MenuActivity.this.startActivity(intent);
                        } else {
                            MenuActivity.this.startActivityForResult(intent, TrainingActivity.COURSE_REQUEST_CODE);
                        }
                    }
                }
            });
            ad.setNegativeButton((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_answer_no), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }
            });
            ad.show();
        } else if (this.sharedPreferences.getBoolean("should_load_book", true)) {
            this.path = getApplicationInfo().dataDir + File.separator + BookDescriptionDatabaseHelper.BOOK_TABLE;
            IBookDescriptionDao bookDescriptionDao2 = SQLiteDaoFactory.getDaoFactory(this).getBookDescriptionDao();
            final long bookId2 = bookDescriptionDao2.getNextItemId();
            this.filePath = this.path + File.separator + bookId2 + File.separator + FileUtil.FB2;
            BookDescription findBookDescription2 = bookDescriptionDao2.findBookDescription(this.filePath);
            BookDescription bookDescription2 = new BookDescription();
            bookDescription2.setId(bookId2);
            this.sharedPreferences.edit().putLong("book_id", bookId2).apply();
            bookDescription2.setFilePath(this.filePath);
            bookDescription2.setType(FileUtil.FB2);
            String bookTitle2 = getResources().getString(R.string.speed_reading_book_name);
            String bookLanguage2 = getResources().getString(R.string.speed_reading_book_language);
            bookDescription2.setAuthor(getResources().getString(R.string.speed_reading_book_author));
            bookDescription2.setTitle(bookTitle2);
            bookDescription2.setLanguage(bookLanguage2);
            bookDescriptionDao2.addBookDescription(bookDescription2);
            File file2 = new File(this.filePath);
            if (!file2.exists()) {
                file2.mkdirs();
                this.filePath += File.separator + "SpeedReading_en.json";
                copyFile("SpeedReading_en.json");
            }
            AlertDialog.Builder ad2 = new AlertDialog.Builder(this);
            ad2.setTitle((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_title));
            ad2.setMessage((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_description));
            ad2.setPositiveButton((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_answer_yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    if (bookId2 > -1) {
                        int timerModeParam = MenuActivity.this.getIntent().getIntExtra(ReaderActivity.TIMER_MODE_PARAM, 0);
                        Intent intent = new Intent(MenuActivity.this, ReaderActivity.class);
                        intent.putExtra(ReaderActivity.BOOK_DESCRIPTION_ID_PARAM, bookId2);
                        intent.putExtra(ReaderActivity.TIMER_MODE_PARAM, timerModeParam);
                        if (timerModeParam == 0) {
                            MenuActivity.this.startActivity(intent);
                        } else {
                            MenuActivity.this.startActivityForResult(intent, TrainingActivity.COURSE_REQUEST_CODE);
                        }
                    }
                }
            });
            ad2.setNegativeButton((CharSequence) getResources().getString(R.string.speed_reading_book_dialog_answer_no), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }
            });
            ad2.show();
        }
    }

    private void copyFile(String fileName) {
        try {
            InputStream in = getAssets().open(fileName);
            OutputStream out = new FileOutputStream(this.filePath);
            byte[] buffer = new byte[1024];
            for (int read = in.read(buffer); read != -1; read = in.read(buffer)) {
                out.write(buffer, 0, read);
            }
            this.sharedPreferences.edit().putBoolean("should_load_book", false).apply();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        ((IMenuPresenter) this.presenter).requestToSetFragment(MenuFragmentType.MAIN_MENU);
        return true;
    }

    @OnClick({2131296268})
    public void onPremiumClick() {
        startActivityForResult(new Intent(this, PurchaseActivity.class), 1002);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                ((IMenuPresenter) this.presenter).onActionBarHomePressed();
                return true;
            case R.id.help /*2131296425*/:
                ((IMenuPresenter) this.presenter).onActionBarHelpPressed();
                return true;
            case R.id.settings /*2131296669*/:
                ((IMenuPresenter) this.presenter).onActionBarSettingsPressed();
                return true;
            case R.id.share /*2131296670*/:
                startActivity(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", getString(R.string.application_url)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setActionBarItemsVisible(boolean visible) {
    }

    public void onBackPressed() {
        ((IMenuPresenter) this.presenter).onBackPressed();
    }

    public void onFileExplorerBackPressed() {
        ((BackPressedListener) this.currentFragment).onBackPressed();
    }

    public void requestToSetFragment(MenuFragmentType menuFragmentType) {
        ((IMenuPresenter) this.presenter).requestToSetFragment(menuFragmentType);
    }

    public void setMainMenuFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MainMenuFragment.newInstance()).commitAllowingStateLoss();
        getSupportActionBar().setTitle((int) R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setProfileFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ProfileFragment.newInstance()).commitAllowingStateLoss();
        getSupportActionBar().setTitle((int) R.string.bottom_menu_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setDescriptionFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DescriptionFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.help);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setLibraryFragment() {
        getSupportActionBar().setTitle((int) R.string.library);
        setFragment(LibraryFragment.newInstance());
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setTrainingMenuFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, TrainingMenuFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.training);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setAcceleratorTrainingMenuFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, AcceleratorTrainingMenuFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.accelerator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setMotivatorsMenuFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MotivatorsMenuFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.bottom_menu_materials);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setSettingsFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MainSettingsFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setMotivatorsFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MotivatorsFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.motivators);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setRulesOfSuccessFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, RulesOfSuccessFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.rules_of_success);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setRecommendationFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, RecomendationFragment.newInstance()).commit();
        getSupportActionBar().setTitle((int) R.string.recommendation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void requestToStartTraining(final TrainingType trainingType) {
        if (this.premiumUtil.isPremiumUser()) {
            startActivity(new Intent(this, TrainingActivity.class).putExtra(TrainingActivity.TRAINING_TYPE_PARAM, trainingType));
        } else if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
            this.interstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    MenuActivity.this.interstitialAd.loadAd(new AdRequest.Builder().build());
                    MenuActivity.this.startActivity(new Intent(MenuActivity.this, TrainingActivity.class).putExtra(TrainingActivity.TRAINING_TYPE_PARAM, trainingType));
                }
            });
        } else {
            startActivity(new Intent(this, TrainingActivity.class).putExtra(TrainingActivity.TRAINING_TYPE_PARAM, trainingType));
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String key) {
        if ((this.notifyKey.equals(key) || this.notifyTimeKey.equals(key)) && Build.VERSION.SDK_INT < 26) {
            startService(new Intent(this, AlarmHandleService.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.purchasePremiumView.setVisibility(this.premiumUtil.isPremiumUser() ? 4 : 0);
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.checkout.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002 && resultCode == -1) {
            this.purchasePremiumView.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.checkout.stop();
        this.unbinder.unbind();
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
        this.currentFragment = fragment;
    }

    public void setBookDetailFragment(BookDescription bookDescription) {
        setFragment(BookDetailFragment.newInstance(bookDescription));
        getSupportActionBar().setTitle((CharSequence) bookDescription.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setFileExplorerFragment() {
        setFragment(FileExplorerFragment.newInstance());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onLibraryAddBookClick() {
        ((IMenuPresenter) this.presenter).requestToSetFragment(MenuFragmentType.FILE_EXPLORER);
    }

    public void onLibraryBookOpen(BookDescription bookDescription) {
        ((IMenuPresenter) this.presenter).requestToSetBookDetailFragment(bookDescription);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle((CharSequence) title);
    }

    public void onFileExplorerClose() {
        ((IMenuPresenter) this.presenter).requestToSetFragment(MenuFragmentType.LIBRARY);
    }

    public void onFileExplorerBookOpen(BookDescription bookDescription) {
        ((IMenuPresenter) this.presenter).requestToSetBookDetailFragment(bookDescription);
    }
}
