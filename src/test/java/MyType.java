/**
 * Description: 泛型警告测试
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/4 09:44
 */
public class MyType<E> {
    class Inner { }
    static class Nested { }

    public static void main(String[] args) {
        MyType mt;          // warning: MyType is a raw type
        MyType.Inner inn;   // warning: MyType.Inner is a raw type

        MyType.Nested nest; // no warning: not parameterized type
        MyType<Object> mt1; // no warning: type parameter given
        MyType<?> mt2;      // no warning: type parameter given (wildcard OK!)
    }
}
