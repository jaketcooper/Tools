package com.safonov.speedreading.purchase.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.BookUtil;
import com.speedreading.alexander.speedreading.R;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.ActivityCheckout;
import org.solovyev.android.checkout.Checkout;
import org.solovyev.android.checkout.ProductTypes;
import org.solovyev.android.checkout.Purchase;
import org.solovyev.android.checkout.RequestListener;

public class PurchaseBookActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public BookUtil bookUtil = App.get().getBookUtil();
    private ActivityCheckout checkout = Checkout.forActivity(this, App.get().getBilling());
    /* access modifiers changed from: private */
    public boolean isPurchased;
    @BindView(2131296574)
    Button purchaseButton;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.purchase_book_activity);
        this.unbinder = ButterKnife.bind((Activity) this);
        this.checkout.start();
        this.toolbar.setTitleTextColor(getResources().getColor(R.color.colorDarkText));
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.checkout.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.unbinder.unbind();
        this.checkout.stop();
        super.onDestroy();
    }

    @OnClick({2131296574})
    public void onPremiumButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.IN_APP, BookUtil.BOOK_SKU, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseBookActivity.this.isPurchased = true;
                PurchaseBookActivity.this.bookUtil.setBookPurchased(true);
                PurchaseBookActivity.this.purchaseButton.setVisibility(4);
                Toast.makeText(PurchaseBookActivity.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseBookActivity.this, R.string.purchase_error, 1).show();
            }
        });
    }

    public void finish() {
        setResult(this.isPurchased ? -1 : 0);
        super.finish();
    }
}
