package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;


public class AsIntStream implements IntStream {
    private ArrayList<Integer> arr;

    private AsIntStream() {
        this.arr = new ArrayList<Integer>();
    }

    private AsIntStream(ArrayList<Integer> array){
        this.arr = array;
    }

    public static IntStream of(int... values) {

        /* Returns a sequential ordered stream whose elements are the specified values. */

        AsIntStream st = new AsIntStream();
        for (int i :
                values) {
            st.arr.add(i);
        }
        return st;
    }


    @Override
    public Double average() {
        /* Returns the average of this stream. */

        if (arr.isEmpty()) {
            throw new IllegalArgumentException("It is empty");
        }
        else {

            return ((double) sum()) / count();
        }
    }

    @Override
    public Integer max() {

        /* Returns the maximum element of this stream.
        This is a terminal operation.*/

        if (arr.isEmpty()){
            throw new IllegalArgumentException("It is empty");
        }
        int max_value = arr.get(0);
        for (int i :
                arr) {
            if (i > max_value){
                max_value = i;
            }
        }
        return max_value;
    }


    @Override
    public Integer min() {

        /* Returns the minimum element of this stream.
        This is a terminal operation.*/

        if (arr.isEmpty()){
            throw new IllegalArgumentException("It is empty");
        }
        int min_value = arr.get(0);
        for (int i :
                arr) {
            if (i < min_value){
                min_value = i;
            }
        }
        return min_value;
    }

    @Override
    public long count() {
        /* Returns the count of elements in this stream.
        This is terminal operation.
        */

        if (arr.isEmpty()){
            throw new IllegalArgumentException("It is empty");
        }
        return arr.size();
    }


    @Override
    public Integer sum() {
        /* Returns the sum of elements in this stream.
        This is terminal operation.
        */

        if (arr.isEmpty()){
            throw new IllegalArgumentException("It is empty");
        }
        int counter = 0;
        for (int i :
                arr) {
            counter += i;
        }
        return counter;
    }


    @Override
    public IntStream filter(IntPredicate predicate) {
        /* Returns a stream consisting of the elements of this stream that match the given predicate.  */
        AsIntStream new_arr = new AsIntStream();
        for (int i : arr) {
            if (predicate.test(i)){
                new_arr.arr.add(i);
            }
        }
        return new_arr;
    }


    @Override
    public void forEach(IntConsumer action) {
        /* Performs an action for each element of this stream.
        This is a terminal operation. */

        for (int i :
                arr) {
            action.accept(i);
        }
    }


    @Override
    public IntStream map(IntUnaryOperator mapper) {
        /*  Returns a stream consisting of the results of applying
         the given function to the elements of this stream.  */

        AsIntStream new_arr = new AsIntStream();
        for (int i : arr) {
            new_arr.arr.add(mapper.apply(i));
        }
        return new_arr;

    }


    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {

        /* Returns a stream consisting of the results of replacing each element of this stream with the
         contents of a mapped stream produced by applying the provided mapping function to each element.
        */

        ArrayList<IntStream> new_arr = new ArrayList<>();
        for (Integer anArr : arr) {
            new_arr.add(func.applyAsIntStream(anArr));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (IntStream el : new_arr) {
            for (int i : el.toArray()){
                res.add(i);
            }
        }
        return new AsIntStream(res);
    }


    @Override
    public int reduce(int identity, IntBinaryOperator op) {

        /*  Performs a reduction on the elements of this stream,
        using the provided identity value and an associative accumulation function,
         and returns the reduced value. This is terminal operation.
         */

        int result = identity;
        for (int i : arr){
            result = op.apply(result, i);
        }
        return result;
    }


    @Override
    public int[] toArray() {
        /* Makes a stream into Array */
        int[] new_arr = new int[arr.size()];
        for (int i =0; i < new_arr.length; i++){
            new_arr[i] = arr.get(i);
        }
        return new_arr;

    }
}
