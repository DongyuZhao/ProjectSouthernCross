package project.southern_cross.general;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class NullableValue<T> {
    private T _value;
    private boolean _hasValue = false;

    public T value() {
        return _value;
    }

    public void setValue(T value) {
        this._value = value;
        this._hasValue = true;
    }
}
