package masterClass.interviewPractices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.apache.commons.lang3.tuple.Pair;

public class TestClass {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//         int N = Integer.parseInt(br.readLine().trim());
//         int[][] ratings = new int[N][2];
//         for(int i_ratings = 0; i_ratings < N; i_ratings++)
//         {
//         	String[] arr_ratings = br.readLine().split(" ");
//         	for(int j_ratings = 0; j_ratings < arr_ratings.length; j_ratings++)
//         	{
//         		ratings[i_ratings][j_ratings] = Integer.parseInt(arr_ratings[j_ratings]);
//         	}
//         }

    	int N = 5;
    	int [][]ratings = {
    		{
    			123, 3
    		},
    		{
    			123, 4
    		},{
    			345,2
    		},
    		{
    			323, 3
    		},
    		{
    			112, 2
    		}
    		
    	};
    	
         int out_ = solution(N, ratings);
         System.out.println(out_);

//         wr.close();
//         br.close();
    }
    static int solution(int N, int[][] ratings){
       // Write your code here
        int result = 0;

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.putIfAbsent(ratings[i][0], new ArrayList<Integer>());
            map.get(ratings[i][0]).add(ratings[i][1]);
        }

        Integer res = (Integer)map.entrySet().stream().map(a-> {// Pair<Integer,Double> pair = new Pair<>();
        List<Integer>  values= a.getValue();
        int total = values.stream().reduce(0, Integer::sum);
//        pair.
        double average =(double) total / values.size();
        return List.of(a.getKey(),average);
        }).reduce((a,b)-> ((double)b.get(1))> (double)a.get(1) ? b: a).get().get(0);

        return res;
//        int id = 0;
//        int maxRating=0;
//        for(int i=0;i<N;i++){
//            if(maxRating<ratings[i][1]){
//                maxRating=ratings[i][1];
//                id=ratings[i][0];
//            }else if(maxRating==ratings[i][1]){
//                id = Math.min(id,ratings[i][0]);
//            }
//        }
//
//        return id;
    
    }
//    by gemini solution
    
//    static int optimizedSolution(int N, int[][] ratings) {
//        Map<Integer, RatingSummary> ratingMap = new HashMap<>();
//
//        for (int[] rating : ratings) {
//            int id = rating[0];
//            int value = rating[1];
//            ratingMap.computeIfAbsent(id, k -> new RatingSummary())
//                    .update(value);
//        }
//
//        int bestId = -1;
//        double maxAverage = -1.0;
//
//        for (Map.Entry<Integer, RatingSummary> entry : ratingMap.entrySet()) {
//            int id = entry.getKey();
//            RatingSummary summary = entry.getValue();
//            double average = summary.getAverage();
//
//            if (average > maxAverage) {
//                maxAverage = average;
//                bestId = id;
//            } else if (average == maxAverage && id < bestId) {
//                bestId = id;
//            }
//        }
//
//        return bestId;
//    }
}