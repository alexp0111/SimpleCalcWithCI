package ru.alexp0111.SimpleCalcWithCI

import org.junit.Assert
import org.junit.Test
import ru.alexp0111.SimpleCalcWithCI.logic.MyCalc

class MyCalcTest {
    @Test
    fun `Test calculator sum logic`() {
        val calc = MyCalc()
        Assert.assertEquals(4.0, calc.findSum(1.0, 3.0), 0.0)
        Assert.assertEquals(0.0, calc.findSum(-2.0, 2.0), 0.0)
        Assert.assertEquals(0.0, calc.findSum(0.0, 0.0), 0.0)
    }
}