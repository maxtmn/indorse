package com.max.tmn.math.matrix;

public class Dimension {

	private int length;
	private int width;

	public Dimension(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int length() {
		return length;
	}

	public int width() {
		return width;
	}

	public boolean isEmpty() {
		return this.length == 0 && this.width == 0;
	}

	@Override
	public String toString() {
		return String.format("%dx%d", length, width);
	}

}