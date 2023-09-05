package com.safonov.speedreading.purchase.view;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
import java.util.Currency;
import java.util.List;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.ActivityCheckout;
import org.solovyev.android.checkout.Checkout;
import org.solovyev.android.checkout.Inventory;
import org.solovyev.android.checkout.ProductTypes;
import org.solovyev.android.checkout.Purchase;
import org.solovyev.android.checkout.RequestListener;
import org.solovyev.android.checkout.Sku;

public class PurchaseActivity extends AppCompatActivity {
    public static final int ONE_CURRENCY_UNIT = 1000000;
    private ActivityCheckout checkout = Checkout.forActivity(this, App.get().getBilling());
    /* access modifiers changed from: private */
    public boolean isPurchased;
    @BindView(2131296571)
    TextView premiumForeverButton;
    /* access modifiers changed from: private */
    public PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296576)
    ConstraintLayout purchaseHalfYearButton;
    @BindView(2131296572)
    TextView purchaseHalfYearPrice;
    @BindView(2131296577)
    ConstraintLayout purchaseMonthButton;
    @BindView(2131296573)
    TextView purchaseMonthPrice;
    @BindView(2131296578)
    ConstraintLayout purchaseYearButton;
    @BindView(2131296579)
    TextView purchaseYearPrice;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean connected;
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.purchase_activity);
        this.unbinder = ButterKnife.bind((Activity) this);
        this.checkout.start();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        } else {
            connected = false;
        }
        List<String> skus = new ArrayList<>();
        skus.add(PremiumUtil.PREMIUM_USER_SKU_MONTH);
        skus.add(PremiumUtil.PREMIUM_USER_SKU_HALF_YEAR);
        skus.add(PremiumUtil.PREMIUM_USER_SKU_YEAR);
        if (connected) {
            this.checkout.loadInventory(Inventory.Request.create().loadSkus(ProductTypes.IN_APP, PremiumUtil.PREMIUM_USER_SKU_UNSUB), new Inventory.Callback() {
                public void onLoaded(@Nonnull Inventory.Products products) {
                    Sku inAppSku = products.get(ProductTypes.IN_APP).getSku(PremiumUtil.PREMIUM_USER_SKU_UNSUB);
                    PurchaseActivity.this.premiumForeverButton.setText(PurchaseActivity.this.getResources().getString(R.string.forever_premium, new Object[]{inAppSku.price}));
                }
            });
            this.checkout.loadInventory(Inventory.Request.create().loadSkus(ProductTypes.SUBSCRIPTION, skus), new Inventory.Callback() {
                public void onLoaded(@Nonnull Inventory.Products products) {
                    Inventory.Product productSubs = products.get(ProductTypes.SUBSCRIPTION);
                    Sku monthSku = productSubs.getSku(PremiumUtil.PREMIUM_USER_SKU_MONTH);
                    Sku halfYearSku = productSubs.getSku(PremiumUtil.PREMIUM_USER_SKU_HALF_YEAR);
                    Sku yearSku = productSubs.getSku(PremiumUtil.PREMIUM_USER_SKU_YEAR);
                    String halfYearPricePerMonth = PurchaseActivity.this.getPriceByMonth(halfYearSku.detailedPrice.amount, 6) + " " + PurchaseActivity.this.getCurrencySymbol(halfYearSku.detailedPrice.currency);
                    String yearPricePerMonth = PurchaseActivity.this.getPriceByMonth(yearSku.detailedPrice.amount, 12) + " " + PurchaseActivity.this.getCurrencySymbol(yearSku.detailedPrice.currency);
                    if (monthSku != null) {
                        PurchaseActivity.this.purchaseMonthPrice.setText(monthSku.price);
                    }
                    if (halfYearSku != null) {
                        PurchaseActivity.this.purchaseHalfYearPrice.setText(halfYearPricePerMonth);
                    }
                    if (yearSku != null) {
                        PurchaseActivity.this.purchaseYearPrice.setText(yearPricePerMonth);
                    }
                }
            });
        } else {
            this.premiumForeverButton.setText("Подключитесь к интернету");
        }
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

    public String getCurrencySymbol(String currencyCode) {
        try {
            return Currency.getInstance(currencyCode).getSymbol();
        } catch (Exception e) {
            return currencyCode;
        }
    }

    public String getPriceByMonth(long price, int countMonth) {
        return String.format("%.2f", new Object[]{Float.valueOf((((float) price) / 1000000.0f) / ((float) countMonth))});
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

    @OnClick({2131296578})
    public void onPremiumYearButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.SUBSCRIPTION, PremiumUtil.PREMIUM_USER_SKU_YEAR, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseActivity.this.isPurchased = true;
                PurchaseActivity.this.premiumUtil.setPremiumUser(true);
                PurchaseActivity.this.purchaseYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseHalfYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseMonthButton.setVisibility(4);
                PurchaseActivity.this.premiumForeverButton.setVisibility(4);
                Toast.makeText(PurchaseActivity.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseActivity.this, R.string.purchase_error, 1).show();
            }
        });
    }

    @OnClick({2131296576})
    public void onPremiumHalfYearButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.SUBSCRIPTION, PremiumUtil.PREMIUM_USER_SKU_HALF_YEAR, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseActivity.this.isPurchased = true;
                PurchaseActivity.this.premiumUtil.setPremiumUser(true);
                PurchaseActivity.this.purchaseYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseHalfYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseMonthButton.setVisibility(4);
                PurchaseActivity.this.premiumForeverButton.setVisibility(4);
                Toast.makeText(PurchaseActivity.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseActivity.this, R.string.purchase_error, 1).show();
            }
        });
    }

    @OnClick({2131296577})
    public void onPremiumMonthButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.SUBSCRIPTION, PremiumUtil.PREMIUM_USER_SKU_MONTH, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseActivity.this.isPurchased = true;
                PurchaseActivity.this.premiumUtil.setPremiumUser(true);
                PurchaseActivity.this.purchaseYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseHalfYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseMonthButton.setVisibility(4);
                PurchaseActivity.this.premiumForeverButton.setVisibility(4);
                Toast.makeText(PurchaseActivity.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseActivity.this, R.string.purchase_error, 1).show();
            }
        });
    }

    @OnClick({2131296571})
    public void onPremiumForeverButtonClick() {
        this.checkout.startPurchaseFlow(ProductTypes.IN_APP, PremiumUtil.PREMIUM_USER_SKU_UNSUB, (String) null, new RequestListener<Purchase>() {
            public void onSuccess(@Nonnull Purchase result) {
                boolean unused = PurchaseActivity.this.isPurchased = true;
                PurchaseActivity.this.premiumUtil.setPremiumUser(true);
                PurchaseActivity.this.purchaseYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseHalfYearButton.setVisibility(4);
                PurchaseActivity.this.purchaseMonthButton.setVisibility(4);
                PurchaseActivity.this.premiumForeverButton.setVisibility(4);
                Toast.makeText(PurchaseActivity.this, R.string.purchase_success, 1).show();
            }

            public void onError(int response, @Nonnull Exception e) {
                Toast.makeText(PurchaseActivity.this, R.string.purchase_error, 1).show();
            }
        });
    }

    public void finish() {
        setResult(this.isPurchased ? -1 : 0);
        super.finish();
    }
}
