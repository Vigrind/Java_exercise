import java.util.HashMap;
import java.util.Map;

import java.util.*;

/**
   Soluzione in cui tutti gli oggetti hanno una soglia.
 */
class BasicWeightedSet2<T> implements WeightedSet<T> {
    private Map<T,Integer> map = new HashMap<>();

    @Override
    public void add(T obj, int weight) {
        map.put(obj, weight);
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
    
    @Override
    public WeightedSet<T> atLeast(int threshold) {
        // Classe anonima da interfaccia
        return new WeightedSet<T>() {
            @Override 
            public void add(T obj, int weight) {
                if (weight < threshold)
                    throw new IllegalArgumentException("Weight is too small.");
                add(obj, weight);
                // same as: BasicWeightedSet2.this.add(obj, weight);
            }
            @Override
            public String toString() {
                List<T> list = new ArrayList<>();
                // qui map è BasicWeightedSet2.this.map
                for (T key: map.keySet()) {
                    if (map.get(key) >= threshold)
                        list.add(key);
                }
                return list.toString();
            }
            @Override
            public WeightedSet<T> atLeast(int newThreshold) {
                return BasicWeightedSet2.this.atLeast(Integer.max(threshold, newThreshold));
            }
        };
    }

}

interface WeightedSet<T> {
	void add(T obj, int weight);
	WeightedSet<T> atLeast(int threshold);
}

