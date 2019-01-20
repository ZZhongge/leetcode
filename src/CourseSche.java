import java.util.*;
import java.lang.*;

public class CourseSche {
    enum STATE {WAIT, PROCESSING, FINISH};

    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] Graph = new ArrayList[numCourses];
        ArrayList<Integer> res = new ArrayList<>();
        STATE[] CourseState = new STATE[numCourses];
        for(int i = 0; i < numCourses; i++) {
            Graph[i] = new ArrayList<>();
            CourseState[i] = STATE.WAIT;
        }

        for (int[] tmp: prerequisites) {
            Graph[tmp[1]].add(tmp[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (CourseState[i] == STATE.WAIT) {
                if (!DFS(i, res, Graph, CourseState)) {
                    res.clear();
                    return res.stream().mapToInt(j->j).toArray();
                }
            }
        }

        return res.stream().mapToInt(j->j).toArray();
    }

    static boolean DFS(int cur, ArrayList<Integer> res, ArrayList<Integer>[] Nodes, STATE[] CourseState) {
        CourseState[cur] = STATE.PROCESSING;
        for (Integer node: Nodes[cur]) {
            if (CourseState[node] == STATE.PROCESSING) {
                return false;
            }
            if (CourseState[node] == STATE.WAIT && !DFS(node, res, Nodes, CourseState)) {
                return false;
            }
        }

        CourseState[cur] = STATE.FINISH;
        res.add(cur);
        return true;
    }

    public static void main(String[] args){

    }
}
