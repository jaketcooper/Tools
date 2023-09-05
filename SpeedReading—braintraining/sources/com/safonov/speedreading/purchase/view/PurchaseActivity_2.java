package com.safonov.speedreading.purchase.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.purchase.PurchasePagerAdapter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.ActivityCheckout;
import org.solovyev.android.checkout.Checkout;
import org.solovyev.android.checkout.ProductTypes;
import org.solovyev.android.checkout.Purchase;
import org.solovyev.android.checkout.RequestListener;

public class PurchaseActivity_2 extends AppCompatActivity {
    public static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArncdZCT0YWSgOsMQxtFnJKkEwd4b8qE68HT1SHr+2GTwqluicDTBA1aHliTlwWBI9WROLAFK9xYeuxB2IYUWU73XBU9bMEGBzlEdOnCl9h4DT/4Qw0oxu5UILSTX6YShCSSohgWA1Q91/Y9k22UPFbgdjULJtGmGMhXZC9Tho72ctyKM0j1qjHkuu4OoznVy4aqxBK/bfytt5+nZI3lIft3U8FZ5nVsei4MoW7bZmGtb5vr0ZbEPfWHCi6MtH0HopSf7f9NWSWD3RyvfTpmdbh4DIo+JghHt5L08HmscZCNaGvBQzSx+uGqLZdgYYYQGhRSk5NsvrOMbqpo17lJmxwIDAQAB";
    private ActivityCheckout checkout = Checkout.forActivity(this, App.get().getBilling());
    /* access modifiers changed from: private */
    public boolean isPurchased;
    /* access modifiers changed from: private */
    public PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296575)
    TextView purchaseForeverButton;
    @BindView(2131296576)
    TextView purchaseHalfYearButton;
    @BindView(2131296577)
    TextView purchaseMonthButton;
    @BindView(2131296578)
    TextView purchaseYearButton;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.purchase_activity);
        this.unbinder = ButterKnife.bind((Activity) this);
        this.checkout.start();
        this.toolbar.setTitleTextColor(getResources().getColor(R.color.colorDarkText));
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((int) R.string.premium);
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<>();
        View page = inflater.inflate(R.layout.purchase_advantage_page, (ViewGroup) null);
        ((TextView) page.findViewById(R.id.purchase_advantage_title_tv)).setText(R.string.more_training_ads_title);
        ((TextView) page.findViewById(R.id.purchase_advantage_description_tv)).setText(R.string.more_training_ads_description);
        ((ImageView) page.findViewById(R.id.purchase_advantage_image_view)).setImageResource(R.drawable.purchase_trainers_icon);
        pages.add(page);
        View page2 = inflater.inflate(R.layout.purchase_advantage_page, (ViewGroup) null);
        ((TextView) page2.findViewById(R.id.purchase_advantage_title_tv)).setText(R.string.no_ads_title);
        ((TextView) page2.findViewById(R.id.purchase_advantage_description_tv)).setText(R.string.no_ads_description);
        ((ImageView) page2.findViewById(R.id.purchase_advantage_image_view)).setImageResource(R.drawable.purchase_ads_icon);
        pages.add(page2);
        View page3 = inflater.inflate(R.layout.purchase_advantage_page, (ViewGroup) null);
        ((TextView) page3.findViewById(R.id.purchase_advantage_title_tv)).setText(R.string.more_speed_ads_title);
        ((TextView) page3.findViewById(R.id.purchase_advantage_description_tv)).setText(R.string.more_speed_ads_description);
        ((ImageView) page3.findViewById(R.id.purchase_advantage_image_view)).setImageResource(R.drawable.purchase_speed_icon);
        pages.add(page3);
        ((ViewPager) findViewById(R.id.pager)).setAdapter(new PurchasePagerAdapter(pages));
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

    @OnClick({2131296575})
    public void onPremiumButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.IN_APP, PremiumUtil.PREMIUM_USER_SKU_UNSUB, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseActivity_2.this.isPurchased = true;
                PurchaseActivity_2.this.premiumUtil.setPremiumUser(true);
                PurchaseActivity_2.this.purchaseForeverButton.setVisibility(4);
                PurchaseActivity_2.this.purchaseYearButton.setVisibility(4);
                PurchaseActivity_2.this.purchaseHalfYearButton.setVisibility(4);
                PurchaseActivity_2.this.purchaseMonthButton.setVisibility(4);
                Toast.makeText(PurchaseActivity_2.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseActivity_2.this, R.string.purchase_error, 1).show();
            }
        });
    }

    public void finish() {
        setResult(this.isPurchased ? -1 : 0);
        super.finish();
    }
}
