package org.jugbd.mnet.utils;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 * @author Bazlur Rahman Rokon
 * @date 10/5/15.
 */
public abstract class Either<L, R> {
    protected L leftValue;
    protected R rightValue;

    public static <L, R> Either<L, R> either(Supplier<L> leftSupplier, Supplier<R> rightSupplier) {

        return Optional.ofNullable(rightSupplier.get())
                .map(Either::<L, R>right)
                .orElseGet(() -> Either.<L, R>left(leftSupplier.get()));
    }

    public abstract L getLeft();

    public abstract R getRight();

    public abstract boolean isLeft();

    public abstract boolean isRight();

    public abstract <T> T fold(Function<L, T> transformLeft, Function<R, T> transformRight);

    public abstract <T, U> Either<T, U> map(Function<L, T> transformLeft, Function<R, U> transformRight);

    public static <L, R> Either<L, R> left(L left) {
        return new Left<>(left);
    }

    public static <L, R> Either<L, R> right(R right) {
        return new Right<>(right);
    }

    public static class Right<L, R> extends Either<L, R> {
        private Right(R right) {
            this.leftValue = null;
            this.rightValue = right;
        }

        @Override
        public L getLeft() {
            throw new NoSuchElementException("Tried to getLeft from Right");
        }

        @Override
        public R getRight() {
            return this.rightValue;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public <T> T fold(Function<L, T> transformLeft, Function<R, T> transformRight) {

            return transformRight.apply(this.rightValue);
        }

        @Override
        public <T, U> Either<T, U> map(Function<L, T> transformLeft, Function<R, U> transformRight) {
            return Either.<T, U>right(transformRight.apply(this.rightValue));
        }

        @Override
        public int hashCode() {

            return this.rightValue.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Right<?, ?>) {
                final Right<?, ?> objAsLeft = (Right<?, ?>) obj;

                return this.rightValue.equals(objAsLeft.rightValue);
            } else {
                return false;
            }
        }
    }

    public static class Left<L, R> extends Either<L, R> {

        public Left(L left) {
            this.rightValue = null;
            this.leftValue = left;
        }

        @Override
        public L getLeft() {

            return leftValue;
        }

        @Override
        public R getRight() {

            throw new NoSuchElementException("Tried to getRight from Left");
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public <T> T fold(Function<L, T> transformLeft, Function<R, T> transformRight) {
            return transformLeft.apply(this.leftValue);
        }

        @Override
        public <T, U> Either<T, U> map(Function<L, T> transformLeft, Function<R, U> transformRight) {
            return Either.<T, U>left(transformLeft.apply(this.leftValue));
        }

        @Override
        public int hashCode() {

            return this.leftValue.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Left<?, ?>) {
                final Left<?, ?> objAsLeft = (Left<?, ?>) obj;
                return this.leftValue.equals(objAsLeft.leftValue);
            } else {
                return false;
            }
        }
    }
}