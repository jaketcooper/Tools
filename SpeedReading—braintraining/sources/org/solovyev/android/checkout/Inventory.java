package org.solovyev.android.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.solovyev.android.checkout.Purchase;

public interface Inventory {

    public interface Callback {
        void onLoaded(@Nonnull Products products);
    }

    void cancel();

    void cancel(int i);

    boolean isLoading();

    int load(@Nonnull Request request, @Nonnull Callback callback);

    @Immutable
    public static final class Products implements Iterable<Product> {
        @Nonnull
        static final Products sEmpty = new Products();
        @Nonnull
        private final Map<String, Product> mMap = new HashMap();

        Products() {
            for (String product : ProductTypes.ALL) {
                this.mMap.put(product, new Product(product, false));
            }
        }

        @Nonnull
        public static Products empty() {
            return sEmpty;
        }

        /* access modifiers changed from: package-private */
        public void add(@Nonnull Product product) {
            this.mMap.put(product.f182id, product);
        }

        @Nonnull
        public Product get(@Nonnull String productId) {
            ProductTypes.checkSupported(productId);
            return this.mMap.get(productId);
        }

        public Iterator<Product> iterator() {
            return Collections.unmodifiableCollection(this.mMap.values()).iterator();
        }

        public int size() {
            return this.mMap.size();
        }

        /* access modifiers changed from: package-private */
        public void merge(@Nonnull Products products) {
            Product product;
            for (Map.Entry<String, Product> entry : this.mMap.entrySet()) {
                if (!entry.getValue().supported && (product = products.mMap.get(entry.getKey())) != null) {
                    entry.setValue(product);
                }
            }
        }
    }

    @Immutable
    public static final class Product {
        @Nonnull

        /* renamed from: id */
        public final String f182id;
        @Nonnull
        final List<Purchase> mPurchases = new ArrayList();
        @Nonnull
        final List<Sku> mSkus = new ArrayList();
        public final boolean supported;

        Product(@Nonnull String id, boolean supported2) {
            ProductTypes.checkSupported(id);
            this.f182id = id;
            this.supported = supported2;
        }

        public boolean isPurchased(@Nonnull Sku sku) {
            return isPurchased(sku.f185id.code);
        }

        public boolean isPurchased(@Nonnull String sku) {
            return hasPurchaseInState(sku, Purchase.State.PURCHASED);
        }

        public boolean hasPurchaseInState(@Nonnull String sku, @Nonnull Purchase.State state) {
            return getPurchaseInState(sku, state) != null;
        }

        @Nullable
        public Purchase getPurchaseInState(@Nonnull String sku, @Nonnull Purchase.State state) {
            return Purchases.getPurchaseInState(this.mPurchases, sku, state);
        }

        @Nullable
        public Purchase getPurchaseInState(@Nonnull Sku sku, @Nonnull Purchase.State state) {
            return getPurchaseInState(sku.f185id.code, state);
        }

        @Nonnull
        public List<Purchase> getPurchases() {
            return Collections.unmodifiableList(this.mPurchases);
        }

        /* access modifiers changed from: package-private */
        public void setPurchases(@Nonnull List<Purchase> purchases) {
            Check.isTrue(this.mPurchases.isEmpty(), "Must be called only once");
            this.mPurchases.addAll(Purchases.neutralize(purchases));
            Collections.sort(this.mPurchases, PurchaseComparator.latestFirst());
        }

        @Nonnull
        public List<Sku> getSkus() {
            return Collections.unmodifiableList(this.mSkus);
        }

        /* access modifiers changed from: package-private */
        public void setSkus(@Nonnull List<Sku> skus) {
            Check.isTrue(this.mSkus.isEmpty(), "Must be called only once");
            this.mSkus.addAll(skus);
        }

        @Nullable
        public Sku getSku(@Nonnull String sku) {
            for (Sku s : this.mSkus) {
                if (s.f185id.code.equals(sku)) {
                    return s;
                }
            }
            return null;
        }
    }

    public static final class Request {
        private final Set<String> mProducts = new HashSet();
        private final Map<String, List<String>> mSkus = new HashMap();

        private Request() {
            for (String product : ProductTypes.ALL) {
                this.mSkus.put(product, new ArrayList(5));
            }
        }

        /* access modifiers changed from: package-private */
        @Nonnull
        public Request copy() {
            Request copy = new Request();
            copy.mSkus.putAll(this.mSkus);
            copy.mProducts.addAll(this.mProducts);
            return copy;
        }

        @Nonnull
        public static Request create() {
            return new Request();
        }

        @Nonnull
        public Request loadAllPurchases() {
            this.mProducts.addAll(ProductTypes.ALL);
            return this;
        }

        @Nonnull
        public Request loadPurchases(@Nonnull String product) {
            ProductTypes.checkSupported(product);
            this.mProducts.add(product);
            return this;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldLoadPurchases(@Nonnull String product) {
            return this.mProducts.contains(product);
        }

        @Nonnull
        public Request loadSkus(@Nonnull String product, @Nonnull String... skus) {
            Check.isTrue(skus.length > 0, "No SKUs listed, can't load them");
            return loadSkus(product, (List<String>) Arrays.asList(skus));
        }

        @Nonnull
        public Request loadSkus(@Nonnull String product, @Nonnull List<String> skus) {
            for (String sku : skus) {
                loadSkus(product, sku);
            }
            return this;
        }

        @Nonnull
        public Request loadSkus(@Nonnull String product, @Nonnull String sku) {
            ProductTypes.checkSupported(product);
            Check.isNotEmpty(sku);
            List<String> list = this.mSkus.get(product);
            Check.isTrue(!list.contains(sku), "Adding same SKU is not allowed");
            list.add(sku);
            return this;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldLoadSkus(@Nonnull String product) {
            ProductTypes.checkSupported(product);
            return !this.mSkus.get(product).isEmpty();
        }

        /* access modifiers changed from: package-private */
        @Nonnull
        public List<String> getSkus(@Nonnull String product) {
            return this.mSkus.get(product);
        }
    }
}
