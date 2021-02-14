/*
 *  Copyright 2020 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.geometry;

import java.util.Objects;

/**
 * Implements a simple, immutable 2-dimensional point in space, where the X &amp; Y coordinates are
 * handled as {@code double}. None of the methods of this class modify the state of existing
 * instances, but instead create and return new instances.
 */
public final class Point {

  private static final String TO_STRING_FORMAT = "{x=%f, y=%f}";

  private final double x;
  private final double y;
  private final int hash;
  private final String representation;

  /**
   * Initializes this instance at the specified X &amp; Y coordinates.
   *
   * @param x Abscissa of this point.
   * @param y Ordinate of this point.
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
    hash = Objects.hash(x, y);
    representation = String.format(TO_STRING_FORMAT, x, y);
  }

  /**
   * Initializes this instance at the origin (X = 0, Y = 0).
   */
  public Point() {
    this(0, 0);
  }

  /**
   * Initializes this instance as a copy of <code>other</code>.
   *
   * @param other Source of copy.
   */
  @SuppressWarnings("CopyConstructorMissesField")
  public Point(Point other) {
    this(other.x, other.y);
  }

  /**
   * Computes and returns a new instance as the vector sum of this instance and <code>other</code>.
   *
   * @param other Instance to add to this point.
   * @return Vector sum.
   */
  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  /**
   * Computes and returns a new instance as the vector difference between this instance and
   * {@code other}.
   *
   * @param other Instance to subtract from this point.
   * @return Vector difference.
   */
  public Point subtract(Point other) {
    return new Point(x - other.x, y - other.y);
  }

  /**
   * Computes and returns a new instance as the product of this instance and a scalar value.
   *
   * @param scale Multiplier.
   * @return New scaled instance.
   */
  public Point multiply(double scale) {
    return new Point(x * scale, y * scale);
  }

  /**
   * Computes and returns a new instance as the product of this instance and the reciprocal of a
   * scalar value.
   *
   * @param scale Divisor.
   * @return New scaled instance.
   */
  public Point divide(double scale) {
    return new Point(x / scale, y / scale);
  }

  /**
   * Returns the abscissa (X coordinate value) of this instance.
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the ordinate (Y coordinate value) value of this instance.
   */
  public double getY() {
    return y;
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Point) {
      Point other = (Point) obj;
      comparison = x == other.x && y == other.y;
    } else {
      comparison = false;
    }
    return comparison;
  }

  @Override
  public String toString() {
    return representation;
  }

}
