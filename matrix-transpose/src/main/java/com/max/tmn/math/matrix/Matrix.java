package com.max.tmn.math.matrix;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Matrix<T> {

	private Value<T>[][] matrix;
	private Dimension dimension;

	public Matrix(int x, int y) {
		this(new Dimension(x, y));
	}

	public Matrix(Dimension dimension) {
		this.dimension = dimension;
		init(dimension);
	}

	@SuppressWarnings("unchecked")
	private void init(Dimension dimension) {
		this.matrix = new Value[dimension.length()][dimension.width()];
		fill(() -> Value.EMPTY);
	}

	public Dimension dimension() {
		return dimension;
	}

	public void fill(Supplier<Value<T>> supplier) {
		for (int i = 0; i < dimension.length(); i++)
			for (int j = 0; j < dimension.width(); j++)
				matrix[i][j] = supplier.get();

	}

	public Value<T> get(int x, int y) {
		return matrix[x][y];
	}

	public void set(int x, int y, Value<T> value) {
		matrix[x][y] = value;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;

		if (!(obj instanceof Matrix))
			return false;

		return Arrays.deepEquals(this.matrix, ((Matrix) obj).matrix);
	}

	@Override
	public String toString() {
		if (this.dimension.isEmpty())
			return "[]";

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.dimension.length(); i++) {
			str.append(Arrays.asList(matrix[i]).stream().map(Object::toString)
					.collect(Collectors.joining(", ")));
			if (this.dimension.length() > 1 && i < this.dimension.length() - 1)
				str.append(System.lineSeparator());
		}

		return str.toString();
	}

	public void print(PrintStream out) {
		out.print(this.toString());
	}

	public static class Value<T> {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Value EMPTY = new Value("EMPTY");

		public static <T> Value<T> of(T value) {
			return new Value<>(value);
		}

		public T raw;

		public Value(T value) {
			this.raw = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (null == obj)
				return false;
			
			if (EMPTY == obj && this != EMPTY)
				return false;

			if (!(obj instanceof Value))
				return false;

			@SuppressWarnings("rawtypes")
			Value oValue = (Value) obj;

			return oValue.raw.equals(this.raw);
		}

		@Override
		public String toString() {
			return raw.toString();
		}

	}

}
