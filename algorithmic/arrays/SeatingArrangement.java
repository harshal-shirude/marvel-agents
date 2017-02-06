/**
 * Problem Statement : Given a classroom layout of total number of rows M and number of seats in each row K. There are total N students in that class.
 * Each student has his preferred row number. Students take a seat based on following criteria :
 *  1. Each student sits in his preferred row
 *  2. If he doesn't get seat in his preferred row, he sits in next vacant row
 *  3. Mth rows next row will be 1st row 
 * Given N,M,k and an array of size N where value at index i represents preferred row for that student, print total number of students who didn't get seats 
 * in their preferred row. Count should also include the number of students who didn't get seat at all.
 *
 * Input : 
 * 5 2 2
 * 1 1 2 1 1
 * Output :
 * 2
 * Explanation :
 * First 3 students will get their preferred rows. 4th student's preferred row is 1, which is already full. So he will sit in next vacant row which is 2.
 * Now, there are no more vacant rows, so 5th student will not get any seat. So the count is 2.
 *
 * Algorithm :
 * Basic idea is to have array 'seatsCount' of size M to store total number of seats availcable in each row.
 * We will multiply M and K so that we will get total number of seats available. Everytime we read preferred seat for student from input array,
 * we will check if the M*K > 0. 
 * If not, then next students won't get seat. 
 * If yes, for that student's preferred row, get the available seat from 'seatsCount' array. If value > 0, then decrement seat count 
 * and total available seat count by one. Otherwise check vacant seat in next rows. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeatingArrangement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] ips = line.split(" ");
        Integer N = Integer.parseInt(ips[0]);   //Number of students
        Integer M = Integer.parseInt(ips[1]);   //Number of rows
        Integer K = Integer.parseInt(ips[2]);   //Number of seats in each row
        line = br.readLine();
        ips = line.split(" ");
        Integer[] seatsCount = new Integer[M+1];
        for(int i = 1; i <= M; i++) {
            seatsCount[i] = K;
        }
        int prc = 0;
        int seatsAvailable = M*K;
        for(int i = 0; i < N; i++) {    //Traverse preferred seats array
            Integer pr = Integer.parseInt(ips[i]);
            if(seatsAvailable == 0) {   //If seat is not available, then increment the count and continue to next student
                prc++;
                continue;
            }
            if(seatsCount[pr] > 0) {    // If seat is available in preferred row, then decrement total available seat count
                seatsCount[pr]--;       // and available seat count in that row
                seatsAvailable--;
            } else if(seatsCount[pr] == 0) {    //If no seat available in opreferred row, traverse from next row untill you find available seat
                for(int j = pr + 1;;j++) {
                    if(j > M) { //If seat is not available in Mth row, start searching from 1st row.
                        j = 1;
                    }
                    if(seatsCount[j] > 0) {
                        seatsCount[j]--;
                        seatsAvailable--;
                        prc++;
                        break;
                    }
                }
            }
        }
        System.out.println(prc);
    }
}
