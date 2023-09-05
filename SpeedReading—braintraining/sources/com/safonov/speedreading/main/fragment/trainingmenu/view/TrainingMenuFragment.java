package com.safonov.speedreading.main.fragment.trainingmenu.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.TrainingFragmentListener;
import com.safonov.speedreading.purchase.view.PurchaseActivity;
import com.safonov.speedreading.training.TrainingType;
import com.speedreading.alexander.speedreading.R;

public class TrainingMenuFragment extends Fragment {
    private MenuFragmentListener menuFragmentListener;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296722)
    TextView startCup;
    @BindView(2131296724)
    TextView startRememberWords;
    @BindView(2131296725)
    TextView startTrueColors;
    /* access modifiers changed from: private */
    public TrainingFragmentListener trainingFragmentListener;
    private Unbinder unbinder;

    public static TrainingMenuFragment newInstance() {
        return new TrainingMenuFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_training_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrainingFragmentListener) {
            this.trainingFragmentListener = (TrainingFragmentListener) context;
            if (context instanceof MenuFragmentListener) {
                this.menuFragmentListener = (MenuFragmentListener) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement MenuFragmentListener");
        }
        throw new RuntimeException(context.toString() + " must implement TrainingFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingFragmentListener = null;
    }

    @OnClick({2131296786})
    public void onAcceleratorMenuClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.ACCELERATOR_COURSE);
    }

    @OnClick({2131296797})
    public void onStartSchulteTableClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.SCHULTE_TABLE);
    }

    @OnClick({2131296795})
    public void onStartRememberNumberClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.REMEMBER_NUMBER);
    }

    @OnClick({2131296793})
    public void onStartLineOfSightClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.LINE_OF_SIGHT);
    }

    @OnClick({2131296798})
    public void onStartSpeedReadingClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.SPEED_READING);
    }

    @OnClick({2131296801})
    public void onStartWordPairsClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.WORD_PAIRS);
    }

    @OnClick({2131296790})
    public void onStartEvenNumbersClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.EVEN_NUMBERS);
    }

    @OnClick({2131296792})
    public void onStartGreenDotClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.GREEN_DOT);
    }

    @OnClick({2131296794})
    public void onStrartMathClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.MATHEMATICS);
    }

    @OnClick({2131296788})
    public void onStartConcentrationClick() {
        this.trainingFragmentListener.requestToStartTraining(TrainingType.CONCENTRATION);
    }

    @OnClick({2131296789})
    public void onStartCupTimerClick() {
        if (this.premiumUtil.isPremiumUser()) {
            this.trainingFragmentListener.requestToStartTraining(TrainingType.CUPTIMER);
        } else {
            showPurchasePremiumDialog();
        }
    }

    @OnClick({2131296796})
    public void onStartRememberWordsClick() {
        if (this.premiumUtil.isPremiumUser()) {
            this.trainingFragmentListener.requestToStartTraining(TrainingType.REMEMBER_WORDS);
        } else {
            showPurchasePremiumDialog();
        }
    }

    @OnClick({2131296785})
    public void onStartBaseCourse() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.pass_descr_title);
        builder.setMessage((int) R.string.pass_descr);
        builder.setPositiveButton((int) R.string.pass_descr_start, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                TrainingMenuFragment.this.trainingFragmentListener.requestToStartTraining(TrainingType.PASS_COURSE);
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

    @OnClick({2131296799})
    public void onStartTrueColorsClick() {
        if (this.premiumUtil.isPremiumUser()) {
            this.trainingFragmentListener.requestToStartTraining(TrainingType.TRUE_COLORS);
        } else {
            showPurchasePremiumDialog();
        }
    }

    public void showPurchasePremiumDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                TrainingMenuFragment.this.startActivity(new Intent(TrainingMenuFragment.this.getActivity(), PurchaseActivity.class));
            }
        });
        builder.create().show();
    }

    public void onResume() {
        super.onResume();
        if (this.premiumUtil.isPremiumUser()) {
            this.startRememberWords.setBackgroundResource(R.drawable.button_shape);
            this.startRememberWords.setText(R.string.begin);
            this.startTrueColors.setBackgroundResource(R.drawable.button_shape);
            this.startTrueColors.setText(R.string.begin);
            this.startCup.setBackgroundResource(R.drawable.button_shape);
            this.startCup.setText(R.string.begin);
        }
    }
}
