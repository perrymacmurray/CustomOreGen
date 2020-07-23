package com.protania.orechanger.util;

import net.minecraft.util.Tuple;

import java.util.*;

public class RandomCollection<T> {
    private class WeightTuple<T> extends Tuple<T, Integer> {
        public WeightTuple(T object, int weight) {
            super(object, weight);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof WeightTuple) {
                return this == o;
            } else {
                return this.get().equals(o);
            }
        }

        public int getWeight() {
            return this.getB();
        }

        public T get() {
            return this.getA();
        }
    }

    private final List<WeightTuple<T>> list = new ArrayList<>();
    private final Random rand;
    private int total = 0;

    public RandomCollection(Random random) {
        rand = random;
    }

    public boolean contains(T o) {
        return list.contains(o);
    }

    public Iterator<T> getIterator() {
        List<T> result = new ArrayList<T>();
        for (WeightTuple t : list) {
            result.add((T)t.get());
        }
        return result.iterator();
    }

    public boolean add(int weight, T o) {
        if (list.contains(o))
            return false;
        total += weight;
        return list.add(new WeightTuple<>(o, weight));
    }

    public boolean addAll(int weight, Collection<T> collection) {
        for (T o : collection) {
            add(weight, o);
        }
        return true;
    }

    public boolean remove(T o) {
        boolean result = false;
        for (WeightTuple listObject : list) {
            if (listObject.get().equals(o)) {
                result = list.remove(listObject);
                if (result)
                    total -= listObject.getWeight();
                break;
            }
        }
        return result;
    }

    private WeightTuple getRandomWeightTuple() {
        int ticket = rand.nextInt(total);
        int cumulativeWeight = 0;
        for (WeightTuple listObject : list) {
            cumulativeWeight += listObject.getWeight();
            if (cumulativeWeight >= ticket) {
                return listObject;
            }
        }

        return null; //This should never EVER happen
    }

    public T getRandom() {
        if (list.size() == 0)
            return null;

        return (T) getRandomWeightTuple().get();
    }

    public T getRandomAndRemove() {
        if (list.size() == 0)
            return null;

        WeightTuple selection = getRandomWeightTuple();
        if (list.remove(selection))
            total -= selection.getWeight();

        return (T) selection.get();
    }

    public int size() {
        return list.size();
    }

    public int weightedSize() {
        return total;
    }
}
