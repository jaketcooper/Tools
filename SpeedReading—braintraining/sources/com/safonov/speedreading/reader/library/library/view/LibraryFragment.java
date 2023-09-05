package com.safonov.speedreading.reader.library.library.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.widget.GridLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.GridSpacingItemDecoration;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.reader.library.library.presenter.ILibraryPresenter;
import com.safonov.speedreading.reader.library.library.presenter.LibraryPresenter;
import com.safonov.speedreading.reader.repository.BookController;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.Fb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.TxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import com.speedreading.alexander.speedreading.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LibraryFragment extends MvpFragment<ILibraryView, ILibraryPresenter> implements ILibraryView {
    public static final String BOOK_ID = "book_id";
    private static final int READ_STORAGE_PERMISSION_REQUEST_CODE = 10;
    public static final String SHOULD_LOAD_BOOK = "should_load_book";
    private LibraryAdapter adapter;
    @BindView(2131296388)
    TextView emptyView;
    String filePath;
    /* access modifiers changed from: private */
    public AlertDialog formatDialog;
    /* access modifiers changed from: private */
    public LibraryFragmentListener fragmentListener;
    private InterstitialAd interstitialAd;
    private boolean isEmpty = true;
    private View parentView;
    String path;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private ProgressDialog progressDialog;
    @BindView(2131296608)
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    long speedReadingBookId;
    @BindView(2131296694)
    ProgressBar speedReadingBookProgress;
    @BindView(2131296695)
    TextView speedReadingBookProgressTv;
    @BindView(2131296472)
    ConstraintLayout speedReadingBookView;
    private Unbinder unbinder;

    static class LibraryAdapter extends RecyclerView.Adapter<ViewHolder> {
        /* access modifiers changed from: private */
        public List<BookDescription> bookDescriptionList;
        private Context context;
        private ItemClickListener itemClickListener;
        SharedPreferences sharedPreferences;
        long speedReadingBookId;

        interface ItemClickListener {
            void onItemClick(long j);

            void onItemLongClick(long j);
        }

        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder target2, View source) {
                this.target = target2;
                target2.titleTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.book_title_text_view, "field 'titleTextView'", TextView.class);
                target2.progressTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.book_progress_text_view, "field 'progressTextView'", TextView.class);
                target2.bookReadButton = (TextView) Utils.findRequiredViewAsType(source, R.id.book_read_button, "field 'bookReadButton'", TextView.class);
                target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.book_progress_bar, "field 'progressBar'", ProgressBar.class);
                target2.bookImageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.book_image_view, "field 'bookImageView'", ImageView.class);
            }

            @CallSuper
            public void unbind() {
                ViewHolder target2 = this.target;
                if (target2 == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                target2.titleTextView = null;
                target2.progressTextView = null;
                target2.bookReadButton = null;
                target2.progressBar = null;
                target2.bookImageView = null;
            }
        }

        class SimpleItemClickListener implements ItemClickListener {
            SimpleItemClickListener() {
            }

            public void onItemClick(int position) {
            }

            public void onItemLongClick(int position) {
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
            @BindView(2131296317)
            ImageView bookImageView;
            @BindView(2131296320)
            TextView bookReadButton;
            private ItemClickListener listener;
            @BindView(2131296318)
            ProgressBar progressBar;
            @BindView(2131296319)
            TextView progressTextView;
            @BindView(2131296321)
            TextView titleTextView;

            ViewHolder(View itemView, ItemClickListener listener2) {
                super(itemView);
                ButterKnife.bind((Object) this, itemView);
                this.listener = listener2;
                itemView.setOnClickListener(this);
                itemView.setOnLongClickListener(this);
            }

            public void onClick(View v) {
                if (this.listener != null) {
                    this.listener.onItemClick(((BookDescription) LibraryAdapter.this.bookDescriptionList.get(getAdapterPosition())).getId());
                }
            }

            public boolean onLongClick(View v) {
                if (this.listener == null) {
                    return true;
                }
                this.listener.onItemLongClick(((BookDescription) LibraryAdapter.this.bookDescriptionList.get(getAdapterPosition())).getId());
                return true;
            }
        }

        private LibraryAdapter(@NonNull Context context2, ItemClickListener itemClickListener2) {
            this.bookDescriptionList = new ArrayList();
            this.context = context2;
            this.itemClickListener = itemClickListener2;
            this.sharedPreferences = context2.getSharedPreferences("load_book", 0);
            this.speedReadingBookId = this.sharedPreferences.getLong("book_id", -1);
        }

        public void setItems(List<BookDescription> bookDescriptionList2) {
            for (BookDescription description : bookDescriptionList2) {
                if (description.getId() != this.speedReadingBookId) {
                    this.bookDescriptionList.add(description);
                }
            }
            notifyDataSetChanged();
        }

        public void removeItem(long bookId) {
            if (bookId != this.speedReadingBookId) {
                int index = 0;
                int removeIndex = 0;
                for (BookDescription bookDescription : this.bookDescriptionList) {
                    if (bookDescription.getId() == bookId) {
                        removeIndex = index;
                    }
                    index++;
                }
                this.bookDescriptionList.remove(removeIndex);
                notifyItemRemoved(removeIndex);
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reader_library_list_item, parent, false), this.itemClickListener);
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            char firstLetter;
            BookDescription bookDescription = this.bookDescriptionList.get(position);
            String bookTitle = bookDescription.getTitle();
            if (!TextUtils.isEmpty(bookTitle)) {
                firstLetter = Character.toUpperCase(bookTitle.charAt(0));
            } else {
                firstLetter = '-';
            }
            int coverColor = LibraryCoverColorHelper.getBookCoverColor(firstLetter);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(coverColor);
            if (Build.VERSION.SDK_INT < 16) {
            }
            holder.titleTextView.setText(bookTitle);
            String type = bookDescription.getType();
            char c = 65535;
            switch (type.hashCode()) {
                case -1110581207:
                    if (type.equals(FileUtil.FB2_ZIP)) {
                        c = 3;
                        break;
                    }
                    break;
                case 101110:
                    if (type.equals(FileUtil.FB2)) {
                        c = 2;
                        break;
                    }
                    break;
                case 115312:
                    if (type.equals(FileUtil.TXT)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3120248:
                    if (type.equals(FileUtil.EPUB)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    holder.bookImageView.setImageResource(R.drawable.file_explorer_epub_book_icon);
                    break;
                case 1:
                    holder.bookImageView.setImageResource(R.drawable.file_explorer_txt_book_icon);
                    break;
                case 2:
                case 3:
                    holder.bookImageView.setImageResource(R.drawable.file_explorer_fb2_book_icon);
                    break;
            }
            if (bookDescription.getProgress() > 0) {
                holder.progressTextView.setText(this.context.getString(R.string.library_book_progress, new Object[]{Integer.valueOf(bookDescription.getProgress())}));
                holder.progressBar.setProgress(bookDescription.getProgress());
                holder.progressTextView.setVisibility(0);
                holder.progressBar.setVisibility(0);
                holder.bookReadButton.setVisibility(4);
            }
        }

        public int getItemCount() {
            return this.bookDescriptionList.size();
        }
    }

    @NonNull
    public ILibraryPresenter createPresenter() {
        IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getContext()).getBookDescriptionDao();
        return new LibraryPresenter(getContext(), new BookController(bookDescriptionDao, new Fb2Dao(getContext(), bookDescriptionDao), new EpubDao(getContext(), bookDescriptionDao), new TxtDao(getContext(), bookDescriptionDao)));
    }

    public static LibraryFragment newInstance() {
        return new LibraryFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.parentView = inflater.inflate(R.layout.reader_library_list_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, this.parentView);
        this.sharedPreferences = getContext().getSharedPreferences("load_book", 0);
        this.speedReadingBookId = this.sharedPreferences.getLong("book_id", -1);
        this.interstitialAd = new InterstitialAd(getContext());
        this.interstitialAd.setAdUnitId(getString(R.string.interstitial_advertisement_id));
        if (!this.premiumUtil.isPremiumUser()) {
            this.interstitialAd.loadAd(new AdRequest.Builder().build());
        }
        this.adapter = new LibraryAdapter(getContext(), new LibraryAdapter.ItemClickListener() {
            public void onItemClick(long bookId) {
                ((ILibraryPresenter) LibraryFragment.this.presenter).onItemClick(bookId);
            }

            public void onItemLongClick(long bookId) {
                ((ILibraryPresenter) LibraryFragment.this.presenter).onItemLongClick(bookId);
            }
        });
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, (int) TypedValue.applyDimension(1, 12.0f, getActivity().getResources().getDisplayMetrics()), true));
        this.recyclerView.setAdapter(this.adapter);
        return this.parentView;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ILibraryPresenter) this.presenter).init();
        if (this.speedReadingBookId > -1) {
            ((ILibraryPresenter) this.presenter).setSpeedReadingBookInfo(this.speedReadingBookId);
            this.isEmpty = false;
            return;
        }
        this.speedReadingBookView.setVisibility(8);
    }

    public void setItems(@NonNull List<BookDescription> bookDescriptionList) {
        this.adapter.setItems(bookDescriptionList);
        if (this.adapter.getItemCount() != 0 || !this.isEmpty) {
            this.recyclerView.setVisibility(0);
            this.emptyView.setVisibility(8);
            return;
        }
        this.recyclerView.setVisibility(8);
        this.emptyView.setVisibility(0);
    }

    public void removeItem(long bookId) {
        if (bookId != this.speedReadingBookId) {
            this.adapter.removeItem(bookId);
        }
        if (this.adapter.getItemCount() == 0) {
            this.recyclerView.setVisibility(8);
            this.emptyView.setVisibility(0);
        }
    }

    @OnClick({2131296406})
    public void onAddBookClick() {
        if (isStoragePermissionGranted()) {
            ((ILibraryPresenter) this.presenter).requestToAddBook();
        } else {
            requestPermission();
        }
    }

    public void showFormatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.reader_library_format_dialog, (ViewGroup) null);
        builder.setCancelable(true);
        builder.setView(dialogView);
        ((Button) dialogView.findViewById(R.id.continue_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LibraryFragment.this.formatDialog.dismiss();
            }
        });
        final CheckBox checkBox = (CheckBox) dialogView.findViewById(R.id.dont_show_again_check_box);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                ((ILibraryPresenter) LibraryFragment.this.presenter).onFormatDialogDismiss(checkBox.isChecked());
            }
        });
        this.formatDialog = builder.create();
        this.formatDialog.show();
    }

    public void showActionDialog(final String bookTitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems((int) R.array.library_book_actions, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LibraryFragment.this.getContext());
                    builder.setCancelable(true);
                    builder.setTitle((CharSequence) bookTitle);
                    builder.setMessage((int) R.string.library_book_remove_message);
                    builder.setPositiveButton((int) R.string.library_book_remove_delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((ILibraryPresenter) LibraryFragment.this.presenter).requestToRemoveBook();
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton((int) R.string.library_book_remove_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
            }
        });
        builder.create().show();
    }

    public void showLoadingLibraryProgressDialog() {
        this.progressDialog = new ProgressDialog(getContext());
        this.progressDialog.setTitle(R.string.library_data_loading);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    public void showRemovingBookProgressDialog() {
        this.progressDialog = new ProgressDialog(getContext());
        this.progressDialog.setTitle(R.string.library_book_deleting);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
    }

    public void setSpeedReadingBookInfo(BookDescription bookDescription) {
        if (bookDescription != null) {
            this.speedReadingBookProgress.setMax(100);
            this.speedReadingBookProgress.setProgress(bookDescription.getProgress());
            this.speedReadingBookProgressTv.setText(getString(R.string.library_book_progress, Integer.valueOf(bookDescription.getProgress())));
        } else if (Locale.getDefault().getLanguage().equals("ru")) {
            addSpeedReadingBook("SpeedReading.json");
        } else {
            addSpeedReadingBook("SpeedReading_en.json");
        }
    }

    private void addSpeedReadingBook(String fileName) {
        this.path = getActivity().getApplicationInfo().dataDir + File.separator + BookDescriptionDatabaseHelper.BOOK_TABLE;
        IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getActivity()).getBookDescriptionDao();
        long bookId = bookDescriptionDao.getNextItemId();
        this.filePath = this.path + File.separator + bookId + File.separator + FileUtil.FB2;
        BookDescription findBookDescription = bookDescriptionDao.findBookDescription(this.filePath);
        BookDescription speedReading = new BookDescription();
        speedReading.setId(bookId);
        this.sharedPreferences.edit().putLong("book_id", bookId).apply();
        this.speedReadingBookId = bookId;
        speedReading.setFilePath(this.filePath);
        speedReading.setType(FileUtil.FB2);
        String bookTitle = getResources().getString(R.string.speed_reading_book_name);
        String bookLanguage = getResources().getString(R.string.speed_reading_book_language);
        speedReading.setAuthor(getResources().getString(R.string.speed_reading_book_author));
        speedReading.setTitle(bookTitle);
        speedReading.setLanguage(bookLanguage);
        bookDescriptionDao.addBookDescription(speedReading);
        File file = new File(this.filePath);
        if (!file.exists()) {
            file.mkdirs();
            this.filePath += File.separator + fileName;
            copyFile(fileName);
        }
        this.speedReadingBookProgress.setMax(100);
        this.speedReadingBookProgress.setProgress(speedReading.getProgress());
        this.speedReadingBookProgressTv.setText(getString(R.string.library_book_progress, Integer.valueOf(speedReading.getProgress())));
    }

    private void copyFile(String fileName) {
        try {
            InputStream in = getActivity().getAssets().open(fileName);
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

    @OnClick({2131296472})
    public void onSpeedReadingBookClick() {
        if (this.speedReadingBookId > -1) {
            IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getContext()).getBookDescriptionDao();
            BookController bookController = new BookController(bookDescriptionDao, new Fb2Dao(getContext(), bookDescriptionDao), new EpubDao(getContext(), bookDescriptionDao), new TxtDao(getContext(), bookDescriptionDao));
            BookDescription bookDescription = bookController.findBookDescription(this.speedReadingBookId);
            if (bookDescription != null) {
                this.fragmentListener.onLibraryBookOpen(bookDescription);
                return;
            }
            if (Locale.getDefault().getLanguage().equals("ru")) {
                addSpeedReadingBook("SpeedReading.json");
            } else {
                addSpeedReadingBook("SpeedReading_en.json");
            }
            this.fragmentListener.onLibraryBookOpen(bookController.findBookDescription(this.speedReadingBookId));
        }
    }

    public void requestToSetFileExplorerFragment() {
        this.fragmentListener.onLibraryAddBookClick();
    }

    public void requestToSetBookDetailFragment(@NonNull final BookDescription bookDescription) {
        if (this.premiumUtil.isPremiumUser()) {
            this.fragmentListener.onLibraryBookOpen(bookDescription);
        } else if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
            this.interstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    LibraryFragment.this.fragmentListener.onLibraryBookOpen(bookDescription);
                }
            });
        } else {
            this.fragmentListener.onLibraryBookOpen(bookDescription);
        }
    }

    private boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    private void requestPermission() {
        requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 10);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] != 0) {
                    Snackbar.make(this.parentView, (int) R.string.library_permission_denied, 0).setAction((int) R.string.library_permission_set, (View.OnClickListener) new View.OnClickListener() {
                        public void onClick(View view) {
                            LibraryFragment.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + LibraryFragment.this.getContext().getPackageName())));
                        }
                    }).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LibraryFragmentListener) {
            this.fragmentListener = (LibraryFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement LibraryFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
    }
}
