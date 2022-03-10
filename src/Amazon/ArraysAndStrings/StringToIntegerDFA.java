package Amazon.ArraysAndStrings;
/* Some other LeetCode problems which can be solved using DFA:

Valid Number's solution article also introduces DFA.
Regular Expression Matching
Detect Capital
Find and Replace Pattern
Binary Prefix Divisible By 5
Wildcard Matching
 */
public class StringToIntegerDFA {
    public int myAtoi(String s) {
        StateMachine Q = new StateMachine();

        for (int i = 0; i < s.length() && Q.getState() != State.qd; ++i) {
            Q.transition(s.charAt(i));
        }

        return Q.getInteger();
    }
}

enum State { q0, q1, q2, qd }

class StateMachine {
    // Store current state value.
    private State currentState;
    // Store result formed and it's sign.
    private int result, sign;

    public StateMachine() {
        currentState = State.q0;
        result = 0;
        sign = 1;
    }

    // Transition to state q1.
    private void toStateQ1(char ch) {
        sign = (ch == '-') ? -1 : 1;
        currentState = State.q1;
    }

    // Transition to state q2.
    private void toStateQ2(int digit) {
        currentState = State.q2;
        appendDigit(digit);
    }

    // Transition to dead state qd.
    private void toStateQd() {
        currentState = State.qd;
    }

    // Append digit to result, if out of range return clamped value.
    private void appendDigit(int digit) {
        if ((result > Integer.MAX_VALUE / 10) ||
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
            if (sign == 1) {
                // If sign is 1, clamp result to Integer.MAX_VALUE.
                result = Integer.MAX_VALUE;
            } else {
                // If sign is -1, clamp result to Integer.MIN_VALUE.
                result = Integer.MIN_VALUE;
                sign = 1;
            }

            // When the 32-bit int range is exceeded, a dead state is reached.
            toStateQd();
        } else {
            // Append current digit to the result.
            result = result * 10 + digit;
        }
    }

    // Change state based on current input character.
    public void transition(char ch) {
        if (currentState == State.q0) {
            // Beginning state of the string (or some whitespaces are skipped).
            if (ch == ' ') {
                // Current character is a whitespaces.
                // We stay in same state.
                return;
            } else if (ch == '-' || ch == '+') {
                // Current character is a sign.
                toStateQ1(ch);
            } else if (Character.isDigit(ch)) {
                // Current character is a digit.
                toStateQ2(ch - '0');
            } else {
                // Current character is not a space/sign/digit.
                // Reached a dead state.
                toStateQd();
            }
        } else if (currentState == State.q1 || currentState == State.q2) {
            // Previous character was a sign or digit.
            if (Character.isDigit(ch)) {
                // Current character is a digit.
                toStateQ2(ch - '0');
            } else {
                // Current character is not a digit.
                // Reached a dead state.
                toStateQd();
            }
        }
    }

    // Return the final result formed with it's sign.
    public int getInteger() {
        return sign * result;
    }

    // Get current state.
    public State getState() {
        return currentState;
    }
};

/**
 * Deterministic Finite Automation (DFA)
 *
 * The Deterministic Finite Automaton approach may feel familiar to you if you have previously studied TOC
 * (Theory Of Computation). If you're unfamiliar with DFA, we will provide a short introduction below,
 * but we encourage you to read more about DFA outside of this article as well.
 *
 * Theory of Computing is the study of theoretical machines and problems which can be solved using these machines.
 * These machines are called state machines. A state machine reads some input and changes the states based on those
 * inputs.
 *
 * Although we may not realize it, there are many examples of state machines that we experience every day. After
 * becoming more familiar with DFA, you may also start to notice new examples of DFA in your environment. One such
 * example that we are all familiar with is a traffic light. The most common type of traffic light has 3 lights:
 * red, green, and yellow. At any time, only one of the lights is on and the traffic light will cycle from red
 * (wait for some time), then to green (wait for some time), then to yellow (for a short time), and finally,
 * turn back to red. Each color can be referred to as a state and the change in color is called a transition.
 *
 * How does the state machine know to transition? Each transition will be the result of some input and depending on
 * the input we will either stay in the same state or transition to a different state. In this example, it will be
 * after some amount of time has passed we will transition to a new color and if less than that amount of time has
 * passed, we will remain at the same color.
 *
 * The state machines with a finite number of states are called finite state machines. Our traffic light state
 * machine is also finite with only three states.
 *
 * Browsing a website can also be treated as a finite state machine.
 * Think of each webpage as a state and transitions occurring due to certain clicks/events.
 *
 * So can a turnstile. For practice, you can try drawing a state diagram for a turnstile that is initially locked,
 * becomes unlocked when a coin is inserted and becomes locked again after being pushed.
 *
 * One possible application for finite state machines is to generate languages.
 * A language is a set of strings made up of characters from a specified set of symbols/alphabets.
 *
 * We can traverse through the states in a state machine diagram to see what kinds of strings the machine will produce,
 * or we can input a string and verify whether or not there exists a set of transitions that could be used to make the
 * string.
 *
 * For example, if we have symbols R, G, Y which represent red, green, and yellow respectively, then our traffic light
 * state machine can generate a string like, "GYRG", and will reject "GYRY" because, we cannot transition from a
 * red light to a yellow light.
 *
 * The finite state machine that either accepts or rejects a sequence of characters by running through a sequence of
 * states is called DFA.
 * There is only one path for specific input from the current state to the next state in DFA.
 * DFAs are useful to recognize patterns in data.
 */

/*
more on this topic https://leetcode.com/problems/string-to-integer-atoi/solution/
 */