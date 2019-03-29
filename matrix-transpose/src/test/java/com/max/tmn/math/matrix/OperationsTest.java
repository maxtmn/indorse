package com.max.tmn.math.matrix;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static com.max.tmn.math.matrix.Operations.transpose;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.max.tmn.math.matrix.Matrix.Value;

public class OperationsTest {

	private AtomicInteger number = new AtomicInteger(1);

	@Test
	public void testTransposeEmtpy() {
		assertThat(transpose(new Matrix<>(0, 0)).toString(), is("[]"));
	}

	@Test
	public void testTransposeSingle() {
		Matrix<Integer> matrix = new Matrix<>(1, 1);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		assertThat(transpose(matrix).toString(), is("1"));
	}

	@Test
	public void testTranspose1x2() {
		Matrix<Integer> matrix = new Matrix<>(1, 2);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		Matrix<Integer> result = transpose(matrix);

		assertThat(result.toString(), is("1\r\n2"));
	}

	@Test
	public void testTranspose2x2() {
		Matrix<Integer> matrix = new Matrix<>(2, 2);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		Matrix<Integer> result = transpose(matrix);

		assertThat(result.toString(), is("1, 3\r\n2, 4"));
	}

	@Test
	public void testTranspose2x3() {
		Matrix<Integer> matrix = new Matrix<>(2, 3);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		Matrix<Integer> result = transpose(matrix);

		assertThat(result.toString(), is("1, 4\r\n2, 5\r\n3, 6"));
	}

	@Test
	public void testTransposeSelfInverse() {
		Matrix<Integer> matrix = new Matrix<>(2, 3);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		Matrix<Integer> result = transpose(transpose(matrix));

		assertThat(result, is(matrix));
	}

	@Test
	public void testTranspose3x3() {
		Matrix<Integer> matrix = new Matrix<>(3, 3);
		matrix.fill(() -> Value.of(number.getAndIncrement()));

		Matrix<Integer> result = transpose(matrix);

		assertThat(result.toString(), is("1, 4, 7\r\n2, 5, 8\r\n3, 6, 9"));
	}

}
