package org.solovyev.android.checkout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.solovyev.android.checkout.Inventory;

public final class RobotmediaDatabase {
    static final String NAME = "billing.db";
    @Nonnull
    private final Context mContext;

    public RobotmediaDatabase(@Nonnull Context context) {
        this.mContext = context;
    }

    public static boolean exists(@Nonnull Context context) {
        File file = getDatabaseFile(context);
        return file != null && file.exists();
    }

    @Nullable
    private static File getDatabaseFile(@Nonnull Context context) {
        return context.getDatabasePath(NAME);
    }

    @Nullable
    static String getDatabasePath(@Nonnull Context context) {
        File file = getDatabaseFile(context);
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    @Nonnull
    static Inventory.Products toInventoryProducts(@Nonnull Collection<String> products) {
        Inventory.Products result = new Inventory.Products();
        for (String productId : products) {
            result.add(new Inventory.Product(productId, true));
        }
        return result;
    }

    @Nonnull
    static String makeInClause(int count) {
        Check.isTrue(count > 0, "Should be positive");
        StringBuilder sb = new StringBuilder((count * 2) + 1);
        sb.append("(");
        sb.append("?");
        for (int i = 1; i < count; i++) {
            sb.append(",?");
        }
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public Inventory.Products load(@Nonnull Inventory.Request request) {
        SQLiteDatabase db = null;
        try {
            db = SQLiteDatabase.openDatabase(getDatabasePath(this.mContext), (SQLiteDatabase.CursorFactory) null, 1);
            Inventory.Products loadProducts = loadProducts(request, db);
            if (db == null) {
                return loadProducts;
            }
            db.close();
            return loadProducts;
        } catch (RuntimeException e) {
            Billing.error((Exception) e);
            if (db != null) {
                db.close();
            }
            return toInventoryProducts(ProductTypes.ALL);
        } catch (Throwable th) {
            if (db != null) {
                db.close();
            }
            throw th;
        }
    }

    @Nonnull
    private Inventory.Products loadProducts(@Nonnull Inventory.Request request, @Nonnull SQLiteDatabase db) {
        Inventory.Products result = new Inventory.Products();
        for (String productId : ProductTypes.ALL) {
            Inventory.Product product = new Inventory.Product(productId, true);
            List<String> skus = request.getSkus(productId);
            if (!skus.isEmpty()) {
                product.setPurchases(loadPurchases(skus, db));
            } else {
                Billing.warning("There are no SKUs for \"" + product.f182id + "\" product. No purchase information will be loaded");
            }
            result.add(product);
        }
        return result;
    }

    @Nonnull
    private List<Purchase> loadPurchases(@Nonnull List<String> skus, @Nonnull SQLiteDatabase db) {
        Check.isNotEmpty((Collection<?>) skus);
        ArrayList arrayList = new ArrayList(skus.size());
        String[] columns = {"_id", "state", "productId", "purchaseTime", "developerPayload"};
        String packageName = this.mContext.getPackageName();
        Cursor c = null;
        try {
            SQLiteDatabase sQLiteDatabase = db;
            c = sQLiteDatabase.query("purchases", columns, "productId in " + makeInClause(skus.size()), (String[]) skus.toArray(new String[skus.size()]), (String) null, (String) null, (String) null);
            if (c.moveToFirst()) {
                do {
                    String str = packageName;
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new Purchase(c.getString(2), c.getString(0), str, c.getLong(3), c.getInt(1), c.getString(4), "", false, "", ""));
                } while (c.moveToNext());
            }
            return arrayList;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
}
