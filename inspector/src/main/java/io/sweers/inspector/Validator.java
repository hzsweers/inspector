package io.sweers.inspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Validates objects of a given type.
 *
 * @param <T> the object type to validate.
 */
public abstract class Validator<T> {

  public abstract void validate(T object) throws ValidationException;

  public Validator<T> nullSafe() {
    // TODO
    return this;
  }

  public interface Factory {
    /**
     * Attempts to create an adapter for {@code type} annotated with {@code annotations}. This
     * returns the adapter if one was created, or null if this factory isn't capable of creating
     * such an adapter.
     *
     * <p>Implementations may use to {@link Inspector#validator} to compose adapters of other types,
     * or {@link Inspector#nextValidator} to delegate to the underlying adapter of the same type.
     */
    @Nullable Validator<?> create(Type type, Set<? extends Annotation> annotations, Inspector inspector);
  }
}
