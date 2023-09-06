package BruteForce;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//다음 순열을 구하기 위한 알고리즘.
//출처 : https://hongjw1938.tistory.com/78
public class Permutation {


    static int[] perm;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        perm = new int[]{7, 2, 3, 6, 5, 4, 1};

        while (getNextPerm(perm, perm.length - 1)){
            for(int num : perm){
                bw.write(String.valueOf(num) + " ");
            }
            bw.write("\n");
        }
        bw.flush();


    }

    //주어진 요소를 순열의 특징(최초순열:오름차순 ; 최종순열:내림차순)을 이용하여 다음 순열을 구해준다.
    private static boolean getNextPerm(int[] perm, int size){
        int i = size - 1; // 끝에서부터 비교하기 위해 마지막 요소 이전 위치에 인덱스를 놓는다.

        /*
        뒤에서부터 오름차순이 아닌 위치를 찾는다.
        뒤에서부터 오름차순이라는 것은 앞에서 내림차순이란 의미로 최종수열의 특징을 갖는다.
        i>0 : 모든 요소
        perm[i-1] >= perm[i] : 앞요소가 현재 요소보다 크거나 같다면 뒤에서부터 오름차순
            EX) i = 6; perm[6-1] >= perm[6] ; 4>=1 ; i--
        && 조건이기 떄문에 중간에 perm[i-1] >= perm[i] 의 조건이 맞지 않는다면 escape
         */
        while (i > 0 && perm[i-1] >= perm[i]) i--;

        //while 조건에 모두 충족하여 순열이 모두 역으로 오름차순이라면 즉, 앞으로 내림차순이라면 최종순열이며 다음 순열은 없다.
        if( i <= 0) return false;

        int j = i - 1; // 뒤에서부터 오름차순이 아닌 위치를 찾았다면 해당 인덱스 -1 위치부터 비교
        while(j < size - 1 && perm[j+1] > perm[i-1]) j++;
        //앞에서부터 뒤로 끝까지 비교하며 perm[j] 보다 큰 값을 찾는데
        // 그 중 값이 아닌 인덱스가 가장 높은 값을가져온다.
        // 이는 뒤에서부터 오름차순이라 검증된 값들 중 가장 작은 값을 가져오는 작업을한다.

        //위의 연산으로 다음 순열을 만들기 위해서 구한 요소들의 위치를 먼저 바꾼다..
        swap(i-1, j);

        // i번째부터 이후의 모든 숫자를 뒤집음
        // i~n-1 사이의 숫자를 상호 뒤집어야 하므로 j 값을 n-1로 초기화
        j = size-1;
        while(i < j){
            swap(i, j);
            i+=1; j-=1;
        }
        return true;
    }

    private static void swap(int i, int j){
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }

}
