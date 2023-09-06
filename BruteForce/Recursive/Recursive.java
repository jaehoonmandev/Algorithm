package BruteForce.Recursive;

public class Recursive {


    public static void main(String[] args) {
        int N = 6; // 시작값
        System.out.println("Factorial " + N + "==" + factorial(N));

        Integer.to
    }

    /*
    팩토리얼은 1부터 주어진 시작값 N 값까지 자연수를 모두 곱하는 것이며.
    식으로는 n!=1×2×3×⋯⋯×(n−1)×n 와 같이 표현할 수 있다.
    이를 위해서 주어진 N->1 까지 곱해주기위해 N-1, N-2 와 같이 1씩 작아지는 수를 곱해야한다.
     */
    private static int factorial(int N){
        //N이 1일때 까지만 연산한다.
        if( N == 1) return 1;
        return N * factorial(N - 1);
    }
}
