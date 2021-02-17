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
 * {@link Comparator} implementation for {@link Point} that supports sorting by magnitude&mdash;that
 * is, by the Euclidean (straight-line) distance from the origin.
 *
 * <p>
 * THIS IS THE EXTRA CREDIT PROBLEM!
 * </p>
 */
public class ComparatorMagnitude implements Comparator<Point> {

  @Override
  public int compare(Point point1, Point point2) {

    double x1 = Math.abs(point1.getX());
    double y1 = Math.abs(point1.getY());
    double x2 = Math.abs(point2.getX());
    double y2 = Math.abs(point2.getY());

    double hyp1 = Math.hypot(x1, y1);
    double hyp2 = Math.hypot(x2, y2);

    if (hyp1 - hyp2 == 0) {
      return (int) (Math.atan2(y1, x1) - Math.atan2(y2, x2));
    } else {
      return (int) (hyp1 - hyp2);
    }
  }

}
