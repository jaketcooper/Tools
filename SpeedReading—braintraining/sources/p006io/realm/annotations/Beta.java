package p006io.realm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* renamed from: io.realm.annotations.Beta */
public @interface Beta {
}
