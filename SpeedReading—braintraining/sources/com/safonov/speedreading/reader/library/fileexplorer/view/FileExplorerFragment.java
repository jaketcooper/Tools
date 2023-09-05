package com.safonov.speedreading.reader.library.fileexplorer.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.design.widget.Snackbar;
import android.support.p003v7.widget.DividerItemDecoration;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileWrapper;
import com.safonov.speedreading.reader.library.fileexplorer.presenter.FileExplorerPresenter;
import com.safonov.speedreading.reader.library.fileexplorer.presenter.IFileExplorerPresenter;
import com.safonov.speedreading.reader.repository.BookController;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.Fb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.TxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class FileExplorerFragment extends MvpFragment<IFileExplorerView, IFileExplorerPresenter> implements IFileExplorerView {
    private FileExplorerAdapter adapter;
    /* access modifiers changed from: private */
    public FileExplorerFragmentListener fragmentListener;
    private View parentView;
    private ProgressDialog progressDialog;
    @BindView(2131296608)
    RecyclerView recyclerView;
    private Unbinder unbinder;

    interface FileExplorerAdapterClickListener {
        void onItemClick(int i);
    }

    class FileExplorerAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String FILE_TYPE_EPUB = "epub";
        private static final String FILE_TYPE_FB2 = "fb2";
        private static final String FILE_TYPE_TXT = "txt";
        private static final String PARENT_FOLDER_NAME = "...";
        private List<FileExplorerFileWrapper> fileExplorerFileWrapperList;
        private FileExplorerAdapterClickListener listener;

        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder target2, View source) {
                this.target = target2;
                target2.fileNameTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.file_name_text_view, "field 'fileNameTextView'", TextView.class);
                target2.fileCoverImageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.file_cover_image_view, "field 'fileCoverImageView'", ImageView.class);
                target2.fileTypeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.file_type_text_view, "field 'fileTypeTextView'", TextView.class);
            }

            @CallSuper
            public void unbind() {
                ViewHolder target2 = this.target;
                if (target2 == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                target2.fileNameTextView = null;
                target2.fileCoverImageView = null;
                target2.fileTypeTextView = null;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            @BindView(2131296398)
            ImageView fileCoverImageView;
            @BindView(2131296399)
            TextView fileNameTextView;
            @BindView(2131296401)
            TextView fileTypeTextView;
            private FileExplorerAdapterClickListener listener;

            ViewHolder(View itemView, FileExplorerAdapterClickListener listener2) {
                super(itemView);
                ButterKnife.bind((Object) this, itemView);
                this.listener = listener2;
                this.itemView.setOnClickListener(this);
            }

            public void onClick(View v) {
                if (this.listener != null) {
                    this.listener.onItemClick(getAdapterPosition());
                }
            }
        }

        private FileExplorerAdapter(FileExplorerAdapterClickListener listener2) {
            this.fileExplorerFileWrapperList = new ArrayList();
            this.listener = listener2;
        }

        public void setData(List<FileExplorerFileWrapper> data) {
            this.fileExplorerFileWrapperList.clear();
            this.fileExplorerFileWrapperList.addAll(data);
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reader_file_explorer_item, parent, false), this.listener);
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.fileNameTextView.setText(this.fileExplorerFileWrapperList.get(position).getFileName());
            switch (fileExplorerFileWrapper.getType()) {
                case PARENT_FOLDER:
                    holder.fileCoverImageView.setImageResource(R.drawable.file_explorer_parent_folder_icon);
                    holder.fileNameTextView.setText(PARENT_FOLDER_NAME);
                    holder.fileTypeTextView.setVisibility(8);
                    return;
                case FOLDER:
                    holder.fileCoverImageView.setImageResource(R.drawable.file_explorer_folder_icon);
                    holder.fileTypeTextView.setVisibility(8);
                    return;
                case TXT:
                    holder.fileCoverImageView.setImageResource(R.drawable.file_explorer_txt_book_icon);
                    holder.fileTypeTextView.setText(FileExplorerFragment.this.getString(R.string.file_explorer_file_type, "txt"));
                    return;
                case FB2:
                case FB2_ZIP:
                    holder.fileCoverImageView.setImageResource(R.drawable.file_explorer_fb2_book_icon);
                    holder.fileTypeTextView.setText(FileExplorerFragment.this.getString(R.string.file_explorer_file_type, "fb2"));
                    return;
                case EPUB:
                    holder.fileCoverImageView.setImageResource(R.drawable.file_explorer_epub_book_icon);
                    holder.fileTypeTextView.setText(FileExplorerFragment.this.getString(R.string.file_explorer_file_type, "epub"));
                    return;
                default:
                    return;
            }
        }

        public int getItemCount() {
            return this.fileExplorerFileWrapperList.size();
        }
    }

    @NonNull
    public IFileExplorerPresenter createPresenter() {
        IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getContext()).getBookDescriptionDao();
        return new FileExplorerPresenter(new BookController(bookDescriptionDao, new Fb2Dao(getContext(), bookDescriptionDao), new EpubDao(getContext(), bookDescriptionDao), new TxtDao(getContext(), bookDescriptionDao)), this);
    }

    public static FileExplorerFragment newInstance() {
        return new FileExplorerFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.parentView = inflater.inflate(R.layout.reader_file_explorer_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, this.parentView);
        this.adapter = new FileExplorerAdapter(new FileExplorerAdapterClickListener() {
            public void onItemClick(int position) {
                ((IFileExplorerPresenter) FileExplorerFragment.this.presenter).onItemClick(position);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        this.recyclerView.setAdapter(this.adapter);
        return this.parentView;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IFileExplorerPresenter) this.presenter).init();
    }

    public void setActionBarTitle(String title) {
        this.fragmentListener.setActionBarTitle(title);
    }

    public void setData(List<FileExplorerFileWrapper> fileExplorerFileWrapperList) {
        this.adapter.setData(fileExplorerFileWrapperList);
    }

    public void onBackPressed() {
        ((IFileExplorerPresenter) this.presenter).onBackPressed();
    }

    public void onBookAddPreExecute() {
        this.progressDialog = new ProgressDialog(getContext());
        this.progressDialog.setTitle(R.string.file_explorer_book_adding);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    public void onBookAddFailed() {
        this.progressDialog.cancel();
        Snackbar.make(this.parentView, (int) R.string.file_explorer_book_adding_failed, 0).show();
    }

    public void onBookAddedSuccess(final BookDescription bookDescription) {
        this.progressDialog.cancel();
        Snackbar.make(this.parentView, (int) R.string.file_explorer_book_adding_success, 0).setAction((int) R.string.file_explorer_open, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                FileExplorerFragment.this.fragmentListener.onFileExplorerBookOpen(bookDescription);
            }
        }).show();
    }

    public void onBookAlreadyExist(final BookDescription bookDescription) {
        this.progressDialog.cancel();
        Snackbar.make(this.parentView, (int) R.string.file_explorer_book_already_exist, 0).setAction((int) R.string.file_explorer_open, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                FileExplorerFragment.this.fragmentListener.onFileExplorerBookOpen(bookDescription);
            }
        }).show();
    }

    public void closeFileExplorer() {
        this.fragmentListener.onFileExplorerClose();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FileExplorerFragmentListener) {
            this.fragmentListener = (FileExplorerFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement FileExplorerFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }
}
