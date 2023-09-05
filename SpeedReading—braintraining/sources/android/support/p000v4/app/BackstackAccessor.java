package android.support.p000v4.app;

/* renamed from: android.support.v4.app.BackstackAccessor */
public class BackstackAccessor {
    private BackstackAccessor() {
        throw new IllegalStateException("Not instantiatable");
    }

    public static boolean isFragmentOnBackStack(Fragment fragment) {
        return fragment.isInBackStack();
    }
}
