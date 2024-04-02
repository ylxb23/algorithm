package org.zero.test.jdk17;

public sealed class Joke permits SubJoke {

    public int sum(int a, int b) {
        var sum = a + b;
        if(sum > 0) {
            return sum+1;
        }
        return sum;
    }

}
