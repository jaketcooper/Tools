package com.safonov.speedreading.main.fragment.motivatorsmenu.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.MenuFragmentType;
import com.safonov.speedreading.reader.library.library.view.LibraryFragmentListener;
import com.safonov.speedreading.reader.repository.BookController;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.Fb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.TxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.SQLiteDaoFactory;
import com.speedreading.alexander.speedreading.R;

public class MotivatorsMenuFragment extends Fragment {
    long bookId;
    private MenuFragmentListener fragmentListener;
    private LibraryFragmentListener libraryFragmentListener;
    SharedPreferences sharedPreferences;
    @BindView(2131296523)
    ConstraintLayout speedReadingBookView;
    private Unbinder unbinder;

    public static MotivatorsMenuFragment newInstance() {
        return new MotivatorsMenuFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_motivators_fragment, container, false);
        this.sharedPreferences = getContext().getSharedPreferences("load_book", 0);
        this.bookId = this.sharedPreferences.getLong("book_id", -1);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.bookId == -1) {
            this.speedReadingBookView.setVisibility(8);
        }
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    @OnClick({2131296523})
    public void onSpeedReadingBookClick() {
        if (this.bookId > -1) {
            IBookDescriptionDao bookDescriptionDao = SQLiteDaoFactory.getDaoFactory(getContext()).getBookDescriptionDao();
            this.libraryFragmentListener.onLibraryBookOpen(new BookController(bookDescriptionDao, new Fb2Dao(getContext(), bookDescriptionDao), new EpubDao(getContext(), bookDescriptionDao), new TxtDao(getContext(), bookDescriptionDao)).findBookDescription(this.bookId));
        }
    }

    @OnClick({2131296374})
    public void onDescriptionClick() {
        this.fragmentListener.requestToSetFragment(MenuFragmentType.DESCRIPTION);
    }

    @OnClick({2131296606})
    public void onRecommendationsClick() {
        this.fragmentListener.requestToSetFragment(MenuFragmentType.RECOMMENDATION);
    }

    @OnClick({2131296633})
    public void onRulesOfSuccessClick() {
        this.fragmentListener.requestToSetFragment(MenuFragmentType.RULES_OF_SUCCESS);
    }

    @OnClick({2131296524})
    public void onMotivatorsClick() {
        this.fragmentListener.requestToSetFragment(MenuFragmentType.MOTIVATORS);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MenuFragmentListener) {
            this.fragmentListener = (MenuFragmentListener) context;
            if (context instanceof LibraryFragmentListener) {
                this.libraryFragmentListener = (LibraryFragmentListener) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement LibraryFragmentListener");
        }
        throw new RuntimeException(context.toString() + " must implement MenuFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
        this.libraryFragmentListener = null;
    }
}
