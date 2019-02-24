/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-5d, -5d);
        assertThat(resultAdd, is(equalTo(-10d)));
    }

    @Test
    public void addOneNumberNegative() {
        double resultAdd = mCalculator.add(-5d, 5d);
        assertThat(resultAdd, is(equalTo(0d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(-5.5f, 7.8f);
        assertThat(resultAdd, is(closeTo(2.3, 0.01)));
    }

    @Test
    public void addOneNumberFloat() {
        double resultAdd = mCalculator.add(5.5f, 7.8d);
        assertThat(resultAdd, is(equalTo(13.3d)));
    }

    @Test
    public void subTwoNumbers() {
        double resultAdd = mCalculator.sub(7.8d, 5.5f);
        assertThat(resultAdd, is(equalTo(2.3d)));
    }

    @Test
    public void subWorksWithNegativeResults() {
        double resultAdd = mCalculator.sub(5.5f, 7.8d);
        assertThat(resultAdd, is(equalTo(-2.3d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultAdd = mCalculator.mul(2d, 7.5d);
        assertThat(resultAdd, is(equalTo(15d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double resultAdd = mCalculator.mul(5d, 0d);
        assertThat(resultAdd, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultAdd = mCalculator.div(25d, 5d);
        assertThat(resultAdd, is(equalTo(5d)));
    }

    @Test
    public void divTwoNumbersZero() {
        double resultAdd = mCalculator.div(5d, 0d);
        assertThat(resultAdd, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}