package org.solovyev.android.checkout;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class GetSkuDetailsRequest extends Request<Skus> {
    private static final int MAX_SIZE_PER_REQUEST = 20;
    @Nonnull
    private final String mProduct;
    @Nonnull
    private final ArrayList<String> mSkus;

    GetSkuDetailsRequest(@Nonnull String product, @Nonnull List<String> skus) {
        super(RequestType.GET_SKU_DETAILS);
        this.mProduct = product;
        this.mSkus = new ArrayList<>(skus);
        Collections.sort(this.mSkus);
    }

    /* access modifiers changed from: package-private */
    public void start(@Nonnull IInAppBillingService service, @Nonnull String packageName) throws RemoteException, RequestException {
        List<Sku> allSkuDetails = new ArrayList<>();
        int start = 0;
        while (start < this.mSkus.size()) {
            Skus skuDetails = getSkuDetails(service, packageName, new ArrayList<>(this.mSkus.subList(start, Math.min(this.mSkus.size(), start + 20))));
            if (skuDetails != null) {
                allSkuDetails.addAll(skuDetails.list);
                start += 20;
            } else {
                return;
            }
        }
        onSuccess(new Skus(this.mProduct, allSkuDetails));
    }

    @Nullable
    private Skus getSkuDetails(@Nonnull IInAppBillingService service, @Nonnull String packageName, ArrayList<String> skuBatch) throws RemoteException, RequestException {
        Check.isTrue(skuBatch.size() <= 20, "SKU list is too big");
        Bundle skusBundle = new Bundle();
        skusBundle.putStringArrayList("ITEM_ID_LIST", skuBatch);
        Bundle bundle = service.getSkuDetails(3, packageName, this.mProduct, skusBundle);
        if (!handleError(bundle)) {
            return Skus.fromBundle(bundle, this.mProduct);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getCacheKey() {
        if (this.mSkus.size() == 1) {
            return this.mProduct + "_" + this.mSkus.get(0);
        }
        StringBuilder sb = new StringBuilder(this.mSkus.size() * 5);
        sb.append("[");
        for (int i = 0; i < this.mSkus.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(this.mSkus.get(i));
        }
        sb.append("]");
        return this.mProduct + "_" + sb.toString();
    }
}
