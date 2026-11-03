
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<Missile> inQ = new PriorityQueue<>(new Comparator<Missile>(){
            public int compare(Missile o1, Missile o2) {
                return o1.in - o2.in;
            }
        });
        PriorityQueue<Missile> outQ = new PriorityQueue<>(new Comparator<Missile>(){
            public int compare(Missile o1, Missile o2) {
                return o1.out - o2.out;
            }
        });

        int id = 0;
        for(int[] target : targets) {
            target[0] = target[0] * 10 + 1;
            target[1] = target[1] * 10 - 1;

            inQ.add(new Missile(id, target[0], target[1]));
            outQ.add(new Missile(id, target[0], target[1]));
            id++;
        }

        return interceptMissile(inQ, outQ);
    }

    public int interceptMissile(PriorityQueue<Missile> inQ, PriorityQueue<Missile> outQ) {
        HashMap<Integer, Integer> missileIdCheckMap = new HashMap<>();
        int count = 0;

        while(inQ.size() > 0 || outQ.size() > 0) {
            if(outQ.size() > 0) {
                Missile end = null;
                while(outQ.size() > 0) {
                    if(missileIdCheckMap.containsKey(outQ.peek().id)) {
                        outQ.poll();     
                    } else {
                        end = outQ.poll();
                        missileIdCheckMap.put(end.id, 0);
                        break;
                    }
                }

                if(end == null) {
                    break;
                }

                while(inQ.size() > 0) {
                    if(missileIdCheckMap.containsKey(inQ.peek().id)) {
                        inQ.poll();
                    } else if(inQ.peek().in <= end.out && inQ.peek().out >= end.out) {
                        Missile get = inQ.poll();
                        missileIdCheckMap.put(get.id, 0);
                    } else {
                        break;
                    }
                }
                count++;
            }
        }
        return count;
    }

    class Missile {
        int id;
        int in;
        int out;

        public Missile(int id, int in, int out) {
            this.id = id;
            this.in = in;
            this.out = out;
        }
    }
}
