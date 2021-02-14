/*
 * Copyright 2020 CNM Ingenuity, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.cnm.deepdive.geometry;

import java.util.Comparator;

/**
 * {@link Comparator} implementation for {@link Point} that supports sorting by X coordinate and
 * then (in the case of ties) Y coordinate.
 *
 * <p>
 * THIS IS THE BASIC PROBLEM!
 * </p>
 */
public class ComparatorXY implements Comparator<Point> {

  @Override
  public int compare(Point point1, Point point2) {
    // TODO Return negative, positive, or 0, based on the order relationship between point1 and
    // point2.
    if (point1.getX() - point2.getX() == 0) {
      return (int) (point1.getY() - point2.getY());
    } else {
      return (int) (point1.getX() - point2.getX());
    }
  }

}
