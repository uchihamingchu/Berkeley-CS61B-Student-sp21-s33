package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        TimeAList tal = new TimeAList();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        tal.timeAListConstruction(Ns, times, opCounts);
        tal.printTimingTable(Ns,times,opCounts);

    }

    public static void timeAListConstruction(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        // TODO: YOUR CODE HERE
        int T = 8;
        AList<Integer> list = new AList<>();
        for (int i = 0; i < T; i++) {
            int size = ((int)Math.pow(2, i)) * 1000;
            Ns.addLast(size);
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < size; j ++) {
                list.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(size);
        }
    }
}

