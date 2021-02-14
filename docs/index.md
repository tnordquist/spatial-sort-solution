{% if site.assignment_url -%}

## Assignment

* Link: <{{ site.assignment_url }}>
* Format: IntelliJ Java project

{%- endif %}

## Value

* Basic implementation: 10 points
* Basic unit tests: 5 points
* Extra credit implementation: 5 points
* Extra credit unit tests: 5 points

## Basic task

In this task, you will implement a `Comparator` that sorts 2-dimensional points---first by the X coordinate, then (in the event of a tie) by the Y coordinate.

### Implementation

The `edu.cnm.deepdive.geometry.Point` class implements a simple point in 2-dimensional space. Additionally, there is a `ComparatorXY` class that is intended to implement the `Comparator<Point>` interface---however, it doesn't do anything (yet). In order to complete the implementation, you must complete the method

```java
public int compare(Point point1, Point point2)
```

For more declaration details, see the [Javadoc documentation](api/edu/cnm/deepdive/geometry/Point.html), and for the [`ComparatorXY.compare` method](api/edu/cnm/deepdive/geometry/ComparatorXY.html#compare(edu.cnm.deepdive.geometry.Point,edu.cnm.deepdive.geometry.Point)).

**Important**: You are not permitted to modify the `Point` class at all.

### Unit tests

For unit testing credit, create a JUnit5 test class, and use `Arrays.sort` with an instance of `ComparatorXY`, using the appropriate assertions in one or more parameterized test methods, to test the following inputs vs. expected outputs. 

{% raw %}

| Before sorting | Expected after sorting |
|:--------------:|:-------------:|
| `{{x=0.0, y=0.0}, {x=1.0, y=1.0}, {x=-2.0, y=-2.0}}` | `{{x=-2.0, y=-2.0}, {x=0.0, y=0.0}, {x=1.0, y=1.0}}` |
| `{{x=0.0, y=0.0}, {x=0.0, y=1.0}, {x=0.0, y=-2.0}}` | `{{x=0.0, y=-2.0}, {x=0.0, y=0.0}, {x=0.0, y=1.0}}` |
| `{{x=0.0, y=0.0}, {x=-1.0, y=-1.0}, {x=0.0, y=0.0}}` | `{{x=-1.0, y=-1.0}, {x=0.0, y=0.0}, {x=0.0, y=0.0}}` |

{% endraw %}

**Important**: 

* You will need to create instances of `Point`, with the X & Y values shown above, and then create an array with those instances; you cannot simply take the inputs shown above and run `Arrays.sort` on them. An example of the creation of such an array is

    ```java
    new Point[]{new Point(0, 0), new Point(1, 1), new Point(-2, -2)};
    ```
    
    (Note that any modifiers that might be appropriate for the declaration have been omitted.)

* Don't forget that `Arrays.sort` sorts an array _in place_; it doesn't return a value. So, rather than testing a result returned from the `Arrays.sort` method, you must pass an input array to that method, and then---after `Arrays.sort` returns---test the sorted contents of the same array.

In evaluating your implementation, we reserve the right to include additional test cases; code that satisfies the requirements stated above should pass all such additional tests.

For full credit, implement your unit tests and JUnit5 parameterized tests.

### Hints

* You may find it useful to create one or more additional methods as “helpers”; the problem can be solved without doing so, however.

* You might consider delegating part of the comparison operation to one or more methods of the `Double` class.

* Don't hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* The method to be completed includes a `TODO` comment to that effect.

## Extra credit

### Implementation

Complete the implementation of the `compare` method in the `ComparatorMagnitude` class, to support sorting by Euclidean (straight-line) distance from the origin. That is, a point close to the origin should be sorted before a point further away. If 2 points are at the same distance from the origin, then the one with the smaller angle (as measured counter-clockwise from the positive X-axis) should be sorted before the one with the larger angle.

For more declaration details, see the [Javadoc documentation](api/edu/cnm/deepdive/geometry/ComparatorMagnitude.html#compare(edu.cnm.deepdive.geometry.Point,edu.cnm.deepdive.geometry.Point)).

### Unit tests 

For unit testing credit, create a new JUnit5 test class, and use `Arrays.sort` with an instance of `ComparatorMagnitude`, in the appropriate parameterized test method(s), to test the following inputs vs. expected outputs: 

{% raw %}

| Before sorting | Expected after sorting |
|:--------------:|:-------------:|
| `{{x=-2.0, y=-2.0}, {x=0.0, y=0.0}, {x=1.0, y=1.0}}` | `{{x=0.0, y=0.0}, {x=1.0, y=1.0}, {x=-2.0, y=-2.0}}` |
| `{{x=0.0, y=-2.0}, {x=0.0, y=0.0}, {x=0.0, y=1.0}}` | `{{x=0.0, y=0.0}, {x=0.0, y=1.0}, {x=0.0, y=-2.0}}` |
| `{{x=-1.0, y=-1.0}, {x=0.0, y=0.0}, {x=0.0, y=0.0}}` | `{{x=0.0, y=0.0}, {x=0.0, y=0.0}, {x=-1.0, y=-1.0}}` |

{% endraw %}

**Important**: 

* You will need to create instances of `Point`, with the X & Y values shown above, and then create an array with those instances; you cannot simply take the inputs shown above and run `Arrays.sort` on them.

* Don't forget that `Arrays.sort` sorts an array _in place_; it doesn't return a value.

* `ComparatorMagnitude` already imports the `edu.cnm.deepdive.geometry.Point` class; there is no need to import & use any other `Point` class from the Java standard library (in fact, doing so would be a step in the wrong direction).

In evaluating your implementation, we reserve the right to include additional test cases; code that satisfies the requirements stated above should pass all such additional tests.

### Hints

* You may find it useful to create one or more additional methods as “helpers”; the problem can be solved without doing so, however.

* You might consider delegating part of the comparison operation to one or more methods of the `Math` class.

* Don't hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* The method to be completed includes a `TODO` comment to that effect.
