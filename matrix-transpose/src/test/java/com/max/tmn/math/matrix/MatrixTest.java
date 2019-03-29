package com.max.tmn.math.matrix;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.max.tmn.math.matrix.Matrix.Value;

public class MatrixTest {
	
	private AtomicInteger number = new AtomicInteger(1);

	@Test
	public void testDefault() {
		assertThat(new Matrix<>(1, 1).get(0, 0), is(Value.EMPTY));
	}
	
	@Test
	public void testSetValue() {
		Matrix<Integer> matrix = new Matrix<>(1, 1);
		matrix.set(0, 0, Value.<Integer>of(1));
		
		assertThat(matrix.get(0, 0), is(Value.of(1)));
	}
	
	@Test
	public void testToStringEmpty() {
		assertThat(new Matrix<>(0, 0).toString(), is("[]"));
	}

	@Test
	public void testToStringSingle() {
		Matrix<Integer> matrix = new Matrix<>(1, 1);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		assertThat(matrix.toString(), is("1"));
	}

	@Test
	public void testToStringSingleRow() {
		Matrix<Integer> matrix = new Matrix<>(1, 2);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		assertThat(matrix.toString(), is("1, 2"));
	}

	@Test
	public void testToString() {
		Matrix<Integer> matrix = new Matrix<>(3, 3);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		assertThat(matrix.toString(), is("1, 2, 3\r\n4, 5, 6\r\n7, 8, 9"));
	}

	
}
